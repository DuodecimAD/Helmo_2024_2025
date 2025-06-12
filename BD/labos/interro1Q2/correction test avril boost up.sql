CREATE TRIGGER VillaFacadesSdb ON Bien
AFTER INSERT, UPDATE
AS
BEGIN
	
	--optimisation
	IF NOT UPDATE(nb_facade) AND NOT UPDATE(id_catbien) AND NOT UPDATE(nb_sdb)
    BEGIN
        RETURN
    END


	--récupérer les données
	DECLARE @nbFacades NUMERIC(1,0)
    DECLARE @nbSdb NUMERIC(2,0)

	--déclarer le curseur
	DECLARE crsr_biens CURSOR FOR
   		SELECT i.nb_facade, i.nb_sdb
   		FROM INSERTED i
   		JOIN CATEGORIE_BIEN cb ON i.id_catbien = cb.id_catbien
   		WHERE cb.description = 'Villa'

	--ouvrir le curseur
	OPEN crsr_biens
	-- assigner les valeurs de la première aux variables 
    FETCH crsr_biens INTO @nbFacades, @nbSdb

	WHILE @@fetch_status = 0
	BEGIN
		-- si la condition est vraie -> arret du trigger
		-- si le nbre de facade n'est pas 4 
		-- si pas de sdb 
		IF @nbFacades <> 4 OR @nbSdb < 1
		BEGIN
			--message erreur 
			RAISERROR('Une villa doit avoir 4 façades et au moins une salle de bain',7,1)
			-- annulation des insert/update
            ROLLBACK TRANSACTION
			--arret du trigger
            RETURN
		END
		-- assigner les valeurs de la ligne suivante aux variables 
		FETCH crsr_biens INTO @nbFacades, @nbSdb
	END
 
	CLOSE crsr_biens
    DEALLOCATE crsr_biens 

END


JEU DE TEST



---------------
SELECT v.prenom || ' ' || v.nom as Vendeur, SUM(b.nb_facade) as Total_facades
FROM vendeur v
JOIN gerer g ON v.id_vendeur = g.id_vendeur
JOIN bien b ON g.id_bien = b.id_bien
WHERE v.telephone LIKE '0474%' OR v.telephone LIKE '0475%'
GROUP BY v.prenom || ' ' || v.nom
HAVING SUM(b.nb_facade) > 4
ORDER BY SUM(b.nb_facade) DESC

--------------
SELECT v.nom || ' ' || v.prenom || '(' || v.pseudo || ')' AS vendeur,
        cb.description AS catégorie,
        COUNT(g.id_bien) AS nombrebiens
FROM vendeur v
LEFT JOIN gerer g ON v.id_vendeur = g.id_vendeur
LEFT JOIN bien b ON g.id_bien = b.id_bien
LEFT JOIN categorie_bien cb ON b.id_catbien = cb.id_catbien
GROUP BY v.nom || ' ' || v.prenom || '(' || v.pseudo || ')', cb.description
ORDER BY vendeur