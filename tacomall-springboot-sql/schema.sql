DROP TABLE IF EXISTS user;;/*SkipError*/
CREATE TABLE user(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    username VARCHAR(32)    COMMENT '用户名' ,
    password VARCHAR(32)    COMMENT '密码' ,
    status INT    COMMENT '状态' ,
    create_time DATETIME    COMMENT '创建时间' ,
    delete_time DATETIME    COMMENT '删除时间' ,
    PRIMARY KEY (id)
) COMMENT = '用户 ';;

ALTER TABLE user COMMENT '用户';;
DROP TABLE IF EXISTS  user_weixin;;/*SkipError*/
CREATE TABLE user_weixin(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    user_id INT    COMMENT '用户id' ,
    open_id VARCHAR(32)    COMMENT 'open_id' ,
    union_id VARCHAR(32)    COMMENT 'union_id' ,
    nickname VARCHAR(32)    COMMENT '昵称' ,
    gender INT    COMMENT '性别' ,
    avatar_url VARCHAR(32)    COMMENT '头像' ,
    status INT    COMMENT '状态' ,
    create_time DATETIME    COMMENT '创建时间' ,
    delete_time DATETIME    COMMENT '删除时间' ,
    PRIMARY KEY (id)
) COMMENT = '用户微信 ';;

ALTER TABLE user_weixin COMMENT '用户微信';;
DROP TABLE IF EXISTS  user_profile;;/*SkipError*/
CREATE TABLE user_profile(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    user_id VARCHAR(32)    COMMENT '用户id' ,
    nickname VARCHAR(32)    COMMENT '昵称' ,
    avatar VARCHAR(32)    COMMENT '头像' ,
    age INT    COMMENT '年纪' ,
    sex INT    COMMENT '性别' ,
    mobile VARCHAR(32)    COMMENT '手机' ,
    PRIMARY KEY (id)
) COMMENT = '用户信息 ';;

ALTER TABLE user_profile COMMENT '用户信息';;
DROP TABLE IF EXISTS  user_level;;/*SkipError*/
CREATE TABLE user_level(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    user_id INT    COMMENT '用户id' ,
    level_id INT    COMMENT '等级id' ,
    PRIMARY KEY (id)
) COMMENT = '用户等级 ';;

ALTER TABLE user_level COMMENT '用户等级';;
DROP TABLE IF EXISTS  user_statistics;;/*SkipError*/
CREATE TABLE user_statistics(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    user_id INT    COMMENT '用户id' ,
    goods_collect_count INT    COMMENT '商品收藏数' ,
    store_collect_count INT    COMMENT '商家收藏数' ,
    PRIMARY KEY (id)
) COMMENT = '用户统计 ';;

ALTER TABLE user_statistics COMMENT '用户统计';;
DROP TABLE IF EXISTS  user_address;;/*SkipError*/
CREATE TABLE user_address(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    user_id INT    COMMENT '用户id' ,
    mobile VARCHAR(32)    COMMENT '手机号' ,
    province VARCHAR(32)    COMMENT '省' ,
    city VARCHAR(32)    COMMENT '市' ,
    area VARCHAR(32)    COMMENT '县' ,
    detail VARCHAR(32)    COMMENT '详情' ,
    create_time DATETIME    COMMENT '创建时间' ,
    delete_time DATETIME    COMMENT '删除时间' ,
    PRIMARY KEY (id)
) COMMENT = '用户地址 ';;

ALTER TABLE user_address COMMENT '用户地址';;
