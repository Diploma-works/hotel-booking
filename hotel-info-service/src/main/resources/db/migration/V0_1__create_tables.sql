create table if not exists hotel (
    id int generated always as identity(start with 100 increment by 100) primary key,
    manager_id int
);

create table if not exists room (
    id int generated always as identity(start with 100 increment by 100) primary key,
    hotel_id int,
    reason text,
    from_date timestamp,
    till_date timestamp
);
