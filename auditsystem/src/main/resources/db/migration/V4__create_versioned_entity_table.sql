create table versionedentities(
                        id bigint generated always as identity primary key,
                        entity_name varchar(100) not null,
                        entity_id bigint not null,
                        data_snapshot jsonb not null,
                        created_at timestamp with time zone not null default current_timestamp,
                        user_id bigint not null,
                        constraint fk_versionedentity_user foreign key (user_id) references users(id) on delete restrict);
