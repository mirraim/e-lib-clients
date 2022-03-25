create table if not exists client (
    id serial primary key,
    name varchar (225) not null,
    email varchar (225) unique not null
);

create table if not exists book (
    id serial primary key,
    general_book_id bigint,
    progress smallint,
    last_reading timestamp,
    client_id bigint
);

alter table book add foreign key (client_id) references client(id);
