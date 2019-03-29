/*
 Navicat Premium Data Transfer

 Source Server         : huangzi
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : huangzi

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 29/03/2019 21:24:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for audience_info
-- ----------------------------
DROP TABLE IF EXISTS `audience_info`;
CREATE TABLE `audience_info`  (
  `ID` int(30) NOT NULL AUTO_INCREMENT COMMENT '观众id',
  `AUDIENCE_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '观众姓名',
  `AUDIENCE_NICKNAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '观众昵称',
  `AUDIENCE_ACCOUNT` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '观众帐号',
  `AUDIENCE_PASSWORD` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '观众密码',
  `AUDIENCE_LOGO` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '观众头像',
  `AUDIENCE_GENDER` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '观众性别',
  `AUDIENCE_AGE` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '观众年龄',
  `AUDIENCE_IDCARD` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '观众身份证号',
  `AUDIENCE_PHONE` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '观众电话',
  `AUDIENCE_BANK` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '观众银行账号',
  `AUDIENCE_LOC` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '观众地址',
  `DELETE_FLAG` int(1) UNSIGNED ZEROFILL NULL DEFAULT 0 COMMENT '逻辑删除状态：0：可用；1：已删除',
  `SPARE_FIELD1` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备用字段1',
  `SPARE_FIELD2` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备用字段2',
  `SPARE_FIELD3` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备用字段3',
  `SPARE_FIELD4` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备用字段4',
  `SPARE_FIELD5` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备用字段5',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of audience_info
-- ----------------------------
INSERT INTO `audience_info` VALUES (1, '小黑', '人世间子', 'xiaohei', '123456', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for cast_type
-- ----------------------------
DROP TABLE IF EXISTS `cast_type`;
CREATE TABLE `cast_type`  (
  `ID` int(30) NOT NULL AUTO_INCREMENT COMMENT '直播种类id',
  `CAST_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '直播种类名称',
  `CAST_LOGO` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '直播种类图像',
  `DELETE_FLAG` int(1) UNSIGNED ZEROFILL NULL DEFAULT 0 COMMENT '逻辑删除状态：0：可用；1：已删除',
  `SPARE_FIELD1` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备用字段1',
  `SPARE_FIELD2` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备用字段2',
  `SPARE_FIELD3` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备用字段3',
  `SPARE_FIELD4` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备用字段4',
  `SPARE_FIELD5` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备用字段5',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cast_type
-- ----------------------------
INSERT INTO `cast_type` VALUES (1, '英雄联盟', '暂无', 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `cast_type` VALUES (2, '绝地求生', '暂无', 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `cast_type` VALUES (3, '魔兽世界', '暂无', 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `cast_type` VALUES (4, '炉石传说', '暂无', 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `cast_type` VALUES (5, '守望先锋', '暂无', 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `cast_type` VALUES (6, 'CSGO', '暂无', 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `cast_type` VALUES (7, '刀塔二', '暂无', 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `cast_type` VALUES (8, '仙剑', '暂无', 0, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for host_fans
-- ----------------------------
DROP TABLE IF EXISTS `host_fans`;
CREATE TABLE `host_fans`  (
  `ID` int(30) NOT NULL AUTO_INCREMENT COMMENT '粉丝id',
  `HOST_ID` int(30) NULL DEFAULT NULL COMMENT '主播id：外键-主播表id',
  `AUDIENCE_ID` int(30) NULL DEFAULT NULL COMMENT '观众id：外键-观众表id',
  `FANS_FLAG` int(1) NULL DEFAULT NULL COMMENT '粉丝状态：0：正常；1：禁言',
  `DELETE_FLAG` int(1) UNSIGNED ZEROFILL NULL DEFAULT 0 COMMENT '逻辑删除状态：0：可用；1：已删除',
  `SPARE_FIELD1` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备用字段1',
  `SPARE_FIELD2` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备用字段2',
  `SPARE_FIELD3` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备用字段3',
  `SPARE_FIELD4` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备用字段4',
  `SPARE_FIELD5` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备用字段5',
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `FANS_FK_1`(`HOST_ID`) USING BTREE,
  INDEX `FANS_FK_2`(`AUDIENCE_ID`) USING BTREE,
  CONSTRAINT `FANS_FK_1` FOREIGN KEY (`HOST_ID`) REFERENCES `host_info` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FANS_FK_2` FOREIGN KEY (`AUDIENCE_ID`) REFERENCES `audience_info` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for host_info
-- ----------------------------
DROP TABLE IF EXISTS `host_info`;
CREATE TABLE `host_info`  (
  `ID` int(30) NOT NULL AUTO_INCREMENT COMMENT '主播id',
  `HOST_ROOM` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '主播房间号',
  `HOST_TYPE` int(30) NULL DEFAULT NULL COMMENT '直播类别：外键-直播种类表id',
  `HOST_FLAG` int(1) UNSIGNED ZEROFILL NULL DEFAULT 0 COMMENT '直播状态：0：休息；1：直播；2：被安排',
  `HOST_TITLE` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '直播标题',
  `HOST_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '主播姓名',
  `HOST_NICKNAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '主播昵称',
  `HOST_ACCOUNT` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '主播账号',
  `HOST_PASSWORD` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '主播密码',
  `HOST_LOGO` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '主播头像',
  `HOST_GENDER` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '主播性别',
  `HOST_AGE` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '主播年龄',
  `HOST_IDCARD` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '主播身份证号',
  `HOST_PHONE` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '主播电话',
  `HOST_BANK` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '主播银行帐号',
  `HOST_LOC` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '主播地址',
  `DELETE_FLAG` int(1) UNSIGNED ZEROFILL NULL DEFAULT 0 COMMENT '逻辑删除状态：0：可用；1：已删除',
  `SPARE_FIELD1` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备用字段1',
  `SPARE_FIELD2` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备用字段2',
  `SPARE_FIELD3` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备用字段3',
  `SPARE_FIELD4` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备用字段4',
  `SPARE_FIELD5` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备用字段5',
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `HOST_FK_1`(`HOST_TYPE`) USING BTREE,
  INDEX `HOST_ROOM`(`HOST_ROOM`) USING BTREE,
  CONSTRAINT `HOST_FK_1` FOREIGN KEY (`HOST_TYPE`) REFERENCES `cast_type` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of host_info
-- ----------------------------
INSERT INTO `host_info` VALUES (1, '0101', 1, 0, '韩服剑指第一', '闫凤春', '摇摆', 'yanfengchun', '123456', '暂无', '男', '28', '123456789', '13622119001', '666666666666666', '安徽省 六安市', 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `host_info` VALUES (30, '0102', 1, 0, '中路杀神', '禹景曦', '若风', 'yujingxi', '123456', '暂无', '男', '32', '123456789', '13622119002', '777777777777777', '湖南省 长沙市', 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `host_info` VALUES (31, '0201', 2, 0, '落地成盒', '李志鹏', '年少囧', 'lizhipeng', '123456', '暂无', '男', '27', '123456789', '13622119003', '333333333333333', '湖南省 长沙市', 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `host_info` VALUES (32, '0202', 2, 0, '2', '2', '2', '2', '2', '2', '2', '2', '22', '2', '2', '2', 0, '', '', '', NULL, NULL);
INSERT INTO `host_info` VALUES (33, '0301', 3, 0, '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `host_info` VALUES (34, '0302', 3, 0, '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `host_info` VALUES (35, '0401', 4, 0, '5', '5', '5', '5', NULL, '5', '5', '5', '5', '5', '5', '5', 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `host_info` VALUES (36, NULL, 5, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `host_info` VALUES (37, NULL, 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `host_info` VALUES (38, NULL, 6, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `host_info` VALUES (39, NULL, 6, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `host_info` VALUES (40, NULL, 8, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `host_info` VALUES (41, NULL, 7, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `host_info` VALUES (42, NULL, 5, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for menu_info
-- ----------------------------
DROP TABLE IF EXISTS `menu_info`;
CREATE TABLE `menu_info`  (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `MENU_URL` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '请求路径规则',
  `MENU_PATH` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '路由path',
  `MENU_COMPONENT` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '组件名称',
  `MENU_COM_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '组件名',
  `MENU_KEEPLIVE` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '菜单切换时是否保活',
  `MENU_REQUIREAUTH` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '是否登陆后才可访问',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu_info
-- ----------------------------
INSERT INTO `menu_info` VALUES (1, '/api/base/supermanager/*', '/supermanager', 'index', '超管资料', NULL, NULL);
INSERT INTO `menu_info` VALUES (2, '/api/base/hostinfo/*', '/hostinfo', 'index', '主播资料', NULL, NULL);
INSERT INTO `menu_info` VALUES (3, '/api/base/roommanager/*', '/roommanager', 'index', '房管资料', NULL, NULL);
INSERT INTO `menu_info` VALUES (4, '/api/base/audience/*', '/audience', 'index', '观众资料', NULL, NULL);

-- ----------------------------
-- Table structure for menu_role
-- ----------------------------
DROP TABLE IF EXISTS `menu_role`;
CREATE TABLE `menu_role`  (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `MENU_ID` int(10) NULL DEFAULT NULL,
  `ROLE_ID` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `MENU_ROLE_FK_1`(`MENU_ID`) USING BTREE,
  INDEX `MENU_ROLE_FK_2`(`ROLE_ID`) USING BTREE,
  CONSTRAINT `MENU_ROLE_FK_1` FOREIGN KEY (`MENU_ID`) REFERENCES `menu_info` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `MENU_ROLE_FK_2` FOREIGN KEY (`ROLE_ID`) REFERENCES `role_info` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu_role
-- ----------------------------
INSERT INTO `menu_role` VALUES (1, 1, 1);
INSERT INTO `menu_role` VALUES (2, 2, 1);
INSERT INTO `menu_role` VALUES (3, 3, 1);
INSERT INTO `menu_role` VALUES (4, 4, 1);
INSERT INTO `menu_role` VALUES (5, 2, 2);
INSERT INTO `menu_role` VALUES (6, 3, 2);
INSERT INTO `menu_role` VALUES (7, 4, 2);
INSERT INTO `menu_role` VALUES (8, 3, 3);
INSERT INTO `menu_role` VALUES (9, 4, 3);

-- ----------------------------
-- Table structure for role_info
-- ----------------------------
DROP TABLE IF EXISTS `role_info`;
CREATE TABLE `role_info`  (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `ROLE_NAMEY` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '角色英文名称',
  `ROLE_NAMEZ` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '角色中文名称',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_info
-- ----------------------------
INSERT INTO `role_info` VALUES (1, 'ROLE_SUPERMANAGER', '超级管理员');
INSERT INTO `role_info` VALUES (2, 'ROLE_HOST', '主播');
INSERT INTO `role_info` VALUES (3, 'ROLE_ROOMMANAGER', '房间管理员');
INSERT INTO `role_info` VALUES (4, 'ROLE_AUDIENCE', '观众');

-- ----------------------------
-- Table structure for room_manager
-- ----------------------------
DROP TABLE IF EXISTS `room_manager`;
CREATE TABLE `room_manager`  (
  `ID` int(30) NOT NULL AUTO_INCREMENT COMMENT '房管id',
  `ROOM_ROOM` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '房间号：外键-主播表房间号hostRoom',
  `ROOM_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '房管姓名',
  `ROOM_NICKNAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '房管昵称',
  `ROOM_ACCOUNT` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '房管账号',
  `ROOM_PASSWORD` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '房管密码',
  `ROOM_LOGO` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '房管头像',
  `ROOM_GENDER` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '房管性别',
  `ROOM_AGE` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '房管年龄',
  `ROOM_IDCARD` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '房管身份证号',
  `ROOM_PHONE` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '房管电话',
  `ROOM_BANK` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '房管银行账号',
  `ROOM_LOC` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '房管地址',
  `DELETE_FLAG` int(1) UNSIGNED ZEROFILL NULL DEFAULT 0 COMMENT '逻辑删除状态：0：可用；1：已删除',
  `SPARE_FIELD1` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备用字段1',
  `SPARE_FIELD2` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备用字段2',
  `SPARE_FIELD3` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备用字段3',
  `SPARE_FIELD4` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备用字段4',
  `SPARE_FIELD5` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备用字段5',
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `ROOM_FK_1`(`ROOM_ROOM`) USING BTREE,
  CONSTRAINT `ROOM_FK_1` FOREIGN KEY (`ROOM_ROOM`) REFERENCES `host_info` (`HOST_ROOM`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for super_manager
-- ----------------------------
DROP TABLE IF EXISTS `super_manager`;
CREATE TABLE `super_manager`  (
  `ID` int(30) NOT NULL AUTO_INCREMENT COMMENT '超管id',
  `SUPER_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '超管姓名',
  `SUPER_NICKNAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '超管昵称',
  `SUPER_ACCOUNT` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '超管账号',
  `SUPER_PASSWORD` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '超管密码',
  `SUPER_LOGO` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '超管头像',
  `SUPER_GENDER` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '超管性别',
  `SUPER_AGE` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '超管年龄',
  `SUPER_IDCARD` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '超管身份证号',
  `SUPER_PHONE` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '超管电话',
  `SUPER_BANK` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '超管银行账号',
  `SUPER_LOC` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '超管地址',
  `DELETE_FLAG` int(1) UNSIGNED ZEROFILL NULL DEFAULT 0 COMMENT '逻辑删除状态：0：可用；1：已删除',
  `SPARE_FIELD1` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备用字段1',
  `SPARE_FIELD2` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备用字段2',
  `SPARE_FIELD3` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备用字段3',
  `SPARE_FIELD4` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备用字段4',
  `SPARE_FIELD5` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备用字段5',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `USER_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户名-账号',
  `USER_PASSWORD` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户密码',
  `USER_TYPE` int(1) UNSIGNED ZEROFILL NULL DEFAULT 4 COMMENT '用户类型：1：超管；2：主播；3：房管；4：观众',
  `DELETE_FLAG` int(1) NULL DEFAULT 0 COMMENT '删除状态：0：正常；1：删除',
  `SPARE_FIELD1` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备用字段1',
  `SPARE_FIELD2` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备用字段2',
  `SPARE_FIELD3` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备用字段3',
  `SPARE_FIELD4` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备用字段4',
  `SPARE_FIELD5` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备用字段5',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 'supermanager', '123456', 1, 0, '', NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES (2, 'host', '123456', 2, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES (3, 'roommanager', '123456', 3, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES (4, 'audience', '123456', 4, 0, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户-角色ID',
  `USER_ID` int(10) NULL DEFAULT NULL COMMENT '用户ID',
  `ROLE_ID` int(10) NULL DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `USER_ROLE_FK_1`(`USER_ID`) USING BTREE,
  INDEX `USER_ROLE_FK_2`(`ROLE_ID`) USING BTREE,
  CONSTRAINT `USER_ROLE_FK_1` FOREIGN KEY (`USER_ID`) REFERENCES `user_info` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `USER_ROLE_FK_2` FOREIGN KEY (`ROLE_ID`) REFERENCES `role_info` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, 1);
INSERT INTO `user_role` VALUES (2, 2, 2);
INSERT INTO `user_role` VALUES (3, 3, 3);
INSERT INTO `user_role` VALUES (4, 4, 4);

SET FOREIGN_KEY_CHECKS = 1;
