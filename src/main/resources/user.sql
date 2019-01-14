create table sys_user
(
  id          bigint not null auto_increment comment '用户ID',
  user_name   varchar(50) comment '用户名',
  user_password    varchar(50) comment '密码',
  user_email       varchar(50) comment '邮箱',
  user_info        text comment '简介',
  head_img    blob comment '头像',
  create_time datetime comment '创建时间',
  primary key (id)
);
alter table sys_user comment '用户表';

create table sys_role
(
  id          bigint not null auto_increment comment '角色ID',
  role_name   varchar(50) comment '角色名',
  enabled     int comment '有效标志',
  create_by   bigint comment '创建人',
  create_time datetime comment '创建时间',
  primary key (id)
);
alter table sys_role comment '角色表';

create table sys_privilege
(
  id             bigint not null auto_increment comment '权限ID',
  privilege_name varchar(50) comment '权限名称',
  privilege_url  varchar(200) comment '权限URL',
  primary key (id)
);
alter table sys_privilege comment '权限表';

create table sys_user_role
(
  user_id bigint comment '用户ID',
  role_id bigint comment '角色ID'
);
alter table sys_user_role comment '用户角色关联表';

create table sys_role_privilege
(
  role_id bigint comment '角色ID',
  privilege_id bigint comment '权限ID'
);
alter table sys_role_privilege comment '角色权限关联表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '123456', 'admin@mybatis.tk', '管理员用户', 0x1231231230, '2016-06-07 01:11:12');
INSERT INTO `sys_user` VALUES ('1001', 'test', '123456', 'test@mybatis.tk', '测试用户', 0x1231231230, '2016-06-07 00:00:00');

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '管理员', '1', '1', '2016-04-01 17:02:14');
INSERT INTO `sys_role` VALUES ('2', '普通用户', '1', '1', '2016-04-01 17:02:34');

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1');
INSERT INTO `sys_user_role` VALUES ('1', '2');
INSERT INTO `sys_user_role` VALUES ('1001', '2');

-- ----------------------------
-- Records of sys_privilege
-- ----------------------------
INSERT INTO `sys_privilege` VALUES ('1', '用户管理', '/users');
INSERT INTO `sys_privilege` VALUES ('2', '角色管理', '/roles');
INSERT INTO `sys_privilege` VALUES ('3', '系统日志', '/logs');
INSERT INTO `sys_privilege` VALUES ('4', '人员维护', '/persons');
INSERT INTO `sys_privilege` VALUES ('5', '单位维护', '/companies');

-- ----------------------------
-- Records of sys_role_privilege
-- ----------------------------
INSERT INTO `sys_role_privilege` VALUES ('1', '1');
INSERT INTO `sys_role_privilege` VALUES ('1', '3');
INSERT INTO `sys_role_privilege` VALUES ('1', '2');
INSERT INTO `sys_role_privilege` VALUES ('2', '4');
INSERT INTO `sys_role_privilege` VALUES ('2', '5');
