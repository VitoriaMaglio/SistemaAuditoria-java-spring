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

--- Atributos -> id identificador único gerado pelo banco
--- entity_name nome da entidade que sofreu uma ação
--- text registra o estado dos dados sem limite prático, pois pode alterar um campo ou cinco campos
--- created_at precisão do tempo em UTC
--- user_id indica quem fez a ação
--- fk primeiro declara a coluna, o tipo e not null, aplica a regra e nomeia a colunafk, indica a coluna da outra tabela do relacionamento, e faz referência para a outra tabela e sua pk.