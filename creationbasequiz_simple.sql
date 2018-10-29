DROP DATABASE IF EXISTS QUIZ2;

-- création de la base avec le charset utf8
CREATE DATABASE QUIZ2 CHARACTER SET utf8 COLLATE utf8_general_ci;
USE QUIZ2;

CREATE TABLE theme (
    idTheme INT(6) auto_increment UNIQUE NOT NULL,
	nomTheme VARCHAR(64)  NOT NULL,
    constraint PK_theme PRIMARY KEY (idTheme)
);

CREATE TABLE module (
    idModule INT(6) AUTO_INCREMENT UNIQUE NOT NULL,
    nomModule VARCHAR(64) NOT NULL,
    idTheme INT(6) NOT NULL,
    CONSTRAINT PK_module PRIMARY KEY (idModule),
    CONSTRAINT FK_module__theme FOREIGN KEY (idTheme) REFERENCES theme (idTheme)
);


CREATE TABLE formateur (
    idFormateur INT(6) auto_increment UNIQUE NOT NULL,
	nomFormateur VARCHAR(32)  NOT NULL,
	prenomFormateur VARCHAR(32)  NOT NULL,
	mailFormateur VARCHAR(32)  NOT NULL,
    mdpFormateur VARCHAR(128)  NOT NULL,
    constraint PK_test PRIMARY KEY (idFormateur)
);

CREATE TABLE test (
    idTest INT(6) auto_increment UNIQUE NOT NULL,
	nomTest VARCHAR(64)  NOT NULL,
    testPublie tinyint(1)  NOT NULL,
    idModule INT(6)  NOT NULL,
    idFormateur INT(6)  NOT NULL,
    quizAleatoire tinyint(1) NOT NULL,
    constraint PK_test PRIMARY KEY (idTest),
    constraint FK_test__module foreign key (idModule) references module(idModule),
    constraint FK_test__formateur foreign key (idFormateur) references formateur(idFormateur)
);

CREATE TABLE stagiaire (
    idStagiaire INT(6) NOT NULL,
	mailStagiaire VARCHAR(32)  NOT NULL,
    mdpStagiaire VARCHAR(128)  NOT NULL,
    constraint PK_stagiaire PRIMARY KEY (idStagiaire)
);

CREATE TABLE passer (
    idStagiaire INT(6) auto_increment UNIQUE NOT NULL,
	idTest INT(6)  NOT NULL,
    note INT(2)  NOT NULL,
    constraint PK_passer PRIMARY KEY (idStagiaire,idTest),
    constraint FK_passe__stagiaire foreign key (idStagiaire) references stagiaire(idStagiaire),
    constraint FK_passe__test foreign key (idTest) references test(idTest)
);

CREATE TABLE question (
    idQuestion INT(6) auto_increment UNIQUE NOT NULL,
	intituleQuestion TEXT NOT NULL,
	idTest int(6)  NOT NULL,
	secondesPourRepondre INT(6)  NOT NULL,
    constraint PK_question PRIMARY KEY (idQuestion),
	constraint FK_question__test foreign key (idTest) references test(idTest)

);

CREATE TABLE proposition (
    idProposition INT(6) auto_increment UNIQUE NOT NULL,
	texteProposition TEXT NOT NULL,
	idQuestion int(6)  NOT NULL,
	propositionJuste tinyint(1)  NOT NULL,
    constraint PK_proposition PRIMARY KEY (idProposition),
    constraint FK_proposition__question foreign key (idQuestion) references question(idQuestion)
);



CREATE TABLE donner (
    idStagiaire INT(6) NOT NULL,
    idProposition INT(6)  NOT NULL,
    secondesPourRepondre INT(6)  NOT NULL,
    reponseTextuelle TEXT NOT NULL,
    constraint PK_donner PRIMARY KEY (idStagiaire,idProposition),
    constraint FK_donner__stagiaire foreign key (idStagiaire) references stagiaire(idStagiaire),
    constraint FK_donner__proposition foreign key (idProposition) references proposition(idProposition)
);


CREATE TABLE admin (
    idAdmin INT(6) auto_increment UNIQUE NOT NULL,
    nomAdmin VARCHAR(20)  NOT NULL,
    prenomAdmin VARCHAR(20) NOT NULL,
    mailAdmin VARCHAR(32)  NOT NULL,
    mdpAdmin VARCHAR(255)  NOT NULL,
    constraint PK_admin PRIMARY KEY (idAdmin)
);


