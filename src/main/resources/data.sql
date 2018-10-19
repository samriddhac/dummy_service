insert into user_group(id,name) values(10001, 'Free');
insert into user_group(id,name) values(10002, 'Premium');
insert into user_group(id,name) values(10003, 'Tier 1');

insert into users(id,name,group_id) values(10001, 'Sam_1', 10001);
insert into users(id,name,group_id) values(10002, 'Sam_2', 10002);
insert into users(id,name,group_id) values(10003, 'Sam_3', 10003);

insert into video_group(id,name) values(10001, 'English');
insert into video_group(id,name) values(10002, 'Hindi');
insert into video_group(id,name) values(10003, 'Custom');

insert into video(id,name,group_id) values(10001, 'Video_1', 10001);
insert into video(id,name,group_id) values(10002, 'Video_2', 10002);
insert into video(id,name,group_id) values(10003, 'Video_3', 10003);