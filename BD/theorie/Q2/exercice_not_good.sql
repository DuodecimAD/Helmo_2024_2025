CREATE TABLE Personne(
	noPersonne INTEGER PRIMARY KEY,
	nom VARCHAR(100),
	prenom VARCHAR(100),
	dateDeNaissance DATE
);

CREATE TABLE Film(
	noFilm INTEGER PRIMARY KEY,
	tire VARCHAR(250),
	dateSortie DATE,
	duree INTEGER,
	CONSTRAINT dureePositive CHECK (duree >0)
);

CREATE TABLE Salle(
	noSalle INTEGER PRIMARY KEY,
	capacite INTEGER,
	CONSTRAINT capacitePositive CHECK (capacite >0)
);

--CREATE TABLE Acteur(
--	role VARCHAR(100) PRIMARY KEY,
--	FOREIGN KEY (noFilm, noPersonne) REFERENCES (Film, Personne),

	--noFilm INTEGER NOT NULL REFERENCES FILM (noFILM),
	--noPersonne INTEGER REFERENCES Personne (noPersonne),
	--role VARCHAR(100),
	--PRIMARY KEY (noFilm, noPersonne, role) REFERENCES (Film, Personne)
--);

CREATE TABLE Acteur (
    role VARCHAR(100) PRIMARY KEY,
    noFilm INTEGER,
    noPersonne INTEGER,
    FOREIGN KEY (noFilm) REFERENCES Film(noFilm),
    FOREIGN KEY (noPersonne) REFERENCES Personne(noPersonne)
);

CREATE TABLE Realisateur(
	noFilm INTEGER,
	noPersonne INTEGER,
	FOREIGN KEY (noFilm) REFERENCES Film(noFilm),
    FOREIGN KEY (noPersonne) REFERENCES Personne(noPersonne)
);

CREATE TABLE Seance (
    dateSeance DATE,
    heureSeance VARCHAR(5),
    nombrePlacesVendues INTEGER,
    noFilm NUMBER,
    noSalle NUMBER,
    PRIMARY KEY (dateSeance, heureSeance),
    FOREIGN KEY (noFilm) REFERENCES Film(noFilm),
    FOREIGN KEY (noSalle) REFERENCES Salle(noSalle)
);

-- Renommer table Personne en Personnalite
ALTER TABLE Personne RENAME TO Personnalite;

-- Ajout colonne description
ALTER TABLE Films ADD Description VARCHAR(4000);

-- Supprimer toutes les tables
DROP TABLE SEANCE;
DROP TABLE REALISATEUR;
DROP TABLE Acteur;
DROP TABLE Salle;
DROP TABLE Personnalite;
DROP TABLE Film;

