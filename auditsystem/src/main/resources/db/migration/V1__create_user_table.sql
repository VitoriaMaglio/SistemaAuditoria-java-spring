create table users(
                    id bigint generated always as identity primary key,
                    name varchar(150) not null,
                    email varchar(100) not null unique,
                    created_at timestamp with time zone not null default current_timestamp);
--- id identificar único gerado pelo banco
--- created_at precisão temporal com UTC, default current_timestamp é que se nenhum valor ofr preenchido nessa coluna, o banco preenche com a data e hora atual.