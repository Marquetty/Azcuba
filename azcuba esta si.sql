/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 100137
 Source Host           : localhost:3306
 Source Schema         : azcuba

 Target Server Type    : MySQL
 Target Server Version : 100137
 File Encoding         : 65001

 Date: 02/11/2021 14:13:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for consumo
-- ----------------------------
DROP TABLE IF EXISTS `consumo`;
CREATE TABLE `consumo`  (
  `id_consumo` int(11) NOT NULL AUTO_INCREMENT,
  `consumo_aceite` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `consumo_lodo` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `consumo_petroleo` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `consumo_biomasa` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `consumo_marabu` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `recobrado` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `indice_dia` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `indice_petroleo` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `consumo_fecha` date NULL DEFAULT NULL,
  PRIMARY KEY (`id_consumo`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of consumo
-- ----------------------------
INSERT INTO `consumo` VALUES (43, '3323', '234', '234', '2342', '244', '33', '555', '234', '2021-10-21');
INSERT INTO `consumo` VALUES (47, '24444', '334440', '345345', '345345', '35350', '345345', '345345', '345345', '2021-10-22');

-- ----------------------------
-- Table structure for personal
-- ----------------------------
DROP TABLE IF EXISTS `personal`;
CREATE TABLE `personal`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ci` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `ocupacion` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `contrata` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `salario` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `tiempo_contrata` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `salario_contrata` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `nombre` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `apellidos` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of personal
-- ----------------------------
INSERT INTO `personal` VALUES (3, '97092616266', 'Operador B', 'NO', '0', '0', '0', 'Antonio Santiago', 'Antunz Marquetty');
INSERT INTO `personal` VALUES (5, '97092616267', 'Operador B', 'SI', '0', '567', '9', 'Antonio Santiago', 'Antunz Marquetty');
INSERT INTO `personal` VALUES (6, '97092616268', 'Operador B', 'NO', '2567', '0', '0', 'Antonio Santiago', 'Antunz Marquetty');
INSERT INTO `personal` VALUES (7, '97122616268', 'Operador B', 'SI', '0', '688', '69', 'Antonio Santiago', 'Antunz Marquetty');
INSERT INTO `personal` VALUES (9, '01012443200', 'Operador B', 'NO', '2000', '0', '0', 'Lilian', 'Gonzales Gónzales');

-- ----------------------------
-- Table structure for producion
-- ----------------------------
DROP TABLE IF EXISTS `producion`;
CREATE TABLE `producion`  (
  `id_producion` int(11) NOT NULL AUTO_INCREMENT,
  `sacos` int(11) NULL DEFAULT NULL,
  `azucarPizarra` int(11) NULL DEFAULT NULL,
  `norma_producion` int(11) NULL DEFAULT NULL,
  `tm_refino` int(11) NULL DEFAULT NULL,
  `total_azucar` int(11) NULL DEFAULT NULL,
  `miel` int(11) NULL DEFAULT NULL,
  `insumo_ajeno` int(11) NULL DEFAULT NULL,
  `refino_a_procesar` int(11) NULL DEFAULT NULL,
  `produccion_fecha` date NULL DEFAULT NULL,
  PRIMARY KEY (`id_producion`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of producion
-- ----------------------------
INSERT INTO `producion` VALUES (1, 24, 544, 65, 56, 56, 1000, 56, 56, '2021-10-17');
INSERT INTO `producion` VALUES (2, 6776, 544, 65, 56, 56, 500, 56, 56, '2021-09-29');
INSERT INTO `producion` VALUES (5, 5676, 56, 56, 4, 9956, 2000, 56, 3, '2021-09-27');
INSERT INTO `producion` VALUES (6, 2500, 95, 56, 56, 3, 4, 9956, 56, '2021-10-22');
INSERT INTO `producion` VALUES (7, 3000, 95, 56, 56, 3, 4, 9956, 56, '2021-10-14');
INSERT INTO `producion` VALUES (8, 500, 95, 56, 50, 3, 4, 9956, 56, '2021-10-04');
INSERT INTO `producion` VALUES (9, 233, 2342, 340, 3434, 34343, 3000, 22234, 3434, '2021-09-26');
INSERT INTO `producion` VALUES (10, 3000, 234234, 234234, 234234, 243242, 3000, 234242, 234234, '2021-10-23');

-- ----------------------------
-- Table structure for transportacion
-- ----------------------------
DROP TABLE IF EXISTS `transportacion`;
CREATE TABLE `transportacion`  (
  `id_vehiculo` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_vehiculo` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `modelo` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `marca` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id_vehiculo`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of transportacion
-- ----------------------------
INSERT INTO `transportacion` VALUES (2, 'ASASD', 'AS', 'ADA');
INSERT INTO `transportacion` VALUES (3, 'Ferroviario', 'mitsubichi', 'mclaren');
INSERT INTO `transportacion` VALUES (4, 'Ferroviario', 'ADA', 'AS');
INSERT INTO `transportacion` VALUES (5, 'Ferroviario', 'AS', 'ADA');

-- ----------------------------
-- Table structure for usuario
-- ----------------------------
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario`  (
  `id_usuario` int(255) NOT NULL AUTO_INCREMENT,
  `contrasenna` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `nombre` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `rol` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id_usuario`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of usuario
-- ----------------------------
INSERT INTO `usuario` VALUES (1, NULL, 'san', 'san');

SET FOREIGN_KEY_CHECKS = 1;
