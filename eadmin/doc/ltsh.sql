/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50524
Source Host           : localhost:3306
Source Database       : ltsh

Target Server Type    : MYSQL
Target Server Version : 50524
File Encoding         : 65001

Date: 2017-06-15 18:22:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cms_article
-- ----------------------------
DROP TABLE IF EXISTS `cms_article`;
CREATE TABLE `cms_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `category_id` int(11) DEFAULT '1' COMMENT '目录id',
  `title` varchar(200) DEFAULT '' COMMENT '文章名称',
  `content` longtext COMMENT '文件内容',
  `count_view` int(11) DEFAULT '0' COMMENT '浏览数',
  `count_comment` int(11) DEFAULT '0' COMMENT '评论数',
  `status` varchar(20) DEFAULT '1' COMMENT '状态//radio/-1隐藏,1,显示',
  `is_comment` int(11) DEFAULT '1' COMMENT '是否评论：-1否 1 是',
  `is_recommend` int(11) DEFAULT '2' COMMENT '是否推荐：-1否 1 是',
  `sort` int(11) DEFAULT '1' COMMENT '排序',
  `href` varchar(256) DEFAULT NULL COMMENT '跳转地址',
  `image_url` varchar(256) DEFAULT NULL COMMENT '图片路径',
  `file_url` varchar(256) DEFAULT NULL COMMENT '文件路径',
  `file_name` varchar(256) DEFAULT NULL COMMENT '文件名',
  `approve_status` int(11) DEFAULT NULL COMMENT '审核状态',
  `start_time` datetime DEFAULT NULL COMMENT '更新时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` int(11) DEFAULT NULL COMMENT '创建者',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4253 DEFAULT CHARSET=utf8 COMMENT='文章';

-- ----------------------------
-- Table structure for cms_article_data
-- ----------------------------
DROP TABLE IF EXISTS `cms_article_data`;
CREATE TABLE `cms_article_data` (
  `id` int(11) NOT NULL COMMENT 'id=cms_article.id',
  `content` text COLLATE utf8_bin COMMENT '文章内容',
  `copyfrom` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '文章来源',
  `relation` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '相关文章',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='文章详表';

-- ----------------------------
-- Table structure for cms_category
-- ----------------------------
DROP TABLE IF EXISTS `cms_category`;
CREATE TABLE `cms_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `parent_id` int(11) DEFAULT '0' COMMENT '父ID',
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '中文名',
  `path` varchar(200) DEFAULT '' COMMENT '模板路径',
  `content` text COMMENT '描述',
  `sort` int(11) DEFAULT '1' COMMENT '排序',
  `status` int(11) DEFAULT '1' COMMENT '状态//radio/0,隐藏,1,显示',
  `type` int(11) DEFAULT '1' COMMENT '类型 1 普通目录 2 a标签 3 a标签_blank 4 直接加载url信息',
  `href` varchar(200) DEFAULT NULL COMMENT '跳转地址',
  `material_type` int(11) DEFAULT NULL COMMENT '素材类型',
  `site_id` int(11) DEFAULT NULL COMMENT '站点ID',
  `seo_title` varchar(200) DEFAULT NULL COMMENT 'SEO title',
  `seo_keywords` varchar(200) DEFAULT NULL COMMENT 'SEO keywords',
  `seo_description` varchar(200) DEFAULT NULL COMMENT 'SEO description',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` int(11) DEFAULT '0' COMMENT '更新人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` int(11) DEFAULT '0' COMMENT '创建者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=278 DEFAULT CHARSET=utf8 COMMENT='栏目表';

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `dict_value` varchar(100) NOT NULL COMMENT '数据值',
  `dict_key` varchar(100) NOT NULL COMMENT '标签名',
  `type` int(11) NOT NULL COMMENT '类型',
  `description` varchar(100) NOT NULL COMMENT '描述',
  `sort` int(11) NOT NULL COMMENT '排序（升序）',
  `parent_id` int(11) DEFAULT '0' COMMENT '父级编号',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`),
  KEY `sys_dict_value` (`dict_value`),
  KEY `sys_dict_key` (`dict_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典表';

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `type` char(1) DEFAULT '1' COMMENT '日志类型',
  `title` varchar(255) DEFAULT '' COMMENT '日志标题',
  `user_name` varchar(64) DEFAULT NULL COMMENT '用户名者',
  `user_id` varchar(64) DEFAULT NULL COMMENT '用户id',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `remote_addr` varchar(255) DEFAULT NULL COMMENT '操作IP地址',
  `user_agent` varchar(255) DEFAULT NULL COMMENT '用户代理',
  `request_uri` varchar(255) DEFAULT NULL COMMENT '请求URI',
  `method` varchar(5) DEFAULT NULL COMMENT '操作方式',
  `params` varchar(1000) DEFAULT NULL COMMENT '提交数据',
  `perform` varchar(255) DEFAULT NULL COMMENT '工作性能',
  `long_time` char(12) DEFAULT NULL COMMENT '请求耗时',
  `remarks` varchar(2000) DEFAULT NULL COMMENT '详细信息',
  PRIMARY KEY (`id`),
  KEY `sys_log_user_name` (`user_name`),
  KEY `sys_log_request_uri` (`request_uri`),
  KEY `sys_log_type` (`type`),
  KEY `sys_log_create_date` (`create_date`)
) ENGINE=InnoDB AUTO_INCREMENT=31099 DEFAULT CHARSET=utf8 COMMENT='日志表';

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `parent_id` int(11) NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(2000) DEFAULT NULL COMMENT '所有父级编号',
  `level` int(11) DEFAULT NULL COMMENT '菜单级别',
  `type` int(11) DEFAULT NULL COMMENT '菜单类型',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `sort` int(10) DEFAULT NULL COMMENT '排序',
  `href` varchar(2000) DEFAULT NULL COMMENT '链接',
  `target` varchar(20) DEFAULT NULL COMMENT '目标',
  `icon` varchar(100) DEFAULT NULL COMMENT '图标',
  `permission` varchar(200) DEFAULT NULL COMMENT '权限标识',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`),
  KEY `sys_menu_parent_id` (`parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=676 DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Table structure for sys_privilege
-- ----------------------------
DROP TABLE IF EXISTS `sys_privilege`;
CREATE TABLE `sys_privilege` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `master` varchar(255) NOT NULL COMMENT '主体',
  `master_value` varchar(255) NOT NULL COMMENT '控制值',
  `access` varchar(255) NOT NULL COMMENT '领域 ',
  `access_value` varchar(255) NOT NULL COMMENT '领域值',
  `operation` varchar(255) DEFAULT NULL COMMENT '权限',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=423 DEFAULT CHARSET=utf8 COMMENT='权限连接表';

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(100) NOT NULL COMMENT '角色名称',
  `code` varchar(255) DEFAULT NULL COMMENT '角色编码',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `login_name` varchar(50) NOT NULL COMMENT '登录名',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `salt` varchar(64) NULL COMMENT '密码加盐',
  `name` varchar(50) DEFAULT NULL COMMENT '显示名',
  `tel` varchar(50) DEFAULT NULL COMMENT '电话号码',
  `qq` varchar(50) DEFAULT NULL COMMENT 'qq',
  `weixin` varchar(50) DEFAULT NULL COMMENT '微信',
  `weibo` varchar(50) DEFAULT NULL COMMENT '微博',
  `session_key` varchar(100) DEFAULT NULL COMMENT '会话key',
  `phone` varchar(50) DEFAULT NULL COMMENT '手机号码',
  `address` varchar(500) DEFAULT NULL COMMENT '地址',
  `email` varchar(50) DEFAULT NULL COMMENT '电子邮件',
  `idcard` varchar(50) DEFAULT NULL COMMENT '身份证',
  `zip` varchar(50) DEFAULT NULL COMMENT '邮政编码',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `sex` int(11) DEFAULT NULL COMMENT '性别',
  `birth` date DEFAULT NULL COMMENT '出生日期',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `login_count` tinyint(4) DEFAULT '0' COMMENT '登录次数',
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_login_name` (`login_name`)
) ENGINE=InnoDB AUTO_INCREMENT=740 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
