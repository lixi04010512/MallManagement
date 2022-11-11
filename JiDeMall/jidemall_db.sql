/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : jidemall_db

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 11/11/2022 10:28:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `component` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `meta` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` tinyint(0) NULL DEFAULT NULL,
  `p_id` bigint(0) NULL DEFAULT NULL,
  `hidden` bit(1) NULL DEFAULT NULL,
  `redirect` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cache` bit(1) NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sort` int(0) NULL DEFAULT NULL,
  `level` tinyint(0) NULL DEFAULT NULL,
  `enabled` tinyint(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '/system', 'Layout', '系统管理', '', 0, NULL, b'0', 'noredirect', b'1', 'el-icon-s-home', NULL, 1, 0, 1, '2021-10-08 17:09:05', '2021-10-08 17:09:05');
INSERT INTO `sys_menu` VALUES (2, 'user', 'user/index', '用户管理', '', 1, 1, b'0', '', b'1', 'el-icon-user', NULL, 2, 1, 1, '2021-11-15 14:08:47', '2021-11-15 14:08:47');
INSERT INTO `sys_menu` VALUES (3, 'role', 'role/index', '角色管理', '', 1, 1, b'0', '', b'1', 'el-icon-user-solid', NULL, 3, 1, 1, '2021-10-07 16:33:26', '2021-10-07 16:33:26');
INSERT INTO `sys_menu` VALUES (4, 'menu', 'menu/index', '菜单管理', '', 1, 1, b'0', '', b'1', 'el-icon-menu', NULL, 4, 1, 1, '2021-10-07 16:28:58', '2021-10-07 16:28:58');
INSERT INTO `sys_menu` VALUES (5, '/setting', 'Layout', '系统配置', NULL, NULL, NULL, NULL, NULL, NULL, 'el-icon-s-management', NULL, 2, NULL, 0, '2021-10-21 16:19:29', '2021-10-21 16:19:29');
INSERT INTO `sys_menu` VALUES (6, 'param', 'param/index', '参数设置', NULL, NULL, 5, NULL, NULL, NULL, 'el-icon-bicycle', NULL, 1, NULL, 0, '2022-11-11 08:45:05', '2022-11-11 08:45:05');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(0) NULL DEFAULT NULL,
  `menu_id` bigint(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 94 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `role_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `enabled` tinyint(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'admin', '管理员', '系统管理员角色', 1, '2022-11-09 16:48:11', '2022-11-10 16:27:13');
INSERT INTO `sys_role` VALUES (2, 'user', '普通用户', '普通用户', 1, '2022-11-09 16:26:43', '2022-11-10 16:27:19');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` int(0) NULL DEFAULT NULL COMMENT '0-未知 1-male 2-female',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `enabled` int(0) NULL DEFAULT 1 COMMENT '1-激活 0-禁用',
  `last_password_reset_time` datetime(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_name`(`user_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin@163.com', '$2a$10$RYaVoYbyBNyh3EwFzBQuau2.OJkrUc6HJ6KubOMcCrZmT0Zqj7KRm', 1, 'admin@163.com', 1, NULL, '2021-08-17 15:38:30', '2021-09-29 16:35:44');
INSERT INTO `sys_user` VALUES (2, 'user@163.com', '$2a$10$IwBWyl/qV6QWXbJ9QQ4iXuQctM..54V.NNH0k/RzuuCQ8x8IPbp1O', 2, 'user@163.com', 1, NULL, '2021-09-17 15:38:30', '2021-09-29 13:18:49');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(0) NULL DEFAULT NULL,
  `role_id` bigint(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
