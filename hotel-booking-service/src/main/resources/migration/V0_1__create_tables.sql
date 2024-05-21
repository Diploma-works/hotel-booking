create table if not exists hotel (
    id int primary key,
    manager_id int,
    name varchar(50),
    address varchar(100),
    description text
);

create table if not exists room (
    id int generated always as identity(start with 100 increment by 100) primary key,
    hotel_id int references hotel(id),
    number int,
    num_of_beds int
);

create table if not exists room_booking (
    id int generated always as identity(start with 100 increment by 100) primary key,
    room_id int references room(id),
    from_date timestamp,
    till_date timestamp
);