DROP TABLE IF EXISTS `book_source`;
CREATE TABLE `book_source` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `url` varchar(1000) DEFAULT '1' COMMENT '网站url',
  `url_name` varchar(100) DEFAULT '' COMMENT '网站名字',
  `desc_select` varchar(50) COMMENT '详情页面选择',
  `book_type_select` varchar(50) COMMENT '书本状态',
  `book_update_select` varchar(50) COMMENT '书本更新时间',
  `book_author_select` varchar(50) COMMENT '作者选择',
  `book_intro_select` varchar(50) COMMENT '简介选择',
  `catalog_select` varchar(50) COMMENT '目录页面过滤',
  `book_select` varchar(50) COMMENT '章节过滤',
  `search_url` varchar(50) COMMENT '搜索地址',
  `search_select` varchar(50) COMMENT '搜索页面过滤',
  `status` char(2) COMMENT '状态【可用、不可】',
  `sort` int(11) DEFAULT '1' COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4261 DEFAULT CHARSET=utf8 COMMENT='文章';

DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `source` varchar(1000) COMMENT '来源',
  `name` varchar(100) DEFAULT '' COMMENT '书本名字',
  `intro` varchar(1000) COMMENT '详情',
  `writer` varchar(50) COMMENT '作者',
  `writer_click` int(11) DEFAULT '0' COMMENT '作者点击',
  `status` char(2) COMMENT '状态 完本连载停更',
  `lable` varchar(50) COMMENT '标签',
  `word_count` int(11) COMMENT '字数',
  `begin_date` datetime COMMENT '开始更新日期',
  `last_update` datetime COMMENT '最近更新',
  `love` int(11) DEFAULT '0' COMMENT '喜欢人数',
  `shelf` int(11) DEFAULT '0' COMMENT '书架添加数',
  `is_show` int(11) DEFAULT '1' COMMENT '是否显示',
  `sort` int(11) DEFAULT '1' COMMENT '排序',
  `click` int(11) DEFAULT '0' COMMENT '点击',
  `search_key` int(11) DEFAULT '0' COMMENT '搜索',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4261 DEFAULT CHARSET=utf8 COMMENT='书本详情';

DROP TABLE IF EXISTS `search`;
CREATE TABLE `search` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `type` char(2) COMMENT '类型 作者 书名',
  `search_key` int(11) DEFAULT '0' COMMENT '搜索',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4261 DEFAULT CHARSET=utf8 COMMENT='书本详情';

DROP TABLE IF EXISTS `book_content`;
CREATE TABLE `book_content` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `book_id` int(11) NOT NULL COMMENT 'book_id',
  `name` varchar(100) DEFAULT '' COMMENT '书本名字',
  `content` varchar(4000) COMMENT '内容',
  `catalog` varchar(100) COMMENT '目录',
  `last_update` datetime COMMENT '最近更新',
  `is_show` int(11) DEFAULT '1' COMMENT '是否显示',
  `sort` int(11) DEFAULT '1' COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4261 DEFAULT CHARSET=utf8 COMMENT='书本内容';
ALTER TABLE `book_content` ADD INDEX index_name( `book_id` );

DROP TABLE IF EXISTS `book_book_type`;
CREATE TABLE `book_book_type` (
  `book_id` int(11) NOT NULL COMMENT 'book_id',
  `book_type_id` int(11) NOT NULL COMMENT 'book_type_id',
  PRIMARY KEY (`book_id`,`book_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4261 DEFAULT CHARSET=utf8 COMMENT='书本和分类中间表';

DROP TABLE IF EXISTS `book_type`;
CREATE TABLE `book_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `pid` int(11) COMMENT 'pid',
  `pname` varchar(50) COMMENT '父级名字',
  `name` varchar(50) COMMENT '名字',
  `status` char(2) COMMENT '状态【可用、不可】',
  `lable` varchar(50) COMMENT '标签',
  `sort` int(11) DEFAULT '1' COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4261 DEFAULT CHARSET=utf8 COMMENT='书本分类';

DROP TABLE IF EXISTS `book_shelf`;
CREATE TABLE `book_shelf` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `book_id` int(11) COMMENT 'pid',
  `sys_user_id` int(11) COMMENT '用户id',
  `group_name` varchar(50) COMMENT '分组名',
  `book_url` varchar(500) COMMENT '同步书籍url',
  `sort` int(11) DEFAULT '1' COMMENT '排序',
  `look_chapter` varchar(50) DEFAULT '0' COMMENT '查看章节',
  `look_position` varchar(50) DEFAULT '0' COMMENT '查看位置',
  `look_time` int(11) DEFAULT '0' COMMENT '查看时长',
  `status` char(2) COMMENT '状态【可用、不可】',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4261 DEFAULT CHARSET=utf8 COMMENT='书架';

