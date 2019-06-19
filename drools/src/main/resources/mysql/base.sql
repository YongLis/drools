CREATE TABLE `crm_attachment` (
  `ID` int(18) NOT NULL AUTO_INCREMENT,
  `CONTENT_TYPE` varchar(64) DEFAULT NULL,
  `FILE_PATH` varchar(100) DEFAULT NULL,
  `FILE_SIZE` int(18) DEFAULT NULL,
  `ORIGINAL_NAME` varchar(255) DEFAULT NULL,
  `SUFFIX` varchar(20) DEFAULT NULL,
  `ATT_TYPE` varchar(20) DEFAULT NULL,
  `UPLOAD_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `MEMBER_ID` int(18) DEFAULT NULL,
  `value1` varchar(256) DEFAULT NULL COMMENT '备用字段1',
  `value2` varchar(256) DEFAULT NULL COMMENT '备用字段2',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `crm_member` (
  `ID` int(18) NOT NULL AUTO_INCREMENT,
  `PASSWORD` varchar(128) NOT NULL,
  `USER_NAME` varchar(64) NOT NULL,
  `STATUS` int(10) DEFAULT NULL,
  `EMAIL` varchar(64) DEFAULT NULL,
  `AVATAR` varchar(255) DEFAULT NULL,
  `GENDER` varchar(255) DEFAULT NULL,
  `HIREDATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `REAL_NAME` varchar(64) NOT NULL,
  `TELEPHONE` varchar(64) DEFAULT NULL,
  `value1` varchar(256) DEFAULT NULL COMMENT '备用字段1',
  `value2` varchar(256) DEFAULT NULL COMMENT '备用字段2',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `CRM_MEMBER_INDEX1` (`USER_NAME`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `crm_member_role` (
  `ID` int(18) NOT NULL AUTO_INCREMENT,
  `MEMBER_ID` int(18) DEFAULT NULL,
  `ROLE_ID` int(18) DEFAULT NULL,
  `value1` varchar(256) DEFAULT NULL COMMENT '备用字段1',
  `value2` varchar(256) DEFAULT NULL COMMENT '备用字段2',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `crm_resource` (
  `ID` int(18) NOT NULL AUTO_INCREMENT,
  `FUN_URLS` varchar(512) DEFAULT NULL,
  `MENU_URL` varchar(128) DEFAULT NULL,
  `RES_KEY` varchar(128) DEFAULT NULL,
  `RES_NAME` varchar(128) DEFAULT NULL,
  `RES_TYPE` varchar(20) DEFAULT NULL,
  `STATUS` int(2) DEFAULT NULL,
  `WEIGHT` int(10) DEFAULT NULL,
  `PARENT_ID` int(18) DEFAULT NULL,
  `value1` varchar(256) DEFAULT NULL COMMENT '备用字段1',
  `value2` varchar(256) DEFAULT NULL COMMENT '备用字段2',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `CRM_RESOURCE_INDEX1` (`RES_KEY`) USING BTREE,
  KEY `CRM_RESOURCE_INDEX2` (`PARENT_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `crm_role` (
  `ID` int(18) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(512) DEFAULT NULL COMMENT '描述',
  `ROLE_NAME` varchar(30) NOT NULL COMMENT '角色名称',
  `STATUS` int(10) NOT NULL COMMENT '状态：1有效；0无效',
  `value1` varchar(256) DEFAULT NULL COMMENT '备用字段1',
  `value2` varchar(256) DEFAULT NULL COMMENT '备用字段2',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `CRM_ROLE_INDEX1` (`ROLE_NAME`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `crm_role_resource` (
  `ID` int(18) NOT NULL AUTO_INCREMENT,
  `ROLE_ID` int(18) NOT NULL,
  `RESOURCE_ID` int(18) NOT NULL,
  `value1` varchar(256) DEFAULT NULL COMMENT '备用字段1',
  `value2` varchar(256) DEFAULT NULL COMMENT '备用字段2',
  PRIMARY KEY (`ID`),
  KEY `CRM_ROLE_RESOURCE_INDEX1` (`ROLE_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `rule_info` (
  `rule_id` varchar(128) NOT NULL COMMENT '规则Id',
  `rule_import` text,
  `rule_name` varchar(128) DEFAULT NULL COMMENT '规则名称',
  `rule_condition_desc` varchar(512) DEFAULT NULL COMMENT '规则描述',
  `rule_condition` varchar(512) DEFAULT NULL COMMENT '规则条件',
  `rule_action` text COMMENT '规则执行',
  `status` varchar(2) NOT NULL DEFAULT '0' COMMENT '0待启用,1启用，2停用',
  PRIMARY KEY (`rule_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `rule_op_info` (
  `id` bigint(20) NOT NULL,
  `rule_id` varchar(255) NOT NULL COMMENT '规则Id',
  `operate` varchar(255) NOT NULL COMMENT '操作： add添加，update 更新，remove停用',
  `status` varchar(255) NOT NULL DEFAULT '0' COMMENT '状态：0待处理，1已处理',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

