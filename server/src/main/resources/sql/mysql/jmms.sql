# Host: localhost  (Version: 5.6.12)
# Date: 2014-03-12 18:45:15
# Generator: MySQL-Front 5.3  (Build 4.91)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "ss_user"
#

DROP TABLE IF EXISTS `ss_user`;
CREATE TABLE `ss_user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(64) NOT NULL DEFAULT '',
  `user_account` varchar(255) NOT NULL DEFAULT '',
  `user_pwd` varchar(255) NOT NULL DEFAULT '',
  `salt` varchar(64) NOT NULL DEFAULT '',
  `user_email` varchar(128) NOT NULL DEFAULT '',
  `status` varchar(32) NOT NULL DEFAULT '0',
  `permissions` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "ss_user"
#

