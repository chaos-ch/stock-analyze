set names utf8;
CREATE TABLE `stock_summary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `code` varchar(10) not null DEFAULT '' COMMENT '股票代码',
  `name_cn` VARCHAR(30) not null DEFAULT '' COMMENT '股票中文名字',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_code` (`code`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='股票汇总信息表';

CREATE TABLE `stock_bs` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `code` varchar(10) not null DEFAULT '' COMMENT '股票代码',
  `data` TEXT not null COMMENT '股票买卖实时详情',
  `bs_time` DATETIME NOT NULL COMMENT '股票成交日期',
  `create_time` DATETIME NOT NULL DEFAULT now() COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_code_date` (`code`, `bs_time`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='股票成交详情';

CREATE TABLE `stock_base_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `code` varchar(10) not null DEFAULT '' COMMENT '股票代码',
  `data` TEXT not null COMMENT '股票基本信息详情',
  `version` int(11) NOT NULL COMMENT '更新时的版本号',
  `create_time` DATETIME NOT NULL DEFAULT now() COMMENT '创建时间',
  PRIMARY KEY (`id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='股票基本信息详情';