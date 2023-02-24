package com.cdu.chatappapi.controller;

import com.auth0.jwt.JWT;
import com.cdu.chatappapi.controller.ex.*;
import com.cdu.chatappapi.entity.Group;
import com.cdu.chatappapi.entity.GroupMessage;
import com.cdu.chatappapi.entity.SingleMessage;
import com.cdu.chatappapi.entity.User;
import com.cdu.chatappapi.service.ChatService;
import com.cdu.chatappapi.service.MessageService;
import com.cdu.chatappapi.service.TokenService;
import com.cdu.chatappapi.service.UserService;
import com.cdu.chatappapi.utils.JsonResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;


@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    TokenService tokenService;
    @Autowired
    UserService userService;
    @Autowired
    MessageService messageService;

    @Autowired
    ChatService chatService;

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

    // 返回登录用户的好友列表和他发给别人的消息列表
    @GetMapping("/api/chat")
    public JsonResponseUtil<Map<String, Object>> findSingleChatInfo(HttpServletRequest request){

        List<Object> friendsList = new ArrayList<>();
        // 装 friendsList 和 messagesList
        Map<String, Object> map = new HashMap<>();

        String token = request.getHeader("token");

        if (token == null) {
            System.err.println("没得token怎么办 api/chat ？");
        }
        String username = JWT.decode(token).getAudience().get(0);

        String result = userService.findFriend(username);
        List<String> userList = members(result);

        for (String str: userList) {
            friendsList.add(userService.getFewInfo(str));
        }

        // messagesList 存放所有消息
        List<SingleMessage> messagesList = messageService.findAllSingleMsg(username);

        map.put("friendsList", friendsList);
        map.put("messagesList", messagesList);

        if (friendsList == null){
            return new JsonResponseUtil<>(400, "你没有任何的好友！");
        }

        if (null == userList){
            return new JsonResponseUtil<>(400, "你没有任何的好友！");
        }

        return new JsonResponseUtil<>(200, "success", map);
    }

    @GetMapping("/api/group")
    public JsonResponseUtil<List<Group>> findGroupChatInfo(HttpServletRequest request){

        String token = request.getHeader("token");

        if (token == null) {
            System.err.println("没得token怎么办 api/group ？");
        }
        String username = JWT.decode(token).getAudience().get(0);

        // 设计一个群组对象, 得到该用户的群组信息！
        User user = userService.getUserByUsername(username);
        List<Group> groupList = userService.returnGroup(user.getGroupId());
        String result = userService.returnMembers(user.getGroupId());

        groupList.get(0).setGroupId(user.getGroupId());
        groupList.get(0).setMembers(members(result));

        if (null == groupList){
            System.out.println("controller group为空！");
            return new JsonResponseUtil<>(400, "没有群组！");
        }

        return new JsonResponseUtil<>(200, "success", groupList);

    }

    // 将字符串列表转为列表
    public List<String> members(String member){
        String demosub = member.substring(1,member.length()-1).replaceAll(" ", "");
        String[] demoArray = demosub.split(",");
        List<String> result = Arrays.asList(demoArray);
        return result;
    }

    @PostMapping("/api/group/message")
    public JsonResponseUtil<List<GroupMessage>> findGroupMessage(@RequestBody Group group){
        // 根据群组ID获取群聊消息记录
        if (null == group){
            return new JsonResponseUtil<>(400, "groupId未获得");
        }
        List<GroupMessage> messageList = chatService.returnGroupMsg(group.getGroupId());

        if (null == messageList){
            System.out.println("group/message 消息列表为空！");
        }

        return new JsonResponseUtil<>(200, "success", messageList);
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
    public JsonResponseUtil<String> updateAvatar(MultipartFile file,
                                                 HttpServletRequest request, HttpSession session){

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

    @PostMapping("/api/add")
    public JsonResponseUtil<List<String>> add(HttpServletRequest request){

        String token = request.getHeader("token");

        if (token == null) {
            System.err.println("没得token怎么办？");
        }
        String username = JWT.decode(token).getAudience().get(0);

        List<String> list = new ArrayList<>();
        list.add("admin1");
        list.add("admin2");
        System.err.println(list);

        if (null == list){
            return new JsonResponseUtil<>(400, "找不到好友！");
        }

        Integer rows = userService.addFriend(list, username);
        if (1 != rows){
            return new JsonResponseUtil<>(400, "不能添加好友！");
        }

        return new JsonResponseUtil<>(200, "success", list);
    }
}