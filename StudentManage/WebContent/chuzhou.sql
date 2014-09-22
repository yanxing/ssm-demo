/*
Navicat MySQL Data Transfer

Source Server         : liyanxing-PC
Source Server Version : 50521
Source Host           : localhost:3306
Source Database       : chuzhou

Target Server Type    : MYSQL
Target Server Version : 50521
File Encoding         : 65001

Date: 2014-09-22 23:25:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `table_admin`
-- ----------------------------
DROP TABLE IF EXISTS `table_admin`;
CREATE TABLE `table_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of table_admin
-- ----------------------------
INSERT INTO `table_admin` VALUES ('1', 'admin', '111111');

-- ----------------------------
-- Table structure for `table_class`
-- ----------------------------
DROP TABLE IF EXISTS `table_class`;
CREATE TABLE `table_class` (
  `class_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(255) DEFAULT NULL,
  `class_counselor` varchar(255) DEFAULT NULL,
  `professional_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`class_id`),
  KEY `professional_id` (`professional_id`),
  CONSTRAINT `professional_id` FOREIGN KEY (`professional_id`) REFERENCES `table_professional` (`professional_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of table_class
-- ----------------------------
INSERT INTO `table_class` VALUES ('1', '计科1班', '马良', '1');
INSERT INTO `table_class` VALUES ('2', '计科2班', '马良', '1');
INSERT INTO `table_class` VALUES ('3', '网工1班', '程辉', '2');

-- ----------------------------
-- Table structure for `table_department`
-- ----------------------------
DROP TABLE IF EXISTS `table_department`;
CREATE TABLE `table_department` (
  `department_id` int(11) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of table_department
-- ----------------------------
INSERT INTO `table_department` VALUES ('1', '计算机与信息工程学院');

-- ----------------------------
-- Table structure for `table_professional`
-- ----------------------------
DROP TABLE IF EXISTS `table_professional`;
CREATE TABLE `table_professional` (
  `professional_id` int(11) NOT NULL AUTO_INCREMENT,
  `professional_name` varchar(255) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`professional_id`),
  KEY `department_id` (`department_id`),
  CONSTRAINT `department_id` FOREIGN KEY (`department_id`) REFERENCES `table_department` (`department_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of table_professional
-- ----------------------------
INSERT INTO `table_professional` VALUES ('1', '计算机科学与技术', '1');
INSERT INTO `table_professional` VALUES ('2', '网络工程', '1');

-- ----------------------------
-- Table structure for `table_student`
-- ----------------------------
DROP TABLE IF EXISTS `table_student`;
CREATE TABLE `table_student` (
  `student_id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `student_number` varchar(255) DEFAULT NULL,
  `student_name` varchar(255) DEFAULT NULL,
  `student_password` varchar(255) DEFAULT NULL,
  `student_sex` varchar(255) DEFAULT NULL,
  `student_birth` datetime DEFAULT NULL,
  `student_phone` varchar(255) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  KEY `class_id` (`class_id`),
  CONSTRAINT `class_id` FOREIGN KEY (`class_id`) REFERENCES `table_class` (`class_id`) ON DELETE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of table_student
-- ----------------------------
INSERT INTO `table_student` VALUES ('0000000001', '001', '张三 ', '000000', '男', '2014-09-19 00:00:00', '11111111111', '2');
INSERT INTO `table_student` VALUES ('0000000002', '002', '李四', '000000', '男', '2014-09-01 21:08:28', '11111111111', '1');
INSERT INTO `table_student` VALUES ('0000000003', '003', '王二', '000000', '男', '2014-09-01 21:09:33', '11111111111', '2');
INSERT INTO `table_student` VALUES ('0000000004', '004', 'yanxing', '000000', '女', '2014-09-01 21:11:42', '11111111111', '2');
INSERT INTO `table_student` VALUES ('0000000005', '005 ', 'lyxtime ', '000000', '女', '2014-09-01 00:00:00', '11111111111', '3');
INSERT INTO `table_student` VALUES ('0000000006', '006 ', 'time ', '000000', '女', '2014-09-01 00:00:00', '11111111111', '3');
INSERT INTO `table_student` VALUES ('0000000010', '009  ', 'student ', '000000', '男', '2014-09-02 00:00:00', '11111111111', '1');
INSERT INTO `table_student` VALUES ('0000000012', '888888 ', 'studnet00', '000000', '男', '2014-09-11 00:00:00', '18255032152', '2');
INSERT INTO `table_student` VALUES ('0000000013', ' 33', ' 33', '000000', '男', null, '18255032152', '1');
INSERT INTO `table_student` VALUES ('0000000014', '4444', ' 444', '000000', '男', '2014-09-05 00:00:00', '18255032152', '1');
INSERT INTO `table_student` VALUES ('0000000015', '88888', '77', '000000', '男', '2014-09-19 00:00:00', '', '2');
