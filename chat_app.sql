/*
Navicat MySQL Data Transfer

Source Server         : shixuntest
Source Server Version : 80028
Source Host           : localhost:3306
Source Database       : chat_app

Target Server Type    : MYSQL
Target Server Version : 80028
File Encoding         : 65001

Date: 2023-02-25 09:01:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for groupmessage
-- ----------------------------
DROP TABLE IF EXISTS `groupmessage`;
CREATE TABLE `groupmessage` (
  `gId` int NOT NULL AUTO_INCREMENT,
  `groupId` int DEFAULT NULL COMMENT '群聊ID',
  `content` varchar(255) DEFAULT NULL,
  `msgUsername` varchar(64) DEFAULT NULL,
  `sendTime` datetime DEFAULT NULL,
  PRIMARY KEY (`gId`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of groupmessage
-- ----------------------------
INSERT INTO `groupmessage` VALUES ('1', '1', '这是测试群聊的第一条消息', 'admin1', '2023-02-24 13:24:06');
INSERT INTO `groupmessage` VALUES ('2', '1', '测试群聊2', 'admin2', '2023-02-24 13:24:27');
INSERT INTO `groupmessage` VALUES ('3', '1', '测试群聊3', 'admin3', '2023-02-24 13:24:45');
INSERT INTO `groupmessage` VALUES ('4', '1', '你干嘛哈哈哎哟', 'cxk', '2023-02-24 13:25:00');
INSERT INTO `groupmessage` VALUES ('5', '1', '111', 'cxk', '2023-02-24 18:20:35');
INSERT INTO `groupmessage` VALUES ('6', '1', '111', 'admin1', '2023-02-24 18:28:32');
INSERT INTO `groupmessage` VALUES ('7', '1', '222', 'cxk', '2023-02-24 18:28:53');
INSERT INTO `groupmessage` VALUES ('8', '1', '11111111', 'admin1', '2023-02-24 18:29:34');
INSERT INTO `groupmessage` VALUES ('9', '1', '333', 'cxk', '2023-02-24 18:29:39');
INSERT INTO `groupmessage` VALUES ('10', '1', '11111111', 'admin1', '2023-02-24 18:29:37');
INSERT INTO `groupmessage` VALUES ('11', '1', '111', 'admin1', '2023-02-24 18:29:45');
INSERT INTO `groupmessage` VALUES ('12', '1', '1', 'admin1', '2023-02-24 18:31:01');
INSERT INTO `groupmessage` VALUES ('13', '1', '1', 'admin1', '2023-02-24 18:31:41');
INSERT INTO `groupmessage` VALUES ('14', '1', '11', 'admin1', '2023-02-24 18:31:43');
INSERT INTO `groupmessage` VALUES ('15', '1', '11', 'admin1', '2023-02-24 18:31:47');
INSERT INTO `groupmessage` VALUES ('16', '1', '333', 'cxk', '2023-02-24 18:32:15');
INSERT INTO `groupmessage` VALUES ('17', '1', '11', 'admin1', '2023-02-24 18:33:26');
INSERT INTO `groupmessage` VALUES ('18', '1', '1', 'admin1', '2023-02-24 18:34:28');
INSERT INTO `groupmessage` VALUES ('19', '1', '11111111111111111111111111111', 'admin1', '2023-02-24 18:35:29');
INSERT INTO `groupmessage` VALUES ('20', '1', '111', 'admin2', '2023-02-24 18:35:48');
INSERT INTO `groupmessage` VALUES ('21', '1', '111111', 'admin1', '2023-02-24 18:35:58');
INSERT INTO `groupmessage` VALUES ('22', '1', '111111', 'admin1', '2023-02-24 18:36:27');
INSERT INTO `groupmessage` VALUES ('23', '1', 'asjdkla', 'admin2', '2023-02-24 18:36:35');
INSERT INTO `groupmessage` VALUES ('24', '1', '1', 'admin1', '2023-02-24 18:37:47');
INSERT INTO `groupmessage` VALUES ('25', '1', '你好', 'admin2', '2023-02-24 18:37:59');
INSERT INTO `groupmessage` VALUES ('26', '1', '1', 'admin1', '2023-02-24 18:38:10');
INSERT INTO `groupmessage` VALUES ('27', '1', '1', 'admin1', '2023-02-24 18:38:24');
INSERT INTO `groupmessage` VALUES ('28', '1', '1', 'admin1', '2023-02-24 18:38:30');
INSERT INTO `groupmessage` VALUES ('29', '1', '1', 'admin1', '2023-02-24 18:39:28');
INSERT INTO `groupmessage` VALUES ('30', '1', '1', 'admin1', '2023-02-24 18:39:29');
INSERT INTO `groupmessage` VALUES ('31', '1', '', 'admin1', '2023-02-24 18:39:34');
INSERT INTO `groupmessage` VALUES ('32', '1', '1', 'admin1', '2023-02-24 18:39:44');
INSERT INTO `groupmessage` VALUES ('33', '1', '1', 'admin1', '2023-02-24 18:41:10');
INSERT INTO `groupmessage` VALUES ('34', '1', '1', 'admin1', '2023-02-24 18:41:12');
INSERT INTO `groupmessage` VALUES ('35', '1', '2', 'admin1', '2023-02-24 18:41:40');
INSERT INTO `groupmessage` VALUES ('36', '1', '11', 'admin1', '2023-02-24 18:42:15');
INSERT INTO `groupmessage` VALUES ('37', '1', '111111', 'admin1', '2023-02-24 18:42:20');
INSERT INTO `groupmessage` VALUES ('38', '1', '1', 'admin1', '2023-02-24 18:43:05');
INSERT INTO `groupmessage` VALUES ('39', '1', '1', 'admin1', '2023-02-24 18:44:50');
INSERT INTO `groupmessage` VALUES ('40', '1', '1', 'admin1', '2023-02-24 18:49:04');
INSERT INTO `groupmessage` VALUES ('41', '1', '12', 'admin1', '2023-02-24 18:49:05');
INSERT INTO `groupmessage` VALUES ('42', '1', '你好', 'cxk', '2023-02-24 18:58:33');
INSERT INTO `groupmessage` VALUES ('43', '1', '123', 'cxk', '2023-02-24 19:13:28');
INSERT INTO `groupmessage` VALUES ('44', '1', '555', 'admin2', '2023-02-24 19:13:47');
INSERT INTO `groupmessage` VALUES ('45', '1', 'nihao admin1', 'cxk', '2023-02-24 20:52:09');
INSERT INTO `groupmessage` VALUES ('46', '1', '你也好啊 c\'x\'k', 'admin1', '2023-02-24 20:52:14');
INSERT INTO `groupmessage` VALUES ('47', '1', 'nihao ', 'cxk', '2023-02-24 20:52:39');
INSERT INTO `groupmessage` VALUES ('48', '1', '哈哈哈', 'admin1', '2023-02-24 20:52:44');
INSERT INTO `groupmessage` VALUES ('49', '1', 'nihao', 'cxk', '2023-02-24 20:52:51');
INSERT INTO `groupmessage` VALUES ('50', '1', 'aaa', 'cxk', '2023-02-24 20:54:23');
INSERT INTO `groupmessage` VALUES ('51', '1', '从存储', 'admin1', '2023-02-24 20:54:27');
INSERT INTO `groupmessage` VALUES ('52', '1', '11111', 'admin1', '2023-02-24 21:02:52');
INSERT INTO `groupmessage` VALUES ('53', '1', '1', 'cxk', '2023-02-24 22:09:27');
INSERT INTO `groupmessage` VALUES ('54', '1', '太难受啦', 'cxk', '2023-02-24 22:15:05');
INSERT INTO `groupmessage` VALUES ('55', '1', '111', 'admin1', '2023-02-24 22:18:11');
INSERT INTO `groupmessage` VALUES ('56', '1', '222', 'cxk', '2023-02-24 22:18:19');
INSERT INTO `groupmessage` VALUES ('57', '1', '3', 'cxk', '2023-02-24 22:26:32');
INSERT INTO `groupmessage` VALUES ('58', '1', '111111', 'admin1', '2023-02-24 22:48:17');
INSERT INTO `groupmessage` VALUES ('59', '1', '3123', 'cxk', '2023-02-24 22:48:23');
INSERT INTO `groupmessage` VALUES ('60', '1', '1', 'admin1', '2023-02-24 23:05:17');
INSERT INTO `groupmessage` VALUES ('61', '1', '1', 'admin1', '2023-02-24 23:05:25');
INSERT INTO `groupmessage` VALUES ('62', '1', '2', 'cxk', '2023-02-24 23:05:29');
INSERT INTO `groupmessage` VALUES ('63', '1', '3', 'admin1', '2023-02-24 23:12:41');
INSERT INTO `groupmessage` VALUES ('64', '1', '666', 'cxk', '2023-02-24 23:12:44');
INSERT INTO `groupmessage` VALUES ('65', '1', '你好', 'admin1', '2023-02-25 08:38:46');
INSERT INTO `groupmessage` VALUES ('66', '1', '你也好', 'cxk', '2023-02-25 08:38:50');
INSERT INTO `groupmessage` VALUES ('67', '1', '哈哈哈', 'cxk', '2023-02-25 08:39:05');
INSERT INTO `groupmessage` VALUES ('68', '1', '哈哈哈', 'admin1', '2023-02-25 08:39:09');
INSERT INTO `groupmessage` VALUES ('69', '1', 'j\'j\'j', 'admin1', '2023-02-25 08:40:05');
INSERT INTO `groupmessage` VALUES ('70', '1', 'aaa', 'cxk', '2023-02-25 08:40:13');
INSERT INTO `groupmessage` VALUES ('71', '1', 'bbb', 'admin1', '2023-02-25 08:40:19');
INSERT INTO `groupmessage` VALUES ('72', '1', '123', 'admin1', '2023-02-25 08:41:02');
INSERT INTO `groupmessage` VALUES ('73', '1', '321', 'cxk', '2023-02-25 08:41:07');
INSERT INTO `groupmessage` VALUES ('74', '1', '666', 'cxk', '2023-02-25 08:59:11');
INSERT INTO `groupmessage` VALUES ('75', '1', '777', 'admin1', '2023-02-25 08:59:14');
INSERT INTO `groupmessage` VALUES ('76', '1', '888', 'cxk', '2023-02-25 08:59:20');
INSERT INTO `groupmessage` VALUES ('77', '1', '999', 'admin1', '2023-02-25 08:59:22');
INSERT INTO `groupmessage` VALUES ('78', '1', '123', 'cxk', '2023-02-25 08:59:25');
INSERT INTO `groupmessage` VALUES ('79', '1', '321', 'admin1', '2023-02-25 08:59:28');

-- ----------------------------
-- Table structure for group_info
-- ----------------------------
DROP TABLE IF EXISTS `group_info`;
CREATE TABLE `group_info` (
  `group_id` int NOT NULL AUTO_INCREMENT,
  `groupName` varchar(16) DEFAULT NULL,
  `groupAvatar` varchar(255) DEFAULT NULL,
  `members` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of group_info
-- ----------------------------
INSERT INTO `group_info` VALUES ('1', 'ikunTeam', 'https://img-1315662121.cos.ap-guangzhou.myqcloud.com/image/group.jpg', '[admin1, cxk, admin2, admin3, admin4, admin5, admin6, admin]');

-- ----------------------------
-- Table structure for singlemessage
-- ----------------------------
DROP TABLE IF EXISTS `singlemessage`;
CREATE TABLE `singlemessage` (
  `mId` int NOT NULL AUTO_INCREMENT,
  `fromUser` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `toUser` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `sendTime` datetime DEFAULT NULL,
  PRIMARY KEY (`mId`)
) ENGINE=InnoDB AUTO_INCREMENT=188 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of singlemessage
-- ----------------------------
INSERT INTO `singlemessage` VALUES ('1', 'admin', 'cxk', '哇真的是你呀', '2023-02-23 10:26:32');
INSERT INTO `singlemessage` VALUES ('2', 'admin1', 'cxk', '你干嘛哈哈', '2023-02-23 10:30:33');
INSERT INTO `singlemessage` VALUES ('3', 'cxk', 'admin1', '真的是你呀', '2023-02-24 10:14:04');
INSERT INTO `singlemessage` VALUES ('6', 'cxk', 'admin1', '111', '2023-02-24 11:18:47');
INSERT INTO `singlemessage` VALUES ('7', 'admin1', 'cxk', ',,', '2023-02-24 11:18:47');
INSERT INTO `singlemessage` VALUES ('8', 'admin1', 'cxk', ',,', '2023-02-24 11:19:06');
INSERT INTO `singlemessage` VALUES ('9', 'admin1', 'cxk', ',,', '2023-02-24 11:19:06');
INSERT INTO `singlemessage` VALUES ('10', 'cxk', 'admin2', '111', '2023-02-24 11:19:10');
INSERT INTO `singlemessage` VALUES ('47', 'admin1', 'admin6', '111', '2023-02-24 18:30:27');
INSERT INTO `singlemessage` VALUES ('48', 'admin2', 'cxk', 'cxk', '2023-02-24 18:37:00');
INSERT INTO `singlemessage` VALUES ('49', 'admin1', 'cxk', '111111111', '2023-02-24 18:37:04');
INSERT INTO `singlemessage` VALUES ('50', 'admin1', 'cxk', '1111111111', '2023-02-24 18:37:31');
INSERT INTO `singlemessage` VALUES ('51', 'admin2', 'admin6', 'cxk', '2023-02-24 18:37:42');
INSERT INTO `singlemessage` VALUES ('52', 'admin1', 'admin2', '1', '2023-02-24 18:41:36');
INSERT INTO `singlemessage` VALUES ('53', 'admin1', 'admin2', '22', '2023-02-24 18:41:44');
INSERT INTO `singlemessage` VALUES ('180', 'admin1', 'cxk', '1', '2023-02-24 23:12:47');
INSERT INTO `singlemessage` VALUES ('181', 'cxk', 'admin1', '2', '2023-02-24 23:12:51');
INSERT INTO `singlemessage` VALUES ('182', 'admin1', 'cxk', 'nihao', '2023-02-25 08:40:28');
INSERT INTO `singlemessage` VALUES ('183', 'cxk', 'admin1', 'iyehao', '2023-02-25 08:40:32');
INSERT INTO `singlemessage` VALUES ('184', 'admin1', 'cxk', 'nihao', '2023-02-25 08:40:47');
INSERT INTO `singlemessage` VALUES ('185', 'cxk', 'admin1', 'haha', '2023-02-25 08:40:50');
INSERT INTO `singlemessage` VALUES ('186', 'cxk', 'admin1', '123', '2023-02-25 08:59:56');
INSERT INTO `singlemessage` VALUES ('187', 'admin1', 'cxk', '321', '2023-02-25 09:00:01');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int NOT NULL AUTO_INCREMENT,
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `salt` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '盐值',
  `gender` int DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像',
  `email` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(64) DEFAULT NULL,
  `createdTime` datetime DEFAULT NULL,
  `friendList` varchar(255) DEFAULT NULL,
  `groupId` int DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('3', 'admin1', '64a59b73fbd7b9911ae9761658ed39ba', '2cceb5a2-2f10-4fa4-ba02-7c2f6141c4eb', '1', 'https://img-1315662121.cos.ap-guangzhou.myqcloud.com/image/default-4.png', '123@qq.com', '123456789', '2023-02-22 14:19:09', '[admin2, cxk, admin, admin3, admin4, admin5, admin6]', '1');
INSERT INTO `user` VALUES ('4', 'admin2', 'bcd039e78838f7ed347dbbaa6769efbe', '4e171c4b-1825-4b38-8240-b3dd8df19559', '0', 'https://img-1315662121.cos.ap-guangzhou.myqcloud.com/image/default-2.png', '123@qq.com', '123456789', '2023-02-22 19:50:51', '[admin1, cxk, admin, admin3, admin4, admin5, admin6]', '1');
INSERT INTO `user` VALUES ('5', 'admin', 'b0d1d163ac9dd908bd26a57ee7aa3549', '9ae21d20-1424-4601-aac5-4c4c748032e1', '0', 'https://img-1315662121.cos.ap-guangzhou.myqcloud.com/image/default-3.png', '123@qq.com', '123456789', '2023-02-23 16:03:27', '[admin1, admin2, cxk,, admin3, admin4, admin5, admin6]', '1');
INSERT INTO `user` VALUES ('7', 'admin3', '38c515be43a73f9b3f47c2af848b5b5e', '0d47dc75-4984-4a1c-9ea4-be550e2d1b7b', '0', 'https://img-1315662121.cos.ap-guangzhou.myqcloud.com/image/default-6.png', '123@qq.com', '123456789', '2023-02-24 08:59:39', '[admin2, cxk, admin, admin1, admin4, admin5, admin6]', '1');
INSERT INTO `user` VALUES ('8', 'admin4', '0f4520bd44207147bdffa36a9d2b2980', '28eea5ad-66eb-496d-9cc6-73aef6584d1a', '1', 'https://img-1315662121.cos.ap-guangzhou.myqcloud.com/image/default-7.png', '123@qq.com', '123456789', '2023-02-24 09:00:31', '[admin2, cxk, admin, admin3, admin1, admin5, admin6]', '1');
INSERT INTO `user` VALUES ('9', 'admin5', 'b088ee84322e7748a780fd1a9f7ecd35', 'c8d57e49-0961-44ce-82c3-48f4618838f1', '1', 'https://img-1315662121.cos.ap-guangzhou.myqcloud.com/image/default-8.png', '123@qq.com', '123456789', '2023-02-24 09:00:54', '[admin2, cxk, admin, admin3, admin4, admin1, admin6]', '1');
INSERT INTO `user` VALUES ('10', 'admin6', '9edbe7de8845c7c4df85d0c144a72328', 'd8e52df3-423f-4086-801e-1030d67df4db', '1', 'https://img-1315662121.cos.ap-guangzhou.myqcloud.com/image/default.png', '123@qq.com', '123456789', '2023-02-24 09:01:24', '[admin2, cxk, admin, admin3, admin4, admin5, admin1]', '1');
INSERT INTO `user` VALUES ('11', 'cxk', '67eb8f353b1679602d3f99d9b1e187d3', '35bbc10a-6e60-4957-9c38-4797bb145905', '1', 'https://img-1315662121.cos.ap-guangzhou.myqcloud.com/image/default-5.png', '123@qq.com', '123456789', '2023-02-24 10:16:40', '[admin2, admin1, admin, admin3, admin4, admin5, admin6]', '1');
