/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/3/28 16:13:40                           */
/*==============================================================*/


drop table if exists T_GROUP;

drop table if exists T_GROUP_ROLE_RELATION;

drop table if exists T_LOG;

drop table if exists T_ORG;

drop table if exists T_RIGHT;

drop table if exists T_ROLE;

drop table if exists T_ROLE_RIGHT_RELATION;

drop table if exists T_USER;

drop table if exists T_USER_GROUP_RELATION;

drop table if exists T_USER_ROLE_RELATION;

/*==============================================================*/
/* Table: T_GROUP                                               */
/*==============================================================*/
create table T_GROUP
(
   group_id             bigint not null comment '组ID',
   p_group_id           bigint comment '父组',
   group_name           varchar(64) not null comment '组名称',
   gen_time             datetime not null comment '创建时间',
   description          varchar(200) comment '组描述',
   primary key (group_id)
);

alter table T_GROUP comment '用户组';

/*==============================================================*/
/* Table: T_GROUP_ROLE_RELATION                                 */
/*==============================================================*/
create table T_GROUP_ROLE_RELATION
(
   group_role_id        bigint not null comment '记录标识',
   group_id             bigint not null comment '组',
   role_id              bigint not null comment '角色',
   primary key (group_role_id)
);

alter table T_GROUP_ROLE_RELATION comment '组角色表';

/*==============================================================*/
/* Table: T_LOG                                                 */
/*==============================================================*/
create table T_LOG
(
   log_id               bigint not null comment '日志ID',
   op_type              int not null comment '操作类型',
   content              varchar(200) not null comment '操作内容',
   user_id              bigint not null comment '操作人',
   gen_time             datetime not null comment '操作时间',
   primary key (log_id)
);

alter table T_LOG comment '操作日志';

/*==============================================================*/
/* Table: T_ORG                                                 */
/*==============================================================*/
create table T_ORG
(
   org_id               bigint not null comment '组织ID',
   p_org_id             bigint comment '父组织',
   org_name             varchar(64) not null comment '组织名称',
   gen_time             datetime not null comment '创建时间',
   description          varchar(200) comment '组织描述',
   primary key (org_id)
);

alter table T_ORG comment '组织表';

/*==============================================================*/
/* Table: T_RIGHT                                               */
/*==============================================================*/
create table T_RIGHT
(
   tr_id                bigint not null comment '权限ID',
   p_tr_id              bigint comment '父权限',
   right_name           varchar(64) not null comment '权限名称',
   description          varchar(200) comment '权限描述',
   primary key (tr_id)
);

alter table T_RIGHT comment '权限表';

/*==============================================================*/
/* Table: T_ROLE                                                */
/*==============================================================*/
create table T_ROLE
(
   role_id              bigint not null comment '角色ID',
   p_role_id            bigint comment '父角色ID',
   role_name            varchar(64) not null comment '角色名称',
   gen_time             datetime not null comment '创建时间',
   description          varchar(200) comment '角色描述',
   primary key (role_id)
);

alter table T_ROLE comment '角色表';

/*==============================================================*/
/* Table: T_ROLE_RIGHT_RELATION                                 */
/*==============================================================*/
create table T_ROLE_RIGHT_RELATION
(
   role_right_id        bigint not null comment '记录标识',
   role_id              bigint not null comment '角色',
   right_id             bigint not null comment '权限',
   right_type           int not null comment '权限类型',
   primary key (role_right_id)
);

alter table T_ROLE_RIGHT_RELATION comment '角色权限表';

/*==============================================================*/
/* Table: T_USER                                                */
/*==============================================================*/
create table T_USER
(
   user_id              bigint not null comment '用户ID',
   org_id               bigint not null comment '所属组织',
   login_name           varchar(64) not null comment '登录账号',
   password             varchar(64) not null comment '用户密码',
   Column_13            char(10),
   vusername            varchar(64) not null comment '用户姓名',
   mobile               varchar(20) comment '手机号',
   email                varchar(64) comment '电子邮箱',
   gen_time             datetime not null comment '创建时间',
   login_time           datetime comment '登录时间',
   last_login_time      datetime comment '上次登录时间',
   count                tinyint not null comment '登录次数',
   is_lock              tinyint not null,
   primary key (user_id)
);

alter table T_USER comment '用户表';

/*==============================================================*/
/* Table: T_USER_GROUP_RELATION                                 */
/*==============================================================*/
create table T_USER_GROUP_RELATION
(
   user_group_id        bigint not null comment '记录标识',
   user_id              bigint not null comment '用户',
   group_id             bigint not null comment '组',
   primary key (user_group_id)
);

alter table T_USER_GROUP_RELATION comment '用户组表';

/*==============================================================*/
/* Table: T_USER_ROLE_RELATION                                  */
/*==============================================================*/
create table T_USER_ROLE_RELATION
(
   user_role_id         bigint not null comment '记录标识',
   user_id              bigint not null comment '用户',
   role_id              bigint not null comment '角色',
   primary key (user_role_id)
);

alter table T_USER_ROLE_RELATION comment '用户角色表';

alter table T_GROUP_ROLE_RELATION add constraint FK_Reference_3 foreign key (role_id)
      references T_ROLE (role_id) on delete restrict on update restrict;

alter table T_GROUP_ROLE_RELATION add constraint FK_Reference_4 foreign key (group_id)
      references T_GROUP (group_id) on delete restrict on update restrict;

alter table T_LOG add constraint FK_Reference_13 foreign key (user_id)
      references T_USER (user_id) on delete restrict on update restrict;

alter table T_ROLE_RIGHT_RELATION add constraint FK_Reference_5 foreign key (role_id)
      references T_ROLE (role_id) on delete restrict on update restrict;

alter table T_ROLE_RIGHT_RELATION add constraint FK_Reference_6 foreign key (right_id)
      references T_RIGHT (tr_id) on delete restrict on update restrict;

alter table T_USER add constraint FK_Reference_14 foreign key (org_id)
      references T_ORG (org_id) on delete restrict on update restrict;

alter table T_USER_GROUP_RELATION add constraint FK_Reference_7 foreign key (user_id)
      references T_USER (user_id) on delete restrict on update restrict;

alter table T_USER_GROUP_RELATION add constraint FK_Reference_8 foreign key (group_id)
      references T_GROUP (group_id) on delete restrict on update restrict;

alter table T_USER_ROLE_RELATION add constraint FK_Reference_11 foreign key (user_id)
      references T_USER (user_id) on delete restrict on update restrict;

alter table T_USER_ROLE_RELATION add constraint FK_Reference_12 foreign key (role_id)
      references T_ROLE (role_id) on delete restrict on update restrict;

