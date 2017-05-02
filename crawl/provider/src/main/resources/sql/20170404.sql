set names utf8;


CREATE TABLE `stock_day_price` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `code` varchar(10) not null DEFAULT '' COMMENT '股票代码',
  `data` TEXT not null COMMENT '股票买卖实时详情',
  `bs_time` DATETIME NOT NULL COMMENT '股票成交日期',
  `create_time` DATETIME NOT NULL DEFAULT now() COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_code_date` (`code`, `bs_time`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='股票成交详情';
