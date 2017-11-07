create sequence hibernate_sequence start 1 increment 1
create table Accomodation (id int8 not null, description varchar(255), name varchar(255), picture_id int8, planet_id int8, primary key (id))
create table AmenityType (id int8 not null, name varchar(255), primary key (id))
create table Picture (id int8 not null, discription varchar(255), path varchar(255), title varchar(255), primary key (id))
create table Planet (id int8 not null, description varchar(255), name varchar(255), weather varchar(255), picture_id int8, solarsystem_id int8, primary key (id))
create table Room (id int8 not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id int8 not null, date timestamp, user_id int8, primary key (id))
create table RoomType (id int8 not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id int8 not null, name varchar(255), primary key (id))
create table User (id int8 not null, address varchar(255), email varchar(255), name varchar(255), password varchar(255), primary key (id))
alter table Accomodation add constraint FK3koapv3mkswmm4xkemai84beu foreign key (picture_id) references Picture
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table Planet add constraint FKl0q3nxfofr5tluicy89hxfi8k foreign key (picture_id) references Picture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKevyo6bv8spehffjmjigvodmpk foreign key (user_id) references User
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), picture_id int8, planet_id int8, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Picture (id  bigserial not null, discription varchar(255), path varchar(255), title varchar(255), primary key (id))
create table Planet (id  bigserial not null, description varchar(255), name varchar(255), weather varchar(255), picture_id int8, solarsystem_id int8, primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, date timestamp, user_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
create table User (id  bigserial not null, address varchar(255), email varchar(255), name varchar(255), password varchar(255), primary key (id))
alter table Accomodation add constraint FK3koapv3mkswmm4xkemai84beu foreign key (picture_id) references Picture
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table Planet add constraint FKl0q3nxfofr5tluicy89hxfi8k foreign key (picture_id) references Picture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKevyo6bv8spehffjmjigvodmpk foreign key (user_id) references User
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), picture_id int8, planet_id int8, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Picture (id  bigserial not null, discription varchar(255), path varchar(255), title varchar(255), primary key (id))
create table Planet (id  bigserial not null, description varchar(255), name varchar(255), weather varchar(255), picture_id int8, solarsystem_id int8, primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, date timestamp, user_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
create table User (id  bigserial not null, address varchar(255), email varchar(255), name varchar(255), password varchar(255), primary key (id))
alter table Accomodation add constraint FK3koapv3mkswmm4xkemai84beu foreign key (picture_id) references Picture
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table Planet add constraint FKl0q3nxfofr5tluicy89hxfi8k foreign key (picture_id) references Picture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKevyo6bv8spehffjmjigvodmpk foreign key (user_id) references User
