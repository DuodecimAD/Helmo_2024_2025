CREATE TABLE BIEN(
	ID_BIEN 			NUMBER(10) PRIMARY KEY,
	RUE 				VARCHAR2(100) NOT NULL,
	NUMERO 				VARCHAR2(10) NOT NULL,
	LOCALITE 			VARCHAR2(50) NOT NULL,
	CODE_POSTAL 		NUMBER(4) NOT NULL,
	PROVINCE 			VARCHAR2(25) NOT NULL,
	DESCRIPTION 		VARCHAR2(1000) NOT NULL,
	SURFACE_HABITABLE 	NUMBER(4) NOT NULL,
	SURFACE_JARDIN 		NUMBER(5) NOT NULL,
	NB_PAV 				NUMBER(2) NOT NULL,
	NB_CHAC 			NUMBER(2) NOT NULL,
	NB_GARAGE 			NUMBER(2) NOT NULL,
	NB_FACADE 			NUMBER(1) NOT NULL,
	NB_SBD 				NUMBER(2),
	DATE_MISE_EN_VENTE 	DATE NOT NULL
);

CREATE TABLE CANDIDAT(
	ID_CANDIDAT NUMBER(10) PRIMARY KEY,
	NOM 		VARCHAR2(50) NOT NULL,
	PRENOM 		VARCHAR2(50) NOT NULL,
	RUE 		VARCHAR2(50) NOT NULL,
	NUMERO 		NUMBER(10,0) NOT NULL,
	LOCALITE 	VARCHAR2(50) NOT NULL,
	CODE_POSTAL NUMBER(10,0) NOT NULL,
	TELEPHONE 	VARCHAR2(25) NOT NULL,
	EMAIL 		VARCHAR2(50)
);

CREATE TABLE OFFRE(
	ID_OFFRE 	NUMBER(10) PRIMARY KEY,
	MONTANT 	NUMBER(10,2) NOT NULL,
	DATE_OFFRE 	DATE NOT NULL,
	STATUS 		CHAR(1) NOT NULL,
	ID_CANDIDAT NUMBER(10) NOT NULL,
	ID_BIEN 	NUMBER(10) NOT NULL,
	FOREIGN KEY (ID_CANDIDAT) REFERENCES CANDIDAT(ID_CANDIDAT),
	FOREIGN KEY (ID_BIEN) REFERENCES BIEN(ID_BIEN)
);

CREATE TABLE VENDEUR(
	ID_VENDEUR 	NUMBER(10) PRIMARY KEY,
	NOM 		VARCHAR2(50) NOT NULL,
	PRENOM 		VARCHAR2(25) NOT NULL,
	TELEPHONE 	VARCHAR2(25) NOT NULL,
	EMAIL 		VARCHAR2(50) NOT NULL
);

CREATE TABLE GERER(
	ID_BIEN 	NUMBER(10),
	ID_VENDEUR  NUMBER(10),
	PRIMARY KEY (ID_BIEN, ID_VENDEUR),
	FOREIGN KEY (ID_BIEN) REFERENCES BIEN(ID_BIEN),
	FOREIGN KEY (ID_VENDEUR) REFERENCES VENDEUR(ID_VENDEUR)
);
