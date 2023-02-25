# 本次项目是大三下综合实训的最终项目-ChatGram

主要是实现聊天功能，有私聊和群聊功能。

## 技术栈

前端通过 `React`、`Typescript`、`Socket.io`进行开发。

后端通过 `SpringBoot`、`JWT`、`netty-socketio`进行开发。

数据库使用的 `MySQL`。

然后是通过 `apifox`进行接口的测试。

## 运行

### 1、下载

找到一个文件夹使用如下命令进行下载：

```
git clone https://github.com/Poison02/chat-app.git
```

因为此项目是直接将前端代码打包过来了的，所以说不存在安装前端环境等。

下载之后，需要等待项目初始化，安装依赖。

### 2、数据库创建

打开自己的`MySQL`创建一个库 `chat-app`。将 `chat_app.sql`文件运行即可。

### 3、运行

先找到 `application.properties`修改自己的 MySQL账号密码。

然后直接找到 `ChatAppApiApplication`右键运行即可。

浏览器输入：

```
http://localhost:8080/
```

即可进行访问。

账号在数据库中都有的，密码都是123.