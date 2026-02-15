create table transactions(
                           id bigint generated always as identity primary key,
                           description varchar(250) not null,
                           amount numeric(10,2) not null,
                           created_at timestamp with time zone not null default current_timestamp,
                           user_id bigint not null,
                           constraint fk_transaction_user
                           foreign key (user_id)
                           references users(id) ON DELETE RESTRICT);
--- created_at precisão temporal com UTC, default current_timestamp é que se nenhum valor for preenchido nessa coluna, o banco preenche com a data e hora atual.
--- user_id relacionamento fk : declara a regra e nomeia a colunafk, declara a coluna com a fk, referencia a coluna e sua pk e define que nenhum usuário pode ser apagado se tiver transações associadas.