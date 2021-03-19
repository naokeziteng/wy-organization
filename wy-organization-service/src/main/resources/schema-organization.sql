DROP TABLE IF EXISTS `org_user`;
DROP TABLE IF EXISTS `org_department`;
DROP TABLE IF EXISTS `org_department_assistant_leader`;

-- 用户表
CREATE TABLE `org_user`(
  `id` varchar(32) NOT NULL COMMENT '用户id',
  `name` varchar(128) NOT NULL COMMENT '姓名',
  `department_id` varchar(32) COMMENT '所属部门id',
  `created_date_time` datetime COMMENT '创建时间',
  `created_user_id` varchar(32) COMMENT '创建者id',
  `updated_date_time` datetime COMMENT '更新时间',
  `updated_user_id` varchar(32) COMMENT '更新者id',
  primary key(`id`)
)
ENGINE=innodb DEFAULT CHARACTER SET utf8mb4
COMMENT '用户表';

-- 部门表
CREATE TABLE `org_department`(
  `id` varchar(32) NOT NULL COMMENT '部门id',
  `name` varchar(128) NOT NULL COMMENT '名称',
  `parent_id` varchar(32) COMMENT '上级部门id',
  `leader_id` varchar(32) COMMENT '部门领导id',
  `created_date_time` datetime COMMENT '创建时间',
  `created_user_id` varchar(32) COMMENT '创建者id',
  `updated_date_time` datetime COMMENT '更新时间',
  `updated_user_id` varchar(32) COMMENT '更新者id',
  primary key(`id`)
)
ENGINE=innodb DEFAULT CHARACTER SET utf8mb4
COMMENT '部门表';


-- 部门分管领导表
CREATE TABLE `org_department_assistant_leader`(
  `department_id` varchar(32) NOT NULL COMMENT '部门id',
  `assistant_leader_id` varchar(32) NOT NULL COMMENT '分管领导id',
  primary key(`department_id`,`assistant_leader_id`)
)
ENGINE=innodb DEFAULT CHARACTER SET utf8mb4
COMMENT '部门表';