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
   group_id             bigint not null comment '��ID',
   p_group_id           bigint comment '����',
   group_name           varchar(64) not null comment '������',
   gen_time             datetime not null comment '����ʱ��',
   description          varchar(200) comment '������',
   primary key (group_id)
);

alter table T_GROUP comment '�û���';

/*==============================================================*/
/* Table: T_GROUP_ROLE_RELATION                                 */
/*==============================================================*/
create table T_GROUP_ROLE_RELATION
(
   group_role_id        bigint not null comment '��¼��ʶ',
   group_id             bigint not null comment '��',
   role_id              bigint not null comment '��ɫ',
   primary key (group_role_id)
);

alter table T_GROUP_ROLE_RELATION comment '���ɫ��';

/*==============================================================*/
/* Table: T_LOG                                                 */
/*==============================================================*/
create table T_LOG
(
   log_id               bigint not null comment '��־ID',
   op_type              int not null comment '��������',
   content              varchar(200) not null comment '��������',
   user_id              bigint not null comment '������',
   gen_time             datetime not null comment '����ʱ��',
   primary key (log_id)
);

alter table T_LOG comment '������־';

/*==============================================================*/
/* Table: T_ORG                                                 */
/*==============================================================*/
create table T_ORG
(
   org_id               bigint not null comment '��֯ID',
   p_org_id             bigint comment '����֯',
   org_name             varchar(64) not null comment '��֯����',
   gen_time             datetime not null comment '����ʱ��',
   description          varchar(200) comment '��֯����',
   primary key (org_id)
);

alter table T_ORG comment '��֯��';

/*==============================================================*/
/* Table: T_RIGHT                                               */
/*==============================================================*/
create table T_RIGHT
(
   tr_id                bigint not null comment 'Ȩ��ID',
   p_tr_id              bigint comment '��Ȩ��',
   right_name           varchar(64) not null comment 'Ȩ������',
   description          varchar(200) comment 'Ȩ������',
   primary key (tr_id)
);

alter table T_RIGHT comment 'Ȩ�ޱ�';

/*==============================================================*/
/* Table: T_ROLE                                                */
/*==============================================================*/
create table T_ROLE
(
   role_id              bigint not null comment '��ɫID',
   p_role_id            bigint comment '����ɫID',
   role_name            varchar(64) not null comment '��ɫ����',
   gen_time             datetime not null comment '����ʱ��',
   description          varchar(200) comment '��ɫ����',
   primary key (role_id)
);

alter table T_ROLE comment '��ɫ��';

/*==============================================================*/
/* Table: T_ROLE_RIGHT_RELATION                                 */
/*==============================================================*/
create table T_ROLE_RIGHT_RELATION
(
   role_right_id        bigint not null comment '��¼��ʶ',
   role_id              bigint not null comment '��ɫ',
   right_id             bigint not null comment 'Ȩ��',
   right_type           int not null comment 'Ȩ������',
   primary key (role_right_id)
);

alter table T_ROLE_RIGHT_RELATION comment '��ɫȨ�ޱ�';

/*==============================================================*/
/* Table: T_USER                                                */
/*==============================================================*/
create table T_USER
(
   user_id              bigint not null comment '�û�ID',
   org_id               bigint not null comment '������֯',
   login_name           varchar(64) not null comment '��¼�˺�',
   password             varchar(64) not null comment '�û�����',
   Column_13            char(10),
   vusername            varchar(64) not null comment '�û�����',
   mobile               varchar(20) comment '�ֻ���',
   email                varchar(64) comment '��������',
   gen_time             datetime not null comment '����ʱ��',
   login_time           datetime comment '��¼ʱ��',
   last_login_time      datetime comment '�ϴε�¼ʱ��',
   count                tinyint not null comment '��¼����',
   is_lock              tinyint not null,
   primary key (user_id)
);

alter table T_USER comment '�û���';

/*==============================================================*/
/* Table: T_USER_GROUP_RELATION                                 */
/*==============================================================*/
create table T_USER_GROUP_RELATION
(
   user_group_id        bigint not null comment '��¼��ʶ',
   user_id              bigint not null comment '�û�',
   group_id             bigint not null comment '��',
   primary key (user_group_id)
);

alter table T_USER_GROUP_RELATION comment '�û����';

/*==============================================================*/
/* Table: T_USER_ROLE_RELATION                                  */
/*==============================================================*/
create table T_USER_ROLE_RELATION
(
   user_role_id         bigint not null comment '��¼��ʶ',
   user_id              bigint not null comment '�û�',
   role_id              bigint not null comment '��ɫ',
   primary key (user_role_id)
);

alter table T_USER_ROLE_RELATION comment '�û���ɫ��';

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

