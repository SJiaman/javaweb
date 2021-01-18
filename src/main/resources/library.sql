/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : library

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 22/12/2020 19:12:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `adminId` int(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`adminId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 123457 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (123456, '123456', 'admin');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `bookId` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `author` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `publish` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `isbn` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `language` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` double(10, 2) NOT NULL,
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `number` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`bookId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, '大雪中的山庄', '东野圭吾 ', '北京十月文艺出版社', '9787530216835', '中文', 35.00, '文学', 1);
INSERT INTO `book` VALUES (2, '三生三世 十里桃花', '唐七公子 ', '沈阳出版社', '9787544138000', '中文', 26.80, '文化', 1);
INSERT INTO `book` VALUES (3, '何以笙箫默', '顾漫 ', '朝华出版社', '9787505414709', '中文', 15.00, '文化', 1);
INSERT INTO `book` VALUES (4, '11处特工皇妃', '潇湘冬儿', '江苏文艺出版社', '9787539943893', '中文', 74.80, '文化', 1);
INSERT INTO `book` VALUES (5, '人类简史', '[以色列] 尤瓦尔·赫拉利 ', '中信出版社', '9787508647357', '英文', 68.00, '文学', 1);
INSERT INTO `book` VALUES (6, '明朝那些事儿（1-9）', '当年明月 ', '中国海关出版社', '9787801656087', '中文', 358.20, '文学', 12);
INSERT INTO `book` VALUES (7, '经济学原理（上下）', '[美] 曼昆 ', '机械工业出版社', '9787111126768', '英文', 88.00, '经济', 1);
INSERT INTO `book` VALUES (9, '画的秘密', '马克-安托万·马修 ', '北京联合出版公司·后浪出版公司', '9787550265608', '中文', 60.00, '文学', 12);
INSERT INTO `book` VALUES (10, '造彩虹的人', '东野圭吾 ', '北京十月文艺出版社', '9787530216859', '中文', 39.50, '文学', 1);
INSERT INTO `book` VALUES (12, '少有人走的路', 'M·斯科特·派克 ', '吉林文史出版社', '9787807023777', '中文', 26.00, '文学', 1);
INSERT INTO `book` VALUES (13, '追寻生命的意义', '[奥] 维克多·弗兰克 ', '新华出版社', '9787501162734', '中文', 12.00, '文学', 0);
INSERT INTO `book` VALUES (14, '秘密花园', '乔汉娜·贝斯福 ', '北京联合出版公司', '9787550252585', '中文', 42.00, '文学', 1);
INSERT INTO `book` VALUES (16, '菜鸟', '菜鸟哥', '任命出版社', '1232', '英文', 1231.00, '计算机', 213);
INSERT INTO `book` VALUES (17, '张三', 'dsa', '张三', '199984312', '中文', 1.00, '张三', 1);
INSERT INTO `book` VALUES (18, 'Python', 'dsa', 'adsd', '1232', 'dasd', 1231.00, 'asd', 12);
INSERT INTO `book` VALUES (19, '菜鸟', 'dsa', 'adsd', '1232', 'dasd', 1231.00, 'asd', 213);

-- ----------------------------
-- Table structure for borrow
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow`  (
  `borrowId` int(20) NOT NULL AUTO_INCREMENT,
  `bookId` int(20) NOT NULL,
  `readerId` int(20) NOT NULL,
  `lendDate` date NULL DEFAULT NULL,
  `backDate` date NULL DEFAULT NULL,
  PRIMARY KEY (`borrowId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of borrow
-- ----------------------------
INSERT INTO `borrow` VALUES (1, 1, 10000, '2017-03-15', '2017-06-16');
INSERT INTO `borrow` VALUES (2, 2, 10001, '2017-06-10', '2017-09-02');
INSERT INTO `borrow` VALUES (3, 3, 10003, '2017-06-12', '2017-09-02');
INSERT INTO `borrow` VALUES (4, 4, 10000, '2017-03-15', '2017-09-03');
INSERT INTO `borrow` VALUES (5, 5, 10002, '2017-06-15', NULL);
INSERT INTO `borrow` VALUES (6, 6, 10000, '2017-06-15', NULL);
INSERT INTO `borrow` VALUES (7, 1, 10001, '2017-09-02', '2017-09-02');

-- ----------------------------
-- Table structure for reader
-- ----------------------------
DROP TABLE IF EXISTS `reader`;
CREATE TABLE `reader`  (
  `readerId` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `birth` date NOT NULL,
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`readerId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10006 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reader
-- ----------------------------
INSERT INTO `reader` VALUES (10000, '张华', '男', '1995-06-10', '天津市', '12345678900', '123456');
INSERT INTO `reader` VALUES (10001, '王小伟', '男', '1996-02-01', '北京市', '12345678909', '123456');
INSERT INTO `reader` VALUES (10002, '王莞尔', '女', '1995-04-15', '浙江省杭州市', '12345678908', '123456');
INSERT INTO `reader` VALUES (10003, '张明华', '男', '1996-08-29', '陕西省西安市', '12345678907', '123456');
INSERT INTO `reader` VALUES (10004, '李一琛', '男', '1996-01-01', '陕西省西安市', '15123659875', '123456');
INSERT INTO `reader` VALUES (10005, '李二飞', '男', '1996-05-03', '山东省青岛市', '15369874123', '123456');

SET FOREIGN_KEY_CHECKS = 1;
