drop index I_PaymentInfo1 on PaymentInfo;
drop index I_PaymentInfo on PaymentInfo;
drop index UK_PaymentInfo on PaymentInfo;
drop index UK_PaymentInfo2 on PaymentInfo;
drop table if exists PaymentInfo;
/*==============================================================*/
/* Table: PaymentInfo                                           */
/*==============================================================*/
create table PaymentInfo
(
   Id                   int not null auto_increment,
   AcceptId             varchar(32) not null,
   TransNo              varchar(32) not null,
   Status               int not null,
   CreatTime            varchar(8) not null,
   Extend               varchar(32),
   primary key (Id)
);
/*==============================================================*/
/* Index: UK_PaymentInfo                                        */
/*==============================================================*/
create index UK_PaymentInfo on PaymentInfo
(
   AcceptId
);
/*==============================================================*/
/* Index: UK_PaymentInfo2                                       */
/*==============================================================*/
create unique index UK_PaymentInfo2 on PaymentInfo
(
   TransNo,
   Status
);
/*==============================================================*/
/* Index: I_PaymentInfo                                         */
/*==============================================================*/
create index I_PaymentInfo on PaymentInfo
(
   Status,
   CreatTime
);

/*==============================================================*/
/* Index: I_PaymentInfo1                                        */
/*==============================================================*/
create index I_PaymentInfo1 on PaymentInfo
(
   Extend
);

---插入几条测试记录
insert into PaymentInfo (AcceptId,TransNo,Status,CreatTime,Extend) values ("A000001", "T000001", 0, "20190323","72334");
insert into PaymentInfo (AcceptId,TransNo,Status,CreatTime,Extend) values ("A000002", "T000002", 0, "20190323","723se34");
insert into PaymentInfo (AcceptId,TransNo,Status,CreatTime,Extend) values ("A000003", "T000003", 0, "20190323","72fsds334");
insert into PaymentInfo (AcceptId,TransNo,Status,CreatTime,Extend) values ("A000011", "T000011", 0, "20190323","72fff334");
insert into PaymentInfo (AcceptId,TransNo,Status,CreatTime,Extend) values ("A000012", "T000012", 0, "20190324","72334err");
insert into PaymentInfo (AcceptId,TransNo,Status,CreatTime,Extend) values ("A000013", "T000013", 0, "20190324","723eee34");


insert into PaymentInfo (AcceptId,TransNo,Status,CreatTime) values ("A000001", "T000001", 0, "20190325");
insert into PaymentInfo (AcceptId,TransNo,Status,CreatTime) values ("A000001", "T000001", 0, "20190326");
insert into PaymentInfo (AcceptId,TransNo,Status,CreatTime) values ("A000001", "T000001", 0, "20190324");
insert into PaymentInfo (AcceptId,TransNo,Status,CreatTime) values ("A000021", "T000021", 1, "20190324");
insert into PaymentInfo (AcceptId,TransNo,Status,CreatTime) values ("A000021", "T000021", 1, "20190324");
insert into PaymentInfo (AcceptId,TransNo,Status,CreatTime) values ("A000021", "T000021", 1, "20190324");
--若执行以下语句，并存在UK_PaymentInfo2唯一索引时，会报错
--insert into PaymentInfo (AcceptId,TransNo,Status,CreatTime) values ("A000033", "T000003", 1, "20190324");

--基本语法  explain sql语句
explain select * from PaymentInfo where Extend = "723eee34";
explain select * from PaymentInfo where AcceptId = "A000001" union select * from PaymentInfo where TransNo="T000001";


drop index I_PaymentInfo3 on PaymentInfo;
create index I_PaymentInfo3 on PaymentInfo
(
   TransNo,
   Status,
   CreatTime
);







