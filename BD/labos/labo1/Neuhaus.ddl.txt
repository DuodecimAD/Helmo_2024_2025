drop table Alerter;
drop table Message;
drop table Offre;
drop table Gerer;
drop table Historique_prix;
drop table Bien;
drop table Client;
drop table Candidat;
drop table Categorie_situation;
drop table Categorie_etat;
drop table Categorie_cuisine;
drop table Categorie_bien;
drop table Vendeur;

create table Vendeur (
     id_vendeur numeric(10) not null,
     pseudo varchar2(10) not null,
     mdp char(32) not null,
     nom varchar2(100) not null,
     prenom varchar2(100) not null,
     telephone varchar2(25) not null,
     email varchar2(100) not null,
     constraint PK_Vendeur primary key (id_vendeur)
	 );	 
	 
create table Candidat (
     id_candidat numeric(10) not null,
     nom varchar2(100) not null,
     prenom varchar2(100) not null,
     rue varchar2(100) not null,
     numero varchar2(10) not null,
     localite varchar2(50) not null,
     code_postal numeric(4) not null,
     telephone varchar2(25) not null,
     email varchar2(100),
     constraint PK_Candidat primary key (id_candidat)
	 );

create table Client (
     id_client numeric(10) not null,
     nom varchar2(100) not null,
     prenom varchar2(100) not null,
     rue varchar2(100) not null,
     numero varchar2(10) not null,
     localite varchar2(50) not null,
     code_postal numeric(4) not null,
     telephone varchar2(25) not null,
     email varchar2(100) not null,
     constraint PK_Client primary key (id_client)
	 );	 
	 
create table Categorie_bien (
     id_catbien numeric(10) not null,
     description varchar2(50) not null,
     code char(1) not null,
     constraint PK_Categorie_bien primary key (id_catbien)
	 );

create table Categorie_cuisine (
     id_catcuisine numeric(10) not null,
     description varchar2(50) not null,
     code char(1) not null,
     constraint PK_Categorie_cuisine primary key (id_catcuisine)
	 );

create table Categorie_etat (
     id_catetat numeric(10) not null,
     description varchar2(50) not null,
     code char(1) not null,
     constraint PK_Categorie_etat primary key (id_catetat)
	 );

create table Categorie_situation (
     id_catsituation numeric(10) not null,
     description varchar2(50) not null,
     code char(1) not null,
     constraint PK_Categorie_situation primary key (id_catsituation)
	 );
	 
create table Message (
     id_message numeric(10) not null,
     texte varchar2(250) not null,
     date_message date not null,
     constraint PK_Message primary key (id_message)
	 );	 

create table Bien (
     id_bien numeric(10) not null,
     rue varchar2(100) not null,
     numero varchar2(10) not null,
     localite varchar2(50) not null,
     code_postal numeric(4) not null,
     description varchar2(1000) not null,
     surface_habitable numeric(4) not null,
     surface_jardin numeric(5) not null,
     nb_pav numeric(2) not null,
     nb_chac numeric(2) not null,
     nb_garage numeric(2) not null,
     nb_facade numeric(1) not null,
     nb_sdb numeric(2) not null,
     date_mise_en_vente date not null,
     id_client numeric(10) not null,
     id_catsituation numeric(10) not null,
     id_catetat numeric(10) not null,
     id_catcuisine numeric(10) not null,
     id_catbien numeric(10) not null,
     constraint PK_Bien primary key (id_bien),
	 foreign key(id_client) references Client(id_client),
	 foreign key(id_catsituation) references Categorie_situation(id_catsituation),
	 foreign key(id_catetat) references Categorie_etat(id_catetat),
	 foreign key(id_catcuisine) references Categorie_cuisine(id_catcuisine),
	 foreign key(id_catbien) references Categorie_bien(id_catbien) 
	 );
	 
create table Gerer (
     id_bien numeric(10) not null,
     id_vendeur numeric(10) not null,
     constraint PK_Gerer primary key (id_vendeur, id_bien),
	 foreign key(id_bien) references Bien(id_bien),
	 foreign key(id_vendeur) references Vendeur(id_vendeur)	 
	 );

create table Historique_prix (
     id_prix varchar2(10) not null,
     montant numeric(10,2) not null,
     date_prix date not null,
     id_bien numeric(10) not null,
     constraint PK_Historique_prix primary key (id_prix),
	 foreign key(id_bien) references Bien(id_bien)	 
	 );

create table Offre (
     id_offre numeric(10) not null,
     montant numeric(10,2) not null,
     date_offre date not null,
     statut char(1) not null,
     id_candidat numeric(10) not null,
     id_bien numeric(10) not null,
     constraint PK_Offre primary key (id_offre),
	 foreign key(id_candidat) references Candidat(id_candidat),
	 foreign key(id_bien) references Bien(id_bien)	 
	 );
	 
create table Alerter (
     id_message numeric(10) not null,
     id_vendeur numeric(10) not null,
	 statut char(1) not null,
     constraint PK_Alerter primary key (id_message, id_vendeur)
	 );

COMMIT;





