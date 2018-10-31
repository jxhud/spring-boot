/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50560
 Source Host           : localhost
 Source Database       : oauth

 Target Server Type    : MySQL
 Target Server Version : 50560
 File Encoding         : utf-8

 Date: 10/31/2018 14:44:47 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `authority`
-- ----------------------------
DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority` (
  `id` int(11) NOT NULL DEFAULT '0',
  `authority` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `authority`
-- ----------------------------
BEGIN;
INSERT INTO `authority` VALUES ('1', 'ROLE_OAUTH_ADMIN'), ('2', 'ROLE_RESOURCE_ADMIN'), ('3', 'ROLE_PRODUCT_ADMIN');
COMMIT;

-- ----------------------------
--  Table structure for `credentials`
-- ----------------------------
DROP TABLE IF EXISTS `credentials`;
CREATE TABLE `credentials` (
  `id` int(11) NOT NULL DEFAULT '0',
  `enabled` tinyint(1) NOT NULL,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `password` varchar(255) COLLATE utf8_bin NOT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `credentials`
-- ----------------------------
BEGIN;
INSERT INTO `credentials` VALUES ('1', '1', 'oauth_admin', '$2a$10$Tg90MO03clbV0l.fbfhTseLvoN0dn.Fa9V11FEEhWIyYgj3hWyzVu', '0'), ('2', '1', 'resource_admin', '$2a$10$Tg90MO03clbV0l.fbfhTseLvoN0dn.Fa9V11FEEhWIyYgj3hWyzVu', '0'), ('3', '1', 'product_admin', '$2a$10$Tg90MO03clbV0l.fbfhTseLvoN0dn.Fa9V11FEEhWIyYgj3hWyzVu', '0');
COMMIT;

-- ----------------------------
--  Table structure for `credentials_authorities`
-- ----------------------------
DROP TABLE IF EXISTS `credentials_authorities`;
CREATE TABLE `credentials_authorities` (
  `credentials_id` bigint(20) NOT NULL,
  `authorities_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `credentials_authorities`
-- ----------------------------
BEGIN;
INSERT INTO `credentials_authorities` VALUES ('1', '1'), ('2', '2'), ('3', '3');
COMMIT;

-- ----------------------------
--  Table structure for `oauth_client_details`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(255) COLLATE utf8_bin NOT NULL,
  `resource_ids` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `client_secret` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `scope` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `authorized_grant_types` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `web_server_redirect_uri` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `authorities` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `autoapprove` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `oauth_client_details`
-- ----------------------------
BEGIN;
INSERT INTO `oauth_client_details` VALUES ('client_1', 'index', '$2a$10$Tg90MO03clbV0l.fbfhTseLvoN0dn.Fa9V11FEEhWIyYgj3hWyzVu', 'select,read,write', 'client_credentials', 'http://127.0.0.1', 'ROLE_PRODUCT_ADMIN', '7200', '0', null, 'true'), ('client_2', 'index', '$2a$10$Tg90MO03clbV0l.fbfhTseLvoN0dn.Fa9V11FEEhWIyYgj3hWyzVu', 'select,read,write', 'password,refresh_token', 'http://127.0.0.1', 'ROLE_PRODUCT_ADMIN', '7200', '0', null, 'true');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
