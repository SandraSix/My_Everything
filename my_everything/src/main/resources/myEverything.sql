
create table if not exists thing(
  name varchar (2048) not null comment  '文件名称',
  path varchar (1024) not null comment '文件路径',
  depath int not null comment '文件路径深度',
  file_type varchar (32) not null comment '文件类型'
);
