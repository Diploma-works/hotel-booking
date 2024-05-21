create table if not exists hotel (
    id int primary key,
    manager_id int,
);

create table if not exists hotel_grade (
    id int generated always as identity(start with 100 increment by 100) primary key,
    hotel_id int references hotel(id),
    grade int
);