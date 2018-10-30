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

 Date: 10/30/2018 08:07:12 AM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
INSERT INTO `oauth_client_details` VALUES ('client_1', 'index', '$2a$10$Tg90MO03clbV0l.fbfhTseLvoN0dn.Fa9V11FEEhWIyYgj3hWyzVu', 'select,read,write', 'client_credentials', 'http://127.0.0.1', 'ROLE_PRODUCT_ADMIN', '7200', '0', null, 'true');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
