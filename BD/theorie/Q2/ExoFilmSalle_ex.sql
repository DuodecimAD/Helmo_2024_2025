>> ExoFilmSalle.pdf

1.
SELECT MAX(duree)
FROM Film;

2.
SELECT COUNT(numPersonne) as nbActeurs
FROM Acteur a
JOIN Film f ON f.numFilm = a.numFilm
WHERE f.titre = 'Gone Girl';

3.
SELECT (SUM(duree) / count(duree)) as durMoy
FROM Film f
JOIN Acteur a ON a.numFilm = f.numFilm
JOIN Personne p ON p.numPersonne = a.numPersonne
WHERE p.prenom = 'Bouli' AND p.nom = 'Lanners';

4.
SELECT numSalle, SUM(NBPLACESVENDUES) as nbPlaces, TO_CHAR(JOURHEURE, 'dd/mm/yyy') as dateSeance
FROM Seance
GROUP BY TO_CHAR(JOURHEURE, 'dd/mm/yyy') , numSalle;

5.
SELECT sa.nomSalle, ROUND((SUM(se.NBPLACESVENDUES) / SUM(sa.capacite)) * 100) || ' %' as tauxRmpl
FROM Salle sa
JOIN Seance se ON se.numSalle = sa.numSalle
WHERE to_char(se.jourHeure, 'YYYY-MM') = '2017-01'
GROUP BY sa.nomSalle;

6.
SELECT f.titre, COUNT(se.jourHeure)
FROM Film f
LEFT JOIN Seance se ON se.numFilm = f.numFilm AND jourHeure > SYSDATE
GROUP BY f.titre;

7.
SELECT f.titre, dateSortie
FROM FILM f
JOIN SEANCE se ON se.NUMFILM = f.NUMFILM
WHERE f.duree > (SELECT AVG(duree)
                 FROM FILM);

8.
SELECT p.nom, p.prenom
FROM PERSONNE p
JOIN Acteur a ON a.NUMPERSONNE = p.NUMPERSONNE

MINUS

SELECT p.nom, p.prenom
FROM PERSONNE p
JOIN REALISATEUR r ON r.NUMPERSONNE = p.NUMPERSONNE;

9.
SELECT titre
FROM film
WHERE titre LIKE '%IRD%'

UNION

SELECT f.titre
FROM film f
JOIN acteur a ON a.NUMFILM = f.NUMFILM
join personne p ON a.NUMPERSONNE = p.NUMPERSONNE
WHERE UPPER(p.nom) = 'HANKS' AND UPPER(p.prenom) = 'TOM';

10.
SELECT f.titre, sa.nomSalle
FROM FILM f
JOIN Seance se ON se.NUMFILM = f.NUMFILM
JOIN Salle sa ON sa.NUMSALLE = se.NUMSALLE
WHERE UPPER(f.titre) = 'BIRDMAN'

INTERSECT

SELECT f.titre, sa.nomSalle
FROM FILM f
JOIN Seance se ON se.NUMFILM = f.NUMFILM
JOIN Salle sa ON sa.NUMSALLE = se.NUMSALLE
WHERE UPPER(f.titre) = 'MOONLIGHT';

=================
====== ou =======
=================

SELECT f.titre, sa.nomSalle
FROM FILM f
JOIN Seance se ON se.NUMFILM = f.NUMFILM
JOIN Salle sa ON sa.NUMSALLE = se.NUMSALLE
WHERE UPPER(f.titre) = 'BIRDMAN' AND
EXISTS (
    SELECT *
    FROM FILM f
    JOIN Seance se ON se.NUMFILM = f.NUMFILM
    JOIN Salle sa2 ON sa2.NUMSALLE = se.NUMSALLE
    WHERE UPPER(f.titre) = 'MOONLIGHT' AND sa2.NUMSALLE = sa.NUMSALLE
);

11.
SELECT f.titre, TO_CHAR(se.JOURHEURE, 'HH24:MI')
FROM film f
JOIN seance se ON f.NUMFILM = se.NUMFILM
WHERE TO_CHAR(se.JOURHEURE, 'HH24:MI') = (SELECT TO_CHAR(JOURHEURE - (2/24), 'HH24:MI')
                                          FROM SEANCE
                                          WHERE TO_CHAR(JOURHEURE, 'dd-mm-yyyy') = '12-10-2004');

-- correction
select f.titre
FROM film f
WHERE EXISTS (SELECT *
             FROM sceance s
             WHERE TO(CHAR(JOURHEURE, 'HH24:MI') = '16:30' AND f.numFilm = s.numFilm);

12.
SELECT f.titre,
   CASE
       WHEN f.duree < 90 THEN '7€'
       WHEN f.duree <= 140 THEN '8.5€'
       ELSE '9€'
   END as prix
FROM film f;


13.
SELECT f.titre --, sa.NOMSALLE, sa.CAPACITE
FROM film f
JOIN seance se ON f.NUMFILM = se.NUMFILM
JOIN salle sa ON se.NUMSALLE = sa.NUMSALLE
WHERE sa.CAPACITE > (SELECT MAX(CAPACITE)-10
                     FROM salle);

-- correction
SELECT f.titre
FROM film f
WHERE NOT EXISTS (SELECT *
                  FROM seance se
                  JOIN salle sa ON se.noSalle = sa.noSalle
                  WHERE f.numFilm = se.numFilm AND s.capactite < 200)

14.
SELECT f.titre
FROM film f
JOIN seance se ON f.NUMFILM = se.NUMFILM
WHERE TO_CHAR(se.JOURHEURE, 'HH24') BETWEEN '18' AND '23'
GROUP BY f.titre
HAVING SUM(se.NBPLACESVENDUES) > 5000;

15.
SELECT f.titre
FROM film f
WHERE f.duree > ALL (SELECT f2.duree
                     FROM film f2
                     WHERE to_CHAR(DATESORTIE, 'yyyy') = '2014');

-- autre façon
SELECT f.titre
FROM film f
WHERE f.duree > (SELECT MAX(f2.duree)
                 FROM film f2
                 WHERE to_CHAR(DATESORTIE, 'yyyy') = '2014');