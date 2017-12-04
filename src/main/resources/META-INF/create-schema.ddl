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
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), picture_id int8, planet_id int8, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Customer (id  bigserial not null, address varchar(255), email varchar(255), name varchar(255), password varchar(255), primary key (id))
create table Picture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), primary key (id))
create table Planet (id  bigserial not null, description varchar(255), name varchar(255), weather varchar(255), picture_id int8, solarsystem_id int8, primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, date timestamp, customer_id int8, room_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
alter table Accomodation add constraint FK3koapv3mkswmm4xkemai84beu foreign key (picture_id) references Picture
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table Planet add constraint FKl0q3nxfofr5tluicy89hxfi8k foreign key (picture_id) references Picture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKbdbdkmt7xohd7jk57w4c2en8j foreign key (customer_id) references Customer
alter table RoomReservation add constraint FKlume3a5tlho5yq37p0ktt377c foreign key (room_id) references Room
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), picture_id int8, planet_id int8, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Customer (id  bigserial not null, address varchar(255), email varchar(255), name varchar(255), password varchar(255), primary key (id))
create table Picture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), primary key (id))
create table Planet (id  bigserial not null, description varchar(255), name varchar(255), weather varchar(255), picture_id int8, solarsystem_id int8, primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, date timestamp, customer_id int8, room_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
alter table Accomodation add constraint FK3koapv3mkswmm4xkemai84beu foreign key (picture_id) references Picture
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table Planet add constraint FKl0q3nxfofr5tluicy89hxfi8k foreign key (picture_id) references Picture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKbdbdkmt7xohd7jk57w4c2en8j foreign key (customer_id) references Customer
alter table RoomReservation add constraint FKlume3a5tlho5yq37p0ktt377c foreign key (room_id) references Room
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), picture_id int8, planet_id int8, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Customer (id  bigserial not null, address varchar(255), email varchar(255), name varchar(255), password varchar(255), primary key (id))
create table Picture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), primary key (id))
create table Planet (id  bigserial not null, description varchar(255), name varchar(255), weather varchar(255), picture_id int8, solarsystem_id int8, primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, date timestamp, customer_id int8, room_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
alter table Accomodation add constraint FK3koapv3mkswmm4xkemai84beu foreign key (picture_id) references Picture
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table Planet add constraint FKl0q3nxfofr5tluicy89hxfi8k foreign key (picture_id) references Picture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKbdbdkmt7xohd7jk57w4c2en8j foreign key (customer_id) references Customer
alter table RoomReservation add constraint FKlume3a5tlho5yq37p0ktt377c foreign key (room_id) references Room
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), picture_id int8, planet_id int8, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Customer (id  bigserial not null, address varchar(255), email varchar(255), name varchar(255), password varchar(255), primary key (id))
create table Picture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), primary key (id))
create table Planet (id  bigserial not null, description varchar(255), name varchar(255), weather varchar(255), picture_id int8, solarsystem_id int8, primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, date timestamp, customer_id int8, room_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
alter table Accomodation add constraint FK3koapv3mkswmm4xkemai84beu foreign key (picture_id) references Picture
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table Planet add constraint FKl0q3nxfofr5tluicy89hxfi8k foreign key (picture_id) references Picture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKbdbdkmt7xohd7jk57w4c2en8j foreign key (customer_id) references Customer
alter table RoomReservation add constraint FKlume3a5tlho5yq37p0ktt377c foreign key (room_id) references Room
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), picture_id int8, planet_id int8, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Customer (id  bigserial not null, address varchar(255), email varchar(255), name varchar(255), password varchar(255), primary key (id))
create table Picture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), primary key (id))
create table Planet (id  bigserial not null, description varchar(255), name varchar(255), weather varchar(255), picture_id int8, solarsystem_id int8, primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, date timestamp, customer_id int8, room_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
alter table Accomodation add constraint FK3koapv3mkswmm4xkemai84beu foreign key (picture_id) references Picture
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table Planet add constraint FKl0q3nxfofr5tluicy89hxfi8k foreign key (picture_id) references Picture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKbdbdkmt7xohd7jk57w4c2en8j foreign key (customer_id) references Customer
alter table RoomReservation add constraint FKlume3a5tlho5yq37p0ktt377c foreign key (room_id) references Room
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), picture_id int8, planet_id int8, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Customer (id  bigserial not null, address varchar(255), email varchar(255), name varchar(255), password varchar(255), primary key (id))
create table Picture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), primary key (id))
create table Planet (id  bigserial not null, description varchar(255), name varchar(255), weather varchar(255), picture_id int8, solarsystem_id int8, primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, date timestamp, customer_id int8, room_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
alter table Accomodation add constraint FK3koapv3mkswmm4xkemai84beu foreign key (picture_id) references Picture
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table Planet add constraint FKl0q3nxfofr5tluicy89hxfi8k foreign key (picture_id) references Picture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKbdbdkmt7xohd7jk57w4c2en8j foreign key (customer_id) references Customer
alter table RoomReservation add constraint FKlume3a5tlho5yq37p0ktt377c foreign key (room_id) references Room
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), picture_id int8, planet_id int8, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Customer (id  bigserial not null, address varchar(255), email varchar(255), name varchar(255), password varchar(255), primary key (id))
create table Picture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), primary key (id))
create table Planet (id  bigserial not null, description varchar(255), name varchar(255), weather varchar(255), picture_id int8, solarsystem_id int8, primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, date timestamp, customer_id int8, room_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
alter table Accomodation add constraint FK3koapv3mkswmm4xkemai84beu foreign key (picture_id) references Picture
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table Planet add constraint FKl0q3nxfofr5tluicy89hxfi8k foreign key (picture_id) references Picture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKbdbdkmt7xohd7jk57w4c2en8j foreign key (customer_id) references Customer
alter table RoomReservation add constraint FKlume3a5tlho5yq37p0ktt377c foreign key (room_id) references Room
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), picture_id int8, planet_id int8, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Customer (id  bigserial not null, address varchar(255), email varchar(255), name varchar(255), password varchar(255), primary key (id))
create table Picture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), primary key (id))
create table Planet (id  bigserial not null, description varchar(255), name varchar(255), weather varchar(255), picture_id int8, solarsystem_id int8, primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, date timestamp, customer_id int8, room_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
alter table Accomodation add constraint FK3koapv3mkswmm4xkemai84beu foreign key (picture_id) references Picture
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table Planet add constraint FKl0q3nxfofr5tluicy89hxfi8k foreign key (picture_id) references Picture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKbdbdkmt7xohd7jk57w4c2en8j foreign key (customer_id) references Customer
alter table RoomReservation add constraint FKlume3a5tlho5yq37p0ktt377c foreign key (room_id) references Room
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), picture_id int8, planet_id int8, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Customer (id  bigserial not null, address varchar(255), email varchar(255), name varchar(255), password varchar(255), primary key (id))
create table Picture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), primary key (id))
create table Planet (id  bigserial not null, description varchar(255), name varchar(255), weather varchar(255), picture_id int8, solarsystem_id int8, primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, date timestamp, customer_id int8, room_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
alter table Accomodation add constraint FK3koapv3mkswmm4xkemai84beu foreign key (picture_id) references Picture
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table Planet add constraint FKl0q3nxfofr5tluicy89hxfi8k foreign key (picture_id) references Picture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKbdbdkmt7xohd7jk57w4c2en8j foreign key (customer_id) references Customer
alter table RoomReservation add constraint FKlume3a5tlho5yq37p0ktt377c foreign key (room_id) references Room
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), picture_id int8, planet_id int8, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Customer (id  bigserial not null, address varchar(255), email varchar(255), name varchar(255), password varchar(255), primary key (id))
create table Picture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), primary key (id))
create table Planet (id  bigserial not null, description varchar(255), name varchar(255), weather varchar(255), picture_id int8, solarsystem_id int8, primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, date timestamp, customer_id int8, room_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
alter table Accomodation add constraint FK3koapv3mkswmm4xkemai84beu foreign key (picture_id) references Picture
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table Planet add constraint FKl0q3nxfofr5tluicy89hxfi8k foreign key (picture_id) references Picture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKbdbdkmt7xohd7jk57w4c2en8j foreign key (customer_id) references Customer
alter table RoomReservation add constraint FKlume3a5tlho5yq37p0ktt377c foreign key (room_id) references Room
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), picture_id int8, planet_id int4, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Customer (id  bigserial not null, address varchar(255), email varchar(255), name varchar(255), password varchar(255), primary key (id))
create table Picture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), primary key (id))
create table Planet (id  serial not null, description varchar(255), name varchar(255), weather varchar(255), picture_id int8, solarsystem_id int8, primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, date timestamp, customer_id int8, room_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
alter table Accomodation add constraint FK3koapv3mkswmm4xkemai84beu foreign key (picture_id) references Picture
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table Planet add constraint FKl0q3nxfofr5tluicy89hxfi8k foreign key (picture_id) references Picture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKbdbdkmt7xohd7jk57w4c2en8j foreign key (customer_id) references Customer
alter table RoomReservation add constraint FKlume3a5tlho5yq37p0ktt377c foreign key (room_id) references Room
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), picture_id int8, planet_id int4, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Customer (id  bigserial not null, address varchar(255), email varchar(255), name varchar(255), password varchar(255), primary key (id))
create table Picture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), primary key (id))
create table Planet (id  serial not null, description varchar(255), name varchar(255), weather varchar(255), picture_id int8, solarsystem_id int8, primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, date timestamp, customer_id int8, room_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
alter table Accomodation add constraint FK3koapv3mkswmm4xkemai84beu foreign key (picture_id) references Picture
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table Planet add constraint FKl0q3nxfofr5tluicy89hxfi8k foreign key (picture_id) references Picture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKbdbdkmt7xohd7jk57w4c2en8j foreign key (customer_id) references Customer
alter table RoomReservation add constraint FKlume3a5tlho5yq37p0ktt377c foreign key (room_id) references Room
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), picture_id int8, planet_id int4, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Customer (id  bigserial not null, address varchar(255), email varchar(255), name varchar(255), password varchar(255), primary key (id))
create table Picture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), primary key (id))
create table Planet (id  serial not null, description varchar(255), name varchar(255), weather varchar(255), picture_id int8, solarsystem_id int8, primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, date timestamp, customer_id int8, room_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
alter table Accomodation add constraint FK3koapv3mkswmm4xkemai84beu foreign key (picture_id) references Picture
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table Planet add constraint FKl0q3nxfofr5tluicy89hxfi8k foreign key (picture_id) references Picture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKbdbdkmt7xohd7jk57w4c2en8j foreign key (customer_id) references Customer
alter table RoomReservation add constraint FKlume3a5tlho5yq37p0ktt377c foreign key (room_id) references Room
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), picture_id int8, planet_id int4, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Customer (id  bigserial not null, address varchar(255), email varchar(255), name varchar(255), password varchar(255), primary key (id))
create table Picture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), primary key (id))
create table Planet (id  serial not null, description varchar(255), name varchar(255), weather varchar(255), picture_id int8, solarsystem_id int8, primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, date timestamp, customer_id int8, room_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
alter table Accomodation add constraint FK3koapv3mkswmm4xkemai84beu foreign key (picture_id) references Picture
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table Planet add constraint FKl0q3nxfofr5tluicy89hxfi8k foreign key (picture_id) references Picture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKbdbdkmt7xohd7jk57w4c2en8j foreign key (customer_id) references Customer
alter table RoomReservation add constraint FKlume3a5tlho5yq37p0ktt377c foreign key (room_id) references Room
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), picture_id int8, planet_id int4, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Customer (id  bigserial not null, address varchar(255), email varchar(255), name varchar(255), password varchar(255), primary key (id))
create table Picture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), primary key (id))
create table Planet (id  serial not null, description varchar(255), name varchar(255), weather varchar(255), picture_id int8, solarsystem_id int8, primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, date timestamp, customer_id int8, room_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
alter table Accomodation add constraint FK3koapv3mkswmm4xkemai84beu foreign key (picture_id) references Picture
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table Planet add constraint FKl0q3nxfofr5tluicy89hxfi8k foreign key (picture_id) references Picture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKbdbdkmt7xohd7jk57w4c2en8j foreign key (customer_id) references Customer
alter table RoomReservation add constraint FKlume3a5tlho5yq37p0ktt377c foreign key (room_id) references Room
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), picture_id int8, planet_id int4, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Customer (id  bigserial not null, address varchar(255), email varchar(255), name varchar(255), password varchar(255), primary key (id))
create table Picture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), primary key (id))
create table Planet (id  serial not null, description varchar(255), name varchar(255), weather varchar(255), picture_id int8, solarsystem_id int8, primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, date timestamp, customer_id int8, room_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
alter table Accomodation add constraint FK3koapv3mkswmm4xkemai84beu foreign key (picture_id) references Picture
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table Planet add constraint FKl0q3nxfofr5tluicy89hxfi8k foreign key (picture_id) references Picture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKbdbdkmt7xohd7jk57w4c2en8j foreign key (customer_id) references Customer
alter table RoomReservation add constraint FKlume3a5tlho5yq37p0ktt377c foreign key (room_id) references Room
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), picture_id int8, planet_id int4, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Customer (id  bigserial not null, address varchar(255), email varchar(255), name varchar(255), password varchar(255), primary key (id))
create table Picture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), primary key (id))
create table Planet (id  serial not null, description varchar(255), name varchar(255), weather varchar(255), picture_id int8, solarsystem_id int8, primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, date timestamp, customer_id int8, room_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
alter table Accomodation add constraint FK3koapv3mkswmm4xkemai84beu foreign key (picture_id) references Picture
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table Planet add constraint FKl0q3nxfofr5tluicy89hxfi8k foreign key (picture_id) references Picture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKbdbdkmt7xohd7jk57w4c2en8j foreign key (customer_id) references Customer
alter table RoomReservation add constraint FKlume3a5tlho5yq37p0ktt377c foreign key (room_id) references Room
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), picture_id int8, planet_id int4, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Customer (id  bigserial not null, address varchar(255), email varchar(255), name varchar(255), password varchar(255), primary key (id))
create table Picture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), primary key (id))
create table Planet (id  serial not null, description varchar(255), name varchar(255), weather varchar(255), picture_id int8, solarsystem_id int8, primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, date timestamp, customer_id int8, room_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
alter table Accomodation add constraint FK3koapv3mkswmm4xkemai84beu foreign key (picture_id) references Picture
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table Planet add constraint FKl0q3nxfofr5tluicy89hxfi8k foreign key (picture_id) references Picture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKbdbdkmt7xohd7jk57w4c2en8j foreign key (customer_id) references Customer
alter table RoomReservation add constraint FKlume3a5tlho5yq37p0ktt377c foreign key (room_id) references Room
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), picture_id int8, planet_id int4, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Customer (id  bigserial not null, address varchar(255), email varchar(255), name varchar(255), password varchar(255), primary key (id))
create table Picture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), primary key (id))
create table Planet (id  serial not null, description varchar(255), name varchar(255), weather varchar(255), picture_id int8, solarsystem_id int8, primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, date timestamp, customer_id int8, room_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
alter table Accomodation add constraint FK3koapv3mkswmm4xkemai84beu foreign key (picture_id) references Picture
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table Planet add constraint FKl0q3nxfofr5tluicy89hxfi8k foreign key (picture_id) references Picture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKbdbdkmt7xohd7jk57w4c2en8j foreign key (customer_id) references Customer
alter table RoomReservation add constraint FKlume3a5tlho5yq37p0ktt377c foreign key (room_id) references Room
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), picture_id int8, planet_id int4, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Customer (id  bigserial not null, address varchar(255), email varchar(255), name varchar(255), password varchar(255), primary key (id))
create table Picture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), primary key (id))
create table Planet (id  serial not null, description varchar(255), name varchar(255), weather varchar(255), picture_id int8, solarsystem_id int8, primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, date timestamp, customer_id int8, room_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
alter table Accomodation add constraint FK3koapv3mkswmm4xkemai84beu foreign key (picture_id) references Picture
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table Planet add constraint FKl0q3nxfofr5tluicy89hxfi8k foreign key (picture_id) references Picture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKbdbdkmt7xohd7jk57w4c2en8j foreign key (customer_id) references Customer
alter table RoomReservation add constraint FKlume3a5tlho5yq37p0ktt377c foreign key (room_id) references Room
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), picture_id int8, planet_id int4, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Customer (id  bigserial not null, address varchar(255), email varchar(255), name varchar(255), password varchar(255), primary key (id))
create table Picture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), primary key (id))
create table Planet (id  serial not null, description varchar(255), name varchar(255), weather varchar(255), picture_id int8, solarsystem_id int8, primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, date timestamp, customer_id int8, room_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
alter table Accomodation add constraint FK3koapv3mkswmm4xkemai84beu foreign key (picture_id) references Picture
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table Planet add constraint FKl0q3nxfofr5tluicy89hxfi8k foreign key (picture_id) references Picture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKbdbdkmt7xohd7jk57w4c2en8j foreign key (customer_id) references Customer
alter table RoomReservation add constraint FKlume3a5tlho5yq37p0ktt377c foreign key (room_id) references Room
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), picture_id int8, planet_id int4, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Customer (id  bigserial not null, address varchar(255), email varchar(255), name varchar(255), password varchar(255), primary key (id))
create table Picture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), primary key (id))
create table Planet (id  serial not null, description varchar(255), name varchar(255), weather varchar(255), picture_id int8, solarsystem_id int8, primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, date timestamp, customer_id int8, room_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
alter table Accomodation add constraint FK3koapv3mkswmm4xkemai84beu foreign key (picture_id) references Picture
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table Planet add constraint FKl0q3nxfofr5tluicy89hxfi8k foreign key (picture_id) references Picture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKbdbdkmt7xohd7jk57w4c2en8j foreign key (customer_id) references Customer
alter table RoomReservation add constraint FKlume3a5tlho5yq37p0ktt377c foreign key (room_id) references Room
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), picture_id int8, planet_id int4, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Customer (id  bigserial not null, address varchar(255), email varchar(255), name varchar(255), password varchar(255), primary key (id))
create table Picture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), primary key (id))
create table Planet (id  serial not null, description varchar(255), name varchar(255), weather varchar(255), picture_id int8, solarsystem_id int8, primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, date timestamp, customer_id int8, room_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
alter table Accomodation add constraint FK3koapv3mkswmm4xkemai84beu foreign key (picture_id) references Picture
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table Planet add constraint FKl0q3nxfofr5tluicy89hxfi8k foreign key (picture_id) references Picture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKbdbdkmt7xohd7jk57w4c2en8j foreign key (customer_id) references Customer
alter table RoomReservation add constraint FKlume3a5tlho5yq37p0ktt377c foreign key (room_id) references Room
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), picture_id int8, planet_id int4, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Customer (id  bigserial not null, address varchar(255), email varchar(255), name varchar(255), password varchar(255), primary key (id))
create table Picture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), primary key (id))
create table Planet (id  serial not null, description varchar(255), name varchar(255), weather varchar(255), picture_id int8, solarsystem_id int8, primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, date timestamp, customer_id int8, room_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
alter table Accomodation add constraint FK3koapv3mkswmm4xkemai84beu foreign key (picture_id) references Picture
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table Planet add constraint FKl0q3nxfofr5tluicy89hxfi8k foreign key (picture_id) references Picture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKbdbdkmt7xohd7jk57w4c2en8j foreign key (customer_id) references Customer
alter table RoomReservation add constraint FKlume3a5tlho5yq37p0ktt377c foreign key (room_id) references Room
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), picture_id int8, planet_id int4, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Customer (id  bigserial not null, address varchar(255), email varchar(255), name varchar(255), password varchar(255), primary key (id))
create table Picture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), primary key (id))
create table Planet (id  serial not null, description varchar(255), name varchar(255), weather varchar(255), picture_id int8, solarsystem_id int8, primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, date timestamp, customer_id int8, room_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
alter table Accomodation add constraint FK3koapv3mkswmm4xkemai84beu foreign key (picture_id) references Picture
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table Planet add constraint FKl0q3nxfofr5tluicy89hxfi8k foreign key (picture_id) references Picture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKbdbdkmt7xohd7jk57w4c2en8j foreign key (customer_id) references Customer
alter table RoomReservation add constraint FKlume3a5tlho5yq37p0ktt377c foreign key (room_id) references Room
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), picture_id int8, planet_id int4, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Customer (id  bigserial not null, address varchar(255), email varchar(255), name varchar(255), password varchar(255), primary key (id))
create table Picture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), primary key (id))
create table Planet (id  serial not null, description varchar(255), name varchar(255), weather varchar(255), picture_id int8, solarsystem_id int8, primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, date timestamp, customer_id int8, room_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
alter table Accomodation add constraint FK3koapv3mkswmm4xkemai84beu foreign key (picture_id) references Picture
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table Planet add constraint FKl0q3nxfofr5tluicy89hxfi8k foreign key (picture_id) references Picture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKbdbdkmt7xohd7jk57w4c2en8j foreign key (customer_id) references Customer
alter table RoomReservation add constraint FKlume3a5tlho5yq37p0ktt377c foreign key (room_id) references Room
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), picture_id int8, planet_id int4, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Customer (id  bigserial not null, address varchar(255), email varchar(255), name varchar(255), password varchar(255), primary key (id))
create table Picture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), primary key (id))
create table Planet (id  serial not null, description varchar(255), name varchar(255), weather varchar(255), picture_id int8, solarsystem_id int8, primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, date timestamp, customer_id int8, room_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
alter table Accomodation add constraint FK3koapv3mkswmm4xkemai84beu foreign key (picture_id) references Picture
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table Planet add constraint FKl0q3nxfofr5tluicy89hxfi8k foreign key (picture_id) references Picture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKbdbdkmt7xohd7jk57w4c2en8j foreign key (customer_id) references Customer
alter table RoomReservation add constraint FKlume3a5tlho5yq37p0ktt377c foreign key (room_id) references Room
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), picture_id int8, planet_id int4, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Customer (id  bigserial not null, address varchar(255), email varchar(255), name varchar(255), password varchar(255), primary key (id))
create table Picture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), primary key (id))
create table Planet (id  serial not null, description varchar(255), name varchar(255), weather varchar(255), picture_id int8, solarsystem_id int8, primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, date timestamp, customer_id int8, room_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
alter table Accomodation add constraint FK3koapv3mkswmm4xkemai84beu foreign key (picture_id) references Picture
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table Planet add constraint FKl0q3nxfofr5tluicy89hxfi8k foreign key (picture_id) references Picture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKbdbdkmt7xohd7jk57w4c2en8j foreign key (customer_id) references Customer
alter table RoomReservation add constraint FKlume3a5tlho5yq37p0ktt377c foreign key (room_id) references Room
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), picture_id int8, planet_id int4, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Customer (id  bigserial not null, address varchar(255), email varchar(255), name varchar(255), password varchar(255), primary key (id))
create table Picture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), primary key (id))
create table Planet (id  serial not null, description varchar(255), name varchar(255), weather varchar(255), picture_id int8, solarsystem_id int8, primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, date timestamp, customer_id int8, room_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
alter table Accomodation add constraint FK3koapv3mkswmm4xkemai84beu foreign key (picture_id) references Picture
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table Planet add constraint FKl0q3nxfofr5tluicy89hxfi8k foreign key (picture_id) references Picture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKbdbdkmt7xohd7jk57w4c2en8j foreign key (customer_id) references Customer
alter table RoomReservation add constraint FKlume3a5tlho5yq37p0ktt377c foreign key (room_id) references Room
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), picture_id int8, planet_id int4, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Customer (id  bigserial not null, address varchar(255), email varchar(255), name varchar(255), password varchar(255), primary key (id))
create table Picture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), primary key (id))
create table Planet (id  serial not null, description varchar(255), name varchar(255), weather varchar(255), picture_id int8, solarsystem_id int8, primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, date timestamp, customer_id int8, room_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
alter table Accomodation add constraint FK3koapv3mkswmm4xkemai84beu foreign key (picture_id) references Picture
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table Planet add constraint FKl0q3nxfofr5tluicy89hxfi8k foreign key (picture_id) references Picture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKbdbdkmt7xohd7jk57w4c2en8j foreign key (customer_id) references Customer
alter table RoomReservation add constraint FKlume3a5tlho5yq37p0ktt377c foreign key (room_id) references Room
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), picture_id int8, planet_id int4, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Customer (id  bigserial not null, address varchar(255), email varchar(255), name varchar(255), password varchar(255), primary key (id))
create table Picture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), primary key (id))
create table Planet (id  serial not null, description varchar(255), name varchar(255), weather varchar(255), picture_id int8, solarsystem_id int8, primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, date timestamp, customer_id int8, room_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
alter table Accomodation add constraint FK3koapv3mkswmm4xkemai84beu foreign key (picture_id) references Picture
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table Planet add constraint FKl0q3nxfofr5tluicy89hxfi8k foreign key (picture_id) references Picture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKbdbdkmt7xohd7jk57w4c2en8j foreign key (customer_id) references Customer
alter table RoomReservation add constraint FKlume3a5tlho5yq37p0ktt377c foreign key (room_id) references Room
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), picture_id int8, planet_id int8, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Customer (id  bigserial not null, address varchar(255), email varchar(255), name varchar(255), password varchar(255), primary key (id))
create table Picture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), primary key (id))
create table Planet (id  bigserial not null, description varchar(255), name varchar(255), weather varchar(255), picture_id int8, solarsystem_id int8, primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, date timestamp, customer_id int8, room_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
alter table Accomodation add constraint FK3koapv3mkswmm4xkemai84beu foreign key (picture_id) references Picture
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table Planet add constraint FKl0q3nxfofr5tluicy89hxfi8k foreign key (picture_id) references Picture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKbdbdkmt7xohd7jk57w4c2en8j foreign key (customer_id) references Customer
alter table RoomReservation add constraint FKlume3a5tlho5yq37p0ktt377c foreign key (room_id) references Room
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), picture_id int8, planet_id int8, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Customer (id  bigserial not null, address varchar(255), email varchar(255), name varchar(255), password varchar(255), primary key (id))
create table Picture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), primary key (id))
create table Planet (id  bigserial not null, description varchar(255), name varchar(255), weather varchar(255), picture_id int8, solarsystem_id int8, primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, date timestamp, customer_id int8, room_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
alter table Accomodation add constraint FK3koapv3mkswmm4xkemai84beu foreign key (picture_id) references Picture
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table Planet add constraint FKl0q3nxfofr5tluicy89hxfi8k foreign key (picture_id) references Picture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKbdbdkmt7xohd7jk57w4c2en8j foreign key (customer_id) references Customer
alter table RoomReservation add constraint FKlume3a5tlho5yq37p0ktt377c foreign key (room_id) references Room
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), picture_id int8, planet_id int8, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Customer (id  bigserial not null, address varchar(255), email varchar(255), name varchar(255), password varchar(255), primary key (id))
create table Picture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), primary key (id))
create table Planet (id  bigserial not null, description varchar(255), name varchar(255), weather varchar(255), picture_id int8, solarsystem_id int8, primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, date timestamp, customer_id int8, room_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
alter table Accomodation add constraint FK3koapv3mkswmm4xkemai84beu foreign key (picture_id) references Picture
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table Planet add constraint FKl0q3nxfofr5tluicy89hxfi8k foreign key (picture_id) references Picture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKbdbdkmt7xohd7jk57w4c2en8j foreign key (customer_id) references Customer
alter table RoomReservation add constraint FKlume3a5tlho5yq37p0ktt377c foreign key (room_id) references Room
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), picture_id int8, planet_id int8, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Customer (id  bigserial not null, address varchar(255), city varchar(255), country varchar(255), email varchar(255) not null, firstName varchar(255), lastName varchar(255), password varchar(255), postalCode varchar(255), primary key (id))
create table Picture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), primary key (id))
create table Planet (id  bigserial not null, description varchar(255), name varchar(255), weather varchar(255), picture_id int8, solarsystem_id int8, primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, endDate date, startDate date, customer_id int8, room_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
alter table Customer add constraint UK_3qgg01qojcmbdp47dkaom9x45 unique (email)
alter table Accomodation add constraint FK3koapv3mkswmm4xkemai84beu foreign key (picture_id) references Picture
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table Planet add constraint FKl0q3nxfofr5tluicy89hxfi8k foreign key (picture_id) references Picture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKbdbdkmt7xohd7jk57w4c2en8j foreign key (customer_id) references Customer
alter table RoomReservation add constraint FKlume3a5tlho5yq37p0ktt377c foreign key (room_id) references Room
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), picture_id int8, planet_id int8, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Customer (id  bigserial not null, address varchar(255), city varchar(255), country varchar(255), email varchar(255) not null, firstName varchar(255), lastName varchar(255), password varchar(255), postalCode varchar(255), primary key (id))
create table Picture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), primary key (id))
create table Planet (id  bigserial not null, description varchar(255), name varchar(255), weather varchar(255), picture_id int8, solarsystem_id int8, primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, endDate date, startDate date, customer_id int8, room_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
alter table Customer add constraint UK_3qgg01qojcmbdp47dkaom9x45 unique (email)
alter table Accomodation add constraint FK3koapv3mkswmm4xkemai84beu foreign key (picture_id) references Picture
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table Planet add constraint FKl0q3nxfofr5tluicy89hxfi8k foreign key (picture_id) references Picture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKbdbdkmt7xohd7jk57w4c2en8j foreign key (customer_id) references Customer
alter table RoomReservation add constraint FKlume3a5tlho5yq37p0ktt377c foreign key (room_id) references Room
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), planet_id int8, primary key (id))
create table AccomodationPicture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), accomodation_id int8, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Customer (id  bigserial not null, address varchar(255), city varchar(255), country varchar(255), email varchar(255) not null, firstName varchar(255), lastName varchar(255), password varchar(255), postalCode varchar(255), primary key (id))
create table Planet (id  bigserial not null, description varchar(255), name varchar(255), weather varchar(255), planetPicture_id int8, solarsystem_id int8, primary key (id))
create table PlanetPicture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, endDate date, startDate date, customer_id int8, room_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
alter table Customer add constraint UK_3qgg01qojcmbdp47dkaom9x45 unique (email)
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table AccomodationPicture add constraint FK7lsj4i3b054wnrjxphhtiv8vn foreign key (accomodation_id) references Accomodation
alter table Planet add constraint FKqi98f2mgee2mlsp0tmivhfhc6 foreign key (planetPicture_id) references PlanetPicture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKbdbdkmt7xohd7jk57w4c2en8j foreign key (customer_id) references Customer
alter table RoomReservation add constraint FKlume3a5tlho5yq37p0ktt377c foreign key (room_id) references Room
SET statement_timeout = 0
SET lock_timeout = 0
SET client_encoding = 'UTF8'
SET standard_conforming_strings = on
SET check_function_bodies = false
SET client_min_messages = warning
SET row_security = off
SET search_path = public, pg_catalog
INSERT INTO planetPicture VALUES (1, 'Ugly insects', 'geonosis.jpg', 'Geonosis')
INSERT INTO planetPicture VALUES (2, 'The planet where maybe exists life', 'mars.jpg', 'Mars')
INSERT INTO planetPicture VALUES (3, 'The place of waving flag', 'moon.jpg', 'Moon')
INSERT INTO planetPicture VALUES (4, 'Giant planet with giant ring', 'saturn.jpg', 'Saturn')
INSERT INTO planetPicture VALUES (5, 'Desert Planet', 'tatooine.jpg', 'Tatooine')
INSERT INTO solarsystem VALUES (1, 'Milky Way')
INSERT INTO solarsystem VALUES (2, 'Star Wars')
INSERT INTO planet VALUES (1, 'The place where we live. Mars is the fourth planet from the Sun and the second-smallest planet in the Solar System after Mercury. Mars''s average distance from the Sun is roughly 230 million kilometres. Orbital period is 687 (Earth) days.', 'Mars', 'The winter is coming...Average temperature is about -60 C°, although it can vary from -125 C° near the poles during the winter to as much as a comfortable 20 C° at midday near the equator.', 3, 1)
INSERT INTO planet VALUES (2, 'Far far away from home. Saturn is the sixth planet from the Sun and the second-largest in the Solar System.The planet''s most famous feature is its prominent ring system that is composed mostly of ice particles, rocky debris and dust. ', 'Saturn', 'Pretty violent and stormy!', 4, 1)
INSERT INTO planet VALUES (3, 'In the neighbourhood.', 'Moon', 'Daytime temperatures on the sunny side of the moon reach 273 degrees F (134 C°); on the dark side it gets as cold as minus 243 F (minus 153 C°).', 2, 1)
INSERT INTO planet VALUES (4, 'Tatooine was a sparsely inhabited circumbinary desert planet located in the galaxy''s Outer Rim Territories. It would serve as the homeworld to the influential Anakin and Luke Skywalker, who would go on to shape galactic history.', 'Tatooine', 'Warm and dry', 5, 2)
INSERT INTO planet VALUES (5, 'Rocky and hard place. Situated in the Geonosis system of the Arkanis sector in the Outer Rim Territories, the planet of Geonosis was 43,000 light years from the Galactic Core, and less than a parsec away from the Outer Rim planet of Tatooine.', 'Geonosis', 'Dry', 1, 2)
INSERT INTO accomodation VALUES (1, 'Hotel with green plants. On every morning we offer you to taste fresh veggies. Enjoy the long walk in the first Martian greenhouse!', 'Mars base 1', 1)
INSERT INTO accomodation VALUES (2, 'ESA Hotel for backpackers. Since the dawn of the space age, Mars has been the target of orbiters, landers and rovers. And now for the backpackers! We offer a multicultural atmosphere, many cultural programs are available.', 'Welcome Hotel', 1)
INSERT INTO accomodation VALUES (3, 'Memorable and chip hotel in Venusville, a very special and bizarre district of a human town. Radiation protection is weak, but enjoyment is guaranteed. Mercenaries, freedom fighters and a lot of mutants.', 'The Last Resort in Venusville', 1)
INSERT INTO accomodation VALUES (4, 'Iron walls, deep jail cells in the middle of the desert. The boss has big ambition, and big body. Mercenaries, bounty hunters and other bizarre creatures. Only for the braves.', 'Jabba''s Palace', 4)
INSERT INTO accomodation VALUES (5, 'Nice music and a lot of guests from all part of the Universe', 'Mos Esley Cantina', 4)
INSERT INTO accomodationPicture VALUES (1, 'Iron walls in the desert.', 'jabba_palace.jpg', 'Jabba''s palace', 4)
INSERT INTO accomodationPicture VALUES (2, 'A twi''lek receptionist. He will salute you with these words: "Die wanna wanga"', 'jabba_bib_fortuna.jpg', 'Bib Fortuna', 4)
INSERT INTO accomodationPicture VALUES (3, 'Always tell him the truth. For your sake.', 'jabba_guard.jpg', 'Gamorrean security man', 4)
INSERT INTO accomodationPicture VALUES (4, 'She waits only for you, if you are a good boy. Or a bad girl.', 'jabba_dancer.jpg', 'Sensual maid', 4)
INSERT INTO accomodationPicture VALUES (5, 'Jabba''s best supplier.', 'jabba_boba_fett.jpg', 'Boba Fett', 4)
INSERT INTO accomodationPicture VALUES (6, 'Golden protocol droid.', 'jabba_3cpo.jpg', '3CPO', 4)
INSERT INTO accomodationPicture VALUES (7, 'The big, big boss.', 'jabba_face.jpg', 'Jabba the Hutt', 4)
INSERT INTO accomodationPicture VALUES (8, 'Very special bed.', 'jabba_han_place.jpg', 'Single Room', 4)
INSERT INTO accomodationPicture VALUES (9, 'Rancor Pit', 'jabba_rancor_pit.jpg', 'Family Room', 4)
INSERT INTO accomodationPicture VALUES (10, 'It''s not the Franz Liszt Chamber Orchestra...', 'jabba_band.jpg', 'The Band', 4)
INSERT INTO accomodationPicture VALUES (11, 'Safari in the desert.', 'jabba_desert.jpg', 'Excursion', 4)
INSERT INTO accomodationPicture VALUES (12, 'Dark cave.', 'jabba_sarlacc.jpg', 'Special offer', 4)
INSERT INTO accomodationPicture VALUES (13, 'Hotel with silo', 'marsbase1.jpg', 'Mars base 1', 1)
INSERT INTO accomodationPicture VALUES (14, 'ESA Hotel', 'marsbase2.jpg', 'Mars base 2', 2)
INSERT INTO accomodationPicture VALUES (15, 'Han Solo and Luke: The beginning of a beautiful friendship', 'mos_esley.jpg', 'mos_esley', 5)
INSERT INTO accomodationPicture VALUES (16, 'Total Recall', 'venusville4.jpg', 'Venusville', 3)
SELECT pg_catalog.setval('accomodation_id_seq', 5, true)
SELECT pg_catalog.setval('amenitytype_id_seq', 1, false)
INSERT INTO customer VALUES (1, 'Várkert bazár 1.', 'Budapest', 'Hungary', 'admin', 'admin', 'admin', 'admin', '1140')
INSERT INTO customer VALUES (2, 'Hősök tere 1.', 'Budapest', 'Hungary', 'berci@freemail.hu', 'Bertalan', 'Farkas', 'abcd1234', '1140')
SELECT pg_catalog.setval('customer_id_seq', 2, true)
SELECT pg_catalog.setval('hibernate_sequence', 5, true)
SELECT pg_catalog.setval('planetpicture_id_seq', 5, true)
SELECT pg_catalog.setval('accomodationpicture_id_seq', 16, true)
SELECT pg_catalog.setval('planet_id_seq', 5, true)
INSERT INTO roomtype VALUES (1, 1, 'Single Room')
INSERT INTO roomtype VALUES (2, 4, 'King''s Suite')
INSERT INTO roomtype VALUES (3, 10, 'Family Room')
INSERT INTO roomtype VALUES (4, 2, 'Honeymoon Suite')
INSERT INTO roomtype VALUES (5, 2, 'Double Room')
INSERT INTO room VALUES (1, 300, 1, 5)
INSERT INTO room VALUES (2, 600, 1, 2)
INSERT INTO room VALUES (3, 2500, 1, 3)
INSERT INTO room VALUES (4, 2500, 1, 3)
INSERT INTO room VALUES (5, 1000, 1, 4)
INSERT INTO room VALUES (6, 300, 4, 1)
INSERT INTO room VALUES (7, 1000, 4, 2)
INSERT INTO room VALUES (8, 600, 4, 5)
INSERT INTO room VALUES (9, 800, 4, 4)
INSERT INTO room VALUES (10, 200, 3, 1)
INSERT INTO room VALUES (11, 600, 3, 5)
INSERT INTO room VALUES (12, 800, 3, 4)
INSERT INTO room VALUES (13, 1000, 3, 2)
INSERT INTO room VALUES (14, 1000, 3, 2)
INSERT INTO room VALUES (15, 2000, 3, 3)
SELECT pg_catalog.setval('room_id_seq', 15, true)
INSERT INTO roomreservation VALUES (1, '2017-12-20', '2017-12-10', 2, 10)
INSERT INTO roomreservation VALUES (2, '2017-12-20', '2017-12-10', 2, 13)
SELECT pg_catalog.setval('roomreservation_id_seq', 2, true)
SELECT pg_catalog.setval('roomtype_id_seq', 5, true)
SELECT pg_catalog.setval('solarsystem_id_seq', 2, true)
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), planet_id int8, primary key (id))
create table AccomodationPicture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), accomodation_id int8, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Customer (id  bigserial not null, address varchar(255), city varchar(255), country varchar(255), email varchar(255) not null, firstName varchar(255), lastName varchar(255), password varchar(255), postalCode varchar(255), primary key (id))
create table Planet (id  bigserial not null, description varchar(255), name varchar(255), weather varchar(255), planetPicture_id int8, solarsystem_id int8, primary key (id))
create table PlanetPicture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, endDate date, startDate date, customer_id int8, room_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
alter table Customer add constraint UK_3qgg01qojcmbdp47dkaom9x45 unique (email)
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table AccomodationPicture add constraint FK7lsj4i3b054wnrjxphhtiv8vn foreign key (accomodation_id) references Accomodation
alter table Planet add constraint FKqi98f2mgee2mlsp0tmivhfhc6 foreign key (planetPicture_id) references PlanetPicture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKbdbdkmt7xohd7jk57w4c2en8j foreign key (customer_id) references Customer
alter table RoomReservation add constraint FKlume3a5tlho5yq37p0ktt377c foreign key (room_id) references Room
SET statement_timeout = 0
SET lock_timeout = 0
SET client_encoding = 'UTF8'
SET standard_conforming_strings = on
SET check_function_bodies = false
SET client_min_messages = warning
SET row_security = off
SET search_path = public, pg_catalog
INSERT INTO planetPicture VALUES (1, 'Ugly insects', 'geonosis.jpg', 'Geonosis')
INSERT INTO planetPicture VALUES (2, 'The planet where maybe exists life', 'mars.jpg', 'Mars')
INSERT INTO planetPicture VALUES (3, 'The place of waving flag', 'moon.jpg', 'Moon')
INSERT INTO planetPicture VALUES (4, 'Giant planet with giant ring', 'saturn.jpg', 'Saturn')
INSERT INTO planetPicture VALUES (5, 'Desert Planet', 'tatooine.jpg', 'Tatooine')
INSERT INTO solarsystem VALUES (1, 'Milky Way')
INSERT INTO solarsystem VALUES (2, 'Star Wars')
INSERT INTO planet VALUES (1, 'The place where we live. Mars is the fourth planet from the Sun and the second-smallest planet in the Solar System after Mercury. Mars''s average distance from the Sun is roughly 230 million kilometres. Orbital period is 687 (Earth) days.', 'Mars', 'The winter is coming...Average temperature is about -60 C°, although it can vary from -125 C° near the poles during the winter to as much as a comfortable 20 C° at midday near the equator.', 3, 1)
INSERT INTO planet VALUES (2, 'Far far away from home. Saturn is the sixth planet from the Sun and the second-largest in the Solar System.The planet''s most famous feature is its prominent ring system that is composed mostly of ice particles, rocky debris and dust. ', 'Saturn', 'Pretty violent and stormy!', 4, 1)
INSERT INTO planet VALUES (3, 'In the neighbourhood.', 'Moon', 'Daytime temperatures on the sunny side of the moon reach 273 degrees F (134 C°); on the dark side it gets as cold as minus 243 F (minus 153 C°).', 2, 1)
INSERT INTO planet VALUES (4, 'Tatooine was a sparsely inhabited circumbinary desert planet located in the galaxy''s Outer Rim Territories. It would serve as the homeworld to the influential Anakin and Luke Skywalker, who would go on to shape galactic history.', 'Tatooine', 'Warm and dry', 5, 2)
INSERT INTO planet VALUES (5, 'Rocky and hard place. Situated in the Geonosis system of the Arkanis sector in the Outer Rim Territories, the planet of Geonosis was 43,000 light years from the Galactic Core, and less than a parsec away from the Outer Rim planet of Tatooine.', 'Geonosis', 'Dry', 1, 2)
INSERT INTO accomodation VALUES (1, 'Hotel with green plants. On every morning we offer you to taste fresh veggies. Enjoy the long walk in the first Martian greenhouse!', 'Mars base 1', 1)
INSERT INTO accomodation VALUES (2, 'ESA Hotel for backpackers. Since the dawn of the space age, Mars has been the target of orbiters, landers and rovers. And now for the backpackers! We offer a multicultural atmosphere, many cultural programs are available.', 'Welcome Hotel', 1)
INSERT INTO accomodation VALUES (3, 'Memorable and chip hotel in Venusville, a very special and bizarre district of a human town. Radiation protection is weak, but enjoyment is guaranteed. Mercenaries, freedom fighters and a lot of mutants.', 'The Last Resort in Venusville', 1)
INSERT INTO accomodation VALUES (4, 'Iron walls, deep jail cells in the middle of the desert. The boss has big ambition, and big body. Mercenaries, bounty hunters and other bizarre creatures. Only for the braves.', 'Jabba''s Palace', 4)
INSERT INTO accomodation VALUES (5, 'Nice music and a lot of guests from all part of the Universe', 'Mos Esley Cantina', 4)
INSERT INTO accomodationPicture VALUES (1, 'Iron walls in the desert.', 'jabba_palace.jpg', 'Jabba''s palace', 4)
INSERT INTO accomodationPicture VALUES (2, 'A twi''lek receptionist. He will salute you with these words: "Die wanna wanga"', 'jabba_bib_fortuna.jpg', 'Bib Fortuna', 4)
INSERT INTO accomodationPicture VALUES (3, 'Always tell him the truth. For your sake.', 'jabba_guard.jpg', 'Gamorrean security man', 4)
INSERT INTO accomodationPicture VALUES (4, 'She waits only for you, if you are a good boy. Or a bad girl.', 'jabba_dancer.jpg', 'Sensual maid', 4)
INSERT INTO accomodationPicture VALUES (5, 'Jabba''s best supplier.', 'jabba_boba_fett.jpg', 'Boba Fett', 4)
INSERT INTO accomodationPicture VALUES (6, 'Golden protocol droid.', 'jabba_3cpo.jpg', '3CPO', 4)
INSERT INTO accomodationPicture VALUES (7, 'The big, big boss.', 'jabba_face.jpg', 'Jabba the Hutt', 4)
INSERT INTO accomodationPicture VALUES (8, 'Very special bed.', 'jabba_han_place.jpg', 'Single Room', 4)
INSERT INTO accomodationPicture VALUES (9, 'Rancor Pit', 'jabba_rancor_pit.jpg', 'Family Room', 4)
INSERT INTO accomodationPicture VALUES (10, 'It''s not the Franz Liszt Chamber Orchestra...', 'jabba_band.jpg', 'The Band', 4)
INSERT INTO accomodationPicture VALUES (11, 'Safari in the desert.', 'jabba_desert.jpg', 'Excursion', 4)
INSERT INTO accomodationPicture VALUES (12, 'Dark cave.', 'jabba_sarlacc.jpg', 'Special offer', 4)
INSERT INTO accomodationPicture VALUES (13, 'Hotel with silo', 'marsbase1.jpg', 'Mars base 1', 1)
INSERT INTO accomodationPicture VALUES (14, 'ESA Hotel', 'marsbase2.jpg', 'Mars base 2', 2)
INSERT INTO accomodationPicture VALUES (15, 'Han Solo and Luke: The beginning of a beautiful friendship', 'mos_esley.jpg', 'mos_esley', 5)
INSERT INTO accomodationPicture VALUES (16, 'Total Recall', 'venusville4.jpg', 'Venusville', 3)
SELECT pg_catalog.setval('accomodation_id_seq', 5, true)
SELECT pg_catalog.setval('amenitytype_id_seq', 1, false)
INSERT INTO customer VALUES (1, 'Várkert bazár 1.', 'Budapest', 'Hungary', 'admin', 'admin', 'admin', 'admin', '1140')
INSERT INTO customer VALUES (2, 'Hősök tere 1.', 'Budapest', 'Hungary', 'berci@freemail.hu', 'Bertalan', 'Farkas', 'abcd1234', '1140')
SELECT pg_catalog.setval('customer_id_seq', 2, true)
SELECT pg_catalog.setval('hibernate_sequence', 5, true)
SELECT pg_catalog.setval('planetpicture_id_seq', 5, true)
SELECT pg_catalog.setval('accomodationpicture_id_seq', 16, true)
SELECT pg_catalog.setval('planet_id_seq', 5, true)
INSERT INTO roomtype VALUES (1, 1, 'Single Room')
INSERT INTO roomtype VALUES (2, 4, 'King''s Suite')
INSERT INTO roomtype VALUES (3, 10, 'Family Room')
INSERT INTO roomtype VALUES (4, 2, 'Honeymoon Suite')
INSERT INTO roomtype VALUES (5, 2, 'Double Room')
INSERT INTO room VALUES (1, 300, 1, 5)
INSERT INTO room VALUES (2, 600, 1, 2)
INSERT INTO room VALUES (3, 2500, 1, 3)
INSERT INTO room VALUES (4, 2500, 1, 3)
INSERT INTO room VALUES (5, 1000, 1, 4)
INSERT INTO room VALUES (6, 300, 4, 1)
INSERT INTO room VALUES (7, 1000, 4, 2)
INSERT INTO room VALUES (8, 600, 4, 5)
INSERT INTO room VALUES (9, 800, 4, 4)
INSERT INTO room VALUES (10, 200, 3, 1)
INSERT INTO room VALUES (11, 600, 3, 5)
INSERT INTO room VALUES (12, 800, 3, 4)
INSERT INTO room VALUES (13, 1000, 3, 2)
INSERT INTO room VALUES (14, 1000, 3, 2)
INSERT INTO room VALUES (15, 2000, 3, 3)
SELECT pg_catalog.setval('room_id_seq', 15, true)
INSERT INTO roomreservation VALUES (1, '2017-12-20', '2017-12-10', 2, 10)
INSERT INTO roomreservation VALUES (2, '2017-12-20', '2017-12-10', 2, 13)
SELECT pg_catalog.setval('roomreservation_id_seq', 2, true)
SELECT pg_catalog.setval('roomtype_id_seq', 5, true)
SELECT pg_catalog.setval('solarsystem_id_seq', 2, true)
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), planet_id int8, primary key (id))
create table AccomodationPicture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), accomodation_id int8, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Customer (id  bigserial not null, address varchar(255), city varchar(255), country varchar(255), email varchar(255) not null, firstName varchar(255), lastName varchar(255), password varchar(255), postalCode varchar(255), primary key (id))
create table Planet (id  bigserial not null, description varchar(255), name varchar(255), weather varchar(255), planetPicture_id int8, solarsystem_id int8, primary key (id))
create table PlanetPicture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, endDate date, startDate date, customer_id int8, room_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
alter table Customer add constraint UK_3qgg01qojcmbdp47dkaom9x45 unique (email)
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table AccomodationPicture add constraint FK7lsj4i3b054wnrjxphhtiv8vn foreign key (accomodation_id) references Accomodation
alter table Planet add constraint FKqi98f2mgee2mlsp0tmivhfhc6 foreign key (planetPicture_id) references PlanetPicture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKbdbdkmt7xohd7jk57w4c2en8j foreign key (customer_id) references Customer
alter table RoomReservation add constraint FKlume3a5tlho5yq37p0ktt377c foreign key (room_id) references Room
SET statement_timeout = 0
SET lock_timeout = 0
SET client_encoding = 'UTF8'
SET standard_conforming_strings = on
SET check_function_bodies = false
SET client_min_messages = warning
SET row_security = off
SET search_path = public, pg_catalog
INSERT INTO planetPicture VALUES (1, 'Ugly insects', 'geonosis.jpg', 'Geonosis')
INSERT INTO planetPicture VALUES (2, 'The planet where maybe exists life', 'mars.jpg', 'Mars')
INSERT INTO planetPicture VALUES (3, 'The place of waving flag', 'moon.jpg', 'Moon')
INSERT INTO planetPicture VALUES (4, 'Giant planet with giant ring', 'saturn.jpg', 'Saturn')
INSERT INTO planetPicture VALUES (5, 'Desert Planet', 'tatooine.jpg', 'Tatooine')
INSERT INTO solarsystem VALUES (1, 'Milky Way')
INSERT INTO solarsystem VALUES (2, 'Star Wars')
INSERT INTO planet VALUES (1, 'The place where we live. Mars is the fourth planet from the Sun and the second-smallest planet in the Solar System after Mercury. Mars''s average distance from the Sun is roughly 230 million kilometres. Orbital period is 687 (Earth) days.', 'Mars', 'The winter is coming...Average temperature is about -60 C°, although it can vary from -125 C° near the poles during the winter to as much as a comfortable 20 C° at midday near the equator.', 3, 1)
INSERT INTO planet VALUES (2, 'Far far away from home. Saturn is the sixth planet from the Sun and the second-largest in the Solar System.The planet''s most famous feature is its prominent ring system that is composed mostly of ice particles, rocky debris and dust. ', 'Saturn', 'Pretty violent and stormy!', 4, 1)
INSERT INTO planet VALUES (3, 'In the neighbourhood.', 'Moon', 'Daytime temperatures on the sunny side of the moon reach 273 degrees F (134 C°); on the dark side it gets as cold as minus 243 F (minus 153 C°).', 2, 1)
INSERT INTO planet VALUES (4, 'Tatooine was a sparsely inhabited circumbinary desert planet located in the galaxy''s Outer Rim Territories. It would serve as the homeworld to the influential Anakin and Luke Skywalker, who would go on to shape galactic history.', 'Tatooine', 'Warm and dry', 5, 2)
INSERT INTO planet VALUES (5, 'Rocky and hard place. Situated in the Geonosis system of the Arkanis sector in the Outer Rim Territories, the planet of Geonosis was 43,000 light years from the Galactic Core, and less than a parsec away from the Outer Rim planet of Tatooine.', 'Geonosis', 'Dry', 1, 2)
INSERT INTO accomodation VALUES (1, 'Hotel with green plants. On every morning we offer you to taste fresh veggies. Enjoy the long walk in the first Martian greenhouse!', 'Mars base 1', 1)
INSERT INTO accomodation VALUES (2, 'ESA Hotel for backpackers. Since the dawn of the space age, Mars has been the target of orbiters, landers and rovers. And now for the backpackers! We offer a multicultural atmosphere, many cultural programs are available.', 'Welcome Hotel', 1)
INSERT INTO accomodation VALUES (3, 'Memorable and chip hotel in Venusville, a very special and bizarre district of a human town. Radiation protection is weak, but enjoyment is guaranteed. Mercenaries, freedom fighters and a lot of mutants.', 'The Last Resort in Venusville', 1)
INSERT INTO accomodation VALUES (4, 'Iron walls, deep jail cells in the middle of the desert. The boss has big ambition, and big body. Mercenaries, bounty hunters and other bizarre creatures. Only for the braves.', 'Jabba''s Palace', 4)
INSERT INTO accomodation VALUES (5, 'Nice music and a lot of guests from all part of the Universe', 'Mos Esley Cantina', 4)
INSERT INTO accomodationPicture VALUES (1, 'Iron walls in the desert.', 'jabba_palace.jpg', 'Jabba''s palace', 4)
INSERT INTO accomodationPicture VALUES (2, 'A twi''lek receptionist. He will salute you with these words: "Die wanna wanga"', 'jabba_bib_fortuna.jpg', 'Bib Fortuna', 4)
INSERT INTO accomodationPicture VALUES (3, 'Always tell him the truth. For your sake.', 'jabba_guard.jpg', 'Gamorrean security man', 4)
INSERT INTO accomodationPicture VALUES (4, 'She waits only for you, if you are a good boy. Or a bad girl.', 'jabba_dancer.jpg', 'Sensual maid', 4)
INSERT INTO accomodationPicture VALUES (5, 'Jabba''s best supplier.', 'jabba_boba_fett.jpg', 'Boba Fett', 4)
INSERT INTO accomodationPicture VALUES (6, 'Golden protocol droid.', 'jabba_3cpo.jpg', '3CPO', 4)
INSERT INTO accomodationPicture VALUES (7, 'The big, big boss.', 'jabba_face.jpg', 'Jabba the Hutt', 4)
INSERT INTO accomodationPicture VALUES (8, 'Very special bed.', 'jabba_han_place.jpg', 'Single Room', 4)
INSERT INTO accomodationPicture VALUES (9, 'Rancor Pit', 'jabba_rancor_pit.jpg', 'Family Room', 4)
INSERT INTO accomodationPicture VALUES (10, 'It''s not the Franz Liszt Chamber Orchestra...', 'jabba_band.jpg', 'The Band', 4)
INSERT INTO accomodationPicture VALUES (11, 'Safari in the desert.', 'jabba_desert.jpg', 'Excursion', 4)
INSERT INTO accomodationPicture VALUES (12, 'Dark cave.', 'jabba_sarlacc.jpg', 'Special offer', 4)
INSERT INTO accomodationPicture VALUES (13, 'Hotel with silo', 'marsbase1.jpg', 'Mars base 1', 1)
INSERT INTO accomodationPicture VALUES (14, 'ESA Hotel', 'marsbase2.jpg', 'Mars base 2', 2)
INSERT INTO accomodationPicture VALUES (15, 'Han Solo and Luke: The beginning of a beautiful friendship', 'mos_esley.jpg', 'mos_esley', 5)
INSERT INTO accomodationPicture VALUES (16, 'Total Recall', 'venusville4.jpg', 'Venusville', 3)
SELECT pg_catalog.setval('accomodation_id_seq', 5, true)
SELECT pg_catalog.setval('amenitytype_id_seq', 1, false)
INSERT INTO customer VALUES (1, 'Várkert bazár 1.', 'Budapest', 'Hungary', 'admin', 'admin', 'admin', 'admin', '1140')
INSERT INTO customer VALUES (2, 'Hősök tere 1.', 'Budapest', 'Hungary', 'berci@freemail.hu', 'Bertalan', 'Farkas', 'abcd1234', '1140')
SELECT pg_catalog.setval('customer_id_seq', 2, true)
SELECT pg_catalog.setval('hibernate_sequence', 5, true)
SELECT pg_catalog.setval('planetpicture_id_seq', 5, true)
SELECT pg_catalog.setval('accomodationpicture_id_seq', 16, true)
SELECT pg_catalog.setval('planet_id_seq', 5, true)
INSERT INTO roomtype VALUES (1, 1, 'Single Room')
INSERT INTO roomtype VALUES (2, 4, 'King''s Suite')
INSERT INTO roomtype VALUES (3, 10, 'Family Room')
INSERT INTO roomtype VALUES (4, 2, 'Honeymoon Suite')
INSERT INTO roomtype VALUES (5, 2, 'Double Room')
INSERT INTO room VALUES (1, 300, 1, 5)
INSERT INTO room VALUES (2, 600, 1, 2)
INSERT INTO room VALUES (3, 2500, 1, 3)
INSERT INTO room VALUES (4, 2500, 1, 3)
INSERT INTO room VALUES (5, 1000, 1, 4)
INSERT INTO room VALUES (6, 300, 4, 1)
INSERT INTO room VALUES (7, 1000, 4, 2)
INSERT INTO room VALUES (8, 600, 4, 5)
INSERT INTO room VALUES (9, 800, 4, 4)
INSERT INTO room VALUES (10, 200, 3, 1)
INSERT INTO room VALUES (11, 600, 3, 5)
INSERT INTO room VALUES (12, 800, 3, 4)
INSERT INTO room VALUES (13, 1000, 3, 2)
INSERT INTO room VALUES (14, 1000, 3, 2)
INSERT INTO room VALUES (15, 2000, 3, 3)
SELECT pg_catalog.setval('room_id_seq', 15, true)
INSERT INTO roomreservation VALUES (1, '2017-12-20', '2017-12-10', 2, 10)
INSERT INTO roomreservation VALUES (2, '2017-12-20', '2017-12-10', 2, 13)
SELECT pg_catalog.setval('roomreservation_id_seq', 2, true)
SELECT pg_catalog.setval('roomtype_id_seq', 5, true)
SELECT pg_catalog.setval('solarsystem_id_seq', 2, true)
create table Accomodation (id  bigserial not null, description varchar(255), name varchar(255), planet_id int8, primary key (id))
create table AccomodationPicture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), accomodation_id int8, primary key (id))
create table AmenityType (id  bigserial not null, name varchar(255), primary key (id))
create table Customer (id  bigserial not null, address varchar(255), city varchar(255), country varchar(255), email varchar(255) not null, firstName varchar(255), lastName varchar(255), password varchar(255), postalCode varchar(255), primary key (id))
create table Planet (id  bigserial not null, description varchar(255), name varchar(255), weather varchar(255), planetPicture_id int8, solarsystem_id int8, primary key (id))
create table PlanetPicture (id  bigserial not null, description varchar(255), fileName varchar(255), title varchar(255), primary key (id))
create table Room (id  bigserial not null, price float8 not null, accomodation_id int8, roomType_id int8, primary key (id))
create table RoomReservation (id  bigserial not null, endDate date, startDate date, customer_id int8, room_id int8, primary key (id))
create table RoomType (id  bigserial not null, bednumber int4 not null, name varchar(255), primary key (id))
create table SolarSystem (id  bigserial not null, name varchar(255), primary key (id))
alter table Customer add constraint UK_3qgg01qojcmbdp47dkaom9x45 unique (email)
alter table Accomodation add constraint FK2qd1f21p8hruef5re79ehs6nx foreign key (planet_id) references Planet
alter table AccomodationPicture add constraint FK7lsj4i3b054wnrjxphhtiv8vn foreign key (accomodation_id) references Accomodation
alter table Planet add constraint FKqi98f2mgee2mlsp0tmivhfhc6 foreign key (planetPicture_id) references PlanetPicture
alter table Planet add constraint FKifd6p3ffhkwf1prcro67a6jc1 foreign key (solarsystem_id) references SolarSystem
alter table Room add constraint FKh0mklnftju6tnxo37d7wmio96 foreign key (accomodation_id) references Accomodation
alter table Room add constraint FKklafyw0cu1h3eo2m7vl1f4ga1 foreign key (roomType_id) references RoomType
alter table RoomReservation add constraint FKbdbdkmt7xohd7jk57w4c2en8j foreign key (customer_id) references Customer
alter table RoomReservation add constraint FKlume3a5tlho5yq37p0ktt377c foreign key (room_id) references Room
SET statement_timeout = 0
SET lock_timeout = 0
SET client_encoding = 'UTF8'
SET standard_conforming_strings = on
SET check_function_bodies = false
SET client_min_messages = warning
SET row_security = off
SET search_path = public, pg_catalog
INSERT INTO planetPicture VALUES (1, 'Ugly insects', 'geonosis.jpg', 'Geonosis')
INSERT INTO planetPicture VALUES (2, 'The planet where maybe exists life', 'mars.jpg', 'Mars')
INSERT INTO planetPicture VALUES (3, 'The place of waving flag', 'moon.jpg', 'Moon')
INSERT INTO planetPicture VALUES (4, 'Giant planet with giant ring', 'saturn.jpg', 'Saturn')
INSERT INTO planetPicture VALUES (5, 'Desert Planet', 'tatooine.jpg', 'Tatooine')
INSERT INTO solarsystem VALUES (1, 'Milky Way')
INSERT INTO solarsystem VALUES (2, 'Star Wars')
INSERT INTO planet VALUES (1, 'The place where we live. Mars is the fourth planet from the Sun and the second-smallest planet in the Solar System after Mercury. Mars''s average distance from the Sun is roughly 230 million kilometres. Orbital period is 687 (Earth) days.', 'Mars', 'The winter is coming...Average temperature is about -60 C°, although it can vary from -125 C° near the poles during the winter to as much as a comfortable 20 C° at midday near the equator.', 3, 1)
INSERT INTO planet VALUES (2, 'Far far away from home. Saturn is the sixth planet from the Sun and the second-largest in the Solar System.The planet''s most famous feature is its prominent ring system that is composed mostly of ice particles, rocky debris and dust. ', 'Saturn', 'Pretty violent and stormy!', 4, 1)
INSERT INTO planet VALUES (3, 'In the neighbourhood.', 'Moon', 'Daytime temperatures on the sunny side of the moon reach 273 degrees F (134 C°); on the dark side it gets as cold as minus 243 F (minus 153 C°).', 2, 1)
INSERT INTO planet VALUES (4, 'Tatooine was a sparsely inhabited circumbinary desert planet located in the galaxy''s Outer Rim Territories. It would serve as the homeworld to the influential Anakin and Luke Skywalker, who would go on to shape galactic history.', 'Tatooine', 'Warm and dry', 5, 2)
INSERT INTO planet VALUES (5, 'Rocky and hard place. Situated in the Geonosis system of the Arkanis sector in the Outer Rim Territories, the planet of Geonosis was 43,000 light years from the Galactic Core, and less than a parsec away from the Outer Rim planet of Tatooine.', 'Geonosis', 'Dry', 1, 2)
INSERT INTO accomodation VALUES (1, 'Hotel with green plants. On every morning we offer you to taste fresh veggies. Enjoy the long walk in the first Martian greenhouse!', 'Mars base 1', 1)
INSERT INTO accomodation VALUES (2, 'ESA Hotel for backpackers. Since the dawn of the space age, Mars has been the target of orbiters, landers and rovers. And now for the backpackers! We offer a multicultural atmosphere, many cultural programs are available.', 'Welcome Hotel', 1)
INSERT INTO accomodation VALUES (3, 'Memorable and chip hotel in Venusville, a very special and bizarre district of a human town. Radiation protection is weak, but enjoyment is guaranteed. Mercenaries, freedom fighters and a lot of mutants.', 'The Last Resort in Venusville', 1)
INSERT INTO accomodation VALUES (4, 'Iron walls, deep jail cells in the middle of the desert. The boss has big ambition, and big body. Mercenaries, bounty hunters and other bizarre creatures. Only for the braves.', 'Jabba''s Palace', 4)
INSERT INTO accomodation VALUES (5, 'Nice music and a lot of guests from all part of the Universe', 'Mos Esley Cantina', 4)
INSERT INTO accomodationPicture VALUES (1, 'Iron walls in the desert.', 'jabba_palace.jpg', 'Jabba''s palace', 4)
INSERT INTO accomodationPicture VALUES (2, 'A twi''lek receptionist. He will salute you with these words: "Die wanna wanga"', 'jabba_bib_fortuna.jpg', 'Bib Fortuna', 4)
INSERT INTO accomodationPicture VALUES (3, 'Always tell him the truth. For your sake.', 'jabba_guard.jpg', 'Gamorrean security man', 4)
INSERT INTO accomodationPicture VALUES (4, 'She waits only for you, if you are a good boy. Or a bad girl.', 'jabba_dancer.jpg', 'Sensual maid', 4)
INSERT INTO accomodationPicture VALUES (5, 'Jabba''s best supplier.', 'jabba_boba_fett.jpg', 'Boba Fett', 4)
INSERT INTO accomodationPicture VALUES (6, 'Golden protocol droid.', 'jabba_3cpo.jpg', '3CPO', 4)
INSERT INTO accomodationPicture VALUES (7, 'The big, big boss.', 'jabba_face.jpg', 'Jabba the Hutt', 4)
INSERT INTO accomodationPicture VALUES (8, 'Very special bed.', 'jabba_han_place.jpg', 'Single Room', 4)
INSERT INTO accomodationPicture VALUES (9, 'Rancor Pit', 'jabba_rancor_pit.jpg', 'Family Room', 4)
INSERT INTO accomodationPicture VALUES (10, 'It''s not the Franz Liszt Chamber Orchestra...', 'jabba_band.jpg', 'The Band', 4)
INSERT INTO accomodationPicture VALUES (11, 'Safari in the desert.', 'jabba_desert.jpg', 'Excursion', 4)
INSERT INTO accomodationPicture VALUES (12, 'Dark cave.', 'jabba_sarlacc.jpg', 'Special offer', 4)
INSERT INTO accomodationPicture VALUES (13, 'Hotel with silo', 'marsbase1.jpg', 'Mars base 1', 1)
INSERT INTO accomodationPicture VALUES (14, 'ESA Hotel', 'marsbase2.jpg', 'Mars base 2', 2)
INSERT INTO accomodationPicture VALUES (15, 'Han Solo and Luke: The beginning of a beautiful friendship', 'mos_esley.jpg', 'mos_esley', 5)
INSERT INTO accomodationPicture VALUES (16, 'Total Recall', 'venusville4.jpg', 'Venusville', 3)
SELECT pg_catalog.setval('accomodation_id_seq', 5, true)
SELECT pg_catalog.setval('amenitytype_id_seq', 1, false)
INSERT INTO customer VALUES (1, 'Várkert bazár 1.', 'Budapest', 'Hungary', 'admin', 'admin', 'admin', 'admin', '1140')
INSERT INTO customer VALUES (2, 'Hősök tere 1.', 'Budapest', 'Hungary', 'berci@freemail.hu', 'Bertalan', 'Farkas', 'abcd1234', '1140')
SELECT pg_catalog.setval('customer_id_seq', 2, true)
SELECT pg_catalog.setval('hibernate_sequence', 5, true)
SELECT pg_catalog.setval('planetpicture_id_seq', 5, true)
SELECT pg_catalog.setval('accomodationpicture_id_seq', 16, true)
SELECT pg_catalog.setval('planet_id_seq', 5, true)
INSERT INTO roomtype VALUES (1, 1, 'Single Room')
INSERT INTO roomtype VALUES (2, 4, 'King''s Suite')
INSERT INTO roomtype VALUES (3, 10, 'Family Room')
INSERT INTO roomtype VALUES (4, 2, 'Honeymoon Suite')
INSERT INTO roomtype VALUES (5, 2, 'Double Room')
INSERT INTO room VALUES (1, 300, 1, 5)
INSERT INTO room VALUES (2, 600, 1, 2)
INSERT INTO room VALUES (3, 2500, 1, 3)
INSERT INTO room VALUES (4, 2500, 1, 3)
INSERT INTO room VALUES (5, 1000, 1, 4)
INSERT INTO room VALUES (6, 300, 4, 1)
INSERT INTO room VALUES (7, 1000, 4, 2)
INSERT INTO room VALUES (8, 600, 4, 5)
INSERT INTO room VALUES (9, 800, 4, 4)
INSERT INTO room VALUES (10, 200, 3, 1)
INSERT INTO room VALUES (11, 600, 3, 5)
INSERT INTO room VALUES (12, 800, 3, 4)
INSERT INTO room VALUES (13, 1000, 3, 2)
INSERT INTO room VALUES (14, 1000, 3, 2)
INSERT INTO room VALUES (15, 2000, 3, 3)
SELECT pg_catalog.setval('room_id_seq', 15, true)
INSERT INTO roomreservation VALUES (1, '2017-12-20', '2017-12-10', 2, 10)
INSERT INTO roomreservation VALUES (2, '2017-12-20', '2017-12-10', 2, 13)
SELECT pg_catalog.setval('roomreservation_id_seq', 2, true)
SELECT pg_catalog.setval('roomtype_id_seq', 5, true)
SELECT pg_catalog.setval('solarsystem_id_seq', 2, true)
