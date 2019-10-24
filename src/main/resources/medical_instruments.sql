/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : medical_instruments

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 23/10/2019 22:57:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for access_stock
-- ----------------------------
DROP TABLE IF EXISTS `access_stock`;
CREATE TABLE `access_stock`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `single_no` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '单号',
  `s_type` tinyint(4) DEFAULT NULL COMMENT '出入库类型',
  `hc_no` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '耗材编号',
  `number` int(11) DEFAULT NULL COMMENT '数量',
  `amount` decimal(10, 2) DEFAULT NULL COMMENT '金额',
  `valid_date` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '对方单位',
  `in_or_out` tinyint(4) DEFAULT NULL COMMENT '入库或者出库',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime(0) DEFAULT NULL COMMENT '最后一次修改的时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of access_stock
-- ----------------------------
INSERT INTO `access_stock` VALUES (1, 'A001', 1, 'ASS003', 20, 20.00, NULL, 1, '2018-06-11 22:04:59', '2018-06-11 22:04:59');
INSERT INTO `access_stock` VALUES (2, 'A002', 2, 'ASS003', 10, 10.00, NULL, 1, '2018-06-11 22:05:24', '2018-06-11 22:05:24');
INSERT INTO `access_stock` VALUES (3, 'A002', 1, 'ASS002', 10, 100.00, NULL, 1, '2018-06-11 22:37:48', '2018-06-11 22:37:48');
INSERT INTO `access_stock` VALUES (4, 'A002', 1, 'ASS002', 10, 100.00, NULL, 1, '2018-06-11 22:37:55', '2018-06-11 22:37:55');
INSERT INTO `access_stock` VALUES (5, 'A002', 1, 'ASS004', 10, 0.00, NULL, 1, '2018-06-11 22:42:37', '2018-06-11 22:42:37');
INSERT INTO `access_stock` VALUES (6, 'A002', 1, 'ASS004', 10, 0.00, NULL, 1, '2018-06-11 22:42:45', '2018-06-11 22:42:45');
INSERT INTO `access_stock` VALUES (7, 'A002', 1, 'ASS004', 10, 0.00, NULL, 1, '2018-06-11 22:43:43', '2018-06-11 22:43:43');
INSERT INTO `access_stock` VALUES (8, 'A002', 1, 'ASS004', 10, 0.00, NULL, 1, '2018-06-11 22:46:35', '2018-06-11 22:46:35');
INSERT INTO `access_stock` VALUES (9, 'CK001', 3, 'ASS003', 12, 12.00, NULL, 2, '2018-06-11 23:07:00', '2018-06-11 23:07:00');
INSERT INTO `access_stock` VALUES (10, 'CK002', 4, 'ASS004', 2, 0.00, NULL, 2, '2018-06-11 23:08:17', '2018-06-11 23:08:17');
INSERT INTO `access_stock` VALUES (11, 'CK003', 3, 'ASS003', 5, 5.00, NULL, 2, '2018-06-11 23:09:43', '2018-06-11 23:09:43');
INSERT INTO `access_stock` VALUES (12, 'AS008', 3, 'ASS004', 20, 0.00, NULL, 2, '2018-06-14 20:45:19', '2018-06-14 20:45:19');
INSERT INTO `access_stock` VALUES (13, 'AA12', 1, 'ASS004', 30, 0.00, NULL, 1, '2018-06-14 21:02:17', '2018-06-14 21:02:17');
INSERT INTO `access_stock` VALUES (14, 'AS008', 3, 'ASS004', 3, 0.00, NULL, 2, '2018-06-14 21:48:45', '2018-06-14 21:48:45');
INSERT INTO `access_stock` VALUES (15, 'AS008', 3, 'ASS004', 3, 0.00, NULL, 2, '2018-06-14 21:49:16', '2018-06-14 21:49:16');
INSERT INTO `access_stock` VALUES (16, 'AS008', 3, 'ASS004', 3, 0.00, NULL, 2, '2018-06-14 21:49:43', '2018-06-14 21:49:43');
INSERT INTO `access_stock` VALUES (17, 'S25', 3, 'ASS004', 5, 0.00, NULL, 2, '2018-06-14 21:50:23', '2018-06-14 21:50:23');
INSERT INTO `access_stock` VALUES (18, 'ee44', 4, 'ASS003', 20, 20.00, NULL, 2, '2018-06-14 21:51:23', '2018-06-14 21:51:23');
INSERT INTO `access_stock` VALUES (19, '44', 3, 'ASS003', 2, 2.00, NULL, 2, '2018-06-14 21:51:54', '2018-06-14 21:51:54');
INSERT INTO `access_stock` VALUES (20, 'AA12', 1, 'ASS001', 130, 1560.00, NULL, 1, '2018-06-14 21:52:17', '2018-06-14 21:52:17');
INSERT INTO `access_stock` VALUES (21, 'AA12', 1, 'ASS001', 130, 1560.00, NULL, 1, '2018-06-14 21:52:19', '2018-06-14 21:52:19');
INSERT INTO `access_stock` VALUES (22, 'qq', 1, 'ASS003', 200, 200.00, NULL, 1, '2018-06-14 21:54:13', '2018-06-14 21:54:13');
INSERT INTO `access_stock` VALUES (23, 'qq', 1, 'ASS004', 200, 0.00, NULL, 1, '2018-06-14 21:54:21', '2018-06-14 21:54:21');
INSERT INTO `access_stock` VALUES (24, 'eee', 3, 'ASS003', 20, 20.00, NULL, 2, '2018-06-14 21:54:39', '2018-06-14 21:54:39');
INSERT INTO `access_stock` VALUES (25, 'eee', 3, 'ASS003', 20, 20.00, NULL, 2, '2018-06-14 21:55:00', '2018-06-14 21:55:00');
INSERT INTO `access_stock` VALUES (26, 'ee', 3, 'ASS004', 20, 0.00, NULL, 2, '2018-06-14 21:59:03', '2018-06-14 21:59:03');
INSERT INTO `access_stock` VALUES (27, 'ee', 3, 'ASS004', 20, 0.00, NULL, 2, '2018-06-14 21:59:34', '2018-06-14 21:59:34');
INSERT INTO `access_stock` VALUES (28, 'aa', 3, 'ASS004', 20, 0.00, NULL, 2, '2018-06-14 22:00:29', '2018-06-14 22:00:29');
INSERT INTO `access_stock` VALUES (29, 'll', 3, 'ASS003', 20, 20.00, NULL, 2, '2018-06-14 22:01:52', '2018-06-14 22:01:52');
INSERT INTO `access_stock` VALUES (30, 'll', 3, 'ASS004', 20, 0.00, NULL, 2, '2018-06-14 22:02:39', '2018-06-14 22:02:39');
INSERT INTO `access_stock` VALUES (31, 'll', 3, 'ASS003', 20, 20.00, NULL, 2, '2018-06-14 22:04:36', '2018-06-14 22:04:36');
INSERT INTO `access_stock` VALUES (32, 'll', 3, 'ASS003', 30, 30.00, NULL, 2, '2018-06-14 22:05:05', '2018-06-14 22:05:05');
INSERT INTO `access_stock` VALUES (33, 'AA', 3, 'ASS004', 31, 0.00, NULL, 2, '2018-06-14 22:11:56', '2018-06-14 22:11:56');
INSERT INTO `access_stock` VALUES (34, 'aa', 3, 'ASS004', 20, 0.00, NULL, 2, '2018-06-14 22:14:13', '2018-06-14 22:14:13');
INSERT INTO `access_stock` VALUES (35, 'ASS005', 1, 'ASS003', 12, 12.00, '江南皮革厂', 1, '2018-06-17 19:31:39', '2018-06-17 19:31:39');
INSERT INTO `access_stock` VALUES (36, 'CK001', 3, 'ASS003', 10, 10.00, '外一', 2, '2018-06-17 19:35:16', '2018-06-17 19:35:16');

-- ----------------------------
-- Table structure for contract
-- ----------------------------
DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `c_no` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '合同编码',
  `c_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '合同名称',
  `c_type` tinyint(4) DEFAULT NULL COMMENT '合同类型',
  `party_b` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '乙方单位',
  `b_contacts` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '乙方联系人',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '乙方联系人电话',
  `signed_date` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '签约日期',
  `end_date` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '截止日期',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '合同内容',
  `create_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `modified_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后一次修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of contract
-- ----------------------------
INSERT INTO `contract` VALUES (1, '001', '钢板100个', 1, '鞍钢', '橘子', '17688882222', '2018-06-11 10:54:48', '2019-06-10 00:00:00', '哈哈哈', '2018-06-11 10:54:48', '2018-06-11 10:54:48');
INSERT INTO `contract` VALUES (2, '002', '针管100个', 1, '江南皮革厂', '柿子', '17688882222', '2018-06-11 00:00:00', '2019-06-11 00:00:00', '哈哈哈', NULL, '2018-06-11 14:32:30');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `number` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '科室编号',
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '科室名称',
  `landline` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '座机',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  `create_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `modified_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后一次修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '001', '外一', '038-12457', 1, '2018-06-05 18:51:00', '2018-06-05 18:51:00');
INSERT INTO `department` VALUES (8, '003', '内一', '2323', 2, '2018-06-06 22:45:48', '2018-06-06 22:45:48');
INSERT INTO `department` VALUES (9, '002', '外二', '2333', 3, '2018-06-06 22:46:08', '2018-06-06 22:46:08');
INSERT INTO `department` VALUES (10, '007', '英国皇家特工', '1201-032154', 1, NULL, '2018-06-17 20:07:58');

-- ----------------------------
-- Table structure for department_stock
-- ----------------------------
DROP TABLE IF EXISTS `department_stock`;
CREATE TABLE `department_stock`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `no` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '编号',
  `stock` int(11) DEFAULT NULL COMMENT '库存',
  `department_no` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '科室编码',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime(0) DEFAULT NULL COMMENT '最后一次修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for device
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `device_no` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '设备编号',
  `device_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '设备名称',
  `unit` tinyint(4) DEFAULT NULL COMMENT '单位',
  `device_type` tinyint(4) DEFAULT NULL COMMENT '设备类型',
  `is_measurement` tinyint(4) DEFAULT NULL COMMENT '是否计量',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  `create_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `modified_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后一次修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of device
-- ----------------------------
INSERT INTO `device` VALUES (1, 'AS001', 'X线照射器', 1, 1, 1, 1, '2018-06-06 23:55:00', '2018-06-06 23:55:00');
INSERT INTO `device` VALUES (2, 'AS002', '数字化X摄影机', 2, 1, 1, 2, NULL, '2018-06-07 22:49:31');

-- ----------------------------
-- Table structure for public_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `public_dictionary`;
CREATE TABLE `public_dictionary`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `column_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '列值',
  `inside_value` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '内值',
  `exterior_value` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '外值',
  `demo` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime(0) DEFAULT NULL COMMENT '最后一次修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of public_dictionary
-- ----------------------------
INSERT INTO `public_dictionary` VALUES (3, 'unit', '1002', '箱', NULL, '2018-05-26 23:45:53', '2018-05-26 23:45:55');
INSERT INTO `public_dictionary` VALUES (4, 'unit', '1003', '件', NULL, '2018-05-26 23:45:53', '2018-05-26 23:45:55');
INSERT INTO `public_dictionary` VALUES (5, 'unit', '1004', '瓶', NULL, '2018-05-26 23:45:53', '2018-05-26 23:45:55');
INSERT INTO `public_dictionary` VALUES (6, 'unit', '1005', '袋', NULL, '2018-05-26 23:45:53', '2018-05-26 23:45:55');
INSERT INTO `public_dictionary` VALUES (7, 'unit', '1006', '台', NULL, '2018-05-26 23:45:53', '2018-05-26 23:45:55');
INSERT INTO `public_dictionary` VALUES (8, 'unit', '1007', '条', NULL, '2018-05-26 23:45:53', '2018-05-26 23:45:55');
INSERT INTO `public_dictionary` VALUES (9, 'unit', '1008', '扇', NULL, '2018-05-26 23:45:53', '2018-05-26 23:45:55');
INSERT INTO `public_dictionary` VALUES (10, 'unit', '1009', '桶', NULL, '2018-05-26 23:45:53', '2018-05-26 23:45:55');
INSERT INTO `public_dictionary` VALUES (11, 'unit', '1010', '包', NULL, '2018-05-26 23:45:53', '2018-05-26 23:45:55');
INSERT INTO `public_dictionary` VALUES (12, 'unit', '2002', '个', NULL, '2018-06-04 12:30:20', '2018-06-04 12:30:20');
INSERT INTO `public_dictionary` VALUES (13, 'unit', '2003', '哈', NULL, '2018-06-04 12:30:41', '2018-06-04 12:30:41');
INSERT INTO `public_dictionary` VALUES (14, 'unit', '2333', '哈哈哈哈', NULL, '2018-06-04 17:44:31', '2018-06-04 17:44:31');

-- ----------------------------
-- Table structure for stock
-- ----------------------------
DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `no` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '编号',
  `stock` int(11) DEFAULT NULL COMMENT '库存',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime(0) DEFAULT NULL COMMENT '最后一次修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stock
-- ----------------------------
INSERT INTO `stock` VALUES (1, 'ASS003', 93, '2018-06-11 20:12:00', '2018-06-17 19:35:16');
INSERT INTO `stock` VALUES (2, 'ASS004', 71, '2018-06-11 22:46:11', '2018-06-14 22:14:13');

-- ----------------------------
-- Table structure for supplies
-- ----------------------------
DROP TABLE IF EXISTS `supplies`;
CREATE TABLE `supplies`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `hc_no` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '耗材编号',
  `hc_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '耗材名字',
  `manafacturer` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '生产厂家',
  `hc_type` tinyint(4) DEFAULT NULL COMMENT '耗材类型',
  `unit` tinyint(4) DEFAULT NULL COMMENT '单位',
  `price` decimal(10, 2) DEFAULT NULL COMMENT '单价',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  `create_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `modified_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后一次修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of supplies
-- ----------------------------
INSERT INTO `supplies` VALUES (4, 'ASS003', '纱布', '北方纱布厂', 2, 2, 1.00, NULL, '2018-06-11 16:53:07', '2018-06-11 16:53:07');
INSERT INTO `supplies` VALUES (6, 'ASS004', '血袋', '义务献血车', 1, 3, 10.00, NULL, NULL, '2018-06-17 20:12:46');
INSERT INTO `supplies` VALUES (7, 'A001', '器械1', '厂家1', 1, 2, 10.00, NULL, '2018-06-18 20:47:05', '2018-06-18 20:47:05');
INSERT INTO `supplies` VALUES (8, 'A002', '器械2', '厂家2', 2, 1, 20.00, NULL, '2018-06-18 20:47:05', '2018-06-18 20:47:05');
INSERT INTO `supplies` VALUES (9, 'A003', '器械3', '厂家3', 3, 7, 30.00, NULL, '2018-06-18 20:47:05', '2018-06-18 20:47:05');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `login_account` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录账号',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '登录密码',
  `user_type` tinyint(4) DEFAULT NULL COMMENT '用户类型',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  `mobile` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机号',
  `email` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `department` bigint(20) DEFAULT NULL COMMENT '所属部门',
  `create_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `modified_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后一次修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '西游却东行', 'test', '1234', 1, 1, '17688882333', 'fhjava@163.com', 1, '2018-06-18 12:28:50', '2018-06-18 12:28:50');

-- ----------------------------
-- Table structure for vendor
-- ----------------------------
DROP TABLE IF EXISTS `vendor`;
CREATE TABLE `vendor`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `v_no` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '厂商编号',
  `v_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '厂商名称',
  `oibc` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '组织机构代码',
  `salesman` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '业务联系人',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '业务员电话',
  `v_type` tinyint(4) DEFAULT NULL COMMENT '厂商类型',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  `create_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `modified_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后一次修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vendor
-- ----------------------------
INSERT INTO `vendor` VALUES (1, '001', '江南皮革厂', '2323224', '柿子', '17688882222', NULL, 2, NULL, '2018-06-17 20:17:40');
INSERT INTO `vendor` VALUES (2, '002', '鞍钢', '23232242', '橘子', '17688882222', 2, 1, '2018-06-10 17:28:01', '2018-06-10 17:28:01');
INSERT INTO `vendor` VALUES (3, 'A001', '上海申安器械厂', '123542', '张三', '17688881111', NULL, 1, '2018-06-17 21:28:16', '2018-06-17 21:28:16');
INSERT INTO `vendor` VALUES (4, 'A002', '广州申安器械厂', '66548', '李四', '17688882222', NULL, 1, '2018-06-17 21:28:16', '2018-06-17 21:28:16');
INSERT INTO `vendor` VALUES (5, 'A003', '北京申安器械厂', '7845124', '王五', '17688883333', NULL, 1, '2018-06-17 21:28:16', '2018-06-17 21:28:16');
INSERT INTO `vendor` VALUES (6, 'A001', '上海申安器械厂', '123542', '张三', '17688881111', NULL, 1, '2018-06-17 21:30:58', '2018-06-17 21:30:58');
INSERT INTO `vendor` VALUES (7, 'A002', '广州申安器械厂', '66548', '李四', '17688882222', NULL, 1, '2018-06-17 21:30:58', '2018-06-17 21:30:58');
INSERT INTO `vendor` VALUES (8, 'A003', '北京申安器械厂', '7845124', '王五', '17688883333', NULL, 1, '2018-06-17 21:30:58', '2018-06-17 21:30:58');
INSERT INTO `vendor` VALUES (9, 'A001', '上海申安器械厂', '123542', '张三', '17688881111', NULL, 1, '2018-06-17 21:32:49', '2018-06-17 21:32:49');
INSERT INTO `vendor` VALUES (10, 'A002', '广州申安器械厂', '66548', '李四', '17688882222', NULL, 1, '2018-06-17 21:32:49', '2018-06-17 21:32:49');
INSERT INTO `vendor` VALUES (11, 'A003', '北京申安器械厂', '7845124', '王五', '17688883333', NULL, 1, '2018-06-17 21:32:49', '2018-06-17 21:32:49');
INSERT INTO `vendor` VALUES (12, 'A001', '上海申安器械厂', '123542', '张三', '17688881111', NULL, 1, '2018-06-17 21:34:07', '2018-06-17 21:34:07');
INSERT INTO `vendor` VALUES (13, 'A002', '广州申安器械厂', '66548', '李四', '17688882222', NULL, 1, '2018-06-17 21:34:07', '2018-06-17 21:34:07');
INSERT INTO `vendor` VALUES (14, 'A003', '北京申安器械厂', '7845124', '王五', '17688883333', NULL, 1, '2018-06-17 21:34:07', '2018-06-17 21:34:07');
INSERT INTO `vendor` VALUES (15, 'A001', '上海申安器械厂', '123542', '张三', '17688881111', NULL, 1, '2018-06-17 21:35:53', '2018-06-17 21:35:53');
INSERT INTO `vendor` VALUES (16, 'A002', '广州申安器械厂', '66548', '李四', '17688882222', NULL, 1, '2018-06-17 21:35:53', '2018-06-17 21:35:53');
INSERT INTO `vendor` VALUES (17, 'A003', '北京申安器械厂', '7845124', '王五', '17688883333', NULL, 1, '2018-06-17 21:35:53', '2018-06-17 21:35:53');

SET FOREIGN_KEY_CHECKS = 1;
