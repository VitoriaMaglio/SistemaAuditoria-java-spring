create table transactions(
                           id bigint generated always as identity primary key,
                           description varchar(250) not null,
                           amount numeric(10,2) not null,
                           created_at timestamp with time zone not null default current_timestamp,
                           user_id bigint not null,
                           constraint fk_transaction_user
                           foreign key (user_id)
                           references users(id) ON DELETE RESTRICT);