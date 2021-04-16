/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : day0412

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2021-04-12 21:28:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for coach
-- ----------------------------
DROP TABLE IF EXISTS `coach`;
CREATE TABLE `coach` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `c_birth` date DEFAULT NULL,
  `c_sex` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of coach
-- ----------------------------
INSERT INTO `coach` VALUES ('1', '王大春', '2021-04-01', '男');
INSERT INTO `coach` VALUES ('2', '孙一伤', '2021-04-07', '男');
INSERT INTO `coach` VALUES ('3', '田二败', '2021-04-28', '男');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `r_id` int(11) NOT NULL AUTO_INCREMENT,
  `r_date` date DEFAULT NULL,
  `r_duration` int(11) DEFAULT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('1', '2021-04-12', '15');
INSERT INTO `record` VALUES ('2', '2021-04-01', '15');
INSERT INTO `record` VALUES ('3', '2021-04-13', '12');

-- ----------------------------
-- Table structure for record_subject
-- ----------------------------
DROP TABLE IF EXISTS `record_subject`;
CREATE TABLE `record_subject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `record_id` int(11) NOT NULL,
  `subject_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of record_subject
-- ----------------------------
INSERT INTO `record_subject` VALUES ('1', '1', '2');
INSERT INTO `record_subject` VALUES ('2', '2', '2');
INSERT INTO `record_subject` VALUES ('3', '3', '2');

-- ----------------------------
-- Table structure for record_trainee
-- ----------------------------
DROP TABLE IF EXISTS `record_trainee`;
CREATE TABLE `record_trainee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `record_id` int(11) NOT NULL,
  `trainee_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of record_trainee
-- ----------------------------
INSERT INTO `record_trainee` VALUES ('1', '1', '1');
INSERT INTO `record_trainee` VALUES ('2', '2', '2');
INSERT INTO `record_trainee` VALUES ('3', '3', '3');

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `s_duration` int(11) DEFAULT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of subject
-- ----------------------------
INSERT INTO `subject` VALUES ('1', '科目一', '10');
INSERT INTO `subject` VALUES ('2', '科目二', '20');
INSERT INTO `subject` VALUES ('3', '科目三', '30');

-- ----------------------------
-- Table structure for trainee
-- ----------------------------
DROP TABLE IF EXISTS `trainee`;
CREATE TABLE `trainee` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `t_sex` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `t_age` int(11) DEFAULT NULL,
  `t_inDate` date DEFAULT NULL,
  `coach_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of trainee
-- ----------------------------
INSERT INTO `trainee` VALUES ('1', '张三', '男', '22', '2021-04-12', '1');
INSERT INTO `trainee` VALUES ('2', '李四', '男', '19', '2021-04-07', '1');
INSERT INTO `trainee` VALUES ('3', '王丽', '女', '24', '2021-04-14', '2');
