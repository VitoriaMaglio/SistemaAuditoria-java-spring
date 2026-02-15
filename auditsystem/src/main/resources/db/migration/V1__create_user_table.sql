create table users(
                    id bigint generated always as identity primary key,
                    name varchar(150) not null,
                    email varchar(100) not null unique,
                    created_at timestamp with time zone not null default current_timestamp);
