create table Candidato(
	id serial not null,
	nome varchar(100) not null,
	numero integer,
	qtd_voto integer,

	constraint pk_candidato primary key(id)
);

create table Usuario(
	id serial not null,
	email varchar(150) unique , 
	token varchar(256) unique,
	status boolean,
	constraint pk_usuario primary key(id)
);

ALTER TABLE usuario ADD COLUMN token varchar;

insert into candidato(nome, numero) values ('Cassio Cunha Lima', 45);
insert into candidato(nome, numero) values ('Ricardo Coutinho', 40);
insert into candidato(nome, numero) values ('Vital do Rego', 15);
insert into candidato(nome, numero) values ('Major Fábio', 90);
insert into candidato(nome, numero) values ('Tárcio Holando', 50);
insert into candidato(nome, numero) values ('Antonio Radical', 16);

 select * from candidato

 select * from usuario

insert into usuario(email, token, status) values('mariaeliane@outlook.com', 'HFDNHD857584HDYGD', false);
insert into usuario(email, token, status) values('mariaelizani@outlook.com', 'DHDBSH867585NGJTUHG', TRUE);
 