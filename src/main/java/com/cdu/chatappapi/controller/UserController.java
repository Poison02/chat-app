package com.cdu.chatappapi.controller;

import com.auth0.jwt.JWT;
import com.cdu.chatappapi.controller.ex.*;
import com.cdu.chatappapi.entity.User;
import com.cdu.chatappapi.service.TokenService;
import com.cdu.chatappapi.service.UserService;
import com.cdu.chatappapi.utils.JsonResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;


@RestController
public class UserController {
    @Autowired
    TokenService tokenService;
    @Autowired
    UserService userService;

    @PostMapping("/api/login")
    public JsonResponseUtil<String> login(@RequestBody User user) {
        // 获取用户信息
        User result = userService.login(user.getUsername(), user.getPassword());
        // 根据用户信息生成token
        String token = tokenService.getToken(result);
        // 将token返回给前端
        return new JsonResponseUtil<>(200, "success", token);
    }

    @PostMapping("/api/register")
    public JsonResponseUtil<String> register(@RequestBody User user){
        if (null == user){
            System.out.println("请输入内容！");
        }
        Integer rows = userService.register(user);

        if (1 != rows){
            return new JsonResponseUtil<>(404, "registerFail");
        }
        return new JsonResponseUtil<>(200, "registerSuccess");
    }

    private static final long AVATAR_MAX_SIZE = 101 * 1024;
    private static final ArrayList<String> AVATAR_TYPE = new ArrayList<>();
    // 静态块
    static {
        AVATAR_TYPE.add("image/jpg");
        AVATAR_TYPE.add("image/png");
        AVATAR_TYPE.add("image/gif");
        AVATAR_TYPE.add("image/bmp");
        AVATAR_TYPE.add("image/jpeg");
    }

    @PostMapping("/api/updateAvatar")
    public JsonResponseUtil<String> updateAvatar(MultipartFile file, HttpServletRequest request, HttpSession session){

        // 判断上传文件是否为空
        boolean isEmpty = file.isEmpty(); // 默认是true
        if (isEmpty){
            throw new FileEmptyException("请选择您要上传的文件！");
        }

        // 获取文件的大小
        long fileSize = file.getSize();
        System.err.println("文件大小为：" + fileSize);
        // 判定文件是否超过规定的大小
        if (fileSize > AVATAR_MAX_SIZE){
            // 提醒用户
            throw new FileSizeException("上传失败，不允许上传超过" + AVATAR_MAX_SIZE / 1024 + "KB的文件！");
        }

        // 获取文件扩展名 （后缀）
        String contentType = file.getContentType();
        System.err.println("文件后缀为：" + contentType);

        // 判断是否符合规则 判断获取的文件扩展名是否属于规定的范围
        if (!AVATAR_TYPE.contains(contentType)){
            // 抛出文件类型不符合异常
            throw new FileTypeException("上传失败！仅允许上传以下类型的文件: " + AVATAR_TYPE);
        }

        // 获取文件名(上传的文件名)
        String fileName = file.getOriginalFilename();
        System.err.println("原始文件名：" + fileName);

        // 指定存储的路径 通过servlet容器获取目标路径
        String path = session.getServletContext().getRealPath("upload");
        File dir = new File(path);
        // 判定该目录是否存在 不存在就创建一个
        if (! dir.exists()){
            dir.mkdir();
        }
        // 改名操作，需要考虑不能重复， 保留原来的名字 获取系统毫秒 1970.1.1到现在
        String newFileName = "" + System.currentTimeMillis() + UUID.randomUUID();
        // 保留原有名字
        String suffix = "";
        // 先获取 . 出现的地方，再用 subString截取文件名
        int index = fileName.lastIndexOf(".");
        if (index > 1){
            suffix = fileName.substring(index);
        }

        // 最终名字
        String endName = newFileName + suffix;
        // 保存至服务器
        File save = new File(path, endName);
        try {
            // 写入文件的操作
            file.transferTo(save);
        }catch (IOException e){
            // 抛出读写异常
            throw new FileIOException("上传失败！出现文件读写错误！请重新上传！");
        }catch (IllegalStateException e){
            // 抛出文件状态异常
            throw new FileStateException("上传失败！你的文件上传异常！请重新选择文件！");
        }

        // 将保存文件的路径记录到数据库中
        String avatar = "/upload/" + endName;
        // 查看文件路径
        System.err.println("文件路径为：" + avatar);

        // 获取当前用户名
        String token = request.getHeader("token");
        if (token == null) {
            System.err.println("没得token怎么办？");
        }
        String username = JWT.decode(token).getAudience().get(0);
        userService.updateAvatar(username, avatar);

        return new JsonResponseUtil<>(200, avatar);
    }
}
