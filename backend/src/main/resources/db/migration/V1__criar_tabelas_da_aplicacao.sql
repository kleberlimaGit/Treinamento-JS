create table financa (id bigint not null auto_increment, total double precision not null, primary key (id)) engine=InnoDB;
create table transacoes (id bigint not null auto_increment, data date, descricao varchar(255), valor_transacao double precision not null, financa_id bigint, primary key (id)) engine=InnoDB;
alter table transacoes add constraint FK2ax24id1c1sk29qve5385u5at foreign key (financa_id) references financa (id);


insert into financa (total)  values (0.0)