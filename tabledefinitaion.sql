create table `member`(
`id` varchar(20) primary key,
`passwd` varchar(20) not null,
`username` varchar(20),
`major` varchar(20),
`age` int,
`sex` varchar(10)
);

create table `notice_board`(
`num` int primary key auto_increment,
`id` varchar(20),
`title` varchar(30),
`content` varchar(100),
`date` datetime
);

create table `applyList`(
    `num` int ,
    `other` varchar(20),
    primary key(num,other)
);

insert into `member` values("test","passwd","tester","test",26,"man");
insert into `member` values("woman","passwd","여성","sftware",23,"woman");
insert into `member` values("barley","passwd","황금보리","coumputer",25,"man");

insert into `notice_board`(id,title,content,`date`) values("test","create test","안녕하세요, 컴퓨터공학과 tester입니다.",now());
insert into `notice_board`(id,title,content,`date`) values("woman","create woman","안녕하세요, 소프트웨어공학과 woman입니다.",now());
insert into `notice_board`(id,title,content,`date`) values("barley","create barley","안녕하세요, 컴퓨터공학과 barley입니다.",now());

insert into `applyList`(num,other) values(9,"woman");
insert into `applyList`(num,other) values(9,"barley");


select * from `member`;
select * from `notice_board`;
select * from `applyList`;

select num,nb.id,username,sex,major,title,content,`date` from `notice_board` as nb join `member` as m on nb.id = m.id where nb.id = "test";

select nb.id,al.num,title,other from `notice_board` as nb join `applyList` as al on nb.num = al.num where nb.id = "test";

delete from `member` where id = "barley";
delete from `notice_board` where num = 3;

update `notice_board` set title="modify",content="수정했습니다.",`date`=now() where num=1;

drop table `member`;
drop table `notice_board`;
drop table `applyList`;