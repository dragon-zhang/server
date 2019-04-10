/*
MySQL Backup
Database: shop_anywhere
Backup Time: 2019-01-20 13:19:09
*/

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `shop_anywhere`.`attribute`;
DROP TABLE IF EXISTS `shop_anywhere`.`belong`;
DROP TABLE IF EXISTS `shop_anywhere`.`card`;
DROP TABLE IF EXISTS `shop_anywhere`.`entity`;
DROP TABLE IF EXISTS `shop_anywhere`.`have`;
DROP TABLE IF EXISTS `shop_anywhere`.`model`;
DROP TABLE IF EXISTS `shop_anywhere`.`store`;
DROP TABLE IF EXISTS `shop_anywhere`.`user`;
DROP TABLE IF EXISTS `shop_anywhere`.`value`;
CREATE TABLE `attribute` (
  `aid` bigint(36) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `model_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '模型id',
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '附加属性id',
  `type` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '字段类型',
  `name` varchar(36) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '字段名称',
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
CREATE TABLE `belong` (
  `aid` bigint(36) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '创始人id',
  `store_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '店铺id',
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
CREATE TABLE `card` (
  `aid` bigint(36) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '发行id',
  `user_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '发行人id',
  `issue_time` datetime DEFAULT NULL COMMENT '发行时间',
  `issue_version` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '发行版本',
  `grade` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '发行卡等级，如:金,银,铜',
  `dr` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '1逻辑删除，0不删除',
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
CREATE TABLE `entity` (
  `aid` bigint(36) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `module_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '模型id',
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '实体id',
  `store_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '店铺id',
  `produce_date` datetime DEFAULT NULL COMMENT '生产日期',
  `warranty_expiration_date` datetime DEFAULT NULL COMMENT '保修到期时间',
  `guarantee` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '是否保修',
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
CREATE TABLE `have` (
  `aid` bigint(36) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `store_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '店铺id',
  `module_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '模型id',
  `count` int(10) DEFAULT NULL COMMENT '拥有该类商品的数量',
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
CREATE TABLE `model` (
  `aid` bigint(36) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '模型id',
  `name` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '名称',
  `brand` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '品牌',
  `size` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '大小,如:10*10*10，单位cm3',
  `msrp` int(5) DEFAULT NULL COMMENT '制造商建议零售价',
  `color` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '颜色',
  `material` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '材质',
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
CREATE TABLE `store` (
  `aid` bigint(36) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '店铺id',
  `size` int(5) DEFAULT NULL COMMENT '店铺大小\r/m2',
  `localtion` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '店铺地点',
  `base64image` varchar(10000) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '店面印象',
  `scope` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '经营范围',
  `dr` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '1逻辑删除，0不删除',
  `create_time` datetime DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
CREATE TABLE `user` (
  `aid` bigint(36) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户id',
  `avatar` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户头像',
  `openid` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '腾讯openid可唯一标识一个QQ用户',
  `uid` varchar(36) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '新浪微博uid可唯一标识一个微博用户',
  `face_id` varchar(36) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '百度人脸用户id',
  `face_group` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '百度人脸用户组',
  `name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户名',
  `gender` char(2) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '性别',
  `type` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户类型',
  `mobile` char(11) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '手机号',
  `email` varchar(36) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `password` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '密码',
  `membership_expire_time` datetime DEFAULT NULL COMMENT '会员到期时间',
  `last_login_ip` varchar(17) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '最近一次登录IP',
  `last_login_date` datetime DEFAULT NULL COMMENT '最近一次登录日期',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `dr` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '1逻辑删除，0不删除',
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
CREATE TABLE `value` (
  `aid` bigint(36) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `attribute_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '附加属性id',
  `value` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '附加属性值',
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
BEGIN;
LOCK TABLES `shop_anywhere`.`attribute` WRITE;
DELETE FROM `shop_anywhere`.`attribute`;
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `shop_anywhere`.`belong` WRITE;
DELETE FROM `shop_anywhere`.`belong`;
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `shop_anywhere`.`card` WRITE;
DELETE FROM `shop_anywhere`.`card`;
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `shop_anywhere`.`entity` WRITE;
DELETE FROM `shop_anywhere`.`entity`;
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `shop_anywhere`.`have` WRITE;
DELETE FROM `shop_anywhere`.`have`;
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `shop_anywhere`.`model` WRITE;
DELETE FROM `shop_anywhere`.`model`;
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `shop_anywhere`.`store` WRITE;
DELETE FROM `shop_anywhere`.`store`;
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `shop_anywhere`.`user` WRITE;
DELETE FROM `shop_anywhere`.`user`;
INSERT INTO `shop_anywhere`.`user` (`aid`,`id`,`avatar`,`openid`,`uid`,`face_id`,`face_group`,`name`,`gender`,`type`,`mobile`,`email`,`password`,`membership_expire_time`,`last_login_ip`,`last_login_date`,`create_time`,`update_time`,`dr`) VALUES (1, '04a2536f-0f4a-11e9-8f01-309c23fd150a', 'http://tvax4.sinaimg.cn/crop.0.0.40.40.1024/007kSlJUly8fvkiv7not8j3014014dfl.jpg', NULL, '6721409826', NULL, NULL, '炼龙45391', '男', NULL, NULL, NULL, NULL, NULL, '192.168.43.1', '2019-01-03 19:23:30', '2019-01-03 19:23:30', '2019-01-03 19:23:30', '0'),(2, '09416f29-0f4c-11e9-8f01-309c23fd150a', 'http://thirdqq.qlogo.cn/qqapp/1108058960/5598F91CDB94E18A90251CADB389B42F/100', '5598F91CDB94E18A90251CADB389B42F', NULL, NULL, NULL, '炼龙', '男', NULL, NULL, NULL, NULL, NULL, '192.168.43.1', '2019-01-03 19:37:57', '2019-01-03 19:37:57', '2019-01-03 19:37:57', '0');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `shop_anywhere`.`value` WRITE;
DELETE FROM `shop_anywhere`.`value`;
UNLOCK TABLES;
COMMIT;
