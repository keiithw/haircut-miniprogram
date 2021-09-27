/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : haircut-pro

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 31/03/2020 21:44:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for appointment
-- ----------------------------
DROP TABLE IF EXISTS `appointment`;
CREATE TABLE `appointment`  (
  `aid` int(32) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `customer_id` int(32) NOT NULL COMMENT '用户id',
  `customer_name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `customer_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `customer_avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sid` int(32) NULL DEFAULT NULL,
  `store_name` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `server_id` int(32) NULL DEFAULT NULL COMMENT '服务id',
  `server_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `barber_id` int(32) NULL DEFAULT NULL COMMENT '理发师id',
  `barber_avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `barber_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `barber_name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `price` int(4) NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT -1 COMMENT '0-预约中 1-已到店 2-已完成 3-已取消',
  `note` varchar(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `segment` int(3) NULL DEFAULT NULL COMMENT '时间段数',
  `day` datetime(0) NULL DEFAULT NULL COMMENT '日期',
  `time` datetime(0) NULL DEFAULT NULL,
  `noon` int(1) NULL DEFAULT NULL COMMENT '午别\r\n  case \'上午\':\r\n        num = 1;\r\n        break;\r\n      case \'下午\':\r\n        num = 2;\r\n        break;\r\n      case \'夜间\':\r\n        num = 3;\r\n        break;\r\n      case \'凌晨\':\r\n        num = 4;\r\n        break;\r\n      case \'全天\':\r\n        num = 5;\r\n        break;',
  `noonName` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '午别名字',
  `created_time` datetime(0) NULL DEFAULT NULL,
  `is_review` int(1) NULL DEFAULT 0,
  PRIMARY KEY (`aid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of appointment
-- ----------------------------
INSERT INTO `appointment` VALUES (5, 579420160, 'ت', '15574520382', 'https://wx.qlogo.cn/mmopen/vi_32/GlOGhBiaJtPWibd574vnPFic7osG780Vh6PjibESSzy5lFrCfMh0bYszOJZf5wkRRDcRCdicEBC2oZWbUgzUfRAiabMg/132', 0, 'admin', 4, '雅致染烫', 6, '', '18676783145', 'CUCU', 123, 1, '一起斗地主', 37, '2020-03-20 18:00:00', NULL, NULL, NULL, '2020-03-03 19:21:52', 0);
INSERT INTO `appointment` VALUES (6, 579420160, 'ت', '15574520382', 'https://wx.qlogo.cn/mmopen/vi_32/GlOGhBiaJtPWibd574vnPFic7osG780Vh6PjibESSzy5lFrCfMh0bYszOJZf5wkRRDcRCdicEBC2oZWbUgzUfRAiabMg/132', 0, 'admin', 4, '雅致染烫', 6, 'http://keithw-bucket.oss-cn-shenzhen.aliyuncs.com/images/1582453125736.png', '18676783145', 'CUCU', 123, -1, '你可以跟我聊聊足球。', 43, '2020-03-20 21:23:00', NULL, NULL, NULL, '2020-03-03 21:26:42', 0);
INSERT INTO `appointment` VALUES (7, 579420160, 'ت', '15574520382', 'https://wx.qlogo.cn/mmopen/vi_32/GlOGhBiaJtPWibd574vnPFic7osG780Vh6PjibESSzy5lFrCfMh0bYszOJZf5wkRRDcRCdicEBC2oZWbUgzUfRAiabMg/132', 0, 'admin', 4, '雅致染烫', 6, '', '18676783145', 'CUCU', 123, -1, '给我倒一杯38.5°的水', 43, '2020-03-20 21:23:00', NULL, NULL, NULL, '2020-03-03 21:26:55', 0);
INSERT INTO `appointment` VALUES (8, 579420160, 'ت', '15574520382', 'https://wx.qlogo.cn/mmopen/vi_32/GlOGhBiaJtPWibd574vnPFic7osG780Vh6PjibESSzy5lFrCfMh0bYszOJZf5wkRRDcRCdicEBC2oZWbUgzUfRAiabMg/132', 0, 'admin', 4, '雅致染烫', 6, 'http://keithw-bucket.oss-cn-shenzhen.aliyuncs.com/images/1582453125736.png', '18676783145', 'CUCU', 488, 2, '', 35, '2020-03-20 17:29:00', NULL, NULL, NULL, '2020-03-06 17:54:50', 0);
INSERT INTO `appointment` VALUES (9, 579420160, 'ت', '15574520381', 'https://wx.qlogo.cn/mmopen/vi_32/GlOGhBiaJtPWibd574vnPFic7osG780Vh6PjibESSzy5lFrCfMh0bYszOJZf5wkRRDcRCdicEBC2oZWbUgzUfRAiabMg/132', 0, 'admin', 2013872128, '极致推油', 6, 'http://keithw-bucket.oss-cn-shenzhen.aliyuncs.com/images/1582453125736.png', '18676783145', 'CUCU', 68, -1, '用花生油。', 40, '2020-03-20 19:30:00', NULL, NULL, NULL, '2020-03-20 15:51:52', 0);
INSERT INTO `appointment` VALUES (10, 579420160, 'ت', '15574520381', 'https://wx.qlogo.cn/mmopen/vi_32/GlOGhBiaJtPWibd574vnPFic7osG780Vh6PjibESSzy5lFrCfMh0bYszOJZf5wkRRDcRCdicEBC2oZWbUgzUfRAiabMg/132', 0, 'admin', 2013872128, '极致推油', 6, 'http://keithw-bucket.oss-cn-shenzhen.aliyuncs.com/images/1582453125736.png', '18676783145', 'CUCU', 68, 2, '用海天酱油。', 33, '2020-03-20 16:00:00', NULL, NULL, NULL, '2020-03-20 15:55:35', 0);
INSERT INTO `appointment` VALUES (12, 579420160, 'ت', '15574520381', 'https://wx.qlogo.cn/mmopen/vi_32/GlOGhBiaJtPWibd574vnPFic7osG780Vh6PjibESSzy5lFrCfMh0bYszOJZf5wkRRDcRCdicEBC2oZWbUgzUfRAiabMg/132', 0, 'admin', 2013872128, '极致推油', 6, 'http://keithw-bucket.oss-cn-shenzhen.aliyuncs.com/images/1582453125736.png', '18676783145', 'CUCU', 68, -1, '', 31, '2020-03-20 15:00:00', NULL, NULL, NULL, '2020-03-20 16:13:22', 0);
INSERT INTO `appointment` VALUES (13, 579420160, 'ت', '15574520381', 'https://wx.qlogo.cn/mmopen/vi_32/GlOGhBiaJtPWibd574vnPFic7osG780Vh6PjibESSzy5lFrCfMh0bYszOJZf5wkRRDcRCdicEBC2oZWbUgzUfRAiabMg/132', 0, 'admin', 4, '雅致染烫', 6, 'http://keithw-bucket.oss-cn-shenzhen.aliyuncs.com/images/1582453125736.png', '18676783145', 'CUCU', 488, 2, '我想喝一杯水 很渴。可以跟我聊聊数学。', 41, '2020-03-20 20:00:00', NULL, NULL, NULL, '2020-03-20 16:18:32', 1);
INSERT INTO `appointment` VALUES (14, 579420160, 'ت', '15574520381', 'https://wx.qlogo.cn/mmopen/vi_32/GlOGhBiaJtPWibd574vnPFic7osG780Vh6PjibESSzy5lFrCfMh0bYszOJZf5wkRRDcRCdicEBC2oZWbUgzUfRAiabMg/132', 0, 'admin', 4, '雅致染烫', 6, 'http://keithw-bucket.oss-cn-shenzhen.aliyuncs.com/images/1582453125736.png', '18676783145', 'CUCU', 488, 3, '染紫色渐变, 时尚 大波浪', 39, '2020-03-20 19:00:00', NULL, NULL, NULL, '2020-03-20 16:30:49', 0);
INSERT INTO `appointment` VALUES (15, 579420160, 'ت', '15574520380', 'https://wx.qlogo.cn/mmopen/vi_32/GlOGhBiaJtPWibd574vnPFic7osG780Vh6PjibESSzy5lFrCfMh0bYszOJZf5wkRRDcRCdicEBC2oZWbUgzUfRAiabMg/132', 0, 'admin', 4, '雅致染烫', 35, '', '18676783143', '推拿师4号', 488, -1, 'hehe', 44, '2020-03-27 22:00:00', NULL, NULL, NULL, '2020-03-22 00:59:44', 0);

-- ----------------------------
-- Table structure for base_admin_permission
-- ----------------------------
DROP TABLE IF EXISTS `base_admin_permission`;
CREATE TABLE `base_admin_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `pid` int(11) NULL DEFAULT NULL COMMENT '父菜单id',
  `descpt` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单url',
  `create_time` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '添加时间',
  `update_time` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新时间',
  `del_flag` int(1) NULL DEFAULT NULL COMMENT '删除标志（0:删除 1：存在）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of base_admin_permission
-- ----------------------------
INSERT INTO `base_admin_permission` VALUES (1, '系统管理', 0, '系统管理', '', '2018-11-30 10:27:34', '2018-11-30 10:27:34', 1);
INSERT INTO `base_admin_permission` VALUES (2, '账号管理', 1, '账号管理', '/user/userManage', '2018-11-30 11:44:41', '2018-11-30 11:56:34', 1);
INSERT INTO `base_admin_permission` VALUES (3, '角色管理', 1, '角色管理', '/role/roleManage', '2018-11-30 11:45:27', '2018-11-30 11:45:27', 1);
INSERT INTO `base_admin_permission` VALUES (7, '权限管理', 1, '权限管理', '/permission/permissionManage', '2018-11-30 11:48:35', '2018-11-30 15:13:38', 1);
INSERT INTO `base_admin_permission` VALUES (9, '基本管理', 0, '基本设置', '', '2018-11-30 12:10:32', '2020-02-10 14:55:59', 1);
INSERT INTO `base_admin_permission` VALUES (19, '服务管理', 1, '  增删服务', '/serveManage', '2020-02-13 16:19:47', '2020-02-13 16:25:22', 1);
INSERT INTO `base_admin_permission` VALUES (20, '人员服务安排', 1, '给人员分配服务', '/manageServeOfTony', '2020-02-15 16:25:00', '2020-02-15 16:25:00', 1);
INSERT INTO `base_admin_permission` VALUES (21, '日程管理', 9, '日程管理', '/fullcalendar', '2020-02-25 14:23:34', '2020-02-25 14:23:34', 1);
INSERT INTO `base_admin_permission` VALUES (22, '预约管理', 9, '预约管理', '/appointmentManage', '2020-03-19 13:12:42', '2020-03-19 13:12:42', 1);

-- ----------------------------
-- Table structure for base_admin_role
-- ----------------------------
DROP TABLE IF EXISTS `base_admin_role`;
CREATE TABLE `base_admin_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限角色ID',
  `role_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `role_desc` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `permissions` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限',
  `create_time` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新时间',
  `role_status` int(1) NOT NULL DEFAULT 1 COMMENT '1：有效 \r\n            0：无效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统用户角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of base_admin_role
-- ----------------------------
INSERT INTO `base_admin_role` VALUES (1, '系统管理员', '系统管理员', '1,9', '2018-11-21 15:54:07', '2020-02-14 18:31:32', 1);
INSERT INTO `base_admin_role` VALUES (2, '普通管理员', '普通管理员', '9', '2018-11-21 15:11:44', '2018-12-03 19:09:57', 1);
INSERT INTO `base_admin_role` VALUES (3, '理发师', '理发', '9', '2020-02-10 13:37:07', '2020-02-10 13:37:07', 0);
INSERT INTO `base_admin_role` VALUES (4, '理发师', '理发', '9', '2020-02-10 13:37:11', '2020-02-10 13:37:11', 0);
INSERT INTO `base_admin_role` VALUES (5, '染烫师', '染烫', '9', '2020-02-10 13:37:23', '2020-02-10 13:37:42', 0);
INSERT INTO `base_admin_role` VALUES (6, '洗头员', '洗头按摩', '1', '2020-02-10 13:38:13', '2020-02-10 13:38:13', 0);
INSERT INTO `base_admin_role` VALUES (7, '店长', '人员培训，事务管理', '1,9', '2020-02-10 13:38:47', '2020-02-10 13:38:47', 0);
INSERT INTO `base_admin_role` VALUES (8, '洗发师', '洗头,spa，按摩', '9', '2020-02-10 14:12:47', '2020-02-10 14:12:47', 0);
INSERT INTO `base_admin_role` VALUES (9, '区域分店', '负责管理区域造型营业', '1', '2020-02-11 10:33:11', '2020-02-14 18:31:43', 1);
INSERT INTO `base_admin_role` VALUES (10, '理发师', '洗剪吹业务', '9', '2020-02-11 10:35:16', '2020-02-11 10:35:16', 0);
INSERT INTO `base_admin_role` VALUES (11, '理发师', '洗剪吹业务', '9', '2020-02-11 10:35:30', '2020-02-11 10:43:28', 1);
INSERT INTO `base_admin_role` VALUES (12, '洗头员', '洗头按摩', '9', '2020-02-24 16:44:16', '2020-02-24 16:44:16', 1);

-- ----------------------------
-- Table structure for base_admin_user
-- ----------------------------
DROP TABLE IF EXISTS `base_admin_user`;
CREATE TABLE `base_admin_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `sid` int(32) NULL DEFAULT 0,
  `sys_user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '系统用户名称',
  `sys_user_pwd` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系统用户密码',
  `role_id` int(255) NULL DEFAULT NULL COMMENT '角色',
  `user_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `reg_time` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登记时间',
  `user_status` int(1) NOT NULL DEFAULT 0 COMMENT '状态（0：无效；1：有效）',
  `introduce` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `work_since` datetime(0) NULL DEFAULT NULL,
  `profile_photo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` int(1) NULL DEFAULT NULL,
  `birthday` datetime(0) NULL DEFAULT NULL,
  `is_shop` int(1) NULL DEFAULT NULL,
  `latitude` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '纬度',
  `longitude` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '精度',
  `working` int(1) NULL DEFAULT 0 COMMENT '0-休息， 1-上班',
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rate` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统管理员帐号' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of base_admin_user
-- ----------------------------
INSERT INTO `base_admin_user` VALUES (1, 0, 'admin', '539b31f986eadbeffcbaa791dc93e278', 1, '18676783145', '2018-11-22 10:57:33', 1, 'Maurice Wu', NULL, 'http://keithw-bucket.oss-cn-shenzhen.aliyuncs.com/images/1583245500435.jpg', NULL, NULL, 1, '22.540148', '113.909516', 0, '广东惠州演达大道46号惠州学院中苑9栋404', 100);
INSERT INTO `base_admin_user` VALUES (6, 0, 'CUCU', '389c602f1bd79cac477aa4c78466f72e', 1, '18676783145', '2020-02-10 13:09:01', 1, '我是北京大学美容医学12级毕业生，修的是皮肤科专业。本人从业7年时间，经验丰富，手法技术娴熟，专业知识过硬。学校里面教的东西很多很杂，学到的东西也“博而不专”。语言方面，掌握比较熟练的是皮肤的护理，当然，在皮肤护理方面和各位前辈们比起来，那简直就是菜鸟。所以在以后的工作中还要向各位前辈同事学习、请教，望给予指点。在犯错误的时候，也请前辈们批评指出，“新人”不是逃避责任的借口，我会牢记这句话的。 在兴趣爱好方面，作为学美容的学生，说在学校做美容实在是骗人的，平时喜欢做些桑拿，推背、按摩等一些相关的业余爱好。', NULL, 'http://keithw-bucket.oss-cn-shenzhen.aliyuncs.com/images/1582453125736.png', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_admin_user` VALUES (15, 866, '理发牛肉店', 'fd9d27dfc4d4ee33c6f3c4a25cfbed53', 1, '13213451231', '2020-02-11 17:58:58', 1, NULL, NULL, '/static/upload/e5f80f39-9414-4c09-a9fe-1c13a88d7bfe.jpg', NULL, NULL, 1, '22.45', '113.4', NULL, '深圳南山', NULL);
INSERT INTO `base_admin_user` VALUES (17, -1966522368, '理发鸡扒店', '95351ff1fb714c9b7a84b0d71a0c7a1e', 1, '12313123131', '2020-02-11 18:25:33', 1, '专注鸡扒', NULL, '', NULL, NULL, 1, '39.5427', '116.2317', NULL, '湖北武汉', NULL);
INSERT INTO `base_admin_user` VALUES (20, -1698086912, '理发鸡扒越秀店', '55423a2e8b33d663863d553ac65b5ce6', 9, '13214213213', '2020-02-12 01:09:34', 1, '', NULL, '', NULL, NULL, 1, '27.2', '113.3', NULL, '嗯嗯嗯嗯', NULL);
INSERT INTO `base_admin_user` VALUES (21, 692666368, '理发鸡扒福田店', '2f02d09a1b7e8e65b118327f11f749f2', 9, '42141231234', '2020-02-12 01:11:07', 1, '', NULL, 'http://keithw-bucket.oss-cn-shenzhen.aliyuncs.com/images/1582632210249.png', NULL, NULL, 1, '37.566535', '126.977969', NULL, '', 100);
INSERT INTO `base_admin_user` VALUES (25, -276217856, '精致男孩店', 'c07bf76db80dcd64875c39f8d28660fb', 1, '12313123131', '2020-02-13 17:48:30', 1, 'I am a very very long Introduce, we have very very good team. come to change your style, we have very very good team, dont hesitate to come , give you a unique style', NULL, 'https://keithw-bucket.oss-cn-shenzhen.aliyuncs.com/images/12713c42-ecf2-4e04-b511-7eb195fbc656.jpg', NULL, NULL, 1, '22.540119', '113.909647', NULL, '深圳市南山区桂庙路132号', 100);
INSERT INTO `base_admin_user` VALUES (35, 0, '推拿师4号', 'f3e8c0cc7dd30fd0aaad87a3b3218bdd', 11, '18676783143', '2020-02-23 18:21:06', 1, '', NULL, '', 0, NULL, 0, '', '', 0, '', 111);
INSERT INTO `base_admin_user` VALUES (36, 0, '理发师一一', '24436a0445ed742cd5403a0a152bf777', 11, '18676783145', '2020-02-27 00:26:10', 1, '', NULL, 'http://keithw-bucket.oss-cn-shenzhen.aliyuncs.com/images/1582734363813.png', 1, NULL, 0, '', '', 0, '广东惠州演达大道46号惠州学院', 100);
INSERT INTO `base_admin_user` VALUES (37, 0, '新来的理发师', '95a11a5b981f99e694fbdba117ca19d6', 11, '18676783145', '2020-02-27 14:37:25', 1, '', NULL, '', 1, NULL, 0, '', '', 0, '', 100);
INSERT INTO `base_admin_user` VALUES (38, -276217856, '精致的洗头女孩', '945fc5baa6dc3e2d8dd70662322ab37f', 12, '18676783145', '2020-02-27 20:14:43', 1, '', NULL, 'http://keithw-bucket.oss-cn-shenzhen.aliyuncs.com/images/1582805673172.jpg', NULL, NULL, 0, '', '', 0, '广东惠州演达大道46号惠州学院', 82);
INSERT INTO `base_admin_user` VALUES (39, -276217856, '看家造型师', '676276a840f2dd1d986abf6442ee71c8', 11, '18676783145', '2020-02-27 20:15:29', 1, '', NULL, '', 1, NULL, 0, '', '', 0, '', 130);

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `id` int(32) NOT NULL,
  `open_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `phone` varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sex` int(1) NULL DEFAULT NULL,
  `birthday` datetime(0) NULL DEFAULT NULL,
  `height` int(3) NULL DEFAULT NULL,
  `weight` int(11) NULL DEFAULT NULL,
  `created_time` datetime(0) NULL DEFAULT NULL,
  `type` int(1) NULL DEFAULT 0 COMMENT '0-新用户  1-消费一次后的老用户',
  `finish_info` int(1) NULL DEFAULT 0 COMMENT '0-未填 1-已填',
  `introduce` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `openid`(`open_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (579420160, 'oH2nz5CTtgGvJHH946J-QY3h29lM', '', '15574520380', 1, NULL, 174, 57, '2020-02-18 20:53:13', NULL, 1, '我喜欢数学，聊聊微积分吧');

-- ----------------------------
-- Table structure for review
-- ----------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review`  (
  `rid` int(32) NOT NULL AUTO_INCREMENT,
  `uid` int(32) NULL DEFAULT NULL,
  `bid` int(32) NULL DEFAULT NULL,
  `sid` int(32) NULL DEFAULT NULL,
  `stars` int(1) NULL DEFAULT NULL,
  `serve_name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `customer_name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `customer_avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
  `barber_name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `title` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
  `content` varchar(66) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `photo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
  `date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`rid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of review
-- ----------------------------
INSERT INTO `review` VALUES (2, 579420160, 6, 0, 5, 'bi', 'ت', 'https://wx.qlogo.cn/mmopen/vi_32/GlOGhBiaJtPWibd574vnPFic7osG780Vh6PjibESSzy5lFrCfMh0bYszOJZf5wkRRDcRCdicEBC2oZWbUgzUfRAiabMg/132', 'CUCU', '快选CUCU！！', 'CUCU是个很棒的小姐姐，颜值惊人啊啊..而且说话很温柔，服务很贴心~~我每次都会来找她', 'http://tmp/wx35edf82d0cd67686.o6zAJs74sQr0P8Uvv2IpmRJDqMkQ.VVQPFmqL5ZMQ0697acd69d00375a8dc548dd49f70610.jpeg', '2020-03-21 17:42:34');

-- ----------------------------
-- Table structure for serve
-- ----------------------------
DROP TABLE IF EXISTS `serve`;
CREATE TABLE `serve`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `sid` int(32) NULL DEFAULT NULL,
  `name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `original_price` int(4) NULL DEFAULT NULL,
  `description` varchar(66) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `current_price` int(4) NULL DEFAULT NULL,
  `picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2013872129 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of serve
-- ----------------------------
INSERT INTO `serve` VALUES (-100057088, -276217856, '大保健', 999, '', 549, '7eb195fbc656.jpg');
INSERT INTO `serve` VALUES (1, -276217856, '泰式spa', 3214, '', 2599, 'https://keithw-bucket.oss-cn-shenzhen.aliyuncs.com/images/12713c42-ecf2-4e04-b511-7eb195fbc656.jpg');
INSERT INTO `serve` VALUES (3, 0, '精致美甲', 130, 'meimei', 99, '');
INSERT INTO `serve` VALUES (4, 0, '雅致染烫', 588, '', 488, 'http://keithw-bucket.oss-cn-shenzhen.aliyuncs.com/images/1583248242291.jpg');
INSERT INTO `serve` VALUES (606208, -276217856, '造型定制+洗剪吹', 535, '', 469, 'http://keithw-bucket.oss-cn-shenzhen.aliyuncs.com/images/1582806322761.jpg');
INSERT INTO `serve` VALUES (1191788544, -276217856, '按摩', 312, '', 1, 'https://keithw-bucket.oss-cn-shenzhen.aliyuncs.com/images/12713c42-ecf2-4e04-b511-7eb195fbc656.jpg');
INSERT INTO `serve` VALUES (1477001216, -276217856, '墨西哥洗头', 20, '海的味道', 9, 'http://keithw-bucket.oss-cn-shenzhen.aliyuncs.com/images/1582806433062.jpg');
INSERT INTO `serve` VALUES (2013872128, 0, '极致推油', 110, '', 68, 'http://keithw-bucket.oss-cn-shenzhen.aliyuncs.com/images/1583247100120.jpeg');

-- ----------------------------
-- Table structure for serve_of_barber
-- ----------------------------
DROP TABLE IF EXISTS `serve_of_barber`;
CREATE TABLE `serve_of_barber`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `barber_id` int(11) NULL DEFAULT NULL,
  `serve_ids` varchar(130) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'serve的id  1,2,3',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `index_name`(`serve_ids`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of serve_of_barber
-- ----------------------------
INSERT INTO `serve_of_barber` VALUES (1, 6, '2013872128,4');
INSERT INTO `serve_of_barber` VALUES (2, 35, '4,2013872128');
INSERT INTO `serve_of_barber` VALUES (3, 36, NULL);
INSERT INTO `serve_of_barber` VALUES (4, 37, NULL);
INSERT INTO `serve_of_barber` VALUES (5, 38, '1477001216,1,-100057088,1191788544');
INSERT INTO `serve_of_barber` VALUES (6, 39, '606208');

-- ----------------------------
-- Table structure for star
-- ----------------------------
DROP TABLE IF EXISTS `star`;
CREATE TABLE `star`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `customer_id` int(32) NULL DEFAULT NULL,
  `target_id` int(32) NULL DEFAULT NULL,
  `is_shop` int(1) NULL DEFAULT NULL,
  `star` int(1) NULL DEFAULT NULL,
  `created_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of star
-- ----------------------------
INSERT INTO `star` VALUES (17, 579420160, 25, 1, 1, '2020-03-08 17:09:00');
INSERT INTO `star` VALUES (21, 579420160, 6, 0, 1, '2020-03-20 16:27:23');

-- ----------------------------
-- Table structure for work_time
-- ----------------------------
DROP TABLE IF EXISTS `work_time`;
CREATE TABLE `work_time`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `sid` int(32) NULL DEFAULT NULL,
  `title` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '1-上班 2-请假 3-迟到',
  `barber_id` int(32) NULL DEFAULT NULL,
  `barber_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `start` varchar(35) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '天',
  `end` varchar(35) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `noon` int(1) NULL DEFAULT NULL COMMENT '午别 case \'上午\':\r\n        num = 1;\r\n        break;\r\n      case \'下午\':\r\n        num = 2;\r\n        break;\r\n      case \'夜间\':\r\n        num = 3;\r\n        break;\r\n      case \'凌晨\':\r\n        num = 4;\r\n        break;\r\n      case \'全天\':\r\n        num = 5;\r\n        break;',
  `noon_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `interval_max` int(1) NULL DEFAULT NULL,
  `all_day` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of work_time
-- ----------------------------
INSERT INTO `work_time` VALUES (1, 0, '请假', 6, 'CUCU', '2020-02-12 00:24:34', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `work_time` VALUES (2, 0, '上班', 35, '6', '2020-03-06 00:24:47', NULL, 1, '上午', NULL, NULL);
INSERT INTO `work_time` VALUES (3, 0, '工作', 6, 'CUCU', '2020-03-20 14:30:00', '2020-02-04 18:00:00', 2, '下午', 1, 0);
INSERT INTO `work_time` VALUES (5, 0, '工作', 6, 'CUCU', '2020-03-20 19:00:00', '2020-02-05 21:50:00', 3, '夜间', 3, 0);
INSERT INTO `work_time` VALUES (6, 0, '工作', 6, 'CUCU', '2020-03-5 09:40:00', '2020-02-04 12:00:00', 1, '上午', 3, 0);
INSERT INTO `work_time` VALUES (7, 0, '迟到', 6, 'CUCU', '', '', 4, '凌晨', 5, 0);
INSERT INTO `work_time` VALUES (8, 0, '迟到', 6, 'CUCU', '', '', 4, '凌晨', 5, 0);
INSERT INTO `work_time` VALUES (9, 0, '工作', 6, 'CUCU', '2020-03-23 14:30:00', '2020-03-23 18:00:00', 2, '下午', 5, 0);
INSERT INTO `work_time` VALUES (10, 0, '工作', 6, 'CUCU', '2020-03-23 19:00:00', '2020-03-23 21:50:00', 3, '夜间', 5, 0);
INSERT INTO `work_time` VALUES (11, 0, '工作', 6, 'CUCU', '2020-03-24 14:30:00', '2020-03-24 18:00:00', 2, '下午', 5, 0);
INSERT INTO `work_time` VALUES (12, 0, '工作', 35, '推拿师4号', '2020-03-27 19:00:00', '2020-03-27 21:50:00', 3, '夜间', 6, 0);
INSERT INTO `work_time` VALUES (14, 0, '工作', 37, '新来的理发师', '2020-03-28 14:30:00', '2020-03-28 18:00:00', 2, '下午', 9, 0);
INSERT INTO `work_time` VALUES (17, 0, '工作', 37, '新来的理发师', '2020-03-27 14:30:00', '2020-03-27 18:00:00', 2, '下午', 9, 0);
INSERT INTO `work_time` VALUES (18, 0, '工作', 36, '理发师一一', '2020-03-28 19:00:00', '2020-03-28 21:50:00', 3, '夜间', 9, 0);
INSERT INTO `work_time` VALUES (23, 0, '工作', 35, '推拿师4号', '2020-04-08 09:40:00', '2020-04-08 12:00:00', 1, '上午', 9, 0);
INSERT INTO `work_time` VALUES (24, 0, '工作', 35, '推拿师4号', '2020-04-09 14:30:00', '2020-04-09 18:00:00', 2, '下午', 7, 0);
INSERT INTO `work_time` VALUES (26, 0, '工作', 6, 'CUCU', '2020-03-26 09:40:00', '2020-03-26 12:00:00', 1, '上午', 8, 0);
INSERT INTO `work_time` VALUES (27, 0, '工作', 6, 'CUCU', '2020-03-27 19:00:00', '2020-03-27 21:50:00', 3, '夜间', 8, 0);
INSERT INTO `work_time` VALUES (28, 0, '工作', 6, 'CUCU', '2020-03-31 14:30:00', '2020-03-31 18:00:00', 2, '下午', 9, 0);

SET FOREIGN_KEY_CHECKS = 1;
