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

CREATE TABLE `crm_member_role` (
  `ID` int(18) NOT NULL AUTO_INCREMENT,
  `MEMBER_ID` int(18) DEFAULT NULL,
  `ROLE_ID` int(18) DEFAULT NULL,
  `value1` varchar(256) DEFAULT NULL COMMENT '备用字段1',
  `value2` varchar(256) DEFAULT NULL COMMENT '备用字段2',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

CREATE TABLE `crm_role` (
  `ID` int(18) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(512) DEFAULT NULL COMMENT '描述',
  `ROLE_NAME` varchar(30) NOT NULL COMMENT '角色名称',
  `STATUS` int(10) NOT NULL COMMENT '状态：1有效；0无效',
  `value1` varchar(256) DEFAULT NULL COMMENT '备用字段1',
  `value2` varchar(256) DEFAULT NULL COMMENT '备用字段2',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `CRM_ROLE_INDEX1` (`ROLE_NAME`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `crm_role_resource` (
  `ID` int(18) NOT NULL AUTO_INCREMENT,
  `ROLE_ID` int(18) NOT NULL,
  `RESOURCE_ID` int(18) NOT NULL,
  `value1` varchar(256) DEFAULT NULL COMMENT '备用字段1',
  `value2` varchar(256) DEFAULT NULL COMMENT '备用字段2',
  PRIMARY KEY (`ID`),
  KEY `CRM_ROLE_RESOURCE_INDEX1` (`ROLE_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

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


INSERT INTO `crm_member` (`ID`, `PASSWORD`, `USER_NAME`, `STATUS`, `EMAIL`, `AVATAR`, `GENDER`, `HIREDATE`, `REAL_NAME`, `TELEPHONE`, `value1`, `value2`) VALUES (1, '9af15b336e6a9619928537df30b2e6a2376569fcf9d7e773eccede65606529a0', 'admin', 1, '768870379@qq.com', NULL, 'GIRL', NULL, '管理员', '18676037292', NULL, NULL);
INSERT INTO `crm_member_role` (`ID`, `MEMBER_ID`, `ROLE_ID`, `value1`, `value2`) VALUES (1, 1, 1, NULL, NULL);
INSERT INTO `crm_resource` (`ID`, `FUN_URLS`, `MENU_URL`, `RES_KEY`, `RES_NAME`, `RES_TYPE`, `STATUS`, `WEIGHT`, `PARENT_ID`, `value1`, `value2`) VALUES (1, '#', '', 'system', '系统管理', 'MENU', 1, 0, NULL, NULL, NULL);
INSERT INTO `crm_resource` (`ID`, `FUN_URLS`, `MENU_URL`, `RES_KEY`, `RES_NAME`, `RES_TYPE`, `STATUS`, `WEIGHT`, `PARENT_ID`, `value1`, `value2`) VALUES (2, '/system/member/list', '/system/member', 'system-member', '用户管理', 'MENU', 1, NULL, 1, NULL, NULL);
INSERT INTO `crm_resource` (`ID`, `FUN_URLS`, `MENU_URL`, `RES_KEY`, `RES_NAME`, `RES_TYPE`, `STATUS`, `WEIGHT`, `PARENT_ID`, `value1`, `value2`) VALUES (3, '/system/role/list,/system/role/resource/tree', '/system/role', 'system-role', '角色管理', 'MENU', 1, NULL, 1, NULL, NULL);
INSERT INTO `crm_resource` (`ID`, `FUN_URLS`, `MENU_URL`, `RES_KEY`, `RES_NAME`, `RES_TYPE`, `STATUS`, `WEIGHT`, `PARENT_ID`, `value1`, `value2`) VALUES (4, '/system/resource/list', '/system/resource', 'system-resource', '资源管理', 'MENU', 1, NULL, 1, NULL, NULL);
INSERT INTO `crm_resource` (`ID`, `FUN_URLS`, `MENU_URL`, `RES_KEY`, `RES_NAME`, `RES_TYPE`, `STATUS`, `WEIGHT`, `PARENT_ID`, `value1`, `value2`) VALUES (5, '/system/role/save', '', 'role-create', '创建角色', 'FUNCTION', 1, NULL, 3, NULL, NULL);
INSERT INTO `crm_resource` (`ID`, `FUN_URLS`, `MENU_URL`, `RES_KEY`, `RES_NAME`, `RES_TYPE`, `STATUS`, `WEIGHT`, `PARENT_ID`, `value1`, `value2`) VALUES (6, '/system/role/delete', '', 'role-delete', '删除角色', 'FUNCTION', 1, NULL, 3, NULL, NULL);
INSERT INTO `crm_resource` (`ID`, `FUN_URLS`, `MENU_URL`, `RES_KEY`, `RES_NAME`, `RES_TYPE`, `STATUS`, `WEIGHT`, `PARENT_ID`, `value1`, `value2`) VALUES (7, '/system/role/update,/system/role/save', '', 'role-save', '保存编辑', 'FUNCTION', 1, NULL, 3, NULL, NULL);
INSERT INTO `crm_resource` (`ID`, `FUN_URLS`, `MENU_URL`, `RES_KEY`, `RES_NAME`, `RES_TYPE`, `STATUS`, `WEIGHT`, `PARENT_ID`, `value1`, `value2`) VALUES (8, '/system/role/resource/save', '', 'reole-resource-save', '分配资源', 'FUNCTION', 1, NULL, 3, NULL, NULL);
INSERT INTO `crm_resource` (`ID`, `FUN_URLS`, `MENU_URL`, `RES_KEY`, `RES_NAME`, `RES_TYPE`, `STATUS`, `WEIGHT`, `PARENT_ID`, `value1`, `value2`) VALUES (9, '/system/resource/form,/system/resource/parent/tree,/system/resource/save', '', 'resource-edit', '编辑', 'FUNCTION', 1, NULL, 4, NULL, NULL);
INSERT INTO `crm_resource` (`ID`, `FUN_URLS`, `MENU_URL`, `RES_KEY`, `RES_NAME`, `RES_TYPE`, `STATUS`, `WEIGHT`, `PARENT_ID`, `value1`, `value2`) VALUES (10, '/system/resource/delete', '', 'resource-delete', '删除', 'FUNCTION', 1, NULL, 4, NULL, NULL);
INSERT INTO `crm_resource` (`ID`, `FUN_URLS`, `MENU_URL`, `RES_KEY`, `RES_NAME`, `RES_TYPE`, `STATUS`, `WEIGHT`, `PARENT_ID`, `value1`, `value2`) VALUES (11, '/system/member/form,/system/member/save', '', 'member-create', '创建用户', 'FUNCTION', 1, NULL, 2, NULL, NULL);
INSERT INTO `crm_resource` (`ID`, `FUN_URLS`, `MENU_URL`, `RES_KEY`, `RES_NAME`, `RES_TYPE`, `STATUS`, `WEIGHT`, `PARENT_ID`, `value1`, `value2`) VALUES (12, '/system/member/delete', '', 'member-delete', '删除用户', 'FUNCTION', 1, NULL, 2, NULL, NULL);
INSERT INTO `crm_resource` (`ID`, `FUN_URLS`, `MENU_URL`, `RES_KEY`, `RES_NAME`, `RES_TYPE`, `STATUS`, `WEIGHT`, `PARENT_ID`, `value1`, `value2`) VALUES (13, '/system/member/form,/system/member/update', '', 'member-edit', '编辑用户', 'FUNCTION', 1, NULL, 2, NULL, NULL);
INSERT INTO `crm_resource` (`ID`, `FUN_URLS`, `MENU_URL`, `RES_KEY`, `RES_NAME`, `RES_TYPE`, `STATUS`, `WEIGHT`, `PARENT_ID`, `value1`, `value2`) VALUES (14, '/system/member/password/reset', '', 'member-reset-password', '重置密码', 'FUNCTION', 1, NULL, 2, NULL, NULL);
INSERT INTO `crm_resource` (`ID`, `FUN_URLS`, `MENU_URL`, `RES_KEY`, `RES_NAME`, `RES_TYPE`, `STATUS`, `WEIGHT`, `PARENT_ID`, `value1`, `value2`) VALUES (15, '/system/resource/form,/system/resource/parent/tree,/system/resource/save', NULL, 'resource-create', '创建资源', 'FUNCTION', 1, NULL, 4, '', '');
INSERT INTO `crm_role` (`ID`, `DESCRIPTION`, `ROLE_NAME`, `STATUS`, `value1`, `value2`) VALUES (1, '超级管理员', 'root', 1, NULL, NULL);
INSERT INTO `crm_role_resource` (`ID`, `ROLE_ID`, `RESOURCE_ID`, `value1`, `value2`) VALUES (1, 1, 1, NULL, NULL);
INSERT INTO `crm_role_resource` (`ID`, `ROLE_ID`, `RESOURCE_ID`, `value1`, `value2`) VALUES (2, 1, 2, NULL, NULL);
INSERT INTO `crm_role_resource` (`ID`, `ROLE_ID`, `RESOURCE_ID`, `value1`, `value2`) VALUES (3, 1, 3, NULL, NULL);
INSERT INTO `crm_role_resource` (`ID`, `ROLE_ID`, `RESOURCE_ID`, `value1`, `value2`) VALUES (4, 1, 4, NULL, NULL);
INSERT INTO `crm_role_resource` (`ID`, `ROLE_ID`, `RESOURCE_ID`, `value1`, `value2`) VALUES (5, 1, 5, NULL, NULL);
INSERT INTO `crm_role_resource` (`ID`, `ROLE_ID`, `RESOURCE_ID`, `value1`, `value2`) VALUES (6, 1, 6, NULL, NULL);
INSERT INTO `crm_role_resource` (`ID`, `ROLE_ID`, `RESOURCE_ID`, `value1`, `value2`) VALUES (7, 1, 7, NULL, NULL);
INSERT INTO `crm_role_resource` (`ID`, `ROLE_ID`, `RESOURCE_ID`, `value1`, `value2`) VALUES (8, 1, 8, NULL, NULL);
INSERT INTO `crm_role_resource` (`ID`, `ROLE_ID`, `RESOURCE_ID`, `value1`, `value2`) VALUES (9, 1, 9, NULL, NULL);
INSERT INTO `crm_role_resource` (`ID`, `ROLE_ID`, `RESOURCE_ID`, `value1`, `value2`) VALUES (10, 1, 10, NULL, NULL);
INSERT INTO `crm_role_resource` (`ID`, `ROLE_ID`, `RESOURCE_ID`, `value1`, `value2`) VALUES (11, 1, 11, NULL, NULL);
INSERT INTO `crm_role_resource` (`ID`, `ROLE_ID`, `RESOURCE_ID`, `value1`, `value2`) VALUES (12, 1, 12, NULL, NULL);
INSERT INTO `crm_role_resource` (`ID`, `ROLE_ID`, `RESOURCE_ID`, `value1`, `value2`) VALUES (13, 1, 13, NULL, NULL);
INSERT INTO `crm_role_resource` (`ID`, `ROLE_ID`, `RESOURCE_ID`, `value1`, `value2`) VALUES (14, 1, 14, NULL, NULL);
