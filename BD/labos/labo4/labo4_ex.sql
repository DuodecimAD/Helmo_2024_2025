1.
SELECT MAX(o.montant) as montant
FROM offre o;

2.
SELECT sum(o.montant) || ' €' as CA_LIEGE
FROM offre o
INNER JOIN candidat c ON o.ID_CANDIDAT = c.ID_CANDIDAT
WHERE o.STATUT = 'A' and c.CODE_POSTAL BETWEEN 4000 AND 4999;

3.
SELECT localite, count(localite) as nb_bien
FROM bien
GROUP BY localite;

4.
SELECT b.localite, sum(o.montant) || ' €' as ca
FROM offre o
INNER JOIN bien b ON o.id_bien = b.id_bien
WHERE o.STATUT = 'A'
group by b.localite;

5.
SELECT b.id_bien, b.rue, b.numero, b.localite, MIN(hp.montant) as prix_actuel
FROM bien b
INNER JOIN historique_prix hp ON hp.ID_BIEN = b.ID_BIEN
GROUP BY b.id_bien, b.rue, b.numero, b.localite
ORDER BY b.id_bien;

6.
SELECT ROUND((SYSDATE - MIN(date_mise_en_vente))/7) as date_bien
FROM bien;

7.
SELECT cs.description, count(b.ID_BIEN) as nombre
FROM CATEGORIE_SITUATION cs
LEFT JOIN bien b ON b.ID_CATSITUATION = cs.ID_CATSITUATION
GROUP BY cs.description
ORDER BY nombre DESC;

8.
SELECT b.localite, COUNT(b.ID_BIEN) as nombre_bien
FROM bien b
JOIN offre o ON b.ID_BIEN = o.ID_BIEN
WHERE o.statut = 'A'
GROUP BY b.localite;

9.
SELECT cb.description, AVG(NB_CHAC) as nb_moyen_chac
FROM CATEGORIE_BIEN cb
LEFT JOIN BIEN b ON cb.ID_CATBIEN = b.ID_CATBIEN
GROUP BY cb.description;

10.
SELECT v.nom, v.prenom, COUNT(g.ID_BIEN) as nombre
FROM vendeur v
LEFT JOIN gerer g ON v.ID_VENDEUR = g.ID_VENDEUR
GROUP BY v.NOM, v.PRENOM;

11.
SELECT v.nom, v.prenom, COUNT(g.id_bien)
FROM vendeur v
/*LEFT*/ JOIN gerer g ON v.id_vendeur = g.id_vendeur
WHERE g.id_bien NOT IN (SELECT id_bien FROM Offre WHERE statut = 'A') or g.id_bien IS NULL
GROUP BY v.nom, v.prenom;

12.
SELECT nom, prenom, COUNT(g.ID_BIEN) as nombre
FROM vendeur v
LEFT JOIN gerer g ON v.ID_VENDEUR = g.ID_VENDEUR
GROUP BY v.NOM, v.PRENOM
HAVING COUNT(g.ID_BIEN) >= 5;

13.
SELECT c.nom, c.prenom, AVG(o.montant) as moyenne
FROM candidat c
JOIN offre o ON c.id_candidat = o.id_candidat
GROUP BY c.nom, c.prenom

14.
SELECT cb.description, SUM(b.surface_jardin) + SUM(b.surface_habitable) || 'm2' as surface
FROM categorie_bien cb
JOIN bien b ON b.id_catbien = cb.id_catbien
GROUP BY cb.description
HAVING (SUM(b.surface_jardin) + SUM(b.surface_habitable)) BETWEEN 2000 AND 3000

15.
SELECT b.id_bien as identifiant, b.rue, b.numero, code_postal
FROM bien b
join HISTORIQUE_PRIX hp ON b.ID_BIEN = hp.ID_BIEN
GROUP BY b.id_bien, b.rue, b.numero, code_postal
HAVING count(hp.ID_BIEN) > 1;

16.
SELECT b.id_bien, b.rue, b.numero, b.LOCALITE, TO_CHAR(b.DATE_MISE_EN_VENTE, 'dd-MON-yy') as date_mise_en_vente
FROM bien b
WHERE b.DATE_MISE_EN_VENTE > (
                             SELECT MIN(DATE_MESSAGE)
                             FROM MESSAGE
                             )

17.
SELECT NOM
FROM CANDIDAT
WHERE ID_CANDIDAT = (
                    SELECT o.ID_CANDIDAT
                    FROM offre o
                    WHERE montant = (
                                    SELECT MAX(o1.montant)
                                    FROM offre o1
                                    )
                    )

18.
SELECT count(c.id_client) as nombre
FROM client c
WHERE c.id_client = ANY (
                        SELECT b.id_client
                        FROM BIEN b
                        WHERE b.NB_CHAC = 3
                        )

19.
SELECT b.id_bien, b.rue, b.numero, b.localite
FROM bien b
WHERE localite = ANY (
                     SELECT c.LOCALITE
                     FROM candidat c
                     )

20.
SELECT b.rue || ', ' || numero || ' - ' || localite || ' (' || code_postal || ')' as adresse
FROM bien b
WHERE b.SURFACE_HABITABLE > (
                            SELECT SURFACE_HABITABLE
                            FROM bien b3
                            WHERE b3.rue = 'rue des minières'
                                    AND b3.numero = 65
                                    AND b3.CODE_POSTAL = 4600
                                    AND b3.localite = 'Richelle'
                            )

21.
SELECT b.id_bien, b.rue, b.numero, b.localite, b.SURFACE_JARDIN
FROM bien b
WHERE b.ID_CATBIEN = (SELECT cb.ID_CATBIEN
                    FROM CATEGORIE_BIEN cb
                    WHERE UPPER(cb.DESCRIPTION) = 'FERMETTE')
		AND b.SURFACE_JARDIN > (
                                SELECT MAX(b2.SURFACE_JARDIN)
		                        FROM bien b2
		                        WHERE b2.ID_CATBIEN = (
                                                        SELECT cb2.ID_CATBIEN
		                                                FROM CATEGORIE_BIEN cb2
		                                                WHERE UPPER(cb2.DESCRIPTION) = 'MAISON'
                                                        )
                                );

-- avec jointure

SELECT b.id_bien, b.rue, b.numero, b.localite, b.surface_jardin
FROM bien b
JOIN categorie_bien cb ON b.id_catbien = cb.id_catbien
WHERE b.surface_jardin > ALL (SELECT b2.surface_jardin
                              FROM bien b2
                              JOIN categorie_bien cb2 ON b2.id_catbien = cb2.id_catbien
                              WHERE cb2.description = 'Maison')
     AND cb.description = 'Fermette';

22.
SELECT b.id_bien, b.rue, b.numero, b.localite, b.SURFACE_HABITABLE
FROM bien b
WHERE b.SURFACE_HABITABLE < ANY (
                                SELECT b2.SURFACE_HABITABLE
                                FROM bien b2
                                WHERE b2.ID_CATBIEN = (
                                                        SELECT cb2.ID_CATBIEN
                                                        FROM CATEGORIE_BIEN cb2
                                                        WHERE UPPER(cb2.DESCRIPTION) = 'VILLA'
                                                        )
                                );

23.
SELECT c.NOM, c.PRENOM, c.ID_CANDIDAT
FROM candidat c
WHERE c.ID_CANDIDAT = ANY (
                            SELECT o2.ID_CANDIDAT
                            FROM offre o2
                            WHERE o2.montant > (
                                                SELECT AVG(o3.MONTANT)
                                                FROM offre o3
                                                )
                            );

24.
SELECT b.id_bien
FROM bien b
where id_bien NOT IN (
                     SELECT o.id_bien
                     FROM offre o
                     );
-- ou

SELECT b.id_bien, b.rue, b.numero, b.localite, b.surface_jardin
FROM bien b
WHERE NOT EXISTS (
                 SELECT * FROM offre o WHERE o.id_bien = b.id_bien
                 );

25.
SELECT m.texte, m.DATE_MESSAGE
FROM message m
WHERE MONTHS_BETWEEN(SYSDATE, DATE_MESSAGE) > 6 AND a.STATUT = 'L' AND NOT EXISTS (
                                                                                    SELECT a.id_message
                                                                                    FROM alerter a
                                                                                    WHERE a.STATUT = 'L'
                                                                                    );

26.
SELECT v.nom, v.prenom
FROM vendeur v
WHERE 3 > (SELECT COUNT(*) FROM gerer g WHERE g.id_vendeur = v.id_vendeur)

-- ou

select v.nom, v.prenom
from VENDEUR v
left join GERER g on v.ID_VENDEUR = g.ID_VENDEUR
group by v.nom, v.prenom
having count(*) < 3;

27.
SELECT nom, prenom, 'Vendeur' as role
FROM vendeur
UNION
SELECT nom, prenom, 'Client' as role
FROM client
UNION
SELECT nom, prenom, 'Candidat' as role
FROM candidat;

28.
SELECT b.ID_BIEN
FROM BIEN b
MINUS
SELECT o.id_bien
FROM offre o;

29.
SELECT v.id_vendeur
FROM vendeur v
minus
SELECT ID_VENDEUR
FROM alerter
WHERE STATUT = 'N'

30.
SELECT c.nom, c.prenom
FROM CANDIDAT c
JOIN OFFRE o ON c.id_candidat = o.id_candidat
JOIN BIEN b ON o.id_bien = b.id_bien
WHERE b.code_postal BETWEEN 4000 AND 4999
MINUS
SELECT c.nom, c.prenom
FROM CANDIDAT c
JOIN OFFRE o ON c.id_candidat = o.id_candidat
JOIN BIEN b ON o.id_bien = b.id_bien
JOIN CATEGORIE_BIEN cb ON b.id_catbien = cb.id_catbien
WHERE cb.description IN ('Villa', 'Ferme', 'Bungalow')

31.
SELECT b.rue, b.numero, b.localite, o.montant,
    CASE
        WHEN o.statut = 'I' OR o.statut = 'E' THEN 'Examen en cours'
        WHEN o.statut = 'A' THEN 'Accepté'
        WHEN o.statut = 'R' THEN 'Refusé'
        WHEN o.statut IS NULL THEN 'Aucune offre'
        ELSE 'Erreur - status inconnu'
    END as statut
FROM bien b
left JOIN offre o ON b.ID_BIEN = o.ID_BIEN;

32.
SELECT b.rue, b.numero, b.code_postal, b.localite,
    CASE
        WHEN MIN(hp.montant) <= 120000 THEN 'Pas cher'
        WHEN MIN(hp.montant) <= 280000  THEN 'Abordable'
        WHEN MIN(hp.montant) <= 400000  THEN 'Cher'
        WHEN MIN(hp.montant) > 400000   THEN 'Très cher'
    END AS Categorie_de_prix
FROM bien b
JOIN historique_prix hp ON b.id_bien = hp.id_bien
GROUP BY b.rue, b.numero, b.code_postal, b.localite
