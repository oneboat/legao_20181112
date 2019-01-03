/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : db_legao

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2019-01-03 21:23:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for legao_classroom
-- ----------------------------
DROP TABLE IF EXISTS `legao_classroom`;
CREATE TABLE `legao_classroom` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '课室',
  `ageArea` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '年龄段',
  `responsePersonName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '负责人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of legao_classroom
-- ----------------------------
INSERT INTO `legao_classroom` VALUES ('1', 'A203', '3岁半', '小刘');

-- ----------------------------
-- Table structure for legao_course
-- ----------------------------
DROP TABLE IF EXISTS `legao_course`;
CREATE TABLE `legao_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `ageArea` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '年龄段',
  `teacherTools` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '教具',
  `courseTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '课时',
  `seriesID` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of legao_course
-- ----------------------------
INSERT INTO `legao_course` VALUES ('1', '机器人', '3-4岁', '机器人', '12.3', '1');

-- ----------------------------
-- Table structure for legao_date
-- ----------------------------
DROP TABLE IF EXISTS `legao_date`;
CREATE TABLE `legao_date` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `timeSection` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '时间段',
  `status` int(11) DEFAULT NULL COMMENT '1表示启用中，2表示停用',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of legao_date
-- ----------------------------
INSERT INTO `legao_date` VALUES ('1', '10:04 - 04:04', '2', '1');
INSERT INTO `legao_date` VALUES ('2', '04:04 - 05:04', '1', '1');
INSERT INTO `legao_date` VALUES ('3', '05:04 - 04:04', '1', '1');
INSERT INTO `legao_date` VALUES ('4', '12:04 - 04:04', '1', '1');
INSERT INTO `legao_date` VALUES ('5', '14:04 - 04:04', '1', '1');
INSERT INTO `legao_date` VALUES ('6', '04:04 - 04:04', '1', '对对对');
INSERT INTO `legao_date` VALUES ('7', '03:04 - 04:04', '1', '梵蒂冈地方');
INSERT INTO `legao_date` VALUES ('8', '05:04 - 04:04', '2', '啊实打实');
INSERT INTO `legao_date` VALUES ('9', '00:00 - 00:00', '1', '王企鹅');
INSERT INTO `legao_date` VALUES ('10', '02:02 - 02:02', '2', '王企鹅');
INSERT INTO `legao_date` VALUES ('11', '01:01 - 01:01', '1', '王企鹅');
INSERT INTO `legao_date` VALUES ('12', '05:05 - 05:05', '2', '王企鹅');

-- ----------------------------
-- Table structure for legao_employ
-- ----------------------------
DROP TABLE IF EXISTS `legao_employ`;
CREATE TABLE `legao_employ` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(1) DEFAULT NULL,
  `telphone` varchar(11) DEFAULT NULL,
  `birthday` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `entryDate` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '入职日期',
  `jobID` varchar(11) DEFAULT NULL COMMENT '关联legao_job表',
  `basicSalary` varchar(255) DEFAULT NULL COMMENT '基本工资',
  `fullWork` varchar(2) DEFAULT NULL COMMENT '是否全勤',
  `eatAllow` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '餐补',
  `classPay` varchar(255) DEFAULT NULL COMMENT '课时费',
  `allClassTime` varchar(11) DEFAULT NULL COMMENT '总课时',
  `extraPay` varchar(255) DEFAULT NULL COMMENT '提成',
  `area` varchar(255) DEFAULT NULL COMMENT '校区',
  `status` int(11) DEFAULT NULL COMMENT '1表在职，2表离职，3表其他',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of legao_employ
-- ----------------------------
INSERT INTO `legao_employ` VALUES ('1', '张三', '男', '15622186647', '2018-11-29 00:00:00', '2018-11-05 00:00:00', '8', '50000', '是', '230', '3000', '50', '4000', '惠州校区', '1');
INSERT INTO `legao_employ` VALUES ('2', '刘小', '女', '15622186647', '2018-11-18 20:01:34', '2018-11-18 20:00:29', '1', '50000', '是', '230', '3000', '50', '4000', '惠州校区', '1');
INSERT INTO `legao_employ` VALUES ('4', 'd', '男', '15622187742', '2018-12-08 00:00:00', '2018-12-08 00:00:00', '1', '111', '否', '无', '无', '无', '无', '----全部----', '1');

-- ----------------------------
-- Table structure for legao_follow
-- ----------------------------
DROP TABLE IF EXISTS `legao_follow`;
CREATE TABLE `legao_follow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学生名',
  `advisor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '顾问',
  `date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `mode` varchar(255) DEFAULT NULL COMMENT '跟进方式',
  `content` varchar(255) DEFAULT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of legao_follow
-- ----------------------------
INSERT INTO `legao_follow` VALUES ('1', '王三', '邓人名', '2018-12-01 23:25:36', '电话', '邀约');
INSERT INTO `legao_follow` VALUES ('2', '李四', '王小二2312', '2018-12-13 21:28:24', '电话', '邀约');

-- ----------------------------
-- Table structure for legao_job
-- ----------------------------
DROP TABLE IF EXISTS `legao_job`;
CREATE TABLE `legao_job` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `createDate` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of legao_job
-- ----------------------------
INSERT INTO `legao_job` VALUES ('1', '高级教师', '设计课程', '2018-12-01 22:31:06');
INSERT INTO `legao_job` VALUES ('8', 'dzx', 'dzx', '2018-11-28 20:41:54');

-- ----------------------------
-- Table structure for legao_relation
-- ----------------------------
DROP TABLE IF EXISTS `legao_relation`;
CREATE TABLE `legao_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `scheduleID` int(11) DEFAULT NULL COMMENT '排课id',
  `studentID` int(11) DEFAULT NULL COMMENT '学生id',
  `signInStatus` int(11) DEFAULT NULL COMMENT '签到状态：1准时，2迟到，3请假',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of legao_relation
-- ----------------------------
INSERT INTO `legao_relation` VALUES ('2', '1', '2', '2');
INSERT INTO `legao_relation` VALUES ('3', '1', '3', '2');
INSERT INTO `legao_relation` VALUES ('4', '1', '4', '2');
INSERT INTO `legao_relation` VALUES ('5', '28', '1', '1');
INSERT INTO `legao_relation` VALUES ('6', '28', '2', '1');
INSERT INTO `legao_relation` VALUES ('7', '28', '3', '1');
INSERT INTO `legao_relation` VALUES ('8', '28', '4', '1');
INSERT INTO `legao_relation` VALUES ('9', '31', '1', '1');
INSERT INTO `legao_relation` VALUES ('10', '31', '2', '1');
INSERT INTO `legao_relation` VALUES ('11', '31', '3', '1');
INSERT INTO `legao_relation` VALUES ('12', '31', '4', '1');
INSERT INTO `legao_relation` VALUES ('13', '32', '2', '1');
INSERT INTO `legao_relation` VALUES ('14', '32', '3', '1');
INSERT INTO `legao_relation` VALUES ('15', '32', '4', '1');
INSERT INTO `legao_relation` VALUES ('16', '33', '1', '3');
INSERT INTO `legao_relation` VALUES ('17', '33', '2', '3');
INSERT INTO `legao_relation` VALUES ('18', '33', '3', '3');

-- ----------------------------
-- Table structure for legao_schedule
-- ----------------------------
DROP TABLE IF EXISTS `legao_schedule`;
CREATE TABLE `legao_schedule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `schoolAreaID` int(11) DEFAULT NULL COMMENT '校区id',
  `dateID` int(11) DEFAULT NULL COMMENT '时间段id',
  `courseID` int(11) DEFAULT NULL COMMENT '课程id',
  `classroomID` int(11) DEFAULT NULL COMMENT '课室id',
  `seriesID` int(11) DEFAULT NULL COMMENT '课程系列id',
  `courseDate` date DEFAULT NULL COMMENT '排课日期',
  `courseWeek` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '本节课在本周周几，周日是1，以此类推',
  `teacherName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '老师',
  `weekOfYear` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of legao_schedule
-- ----------------------------
INSERT INTO `legao_schedule` VALUES ('1', '1', '2', '1', '1', '1', '2018-12-23', '1', '刘小', '52');
INSERT INTO `legao_schedule` VALUES ('3', '1', '4', '1', '1', '2', '2018-12-12', '4', '刘小', '50');
INSERT INTO `legao_schedule` VALUES ('4', '1', '4', '1', '1', '1', '2018-12-26', '4', '刘小', '52');
INSERT INTO `legao_schedule` VALUES ('5', '1', '5', '1', '1', '1', '2018-12-27', '5', '刘小', '52');
INSERT INTO `legao_schedule` VALUES ('6', '1', '6', '1', '1', '1', '2018-12-28', '6', '张萌萌', '52');
INSERT INTO `legao_schedule` VALUES ('7', '1', '7', '1', '1', '1', '2018-12-29', '7', '刘小', '52');
INSERT INTO `legao_schedule` VALUES ('8', '1', '4', '1', '1', '1', '2018-12-30', '1', '刘小', '1');
INSERT INTO `legao_schedule` VALUES ('9', '1', '5', '1', '1', '1', '2018-12-31', '2', '刘小', '1');
INSERT INTO `legao_schedule` VALUES ('11', '1', '2', '1', '1', '1', '2018-12-30', '1', '刘小', '1');
INSERT INTO `legao_schedule` VALUES ('12', '1', '2', '1', '1', '2', '2018-12-24', '1', '刘小', '52');
INSERT INTO `legao_schedule` VALUES ('14', '1', '2', '1', '1', '1', '2018-12-30', '1', '刘小', '1');
INSERT INTO `legao_schedule` VALUES ('15', '1', '7', '1', '1', '1', '2018-12-28', '6', 'd', '52');
INSERT INTO `legao_schedule` VALUES ('16', '2', '7', '1', '1', '1', '2018-12-28', '6', 'd', '52');
INSERT INTO `legao_schedule` VALUES ('17', '6', '2', '1', '1', '1', '2018-12-24', '2', '刘小', '52');
INSERT INTO `legao_schedule` VALUES ('18', '2', '3', '1', '1', '1', '2018-12-24', '2', '刘小', '52');
INSERT INTO `legao_schedule` VALUES ('19', '1', '5', '1', '1', '1', '2018-12-30', '1', '刘小', '1');
INSERT INTO `legao_schedule` VALUES ('20', '1', '4', '1', '1', '1', '2018-12-30', '1', '刘小', '1');
INSERT INTO `legao_schedule` VALUES ('21', '1', '5', '1', '1', '1', '2018-12-31', '2', '刘小', '1');
INSERT INTO `legao_schedule` VALUES ('22', '1', '3', '1', '1', '1', '2018-12-30', '1', '刘小', '1');
INSERT INTO `legao_schedule` VALUES ('23', '2', '6', '1', '1', '1', '2018-12-31', '2', '刘小', '1');
INSERT INTO `legao_schedule` VALUES ('24', '1', '1', '1', '1', '1', '2018-12-23', '1', '刘小', '52');
INSERT INTO `legao_schedule` VALUES ('28', '1', '1', '1', '1', '1', '2018-12-23', '1', '刘小', '52');
INSERT INTO `legao_schedule` VALUES ('29', '1', '1', '1', '1', '1', '2018-12-23', '1', '刘小', '52');
INSERT INTO `legao_schedule` VALUES ('31', '1', '1', '1', '1', '1', '2018-12-23', '1', '刘小', '52');
INSERT INTO `legao_schedule` VALUES ('32', '1', '2', '1', '1', '1', '2018-12-31', '2', '刘小', '1');
INSERT INTO `legao_schedule` VALUES ('33', '2', '7', '1', '1', '1', '2019-01-02', '4', '刘小', '1');

-- ----------------------------
-- Table structure for legao_schoolarea
-- ----------------------------
DROP TABLE IF EXISTS `legao_schoolarea`;
CREATE TABLE `legao_schoolarea` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '校区名',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '地址',
  `responPersonName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '负责人姓名',
  `telphone` varchar(255) DEFAULT NULL COMMENT '联系电话',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of legao_schoolarea
-- ----------------------------
INSERT INTO `legao_schoolarea` VALUES ('1', '惠州校区', '惠城区东阳街220号', '刘小', '15622176645');
INSERT INTO `legao_schoolarea` VALUES ('2', '深圳', '深圳福田', '邓振祥', '15622187742');
INSERT INTO `legao_schoolarea` VALUES ('6', '罗湖校区', '深圳罗湖', '张小小', '15622187742');

-- ----------------------------
-- Table structure for legao_series
-- ----------------------------
DROP TABLE IF EXISTS `legao_series`;
CREATE TABLE `legao_series` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `teacherTools` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '教具',
  `courseTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '课时',
  `ageArea` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '年龄段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of legao_series
-- ----------------------------
INSERT INTO `legao_series` VALUES ('1', '机器人系列', '机器人，乐高战机', '12.4', '4岁半');
INSERT INTO `legao_series` VALUES ('2', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for legao_student
-- ----------------------------
DROP TABLE IF EXISTS `legao_student`;
CREATE TABLE `legao_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nickName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '昵称',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '姓名',
  `parentName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '家长姓名',
  `parentRelat` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '家长关系',
  `sex` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '性别',
  `telphone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '手机号码',
  `weChatID` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '微信号',
  `education` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `birthday` timestamp NULL DEFAULT NULL,
  `createDate` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '录入日期',
  `sparePhone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '备用电话',
  `markPeople` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '市场人员',
  `advisor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '顾问',
  `area` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '地区',
  `willDate` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '意向时间',
  `baseSituation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '基本情况',
  `status` int(11) DEFAULT NULL COMMENT '学生状态：1代表新客户，2代表试听客户，3代表号码无效客户，4其他',
  `source` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '学生来源',
  `importanceGrade` int(11) DEFAULT NULL COMMENT '重要程度：1代表重点，2代表优质，3会员，4一般，5放弃，6未知',
  `teacherName` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '老师姓名',
  `courseID` int(11) DEFAULT NULL COMMENT '学生选择的课程系列id',
  `schoolAreaID` int(11) DEFAULT NULL COMMENT '校区id,管理到legao_schoolArea表',
  `followID` int(11) DEFAULT NULL COMMENT '跟进人员id，关联到legao_followPeople',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of legao_student
-- ----------------------------
INSERT INTO `legao_student` VALUES ('1', '小四', '李四', '李刚', '父子', '男', '15622187742', '279518467', '硕士', '1995-04-18 00:00:00', '2018-12-15 15:32:23', '无', '赵小二', '何猷君', '惠州校区', '2018-12-15 15:32:23', '很活泼', '1', '店内', '1', '张三', '1', '1', '1');
INSERT INTO `legao_student` VALUES ('2', '小三', '王三', '王刚', '母子', '女', '13822187742', '279518467', '本科', '2017-09-18 13:23:24', '2018-12-23 16:37:37', '无', '赵小二', '何于', '惠州校区', '2018-12-23 16:37:37', '很活泼', '2', '店内', '2', '刘小', '2', '1', '1');
INSERT INTO `legao_student` VALUES ('3', '无', '1', '1', '无', '男', '15622187742', '无', '无', '2018-11-26 00:00:00', '2018-12-23 16:37:39', '无', '无', '无', '无', '2018-12-23 16:37:39', '无', '1', '1', '1', '张三', '1', '1', '1');
INSERT INTO `legao_student` VALUES ('4', '1', '1', '1', '1', '男', '15622187742', '1', '1', '2018-12-15 00:00:00', '2018-12-23 16:37:41', '1', '无', '11', '1', '2018-12-23 16:37:41', '1', '1', '1', '1', '刘小', '2', '1', '1');

-- ----------------------------
-- Table structure for legao_user
-- ----------------------------
DROP TABLE IF EXISTS `legao_user`;
CREATE TABLE `legao_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` int(2) DEFAULT NULL,
  `createDate` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `selectStudentFields` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '学生模块选择了哪些字段显示',
  `selectEmployFields` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of legao_user
-- ----------------------------
INSERT INTO `legao_user` VALUES ('11', 'sxl', 'd3e3a9203e2a2b56f63260118448b00b', '1', '2018-11-13 22:16:03', null, null);
INSERT INTO `legao_user` VALUES ('13', 'dzx123', '05dec077316d4b085df5d34987d5f7fe', '1', '2018-11-14 13:14:54', null, null);
INSERT INTO `legao_user` VALUES ('14', 'dzx', 'e2687a7e9df77a71a4d9382066b3d787', '1', '2019-01-02 14:58:15', '[9,10,11,12,13,14]', '[0,1,2,4,5,6]');
INSERT INTO `legao_user` VALUES ('15', '1', 'e2687a7e9df77a71a4d9382066b3d787', '1', '2018-11-14 13:17:44', null, null);
INSERT INTO `legao_user` VALUES ('16', '232432', '107dcdb8e15795f25e10da846b72b8b3', '1', '2018-11-14 13:17:49', null, null);
INSERT INTO `legao_user` VALUES ('17', '123213', '492ab0b70d2a80fa9221e87438b8867f', '1', '2018-11-14 13:17:52', null, null);
INSERT INTO `legao_user` VALUES ('18', '123123', 'b3447b91e4460915799bc9f28d57d2ab', '1', '2018-11-14 13:25:32', null, null);
INSERT INTO `legao_user` VALUES ('19', 'dfsdf', '62264c5565dd5961a0843136d05ae84a', '1', '2018-11-14 13:23:19', null, null);
INSERT INTO `legao_user` VALUES ('20', '3123', 'e5f8ded52516f49e0d8c99a2b4d6a3bb', '1', '2018-11-14 13:23:25', null, null);
INSERT INTO `legao_user` VALUES ('21', '123123123', '492ab0b70d2a80fa9221e87438b8867f', '1', '2018-11-14 13:23:29', null, null);
INSERT INTO `legao_user` VALUES ('22', '12312312312', '492ab0b70d2a80fa9221e87438b8867f', '1', '2018-11-14 13:23:34', null, null);
INSERT INTO `legao_user` VALUES ('23', 'asdasd', 'd02bfdb6585786bf1c7d8e0ea5093ab6', '2', '2018-11-15 14:03:01', null, null);
INSERT INTO `legao_user` VALUES ('24', 'dsasdasdad', '966882824ea1f908690949e5fe1238d1', '2', '2018-11-15 14:03:09', null, null);
INSERT INTO `legao_user` VALUES ('25', 'asdasdasdas', '8e2fccdd95d345d5e3f6e2b2c99e825c', '2', '2018-11-15 14:03:13', null, null);
INSERT INTO `legao_user` VALUES ('26', '12312', '7ba7142252fc9fb5fde8cefdbea96b58', '2', '2018-11-15 14:03:19', null, null);
INSERT INTO `legao_user` VALUES ('27', '31231231', '60566a53d206430c60672753db53dffd', '2', '2018-11-15 14:03:24', null, null);
INSERT INTO `legao_user` VALUES ('28', '12312312', '7ba7142252fc9fb5fde8cefdbea96b58', '2', '2018-11-15 14:03:29', null, null);
INSERT INTO `legao_user` VALUES ('29', '12312312312123123', 'ab909d6b37d04cf963d768dd90b36415', '2', '2018-11-15 14:03:42', null, null);
INSERT INTO `legao_user` VALUES ('30', '345345', '4aed5c9382699d31b6be8de01edbad73', '2', '2018-11-15 14:03:47', null, null);
INSERT INTO `legao_user` VALUES ('31', '345345534', 'a3f576e42f3f14f1399cdb545b0d0b29', '2', '2018-11-15 14:03:53', null, null);
INSERT INTO `legao_user` VALUES ('32', '657567', '256124da88d08f358ec0c3bf687ebde3', '2', '2018-11-15 14:04:01', null, null);
INSERT INTO `legao_user` VALUES ('33', '65756', 'da491519adb34ecfb89813df76244440', '2', '2018-11-15 14:04:05', null, null);
