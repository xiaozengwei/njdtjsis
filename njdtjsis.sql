/*
Navicat MySQL Data Transfer

Source Server         : 221.6.30.202_13306
Source Server Version : 50625
Source Host           : 221.6.30.202:13306
Source Database       : njdtjsis

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2020-02-04 15:57:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for attachment
-- ----------------------------
DROP TABLE IF EXISTS `attachment`;
CREATE TABLE `attachment` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `relation_id` varchar(40) DEFAULT NULL COMMENT '关联表ID',
  `file_name` varchar(100) DEFAULT NULL COMMENT '附件名称',
  `file_type` varchar(40) DEFAULT NULL COMMENT '附件类型',
  `file_identify_name` varchar(100) DEFAULT NULL COMMENT '附件上传后保存名',
  `file_path` varchar(100) DEFAULT NULL COMMENT '附件路径',
  `upload_user_id` varchar(40) DEFAULT NULL COMMENT '上传人ID',
  `upload_user_name` varchar(40) DEFAULT NULL COMMENT '上传人姓名',
  `upload_time` datetime DEFAULT NULL COMMENT '上传时间',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` varchar(40) DEFAULT NULL COMMENT '排序',
  `data_delete` varchar(40) DEFAULT NULL COMMENT '删除',
  `file_longitude` varchar(40) DEFAULT NULL COMMENT '经度',
  `file_dimensionality` varchar(40) DEFAULT NULL COMMENT '维度',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='附件记录表';

-- ----------------------------
-- Table structure for attendance_all_record_time
-- ----------------------------
DROP TABLE IF EXISTS `attendance_all_record_time`;
CREATE TABLE `attendance_all_record_time` (
  `id` varchar(80) NOT NULL,
  `recordTime` datetime DEFAULT NULL,
  `localRecordTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for attendance_record_time
-- ----------------------------
DROP TABLE IF EXISTS `attendance_record_time`;
CREATE TABLE `attendance_record_time` (
  `id` varchar(80) NOT NULL,
  `recordTime` datetime DEFAULT NULL,
  `localRecordTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for builddg_pad_day
-- ----------------------------
DROP TABLE IF EXISTS `builddg_pad_day`;
CREATE TABLE `builddg_pad_day` (
  `row_id` varchar(40) NOT NULL,
  `bd_id` varchar(40) DEFAULT NULL COMMENT '标段ID',
  `bd_name` varchar(120) DEFAULT NULL COMMENT '标段名称',
  `dg_num` varchar(40) DEFAULT NULL COMMENT '危险源序号',
  `dg_reson` varchar(140) DEFAULT NULL COMMENT '潜在危险因素',
  `dg_sg` varchar(140) DEFAULT NULL COMMENT '可能导致的事故',
  `dg_level` varchar(40) DEFAULT NULL COMMENT '风险度',
  `contrl_answer` varchar(140) DEFAULT NULL COMMENT '控制措施',
  `contrl_time` varchar(40) DEFAULT NULL COMMENT '受控时间',
  `build_manager` varchar(40) DEFAULT NULL COMMENT '施工负责人',
  `level_manager` varchar(40) DEFAULT NULL COMMENT '班组负责人',
  `safe_manager` varchar(40) DEFAULT NULL COMMENT '安全负责人',
  `cr_time` varchar(80) DEFAULT NULL COMMENT '迄今时间',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='危险源公示牌';

-- ----------------------------
-- Table structure for build_progress_record
-- ----------------------------
DROP TABLE IF EXISTS `build_progress_record`;
CREATE TABLE `build_progress_record` (
  `row_id` varchar(40) NOT NULL,
  `bd_id` varchar(40) DEFAULT NULL COMMENT '标段ID',
  `bd_name` varchar(120) DEFAULT NULL COMMENT '标段名称',
  `ht_price` varchar(40) DEFAULT NULL COMMENT '合同额度',
  `ht_cost` varchar(40) DEFAULT NULL COMMENT '开累完成产值',
  `cost_prsent` varchar(40) DEFAULT NULL COMMENT '开销比例',
  `data_order` decimal(10,0) DEFAULT NULL COMMENT '排序',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `upload_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `ext1` varchar(40) DEFAULT NULL,
  `ext2` varchar(40) DEFAULT NULL,
  `ext3` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for by_project_introduction
-- ----------------------------
DROP TABLE IF EXISTS `by_project_introduction`;
CREATE TABLE `by_project_introduction` (
  `row_id` varchar(40) NOT NULL,
  `station_total_project` varchar(40) DEFAULT NULL COMMENT '车站土建总工程（百分）',
  `qjtj_total_gcs` varchar(40) DEFAULT NULL COMMENT '区间土建总工程（百分）',
  `fg_total_schedule` varchar(40) DEFAULT NULL COMMENT '辅轨总进度（百分）',
  `sb_total_schedule` varchar(40) DEFAULT NULL COMMENT '设备工程总进度（百分）',
  `tzwc_money` varchar(40) DEFAULT NULL COMMENT '投资完成金额（数值）',
  `station_all_count` int(11) DEFAULT NULL COMMENT '车站总数',
  `ykg_station_all_count` int(11) DEFAULT NULL COMMENT '已开工车站数',
  `dgj_all_count` int(11) DEFAULT NULL COMMENT '盾构机总数',
  `ysf_dgj_count` int(11) DEFAULT NULL COMMENT '已始发盾构机数',
  `project_introduction` varchar(500) DEFAULT NULL COMMENT '工程简介 ',
  `station_total_project02` varchar(40) DEFAULT NULL COMMENT '车站土建总工程（数值）',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for curing_temperature
-- ----------------------------
DROP TABLE IF EXISTS `curing_temperature`;
CREATE TABLE `curing_temperature` (
  `rowId` varchar(80) NOT NULL,
  `bdId` varchar(40) DEFAULT NULL,
  `temperatureOrder` varchar(400) DEFAULT NULL,
  `humidityOrder` varchar(400) DEFAULT NULL,
  `temperature` varchar(40) DEFAULT NULL,
  `humidity` varchar(40) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`rowId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for danager_project
-- ----------------------------
DROP TABLE IF EXISTS `danager_project`;
CREATE TABLE `danager_project` (
  `row_id` varchar(40) NOT NULL,
  `bd_id` varchar(40) DEFAULT NULL COMMENT '标段ID',
  `bd_name` varchar(120) DEFAULT NULL COMMENT '标段名称',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `project_address` varchar(100) DEFAULT NULL COMMENT '工程地点',
  `fb_project_type` varchar(100) DEFAULT NULL COMMENT '分部分项工程类别',
  `fb_project_name` varchar(100) DEFAULT NULL COMMENT '分部分项工程名称',
  `ext1` varchar(100) DEFAULT NULL COMMENT '是否超过一定规模',
  `fb_project_parameter` varchar(100) DEFAULT NULL COMMENT '分部分项工程参数',
  `fa_sp_qk` varchar(100) DEFAULT NULL COMMENT '方案审批情况',
  `kg_time` datetime DEFAULT NULL COMMENT '计划开工日期',
  `wg_time` datetime DEFAULT NULL COMMENT '完工日期',
  `now_type` varchar(100) DEFAULT NULL COMMENT '目前状态',
  `person_charge` varchar(40) DEFAULT NULL COMMENT '责任人',
  `ext2` varchar(100) DEFAULT NULL,
  `ext3` varchar(100) DEFAULT NULL,
  `ext4` varchar(100) DEFAULT NULL,
  `ext5` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='危险源公示牌';

-- ----------------------------
-- Table structure for device_camera_record
-- ----------------------------
DROP TABLE IF EXISTS `device_camera_record`;
CREATE TABLE `device_camera_record` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `wl_address` varchar(240) DEFAULT NULL COMMENT '物理地址',
  `hls_lc_address` varchar(240) DEFAULT NULL COMMENT 'hls流畅地址',
  `com_id` varchar(240) DEFAULT NULL COMMENT '公司ID',
  `bd_id` varchar(240) DEFAULT NULL COMMENT '标段ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `status` varchar(40) DEFAULT NULL COMMENT '状态',
  `order_num` decimal(10,0) DEFAULT NULL COMMENT '排序',
  `ext1` varchar(120) DEFAULT NULL COMMENT '扩展1',
  `ext2` datetime DEFAULT NULL COMMENT '扩展2',
  `ext3` decimal(10,0) DEFAULT NULL COMMENT '扩展3',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for dgj_jd
-- ----------------------------
DROP TABLE IF EXISTS `dgj_jd`;
CREATE TABLE `dgj_jd` (
  `row_id` varchar(40) NOT NULL COMMENT '实际',
  `tj_hs` varchar(40) DEFAULT NULL COMMENT '推进环数',
  `yx_ys` varchar(250) DEFAULT NULL COMMENT '影响因素',
  `bd_id` varchar(40) DEFAULT NULL,
  `bd_name` varchar(40) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `upload_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user` varchar(100) DEFAULT NULL,
  `sc_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `ext1` varchar(100) DEFAULT NULL,
  `ext2` varchar(100) DEFAULT NULL,
  `sj_hs` varchar(40) DEFAULT NULL COMMENT '设计环数',
  `kl_hs` varchar(40) DEFAULT NULL COMMENT '开累环数',
  `ct_cs` varchar(40) DEFAULT NULL COMMENT '出土车数',
  `today_tj_hs` int(11) DEFAULT NULL COMMENT '当天环数',
  `this_month_lj_hs` int(11) DEFAULT NULL COMMENT '本月累计环数',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for dt_yc_apply
-- ----------------------------
DROP TABLE IF EXISTS `dt_yc_apply`;
CREATE TABLE `dt_yc_apply` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `applicant_name` varchar(40) DEFAULT NULL COMMENT '姓名',
  `applicant_phone` varchar(40) DEFAULT NULL COMMENT '手机号',
  `applicant_id_card` varchar(40) DEFAULT NULL COMMENT '身份证',
  `start_time` datetime DEFAULT NULL,
  `create_user_id` varchar(40) DEFAULT NULL COMMENT '创建人ID',
  `create_user_name` varchar(40) DEFAULT NULL COMMENT '创建人姓名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_user_id` varchar(40) DEFAULT NULL COMMENT '修改人ID',
  `modify_user_name` varchar(40) DEFAULT NULL COMMENT '修改人姓名',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `data_type` varchar(40) DEFAULT NULL COMMENT '类别',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` varchar(40) DEFAULT NULL COMMENT '排序',
  `yc_address` varchar(255) DEFAULT NULL COMMENT '异常地址',
  `data_deleted` varchar(40) DEFAULT NULL COMMENT '删除',
  `yc_ms` varchar(250) DEFAULT NULL COMMENT '异常描述',
  `cl_yj` varchar(250) DEFAULT NULL,
  `bd_id` varchar(200) DEFAULT NULL COMMENT '标段id',
  `relation_id` varchar(200) DEFAULT NULL COMMENT '图片关联id',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='会议室租赁申请表';

-- ----------------------------
-- Table structure for equipment_info
-- ----------------------------
DROP TABLE IF EXISTS `equipment_info`;
CREATE TABLE `equipment_info` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `equipment_type` varchar(40) DEFAULT NULL COMMENT '设备种类',
  `equipment_name` varchar(40) DEFAULT NULL COMMENT '设备名称',
  `equipment_model` varchar(40) DEFAULT NULL COMMENT '设备型号',
  `driver_name` varchar(40) DEFAULT NULL COMMENT '驾驶员',
  `telephone` varchar(40) DEFAULT NULL COMMENT '电话',
  `ls_dw` varchar(40) DEFAULT NULL COMMENT '隶属单位',
  `manager_num` varchar(40) DEFAULT NULL COMMENT '管理编号',
  `enter_time` date DEFAULT NULL COMMENT '进场时间',
  `outer_time` date DEFAULT NULL COMMENT '出场时间',
  `operation_license` varchar(40) DEFAULT NULL COMMENT '特种人员操作证',
  `is_test` varchar(40) DEFAULT NULL COMMENT '是否报检',
  `work_status` varchar(40) DEFAULT NULL COMMENT '工作状态',
  `custom_message` varchar(200) DEFAULT NULL COMMENT '自定义信息',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(40) DEFAULT NULL COMMENT '创建人ID',
  `create_user_name` varchar(40) DEFAULT NULL COMMENT '创建人姓名',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `update_user_id` varchar(40) DEFAULT NULL COMMENT '修改人ID',
  `update_user_name` varchar(40) DEFAULT NULL COMMENT '修改人姓名',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` int(11) DEFAULT NULL COMMENT '排序',
  `ext1` varchar(40) DEFAULT NULL COMMENT '扩展1',
  `ext2` timestamp NULL DEFAULT NULL COMMENT '扩展2',
  `ext3` int(11) DEFAULT NULL COMMENT '扩展3',
  `org_dw_id` varchar(40) DEFAULT NULL COMMENT '单位ID',
  `qr_code` varchar(80) DEFAULT NULL COMMENT '二维码图片路径',
  `bd_id` varchar(40) DEFAULT NULL COMMENT '标段ID',
  `sb_zl` varchar(40) DEFAULT NULL COMMENT '设备种类',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='设备信息表';

-- ----------------------------
-- Table structure for file_record
-- ----------------------------
DROP TABLE IF EXISTS `file_record`;
CREATE TABLE `file_record` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `relation_id` varchar(40) DEFAULT NULL COMMENT '关联表ID',
  `file_name` varchar(100) DEFAULT NULL COMMENT '附件名称',
  `file_type` varchar(100) DEFAULT NULL COMMENT '附件类型',
  `file_identify_name` varchar(100) DEFAULT NULL COMMENT '附件上传后保存名',
  `file_path` varchar(100) DEFAULT NULL COMMENT '附件路径',
  `upload_user_id` varchar(40) DEFAULT NULL COMMENT '上传人ID',
  `upload_user_name` varchar(40) DEFAULT NULL COMMENT '上传人姓名',
  `upload_time` datetime DEFAULT NULL COMMENT '上传时间',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` varchar(40) DEFAULT NULL COMMENT '排序',
  `data_delete` varchar(40) DEFAULT NULL COMMENT '删除',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='附件记录表';

-- ----------------------------
-- Table structure for gx_oa_attachment_config
-- ----------------------------
DROP TABLE IF EXISTS `gx_oa_attachment_config`;
CREATE TABLE `gx_oa_attachment_config` (
  `attachment_config_id` varchar(40) NOT NULL,
  `table_name` varchar(50) DEFAULT NULL COMMENT '对应引用表名',
  `app_id` varchar(50) DEFAULT NULL COMMENT '引用表ID',
  `file_name` varchar(500) DEFAULT NULL COMMENT '附件名称',
  `file_name_inshort` varchar(100) DEFAULT NULL COMMENT '附件简称',
  `file_type` varchar(50) DEFAULT NULL COMMENT '附件类型',
  `min_size` varchar(50) DEFAULT '''0''' COMMENT '附件大小下限（MB）',
  `max_size` varchar(50) DEFAULT NULL COMMENT '附件大小上限（MB）',
  `file_extend_name` varchar(50) DEFAULT NULL COMMENT '文件限制',
  `order_id` varchar(50) DEFAULT NULL COMMENT '排序号',
  `flag` varchar(10) DEFAULT '''0''' COMMENT '启动状态',
  `is_necessary` varchar(50) DEFAULT NULL COMMENT '是否必传',
  PRIMARY KEY (`attachment_config_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for gx_oa_attachment_instance
-- ----------------------------
DROP TABLE IF EXISTS `gx_oa_attachment_instance`;
CREATE TABLE `gx_oa_attachment_instance` (
  `attachment_id` varchar(50) NOT NULL,
  `table_name` varchar(50) DEFAULT NULL COMMENT '对应表名',
  `table_id` varchar(50) DEFAULT NULL COMMENT '对应表的ID',
  `attachment_name` varchar(500) DEFAULT NULL COMMENT '附件名称',
  `uploader_name` varchar(50) DEFAULT NULL COMMENT '附件上传人姓名',
  `upload_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '上传时间',
  `user_id` varchar(50) DEFAULT NULL COMMENT '上传人系统内编号',
  `flow_id` varchar(50) DEFAULT NULL COMMENT '上传人所在的流程ID',
  `node_id` varchar(50) DEFAULT NULL COMMENT '上传所在环节ID',
  `file_size` varchar(200) DEFAULT NULL,
  `file_mime` varchar(250) DEFAULT NULL COMMENT '附件文件MIME',
  `FILE_PC` varchar(50) DEFAULT NULL COMMENT '文件存放服务器说明',
  `file_path` varchar(500) DEFAULT NULL COMMENT '文件路径',
  `extend_name` varchar(50) DEFAULT NULL COMMENT '文件扩展名',
  `order_id` varchar(50) DEFAULT NULL COMMENT '文件排序号',
  `state` varchar(10) DEFAULT NULL COMMENT '文件状态',
  `flag` varchar(10) DEFAULT NULL COMMENT '文件同步标志位',
  `cfgins_id` varchar(50) DEFAULT NULL,
  `pi_id` varchar(40) DEFAULT NULL COMMENT '流程实例ID',
  `ai_id` varchar(40) DEFAULT NULL COMMENT '活动实例',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_username` varchar(40) DEFAULT NULL COMMENT '创建人',
  `create_userid` varchar(40) DEFAULT NULL COMMENT '创建人名字',
  `attachment_type` varchar(1) DEFAULT NULL COMMENT '附件类型',
  `attachment_serial_number` varchar(100) DEFAULT NULL COMMENT '附件编号',
  PRIMARY KEY (`attachment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for gx_oa_column
-- ----------------------------
DROP TABLE IF EXISTS `gx_oa_column`;
CREATE TABLE `gx_oa_column` (
  `row_id` varchar(32) NOT NULL,
  `column_name` varchar(200) DEFAULT NULL COMMENT '栏目名称',
  `column_type` varchar(10) DEFAULT NULL COMMENT '栏目类型',
  `column_info` varchar(200) DEFAULT NULL COMMENT '栏目介绍',
  `order_num` int(11) DEFAULT NULL,
  `parent_id` varchar(32) DEFAULT NULL COMMENT '父节点ID',
  `column_icon` varchar(50) DEFAULT NULL,
  `create_user_id` varchar(32) DEFAULT NULL,
  `create_user_name` varchar(50) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `parent_name` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for gx_oa_column_article
-- ----------------------------
DROP TABLE IF EXISTS `gx_oa_column_article`;
CREATE TABLE `gx_oa_column_article` (
  `row_id` varchar(50) NOT NULL,
  `article_title` varchar(500) DEFAULT NULL COMMENT '栏目文章标题',
  `article_content` longtext CHARACTER SET utf8mb4,
  `create_user_id` varchar(100) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `publish_time` date DEFAULT NULL COMMENT '发布时间',
  `source` varchar(255) DEFAULT NULL COMMENT '文章来源',
  `order_num` int(11) DEFAULT NULL,
  `comment` varchar(500) DEFAULT NULL,
  `article_type` varchar(50) DEFAULT NULL COMMENT '文档类型(图片新闻）',
  `article_status` varchar(50) DEFAULT NULL COMMENT '状态',
  `hits` int(20) DEFAULT NULL,
  `create_user_name` varchar(200) DEFAULT NULL,
  `is_news_pic` varchar(1) DEFAULT NULL COMMENT '是否为图片新闻',
  `pic_file_name` varchar(500) DEFAULT NULL COMMENT '图片名称',
  `pic_file_real_name` varchar(500) DEFAULT NULL,
  `video_file_name` varchar(500) DEFAULT NULL,
  `video_file_real_name` varchar(500) DEFAULT NULL,
  `voted_num` bigint(10) DEFAULT NULL,
  `is_vote` varchar(1) DEFAULT NULL,
  `vote_method` varchar(2) DEFAULT NULL COMMENT '选择模式（0单选，1多选）',
  `max_vote_num` int(11) DEFAULT NULL COMMENT '如果是多选，最多可以选几项',
  `vote_limit_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for gx_oa_column_article_relation
-- ----------------------------
DROP TABLE IF EXISTS `gx_oa_column_article_relation`;
CREATE TABLE `gx_oa_column_article_relation` (
  `row_id` varchar(50) NOT NULL,
  `column_id` varchar(50) DEFAULT NULL,
  `article_id` varchar(50) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user_id` varchar(32) DEFAULT NULL,
  `order_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for gx_oa_column_article_vote_option
-- ----------------------------
DROP TABLE IF EXISTS `gx_oa_column_article_vote_option`;
CREATE TABLE `gx_oa_column_article_vote_option` (
  `row_id` varchar(32) NOT NULL,
  `option_name` varchar(500) DEFAULT NULL,
  `order_num` decimal(10,0) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user_id` varchar(32) DEFAULT NULL,
  `create_user_name` varchar(50) DEFAULT NULL,
  `article_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for gx_oa_flow
-- ----------------------------
DROP TABLE IF EXISTS `gx_oa_flow`;
CREATE TABLE `gx_oa_flow` (
  `row_id` varchar(32) NOT NULL,
  `flow_name` varchar(500) DEFAULT NULL,
  `flow_id` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user_id` varchar(50) DEFAULT NULL,
  `order_num` int(11) DEFAULT NULL,
  `comment` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for gx_oa_flow_node
-- ----------------------------
DROP TABLE IF EXISTS `gx_oa_flow_node`;
CREATE TABLE `gx_oa_flow_node` (
  `row_id` varchar(32) NOT NULL,
  `flow_node_name` varchar(500) DEFAULT NULL,
  `flow_node_id` varchar(50) DEFAULT NULL,
  `create_user_id` varchar(50) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `order_num` int(11) DEFAULT NULL,
  `flow_id` varchar(32) DEFAULT NULL,
  `comment` varchar(500) DEFAULT NULL,
  `node_type` varchar(1) DEFAULT '0' COMMENT '0默认；1同部门人员或者部门负责人；2申请人',
  PRIMARY KEY (`row_id`),
  UNIQUE KEY `index_gx_oa_flow_node_rowid` (`row_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for gx_oa_form_privillege_relation
-- ----------------------------
DROP TABLE IF EXISTS `gx_oa_form_privillege_relation`;
CREATE TABLE `gx_oa_form_privillege_relation` (
  `row_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `process_template_id` varchar(40) DEFAULT NULL COMMENT '事项配置ID',
  `activity_id` varchar(40) DEFAULT NULL COMMENT '活动节点ID',
  `business_key` varchar(40) DEFAULT NULL COMMENT '业务表单键（sw/fw）',
  `form_element_name` varchar(200) DEFAULT NULL COMMENT '表单元素名称',
  `element_privillege` varchar(200) DEFAULT 'W' COMMENT '元素权限（R/W）',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user_id` varchar(50) DEFAULT NULL,
  `relation_status` varchar(50) DEFAULT NULL,
  `relation_comment` varchar(200) DEFAULT NULL,
  `form_element_comment` varchar(200) DEFAULT NULL COMMENT '表单元素中文说明',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for gx_oa_mobile_function
-- ----------------------------
DROP TABLE IF EXISTS `gx_oa_mobile_function`;
CREATE TABLE `gx_oa_mobile_function` (
  `function_id` varchar(40) NOT NULL,
  `function_name` varchar(40) DEFAULT NULL,
  `function_type` char(1) DEFAULT NULL COMMENT '菜单级别类型 ',
  `function_fragment` char(1) DEFAULT NULL,
  `is_visible` char(1) DEFAULT NULL,
  `order_num` int(255) DEFAULT NULL,
  `function_img` varchar(200) DEFAULT NULL,
  `function_activity` varchar(200) DEFAULT NULL,
  `function_url` varchar(300) DEFAULT NULL COMMENT '一级菜单的function_img (不为空是二级菜单)',
  `del_flag` char(1) DEFAULT NULL,
  PRIMARY KEY (`function_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for gx_oa_mobile_publish
-- ----------------------------
DROP TABLE IF EXISTS `gx_oa_mobile_publish`;
CREATE TABLE `gx_oa_mobile_publish` (
  `row_id` varchar(32) NOT NULL,
  `app_name` varchar(140) DEFAULT NULL COMMENT 'app名称',
  `app_en_name` varchar(80) DEFAULT NULL COMMENT 'app英文名',
  `app_ver` varchar(40) DEFAULT NULL COMMENT '版本号',
  `app_show_ver` varchar(40) DEFAULT NULL COMMENT '显示版本号',
  `publish_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '发布日期',
  `publish_user` varchar(40) DEFAULT NULL COMMENT '发布人',
  `attach_id` varchar(40) DEFAULT NULL,
  `attach_name` varchar(255) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `updtae_content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for gx_oa_mobile_role
-- ----------------------------
DROP TABLE IF EXISTS `gx_oa_mobile_role`;
CREATE TABLE `gx_oa_mobile_role` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `role_name` varchar(80) DEFAULT NULL COMMENT '角色名称',
  `role_id` varchar(80) DEFAULT NULL COMMENT '角色ID',
  `role_intro` varchar(40) DEFAULT NULL COMMENT '角色说明',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(40) DEFAULT NULL COMMENT '创建者ID',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `modify_user_id` varchar(40) DEFAULT NULL COMMENT '修改人ID',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` bigint(11) DEFAULT NULL COMMENT '排序',
  `parent_role_id` varchar(40) DEFAULT NULL COMMENT '父角色ID',
  `parent_role_name` varchar(80) DEFAULT NULL COMMENT '父角色名称',
  `role_type` varchar(40) DEFAULT NULL COMMENT '角色类别',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色';

-- ----------------------------
-- Table structure for gx_oa_mobile_role_has_function
-- ----------------------------
DROP TABLE IF EXISTS `gx_oa_mobile_role_has_function`;
CREATE TABLE `gx_oa_mobile_role_has_function` (
  `row_id` varchar(40) NOT NULL,
  `function_id` varchar(40) DEFAULT NULL,
  `role_id` varchar(40) DEFAULT NULL,
  `function_name` varchar(40) DEFAULT NULL,
  `role_name` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for gx_oa_mobile_role_has_user
-- ----------------------------
DROP TABLE IF EXISTS `gx_oa_mobile_role_has_user`;
CREATE TABLE `gx_oa_mobile_role_has_user` (
  `user_id` varchar(40) NOT NULL,
  `role_id` varchar(40) NOT NULL,
  `order_num` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` varchar(40) DEFAULT NULL,
  `create_user_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for gx_oa_wenhao_config
-- ----------------------------
DROP TABLE IF EXISTS `gx_oa_wenhao_config`;
CREATE TABLE `gx_oa_wenhao_config` (
  `wenhao_row_id` varchar(50) NOT NULL COMMENT '文号ROWID',
  `dept_id` varchar(50) DEFAULT NULL COMMENT '单位ID',
  `wenhao_year` varchar(4) DEFAULT NULL COMMENT '文号年份',
  `wenhao_type` varchar(100) DEFAULT NULL COMMENT '文号类型',
  `bracket_type` varchar(10) DEFAULT NULL COMMENT '括号类型',
  `mark_word` varchar(50) DEFAULT NULL COMMENT '号字',
  `complete_content` varchar(30) DEFAULT NULL COMMENT '完整内容',
  `current_max_value` int(11) DEFAULT NULL COMMENT '当前最大值',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `creator_id` varchar(50) DEFAULT NULL,
  `creator_name` varchar(100) DEFAULT NULL,
  `doc_type` varchar(40) DEFAULT NULL COMMENT '公文类别',
  `max_wenhao_row_id` varchar(50) DEFAULT NULL COMMENT '最大号ROWid',
  `ORDER_Num` int(11) DEFAULT '0' COMMENT '排序',
  PRIMARY KEY (`wenhao_row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for gx_oa_wenhao_max
-- ----------------------------
DROP TABLE IF EXISTS `gx_oa_wenhao_max`;
CREATE TABLE `gx_oa_wenhao_max` (
  `wenhao_max_row_id` varchar(50) NOT NULL,
  `max_wenhao` varchar(50) DEFAULT NULL COMMENT '文号最大值',
  `extend1` varchar(40) DEFAULT NULL,
  `extend2` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`wenhao_max_row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for gx_sys_attendance
-- ----------------------------
DROP TABLE IF EXISTS `gx_sys_attendance`;
CREATE TABLE `gx_sys_attendance` (
  `uniqueId` varchar(80) NOT NULL COMMENT '考勤记录唯一标识',
  `attendancenNum` varchar(80) DEFAULT NULL,
  `biddingsId` varchar(80) DEFAULT NULL COMMENT '自定义班组标识',
  `certificateNo` varchar(80) DEFAULT NULL COMMENT '证件号码',
  `certificateType` varchar(80) DEFAULT NULL COMMENT '证件类型',
  `doorControlName` varchar(80) DEFAULT NULL COMMENT '门禁地址',
  `id` varchar(80) DEFAULT NULL COMMENT '成员ID',
  `imageUrl` varchar(80) DEFAULT NULL COMMENT '图片链接',
  `projectId` varchar(80) DEFAULT NULL COMMENT '自定义项目标识',
  `restNum` varchar(80) DEFAULT NULL,
  `signType` varchar(80) DEFAULT NULL COMMENT '签到类型',
  `total` varchar(80) DEFAULT NULL,
  `validCount` varchar(80) DEFAULT NULL,
  `signTime` datetime DEFAULT NULL COMMENT '签到时间（13位格式时间戳）',
  `localRecordTime` datetime DEFAULT NULL COMMENT '录入时间',
  PRIMARY KEY (`uniqueId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for gx_sys_attendance_all
-- ----------------------------
DROP TABLE IF EXISTS `gx_sys_attendance_all`;
CREATE TABLE `gx_sys_attendance_all` (
  `uniqueId` varchar(80) NOT NULL COMMENT '考勤记录唯一标识',
  `certificateNo` varchar(80) DEFAULT NULL COMMENT '证件号码',
  `doorControlName` varchar(80) DEFAULT NULL COMMENT '门禁地址',
  `signType` varchar(80) DEFAULT NULL COMMENT '签到类型',
  `signTime` datetime DEFAULT NULL COMMENT '签到时间（13位格式时间戳）',
  `localRecordTime` datetime DEFAULT NULL COMMENT '录入时间',
  `attendancenNum` varchar(80) DEFAULT NULL,
  `biddingsId` varchar(80) DEFAULT NULL COMMENT '自定义班组标识',
  `certificateType` varchar(80) DEFAULT NULL COMMENT '证件类型',
  `id` varchar(80) DEFAULT NULL COMMENT '成员ID',
  `imageUrl` varchar(80) DEFAULT NULL COMMENT '图片链接',
  `restNum` varchar(80) DEFAULT NULL,
  `validCount` varchar(80) DEFAULT NULL,
  `projectId` varchar(80) DEFAULT NULL COMMENT '自定义项目标识',
  `total` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`uniqueId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for gx_sys_attendance_result
-- ----------------------------
DROP TABLE IF EXISTS `gx_sys_attendance_result`;
CREATE TABLE `gx_sys_attendance_result` (
  `rowId` varchar(40) NOT NULL,
  `doorControlName` varchar(80) DEFAULT NULL,
  `signTime` date DEFAULT NULL,
  `userId` varchar(40) DEFAULT NULL,
  `userName` varchar(80) DEFAULT NULL,
  `orgName` varchar(80) DEFAULT NULL,
  `ruleName` varchar(80) DEFAULT NULL,
  `earlyTime` datetime DEFAULT NULL,
  `lastTime` datetime DEFAULT NULL,
  `count` varchar(80) DEFAULT NULL,
  `workTime` varchar(80) DEFAULT NULL,
  `resultKey` varchar(80) DEFAULT NULL,
  `resultType` varchar(40) DEFAULT NULL,
  `resultCheckType` varchar(40) DEFAULT NULL,
  `ext1` varchar(120) DEFAULT NULL COMMENT '扩展1',
  `ext2` datetime DEFAULT NULL COMMENT '扩展2',
  `ext3` decimal(10,0) DEFAULT NULL COMMENT '扩展3',
  `data_order` int(11) DEFAULT NULL,
  `signType` varchar(40) DEFAULT NULL,
  `userType` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`rowId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for gx_sys_att_rule
-- ----------------------------
DROP TABLE IF EXISTS `gx_sys_att_rule`;
CREATE TABLE `gx_sys_att_rule` (
  `row_id` varchar(80) NOT NULL COMMENT '主键',
  `rule_name` varchar(80) DEFAULT NULL COMMENT '规则名称',
  `rule_time` varchar(80) DEFAULT NULL COMMENT '规则时间段',
  `rule_period` varchar(80) DEFAULT NULL COMMENT '规则周期',
  `entrance_id` varchar(40) DEFAULT NULL COMMENT '门禁id',
  `rule_address` varchar(80) DEFAULT NULL COMMENT '门禁地址',
  `rule_equipment_name` varchar(80) DEFAULT NULL COMMENT '门禁考勤机名称',
  `org_row_id` varchar(40) DEFAULT NULL COMMENT '部门id',
  `com_bd_id` varchar(40) DEFAULT NULL,
  `org_name` varchar(80) DEFAULT NULL COMMENT '部门名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `status` varchar(40) DEFAULT NULL COMMENT '状态',
  `order_num` decimal(10,0) DEFAULT NULL COMMENT '排序',
  `ext1` varchar(120) DEFAULT NULL COMMENT '扩展1',
  `ext2` datetime DEFAULT NULL COMMENT '扩展2',
  `ext3` decimal(10,0) DEFAULT NULL COMMENT '扩展3',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for gx_sys_dic_index
-- ----------------------------
DROP TABLE IF EXISTS `gx_sys_dic_index`;
CREATE TABLE `gx_sys_dic_index` (
  `ROW_ID` varchar(40) NOT NULL DEFAULT '',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建日期',
  `CREATE_USER_ID` varchar(40) DEFAULT NULL COMMENT '创建用户id',
  `DIC_FUNCTION_NAME` varchar(80) DEFAULT NULL COMMENT '索引名称',
  `DIC_FUNCTION_ID` varchar(40) DEFAULT NULL COMMENT '索引功能ID',
  `DIC_FUNCTION_DEC` varchar(220) DEFAULT NULL COMMENT '索引显示内容',
  `DIC_FUNCTION_TYPE` varchar(10) DEFAULT NULL COMMENT '索引类型',
  `STATUS` varchar(10) DEFAULT NULL COMMENT '字典状态',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '最后更新时间',
  `ORDER_NUM` bigint(22) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`ROW_ID`),
  UNIQUE KEY `PK_SYS_DIC_INDEX` (`ROW_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for gx_sys_dic_record
-- ----------------------------
DROP TABLE IF EXISTS `gx_sys_dic_record`;
CREATE TABLE `gx_sys_dic_record` (
  `ROW_ID` varchar(40) NOT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `CREATE_USER_ID` varchar(40) DEFAULT NULL,
  `DIC_NAME` varchar(40) DEFAULT NULL,
  `DIC_ID` varchar(40) DEFAULT NULL,
  `DIC_SHOW_VAL` varchar(100) DEFAULT NULL,
  `DIC_VALUE` varchar(100) DEFAULT NULL,
  `DIC_TYPE` varchar(100) DEFAULT NULL,
  `STATUS` varchar(10) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `ORDER_NUM` bigint(22) DEFAULT NULL,
  `DIC_FUNCTION` varchar(10) DEFAULT NULL,
  `TABLE_ID` varchar(32) DEFAULT NULL,
  `PARENT_ID` varchar(40) DEFAULT NULL,
  `PARENT_NAME` varchar(40) DEFAULT NULL,
  `FLAG_ZM` varchar(40) DEFAULT NULL,
  `FLAG_RQ` varchar(40) DEFAULT NULL,
  `FLAG_NUM` varchar(40) DEFAULT NULL,
  `FLAG_WRITE` varchar(40) DEFAULT NULL,
  `max_status` varchar(40) DEFAULT NULL COMMENT '是否启用最大值配置（1启用，0否）',
  `max_id` varchar(40) DEFAULT NULL COMMENT '最大值的ID',
  PRIMARY KEY (`ROW_ID`),
  UNIQUE KEY `PK_SYS_DIC_RECORD` (`ROW_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for gx_sys_ent
-- ----------------------------
DROP TABLE IF EXISTS `gx_sys_ent`;
CREATE TABLE `gx_sys_ent` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `enrrance_address` varchar(80) DEFAULT NULL COMMENT '门禁地址',
  `entrance_address_as` varchar(40) DEFAULT NULL COMMENT '门禁地址别名',
  `entrance_equipment_name` varchar(80) DEFAULT NULL COMMENT '考勤机名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `status` varchar(40) DEFAULT NULL COMMENT '状态',
  `order_num` decimal(10,0) DEFAULT NULL COMMENT '排序',
  `ext1` varchar(120) DEFAULT NULL COMMENT '扩展1',
  `ext2` datetime DEFAULT NULL COMMENT '扩展2',
  `ext3` decimal(10,0) DEFAULT NULL COMMENT '扩展3',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for gx_sys_function
-- ----------------------------
DROP TABLE IF EXISTS `gx_sys_function`;
CREATE TABLE `gx_sys_function` (
  `row_id` bigint(40) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `function_name` varchar(80) NOT NULL COMMENT '菜单名称',
  `function_show_name` varchar(180) DEFAULT NULL COMMENT '菜单显示名称',
  `function_en_name` varchar(580) DEFAULT NULL COMMENT '菜单英文名称',
  `function_intro` varchar(40) DEFAULT NULL COMMENT '菜单说明',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(40) DEFAULT NULL COMMENT '创建者ID',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `modify_user_id` varchar(40) DEFAULT NULL COMMENT '修改人ID',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` bigint(11) DEFAULT NULL COMMENT '排序',
  `parent_function_id` varchar(40) DEFAULT NULL COMMENT '父菜单ID',
  `parent_function_name` varchar(80) DEFAULT NULL COMMENT '父菜单名称',
  `function_type` varchar(40) DEFAULT NULL COMMENT '菜单类别',
  `is_main_page` varchar(40) DEFAULT NULL COMMENT '是否为为主页图标',
  `function_icon` varchar(80) DEFAULT NULL COMMENT '菜单图标',
  `main_page_icon` varchar(40) DEFAULT NULL COMMENT '主页图标',
  `main_function_name` varchar(80) DEFAULT NULL COMMENT '主页显示名称',
  `main_order` int(11) DEFAULT NULL COMMENT '主页排序位',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3923 DEFAULT CHARSET=utf8 COMMENT='系统权限菜单表';

-- ----------------------------
-- Table structure for gx_sys_org
-- ----------------------------
DROP TABLE IF EXISTS `gx_sys_org`;
CREATE TABLE `gx_sys_org` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `org_name` varchar(80) DEFAULT NULL COMMENT '组织名称',
  `org_show_name` varchar(180) DEFAULT NULL COMMENT '组织显示名称',
  `org_en_name` varchar(80) DEFAULT NULL COMMENT '菜单英文名称',
  `org_intro` varchar(40) DEFAULT NULL COMMENT '组织说明',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(40) DEFAULT NULL COMMENT '创建者ID',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `modify_user_id` varchar(40) DEFAULT NULL COMMENT '修改人ID',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` bigint(11) DEFAULT NULL COMMENT '排序',
  `parent_org_id` varchar(40) DEFAULT NULL COMMENT '父组织ID',
  `parent_org_name` varchar(80) DEFAULT NULL COMMENT '父组织名称',
  `org_type` varchar(40) DEFAULT NULL COMMENT '组织类别',
  `is_main_page` varchar(40) DEFAULT NULL COMMENT '是否为虚拟组织',
  `org_bd_id` varchar(40) DEFAULT NULL,
  `org_bd_name` varchar(240) DEFAULT NULL,
  `org_com_id` varchar(40) DEFAULT NULL COMMENT '组织所属单位ID',
  `is_show` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统组织单位';

-- ----------------------------
-- Table structure for gx_sys_org_copy
-- ----------------------------
DROP TABLE IF EXISTS `gx_sys_org_copy`;
CREATE TABLE `gx_sys_org_copy` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `org_name` varchar(80) DEFAULT NULL COMMENT '组织名称',
  `org_show_name` varchar(180) DEFAULT NULL COMMENT '组织显示名称',
  `org_en_name` varchar(80) DEFAULT NULL COMMENT '菜单英文名称',
  `org_intro` varchar(40) DEFAULT NULL COMMENT '组织说明',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(40) DEFAULT NULL COMMENT '创建者ID',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `modify_user_id` varchar(40) DEFAULT NULL COMMENT '修改人ID',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` bigint(11) DEFAULT NULL COMMENT '排序',
  `parent_org_id` varchar(40) DEFAULT NULL COMMENT '父组织ID',
  `parent_org_name` varchar(80) DEFAULT NULL COMMENT '父组织名称',
  `org_type` varchar(40) DEFAULT NULL COMMENT '组织类别',
  `is_main_page` varchar(40) DEFAULT NULL COMMENT '是否为虚拟组织',
  `org_bd_id` varchar(40) DEFAULT NULL,
  `org_bd_name` varchar(240) DEFAULT NULL,
  `org_com_id` varchar(40) DEFAULT NULL COMMENT '组织所属单位ID',
  `is_show` varchar(1) DEFAULT NULL,
  `org_level` varchar(255) DEFAULT NULL COMMENT '层级:监理、施工单位、分包单位',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统组织单位';

-- ----------------------------
-- Table structure for gx_sys_org_tz
-- ----------------------------
DROP TABLE IF EXISTS `gx_sys_org_tz`;
CREATE TABLE `gx_sys_org_tz` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `org_name` varchar(80) DEFAULT NULL COMMENT '组织名称',
  `org_show_name` varchar(180) DEFAULT NULL COMMENT '组织显示名称',
  `org_en_name` varchar(80) DEFAULT NULL COMMENT '菜单英文名称',
  `org_intro` varchar(40) DEFAULT NULL COMMENT '组织说明',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(40) DEFAULT NULL COMMENT '创建者ID',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `modify_user_id` varchar(40) DEFAULT NULL COMMENT '修改人ID',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` bigint(11) DEFAULT NULL COMMENT '排序',
  `parent_org_id` varchar(40) DEFAULT NULL COMMENT '父组织ID',
  `parent_org_name` varchar(80) DEFAULT NULL COMMENT '父组织名称',
  `org_type` varchar(40) DEFAULT NULL COMMENT '组织类别',
  `is_main_page` varchar(40) DEFAULT NULL COMMENT '是否为虚拟组织',
  `org_bd_id` varchar(40) DEFAULT NULL,
  `org_bd_name` varchar(240) DEFAULT NULL,
  `org_com_id` varchar(40) DEFAULT NULL COMMENT '组织所属单位ID',
  `is_show` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统组织单位';

-- ----------------------------
-- Table structure for gx_sys_result
-- ----------------------------
DROP TABLE IF EXISTS `gx_sys_result`;
CREATE TABLE `gx_sys_result` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `result_type` varchar(40) DEFAULT NULL COMMENT '考勤结果',
  `result_type_change` varchar(40) DEFAULT NULL COMMENT '校准结果',
  `user_id` varchar(40) DEFAULT NULL COMMENT '用户id',
  `result_time` date DEFAULT NULL COMMENT '考勤时间',
  `attendance_status` varchar(40) DEFAULT NULL COMMENT '进/出状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `status` varchar(40) DEFAULT NULL COMMENT '状态',
  `order_num` decimal(10,0) DEFAULT NULL COMMENT '排序',
  `ext1` varchar(120) DEFAULT NULL COMMENT '扩展1',
  `ext2` datetime DEFAULT NULL COMMENT '扩展2',
  `ext3` decimal(10,0) DEFAULT NULL COMMENT '扩展3',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for gx_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `gx_sys_role`;
CREATE TABLE `gx_sys_role` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `role_name` varchar(80) DEFAULT NULL COMMENT '角色名称',
  `role_id` varchar(80) DEFAULT NULL COMMENT '角色ID',
  `role_intro` varchar(40) DEFAULT NULL COMMENT '角色说明',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(40) DEFAULT NULL COMMENT '创建者ID',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `modify_user_id` varchar(40) DEFAULT NULL COMMENT '修改人ID',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` bigint(11) DEFAULT NULL COMMENT '排序',
  `parent_role_id` varchar(40) DEFAULT NULL COMMENT '父角色ID',
  `parent_role_name` varchar(80) DEFAULT NULL COMMENT '父角色名称',
  `role_type` varchar(40) DEFAULT NULL COMMENT '角色类别',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色';

-- ----------------------------
-- Table structure for gx_sys_role_has_function
-- ----------------------------
DROP TABLE IF EXISTS `gx_sys_role_has_function`;
CREATE TABLE `gx_sys_role_has_function` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `function_id` bigint(80) NOT NULL COMMENT '菜单ID',
  `role_id` varchar(80) NOT NULL COMMENT '角色ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(40) DEFAULT NULL COMMENT '创建者ID',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` bigint(11) DEFAULT NULL COMMENT '排序',
  `rl_type` varchar(40) DEFAULT NULL COMMENT '关系类别',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色与权限关系表（注意关系表不存在更新操作）';

-- ----------------------------
-- Table structure for gx_sys_role_has_user
-- ----------------------------
DROP TABLE IF EXISTS `gx_sys_role_has_user`;
CREATE TABLE `gx_sys_role_has_user` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `user_id` varchar(80) NOT NULL COMMENT '用户ID',
  `role_id` varchar(80) NOT NULL COMMENT '角色ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(40) DEFAULT NULL COMMENT '创建者ID',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` bigint(11) DEFAULT NULL COMMENT '排序',
  `rl_type` varchar(40) DEFAULT NULL COMMENT '关系类别',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统人员与角色关系表（注意关系表不存在更新操作）';

-- ----------------------------
-- Table structure for gx_sys_score
-- ----------------------------
DROP TABLE IF EXISTS `gx_sys_score`;
CREATE TABLE `gx_sys_score` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `score_value` float DEFAULT NULL COMMENT '分数',
  `score_start` date DEFAULT NULL COMMENT '开始时间',
  `score_end` date DEFAULT NULL COMMENT '结束时间',
  `user_id` varchar(40) DEFAULT NULL COMMENT '用户id',
  `user_name` varchar(40) DEFAULT NULL COMMENT '姓名',
  `org_id` varchar(40) DEFAULT NULL COMMENT '部门id',
  `org_name` varchar(80) DEFAULT NULL COMMENT '部门名称',
  `org_bd_id` varchar(40) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `status` varchar(40) DEFAULT NULL COMMENT '状态',
  `order_num` decimal(10,0) DEFAULT NULL COMMENT '排序',
  `ext1` varchar(120) DEFAULT NULL COMMENT '扩展1',
  `ext2` datetime DEFAULT NULL COMMENT '扩展2',
  `ext3` decimal(10,0) DEFAULT NULL COMMENT '扩展3',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for gx_sys_score_record
-- ----------------------------
DROP TABLE IF EXISTS `gx_sys_score_record`;
CREATE TABLE `gx_sys_score_record` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `record_score` float DEFAULT NULL COMMENT '分值',
  `record_type` varchar(40) DEFAULT NULL COMMENT '加/减类型',
  `record_time` date DEFAULT NULL COMMENT '时间',
  `user_id` varchar(40) DEFAULT NULL COMMENT '用户id',
  `user_name` varchar(80) DEFAULT NULL COMMENT '姓名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `status` varchar(40) DEFAULT NULL COMMENT '状态',
  `order_num` decimal(10,0) DEFAULT NULL COMMENT '排序',
  `ext1` varchar(120) DEFAULT NULL COMMENT '扩展1',
  `ext2` datetime DEFAULT NULL COMMENT '扩展2',
  `ext3` decimal(10,0) DEFAULT NULL COMMENT '扩展3',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for gx_sys_score_rule
-- ----------------------------
DROP TABLE IF EXISTS `gx_sys_score_rule`;
CREATE TABLE `gx_sys_score_rule` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `score_default` float DEFAULT NULL COMMENT '初始分值',
  `score_half` float DEFAULT NULL COMMENT '旷工半天分值',
  `score_all` float DEFAULT NULL COMMENT '旷工全天分值',
  `score_late` float DEFAULT NULL COMMENT '迟到分值',
  `score_early` float DEFAULT NULL COMMENT '早退分值',
  `score_normal` float DEFAULT NULL COMMENT '正常分值',
  `org_row_id` varchar(40) DEFAULT NULL COMMENT '部门id',
  `org_name` varchar(80) DEFAULT NULL COMMENT '部门名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `status` varchar(40) DEFAULT NULL COMMENT '状态',
  `order_num` decimal(10,0) DEFAULT NULL COMMENT '排序',
  `ext1` varchar(120) DEFAULT NULL COMMENT '扩展1',
  `ext2` datetime DEFAULT NULL COMMENT '扩展2',
  `ext3` decimal(10,0) DEFAULT NULL COMMENT '扩展3',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for gx_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `gx_sys_user`;
CREATE TABLE `gx_sys_user` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `user_name` varchar(80) DEFAULT NULL COMMENT '用户名称',
  `user_show_name` varchar(180) DEFAULT NULL COMMENT '用户别名',
  `user_en_name` varchar(80) DEFAULT NULL COMMENT '用户英文名称',
  `user_id` varchar(80) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户帐号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(40) DEFAULT NULL COMMENT '创建者ID',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `modify_user_id` varchar(40) DEFAULT NULL COMMENT '修改人ID',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` int(11) DEFAULT NULL COMMENT '排序',
  `user_mobile_num` varchar(40) DEFAULT NULL COMMENT '手机号',
  `user_sex` varchar(80) DEFAULT NULL COMMENT '性别',
  `user_type` varchar(40) DEFAULT NULL COMMENT '用户类型',
  `user_photo` varchar(80) DEFAULT NULL COMMENT '用户头像',
  `user_mail` varchar(80) DEFAULT NULL COMMENT '邮件',
  `user_level` varchar(80) DEFAULT NULL COMMENT '学历',
  `power_level` int(11) DEFAULT NULL COMMENT '用户鉴权级别',
  `user_card_id` varchar(80) DEFAULT NULL COMMENT '身份证',
  `sys_color_id` varchar(80) DEFAULT NULL COMMENT '系统皮肤',
  `bd_name` varchar(80) DEFAULT NULL,
  `bd_id` varchar(80) DEFAULT NULL,
  `card_no` varchar(80) DEFAULT NULL,
  `client_id` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`row_id`),
  KEY `gxsysuseri1` (`row_id`,`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Table structure for gx_sys_user_in_org
-- ----------------------------
DROP TABLE IF EXISTS `gx_sys_user_in_org`;
CREATE TABLE `gx_sys_user_in_org` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `user_id` varchar(80) NOT NULL COMMENT '用户ID',
  `org_id` varchar(80) NOT NULL COMMENT '组织ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(40) DEFAULT NULL COMMENT '创建者ID',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` int(11) DEFAULT NULL COMMENT '排序',
  `rl_type` varchar(40) DEFAULT NULL COMMENT '关系类别',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统组织与人员关系表（注意关系表不存在更新操作）';

-- ----------------------------
-- Table structure for gx_sys_user_in_org_copy
-- ----------------------------
DROP TABLE IF EXISTS `gx_sys_user_in_org_copy`;
CREATE TABLE `gx_sys_user_in_org_copy` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `user_id` varchar(80) NOT NULL COMMENT '用户ID',
  `org_id` varchar(80) NOT NULL COMMENT '组织ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(40) DEFAULT NULL COMMENT '创建者ID',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` int(11) DEFAULT NULL COMMENT '排序',
  `rl_type` varchar(40) DEFAULT NULL COMMENT '关系类别',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统组织与人员关系表（注意关系表不存在更新操作）';

-- ----------------------------
-- Table structure for gx_sys_user_in_org_tz
-- ----------------------------
DROP TABLE IF EXISTS `gx_sys_user_in_org_tz`;
CREATE TABLE `gx_sys_user_in_org_tz` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `user_id` varchar(80) NOT NULL COMMENT '用户ID',
  `org_id` varchar(80) NOT NULL COMMENT '组织ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(40) DEFAULT NULL COMMENT '创建者ID',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` int(11) DEFAULT NULL COMMENT '排序',
  `rl_type` varchar(40) DEFAULT NULL COMMENT '关系类别',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统组织与人员关系表（注意关系表不存在更新操作）';

-- ----------------------------
-- Table structure for gx_view_column
-- ----------------------------
DROP TABLE IF EXISTS `gx_view_column`;
CREATE TABLE `gx_view_column` (
  `row_id` varchar(32) NOT NULL,
  `column_name` varchar(200) DEFAULT NULL COMMENT '栏目名称',
  `column_type` varchar(10) DEFAULT NULL COMMENT '栏目类型',
  `column_info` varchar(200) DEFAULT NULL COMMENT '栏目介绍',
  `order_num` int(11) DEFAULT NULL,
  `parent_id` varchar(32) DEFAULT NULL COMMENT '父节点ID',
  `column_icon` varchar(50) DEFAULT NULL,
  `create_user_id` varchar(32) DEFAULT NULL,
  `create_user_name` varchar(50) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `parent_name` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for gx_view_column_article
-- ----------------------------
DROP TABLE IF EXISTS `gx_view_column_article`;
CREATE TABLE `gx_view_column_article` (
  `row_id` varchar(50) NOT NULL,
  `article_title` varchar(500) DEFAULT NULL COMMENT '栏目文章标题',
  `article_content` longtext CHARACTER SET utf8mb4,
  `create_user_id` varchar(100) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `publish_time` date DEFAULT NULL COMMENT '发布时间',
  `source` varchar(255) DEFAULT NULL COMMENT '文章来源',
  `order_num` int(11) DEFAULT NULL,
  `comment` varchar(500) DEFAULT NULL,
  `article_type` varchar(50) DEFAULT NULL COMMENT '文档类型(图片新闻）',
  `article_status` varchar(50) DEFAULT NULL COMMENT '状态',
  `hits` int(20) DEFAULT NULL,
  `create_user_name` varchar(200) DEFAULT NULL,
  `is_news_pic` varchar(1) DEFAULT NULL COMMENT '是否为图片新闻',
  `pic_file_name` varchar(500) DEFAULT NULL COMMENT '图片名称',
  `pic_file_real_name` varchar(500) DEFAULT NULL,
  `video_file_name` varchar(500) DEFAULT NULL,
  `video_file_real_name` varchar(500) DEFAULT NULL,
  `voted_num` bigint(10) DEFAULT NULL,
  `is_vote` varchar(1) DEFAULT NULL,
  `vote_method` varchar(2) DEFAULT NULL COMMENT '选择模式（0单选，1多选）',
  `max_vote_num` int(11) DEFAULT NULL COMMENT '如果是多选，最多可以选几项',
  `vote_limit_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `bd_id` varchar(40) DEFAULT NULL,
  `bd_name` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for gx_view_column_article_relation
-- ----------------------------
DROP TABLE IF EXISTS `gx_view_column_article_relation`;
CREATE TABLE `gx_view_column_article_relation` (
  `row_id` varchar(50) NOT NULL,
  `column_id` varchar(50) DEFAULT NULL,
  `article_id` varchar(50) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user_id` varchar(32) DEFAULT NULL,
  `order_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for history_opinion
-- ----------------------------
DROP TABLE IF EXISTS `history_opinion`;
CREATE TABLE `history_opinion` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `table_id` varchar(40) DEFAULT NULL COMMENT '关联业务表ID',
  `pi_id` varchar(40) DEFAULT NULL COMMENT '流程实例ID',
  `handle_stage` varchar(40) DEFAULT NULL COMMENT '办理阶段名称',
  `handle_process` varchar(40) DEFAULT NULL COMMENT '办理过程',
  `handle_user` varchar(40) DEFAULT NULL COMMENT '办理人',
  `handle_time` datetime DEFAULT NULL COMMENT '办理时间',
  `handle_opinion` varchar(200) DEFAULT NULL COMMENT '办理意见',
  `data_type` varchar(40) DEFAULT NULL COMMENT '类别',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` int(11) DEFAULT NULL COMMENT '排序',
  `data_deleted` varchar(40) DEFAULT NULL COMMENT '删除',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for map_record
-- ----------------------------
DROP TABLE IF EXISTS `map_record`;
CREATE TABLE `map_record` (
  `row_id` varchar(40) NOT NULL,
  `address_wl` varchar(80) DEFAULT NULL COMMENT '物理地址',
  `address_jd` varchar(40) DEFAULT NULL COMMENT '经度',
  `address_wd` varchar(40) DEFAULT NULL COMMENT '维度',
  `user_id` varchar(80) DEFAULT NULL COMMENT '用户ID',
  `user_name` varchar(40) DEFAULT NULL COMMENT '人员姓名',
  `person_phone` varchar(40) DEFAULT NULL COMMENT '用户手机号',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `upload_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `bd_id` varchar(40) DEFAULT NULL,
  `bd_name` varchar(40) DEFAULT NULL,
  `status` varchar(40) DEFAULT NULL COMMENT '状态',
  `ext1` varchar(40) DEFAULT NULL,
  `ext2` varchar(40) DEFAULT NULL,
  `ext3` varchar(40) DEFAULT NULL,
  `ext4` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for map_today
-- ----------------------------
DROP TABLE IF EXISTS `map_today`;
CREATE TABLE `map_today` (
  `row_id` varchar(40) NOT NULL,
  `address_wl` varchar(80) DEFAULT NULL COMMENT '物理地址',
  `address_jd` varchar(40) DEFAULT NULL COMMENT '经度',
  `address_wd` varchar(40) DEFAULT NULL COMMENT '维度',
  `user_id` varchar(80) DEFAULT NULL COMMENT '用户ID',
  `user_name` varchar(40) DEFAULT NULL COMMENT '人员姓名',
  `person_phone` varchar(40) DEFAULT NULL COMMENT '用户手机号',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `upload_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `bd_id` varchar(40) DEFAULT NULL,
  `bd_name` varchar(40) DEFAULT NULL,
  `status` varchar(40) DEFAULT NULL COMMENT '状态',
  `ext1` varchar(40) DEFAULT NULL,
  `ext2` varchar(40) DEFAULT NULL,
  `ext3` varchar(40) DEFAULT NULL,
  `ext4` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for material_count
-- ----------------------------
DROP TABLE IF EXISTS `material_count`;
CREATE TABLE `material_count` (
  `row_id` varchar(40) NOT NULL,
  `material_type` varchar(40) DEFAULT NULL COMMENT '物料类型',
  `material_count` int(11) DEFAULT NULL COMMENT '物料使用量',
  `bd_id` varchar(80) DEFAULT NULL,
  `bd_name` varchar(80) DEFAULT NULL,
  `create_name` varchar(80) DEFAULT NULL COMMENT '创建人姓名',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `upload_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `ext1` varchar(80) DEFAULT NULL,
  `ext2` varchar(80) DEFAULT NULL,
  `ext3` varchar(80) DEFAULT NULL,
  `ext4` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for material_info
-- ----------------------------
DROP TABLE IF EXISTS `material_info`;
CREATE TABLE `material_info` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `material_type` varchar(40) DEFAULT NULL COMMENT '材料种类',
  `material_name` varchar(40) DEFAULT NULL COMMENT '材料名称',
  `material_model` varchar(40) DEFAULT NULL COMMENT '型号规格',
  `manufacturer` varchar(40) DEFAULT NULL COMMENT '生厂厂家',
  `manager_person` varchar(40) DEFAULT NULL COMMENT '管理人员',
  `telephone` varchar(40) DEFAULT NULL COMMENT '电话',
  `enter_time` timestamp NULL DEFAULT NULL COMMENT '进场时间',
  `outer_time` varchar(40) DEFAULT NULL COMMENT '出场时间',
  `enter_number` double DEFAULT NULL COMMENT '进场数量',
  `measurement_unit` varchar(40) DEFAULT NULL COMMENT '计量单位',
  `use_site` varchar(60) DEFAULT NULL COMMENT '使用部位',
  `batch_number` varchar(40) DEFAULT NULL COMMENT '批号',
  `test_status` varchar(40) DEFAULT NULL COMMENT '送检状态',
  `certificate_num` varchar(40) DEFAULT NULL COMMENT '合格证编号',
  `custom_message` varchar(200) DEFAULT NULL COMMENT '自定义信息',
  `monitoring_report` varchar(200) DEFAULT NULL COMMENT '监测报告',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(40) DEFAULT NULL COMMENT '创建人ID',
  `create_user_name` varchar(40) DEFAULT NULL COMMENT '创建人姓名',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` varchar(40) DEFAULT NULL COMMENT '修改人ID',
  `update_user_name` varchar(40) DEFAULT NULL COMMENT '修改人姓名',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` int(11) DEFAULT NULL COMMENT '排序',
  `ext1` varchar(40) DEFAULT NULL COMMENT '当日物料使用量',
  `ext2` datetime DEFAULT NULL COMMENT '扩展2',
  `ext3` int(11) DEFAULT NULL COMMENT '扩展3',
  `org_dw_id` varchar(40) DEFAULT NULL COMMENT '单位ID',
  `bd_id` varchar(40) DEFAULT NULL COMMENT '标段ID',
  `strength_grade` varchar(40) DEFAULT NULL COMMENT '强度等级（混凝土）',
  `curing_condition` varchar(40) DEFAULT NULL COMMENT '养护条件（混凝土）',
  `report_number` varchar(40) DEFAULT NULL COMMENT '报告编号（混凝土）',
  `test_item` varchar(40) DEFAULT NULL COMMENT '检测项目（混凝土）',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='材料信息表';

-- ----------------------------
-- Table structure for material_track
-- ----------------------------
DROP TABLE IF EXISTS `material_track`;
CREATE TABLE `material_track` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `relation_id` varchar(40) DEFAULT NULL COMMENT '关联表主键',
  `material_type` varchar(40) DEFAULT NULL COMMENT '材料种类',
  `use_number` int(11) DEFAULT NULL COMMENT '使用数量',
  `use_time` datetime DEFAULT NULL COMMENT '使用时间',
  `use_reason` varchar(200) DEFAULT NULL COMMENT '用途',
  `operator_id` varchar(40) DEFAULT NULL COMMENT '操作人ID',
  `opertaor_name` varchar(40) DEFAULT NULL COMMENT '操作人姓名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(40) DEFAULT NULL COMMENT '创建人ID',
  `create_user_name` varchar(40) DEFAULT NULL COMMENT '创建人姓名',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` varchar(40) DEFAULT NULL COMMENT '排序',
  `ext1` varchar(40) DEFAULT NULL COMMENT '扩展1',
  `ext2` datetime DEFAULT NULL COMMENT '扩展2',
  `ext3` int(11) DEFAULT NULL COMMENT '扩展3',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='材料跟踪表';

-- ----------------------------
-- Table structure for materiel_test
-- ----------------------------
DROP TABLE IF EXISTS `materiel_test`;
CREATE TABLE `materiel_test` (
  `row_id` varchar(40) NOT NULL,
  `report_no` varchar(40) DEFAULT NULL COMMENT '报告编号',
  `materiel_type` varchar(40) DEFAULT NULL COMMENT '物料品种',
  `materiel_level` varchar(40) DEFAULT NULL COMMENT '级别',
  `materiel_model` varchar(40) DEFAULT NULL COMMENT '规格型号',
  `report_date` date DEFAULT NULL COMMENT '报告日期',
  `manufacturer` varchar(40) DEFAULT NULL COMMENT '生产厂家',
  `enter_number` double DEFAULT NULL COMMENT '进场数量',
  `enter_ph` varchar(40) DEFAULT NULL COMMENT '进场批号',
  `enter_date` date DEFAULT NULL COMMENT '进场日期',
  `use_site` varchar(40) DEFAULT NULL COMMENT '使用部位',
  `sample_place` varchar(40) DEFAULT NULL COMMENT '取样地点',
  `sample_date` date DEFAULT NULL COMMENT '取样日期',
  `sample_user` varchar(40) DEFAULT NULL COMMENT '取样人',
  `witness` varchar(40) DEFAULT NULL COMMENT '见证人',
  `remark` varchar(120) DEFAULT NULL COMMENT '备注',
  `create_user_id` varchar(40) DEFAULT NULL,
  `create_user_name` varchar(40) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user_id` varchar(40) DEFAULT NULL,
  `update_user_name` varchar(40) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `com_org_id` varchar(40) DEFAULT NULL,
  `com_bd_id` varchar(40) DEFAULT NULL,
  `ext1` varchar(40) DEFAULT NULL,
  `ext2` int(11) DEFAULT NULL,
  `ext3` datetime DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for meeting_room_lease_apply
-- ----------------------------
DROP TABLE IF EXISTS `meeting_room_lease_apply`;
CREATE TABLE `meeting_room_lease_apply` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `applicant_name` varchar(40) DEFAULT NULL COMMENT '姓名',
  `applicant_phone` varchar(40) DEFAULT NULL COMMENT '手机号',
  `applicant_id_card` varchar(40) DEFAULT NULL COMMENT '身份证',
  `company_name` varchar(40) DEFAULT NULL COMMENT '公司名称',
  `start_time` datetime DEFAULT NULL COMMENT '会议开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '会议结束时间',
  `selected_room` varchar(40) DEFAULT NULL COMMENT '选择会议室',
  `create_user_id` varchar(40) DEFAULT NULL COMMENT '创建人ID',
  `create_user_name` varchar(40) DEFAULT NULL COMMENT '创建人姓名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_user_id` varchar(40) DEFAULT NULL COMMENT '修改人ID',
  `modify_user_name` varchar(40) DEFAULT NULL COMMENT '修改人姓名',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `data_type` varchar(40) DEFAULT NULL COMMENT '类别',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` varchar(40) DEFAULT NULL COMMENT '排序',
  `data_deleted` varchar(40) DEFAULT NULL COMMENT '删除',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='会议室租赁申请表';

-- ----------------------------
-- Table structure for org_data_order_default
-- ----------------------------
DROP TABLE IF EXISTS `org_data_order_default`;
CREATE TABLE `org_data_order_default` (
  `row_id` varchar(80) NOT NULL,
  `org_id` varchar(80) DEFAULT NULL,
  `org_name` varchar(80) DEFAULT NULL,
  `p_org_id` varchar(80) DEFAULT NULL,
  `o_org_name` varchar(80) DEFAULT NULL,
  `data_order` varchar(80) DEFAULT NULL,
  `ext1` int(11) DEFAULT NULL,
  `ext2` date DEFAULT NULL,
  `ext3` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for proc_act
-- ----------------------------
DROP TABLE IF EXISTS `proc_act`;
CREATE TABLE `proc_act` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `process_id` varchar(40) DEFAULT NULL COMMENT '关联流程模板表流程ID',
  `act_id` varchar(40) DEFAULT NULL COMMENT '节点ID',
  `act_name` varchar(40) DEFAULT NULL COMMENT '节点名称',
  `act_explain` varchar(240) DEFAULT NULL COMMENT '节点说明',
  `handle_user_name` varchar(40) DEFAULT NULL COMMENT '办理人',
  `handle_user_name1` varchar(40) DEFAULT NULL COMMENT '预备办理人',
  `back_act` varchar(40) DEFAULT NULL COMMENT '上一步',
  `next_act` varchar(40) DEFAULT NULL COMMENT '下一步',
  `act_order` decimal(8,0) DEFAULT NULL COMMENT '顺序',
  `data_type` varchar(40) DEFAULT NULL COMMENT '类别',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_deleted` varchar(40) DEFAULT '1' COMMENT '删除状态',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='流程节点表';

-- ----------------------------
-- Table structure for proc_act_instance
-- ----------------------------
DROP TABLE IF EXISTS `proc_act_instance`;
CREATE TABLE `proc_act_instance` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `process_id` varchar(40) DEFAULT NULL COMMENT '关联流程模板表的流程ID ',
  `instance_id` varchar(40) DEFAULT NULL COMMENT '关联流程实例表流程实例ID',
  `business_id` varchar(40) DEFAULT NULL COMMENT '流程业务ID',
  `act_id` varchar(40) DEFAULT NULL COMMENT '关联流程节点表节点ID',
  `act_name` varchar(40) DEFAULT NULL COMMENT '流程节点名称',
  `handle_user` varchar(40) DEFAULT NULL COMMENT '办理人',
  `handle_user1` varchar(40) DEFAULT NULL COMMENT '预备办理人',
  `act_back` varchar(40) DEFAULT NULL COMMENT '上一步',
  `act_next` varchar(40) DEFAULT NULL COMMENT '下一步',
  `act_order` decimal(8,0) DEFAULT NULL COMMENT '顺序',
  `act_inst_remark` varchar(240) DEFAULT NULL COMMENT '备注',
  `active_state` varchar(40) DEFAULT NULL COMMENT '激活状态',
  `active_user_id` varchar(40) DEFAULT NULL COMMENT '激活人ID',
  `active_user_name` varchar(40) DEFAULT NULL COMMENT '激活人姓名',
  `active_time` datetime DEFAULT NULL COMMENT '激活（开始）时间',
  `finish_time` datetime DEFAULT NULL COMMENT '完成（结束）时间',
  `step_state` varchar(40) DEFAULT NULL COMMENT '节点状态',
  `time_limit` datetime DEFAULT NULL COMMENT '监督时限',
  `data_type` varchar(40) DEFAULT NULL COMMENT '类别',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_deleted` varchar(40) DEFAULT '1' COMMENT '删除状态',
  PRIMARY KEY (`row_id`),
  KEY `流程实例ID` (`instance_id`) USING BTREE COMMENT '流程实例ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='流程节点实例表';

-- ----------------------------
-- Table structure for proc_instance
-- ----------------------------
DROP TABLE IF EXISTS `proc_instance`;
CREATE TABLE `proc_instance` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `process_id` varchar(40) DEFAULT NULL COMMENT '关联流程模板表流程ID',
  `process_name` varchar(40) DEFAULT NULL COMMENT '流程名称',
  `business_id` varchar(40) DEFAULT NULL COMMENT '关联业务表ID',
  `instance_state` varchar(40) DEFAULT NULL COMMENT '流程实例状态',
  `active_state` varchar(40) DEFAULT NULL COMMENT '激活状态',
  `active_user_name` varchar(40) DEFAULT NULL COMMENT '激活人姓名',
  `time_limit` datetime DEFAULT NULL COMMENT '监督时限',
  `create_time` datetime DEFAULT NULL COMMENT '实例创建时间',
  `end_time` datetime DEFAULT NULL COMMENT '实例结束时间',
  `create_user_id` varchar(40) DEFAULT NULL COMMENT '创建人ID',
  `create_user_name` varchar(40) DEFAULT NULL COMMENT '创建人姓名',
  `data_type` varchar(40) DEFAULT NULL COMMENT '类别',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` decimal(8,0) DEFAULT NULL COMMENT '排序',
  `data_deleted` varchar(40) DEFAULT '1' COMMENT '删除状态',
  PRIMARY KEY (`row_id`),
  KEY `业务表ID` (`business_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='流程实例表';

-- ----------------------------
-- Table structure for proc_template
-- ----------------------------
DROP TABLE IF EXISTS `proc_template`;
CREATE TABLE `proc_template` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `process_name` varchar(40) DEFAULT NULL COMMENT '流程名称',
  `process_key` varchar(40) DEFAULT NULL COMMENT '流程key',
  `process_id` varchar(40) DEFAULT NULL COMMENT '流程ID',
  `process_explain` varchar(240) DEFAULT NULL COMMENT '流程说明',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(40) DEFAULT NULL COMMENT '创建人ID',
  `create_user_name` varchar(40) DEFAULT NULL COMMENT '创建人姓名',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `modify_user_id` varchar(40) DEFAULT NULL COMMENT '修改人ID',
  `modify_user_name` varchar(40) DEFAULT NULL COMMENT '修改人姓名',
  `data_type` varchar(40) DEFAULT NULL COMMENT '类别',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` decimal(8,0) DEFAULT NULL COMMENT '排序',
  `data_deleted` varchar(40) DEFAULT '1' COMMENT '删除状态 0：删除 1：有效',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='审批流程模板表';

-- ----------------------------
-- Table structure for robot_words
-- ----------------------------
DROP TABLE IF EXISTS `robot_words`;
CREATE TABLE `robot_words` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `rwords_type` varchar(140) DEFAULT NULL COMMENT '词组类别',
  `ask_rwords` varchar(540) DEFAULT NULL COMMENT '问句词组',
  `answer_rwords` varchar(540) DEFAULT NULL COMMENT '回复词组',
  `next_rwords` varchar(50) DEFAULT NULL COMMENT '下一词组猜想',
  `rwords_status` varchar(20) DEFAULT NULL COMMENT '词组状态',
  `rwords_order` decimal(10,0) DEFAULT NULL COMMENT '词组优先级',
  `rwords_id` varchar(120) DEFAULT NULL COMMENT '传感器所属标段',
  `create_time` datetime DEFAULT NULL COMMENT '传感器类型',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `ext1` varchar(140) DEFAULT NULL COMMENT '扩展1',
  `ext2` datetime DEFAULT NULL COMMENT '扩展2',
  `ext3` decimal(10,0) DEFAULT NULL COMMENT '扩展3',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='机器人词汇索引表';

-- ----------------------------
-- Table structure for sensor_data_record_history
-- ----------------------------
DROP TABLE IF EXISTS `sensor_data_record_history`;
CREATE TABLE `sensor_data_record_history` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `sensor_site_name` varchar(140) DEFAULT NULL COMMENT '传感器站名',
  `sensor_site_jd` varchar(20) DEFAULT NULL COMMENT '传感器经度',
  `sensor_site_wd` varchar(20) DEFAULT NULL COMMENT '传感器纬度',
  `sensor_site_id` varchar(40) DEFAULT NULL COMMENT '传感器设备ID',
  `sensor_site_bd` varchar(120) DEFAULT NULL COMMENT '传感器所属标段',
  `sensor_site_bd_id` varchar(40) DEFAULT NULL COMMENT '传感器所属标段ID',
  `sensor_site_type` varchar(40) DEFAULT NULL COMMENT '传感器所类别',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `status` varchar(20) DEFAULT NULL COMMENT '状态',
  `order_num` decimal(10,0) DEFAULT NULL COMMENT '排序',
  `sensor_data_pm25` varchar(10) DEFAULT NULL COMMENT '扩展1',
  `sensor_data_pm10` varchar(10) DEFAULT NULL COMMENT '扩展2',
  `sensor_data_humidity` decimal(10,0) DEFAULT NULL COMMENT '扩展3',
  `sensor_data_wind_speed` varchar(20) DEFAULT NULL COMMENT '风速',
  `sensor_data_wind_direction` varchar(20) DEFAULT NULL COMMENT '风向',
  `sensor_data_temperature` varchar(20) DEFAULT NULL COMMENT '温度',
  `sensor_data_ext1` varchar(20) DEFAULT NULL COMMENT '噪音',
  `sensor_data_ext2` varchar(20) DEFAULT NULL COMMENT '养护室温度',
  `sensor_data_ext3` varchar(20) DEFAULT NULL COMMENT '养护室湿度',
  `sensor_data_ext4` varchar(20) DEFAULT NULL COMMENT '扩展',
  `sensor_data_ext5` varchar(20) DEFAULT NULL COMMENT '扩展',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='传感器数据历史记录表';

-- ----------------------------
-- Table structure for sensor_data_record_reltime
-- ----------------------------
DROP TABLE IF EXISTS `sensor_data_record_reltime`;
CREATE TABLE `sensor_data_record_reltime` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `sensor_site_name` varchar(140) DEFAULT NULL COMMENT '传感器站名',
  `sensor_site_jd` varchar(20) DEFAULT NULL COMMENT '传感器经度',
  `sensor_site_wd` varchar(20) DEFAULT NULL COMMENT '传感器纬度',
  `sensor_site_id` varchar(40) DEFAULT NULL COMMENT '传感器设备ID',
  `sensor_site_bd` varchar(120) DEFAULT NULL COMMENT '传感器所属标段',
  `sensor_site_bd_id` varchar(40) DEFAULT NULL COMMENT '传感器所属标段ID',
  `sensor_site_type` varchar(40) DEFAULT NULL COMMENT '传感器所类别',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `status` varchar(20) DEFAULT NULL COMMENT '状态',
  `order_num` decimal(10,0) DEFAULT NULL COMMENT '排序',
  `sensor_data_pm25` varchar(10) DEFAULT NULL COMMENT '扩展1',
  `sensor_data_pm10` varchar(10) DEFAULT NULL COMMENT '扩展2',
  `sensor_data_humidity` varchar(10) DEFAULT NULL COMMENT '扩展3',
  `sensor_data_wind_speed` varchar(20) DEFAULT NULL COMMENT '风速',
  `sensor_data_wind_direction` varchar(20) DEFAULT NULL COMMENT '风向',
  `sensor_data_temperature` varchar(20) DEFAULT NULL COMMENT '温度',
  `sensor_data_ext1` varchar(20) DEFAULT NULL COMMENT '扩展1',
  `sensor_data_ext2` varchar(20) DEFAULT NULL COMMENT '扩展',
  `sensor_data_ext3` varchar(20) DEFAULT NULL COMMENT '扩展',
  `sensor_data_ext4` varchar(20) DEFAULT NULL COMMENT '扩展',
  `sensor_data_ext5` varchar(20) DEFAULT NULL COMMENT '扩展',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='传感器数据实时表';

-- ----------------------------
-- Table structure for sensor_index
-- ----------------------------
DROP TABLE IF EXISTS `sensor_index`;
CREATE TABLE `sensor_index` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `sensor_site_name` varchar(140) DEFAULT NULL COMMENT '传感器站名',
  `sensor_site_address` varchar(240) DEFAULT NULL COMMENT '传感器地址',
  `sensor_site_desc` varchar(240) DEFAULT NULL COMMENT '传感器介绍',
  `sensor_site_jd` varchar(20) DEFAULT NULL COMMENT '传感器经度',
  `sensor_site_wd` varchar(20) DEFAULT NULL COMMENT '传感器纬度',
  `sensor_site_id` varchar(40) DEFAULT NULL COMMENT '传感器设备ID',
  `sensor_site_bd` varchar(120) DEFAULT NULL COMMENT '传感器所属标段',
  `sensor_site_bd_id` varchar(40) DEFAULT NULL COMMENT '传感器所属标段ID',
  `sensor_site_type` varchar(40) DEFAULT NULL COMMENT '传感器所属类别',
  `create_time` datetime DEFAULT NULL COMMENT '传感器类型',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `status` varchar(20) DEFAULT NULL COMMENT '状态',
  `order_num` decimal(10,0) DEFAULT NULL COMMENT '排序',
  `ext1` varchar(140) DEFAULT NULL COMMENT '扩展1',
  `ext2` datetime DEFAULT NULL COMMENT '扩展2',
  `ext3` decimal(10,0) DEFAULT NULL COMMENT '扩展3',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='传感器索引表';

-- ----------------------------
-- Table structure for sxpz_record
-- ----------------------------
DROP TABLE IF EXISTS `sxpz_record`;
CREATE TABLE `sxpz_record` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `sxpz_id` varchar(40) DEFAULT NULL COMMENT '事项ID',
  `sxpz_name` varchar(240) DEFAULT NULL COMMENT '事项名称',
  `sxpz_com_id` varchar(240) DEFAULT NULL COMMENT '事项公司ID',
  `sxpz_bd_id` varchar(240) DEFAULT NULL COMMENT '事项标段ID',
  `sxpz_com_name` varchar(50) DEFAULT NULL COMMENT '事项公司名',
  `sxpz_status` varchar(20) DEFAULT NULL COMMENT '事项状态',
  `sxpz_order` decimal(10,0) DEFAULT NULL COMMENT '事项排序',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `v1` varchar(20) DEFAULT NULL COMMENT '进场人数',
  `v2` varchar(20) DEFAULT NULL COMMENT '进场设备数目',
  `v3` varchar(20) DEFAULT NULL COMMENT '当日进出物料',
  `v4` varchar(20) DEFAULT NULL COMMENT '当日使用物料',
  `v5` varchar(20) DEFAULT NULL COMMENT '噪音',
  `v6` varchar(20) DEFAULT NULL COMMENT '风速',
  `v7` varchar(20) DEFAULT NULL COMMENT '风向',
  `h1` varchar(20) DEFAULT NULL COMMENT '温度',
  `h2` varchar(20) DEFAULT NULL COMMENT '湿度',
  `h3` varchar(20) DEFAULT NULL COMMENT 'pm2.5',
  `h4` varchar(20) DEFAULT NULL COMMENT 'pm10',
  `h5` varchar(20) DEFAULT NULL,
  `bd_intro` varchar(2500) DEFAULT NULL,
  `b1` varchar(20) DEFAULT NULL COMMENT '养护室温度',
  `b2` varchar(20) DEFAULT NULL COMMENT '养护室湿度',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='事项配置表';

-- ----------------------------
-- Table structure for sys_type_dic
-- ----------------------------
DROP TABLE IF EXISTS `sys_type_dic`;
CREATE TABLE `sys_type_dic` (
  `rowId` varchar(40) NOT NULL COMMENT '主键',
  `dic_name` varchar(40) DEFAULT NULL COMMENT '字典名称',
  `dic_type` varchar(40) DEFAULT NULL COMMENT '类别',
  `dic_total` int(11) DEFAULT NULL COMMENT '统计',
  `data_ordre` varchar(40) DEFAULT NULL COMMENT '排序',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_delete` varchar(40) DEFAULT NULL COMMENT '删除',
  PRIMARY KEY (`rowId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for unqualified_test
-- ----------------------------
DROP TABLE IF EXISTS `unqualified_test`;
CREATE TABLE `unqualified_test` (
  `row_id` varchar(40) NOT NULL,
  `material_name` varchar(40) DEFAULT NULL COMMENT '材料名称',
  `entrust_date` date DEFAULT NULL COMMENT '委托日期',
  `test_date` date DEFAULT NULL COMMENT '试验日期',
  `use_position` varchar(120) DEFAULT NULL COMMENT '使用部位',
  `test_project` varchar(40) DEFAULT NULL COMMENT '检测项目',
  `test_report_no` varchar(40) DEFAULT NULL COMMENT '检测报告编号',
  `test_result` varchar(40) DEFAULT NULL COMMENT '检测结果',
  `cj_fj` varchar(40) DEFAULT NULL COMMENT '初检/复检',
  `handle_opinion` varchar(40) DEFAULT NULL COMMENT '处理意见',
  `handle_result` varchar(40) DEFAULT NULL COMMENT '处理结果',
  `qualified_report_no` varchar(40) DEFAULT NULL COMMENT '合格报告编号',
  `remark` varchar(120) DEFAULT NULL COMMENT '备注',
  `create_user_id` varchar(40) DEFAULT NULL,
  `create_user_name` varchar(40) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user_id` varchar(40) DEFAULT NULL,
  `update_user_name` varchar(40) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `com_org_id` varchar(40) DEFAULT NULL,
  `com_bd_id` varchar(40) DEFAULT NULL,
  `ext1` varchar(40) DEFAULT NULL COMMENT '备用字段1',
  `ext2` int(11) DEFAULT NULL,
  `ext3` datetime DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for unqualified_test_jczx
-- ----------------------------
DROP TABLE IF EXISTS `unqualified_test_jczx`;
CREATE TABLE `unqualified_test_jczx` (
  `row_id` varchar(40) NOT NULL,
  `material_name` varchar(40) DEFAULT NULL COMMENT '材料名称',
  `entrust_date` date DEFAULT NULL COMMENT '委托日期',
  `test_date` date DEFAULT NULL COMMENT '试验日期',
  `use_position` varchar(120) DEFAULT NULL COMMENT '使用部位',
  `test_project` varchar(40) DEFAULT NULL COMMENT '检测项目',
  `test_report_no` varchar(40) DEFAULT NULL COMMENT '检测报告编号',
  `test_result` varchar(40) DEFAULT NULL COMMENT '检测结果',
  `cj_fj` varchar(40) DEFAULT NULL COMMENT '初检/复检',
  `handle_opinion` varchar(40) DEFAULT NULL COMMENT '处理意见',
  `handle_result` varchar(40) DEFAULT NULL COMMENT '处理结果',
  `qualified_report_no` varchar(40) DEFAULT NULL COMMENT '合格报告编号',
  `remark` varchar(120) DEFAULT NULL COMMENT '备注',
  `create_user_id` varchar(40) DEFAULT NULL,
  `create_user_name` varchar(40) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user_id` varchar(40) DEFAULT NULL,
  `update_user_name` varchar(40) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `com_org_id` varchar(40) DEFAULT NULL,
  `com_bd_id` varchar(40) DEFAULT NULL,
  `ext1` varchar(40) DEFAULT NULL COMMENT '备用字段1',
  `ext2` int(11) DEFAULT NULL,
  `ext3` datetime DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for weekly_report
-- ----------------------------
DROP TABLE IF EXISTS `weekly_report`;
CREATE TABLE `weekly_report` (
  `row_id` varchar(40) NOT NULL,
  `this_week_work` longtext COMMENT '本周工作',
  `other_work` varchar(1000) DEFAULT NULL COMMENT '其他事项',
  `bd_id` varchar(40) DEFAULT NULL,
  `bd_name` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `ext1` varchar(255) DEFAULT NULL,
  `ext2` varchar(255) DEFAULT NULL,
  `ext3` varchar(255) DEFAULT NULL,
  `ext4` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for weekly_report_project
-- ----------------------------
DROP TABLE IF EXISTS `weekly_report_project`;
CREATE TABLE `weekly_report_project` (
  `row_id` varchar(40) NOT NULL,
  `this_week_work` longtext COMMENT '本周工作',
  `other_work` varchar(1000) DEFAULT NULL COMMENT '其他事项',
  `bd_id` varchar(40) DEFAULT NULL,
  `bd_name` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `ext1` varchar(255) DEFAULT NULL,
  `ext2` varchar(255) DEFAULT NULL,
  `ext3` varchar(255) DEFAULT NULL,
  `ext4` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for wl_import_record
-- ----------------------------
DROP TABLE IF EXISTS `wl_import_record`;
CREATE TABLE `wl_import_record` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `file_name` varchar(100) DEFAULT NULL COMMENT '附件名称',
  `file_type` varchar(100) DEFAULT NULL COMMENT '附件类型',
  `file_identify_name` varchar(100) DEFAULT NULL COMMENT '附件上传后保存名',
  `file_path` varchar(100) DEFAULT NULL COMMENT '附件路径',
  `upload_user_id` varchar(40) DEFAULT NULL COMMENT '上传人ID',
  `upload_user_name` varchar(40) DEFAULT NULL COMMENT '上传人姓名',
  `upload_time` datetime DEFAULT NULL COMMENT '上传时间',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` varchar(40) DEFAULT NULL COMMENT '排序',
  `data_delete` varchar(40) DEFAULT NULL COMMENT '删除',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='附件记录表';

-- ----------------------------
-- Table structure for worksite_index
-- ----------------------------
DROP TABLE IF EXISTS `worksite_index`;
CREATE TABLE `worksite_index` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `worksite_name` varchar(140) DEFAULT NULL COMMENT '工点名',
  `worksite_address` varchar(240) DEFAULT NULL COMMENT '工点地址',
  `worksite_jd` varchar(20) DEFAULT NULL COMMENT '工点经度',
  `worksite_wd` varchar(20) DEFAULT NULL COMMENT '工点纬度',
  `worksite_id` varchar(40) DEFAULT NULL COMMENT '工点ID',
  `bd_name` varchar(120) DEFAULT NULL COMMENT '所属标段名',
  `bd_id` varchar(40) DEFAULT NULL COMMENT '标段ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `status` varchar(20) DEFAULT NULL COMMENT '状态',
  `order_num` decimal(10,0) DEFAULT NULL COMMENT '排序',
  `ext1` varchar(200) DEFAULT NULL COMMENT '工点简介',
  `ext2` datetime DEFAULT NULL COMMENT '扩展2',
  `ext3` decimal(10,0) DEFAULT NULL COMMENT '扩展3',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='传感器索引表';

-- ----------------------------
-- Table structure for worksite_record
-- ----------------------------
DROP TABLE IF EXISTS `worksite_record`;
CREATE TABLE `worksite_record` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `worksite_id` varchar(40) DEFAULT NULL COMMENT '事项ID',
  `worksit_name` varchar(240) DEFAULT NULL COMMENT '事项名称',
  `bd_id` varchar(240) DEFAULT NULL COMMENT '事项标段ID',
  `status` varchar(20) DEFAULT NULL COMMENT '事项状态',
  `order_num` decimal(10,0) DEFAULT NULL COMMENT '事项排序',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `bd_intro` varchar(2500) DEFAULT NULL,
  `bd_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='事项配置表';

-- ----------------------------
-- Table structure for yc_monitor
-- ----------------------------
DROP TABLE IF EXISTS `yc_monitor`;
CREATE TABLE `yc_monitor` (
  `rowId` varchar(80) NOT NULL,
  `bdId` varchar(40) DEFAULT NULL,
  `bdName` varchar(255) DEFAULT NULL,
  `orderAll` varchar(400) DEFAULT NULL,
  `pm25` varchar(40) DEFAULT NULL,
  `pm10` varchar(40) DEFAULT NULL,
  `db` varchar(40) DEFAULT NULL,
  `temperature` varchar(40) DEFAULT NULL,
  `humidity` varchar(40) DEFAULT NULL,
  `wind` varchar(40) DEFAULT NULL,
  `speed` varchar(40) DEFAULT NULL,
  `time` varchar(40) DEFAULT NULL,
  `localRecordTime` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`rowId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for yh_pc_situation
-- ----------------------------
DROP TABLE IF EXISTS `yh_pc_situation`;
CREATE TABLE `yh_pc_situation` (
  `row_id` varchar(40) NOT NULL,
  `yh_name` varchar(200) DEFAULT NULL COMMENT '隐患名称',
  `yh_problem` varchar(200) DEFAULT NULL COMMENT '具体隐患问题',
  `zg_situation` varchar(200) DEFAULT NULL COMMENT '对应整改落实情况',
  `hxsg_gzcs` varchar(200) DEFAULT NULL COMMENT '后续施工跟踪措施',
  `yhzg_fzr` varchar(40) DEFAULT NULL COMMENT '隐患整改负责人',
  `sgdw_fzr` varchar(40) DEFAULT NULL COMMENT '施工单位项目负责人',
  `jldw_fzr` varchar(40) DEFAULT NULL COMMENT '监理单位项目负责人',
  `jsdw_fzr` varchar(40) DEFAULT NULL COMMENT '建设单位项目负责人',
  `tb_org_name` varchar(40) DEFAULT NULL COMMENT '填报单位',
  `tb_user_id` varchar(40) DEFAULT NULL COMMENT '填报人ID',
  `tb_user_name` varchar(40) DEFAULT NULL COMMENT '填报人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `tb_date` date DEFAULT NULL COMMENT '填报日期',
  `com_org_id` varchar(40) DEFAULT NULL COMMENT '单位ID',
  `bd_id` varchar(40) DEFAULT NULL COMMENT '标段ID',
  `bd_name` varchar(200) DEFAULT NULL COMMENT '标段名称',
  `data_type` varchar(40) DEFAULT NULL COMMENT '类别',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` int(11) DEFAULT NULL COMMENT '排序',
  `data_delete` varchar(40) DEFAULT NULL COMMENT '删除',
  `start_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `end_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `time_period` int(11) DEFAULT NULL COMMENT '时间周期',
  `brief_intro` varchar(1000) DEFAULT NULL COMMENT '简介',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- View structure for v_att
-- ----------------------------
DROP VIEW IF EXISTS `v_att`;
CREATE ALGORITHM=UNDEFINED DEFINER=`njdtweb`@`%` SQL SECURITY DEFINER  VIEW `v_att` AS SELECT
	concat(
		`a`.`uniqueId`,
		'_',
		`u`.`user_id`
	) AS `v_att_user_key`,
	`a`.`uniqueId` AS `uniqueId`,
	`a`.`signTime` AS `signTime`,
	`a`.`doorControlName` AS `doorControlName`,
	`a`.`certificateNo` AS `certificateNo`,
	`a`.`projectId` AS `projectId`,
	`a`.`imageUrl` AS `imageUrl`,
	`a`.`signType` AS `signType`,
	`u`.`row_id` AS `user_key`,
	`u`.`user_id` AS `user_id`,
	`u`.`user_name` AS `user_name`,
	`o`.`row_id` AS `org_id`,
	`o`.`org_name` AS `org_name`,
	`o`.`parent_org_id` AS `parent_org_id`
FROM
	(
		(
			`gx_sys_attendance` `a`
			JOIN `gx_sys_user` `u`	
		)
		JOIN `gx_sys_user_in_org_copy` `or`
		JOIN `gx_sys_org_copy` `o`
	)
WHERE
	(
		(
			`a`.`certificateNo` = `u`.`user_card_id`
		)
		AND (
			`u`.`user_id` = `or`.`user_id`
		)
		AND(
			`or`.`org_id` = `o`.`row_id`
		)
	) ;

-- ----------------------------
-- View structure for v_att_all
-- ----------------------------
DROP VIEW IF EXISTS `v_att_all`;
CREATE ALGORITHM=UNDEFINED DEFINER=`njdtweb`@`%` SQL SECURITY DEFINER  VIEW `v_att_all` AS SELECT
	concat(
		`a`.`uniqueId`,
		'_',
		`u`.`user_id`
	) AS `v_att_user_key`,
	`a`.`uniqueId` AS `uniqueId`,
	`a`.`signTime` AS `signTime`,
	`a`.`doorControlName` AS `doorControlName`,
	`a`.`certificateNo` AS `certificateNo`,
	`a`.`projectId` AS `projectId`,
	`a`.`imageUrl` AS `imageUrl`,
	`a`.`signType` AS `signType`,
	`u`.`row_id` AS `user_key`,
	`u`.`user_id` AS `user_id`,
	`u`.`user_name` AS `user_name`,
	`u`.`user_type` AS `user_type`,
	`o`.`row_id` AS `org_id`,
	`o`.`org_name` AS `org_name`
FROM
	(
		(
			`gx_sys_attendance_all` `a`
			JOIN `gx_sys_user` `u`	
		)
		JOIN `gx_sys_user_in_org_copy` `or`
		JOIN `gx_sys_org_copy` `o`
	)
WHERE
	(
		(
			`a`.`certificateNo` = `u`.`user_card_id`
		)
		AND (
			`u`.`user_id` = `or`.`user_id`
		)
		AND(
			`or`.`org_id` = `o`.`row_id`
		)
	) ;

-- ----------------------------
-- View structure for v_column_article
-- ----------------------------
DROP VIEW IF EXISTS `v_column_article`;
CREATE ALGORITHM=UNDEFINED DEFINER=`oatyjt`@`%` SQL SECURITY INVOKER  VIEW `v_column_article` AS SELECT
r.row_id AS v_column_article_key,
a.article_title AS article_title,
a.article_type AS article_type,
a.article_content AS article_content,
a.article_status AS article_status,
a.create_time AS create_time,
a.order_num AS order_num,
a.`comment` AS `comment`,
c.column_name AS column_name,
c.row_id AS column_id,
a.row_id AS article_id,
a.is_news_pic AS is_news_pic,
a.pic_file_name AS pic_file_name,
a.pic_file_real_name AS pic_file_real_name,
c.parent_id,
a.publish_time,
a.vote_limit_time,
a.max_vote_num,
a.vote_method,
a.is_vote,
a.voted_num,
a.source,
a.hits,
a.video_file_name,
a.video_file_real_name
FROM
	(
		(
			`gx_oa_column` `c`
			JOIN `gx_oa_column_article` `a`
		)
		JOIN `gx_oa_column_article_relation` `r`
	)
WHERE
	(
		(
			`c`.`row_id` = `r`.`column_id`
		)
		AND (
			`a`.`row_id` = `r`.`article_id`
		)
	) ;

-- ----------------------------
-- View structure for v_dt_yc
-- ----------------------------
DROP VIEW IF EXISTS `v_dt_yc`;
CREATE ALGORITHM=UNDEFINED DEFINER=`njdtweb`@`%`  VIEW `v_dt_yc` AS SELECT
	m.row_id AS business_id,
	m.applicant_name,
	m.applicant_phone,
	m.applicant_id_card,
	m.start_time,
	m.create_user_id,
	m.create_user_name,
	m.create_time,
	pi.process_id,
	pi.row_id AS instance_id,
	pi.instance_state,
	ai.row_id,
	ai.act_id,
	ai.act_name,
	ai.handle_user,
	ai.handle_user1,
	ai.act_back,
	ai.act_next,
	ai.active_state,
	ai.active_time,
	ai.finish_time,
	ai.step_state
FROM
	dt_yc_apply m,
	proc_instance pi,
	proc_act_instance ai
WHERE
	m.row_id = pi.business_id
AND pi.row_id = ai.instance_id ;

-- ----------------------------
-- View structure for v_meet_procinst
-- ----------------------------
DROP VIEW IF EXISTS `v_meet_procinst`;
CREATE ALGORITHM=UNDEFINED DEFINER=`njdtweb`@`%`  VIEW `v_meet_procinst` AS SELECT
	m.row_id,
	m.applicant_name,
	m.applicant_phone,
	m.applicant_id_card,
	m.company_name,
	m.start_time AS meet_start_time,
	m.end_time AS meet_end_time,
	m.selected_room,
	m.create_user_id,
	m.create_user_name,
	m.create_time,
	pi.process_id,
	pi.row_id AS instance_id,
	pi.instance_state,
	pi.active_state,
	pi.active_user_name,
	pi.create_time AS start_time,
	pi.end_time
FROM
	meeting_room_lease_apply m,
	proc_instance pi
WHERE
	m.row_id = pi.business_id ;

-- ----------------------------
-- View structure for v_mobile_role_user
-- ----------------------------
DROP VIEW IF EXISTS `v_mobile_role_user`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY INVOKER  VIEW `v_mobile_role_user` AS SELECT
	concat(
		`r`.`row_id`,
		'_',
		`u`.`user_id`
	) AS `v_mobile_role_user_key`,
	`u`.`row_id` AS `user_key`,
	`u`.`user_name` AS `user_name`,
	`u`.`user_show_name` AS `user_show_name`,
	`u`.`user_en_name` AS `user_en_name`,
	`u`.`user_id` AS `user_id`,
	`u`.`data_status` AS `data_status`,
	`u`.`data_order` AS `data_order`,
	`u`.`user_sex` AS `user_sex`,
	`u`.`user_type` AS `user_type`,
	`r`.`row_id` AS `role_key`,
	`r`.`role_name` AS `role_name`,
	`r`.`role_id` AS `role_id`,
	`r`.`role_intro` AS `role_intro`,
	`r`.`data_order` AS `r_data_order`
FROM
	(
		(
			`gx_oa_mobile_role` `r`
			JOIN `gx_sys_user` `u`
		)
		JOIN `gx_oa_mobile_role_has_user` `ru`
	)
WHERE
	(
		(
			`r`.`row_id` = `ru`.`role_id`
		)
		AND (
			`u`.`user_id` = `ru`.`user_id`
		)
	) ;

-- ----------------------------
-- View structure for v_no_org
-- ----------------------------
DROP VIEW IF EXISTS `v_no_org`;
CREATE ALGORITHM=UNDEFINED DEFINER=`njdtweb`@`%` SQL SECURITY DEFINER  VIEW `v_no_org` AS select * from gx_sys_org_copy where gx_sys_org_copy.row_id not in(select gx_sys_att_rule.org_row_id from gx_sys_att_rule) ;

-- ----------------------------
-- View structure for v_role_user
-- ----------------------------
DROP VIEW IF EXISTS `v_role_user`;
CREATE ALGORITHM=UNDEFINED DEFINER=`gxlab_user`@`%` SQL SECURITY INVOKER  VIEW `v_role_user` AS select concat(`r`.`role_id`,`u`.`user_id`) AS `v_role_user_key`,`u`.`row_id` AS `user_key`,`u`.`user_name` AS `user_name`,`u`.`user_show_name` AS `user_show_name`,`u`.`user_en_name` AS `user_en_name`,`u`.`user_id` AS `user_id`,`u`.`create_time` AS `create_time`,`u`.`create_user_id` AS `create_user_id`,`u`.`modify_time` AS `modify_time`,`u`.`modify_user_id` AS `modify_user_id`,`u`.`data_status` AS `data_status`,`u`.`data_order` AS `data_order`,`u`.`user_mobile_num` AS `user_mobile_num`,`u`.`user_sex` AS `user_sex`,`u`.`user_type` AS `user_type`,`r`.`row_id` AS `role_key`,`r`.`role_name` AS `role_name`,`r`.`role_id` AS `role_id`,`r`.`role_intro` AS `role_intro`,`r`.`create_time` AS `r_create_time`,`r`.`create_user_id` AS `r_create_user_id`,`r`.`modify_time` AS `r_modify_time`,`r`.`modify_user_id` AS `r_modify_user_id`,`r`.`data_status` AS `r_data_status`,`r`.`data_order` AS `r_data_order`,`r`.`parent_role_id` AS `parent_role_id`,`r`.`parent_role_name` AS `parent_role_name`,`r`.`role_type` AS `role_type`,`ru`.`rl_type` AS `rl_type`,`ru`.`row_id` AS `rhu_id` from ((`gx_sys_role` `r` join `gx_sys_user` `u`) join `gx_sys_role_has_user` `ru`) where ((`r`.`role_id` = `ru`.`role_id`) and (`u`.`user_id` = `ru`.`user_id`)) ;

-- ----------------------------
-- View structure for v_sys_dic
-- ----------------------------
DROP VIEW IF EXISTS `v_sys_dic`;
CREATE ALGORITHM=UNDEFINED DEFINER=`njtycyjt`@`%` SQL SECURITY INVOKER  VIEW `v_sys_dic` AS select concat(`d`.`ROW_ID`,'_',`i`.`ROW_ID`) AS `v_sys_dic_key`,`i`.`DIC_FUNCTION_NAME` AS `index_dic_name`,`i`.`DIC_FUNCTION_ID` AS `index_dic_id`,`i`.`DIC_FUNCTION_DEC` AS `index_dic_desc`,`d`.`DIC_NAME` AS `record_dic_name`,`d`.`DIC_ID` AS `record_dic_id`,`d`.`DIC_SHOW_VAL` AS `DIC_SHOW_VAL`,`d`.`DIC_VALUE` AS `DIC_VALUE`,`d`.`DIC_TYPE` AS `DIC_TYPE`,`d`.`ORDER_NUM` AS `ORDER_NUM`,`d`.`max_status` AS `max_status`,`d`.`max_id` AS `max_id` from (`gx_sys_dic_index` `i` join `gx_sys_dic_record` `d`) where (`i`.`ROW_ID` = `d`.`TABLE_ID`) ;

-- ----------------------------
-- View structure for v_user
-- ----------------------------
DROP VIEW IF EXISTS `v_user`;
CREATE ALGORITHM=UNDEFINED DEFINER=`gxlab_user`@`%` SQL SECURITY INVOKER  VIEW `v_user` AS SELECT
	concat(`o`.`row_id`, `u`.`user_id`) AS `v_user_key`,
	`o`.`org_name` AS `org_name`,
	`o`.`parent_org_id` AS `p_org_id`,
	`o`.`parent_org_name` AS `p_org_name`,
	`o`.`org_type` AS `org_type`,
	`o`.`row_id` AS `org_id`,
	`u`.`user_name` AS `user_name`,
	`u`.`user_en_name` AS `user_password`,
	`u`.`user_id` AS `user_id`,
	`u`.`user_type` AS `user_type`,
	`u`.`user_mobile_num` AS `user_mobile_num`,
	`u`.`data_status` AS `user_status`,
	`u`.`sys_color_id` AS `sys_color_id`,
	`u`.`user_card_id` AS `user_card_id`,
	`o`.`org_com_id` AS `com_org_id`,
	`o`.`org_bd_id` AS `com_bd_id`,
	`uio`.`data_order` AS `data_order`,
	uio.row_id as uio_row_id,
	u.row_id AS user_row_id,
u.client_id AS client_id
FROM
	(
		(
			`gx_sys_org` `o`
			JOIN `gx_sys_user` `u`
		)
		JOIN `gx_sys_user_in_org` `uio`
	)
WHERE
	(
		(
			`o`.`row_id` = `uio`.`org_id`
		)
		AND (
			`u`.`user_id` = `uio`.`user_id`
		)
	)
ORDER BY
	`uio`.`data_order` ;

-- ----------------------------
-- View structure for v_user_copy
-- ----------------------------
DROP VIEW IF EXISTS `v_user_copy`;
CREATE ALGORITHM=UNDEFINED DEFINER=`njdtweb`@`%` SQL SECURITY DEFINER  VIEW `v_user_copy` AS SELECT
	concat(`o`.`row_id`, `u`.`user_id`) AS `v_user_key`,
	`o`.`org_name` AS `org_name`,
	`o`.`parent_org_id` AS `p_org_id`,
	`o`.`parent_org_name` AS `p_org_name`,
	`o`.`org_type` AS `org_type`,
	`o`.`row_id` AS `org_id`,
	`u`.`user_name` AS `user_name`,
	`u`.`user_en_name` AS `user_password`,
	`u`.`user_id` AS `user_id`,
	`u`.`user_type` AS `user_type`,
	`u`.`user_sex` AS `user_sex`,
	`u`.`user_mobile_num` AS `user_mobile_num`,
	`u`.`data_status` AS `user_status`,
	`u`.`sys_color_id` AS `sys_color_id`,
	`u`.`card_no` AS `card_no`,
	`u`.`user_card_id` AS `user_card_id`,
	`o`.`org_com_id` AS `com_org_id`,
	`o`.`org_bd_id` AS `com_bd_id`,
	`o`.`org_level` AS `org_level`,
	`uio`.`data_order` AS `data_order`,
uio.row_id as uio_row_id,
	u.row_id AS user_row_id
FROM
	(
		(
			`gx_sys_org_copy` `o`
			JOIN `gx_sys_user` `u`
		)
		JOIN `gx_sys_user_in_org_copy` `uio`
	)
WHERE
	(
		(
			`o`.`row_id` = `uio`.`org_id`
		)
		AND (
			`u`.`user_id` = `uio`.`user_id`
		)
	)
ORDER BY
	`uio`.`data_order` ;

-- ----------------------------
-- View structure for v_user_in_org_att
-- ----------------------------
DROP VIEW IF EXISTS `v_user_in_org_att`;
CREATE ALGORITHM=UNDEFINED DEFINER=`njdtweb`@`%` SQL SECURITY DEFINER  VIEW `v_user_in_org_att` AS SELECT
`re`.rowId as `attRowId`,
`re`.signTime ,
`re`.userId ,
`re`.userName,
`vu`.org_name as `orgName`,
`vu`.org_id as `orgId`,
`vu`.com_bd_id as `bdId`,
`vu`.org_level as `org_level`,
`re`.ruleName,
`re`.earlyTime,
`re`.lastTime,
`re`.count,
`re`.workTime,
`re`.resultKey,
`re`.resultType,
`re`.resultCheckType,
`re`.signType,
`re`.doorControlName,
`vu`.data_order as `dataOrder`,
`vu`.user_type as `userType`
FROM
	(
		`gx_sys_attendance_result` `re`

		JOIN `v_user_copy` `vu`
	)
WHERE
	(
		(
			`re`.`userId` = `vu`.`user_id`
		)
	) ;

-- ----------------------------
-- View structure for v_user_org
-- ----------------------------
DROP VIEW IF EXISTS `v_user_org`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY INVOKER  VIEW `v_user_org` AS SELECT
	concat(
		`gx_sys_org`.row_id,
		`gx_hr_user`.`user_id`
	) AS `user_org_key`,
	`gx_sys_org`.`row_id` AS `row_id`,
	`gx_sys_org`.`org_name` AS `org_name`,
	`gx_hr_user`.`user_name` AS `user_name`,
	`gx_hr_user_in_org`.`user_id` AS `user_id`,
	`gx_hr_user`.`row_id` AS `user_row_id`,
	`gx_hr_user_in_org`.`row_id` AS `between_id`,
	`gx_hr_user_in_org`.`data_order` AS `data_order`,
	`gx_hr_user`.`user_job` AS `user_job`,
	`gx_hr_user`.`user_card_id` AS `user_card_id`
FROM
	(
		(
			`gx_sys_org`
			JOIN `gx_hr_user`
		)
		JOIN `gx_hr_user_in_org`
	)
WHERE
	(
		(
			`gx_sys_org`.`row_id` = `gx_hr_user_in_org`.`org_id`
		)
		AND (
			`gx_hr_user`.`user_id` = `gx_hr_user_in_org`.`user_id`
		)
	) ;

-- ----------------------------
-- View structure for v_user_org_score
-- ----------------------------
DROP VIEW IF EXISTS `v_user_org_score`;
CREATE ALGORITHM=UNDEFINED DEFINER=`njdtweb`@`%` SQL SECURITY DEFINER  VIEW `v_user_org_score` AS SELECT
	concat(
		`s`.`row_id`,
		'_',
		`u`.`user_id`
	) AS `v_score_user_key`,
	`s`.`row_id` AS `score_key`,
	`s`.`record_score` AS `record_score`,
	`s`.`record_type` AS `record_type`,
	`s`.`record_time` AS `record_time`,
	`u`.`row_id` AS `user_key`,
	`u`.`user_id` AS `user_id`,
	`u`.`user_name` AS `user_name`,
	`o`.`row_id` AS `org_id`,
	`o`.`org_name` AS `org_name`,
	`o`.`parent_org_id` AS `parent_org_id`,
	`o`.`parent_org_name` AS `parent_org_name`,
	`s`.`order_num` AS `data_order`
FROM
	(
		(
			`gx_sys_score_record` `s`
			JOIN `gx_sys_user` `u`	
		)
		JOIN `gx_sys_user_in_org` `io`
		JOIN `gx_sys_org` `o`
	)
WHERE
	(
		(
			`s`.`user_id` = `u`.`user_id`
		)
		AND (
			`u`.`user_id` = `io`.`user_id`
		)
		AND(
			`io`.`org_id` = `o`.`row_id`
		)
	) ;

-- ----------------------------
-- View structure for v_user_tz
-- ----------------------------
DROP VIEW IF EXISTS `v_user_tz`;
CREATE ALGORITHM=UNDEFINED DEFINER=`njdtweb`@`%`  VIEW `v_user_tz` AS SELECT
	concat(`o`.`row_id`, `u`.`user_id`) AS `v_user_key`,
	`o`.`org_name` AS `org_name`,
	`o`.`parent_org_id` AS `p_org_id`,
	`o`.`parent_org_name` AS `p_org_name`,
	`o`.`org_type` AS `org_type`,
	`o`.`row_id` AS `org_id`,
	`u`.`user_name` AS `user_name`,
	`u`.`user_en_name` AS `user_password`,
	`u`.`user_id` AS `user_id`,
	`u`.`user_type` AS `user_type`,
	`u`.`user_mobile_num` AS `user_mobile_num`,
	`u`.`data_status` AS `user_status`,
	`u`.`sys_color_id` AS `sys_color_id`,
	`u`.`user_card_id` AS `user_card_id`,
	`o`.`org_com_id` AS `com_org_id`,
	`o`.`org_bd_id` AS `com_bd_id`,
	`uio`.`data_order` AS `data_order`,
uio.row_id as uio_row_id,
	u.row_id AS user_row_id
FROM
	(
		(
			`gx_sys_org_tz` `o`
			JOIN `gx_sys_user` `u`
		)
		JOIN `gx_sys_user_in_org_tz` `uio`
	)
WHERE
	(
		(
			`o`.`row_id` = `uio`.`org_id`
		)
		AND (
			`u`.`user_id` = `uio`.`user_id`
		)
	)
ORDER BY
	`uio`.`data_order` ;

-- ----------------------------
-- View structure for v_view_column_article
-- ----------------------------
DROP VIEW IF EXISTS `v_view_column_article`;
CREATE ALGORITHM=UNDEFINED DEFINER=`njdtweb`@`%` SQL SECURITY DEFINER  VIEW `v_view_column_article` AS SELECT
	`r`.`row_id` AS `v_column_article_key`,
	`a`.`article_title` AS `article_title`,
	`a`.`article_type` AS `article_type`,
	`a`.`article_content` AS `article_content`,
	`a`.`article_status` AS `article_status`,
	`a`.`create_time` AS `create_time`,
	`a`.`order_num` AS `order_num`,
	`a`.`comment` AS `comment`,
	`a`.`bd_id` AS `bd_id`,
`a`.`bd_name` AS `bd_name`,
	`c`.`column_name` AS `column_name`,
`c`.`row_id` AS `column_id`,
 `a`.`row_id` AS `article_id`,

	`a`.`is_news_pic` AS `is_news_pic`,
	`a`.`pic_file_name` AS `pic_file_name`,
	`a`.`pic_file_real_name` AS `pic_file_real_name`,
	a.voted_num,
	a.vote_limit_time,
	a.is_vote,a.vote_method,a.max_vote_num
FROM
	(
		(
			`gx_view_column` `c`
			JOIN `gx_view_column_article` `a`
		)
		JOIN `gx_view_column_article_relation` `r`
	)
WHERE
	(
		(
			`c`.`row_id` = `r`.`column_id`
		)
		AND 
		(
			`a`.`row_id` = `r`.`article_id`
		)
	) ;
