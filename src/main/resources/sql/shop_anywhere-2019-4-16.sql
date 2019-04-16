/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : 127.0.0.1:3306
 Source Schema         : shop_anywhere

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 16/04/2019 10:55:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for attribute
-- ----------------------------
DROP TABLE IF EXISTS `attribute`;
CREATE TABLE `attribute`  (
  `aid` bigint(36) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `model_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '模型id',
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '附加属性id',
  `type` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '字段类型',
  `name` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '字段名称',
  PRIMARY KEY (`aid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for belong
-- ----------------------------
DROP TABLE IF EXISTS `belong`;
CREATE TABLE `belong`  (
  `aid` bigint(36) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '创始人id',
  `store_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '店铺id',
  PRIMARY KEY (`aid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for buy
-- ----------------------------
DROP TABLE IF EXISTS `buy`;
CREATE TABLE `buy`  (
  `aid` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '用户id',
  `entity_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '实体id',
  `use_leased_card_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '使用卡的id,不能用卡或者没有用卡,此字段为空',
  `date` datetime(0) NOT NULL COMMENT '购买日期',
  PRIMARY KEY (`aid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of buy
-- ----------------------------
INSERT INTO `buy` VALUES (1, 'test', 'test', NULL, '2019-04-15 21:17:40');

-- ----------------------------
-- Table structure for card
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card`  (
  `aid` bigint(36) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '发行卡id',
  `user_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '发行人id',
  `issue_time` datetime(0) NOT NULL COMMENT '发行时间',
  `issue_version` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '发行版本',
  `grade` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '发行卡等级，如:金,银,铜',
  `dr` tinyint(1) NULL DEFAULT NULL COMMENT '1逻辑删除，0不删除',
  PRIMARY KEY (`aid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for entity
-- ----------------------------
DROP TABLE IF EXISTS `entity`;
CREATE TABLE `entity`  (
  `aid` bigint(36) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `module_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '模型id',
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '实体id',
  `produce_date` datetime(0) NOT NULL COMMENT '生产日期',
  `warranty_expiration_date` datetime(0) NULL DEFAULT NULL COMMENT '保修到期时间',
  `guarantee` tinyint(1) NULL DEFAULT NULL COMMENT '是否保修',
  `selled` tinyint(1) NOT NULL COMMENT '是否被售出,1被售出,0未被售出',
  `selled_price` decimal(5, 2) NULL DEFAULT NULL COMMENT '被售出时的价格,未被售出时该字段为空',
  PRIMARY KEY (`aid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for have
-- ----------------------------
DROP TABLE IF EXISTS `have`;
CREATE TABLE `have`  (
  `aid` bigint(36) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `store_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '店铺id',
  `entity_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '实例id',
  PRIMARY KEY (`aid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for leased_card
-- ----------------------------
DROP TABLE IF EXISTS `leased_card`;
CREATE TABLE `leased_card`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `card_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '发行卡id',
  `type` int(1) NOT NULL COMMENT '0表示次数卡,1表示时间卡',
  `available_times` int(5) NULL DEFAULT NULL COMMENT '可用次数,时间卡的可用次数为-1',
  `expiration_date` datetime(0) NULL DEFAULT NULL COMMENT '过期时间,次数卡的过期时间为null',
  `rent` decimal(5, 2) NULL DEFAULT NULL COMMENT '租金',
  `tenant_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '租户id,来源于user表',
  `rental_time` datetime(0) NULL DEFAULT NULL COMMENT '租赁时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for model
-- ----------------------------
DROP TABLE IF EXISTS `model`;
CREATE TABLE `model`  (
  `aid` bigint(36) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '模型id',
  `name` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '名称',
  `brand` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '品牌',
  `size` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '大小,如:10*10*10，单位cm3',
  `msrp` decimal(5, 2) NOT NULL COMMENT '制造商建议零售价',
  `color` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '颜色',
  `material` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '材质',
  PRIMARY KEY (`aid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store`  (
  `aid` bigint(36) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '店铺id',
  `size` int(5) NULL DEFAULT NULL COMMENT '店铺大小\r/m2',
  `localtion` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '店铺地点',
  `base64image` varchar(10000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '店面印象',
  `scope` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '经营范围',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '注册时间',
  `dr` tinyint(1) NULL DEFAULT NULL COMMENT '1逻辑删除，0不删除',
  PRIMARY KEY (`aid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `aid` bigint(36) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '用户id',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '用户头像',
  `openid` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '腾讯openid可唯一标识一个QQ用户',
  `uid` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '新浪微博uid可唯一标识一个微博用户',
  `face_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '百度人脸用户id',
  `face_group` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '百度人脸用户组',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '用户名',
  `gender` char(2) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '性别',
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '用户类型',
  `mobile` char(11) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '手机号',
  `email` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '邮箱',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '密码',
  `membership_expire_time` datetime(0) NULL DEFAULT NULL COMMENT '会员到期时间',
  `last_login_ip` varchar(17) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '最近一次登录IP',
  `last_login_date` datetime(0) NULL DEFAULT NULL COMMENT '最近一次登录日期',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `dr` tinyint(1) NULL DEFAULT NULL COMMENT '1逻辑删除，0不删除',
  PRIMARY KEY (`aid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '04a2536f-0f4a-11e9-8f01-309c23fd150a', 'http://tvax4.sinaimg.cn/crop.0.0.40.40.1024/007kSlJUly8fvkiv7not8j3014014dfl.jpg', NULL, '6721409826', NULL, NULL, '炼龙45391', '男', '生产者', NULL, NULL, NULL, NULL, '192.168.43.1', '2019-01-03 19:23:30', '2019-01-03 19:23:30', '2019-01-03 19:23:30', 0);
INSERT INTO `user` VALUES (2, '09416f29-0f4c-11e9-8f01-309c23fd150a', 'http://thirdqq.qlogo.cn/qqapp/1108058960/5598F91CDB94E18A90251CADB389B42F/100', '5598F91CDB94E18A90251CADB389B42F', NULL, NULL, NULL, '炼龙', '男', NULL, NULL, NULL, NULL, NULL, '192.168.43.1', '2019-01-03 19:37:57', '2019-01-03 19:37:57', '2019-01-03 19:37:57', 0);

-- ----------------------------
-- Table structure for value
-- ----------------------------
DROP TABLE IF EXISTS `value`;
CREATE TABLE `value`  (
  `aid` bigint(36) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `attribute_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '附加属性id',
  `value` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '附加属性值',
  PRIMARY KEY (`aid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
