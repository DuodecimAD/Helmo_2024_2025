DROP TABLE Seance;
DROP TABLE Acteur;
DROP TABLE Realisateur;
DROP TABLE Personne;
DROP TABLE Film;
DROP TABLE Salle;


CREATE TABLE Salle(
   numSalle INTEGER PRIMARY KEY,
   nomSalle VARCHAR(100) NOT NULL,
   capacite INTEGER NOT NULL
);

CREATE TABLE Film(
   numFilm INTEGER PRIMARY KEY,
   titre VARCHAR(100) NOT NULL UNIQUE,
   dateSortie DATE NOT NULL,
   duree INT
);

CREATE TABLE Personne(
    numPersonne INTEGER PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    dateNaissance DATE
);

CREATE TABLE Acteur(
   numFilm INTEGER REFERENCES Film(numFilm),
   numPersonne INTEGER REFERENCES Personne(numPersonne),
   role VARCHAR(100) NOT NULL,
   PRIMARY KEY(numFilm, numPersonne, role)
);

CREATE TABLE Realisateur(
   numFilm INTEGER REFERENCES Film(numFilm),
   numPersonne INTEGER REFERENCES Personne(numPersonne),
   PRIMARY KEY(numFilm, numPersonne)
);


CREATE TABLE Seance(
   numSalle INTEGER REFERENCES Salle(numSalle),
   numFilm INTEGER REFERENCES Film(numFilm),
   jourHeure DATE NOT NULL,
   nbPlacesVendues INTEGER NOT NULL,
   PRIMARY KEY(numSalle, numFilm, jourHeure)
);

=======================================================================
INSERT INTO Personne VALUES (1,'Darmon', 'Matt', TO_DATE('01011980','ddmmyyyy'));
INSERT INTO Personne VALUES (2,'De Noirot', 'Robert', TO_DATE('27061960','ddmmyyyy'));
INSERT INTO Personne VALUES (3,'Denouvelle', 'Catherine', null);
INSERT INTO Personne VALUES (4,'Cardin', 'Louise', TO_DATE('11101965','ddmmyyyy'));
INSERT INTO Personne VALUES (5,'Jeunot', 'Gérard', TO_DATE('21111970','ddmmyyyy'));
INSERT INTO Personne VALUES (6,'Milton', 'John', TO_DATE('01101994','ddmmyyyy'));
INSERT INTO Personne VALUES (7,'Stallion', 'Sylvestre', TO_DATE('19041964','ddmmyyyy'));
INSERT INTO Personne VALUES (8,'Fillo', 'Marie', null);
INSERT INTO Personne VALUES (9,'Lanners', 'Bouli', null);

=======================================================================
INSERT INTO Film VALUES (1, 'Les affranchis', TO_DATE('12102004','ddmmyyyy'), 132);
INSERT INTO Film VALUES (2, 'Exostar', TO_DATE('12082009','ddmmyyyy'), 146);
INSERT INTO Film VALUES (3, 'Le silence des brebis', TO_DATE('24082007','ddmmyyyy'), 98);
INSERT INTO Film VALUES (4, 'Gone Girl', TO_DATE('23102014','ddmmyyyy'), 116);
INSERT INTO Film VALUES (5, 'Lethal connection 2', TO_DATE('01102014','ddmmyyyy'), 124);
INSERT INTO Film VALUES (6, 'Lethal connection 3', TO_DATE('01102016','ddmmyyyy'), 134);

========================================================================
INSERT INTO Salle VALUES (1, 'Salle bleue', 150);
INSERT INTO Salle VALUES (2, 'Salle rouge', 120);
INSERT INTO Salle VALUES (3, 'Salle verte', 210);
INSERT INTO Salle VALUES (4, 'Salle blanche', 85);
INSERT INTO Salle VALUES (5, 'Salle mauve', 120);
========================================================================
INSERT INTO Seance VALUES (1,1,TO_DATE('12102004 18:30','ddmmyyyy hh24:mi'), 110);
INSERT INTO Seance VALUES (1,1,TO_DATE('13102004 18:30','ddmmyyyy hh24:mi'), 70);
INSERT INTO Seance VALUES (1,1,TO_DATE('13102004 21:30','ddmmyyyy hh24:mi'), 90);
INSERT INTO Seance VALUES (1,1,TO_DATE('14102004 20:30','ddmmyyyy hh24:mi'), 10);

INSERT INTO Seance VALUES (1,2,TO_DATE('12082009 18:30','ddmmyyyy hh24:mi'), 110);
INSERT INTO Seance VALUES (2,2,TO_DATE('13012017 18:30','ddmmyyyy hh24:mi'), 45);
INSERT INTO Seance VALUES (2,2,TO_DATE('13102017 21:30','ddmmyyyy hh24:mi'), 10);
INSERT INTO Seance VALUES (3,2,TO_DATE('14102018 20:30','ddmmyyyy hh24:mi'), 15);

INSERT INTO Seance VALUES (3,2,TO_DATE('12012017 18:30','ddmmyyyy hh24:mi'), 110);
INSERT INTO Seance VALUES (4,2,TO_DATE('13012017 18:30','ddmmyyyy hh24:mi'), 45);
INSERT INTO Seance VALUES (4,2,TO_DATE('13012017 21:30','ddmmyyyy hh24:mi'), 10);
INSERT INTO Seance VALUES (5,2,TO_DATE('14012017 20:30','ddmmyyyy hh24:mi'), 15);


========================================================================

INSERT INTO Realisateur VALUES (1,1);
INSERT INTO Realisateur VALUES (2,1);
INSERT INTO Realisateur VALUES (3,2);
INSERT INTO Realisateur VALUES (4,3);
INSERT INTO Realisateur VALUES (5,3);
INSERT INTO Realisateur VALUES (6,3);
========================================================================
INSERT INTO Acteur VALUES (1,4, 'Le policier');
INSERT INTO Acteur VALUES (1,5, 'John Stroke');
INSERT INTO Acteur VALUES (2,4, 'Illian Stone');
INSERT INTO Acteur VALUES (3,4, 'Leon Stowalski');
INSERT INTO Acteur VALUES (3,7, 'John Satip');
INSERT INTO Acteur VALUES (4,6, 'Nath Fone');
INSERT INTO Acteur VALUES (5,8, 'John Riggs');
INSERT INTO Acteur VALUES (5,9, 'Spencer Murtaugh');
INSERT INTO Acteur VALUES (6,8, 'John Riggs');
INSERT INTO Acteur VALUES (6,9, 'Spencer Murtaugh');

COMMIT;