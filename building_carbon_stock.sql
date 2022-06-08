/*
SQLyog Ultimate v12.14 (64 bit)
MySQL - 8.0.13 : Database - building_carbon_stock
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`building_carbon_stock` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;

USE `building_carbon_stock`;

/*Table structure for table `carbon_emission_factor` */

DROP TABLE IF EXISTS `carbon_emission_factor`;

CREATE TABLE `carbon_emission_factor` (
  `carbon_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `energy_name` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '能源名称',
  `carbon_content` double DEFAULT NULL COMMENT '单位热值含碳量（吨碳/TJ）',
  `carbon_oxidation_rate` double DEFAULT NULL COMMENT '碳氧化率',
  `CO2_emission_factor` double DEFAULT NULL COMMENT 'CO2 排放系数（kgCO2/kg）',
  PRIMARY KEY (`carbon_id`),
  KEY `carbon_content` (`carbon_content`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='各种能源折碳排放因子';

/*Data for the table `carbon_emission_factor` */

insert  into `carbon_emission_factor`(`carbon_id`,`energy_name`,`carbon_content`,`carbon_oxidation_rate`,`CO2_emission_factor`) values 
(1,'天然气',18.9,0.98,2.9251),
(2,'柴油',20.2,0.98,3.0959),
(3,'汽油',18.9,0.98,2.9251),
(4,'热力',NULL,NULL,2.7725),
(5,'蒸汽',NULL,NULL,2.7725);

/*Table structure for table `diesel_fuel_consumption` */

DROP TABLE IF EXISTS `diesel_fuel_consumption`;

CREATE TABLE `diesel_fuel_consumption` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `y_diesel` double DEFAULT NULL COMMENT '输入，柴油消耗量，kg',
  `w_diesel` double DEFAULT NULL COMMENT '输出，柴油转换能耗，tce',
  `t_diesel` double DEFAULT NULL COMMENT '输出，柴油转换碳排放，tCO2',
  `created_time` date DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='柴油能耗与碳排放计算';

/*Data for the table `diesel_fuel_consumption` */

insert  into `diesel_fuel_consumption`(`id`,`y_diesel`,`w_diesel`,`t_diesel`,`created_time`) values 
(1,456,0.6644376,1.4117304,'2022-05-12'),
(2,11,0.0160281,0.0340549,'2022-05-13'),
(3,1000,1.4571,3.0959000000000003,'2022-05-14'),
(4,45,0.0655695,0.13931549999999998,'2022-05-15'),
(5,12,0.0174852,0.0371508,'2022-05-16'),
(6,14,0.0203994,0.043342599999999995,'2022-05-17'),
(7,15,0.0218565,0.0464385,'2022-05-18'),
(8,15,0.0218565,0.0464385,'2022-05-19'),
(9,1245,1.8140895000000001,3.8543955,'2022-05-20'),
(10,123,0.1792233,0.3807957,'2022-05-21');

/*Table structure for table `electricity_consumption` */

DROP TABLE IF EXISTS `electricity_consumption`;

CREATE TABLE `electricity_consumption` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `d_n` double DEFAULT NULL COMMENT '输入，暖通空调系统的用电量，kWh',
  `d_r` double DEFAULT NULL COMMENT '输入，生活热水系统的用电量，kWh',
  `d_w` double DEFAULT NULL COMMENT '输入，照明系统用电量，kWh',
  `d_e` double DEFAULT NULL COMMENT '输入，其他用能设备（电梯、水泵与通风机）用电量',
  `e` double DEFAULT NULL COMMENT '输入，光伏发电量',
  `w_n` double DEFAULT NULL COMMENT '输出，暖通空调能耗',
  `w_r` double DEFAULT NULL COMMENT '输出，生活热水能耗',
  `w_w` double DEFAULT NULL COMMENT '输出，照明能耗',
  `w_e` double DEFAULT NULL COMMENT '输出，其他用能设备能耗',
  `d` double DEFAULT NULL COMMENT '输出，总用电量',
  `w_electricity` double DEFAULT NULL COMMENT '输出，电力转换能耗，tce',
  `grid_id` int(11) DEFAULT NULL COMMENT '输入，外键，区域编号',
  `t_grid` double DEFAULT NULL COMMENT '输出，区域电力转换碳排放，tCO2',
  `created_time` date DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `grid_id` (`grid_id`),
  CONSTRAINT `electricity_consumption_ibfk_1` FOREIGN KEY (`grid_id`) REFERENCES `grid_emission_factor` (`area_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='电力能耗与碳排放计算';

/*Data for the table `electricity_consumption` */

insert  into `electricity_consumption`(`id`,`d_n`,`d_r`,`d_w`,`d_e`,`e`,`w_n`,`w_r`,`w_w`,`w_e`,`d`,`w_electricity`,`grid_id`,`t_grid`,`created_time`) values 
(1,32,11,1,1,1,0.0039328,0.0013518999999999998,0.0001229,0.0001229,44,0.005407599999999999,6,0.0353848,'2022-05-08'),
(2,25,25,25,25,25,0.0030724999999999997,0.0030724999999999997,0.0030724999999999997,0.0030724999999999997,75,0.0092175,4,0.0706425,'2022-05-09'),
(3,1000,1000,1000,1000,1000,0.1229,0.1229,0.1229,0.1229,3000,0.36869999999999997,6,2.8257,'2022-05-10'),
(4,1000,1000,1000,1000,1000,0.1229,0.1229,0.1229,0.1229,3000,0.36869999999999997,4,2.8257,'2022-05-11'),
(5,1000,1000,1000,1000,1000,0.1229,0.1229,0.1229,0.1229,3000,0.36869999999999997,4,2.8257,'2022-05-12'),
(6,1000,1000,1000,1000,1000,0.1229,0.1229,0.1229,0.1229,3000,0.36869999999999997,3,2.8257,'2022-05-13'),
(7,1000,1000,1000,1000,1000,0.1229,0.1229,0.1229,0.1229,3000,0.36869999999999997,6,2.8257,'2022-05-14'),
(8,1000,1000,1000,1000,1000,0.1229,0.1229,0.1229,0.1229,3000,0.36869999999999997,1,2.8257,'2022-05-15'),
(9,1000,1000,1000,1000,1000,0.1229,0.1229,0.1229,0.1229,3000,0.36869999999999997,1,2.8257,'2022-05-16'),
(10,1000,1000,1000,1000,1000,0.1229,0.1229,0.1229,0.1229,3000,0.36869999999999997,5,2.8257,'2022-05-17'),
(11,1000,1000,1000,1000,1000,0.1229,0.1229,0.1229,0.1229,3000,0.36869999999999997,1,2.8257,'2022-05-18'),
(12,1000,1000,1000,1000,1000,0.1229,0.1229,0.1229,0.1229,3000,0.36869999999999997,6,2.8257,'2022-05-19'),
(13,1000,1000,1000,1000,1000,0.1229,0.1229,0.1229,0.1229,3000,0.36869999999999997,6,2.8257,'2022-05-20'),
(14,1000,1000,1000,1000,1000,0.1229,0.1229,0.1229,0.1229,3000,0.36869999999999997,3,2.8257,'2022-05-21'),
(15,1000,1000,1000,1000,1000,0.1229,0.1229,0.1229,0.1229,3000,0.36869999999999997,1,2.8257,'2022-05-22'),
(16,1000,123,1000,1000,1000,0.1229,0.0151167,0.1229,0.1229,2123,0.2609167,5,1.9996537,'2022-05-23'),
(17,1000,1000,1000,1233,1000,0.1229,0.1229,0.1229,0.1515357,3233,0.39733569999999996,5,3.0451627,'2022-05-24'),
(18,200,100,110,300,30,0.024579999999999998,0.012289999999999999,0.013519,0.03687,680,0.08357200000000001,1,0.6404920000000001,'2022-05-25'),
(19,1,56,1,245,1,0.0001229,0.0068823999999999995,0.0001229,0.0301105,302,0.037115800000000004,2,0.3269452,'2022-05-26'),
(20,123,11,1,1,1,0.0151167,0.0013518999999999998,0.0001229,0.0001229,135,0.0165915,3,0.10693350000000001,'2022-05-27'),
(21,123,123,123,123,123,0.0151167,0.0151167,0.0151167,0.0151167,369,0.0453501,4,0.3168603,'2022-05-28'),
(22,123,132,145,412,151,0.0151167,0.0162228,0.0178205,0.0506348,661,0.08123689999999999,5,0.5897442,'2022-05-29'),
(23,123,456,123,321,142,0.0151167,0.0560424,0.0151167,0.0394509,881,0.10827490000000001,1,0.8298139,'2022-05-30'),
(24,135,456,123,233,56,0.0165915,0.0560424,0.0151167,0.0286357,891,0.1095039,6,0.7165422,'2022-06-07');

/*Table structure for table `energy_coal_factor` */

DROP TABLE IF EXISTS `energy_coal_factor`;

CREATE TABLE `energy_coal_factor` (
  `energy_id` int(8) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `energy_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '能源名称',
  `average_low_calorific_value` int(8) DEFAULT NULL COMMENT '平均低位发热量',
  `standard_coa_coefficient` double DEFAULT NULL COMMENT '折标准煤系数',
  PRIMARY KEY (`energy_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='各种能源折标准煤参考系数';

/*Data for the table `energy_coal_factor` */

insert  into `energy_coal_factor`(`energy_id`,`energy_name`,`average_low_calorific_value`,`standard_coa_coefficient`) values 
(1,'柴油',42652,1.4571),
(2,'汽油',43070,1.4714),
(3,'油田天然气',38931,1.33),
(4,'热力（当量值）',NULL,0.03412),
(5,'电力（当量值）',3600,0.1229),
(6,'蒸汽（低压）',3763,0.1286);

/*Table structure for table `gas_consumption` */

DROP TABLE IF EXISTS `gas_consumption`;

CREATE TABLE `gas_consumption` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `q` double DEFAULT NULL COMMENT '输入，天然气消耗量，m3',
  `w_gas` double DEFAULT NULL COMMENT '输出，天然气转换能耗，tce',
  `t_gas` double DEFAULT NULL COMMENT '输出，天然气转换碳排放，tCO2',
  `created_time` date DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='天然气能耗与碳排放';

/*Data for the table `gas_consumption` */

insert  into `gas_consumption`(`id`,`q`,`w_gas`,`t_gas`,`created_time`) values 
(1,213,0.28329000000000004,0.4605486,'2022-05-08'),
(2,20,0.026600000000000002,0.043244,'2022-05-09'),
(3,20,0.026600000000000002,0.043244,'2022-05-10'),
(4,100,0.133,0.21622,'2022-05-11'),
(5,1000,1.33,2.1622,'2022-05-12'),
(6,200,0.266,0.43244,'2022-05-13'),
(7,165,0.21945000000000003,0.356763,'2022-05-14'),
(8,1230,1.6359000000000001,2.659506,'2022-05-15'),
(9,200,0.266,0.43244,'2022-05-16'),
(10,132,0.17556,0.2854104,'2022-05-17'),
(11,546,0.72618,1.1805611999999999,'2022-05-18'),
(12,150,0.1995,0.32433,'2022-05-19'),
(13,123,0.16359,0.26595060000000004,'2022-05-20'),
(14,1000,1.33,2.1622,'2022-05-23'),
(15,123,0.16359,0.26595060000000004,'2022-05-26'),
(16,123,0.16359,0.35978730000000003,'2022-04-07');

/*Table structure for table `gasoline_consumption` */

DROP TABLE IF EXISTS `gasoline_consumption`;

CREATE TABLE `gasoline_consumption` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `y_gasoline` double DEFAULT NULL COMMENT '输入，汽油消耗量，kg',
  `w_gasoline` double DEFAULT NULL COMMENT '输出，汽油转换能耗，tce',
  `t_gasoline` double DEFAULT NULL COMMENT '输出，汽油转换碳排放，tCO2',
  `created_time` date DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='汽油能耗与碳排放计算';

/*Data for the table `gasoline_consumption` */

insert  into `gasoline_consumption`(`id`,`y_gasoline`,`w_gasoline`,`t_gasoline`,`created_time`) values 
(1,156,0.2295384,0.45631560000000004,'2022-05-07'),
(2,12,0.0176568,0.0351012,'2022-05-08'),
(3,12,0.0176568,0.0351012,'2022-05-09'),
(4,1000,1.4714,2.9251,'2022-05-10'),
(5,23,0.033842199999999996,0.0672773,'2022-05-11'),
(6,123,0.1809822,0.35978730000000003,'2022-05-12'),
(7,412,0.6062168,1.2051412000000001,'2022-05-13'),
(8,123,0.1809822,0.35978730000000003,'2022-05-14'),
(9,124,0.1824536,0.3627124,'2022-05-15'),
(10,1244,1.8304216000000002,3.6388244,'2022-05-16'),
(11,515,0.7577710000000001,1.5064265000000001,'2022-05-17'),
(12,1241,1.8260074,3.6300491000000004,'2022-05-18'),
(13,125,0.183925,0.3656375,'2022-05-19'),
(14,123,0.1809822,0.35978730000000003,'2022-05-20'),
(15,123,0.1809822,0.35978730000000003,'2022-05-21');

/*Table structure for table `grid_emission_factor` */

DROP TABLE IF EXISTS `grid_emission_factor`;

CREATE TABLE `grid_emission_factor` (
  `area_id` int(8) NOT NULL COMMENT '区域编号',
  `grid_name` varchar(255) DEFAULT NULL COMMENT '电网名称',
  `om` double DEFAULT NULL COMMENT 'EFgrid,OMSimple',
  `bm` double DEFAULT NULL COMMENT 'EFgrid,BM',
  PRIMARY KEY (`area_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='中国区域电网基准线排放因子';

/*Data for the table `grid_emission_factor` */

insert  into `grid_emission_factor`(`area_id`,`grid_name`,`om`,`bm`) values 
(1,'华北',0.9419,0.4819),
(2,'东北',1.0826,0.2399),
(3,'华东',0.7921,0.387),
(4,'华中',0.8587,0.2854),
(5,'西北',0.8922,0.4407),
(6,'南方',0.8042,0.2135);

/*Table structure for table `heat_consumption` */

DROP TABLE IF EXISTS `heat_consumption`;

CREATE TABLE `heat_consumption` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `r` double DEFAULT NULL COMMENT '输入，热量/冷量，MJ',
  `w_heat` double DEFAULT NULL COMMENT '输出，热量/冷量转换能耗，tce',
  `t_heat` double DEFAULT NULL COMMENT '输出，热量/冷量转换碳排放，tCO2',
  `created_time` date DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='供热供冷能耗与碳排放计算';

/*Data for the table `heat_consumption` */

insert  into `heat_consumption`(`id`,`r`,`w_heat`,`t_heat`,`created_time`) values 
(1,200,0.006824,0.018919540000000002,'2022-05-18'),
(2,1000,0.03412,0.09459769999999999,'2022-05-19'),
(3,1000,0.03412,0.09459769999999999,'2022-05-20'),
(4,1000,0.03412,0.09459769999999999,'2022-05-21'),
(5,123,0.00419676,0.0116355171,'2022-05-22');

/*Table structure for table `steam_consumption` */

DROP TABLE IF EXISTS `steam_consumption`;

CREATE TABLE `steam_consumption` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `z` double DEFAULT NULL COMMENT '输入，蒸汽消耗量，MJ',
  `w_steam` double DEFAULT NULL COMMENT '输出，蒸汽转换能耗，tce',
  `t_steam` double DEFAULT NULL COMMENT '输出，转换碳排放，tCO2',
  `created_time` date DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='蒸汽能耗与碳排放计算';

/*Data for the table `steam_consumption` */

insert  into `steam_consumption`(`id`,`z`,`w_steam`,`t_steam`,`created_time`) values 
(1,1000,0.03417486048365665,2772.5,'2022-05-18'),
(2,1000,0.03417486048365665,2772.5,'2022-05-19'),
(3,123,0.004203507839489768,341.0175,'2022-05-20'),
(4,1000,0.03417486048365665,2772.5,'2022-05-21'),
(5,123,0.004203507839489768,341.0175,'2022-05-25');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户密码',
  `authority` int(8) NOT NULL COMMENT '用户权限',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户登录表';

/*Data for the table `users` */

insert  into `users`(`id`,`username`,`password`,`authority`) values 
(1,'root','123456',1),
(2,'user1','123456',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
