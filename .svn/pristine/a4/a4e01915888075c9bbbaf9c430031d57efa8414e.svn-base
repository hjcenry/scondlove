/*
Navicat MySQL Data Transfer

Source Server         : 192.168.6.119
Source Server Version : 50527
Source Host           : 192.168.6.119:3306
Source Database       : predestinedlove

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2014-12-12 18:04:45
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `bazaarclassify`
-- ----------------------------
DROP TABLE IF EXISTS `bazaarclassify`;
CREATE TABLE `bazaarclassify` (
  `classify_id` varchar(40) NOT NULL COMMENT '分类id',
  `classify_name` varchar(100) NOT NULL COMMENT '分类名称',
  `realtype` int(2) DEFAULT '1' COMMENT '分类业务类型（1.二手市场）',
  `create_user` varchar(40) DEFAULT NULL COMMENT '分类创建人id',
  `create_time` datetime DEFAULT NULL COMMENT '分类创建时间',
  `update_user` varchar(40) DEFAULT NULL COMMENT '分类修改人id',
  `update_time` datetime DEFAULT NULL COMMENT '分类修改时间',
  `status` int(2) NOT NULL DEFAULT '1' COMMENT '分类使用状态（1使用中）',
  PRIMARY KEY (`classify_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bazaarclassify
-- ----------------------------
INSERT INTO bazaarclassify VALUES ('1', '旅游', '1', '1', '2014-12-05 16:38:54', '1', '2014-12-05 16:38:54', '1');
INSERT INTO bazaarclassify VALUES ('2', '美食', '1', '1', '2014-12-05 16:38:54', '1', '2014-12-05 16:38:54', '1');
INSERT INTO bazaarclassify VALUES ('3', '健身', '1', '1', '2014-12-05 16:38:54', '1', '2014-12-05 16:38:54', '1');
INSERT INTO bazaarclassify VALUES ('4', '其他', '1', '1', '2014-12-05 16:38:54', '1', '2014-12-05 16:38:54', '1');

-- ----------------------------
-- Table structure for `deal_message`
-- ----------------------------
DROP TABLE IF EXISTS `deal_message`;
CREATE TABLE `deal_message` (
  `deal_id` varchar(40) NOT NULL COMMENT '活动id',
  `deal_title` varchar(100) DEFAULT NULL COMMENT '活动名称',
  `deal_desc` varchar(255) DEFAULT NULL COMMENT '活动描述',
  `deal_image` varchar(100) DEFAULT NULL COMMENT '活动图片',
  `deal_time` datetime DEFAULT NULL COMMENT '活动时间',
  `deal_type` int(2) DEFAULT NULL COMMENT '活动类型（1.找王子，2找公主）',
  `classify_id` varchar(40) NOT NULL COMMENT '分类id',
  `deal_status` int(2) DEFAULT NULL COMMENT '活动状态（0.关闭，1.打开，2.完成）',
  `create_user` varchar(40) DEFAULT NULL COMMENT '活动创建人id',
  `create_time` datetime DEFAULT NULL COMMENT '活动创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '活动修改时间',
  `status` int(2) unsigned zerofill NOT NULL DEFAULT '01' COMMENT '活动编辑状态（0.草稿，1.发布）',
  PRIMARY KEY (`deal_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of deal_message
-- ----------------------------
INSERT INTO deal_message VALUES ('0b6f0349-f97f-4b44-913b-3dd1908052c9', '1', '1', '/images/goods/26421417770093173.JPG', null, '1', '1', '1', '1', '2014-12-05 16:54:25', '2014-12-05 16:54:25', '01');
INSERT INTO deal_message VALUES ('1', '是如何aweg啊额和阿任个人色如果热水何社会色', '色若何合适', '/images/goods/26421417770093173.JPG', null, '1', '1', '1', '1', '2014-12-05 16:35:20', '2014-12-05 16:35:24', '01');
INSERT INTO deal_message VALUES ('15676bda-8200-4f26-8c1f-2ebceac3ed95', '可以的不错', '喜欢就好其它什么也没有', '418180717463.jpg', null, '1', '9', '1', '1', '2014-12-10 11:10:14', '2014-12-10 11:10:14', '01');
INSERT INTO deal_message VALUES ('2', '深入骨髓如何', '啊问题', '', null, '2', '2', '1', '1', '2014-12-07 17:18:44', '2014-12-05 17:18:47', '01');
INSERT INTO deal_message VALUES ('999d0865-ac8b-43c4-a3bd-14b9b51d7c52', '宝贝', '宝贝宝贝宝贝宝贝', null, null, '2', '3', '1', '1', '2014-12-09 19:39:48', '2014-12-09 19:39:48', '01');
INSERT INTO deal_message VALUES ('f557f17c-a5eb-4021-ab51-a795839ec514', '手机', '手机手机手机手机', '1418124726646.JPG', null, '1', '1', '1', '1', '2014-12-09 19:39:27', '2014-12-09 19:39:27', '01');

-- ----------------------------
-- Table structure for `deal_pay`
-- ----------------------------
DROP TABLE IF EXISTS `deal_pay`;
CREATE TABLE `deal_pay` (
  `pay_id` varchar(100) NOT NULL COMMENT '出价id',
  `deal_id` varchar(40) NOT NULL COMMENT '活动id',
  `pay_image` varchar(100) DEFAULT NULL COMMENT '活动图片',
  `offer_desc` varchar(255) DEFAULT NULL COMMENT '出价备注',
  `telphone` varchar(20) DEFAULT NULL COMMENT '出价人联系方式',
  `deal_desc` varchar(255) DEFAULT NULL COMMENT '处理备注',
  `create_user` varchar(40) DEFAULT NULL COMMENT '出价人id',
  `create_time` datetime DEFAULT NULL COMMENT '出价时间',
  `deal_user` varchar(40) DEFAULT NULL COMMENT '出价处理人',
  `deal_time` datetime DEFAULT NULL COMMENT '出价处理时间',
  `deal_status` int(2) DEFAULT '0' COMMENT '出价处理状态（0.未处理，1.已处理 同意）',
  PRIMARY KEY (`pay_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of deal_pay
-- ----------------------------
INSERT INTO deal_pay VALUES ('0b6438c1-3057-4d68-ace6-2c34c0b5cb31', '82d971fb-b8bb-41d9-ab7a-dca044d2197c', '/images/goods/3571418123704993.JPG', '187349003876', '18734900386', 'nihao ', '1', '2014-12-09 19:22:19', '2', '2014-12-09 19:28:08', '1');
INSERT INTO deal_pay VALUES ('1', 'f0efaf9e-f621-4fb6-b0bc-d35ee6bbb016', null, '我愿意出价2000', '18734900386', '', '2', '2014-12-08 16:08:14', '1', '2014-12-08 16:15:13', '0');
INSERT INTO deal_pay VALUES ('2', 'f0efaf9e-f621-4fb6-b0bc-d35ee6bbb016', null, '我愿意出价3000', '18734900386', '同意', '3', '2014-12-08 15:14:43', '1', '2014-12-08 16:14:40', '1');
INSERT INTO deal_pay VALUES ('2544714b-3eae-4374-90a4-c27c68a7673c', 'f557f17c-a5eb-4021-ab51-a795839ec514', '/images/goods/34201418124802695.JPG', '好对的额', '18734900386', '好', '3', '2014-12-09 19:40:37', '1', '2014-12-09 19:41:33', '1');
INSERT INTO deal_pay VALUES ('3056535f-d13e-40d4-9812-ce43ee007a37', '999d0865-ac8b-43c4-a3bd-14b9b51d7c52', null, '', '18734900386', '你好', '3', '2014-12-09 19:41:09', '1', '2014-12-09 19:41:53', '1');
INSERT INTO deal_pay VALUES ('6dbe77da-277c-400f-95b9-6669d6d16c36', '82d971fb-b8bb-41d9-ab7a-dca044d2197c', null, '', '18734900386', null, '1', '2014-12-09 19:20:44', null, null, '0');
INSERT INTO deal_pay VALUES ('ca251e14-25f0-4a34-a55e-9c946ee66c84', '15676bda-8200-4f26-8c1f-2ebceac3ed95', '/images/goods/43671418196771485.JPG', '20', '18734900386', 'tongyi ', '2', '2014-12-10 15:40:24', '1', '2014-12-10 15:40:59', '1');

-- ----------------------------
-- Table structure for `reply_message`
-- ----------------------------
DROP TABLE IF EXISTS `reply_message`;
CREATE TABLE `reply_message` (
  `reply_id` varchar(40) NOT NULL COMMENT '回复id',
  `reply_content` varchar(255) DEFAULT NULL COMMENT '回复内容',
  `deal_id` varchar(40) NOT NULL COMMENT '交易id',
  `create_user` varchar(40) DEFAULT NULL COMMENT '回复创建人id',
  `create_time` datetime DEFAULT NULL COMMENT '回复创建时间',
  `status` int(2) NOT NULL DEFAULT '1',
  PRIMARY KEY (`reply_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reply_message
-- ----------------------------
INSERT INTO reply_message VALUES ('1', '我出2000可否？', 'f0efaf9e-f621-4fb6-b0bc-d35ee6bbb016', '2', '2014-12-08 16:05:13', '1');
INSERT INTO reply_message VALUES ('2', '@马里奥 好的', 'f0efaf9e-f621-4fb6-b0bc-d35ee6bbb016', '3', '2014-12-08 16:12:29', '1');
INSERT INTO reply_message VALUES ('236988aa-b1e2-49b9-a6ad-8b09144d080a', '@阿斯顿 不好', '82d971fb-b8bb-41d9-ab7a-dca044d2197c', '1', '2014-12-09 18:38:05', '1');
INSERT INTO reply_message VALUES ('23cb884b-ba76-4838-a05d-9a99122c7712', '@马里奥 红红火火', '999d0865-ac8b-43c4-a3bd-14b9b51d7c52', '1', '2014-12-10 11:28:21', '1');
INSERT INTO reply_message VALUES ('26640c11-047d-4ad8-9d98-b78614cfe0ba', '@奥拉夫 nihao', '82d971fb-b8bb-41d9-ab7a-dca044d2197c', '2', '2014-12-09 19:28:19', '1');
INSERT INTO reply_message VALUES ('2c2565c4-0c8f-47df-9d44-670602727f64', '@阿斯顿 哈哈哈', '999d0865-ac8b-43c4-a3bd-14b9b51d7c52', '1', '2014-12-10 11:27:52', '1');
INSERT INTO reply_message VALUES ('3', '@奥拉夫 不行', 'f0efaf9e-f621-4fb6-b0bc-d35ee6bbb016', '1', '2014-12-08 17:05:39', '1');
INSERT INTO reply_message VALUES ('308df01d-a512-4500-9c37-b0005c7067da', '不好', 'f0efaf9e-f621-4fb6-b0bc-d35ee6bbb016', '1', '2014-12-09 15:10:47', '1');
INSERT INTO reply_message VALUES ('37d73874-7089-47e1-9669-3102f3d37642', '@阿斯顿 凝固', 'f557f17c-a5eb-4021-ab51-a795839ec514', '1', '2014-12-10 11:07:49', '1');
INSERT INTO reply_message VALUES ('3bd2eed0-f173-4c6a-8c6b-73b2f2b088c6', '@奥拉夫 你好', 'f0efaf9e-f621-4fb6-b0bc-d35ee6bbb016', '1', '2014-12-09 15:10:07', '1');
INSERT INTO reply_message VALUES ('57839666-a471-4fe2-8b0e-6a578033fd69', '不好吧', 'f0efaf9e-f621-4fb6-b0bc-d35ee6bbb016', '2', '2014-12-09 16:16:18', '1');
INSERT INTO reply_message VALUES ('594c6a34-f4bb-462c-8b28-f290833de85a', '@奥拉夫 你好', 'f0efaf9e-f621-4fb6-b0bc-d35ee6bbb016', '1', '2014-12-09 15:20:33', '1');
INSERT INTO reply_message VALUES ('617f33f3-90d7-413f-b33f-c7d954e0c9f5', '@马里奥 啊啊啊', 'f557f17c-a5eb-4021-ab51-a795839ec514', '1', '2014-12-10 11:08:15', '1');
INSERT INTO reply_message VALUES ('73a91434-d7b7-4ed3-ba4d-c0b5098bee90', '@马里奥 好的', 'f557f17c-a5eb-4021-ab51-a795839ec514', '1', '2014-12-09 19:41:42', '1');
INSERT INTO reply_message VALUES ('830f6162-22aa-44d4-a6a1-94b22d53385f', '好的', 'f557f17c-a5eb-4021-ab51-a795839ec514', '3', '2014-12-09 19:40:48', '1');
INSERT INTO reply_message VALUES ('99e125dd-83c4-4bcd-bb42-e1c8ef3c782e', '你好', '82d971fb-b8bb-41d9-ab7a-dca044d2197c', '1', '2014-12-09 18:37:57', '1');
INSERT INTO reply_message VALUES ('9d672286-7868-48e7-9c5a-d74d12a3f035', '@阿斯顿 hao ', '82d971fb-b8bb-41d9-ab7a-dca044d2197c', '2', '2014-12-09 19:28:33', '1');
INSERT INTO reply_message VALUES ('a875a947-d836-4e65-9f68-517fe18145cd', '@马里奥 甩甩手', '999d0865-ac8b-43c4-a3bd-14b9b51d7c52', '1', '2014-12-09 19:41:58', '1');
INSERT INTO reply_message VALUES ('c121772b-e98f-403f-bf2e-b4aa7baba136', '@马里奥 就好', 'f0efaf9e-f621-4fb6-b0bc-d35ee6bbb016', '1', '2014-12-09 15:21:34', '1');
INSERT INTO reply_message VALUES ('ce944831-08ee-4ba6-8758-82a7332373c7', '@阿斯顿 哈哈哈哈哈哈哈哈', '999d0865-ac8b-43c4-a3bd-14b9b51d7c52', '1', '2014-12-10 11:28:07', '1');
INSERT INTO reply_message VALUES ('cfafab9b-942f-412e-8629-8e5fb8f9e5a7', '@阿斯顿 嘿嘿', '999d0865-ac8b-43c4-a3bd-14b9b51d7c52', '1', '2014-12-10 11:27:14', '1');
INSERT INTO reply_message VALUES ('e11cd35e-241a-48f7-9051-d3a680fdf9aa', '你好', '999d0865-ac8b-43c4-a3bd-14b9b51d7c52', '3', '2014-12-09 19:41:15', '1');
INSERT INTO reply_message VALUES ('f3432a85-c0d2-4d8d-8a33-45a7a724f06b', '@阿斯顿 好的', '82d971fb-b8bb-41d9-ab7a-dca044d2197c', '2', '2014-12-09 18:45:51', '1');
INSERT INTO reply_message VALUES ('fb17c252-4f02-443e-8b9a-093a3271aca5', '@阿斯顿 也好', 'f0efaf9e-f621-4fb6-b0bc-d35ee6bbb016', '2', '2014-12-09 16:16:32', '1');

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `username` varchar(128) NOT NULL,
  `password` varchar(500) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updatetime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO tb_user VALUES ('1', '2', 'admin', 'admin', 'O0XverE04xc=', '2014-11-25 15:55:39', '2014-11-25 14:31:19');
INSERT INTO tb_user VALUES ('2', '2', 'root', 'root', 'O0XverE04xc=', '2014-12-08 14:55:46', '2014-12-08 14:55:49');
INSERT INTO tb_user VALUES ('3', '3', 'hao', 'hao', 'O0XverE04xc=', '2014-12-08 16:24:19', '2014-12-08 16:16:28');

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` varchar(40) NOT NULL COMMENT '用户id',
  `user_name` varchar(40) DEFAULT NULL COMMENT '用户名',
  `nickname` varchar(240) DEFAULT NULL COMMENT '昵称',
  `user_image` varchar(100) DEFAULT NULL COMMENT '用户头像',
  `user_sex` int(2) DEFAULT '1' COMMENT '用户性别（1.男，2.女，3.保密）',
  `telphone` varchar(20) DEFAULT NULL COMMENT '联系方式',
  `create_time` datetime DEFAULT NULL COMMENT '用户创建时间',
  `status` int(2) DEFAULT '1' COMMENT '用户状态',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `marrystatus` int(4) DEFAULT NULL COMMENT '婚姻状态(0未婚1离婚2丧偶)',
  `height` int(6) DEFAULT NULL COMMENT '身高',
  `education` varchar(250) DEFAULT NULL COMMENT '学历',
  `monthly` varchar(120) DEFAULT NULL COMMENT '月薪',
  `province` varchar(120) DEFAULT NULL COMMENT '省',
  `city` varchar(120) DEFAULT NULL COMMENT '区域',
  `marrytype` int(2) DEFAULT NULL COMMENT '情缘状态(0示完善1完善)',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO user_info VALUES ('1', '阿斯顿', null, 'http://s0.hao123img.com/index/images/weather/icon/a0.png', '1', '11111111111', '2014-12-05 16:42:04', '1', null, null, null, null, null, null, null, '0');
INSERT INTO user_info VALUES ('2', '奥拉夫', null, 'http://img6.hao123.com/data/1_e5c6bddf8c972228b87765f508a03b6b_0', '1', '18734900384', '2014-12-08 14:55:06', '1', null, null, null, null, null, null, null, '0');
INSERT INTO user_info VALUES ('3', '马里奥', null, 'http://img6.hao123.com/data/1_201bb69dd46a06224b8ca69dab05b292_510', '1', '18734900384', '2014-12-08 16:16:04', '1', null, null, null, null, null, null, null, '0');
INSERT INTO user_info VALUES ('3778b134-2b34-4908-b9e0-9353785f9a93', 'lipx1', null, '/upload/54b5be62-14cd-4f63-b606-3c4c1d4882ab.jpg', null, null, '2014-12-12 09:44:31', '0', null, null, null, null, null, null, null, null);
