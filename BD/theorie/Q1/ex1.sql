CREATE TABLE Acteur(
   idActeur INT PRIMARY KEY,
   nom VARCHAR(100) NOT NULL,
   prenom VARCHAR(100)
);

CREATE TABLE Genre(
   idGenre INT PRIMARY KEY,
   nom VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE Film(
	idFilm INTEGER PRIMARY KEY,
	titre VARCHAR(250),
   duree INTEGER,
   description VARCHAR(300) NOT NULL,
	idGenre INTEGER,
	CONSTRAINT duree CHECK (duree >0)
);

CREATE TABLE Jouer(
   idFilm INT,
   idActeur INT,
   role VARCHAR(100) NOT NULL,
   PRIMARY KEY(idFilm, idActeur),
   FOREIGN KEY(idFilm) REFERENCES Film(idFilm),
   FOREIGN KEY(idActeur) REFERENCES Acteur(idActeur)
);

--------------------------------------------------------------------
INSERT INTO Acteur VALUES (1,'Darmon', 'Matt');
INSERT INTO Acteur VALUES (2,'De Noirot', 'Robert');
INSERT INTO Acteur VALUES (3,'Denouvelle', 'Catherine');
INSERT INTO Acteur VALUES (4,'Cardin', null);
INSERT INTO Acteur VALUES (5,'Jeunot', null);
INSERT INTO Acteur VALUES (6,'Milton', 'John');
INSERT INTO Acteur VALUES (7,'Stallion', 'Sylvestre');
INSERT INTO Acteur VALUES (8,'Fillo', 'Marue');

--------------------------------------------------------------------
INSERT INTO Genre VALUES (1, 'Thriller');
INSERT INTO Genre VALUES (2, 'Comédie');
INSERT INTO Genre VALUES (3, 'Drame');
INSERT INTO Genre VALUES (4, 'Policier');
INSERT INTO Genre VALUES (5, 'Science-Fiction');

--------------------------------------------------------------------
INSERT INTO Film VALUES (1, 'Les affranchis', 132, 'Un film policier haletant avec un dénouement innatendu', 4);
INSERT INTO Film VALUES (2, 'Exostar', 92, 'Une pure merveille d''effets spéciaux mais le scénario laisse à désirer', 5);
INSERT INTO Film VALUES (3, 'Le silence des brebis', null, 'L''histoire glaçante d''un amateur de viande', 1);
INSERT INTO Film VALUES (4, 'A cop in New-York', 142, 'La lutte pour la survie dans les bas-fonds de New-York.', 4);
INSERT INTO Film VALUES (5, 'Lethal connection 2', 128, 'Le retour de Riggs et Murtaugh dans une histoire à dormir debout.', 4);

--------------------------------------------------------------------
INSERT INTO Jouer VALUES (1, 1, 'Tom Riffle');
INSERT INTO Jouer VALUES (1, 3, 'Joanna Stroke');
INSERT INTO Jouer VALUES (2, 1, 'Steve Boldon (jeune)');
INSERT INTO Jouer VALUES (2, 2, 'Steve Boldon (agé)');
INSERT INTO Jouer VALUES (2, 7, 'Mr. Dark');
INSERT INTO Jouer VALUES (3, 6, 'Percy Darby');

--------------------------------------------------------------------
COMMIT;


--------------------------------------------------------------------
select *
from FILM;

SELECT *
FROM ACTEUR;

SELECT *
FROM GENRE;

7)
select *
from FILM
where IDGENRE = 6;

8)
INSERT INTO FILM (IDFILM, TITRE, DUREE, DESCRIPTION, IDGENRE)
VALUES (6,'La Reine', 156, 'La vie insipide de la reine du royaume de Flatland', 6);

9)
DELETE FROM GENRE
WHERE NOM = 'Biopic';

10)
INSERT INTO ACTEUR (IDACTEUR, NOM, PRENOM) values (9, 'Fillo', 'Marie');

11)
SELECT *
FROM FILM
WHERE DUREE > 100;

12)
SELECT TITRE
FROM FILM
WHERE TITRE LIKE 'L%';

13)
SELECT TITRE, DUREE
FROM FILM
WHERE TITRE LIKE 'L%' AND DUREE > 100;

14)
SELECT TITRE, DUREE
FROM FILM
WHERE DUREE IS NULL ;

15)
SELECT f.TITRE, g.NOM AS GENRE
FROM FILM f
INNER JOIN GENRE g ON g.IDGENRE = f.IDGENRE;

16)
SELECT f.TITRE, g.NOM AS GENRE
FROM FILM f
INNER JOIN GENRE g ON g.IDGENRE = f.IDGENRE
WHERE f.TITRE LIKE 'L%' AND DUREE BETWEEN 100 AND 135;

17)
SELECT f.titre, f.description
FROM FILM f
INNER JOIN GENRE g ON g.IDGENRE = f.IDGENRE
WHERE g.NOM IN ( 'Policier', 'Thriller', 'Drame');
--WHERE g.NOM = 'Policier' OR g.NOM = 'Thriller' OR g.NOM = 'Drame';

18)
SELECT g.NOM
FROM FILM f
RIGHT JOIN GENRE g ON g.IDGENRE = f.IDGENRE
WHERE f.IDGENRE IS NULL;

19)
-- never gonna happen -> NOT NULL
SELECT titre
FROM FILM
WHERE IDGENRE IS NULL;

20)
SELECT a.NOM, a.PRENOM, f.titre
FROM FILM f
INNER JOIN JOUER j ON f.IDFILM = j.IDFILM
INNER JOIN ACTEUR a on a.IDACTEUR = j.IDACTEUR;

21)
SELECT a.NOM, a.PRENOM, f.titre, j.ROLE
FROM FILM f
INNER JOIN JOUER j ON f.IDFILM = j.IDFILM
INNER JOIN ACTEUR a on a.IDACTEUR = j.IDACTEUR;

22)
SELECT a.NOM, a.PRENOM
FROM ACTEUR a
LEFT JOIN JOUER j on j.IDACTEUR = a.IDACTEUR
WHERE j.IDACTEUR IS NULL;

23)
SELECT TITRE, DUREE, DESCRIPTION
FROM Film
WHERE DESCRIPTION LIKE '%histoire%';

UPDATE Film
SET DUREE = DUREE+10
WHERE DESCRIPTION LIKE '%histoire%';

