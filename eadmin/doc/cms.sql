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
  `status` enum('显示','隐藏') DEFAULT NULL COMMENT '状态隐藏显示',
  `is_comment` enum('是','否') DEFAULT NULL COMMENT '是否评论：否 是',
  `is_recommend` enum('是','否') DEFAULT NULL COMMENT '是否推荐：否 是',
  `site_id` int(11) DEFAULT NULL COMMENT '站点ID',
  `seo_title` varchar(200) DEFAULT NULL COMMENT 'SEO标题',
  `seo_keywords` varchar(200) DEFAULT NULL COMMENT 'SEO关键字',
  `seo_description` varchar(200) DEFAULT NULL COMMENT 'SEO详情',
  `sort` int(11) DEFAULT '1' COMMENT '排序',
  `href` varchar(256) DEFAULT NULL COMMENT '跳转地址',
  `image_url` varchar(256) DEFAULT NULL COMMENT '图片路径',
  `file_url` varchar(256) DEFAULT NULL COMMENT '文件路径',
  `file_name` varchar(256) DEFAULT NULL COMMENT '文件名',
  `approve_status` int(11) DEFAULT NULL COMMENT '审核状态',
  `start_time` datetime DEFAULT NULL COMMENT '更新时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` int(11) DEFAULT NULL COMMENT '创建者',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4262 DEFAULT CHARSET=utf8 COMMENT='文章';

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
  `status` enum('显示','隐藏') DEFAULT NULL COMMENT '状态隐藏显示',
  `type` int(11) DEFAULT '1' COMMENT '类型 1 普通目录 2 a标签 3 a标签_blank 4 直接加载url信息',
  `href` varchar(200) DEFAULT NULL COMMENT '跳转地址',
  `material_type` int(11) DEFAULT NULL COMMENT '素材类型',
  `site_id` int(11) DEFAULT NULL COMMENT '站点ID',
  `seo_title` varchar(200) DEFAULT NULL COMMENT 'SEO标题',
  `seo_keywords` varchar(200) DEFAULT NULL COMMENT 'SEO关键字',
  `seo_description` varchar(200) DEFAULT NULL COMMENT 'SEO详情',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` int(11) DEFAULT '0' COMMENT '更新人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` int(11) DEFAULT '0' COMMENT '创建者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=278 DEFAULT CHARSET=utf8 COMMENT='栏目表';
