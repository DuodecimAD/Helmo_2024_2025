6.
CREATE VIEW contact_candidat
AS
SELECT nom || ' ' || prenom as Nom,
    CASE
        WHEN email = 'NULL' THEN telephone
        WHEN email IS NULL THEN telephone
        WHEN email IS NOT NULL THEN email
    END as Contact
FROM candidat
WITH READ ONLY;

-- QUERY CHECK
select * from contact_candidat;

7.
CREATE VIEW chateau (id_bien, id_catbien, rue, numero, localite, code_postal, description,
                    surface_habitable, surface_jardin, nb_pav, nb_chac, nb_garage, nb_facade,
                    nb_sdb, date_mise_en_vente, id_client, id_catsituation, id_catetat, id_catcuisine)
AS
SELECT id_bien, id_catbien, rue, numero, localite, code_postal, description, surface_habitable,
        surface_jardin, nb_pav, nb_chac, nb_garage, nb_facade, nb_sdb, date_mise_en_vente, id_client,
        id_catsituation, id_catetat, id_catcuisine
FROM bien b
WHERE id_catbien = (select ID_CATBIEN
                    from categorie_bien
                    where description = 'Château')
WITH CHECK OPTION;

-- INSERT 1
INSERT INTO chateau (id_bien, id_catbien, rue, numero, localite, code_postal, description,
                    surface_habitable, surface_jardin, nb_pav, nb_chac, nb_garage, nb_facade, nb_sdb,
                    date_mise_en_vente, id_client, id_catsituation, id_catetat, id_catcuisine)
VALUES (777, 1, 'rue des trois lascars', 45, 'Liège', 4000, 'Un magnifique château au cœur de Liège',
        450, 2300, 16, 9, 4, 4, 3, TO_DATE('24/01/2013','DD/MM/YYYY'), 19, 6, 4, 3);

-- INSERT 2
INSERT INTO GERER (ID_BIEN, ID_VENDEUR)
VALUES (777, 4);

-- QUERY CHECK
select * from chateau;

8.
CREATE VIEW biens_sold_by_Brudel
AS
SELECT rue || ' ' || numero || ', ' || code_postal || ' ' || localite AS adresse
FROM bien
WHERE id_bien = ANY (SELECT id_bien
        FROM offre
        WHERE id_candidat = (select ID_CANDIDAT
                    from CANDIDAT
                    where nom = 'Delhez' and prenom = 'Bruno'))
WITH READ ONLY;

-- QUERY CHECK
select * from biens_sold_by_Brudel;

9.
CREATE VIEW biens_en_vente AS
SELECT *
FROM BIEN
where id_bien != ALL (select ID_BIEN
                 from OFFRE
                 where statut = 'A')
WITH READ ONLY;

-- QUERY CHECK
SELECT * FROM biens_en_vente;

10.
-- Je ne sais pas si on ne doit pas afficher les biens dont il n'y a pas de prix_actuel

CREATE VIEW affiche_bien
AS
SELECT b.id_bien as NumBien,
        localite || ' (' || code_postal || ')' as Localité,
        (SELECT MIN(o.montant)
        from OFFRE o
        WHERE o.id_bien = b.id_bien) as Prix_actuel,
        (SELECT ce.DESCRIPTION
        FROM CATEGORIE_ETAT ce
        WHERE ce.ID_CATETAT = b.ID_CATETAT) as Etat,
        (SELECT cs.description
        FROM CATEGORIE_SITUATION cs
        WHERE cs.ID_CATSITUATION = b.ID_CATSITUATION) as Situation,
        (SELECT cb.description
        FROM categorie_bien cb
        WHERE cb.id_catbien = b.ID_CATBIEN) as TypeBien,
        nb_chac,
        nb_sdb,
        nb_facade
FROM bien b
WITH READ ONLY;

-- QUERY CHECK
select * from affiche_bien;