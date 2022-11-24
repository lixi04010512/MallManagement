/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80031
 Source Host           : localhost:3306
 Source Schema         : jide

 Target Server Type    : MySQL
 Target Server Version : 80031
 File Encoding         : 65001

 Date: 24/11/2022 21:16:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_address
-- ----------------------------
DROP TABLE IF EXISTS `tb_address`;
CREATE TABLE `tb_address` (
  `address_id` int NOT NULL AUTO_INCREMENT COMMENT '地址id',
  `user_id` int NOT NULL COMMENT '关联用户id',
  `area` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '区域',
  `building` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '楼栋',
  `house_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '门牌号',
  `consignee` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '收货人',
  `phone` bigint NOT NULL COMMENT '收货人手机号码',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updata_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`address_id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_address
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin` (
  `uid` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户名',
  `password` char(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '密码',
  `salt` char(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '盐值',
  `phone` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '电话号码',
  `email` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '电子邮箱',
  `gender` int DEFAULT NULL COMMENT '性别:0-女，1-男',
  `avatar` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '头像',
  `is_delete` int DEFAULT NULL COMMENT '是否删除：0-未删除，1-已删除',
  `created_user` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '日志-创建人',
  `created_time` datetime DEFAULT NULL COMMENT '日志-创建时间',
  `modified_user` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '日志-最后修改执行人',
  `modified_time` datetime DEFAULT NULL COMMENT '日志-最后修改时间',
  `balance` decimal(18,2) DEFAULT NULL COMMENT '余额',
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
BEGIN;
INSERT INTO `tb_admin` VALUES (1, 'admin', '25C447B2162349FEEEAD3C151185C31D', '40BA2E76-4017-4229-B9A4-8E3BBA9A1603', NULL, NULL, NULL, NULL, 0, 'LIXI', '2022-11-21 17:44:45', 'LIXI', '2022-11-21 17:44:45', NULL);
INSERT INTO `tb_admin` VALUES (2, 'xi', '5B1CB7304C133BF636934ABBC9A39828', '0E579CA0-7FC1-4403-BC13-3C76484B0A67', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for tb_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_category`;
CREATE TABLE `tb_category` (
  `category_id` int NOT NULL AUTO_INCREMENT COMMENT '分类id',
  `category_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '分类名称',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_name` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_category
-- ----------------------------
BEGIN;
INSERT INTO `tb_category` VALUES (1, '手机', '2022-11-20 09:58:00', '2022-11-20 09:58:00');
INSERT INTO `tb_category` VALUES (2, '口红', '2022-11-20 17:08:40', '2022-11-20 17:08:40');
INSERT INTO `tb_category` VALUES (3, '耳机', '2022-11-20 17:32:57', '2022-11-20 17:32:57');
COMMIT;

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `order_id` int NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `user_id` int NOT NULL COMMENT '用户id',
  `address` varchar(255) DEFAULT NULL COMMENT '收货地址id',
  `product_id` int NOT NULL COMMENT '商品id',
  `amount` int NOT NULL COMMENT '商品数量',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
  `status` enum('已收货','未收货') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '未收货' COMMENT '订单状态',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `total_price` decimal(10,2) DEFAULT NULL,
  `receiver` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `address_id` (`address`) USING BTREE,
  KEY `product_id` (`product_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_order
-- ----------------------------
BEGIN;
INSERT INTO `tb_order` VALUES (80, 8, 'D2104', 167, 2, NULL, '未收货', '2022-11-24 12:58:41', '2022-11-24 20:58:41', 3598.00, 'xixi', '15979211139');
COMMIT;

-- ----------------------------
-- Table structure for tb_product
-- ----------------------------
DROP TABLE IF EXISTS `tb_product`;
CREATE TABLE `tb_product` (
  `product_id` int NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `category_id` int NOT NULL COMMENT '分类id',
  `product_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品名称',
  `product_img` varchar(155) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '图片',
  `intro` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '简介',
  `details` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '详情',
  `price` decimal(10,2) NOT NULL COMMENT '价格',
  `inventory` int NOT NULL COMMENT '库存',
  `sales_count` int DEFAULT NULL COMMENT '销量',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`product_id`) USING BTREE,
  KEY `classify_id` (`category_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=173 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_product
-- ----------------------------
BEGIN;
INSERT INTO `tb_product` VALUES (129, 2, '迪奥（Dior）烈艳蓝金唇膏-哑光999# 3.5g 传奇红（口红', '/assets/images/1.png', '', '雾面质地 显色持久 显白 正红色 李佳琦推荐）', 315.00, 1000, 88, '2022-11-20 17:23:10', '2022-11-20 17:23:10');
INSERT INTO `tb_product` VALUES (130, 2, '海囤全球 魅可（MAC)经典唇膏 子弹头口红3g', '/assets/images/2.png', '', 'Chili 秀智色/小辣椒色', 155.00, 1000, 232, '2022-11-20 17:23:10', '2022-11-20 17:23:10');
INSERT INTO `tb_product` VALUES (131, 2, '【联名限量版】MANSLY口红套装中国风口红情人节女朋友生日礼物唇釉彩妆女磁扣锦绣红妆口红礼盒彩妆 锦绣红妆口红礼盒（6支）', '/assets/images/3.png', '', '几得精选', 295.00, 995, 54, '2022-11-20 17:23:10', '2022-11-20 17:23:10');
INSERT INTO `tb_product` VALUES (132, 2, '圣罗兰（YSL）莹亮纯魅唇膏12#（圆管口红）4.5g 斩男色', '/assets/images/4.png', '', '几得精选', 320.00, 1000, 66, '2022-11-20 17:23:10', '2022-11-20 17:23:10');
INSERT INTO `tb_product` VALUES (133, 2, '圣罗兰（YSL）纯口红1#（正红色）3.8g', '/assets/images/5.png', '', '几得精选', 320.00, 1000, 90, '2022-11-20 17:23:10', '2022-11-20 17:23:10');
INSERT INTO `tb_product` VALUES (134, 2, '纪梵希高定香榭天鹅绒唇膏306#(小羊皮口红 法式红 雾面哑光', '/assets/images/6.png', '', '持久锁色）新老包装随机发货', 355.00, 1000, 23, '2022-11-20 17:23:10', '2022-11-20 17:23:10');
INSERT INTO `tb_product` VALUES (135, 2, '【联名款】MANSLY口红套装红鸾心动口红礼盒中国风开运红情人节女朋友生日礼物唇釉颐和园同款彩妆口红 红鸾心动口红礼盒（6支）', '/assets/images/7.png', '', '几得精选', 195.00, 1000, 56, '2022-11-20 17:23:10', '2022-11-20 17:23:10');
INSERT INTO `tb_product` VALUES (136, 2, '海囤全球 迪奥（Dior）烈艳蓝金唇膏 口红', '/assets/images/8.png', '', '3.5g 999号 正红色', 258.00, 1000, 78, '2022-11-20 17:23:10', '2022-11-20 17:23:10');
INSERT INTO `tb_product` VALUES (137, 2, '圣罗兰（YSL）纯口红13#（正橘色）3.8g', '/assets/images/9.png', '', '几得精选', 320.00, 1000, 631, '2022-11-20 17:23:10', '2022-11-20 17:23:10');
INSERT INTO `tb_product` VALUES (138, 2, '海囤全球 魅可（MAC)磨砂系列 雾面丝绒哑光子弹头口红', '/assets/images/10.png', '', '3g 316 devoted to chili 泫雅色', 165.00, 1000, 1024, '2022-11-20 17:23:10', '2022-11-20 17:23:10');
INSERT INTO `tb_product` VALUES (139, 2, '【情人礼物】香奈儿Chanel 口红/唇膏可可小姐水亮/丝绒系列润唇保湿口红配玫瑰花礼盒 丝绒系列', '/assets/images/11.png', '', '43#斩男色', 298.00, 1000, 26, '2022-11-20 17:23:10', '2022-11-20 17:23:10');
INSERT INTO `tb_product` VALUES (140, 2, '迪奥（Dior）口红礼盒套装（烈艳蓝金唇膏哑光#999 3.5g正红色+香氛小样1ml*3随机+随机礼盒样式）', '/assets/images/12.png', '', '几得精选', 379.00, 1000, 12, '2022-11-20 17:23:10', '2022-11-20 17:23:10');
INSERT INTO `tb_product` VALUES (141, 2, '圣罗兰（YSL）纯口红52# 3.8g', '/assets/images/13.png', '', '几得精选', 320.00, 1000, 20, '2022-11-20 17:23:10', '2022-11-20 17:23:10');
INSERT INTO `tb_product` VALUES (142, 2, '迪奥（Dior）烈艳蓝金口红唇膏 028# 3.5g', '/assets/images/14.png', '', '珊瑚红 (滋润保湿 持久显色 粉嫩少女 摩洛哥王妃 幸运色)', 315.00, 1000, 1226, '2022-11-20 17:23:10', '2022-11-20 17:23:10');
INSERT INTO `tb_product` VALUES (143, 2, '迪奥（Dior）烈艳蓝金唇膏520# 3.5g 玫瑰红(口红', '/assets/images/15.png', '', '缎光 滋润保湿 长效持妆 玫红色 斩男色 告白色 粉红色)', 315.00, 1000, 20, '2022-11-20 17:23:10', '2022-11-20 17:23:10');
INSERT INTO `tb_product` VALUES (144, 2, '海囤全球 迪奥（Dior）烈艳蓝金唇膏 口红', '/assets/images/16.png', '', '3.5g 999号 哑光-经典正红', 255.00, 1000, 10, '2022-11-20 17:23:10', '2022-11-20 17:23:10');
INSERT INTO `tb_product` VALUES (145, 2, '欧莱雅（LOREAL）纷泽滋润唇膏RC301复古魅红3.7g（金管 口红女 滋润显色）', '/assets/images/17.png', '', '几得精选', 99.00, 1000, 31, '2022-11-20 17:23:10', '2022-11-20 17:23:10');
INSERT INTO `tb_product` VALUES (146, 2, '阿玛尼(Armani) 口红女士唇釉 生日礼物/表白礼物', '/assets/images/18.png', '', '红管#405番茄红 【李佳琪推荐omg】', 285.00, 1000, 1031, '2022-11-20 17:23:10', '2022-11-20 17:23:10');
INSERT INTO `tb_product` VALUES (147, 2, '美宝莲（MAYBELLINE）绝色持久唇膏雾感哑光系列R09PM 3.9g（女皇色口红新老包装）', '/assets/images/19.png', '', '几得精选', 106.00, 1000, 98, '2022-11-20 17:23:10', '2022-11-20 17:23:10');
INSERT INTO `tb_product` VALUES (148, 2, '【专柜正品】迪奥999Dior口红唇膏烈艳蓝金 哑光滋润520/888/999送礼礼品套装 烈艳蓝金', '/assets/images/20.png', '', '844#橘红色赠礼盒礼袋', 260.00, 1000, 10, '2022-11-20 17:23:10', '2022-11-20 17:23:10');
INSERT INTO `tb_product` VALUES (149, 2, '迪奥（Dior）烈艳蓝金唇膏-哑光999# 3.5g 传奇红（口红', '/assets/images/21.png', '', '雾面质地 显色持久 显白 正红色 李佳琦推荐）', 315.00, 1000, 20, '2022-11-20 17:23:10', '2022-11-20 17:23:10');
INSERT INTO `tb_product` VALUES (150, 2, '海囤全球 魅可（MAC)经典唇膏 子弹头口红3g', '/assets/images/22.png', '', 'Chili 秀智色/小辣椒色', 155.00, 1000, 22, '2022-11-20 17:23:10', '2022-11-20 17:23:10');
INSERT INTO `tb_product` VALUES (151, 2, '【联名限量版】MANSLY口红套装中国风口红情人节女朋友生日礼物唇釉彩妆女磁扣锦绣红妆口红礼盒彩妆 锦绣红妆口红礼盒（6支）', '/assets/images/23.png', '', '几得精选', 295.00, 1000, 17, '2022-11-20 17:23:10', '2022-11-20 17:23:10');
INSERT INTO `tb_product` VALUES (152, 2, '圣罗兰（YSL）莹亮纯魅唇膏12#（圆管口红）4.5g 斩男色', '/assets/images/24.png', '', '几得精选', 320.00, 1000, 11, '2022-11-20 17:23:10', '2022-11-20 17:23:10');
INSERT INTO `tb_product` VALUES (153, 2, '圣罗兰（YSL）纯口红1#（正红色）3.8g', '/assets/images/25.png', '', '几得精选', 320.00, 1000, 20, '2022-11-20 17:23:10', '2022-11-20 17:23:10');
INSERT INTO `tb_product` VALUES (154, 2, '纪梵希高定香榭天鹅绒唇膏306#', '/assets/images/26.png', '', '(小羊皮口红 法式红 雾面哑光 持久锁色）新老包装随机发货', 355.00, 998, 21, '2022-11-20 17:23:10', '2022-11-20 17:23:10');
INSERT INTO `tb_product` VALUES (155, 2, '【联名款】MANSLY口红套装红鸾心动口红礼盒中国风开运红情人节女朋友生日礼物唇釉颐和园同款彩妆口红 红鸾心动口红礼盒（6支）', '/assets/images/27.png', '', '几得精选', 195.00, 1000, 24, '2022-11-20 17:23:10', '2022-11-20 17:23:10');
INSERT INTO `tb_product` VALUES (156, 2, '海囤全球 迪奥（Dior）烈艳蓝金唇膏 口红', '/assets/images/28.png', '', '3.5g 999号 正红色', 258.00, 1000, 16, '2022-11-20 17:23:10', '2022-11-20 17:23:10');
INSERT INTO `tb_product` VALUES (157, 2, '圣罗兰（YSL）纯口红13#（正橘色）3.8g', '/assets/images/29.png', '', '几得精选', 320.00, 1000, 90, '2022-11-20 17:23:10', '2022-11-20 17:23:10');
INSERT INTO `tb_product` VALUES (158, 2, 'MAC 雾面丝绒哑光子弹头口红', '/assets/images/30.png', '', '磨砂系列 3g 316 devoted to chili 泫雅色', 165.00, 993, 88, '2022-11-20 17:24:10', '2022-11-20 17:24:10');
INSERT INTO `tb_product` VALUES (159, 2, 'MAC 雾面丝绒哑光子弹头口红', '/assets/images/31.png', '', '磨砂系列 3g 316 devoted to chili 泫雅色', 165.00, 993, 165, '2022-11-20 17:24:10', '2022-11-20 17:24:10');
INSERT INTO `tb_product` VALUES (160, 3, '小米 Redmi AirDots', '/assets/images/32.png', '', '真无线蓝牙耳机|分体式耳机 |收纳充电盒 |蓝牙5.0 |按键防触控操作', 129.00, 998, 120, '2022-11-20 17:31:54', '2022-11-20 17:31:54');
INSERT INTO `tb_product` VALUES (161, 3, '【自营仓次日达】moloke真无线蓝牙耳机双耳适用于苹果华为小米 运动跑步入耳式oppo迷你商务耳机 【1:1尊享版】自动弹窗+无线充电+可触控（热卖）', '/assets/images/33.png', NULL, '几得精选', 199.00, 1000, 51, '2022-11-20 17:31:54', '2022-11-20 17:31:54');
INSERT INTO `tb_product` VALUES (162, 3, '小米耳机 圈铁Pro 入耳式有线运动音乐耳机耳麦', '/assets/images/34.png', NULL, '几得精选', 149.00, 1000, 72, '2022-11-20 17:31:54', '2022-11-20 17:31:54');
INSERT INTO `tb_product` VALUES (163, 3, '小米 Redmi AirDots', '/assets/images/35.png', NULL, '真无线蓝牙耳机|分体式耳机 |收纳充电盒 |蓝牙5.0 |按键防触控操作', 129.00, 1000, 84, '2022-11-20 17:31:54', '2022-11-20 17:31:54');
INSERT INTO `tb_product` VALUES (164, 3, '【自营仓次日达】moloke真无线蓝牙耳机双耳适用于苹果华为小米 运动跑步入耳式oppo迷你商务耳机 【1:1尊享版】自动弹窗+无线充电+可触控（热卖）', '/assets/images/36.png', NULL, '几得精选', 199.00, 1000, 16, '2022-11-20 17:31:54', '2022-11-20 17:31:54');
INSERT INTO `tb_product` VALUES (165, 3, '小米耳机 圈铁Pro 入耳式有线运动音乐耳机耳麦', '/assets/images/37.png', NULL, '几得精选', 149.00, 1000, 17, '2022-11-20 17:31:54', '2022-11-20 17:31:54');
INSERT INTO `tb_product` VALUES (166, 3, '小米9 Pro 5G 全面屏游戏拍照新品手机', '/assets/images/38.png', NULL, '几得精选', 9999.00, 1000, 135, '2022-11-20 17:31:54', '2022-11-20 17:31:54');
INSERT INTO `tb_product` VALUES (167, 3, '小米MIX2S 骁龙845 AI感光双摄 四曲面陶瓷全面屏', '/assets/images/39.png', NULL, '白色 多功能 NFC 6GB+128GB 游戏智能拍照手机', 1799.00, 1000, 71, '2022-11-20 17:31:54', '2022-11-20 17:31:54');
INSERT INTO `tb_product` VALUES (168, 3, '小米MIX2S 骁龙845 AI感光双摄 四曲面陶瓷全面屏', '/assets/images/40.png', NULL, '黑色 多功能 NFC 6GB+128GB 游戏智能拍照手机', 1799.00, 1000, 73, '2022-11-20 17:31:54', '2022-11-20 17:31:54');
INSERT INTO `tb_product` VALUES (169, 3, '小米9 4800万超广角三摄 6GB+128GB全息幻彩蓝 骁龙855', '/assets/images/41.png', NULL, '全网通4G 双卡双待 水滴全面屏拍照智能游戏手机', 2599.00, 1000, 0, '2022-11-20 17:31:54', '2022-11-20 17:31:54');
COMMIT;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `uid` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户名',
  `password` char(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '密码',
  `salt` char(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '盐值',
  `phone` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '电话号码',
  `email` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '电子邮箱',
  `gender` int DEFAULT NULL COMMENT '性别:0-女，1-男',
  `avatar` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '头像',
  `is_delete` int DEFAULT NULL COMMENT '是否删除：0-未删除，1-已删除',
  `created_user` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '日志-创建人',
  `created_time` datetime DEFAULT NULL COMMENT '日志-创建时间',
  `modified_user` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '日志-最后修改执行人',
  `modified_time` datetime DEFAULT NULL COMMENT '日志-最后修改时间',
  `balance` decimal(18,2) DEFAULT NULL COMMENT '余额',
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
BEGIN;
INSERT INTO `tb_user` VALUES (1, 'kkkuu', '07C698FB5E48E7E9DAF6810A452F6FA3', '97752D34-B223-4700-95C7-86A37619C7BD', NULL, NULL, NULL, '/d', 0, 'kkkuu', '2022-11-02 14:31:00', 'test', '2022-11-16 19:46:25', NULL);
INSERT INTO `tb_user` VALUES (2, '456', 'C03C349D4652813A924A2381CFA20FFA', '61402B72-04BB-4760-9A82-715AF42D7B2B', NULL, NULL, NULL, NULL, 0, '456', '2022-11-16 19:46:25', '456', '2022-11-16 19:46:25', NULL);
INSERT INTO `tb_user` VALUES (3, 'kkkuu09', 'E9F56F23B7401C7BE6F4CE43332FEDE7', 'BA8FFCDD-9C02-4A41-AD7B-36EE1EDC94CF', NULL, NULL, NULL, NULL, 0, 'kkkuu09', '2022-11-16 19:52:12', 'kkkuu09', '2022-11-16 19:52:12', NULL);
INSERT INTO `tb_user` VALUES (4, 'szy', 'F889CD616C4FFFC0C3818089062582A5', '746C2256-1484-42F4-A9DE-165FCBE67BA1', NULL, NULL, NULL, NULL, 0, 'szy', '2022-11-16 20:37:27', 'szy', '2022-11-16 20:37:27', NULL);
INSERT INTO `tb_user` VALUES (5, 'lixi', '64F479956222D955D7B6E6D86476D909', '1DB9B0A9-81A0-42A8-8111-493B029FFB3B', NULL, '1784420499@qq.com', NULL, NULL, 0, 'lixi', '2022-11-21 17:43:34', 'lixi', '2022-11-21 17:43:34', NULL);
INSERT INTO `tb_user` VALUES (6, 'xi', '5B1CB7304C133BF636934ABBC9A39828', '0E579CA0-7FC1-4403-BC13-3C76484B0A67', NULL, '1784420499@qq.com', NULL, NULL, 0, 'xi', '2022-11-21 20:12:36', 'xi', '2022-11-21 20:12:36', NULL);
INSERT INTO `tb_user` VALUES (7, 'xili', '1865AD116137FFA2F3796154212E91CC', '963085B2-58F8-47D0-B8B2-FDFF018D3C3E', NULL, '1784420499@qq.com', NULL, NULL, 0, 'xili', '2022-11-21 20:14:32', 'xili', '2022-11-21 20:14:32', NULL);
INSERT INTO `tb_user` VALUES (8, '嘻嘻', '27FA49F2D43F9AF883E4E6783B67AAB2', '65164910-43BE-4EFA-9EB8-C19C34EEB506', NULL, '1784420499@qq.com', NULL, NULL, 0, '嘻嘻', '2022-11-24 12:14:30', '嘻嘻', '2022-11-24 12:14:30', 6413.00);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
