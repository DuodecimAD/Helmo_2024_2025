-- SUPPRESSION DES TABLES DU SCHEMA RESERVATION SPECTACLE
DROP TABLE RESERVATION;
DROP TABLE CLIENT;
DROP TABLE CATEGORIEPLACE;
DROP TABLE REPRESENTATION;
DROP TABLE SALLE;
DROP TABLE PARTICIPANTSPECTACLE;
DROP TABLE ROLE;
DROP TABLE SPECTACLE;
DROP TABLE GENRE;
DROP TABLE PARTICIPANT;

CREATE TABLE ROLE (
    idRole    		INTEGER NOT NULL PRIMARY KEY,
	description		VARCHAR2(50)
);

CREATE TABLE GENRE (
    idGenre    		INTEGER NOT NULL PRIMARY KEY,
    description		VARCHAR2(50)
);

CREATE TABLE PARTICIPANT (
    idParticipant   INTEGER NOT NULL PRIMARY KEY,
    nom         	VARCHAR2(50) NOT NULL,
    prenom      	VARCHAR2(50) NOT NULL,
    dateNaissance 	DATE
);

CREATE TABLE SALLE (
    idSalle		    INTEGER NOT NULL PRIMARY KEY,
    nom         	VARCHAR2(50) NOT NULL,
    capacite     	INTEGER NOT NULL,
    accesPMR		CHAR(1) NOT NULL
);

CREATE TABLE CLIENT (
    idClient   		INTEGER NOT NULL PRIMARY KEY,
    nom         	VARCHAR2(50) NOT NULL,
    prenom      	VARCHAR2(50) NOT NULL,
    rue	    	  	VARCHAR2(50) NOT NULL,
    numero      	VARCHAR2(5) NOT NULL,
    codePostal     	VARCHAR2(20) NOT NULL,
    localite     	VARCHAR2(50) NOT NULL,
    pays    	 	VARCHAR2(50) NOT NULL,
    email     		VARCHAR2(50) ,
    telephone  		VARCHAR2(50)
);

CREATE TABLE SPECTACLE (
    idSpectacle	    	INTEGER NOT NULL PRIMARY KEY,
    nom         		VARCHAR2(100) NOT NULL,
    descriptionCourte   VARCHAR2(250) NOT NULL,
    descriptionLongue  	VARCHAR2(2000) NOT NULL,
    duree 		     	INTEGER,
    statut     			CHAR(1) NOT NULL,
    ageMinimum     		INTEGER,
    idGenre				INTEGER REFERENCES GENRE(idGenre)
);

CREATE TABLE PARTICIPANTSPECTACLE (
	idParticipant	INTEGER NOT NULL REFERENCES PARTICIPANT(idParticipant),
	idSpectacle		INTEGER NOT NULL REFERENCES SPECTACLE(idSpectacle),
        idRole 			INTEGER NOT NULL REFERENCES ROLE(idRole),
	CONSTRAINT PK_PARTSPEC PRIMARY KEY(idParticipant, idSpectacle)
);

CREATE TABLE CATEGORIEPLACE (
	idCategorie		INTEGER NOT NULL PRIMARY KEY,
	description		VARCHAR2(50) NOT NULL,
	nbSiege			INTEGER NOT NULL,
        idSalle			INTEGER NOT NULL REFERENCES SALLE(idSalle)
);

CREATE TABLE REPRESENTATION (
	idRepresentation	 INTEGER NOT NULL PRIMARY KEY,
	dateRepresentation	 DATE NOT NULL,
	idSpectacle			 INTEGER REFERENCES SPECTACLE(idSpectacle) NOT NULL,
	idSalle				 INTEGER REFERENCES SALLE(idSalle) NOT NULL
);

CREATE TABLE RESERVATION(
	idReservation	 INTEGER NOT NULL PRIMARY KEY,
	dateReservation	 DATE NOT NULL,
	idClient		 INTEGER REFERENCES CLIENT(idClient) NOT NULL,
	idCategorie		 INTEGER REFERENCES CATEGORIEPLACE(idCategorie) NOT NULL,
	idRepresentation 	 INTEGER REFERENCES REPRESENTATION(idRepresentation) NOT NULL,
	nbPlaces		 INTEGER NOT NULL
);














INSERT INTO ROLE VALUES (1, 'Interprète');
INSERT INTO ROLE VALUES (2, 'Direction artisitique');
INSERT INTO ROLE VALUES (3, 'Régie générale');
INSERT INTO ROLE VALUES (4, 'Régie lumière');
INSERT INTO ROLE VALUES (5, 'Production');
INSERT INTO ROLE VALUES (6, 'Scénariste');
INSERT INTO ROLE VALUES (7, 'Musicien');
INSERT INTO ROLE VALUES (8, 'Acteur');
INSERT INTO ROLE VALUES (9, 'Merchandising');
INSERT INTO ROLE VALUES (10, 'Assistant');

INSERT INTO GENRE VALUES (1, 'Théâtre');
INSERT INTO GENRE VALUES (2, 'Danse');
INSERT INTO GENRE VALUES (3, 'Conférence');
INSERT INTO GENRE VALUES (4, 'Jeune public');
INSERT INTO GENRE VALUES (5, 'Lecture');
INSERT INTO GENRE VALUES (6, 'Musique');
INSERT INTO GENRE VALUES (7, 'Art de la rue');
INSERT INTO GENRE VALUES (8, 'Performance immersive');

INSERT INTO PARTICIPANT VALUES (1, 'Zimmer', 'Johann', TO_DATE('24/02/1969','dd/mm/yyyy'));
INSERT INTO PARTICIPANT VALUES (2, 'Boldon', 'Jules', TO_DATE('15/05/1978','dd/mm/yyyy'));
INSERT INTO PARTICIPANT VALUES (3, 'Glock', 'Johnny', TO_DATE('24/05/1971','dd/mm/yyyy'));
INSERT INTO PARTICIPANT VALUES (4, 'Gillon', 'Nathalie', TO_DATE('16/06/1983','dd/mm/yyyy'));
INSERT INTO PARTICIPANT VALUES (5, 'Freien', 'Simon', TO_DATE('17/07/1984','dd/mm/yyyy'));
INSERT INTO PARTICIPANT VALUES (6, 'Barto', 'Paul', TO_DATE('02/02/1965','dd/mm/yyyy'));
INSERT INTO PARTICIPANT VALUES (7, 'Kolpin', 'Marco', TO_DATE('11/01/1979','dd/mm/yyyy'));
INSERT INTO PARTICIPANT VALUES (8, 'Prezo', 'Jeanne', TO_DATE('04/10/1980','dd/mm/yyyy'));
INSERT INTO PARTICIPANT VALUES (9, 'Stillenwald', 'Jurgen', TO_DATE('24/02/1981','dd/mm/yyyy'));
INSERT INTO PARTICIPANT VALUES (10, 'Johnson', 'John', TO_DATE('12/03/1974','dd/mm/yyyy'));
INSERT INTO PARTICIPANT VALUES (11, 'Distuk', 'Bilo', TO_DATE('23/05/1972','dd/mm/yyyy'));
INSERT INTO PARTICIPANT VALUES (12, 'Vartan', 'Géraldine', TO_DATE('20/04/1965','dd/mm/yyyy'));
INSERT INTO PARTICIPANT VALUES (13, 'Klifo', 'Noémie', TO_DATE('20/04/1965','dd/mm/yyyy'));
INSERT INTO PARTICIPANT VALUES (14, 'Bernid', 'Paul', TO_DATE('20/04/1965','dd/mm/yyyy'));
INSERT INTO PARTICIPANT VALUES (15, 'Polut', 'Jeanne', TO_DATE('20/04/1965','dd/mm/yyyy'));
INSERT INTO PARTICIPANT VALUES (16, 'Paltor', 'Stéphanie', TO_DATE('20/04/1965','dd/mm/yyyy'));
INSERT INTO PARTICIPANT VALUES (17, 'Manset', 'Gérard', TO_DATE('20/04/1965','dd/mm/yyyy'));

INSERT INTO SALLE VALUES (1, 'Grande Main', 650, 'Y');
INSERT INTO SALLE VALUES (2, 'Oeil Vert', 150, 'N');
INSERT INTO SALLE VALUES (3, 'Café des Arts', 60, 'Y');
INSERT INTO SALLE VALUES (4, 'Opéra Royal', 460, 'Y');
INSERT INTO SALLE VALUES (5, 'Reflektor', 240, 'Y');
INSERT INTO SALLE VALUES (6, 'Le Hangar', 120, 'Y');
INSERT INTO SALLE VALUES (7, 'La Zone', 80, 'N');
INSERT INTO SALLE VALUES (8, 'Le Trocadéro', 120, 'Y');
INSERT INTO SALLE VALUES (9, 'Le Manège Fonck', 220, 'Y');


INSERT INTO CATEGORIEPLACE VALUES (1, 'Parterre 1', 100, 1);
INSERT INTO CATEGORIEPLACE VALUES (2, 'Parterre 2', 250, 1);
INSERT INTO CATEGORIEPLACE VALUES (3, 'Balcon', 150, 1);
INSERT INTO CATEGORIEPLACE VALUES (4, 'Paradis', 100, 1);
INSERT INTO CATEGORIEPLACE VALUES (5, 'Loges', 50, 1);
INSERT INTO CATEGORIEPLACE VALUES (6, 'Parterre', 100, 2);
INSERT INTO CATEGORIEPLACE VALUES (7, 'Pourtours', 50, 2);
INSERT INTO CATEGORIEPLACE VALUES (8, 'Debout', 60, 3);
INSERT INTO CATEGORIEPLACE VALUES (9, 'Balcon', 150, 4);
INSERT INTO CATEGORIEPLACE VALUES (10, 'Parterre', 220, 4);
INSERT INTO CATEGORIEPLACE VALUES (11, 'Loges', 90, 4);
INSERT INTO CATEGORIEPLACE VALUES (12, 'Debout', 240, 5);
INSERT INTO CATEGORIEPLACE VALUES (13, 'Debout', 120, 6);
INSERT INTO CATEGORIEPLACE VALUES (14, 'Debout', 80, 7);
INSERT INTO CATEGORIEPLACE VALUES (15, 'Parterre', 60, 8);
INSERT INTO CATEGORIEPLACE VALUES (16, 'Balcon', 45, 8);
INSERT INTO CATEGORIEPLACE VALUES (17, 'Paradis', 20, 8);
INSERT INTO CATEGORIEPLACE VALUES (18, 'Debout', 220, 9);

INSERT INTO SPECTACLE VALUES (1, 'Rumeur et petits jours', 'Spectacle hilarant', 'Lorem ipsum dolores habit mio colore suspect nostro parami alos.', 80, 'E',null,1);
INSERT INTO SPECTACLE VALUES (2, 'Maris et femmes', 'Une introspection inventive', 'Lorem ipsum dolores habit mio colore suspect nostro parami alos.',null , 'C',16,4);
INSERT INTO SPECTACLE VALUES (3, 'Meeting', 'La grâce au rendez-vous', 'Lorem ipsum dolores habit mio colore suspect nostro parami alos.', 120, 'E',null ,2);
INSERT INTO SPECTACLE VALUES (4, 'Ressacs', 'Le monde tourne toujours', 'Lorem ipsum dolores habit mio colore suspect nostro parami alos.', 105, 'T',16,1);
INSERT INTO SPECTACLE VALUES (5, 'Les lions du Tibre', 'Qu''avons-nous fait ?', 'Lorem ipsum dolores habit mio colore suspect nostro parami alos.', 105, 'T',16,5);
INSERT INTO SPECTACLE VALUES (6, 'Nostradamus', 'Que savons-nous du futur ?', 'Lorem ipsum dolores habit mio colore suspect nostro parami alos.', 120, 'R',12,1);
INSERT INTO SPECTACLE VALUES (7, 'The Eagles', 'Les tenanciers de l''hotel reviennent.', 'Lorem ipsum dolores habit mio colore suspect nostro parami alos.', 100, 'N',12,6);
INSERT INTO SPECTACLE VALUES (8, 'Death of Nowhere', 'Du vrai hardcore qui débarque à Liège.', 'Lorem ipsum dolores habit mio colore suspect nostro parami alos.', 120, 'N',12,6);
INSERT INTO SPECTACLE VALUES (9, 'Les vertus du coeur', 'Un texte sensible et d''actualité.', 'Lorem ipsum dolores habit mio colore suspect nostro parami alos.', null, 'C',8,5);
INSERT INTO SPECTACLE VALUES (10, 'Hugues Stiernon', 'La philosophie 2.0.', 'Lorem ipsum dolores habit mio colore suspect nostro parami alos.', 120, 'N',8,3);

INSERT INTO PARTICIPANTSPECTACLE VALUES (1,1,1);
INSERT INTO PARTICIPANTSPECTACLE VALUES (2,1,1);
INSERT INTO PARTICIPANTSPECTACLE VALUES (3,1,2);
INSERT INTO PARTICIPANTSPECTACLE VALUES (1,4,1);
INSERT INTO PARTICIPANTSPECTACLE VALUES (8,1,2);
INSERT INTO PARTICIPANTSPECTACLE VALUES (7,4,1);
INSERT INTO PARTICIPANTSPECTACLE VALUES (4,1,2);
INSERT INTO PARTICIPANTSPECTACLE VALUES (5,4,1);
INSERT INTO PARTICIPANTSPECTACLE VALUES (13,6,3);
INSERT INTO PARTICIPANTSPECTACLE VALUES (13,5,5);
INSERT INTO PARTICIPANTSPECTACLE VALUES (14,3,5);
INSERT INTO PARTICIPANTSPECTACLE VALUES (15,6,6);
INSERT INTO PARTICIPANTSPECTACLE VALUES (16,1,7);

INSERT INTO REPRESENTATION VALUES (1, TO_DATE('01/02/2024 20:00','dd/mm/yyyy HH24:MI'), 1,1);
INSERT INTO REPRESENTATION VALUES (2, TO_DATE('02/03/2024 20:00','dd/mm/yyyy HH24:MI'), 1,1);
INSERT INTO REPRESENTATION VALUES (3, TO_DATE('03/03/2024 18:15','dd/mm/yyyy HH24:MI'), 1,1);
INSERT INTO REPRESENTATION VALUES (4, TO_DATE('04/04/2024 20:00','dd/mm/yyyy HH24:MI'), 1,1);
INSERT INTO REPRESENTATION VALUES (5, TO_DATE('03/04/2024 19:00','dd/mm/yyyy HH24:MI'), 2,2);
INSERT INTO REPRESENTATION VALUES (6, TO_DATE('04/05/2024 19:00','dd/mm/yyyy HH24:MI'), 2,2);
INSERT INTO REPRESENTATION VALUES (7, TO_DATE('12/07/2024 19:00','dd/mm/yyyy HH24:MI'), 3,2);
INSERT INTO REPRESENTATION VALUES (8, TO_DATE('13/07/2024 19:00','dd/mm/yyyy HH24:MI'), 4,1);
INSERT INTO REPRESENTATION VALUES (9, TO_DATE('14/07/2024 19:00','dd/mm/yyyy HH24:MI'), 4,1);
INSERT INTO REPRESENTATION VALUES (10, TO_DATE('20/09/2024 19:00','dd/mm/yyyy HH24:MI'), 7,5);
INSERT INTO REPRESENTATION VALUES (11, TO_DATE('21/09/2024 19:00','dd/mm/yyyy HH24:MI'), 8,6);
INSERT INTO REPRESENTATION VALUES (12, TO_DATE('22/09/2024 19:00','dd/mm/yyyy HH24:MI'), 8,6);
INSERT INTO REPRESENTATION VALUES (13, TO_DATE('03/10/2024 19:00','dd/mm/yyyy HH24:MI'), 9,7);
INSERT INTO REPRESENTATION VALUES (14, TO_DATE('04/10/2024 19:00','dd/mm/yyyy HH24:MI'), 9,7);
INSERT INTO REPRESENTATION VALUES (15, TO_DATE('05/10/2024 19:00','dd/mm/yyyy HH24:MI'), 9,7);
INSERT INTO REPRESENTATION VALUES (16, TO_DATE('05/10/2024 19:00','dd/mm/yyyy HH24:MI'), 2,2);
INSERT INTO REPRESENTATION VALUES (17, TO_DATE('06/10/2024 19:00','dd/mm/yyyy HH24:MI'), 2,2);
INSERT INTO REPRESENTATION VALUES (18, TO_DATE('08/10/2024 19:00','dd/mm/yyyy HH24:MI'), 2,2);
INSERT INTO REPRESENTATION VALUES (19, TO_DATE('23/10/2024 19:00','dd/mm/yyyy HH24:MI'), 8,6);
INSERT INTO REPRESENTATION VALUES (20, TO_DATE('24/11/2024 19:00','dd/mm/yyyy HH24:MI'), 8,6);
INSERT INTO REPRESENTATION VALUES (21, TO_DATE('26/12/2024 19:00','dd/mm/yyyy HH24:MI'), 8,5);
INSERT INTO REPRESENTATION VALUES (22, TO_DATE('28/12/2024 19:00','dd/mm/yyyy HH24:MI'), 8,5);


INSERT INTO CLIENT VALUES (1, 'Durant', 'Roger', 'rue des alouettes', 24, 4000, 'Liège', 'Belgique','r.dur@yahoo.be',null );
INSERT INTO CLIENT VALUES (2, 'Dupont', 'Sylvie', 'avenue du bac', 16, 4890, 'Clermont', 'Belgique', 'sylvie89@scarlet.be',null );
INSERT INTO CLIENT VALUES (3, 'Dupond', 'Nathalie', 'rue des alouettes', 24, 4000, 'Liège', 'Belgique', 'nath_dupond@gmail.com', '04/2784512');
INSERT INTO CLIENT VALUES (4, 'Durand', 'Marc', 'rue des alouettes', 24, 4000, 'Liège', 'Belgique', 'billboquet@yahoo.com', '0474/784512' );
INSERT INTO CLIENT VALUES (5, 'Dunant', 'Henri', 'rue des croix', 14, 4800, 'Verviers', 'Belgique',null ,null );
INSERT INTO CLIENT VALUES (6, 'Rienco', 'Mandé', 'rue du seuil', 11, 4900, 'Spa', 'Belgique',null ,'0478/98.23.23' );
INSERT INTO CLIENT VALUES (7, 'Pabli', 'Stéphano', 'allée verte', 14, 4150, 'Chaufontaine', 'Belgique',null ,'0476/49.23.23' );
INSERT INTO CLIENT VALUES (8, 'Durant', 'Christine', 'rue de Verneuil', 51, 4150, 'Chaufontaine', 'Belgique',null ,'0478/96.24.34' );

INSERT INTO RESERVATION VALUES (1, TO_DATE('24/04/2024','dd/mm/yyyy'), 1, 1, 1,15);
INSERT INTO RESERVATION VALUES (2, TO_DATE('25/03/2024','dd/mm/yyyy'), 2, 2, 1,5);
INSERT INTO RESERVATION VALUES (3, TO_DATE('25/04/2024','dd/mm/yyyy'), 3, 3, 1,2);
INSERT INTO RESERVATION VALUES (4, TO_DATE('26/05/2024','dd/mm/yyyy'), 4, 1, 1,6);
INSERT INTO RESERVATION VALUES (5, TO_DATE('30/04/2024','dd/mm/yyyy'), 5, 6, 5,8);
INSERT INTO RESERVATION VALUES (6, TO_DATE('30/04/2024','dd/mm/yyyy'), 3, 6, 6,5);
INSERT INTO RESERVATION VALUES (7, TO_DATE('01/05/2024','dd/mm/yyyy'), 1, 1, 4,4);
INSERT INTO RESERVATION VALUES (8, TO_DATE('01/06/2024','dd/mm/yyyy'), 6, 2, 7,12);
INSERT INTO RESERVATION VALUES (9, TO_DATE('02/06/2024','dd/mm/yyyy'), 7, 2, 6,4);
INSERT INTO RESERVATION VALUES (10, TO_DATE('23/05/2024','dd/mm/yyyy'), 5, 1, 5,8);
INSERT INTO RESERVATION VALUES (11, TO_DATE('16/05/2024','dd/mm/yyyy'), 1, 1, 4,4);
INSERT INTO RESERVATION VALUES (12, TO_DATE('12/06/2024','dd/mm/yyyy'), 6, 2, 14,12);
INSERT INTO RESERVATION VALUES (13, TO_DATE('06/06/2024','dd/mm/yyyy'), 7, 2, 15,4);
INSERT INTO RESERVATION VALUES (14, TO_DATE('18/05/2024','dd/mm/yyyy'), 5, 1, 16,8);
INSERT INTO RESERVATION VALUES (15, TO_DATE('05/05/2024','dd/mm/yyyy'), 2, 1, 21,8);

COMMIT;