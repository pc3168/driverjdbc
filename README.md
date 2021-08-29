# Criando Banco de dados e realizando CRUD com Java utilizando JDBC.
Conectando com banco de dados


# Criando banco e tabela com postgres
```Sql
create database curso;

create sequence curso_id_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 123456789
START 1
CACHE 1;

--drop table cursos;
create table cursos (
       id integer not null default nextval('curso_id_seq'),
       nome varchar(50) not null, 
       duracao_horas time not null,
       primary key(id)
);


insert into cursos(nome, duracao_horas) values ('java','20:00:00');
insert into cursos(nome, duracao_horas) values ('c#','22:00:00');
insert into cursos(nome, duracao_horas) values ('Linux','8:00:00');
insert into cursos(nome, duracao_horas) values ('python','15:00:00');
insert into cursos(nome, duracao_horas) values ('C++','15:00:00');

select * from cursos;
```

# criando banco e tabela com mysql 
```Sql
create database curso;

create table cursos (
       id integer not null AUTO_INCREMENT,
       nome varchar(50) not null, 
       duracao_horas time not null,
       primary key(id)
);

insert into cursos(nome, duracao_horas) values ('java','20:00:00');
insert into cursos(nome, duracao_horas) values ('c#','22:00:00');
insert into cursos(nome, duracao_horas) values ('Linux','8:00:00');
insert into cursos(nome, duracao_horas) values ('python','15:00:00');
insert into cursos(nome, duracao_horas) values ('C++','15:00:00');

select * from cursos;
```