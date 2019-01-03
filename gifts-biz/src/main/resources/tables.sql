create database test;

use test;

drop table activity;

create table activity (
	id INT not NULL
    ,description varchar(200)
    ,order_id int
	,reward_image_url varchar(150)
	,available_order_task_number int
    ,start_time timestamp
    ,end_time timestamp
    ,add_date timestamp not null default now()
    ,primary key(id)
);

drop table customer;

create table customer (
	id INT not NULL
    ,shop_name varchar(10)
    ,phone_number char(11)
	,credit_value int
    ,primary key(id)
);

drop table merchant_order;

create table merchant_order (
	id INT not NULL
	,order_name varchar(15)
    ,description varchar(200)
    ,customer_id int
    ,task_number int
	,process_image_url varchar(150)
    ,primary key(id)
);

drop table task;

create table task (
	id INT not NULL
    ,user_id int
    ,activity_id int
	,status_code int
    ,primary key(id)
);

drop table wx_user;

create table wx_user (
	id INT not NULL
    ,nick_name varchar(30)
	,age int
	,phone_number char(11)
	,wechat_number varchar(30)
	,taobao_number varchar(30)
	,naughty_value int
	,credit_value int
	,referrer_user_id int
	,primary key(id)
);

create unique index user_indx_1 on wx_user(wechat_number);
create unique index user_indx_2 on wx_user(taobao_number);