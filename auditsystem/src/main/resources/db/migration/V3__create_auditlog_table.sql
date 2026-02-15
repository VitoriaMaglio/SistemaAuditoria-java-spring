create table auditlogs(
                        id bigint generated always as identity primary key,
                        action varchar(50) not null,
                        entity_name varchar(100) not null,
                        entity_id bigint not null,
                        old_value text,
                        new_value text,
                        created_at timestamp with time zone not null default current_timestamp,
                        user_id bigint not null,
                        constraint fk_auditlog_user foreign key (user_id) references users(id));
