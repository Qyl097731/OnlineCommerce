/*
Navicat MySQL Data Transfer

Source Server         : qiuyiliang
Source Server Version : 50729
Source Host           : localhost:3306
Source Database       : db_database12

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-12-09 11:41:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_auser`
-- ----------------------------
DROP TABLE IF EXISTS `tb_auser`;
CREATE TABLE `tb_auser` (
  `aname` varchar(50) NOT NULL,
  `apwd` varchar(50) NOT NULL,
  PRIMARY KEY (`aname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_auser
-- ----------------------------
INSERT INTO `tb_auser` VALUES ('admin', '123456');

-- ----------------------------
-- Table structure for `tb_buser`
-- ----------------------------
DROP TABLE IF EXISTS `tb_buser`;
CREATE TABLE `tb_buser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bemail` varchar(50) NOT NULL,
  `bpwd` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_buser
-- ----------------------------
INSERT INTO `tb_buser` VALUES ('5', '553579046@qq.com', '123456');
INSERT INTO `tb_buser` VALUES ('7', '553579049@qq.com', '123456');
INSERT INTO `tb_buser` VALUES ('8', '553579050@qq.com', '123456');
INSERT INTO `tb_buser` VALUES ('9', '553579051@qq.com', '123456');
INSERT INTO `tb_buser` VALUES ('10', '553579032@qq.com', '123456');
INSERT INTO `tb_buser` VALUES ('11', '553579011@qq.com', '123456');

-- ----------------------------
-- Table structure for `tb_cart`
-- ----------------------------
DROP TABLE IF EXISTS `tb_cart`;
CREATE TABLE `tb_cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `busertable_id` int(11) NOT NULL,
  `goodstable_id` int(11) NOT NULL,
  `shoppinggnum` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `busertb1_id` (`busertable_id`),
  KEY `goodstb1_id` (`goodstable_id`),
  CONSTRAINT `busertb1_id` FOREIGN KEY (`busertable_id`) REFERENCES `tb_buser` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `goodstb1_id` FOREIGN KEY (`goodstable_id`) REFERENCES `tb_goods` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_cart
-- ----------------------------
INSERT INTO `tb_cart` VALUES ('15', '10', '20', '2');

-- ----------------------------
-- Table structure for `tb_focus`
-- ----------------------------
DROP TABLE IF EXISTS `tb_focus`;
CREATE TABLE `tb_focus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodstable_id` int(11) NOT NULL,
  `busertable_id` int(11) NOT NULL,
  `focustime` datetime NOT NULL,
  `gpicture` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `goodstb_id` (`goodstable_id`),
  KEY `busertb_id` (`busertable_id`),
  CONSTRAINT `busertb_id` FOREIGN KEY (`busertable_id`) REFERENCES `tb_buser` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `goodstb_id` FOREIGN KEY (`goodstable_id`) REFERENCES `tb_goods` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_focus
-- ----------------------------
INSERT INTO `tb_focus` VALUES ('1', '20', '10', '2020-12-07 17:41:08', null);
INSERT INTO `tb_focus` VALUES ('2', '16', '10', '2020-12-08 01:44:05', null);
INSERT INTO `tb_focus` VALUES ('3', '19', '10', '2020-12-08 02:22:36', '20201206220521401.png');
INSERT INTO `tb_focus` VALUES ('4', '15', '10', '2020-12-08 13:58:46', '20201206220456935.png');
INSERT INTO `tb_focus` VALUES ('5', '22', '10', '2020-12-09 01:12:32', '20201208143053441.png');

-- ----------------------------
-- Table structure for `tb_goods`
-- ----------------------------
DROP TABLE IF EXISTS `tb_goods`;
CREATE TABLE `tb_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gname` varchar(50) NOT NULL,
  `goprice` double NOT NULL,
  `grprice` double DEFAULT NULL,
  `gstore` int(11) NOT NULL,
  `gpicture` varchar(50) DEFAULT NULL,
  `gtype_id` int(11) NOT NULL,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `goodstype_id` (`gtype_id`),
  CONSTRAINT `goodstype_id` FOREIGN KEY (`gtype_id`) REFERENCES `tb_goodstype` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_goods
-- ----------------------------
INSERT INTO `tb_goods` VALUES ('13', 'PUMA芥末绿复古老爹鞋', '200', '100', '100', '20201206220439617.png', '2', '芥末绿色的鞋面视觉上给人一种清新感');
INSERT INTO `tb_goods` VALUES ('14', '肖优秀真皮细高跟过膝瘦腿弹力靴', '458', '388', '99', '20201206220450508.png', '2', '细跟尖头设计更显优雅女人味。');
INSERT INTO `tb_goods` VALUES ('15', 'lancome兰蔻皮革红管哑光口红507/粉金管278/473/481/888/274/196', '245', '245', '99', '20201206220456935.png', '5', '雾面质感暗红色管身，优雅而高贵。');
INSERT INTO `tb_goods` VALUES ('16', 'The North Face舒适经典保暖帽', '199', '100', '499', '20201206220507453.png', '2', 'The NorthFace®与咸狗豆豆一起让您在木板路上保持舒适。');
INSERT INTO `tb_goods` VALUES ('19', '港风纯色打底衫男', '100', '98', '494', '20201206220521401.png', '2', '简洁大方的纯色T恤，真的好穿搭单品\r\n');
INSERT INTO `tb_goods` VALUES ('20', '三只松鼠_坚果大礼包1393g/7袋', '300', '157', '4987', '20201206220618428.png', '1', '坚果礼系列, 和生活一样多姿多彩 和生活一样多姿多彩');
INSERT INTO `tb_goods` VALUES ('21', '秋冬男士卫裤宽松束脚裤韩版潮流运动裤百搭潮牌休闲裤加绒加厚', '248', '168', '2000', '20201208142833026.png', '2', '非一般针织面料，新材料哦! ! 非一般针织面料。  ');
INSERT INTO `tb_goods` VALUES ('22', '戒之馆婴亲霜湿痒婴儿疹子膏儿童露宝宝护肤品口水润肤霜婴宝面霜', '149', '89', '99999', '20201208143053441.png', '6', '专为湿痒宝宝肌肤设计  戒之馆.婴幼肌肤护理霜');
INSERT INTO `tb_goods` VALUES ('23', 'ework办公桌椅组合简约现代办公室工作位2/4/6人员工位电脑桌家具', '1438', '719', '20000', '20201208143429528.png', '9', '上市7年，不停迭代，只为更优的办公体验 ');

-- ----------------------------
-- Table structure for `tb_goodstype`
-- ----------------------------
DROP TABLE IF EXISTS `tb_goodstype`;
CREATE TABLE `tb_goodstype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typename` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_goodstype
-- ----------------------------
INSERT INTO `tb_goodstype` VALUES ('1', '零食');
INSERT INTO `tb_goodstype` VALUES ('2', '服装');
INSERT INTO `tb_goodstype` VALUES ('4', '家用电器');
INSERT INTO `tb_goodstype` VALUES ('5', '化妆品');
INSERT INTO `tb_goodstype` VALUES ('6', '孕婴');
INSERT INTO `tb_goodstype` VALUES ('7', '水果');
INSERT INTO `tb_goodstype` VALUES ('8', '电子产品');
INSERT INTO `tb_goodstype` VALUES ('9', '办公用品');
INSERT INTO `tb_goodstype` VALUES ('10', '建材');
INSERT INTO `tb_goodstype` VALUES ('11', '汽车');

-- ----------------------------
-- Table structure for `tb_notice`
-- ----------------------------
DROP TABLE IF EXISTS `tb_notice`;
CREATE TABLE `tb_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ntitle` varchar(255) NOT NULL,
  `ncontent` varchar(255) NOT NULL,
  `ntime` date DEFAULT NULL,
  `npicture` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_notice
-- ----------------------------
INSERT INTO `tb_notice` VALUES ('4', 'Jordan官方旗舰店', '当经典遇见未来', '2020-12-08', '20201208013641912.png');
INSERT INTO `tb_notice` VALUES ('5', '引领潮流', '这个冬天穿搭不愁', '2020-12-08', '20201208013744697.jpg');
INSERT INTO `tb_notice` VALUES ('6', '日系服装店', '国外潮搭', '2020-12-08', '20201208013817672.png');

-- ----------------------------
-- Table structure for `tb_orderbase`
-- ----------------------------
DROP TABLE IF EXISTS `tb_orderbase`;
CREATE TABLE `tb_orderbase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `busertable_id` int(11) NOT NULL,
  `amount` double NOT NULL,
  `status` tinyint(4) NOT NULL,
  `orderdate` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `busertb2_tb` (`busertable_id`),
  CONSTRAINT `busertb2_tb` FOREIGN KEY (`busertable_id`) REFERENCES `tb_buser` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_orderbase
-- ----------------------------
INSERT INTO `tb_orderbase` VALUES ('1', '5', '0', '0', '2020-12-06 19:38:05');
INSERT INTO `tb_orderbase` VALUES ('2', '5', '0', '1', '2020-12-06 19:38:21');
INSERT INTO `tb_orderbase` VALUES ('11', '10', '510', '1', '2020-12-08 01:11:29');
INSERT INTO `tb_orderbase` VALUES ('23', '10', '245', '1', '2020-12-08 13:59:21');
INSERT INTO `tb_orderbase` VALUES ('24', '11', '89', '1', '2020-12-08 14:35:18');

-- ----------------------------
-- Table structure for `tb_orderdetail`
-- ----------------------------
DROP TABLE IF EXISTS `tb_orderdetail`;
CREATE TABLE `tb_orderdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderbasetable_id` int(11) NOT NULL,
  `goodstable_id` int(11) NOT NULL,
  `shoppingnum` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `orderbasetb_id` (`orderbasetable_id`),
  KEY `goodstb3_id` (`goodstable_id`),
  CONSTRAINT `goodstb3_id` FOREIGN KEY (`goodstable_id`) REFERENCES `tb_goods` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `orderbasetb_id` FOREIGN KEY (`orderbasetable_id`) REFERENCES `tb_orderbase` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_orderdetail
-- ----------------------------
INSERT INTO `tb_orderdetail` VALUES ('1', '1', '13', '10');
INSERT INTO `tb_orderdetail` VALUES ('2', '2', '13', '10');
INSERT INTO `tb_orderdetail` VALUES ('3', '11', '19', '2');
INSERT INTO `tb_orderdetail` VALUES ('15', '23', '15', '1');
INSERT INTO `tb_orderdetail` VALUES ('16', '24', '22', '1');
