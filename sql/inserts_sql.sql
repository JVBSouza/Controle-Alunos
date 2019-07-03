CREATE database pi_controle;

USE pi_controle;

create table responsaveis (
	cod_resp int not null auto_increment,
	nome varchar(100), 
cpf varchar(20), 
rg varchar(20), 
telefone varchar(20),
datanasc date,
endereco varchar(100),
parentesco varchar(10),
primary key (cod_resp)
) Engine = InnoDB;

INSERT into responsaveis (nome, cpf, rg, telefone, datanasc, endereco, parentesco) VALUES 
("Luiz Alexandre","094.123.234-54", "5.123.123","(48)99888-7766", "1980-12-28", "Rua das Tainhas 20", "Pai"),
("Leonardo Abreu","090.123.345-25", "8.321.123","(48) 88998-8877", "1950-02-20", "Rua do Capitão 40", "Avô"),
("José Leonardo","182.324.123-24", "5.588.055","(47)99908-0098", "1991-05-31", "Rua do Limoeiro 90", "Mãe"),
("Igor Menezes ","400.324.123-20", "5.123.415","(47)88412-0898", "1995-06-20", "Rua do Pinheiro 05", "Mãe"),
("Rafael Nilton","602.999.123-21", "6.800.200","(47)99908-7798", "1985-01-30", "Rua das Laranjas 10", "Mãe"),
("Paulo Antonio","182.589.200-52", "6.123.415","(47)99908-0088", "1973-11-10", "Rua das Árvores 20", "Mãe"),
("Marina Monique","985.333.123-66", "4.700.200","(47)99908-5554", "1986-10-20", "Rua das Alamedas 30", "Pai"),
("Marta Paula ","888.324.555-22", "4.123.415","(47)99908-2054", "1979-09-20", "Rua do Itacorubi 40", "Mãe"),
("Luiza Sousa","222.800.80-24", "4.200.415","(47)99908-9087", "1977-07-20", "Rua da Santa Paula11", "Pai"),
("Fernanda Paula","223.555.123-90", "4.100.000", "(47)99908-2020", "1989-05-21", "Avenida I de Maio 99", "Pai");


create table alunos (
matricula int not null, 
nome varchar(100), 
cpf varchar(20), 
rg varchar(20), 
telefone varchar(20),
datanasc date,
endereco varchar(100),
responsavel_1 int,
responsavel_2 int,
primary key (matricula),
constraint fk_resp1 foreign key (responsavel_1) references responsaveis (cod_resp),
constraint fk_resp2 foreign key (responsavel_2) references responsaveis (cod_resp)
) Engine = InnoDB;

INSERT into alunos (matricula, nome, cpf, rg, telefone, datanasc, endereco, responsavel_1, responsavel_2) VALUES
(20190101, "Ana Maria", "090.932.13-32", "5.321.123", "(48)99992-1122", "2000-01-01","Rua das Tainhas 20", 1, 2),
(20190102, "Carlos Caio","099.213.321-51", "9.321.512","(48)89963-1235", "1999-05-22", "Rua do Capitão 40", 3, 3),
(20190103, "Miguel Silvio","085.213.321-51", "8.555.512","(48)79230-4040", "1999-05-22", "Rua do Limoeiro 90", 4, 4),
(20190104, "Marina Silva","780.566.065-51", "7.321.512","(48)59230-3030", "1999-05-22", "Rua do Pinheiro 05", 4, 4),
(20190105, "Livia Correia","050.213.321-69", "5.321.512","(48)98852-1235", "1999-05-22", "Rua das Laranjas 10", 5, 5),
(20190201, "Tiago João","099.213.321-63", "2.222.512","(48)99230-2033", "1999-05-22", "Rua das Árvores 20", 6, 6),
(20190202, "Daniela Braz","099.066.321-22", "9.222.512","(48)99280-1235", "200-05-22", "Rua da Laranjeira", 7, 7),
(20190203, "Martha Ana","801.111.321-11", "9.302.500","(48)99250-1235", "1999-05-22", "Rua das Alamedas 30", 8, 8),
(20190204, "José Marlon","099.213.321-51", "9.321.444","(48)79230-1235", "1999-06-22", "Rua do Limoeiro 150", 9, 9),
(20190205, "Yuri Pauuulo","099.300.321-40", "6.321.512","(48)99550-2020", "1999-05-22", "Avenida I de Maio 99", 10,10);



create table usuarios (
	cod_user int auto_increment not null,
	nome varchar(100),
	cpf varchar(20),
	rg varchar(20),
	datanasc date,
	endereco varchar(100),
	telefone varchar(20),
	turno varchar(15),
	setor varchar(15),
	senha varchar(10),
	primary key (cod_user)
) Engine = InnoDB;

INSERT INTO usuarios (nome, cpf, rg, datanasc, endereco, telefone, turno, setor, senha) VALUES 
("Thiago Asp", "909.134.451-12", "3.123.123", "1990-12-23", "Rua Florianópolis", "(48)98765-4321","Matutino","Operador", "senha"),
("Ana Cravo", "201.788.666-52", "2.512.231", "1975-10-02", "Rua das Amendoeiras", "(48)12345-6789","Vespertino","Secretaria","abc123"),
("Admin", "089.500.512-52", "3.566.288", "1975-10-09", "Rua das Acácias", "(48)33345-6789", "Vespertino", "Administrador", "admin");


create table autorizacao (
	cod_autoriza int not null auto_increment,
	matricula int,
	cod_resp int,
	cod_user int,
	data datetime,
	descr varchar(250),
	ativo boolean,
	descr_cancel varchar(250),
	primary key (cod_autoriza),
	constraint fk_matricula foreign key (matricula) references alunos(matricula),
	constraint fk_resp foreign key (cod_resp) references responsaveis (cod_resp),
	constraint fk_user foreign key (cod_user) references usuarios (cod_user)
) Engine = InnoDB;

INSERT into autorizacao (matricula, cod_resp, cod_user, data, descr, ativo, descr_cancel) VALUES
(20190101, 1, 2, "2019-06-15 10:30:00", "Médico", true, null),
(20190102, 3, 1, "2019-06-20 09:00:00", "Dentista", false, "Consulta adiada"),
(20190103, 3, 1, "2019-06-22 09:00:00", "Dentista", true, null),
(20190104, 4, 1, "2019-05-31 10:00:00", "Atrasada", true, null),
(20190105, 8, 2, "2019-06-10 11:00:00", "Pedido especial da mãe", true, null),
(20190106, 10, 2, "2019-06-12 10:45:00", "Viagem", true, null);


create table registros (
	cod_registro int auto_increment not null,
	cod_autoriza int,
cod_user int,
	matricula int,
	hora datetime,
	tipo varchar(20),
	primary key (cod_registro),
	constraint fk_autoriza foreign key (cod_autoriza) references autorizacao (cod_autoriza),
	constraint fk_user_reg foreign key (cod_user) references usuarios (cod_user),
	constraint fk_matricula_reg foreign key (matricula) references alunos (matricula)
) Engine = InnoDB;

INSERT into registros (cod_autoriza,cod_user, matricula, hora, tipo) VALUES 
(1,1, 20190101, "2019-06-15 09:25:00", "Entrada"),
(null, 1, 20190101, "2019-06-25 12:05:12", "Saída"),
(5, 1, 20190102, "2019-06-10 09:00:00", "Entrada"),
(null, 1, 20190102, "2019-06-12 11:48:00", "Saída"),
(null, 1, 20190103, "2019-06-15 7:30:00", "Entrada"),
(null, 1, 20190103, "2019-06-16 11:30:00", "Saída"),
(null, 1, 20190104, "2019-06-16 7:30:00", "Entrada"),
(null, 1, 20190104, "2019-06-16 11:30:00", "Saída"),
(null, 1, 20190105, "2019-06-16 8:30:00", "Entrada"),
(null, 1, 20190105, "2019-06-17 11:30:00", "Saída"),
(null, 1, 20190106, "2019-06-17 7:30:00", "Entrada"),
(null, 1, 20190106, "2019-06-17 11:30:00", "Saída"),
(null, 1, 20190107, "2019-06-17 7:40:00", "Entrada"),
(null, 1, 20190107, "2019-06-18 11:40:00", "Saída"),
(3, 1, 20190108, "2019-06-18 10:30:00", "Entrada"),
(null, 1, 20190108, "2019-06-19 12:30:00", "Saída");
