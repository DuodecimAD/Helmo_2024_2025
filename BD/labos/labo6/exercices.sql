1.
CREATE TRIGGER date_offre_posterieure_date_vente ON offre
AFTER INSERT
AS
BEGIN
-- declaring variables
DECLARE @dateOffre SMALLDATETIME
DECLARE @idBien INTEGER
DECLARE @dateMiseVente SMALLDATETIME

-- initializing variables
	SELECT @idBien = id_bien, @dateOffre = date_offre
	FROM INSERTED

	SELECT @dateMiseVente = date_mise_en_vente
	FROM bien
	WHERE id_bien = @idBien

-- comparing dates
	IF @dateOffre < @dateMiseVente
	BEGIN
		RAISERROR('[date_offre_posterieure_date_vente] La date d''une offre pour un bien ne peut $etre  antérieur à la base de mise en vente du bien', 7, 1)
		ROLLBACK TRANSACTION
		RETURN
	END

END

----CONFIRMATION----
--commit
INSERT INTO Offre(id_offre, montant, date_offre, statut, id_candidat, id_bien)
VALUES (21,152000,CONVERT(smalldatetime, '15/10/2012', 103),'A', 8,29);
--error
INSERT INTO Offre(id_offre, montant, date_offre, statut, id_candidat, id_bien)
VALUES (22,152000,CONVERT(smalldatetime, '15/10/2020', 103),'A', 8,29);

2.
CREATE TRIGGER max_3_candidats_per_offer ON offre
AFTER INSERT
AS
BEGIN
-- declaring variables
DECLARE @idCandidat INTEGER
DECLARE @nbOffres INTEGER

-- initializing variables
	SELECT @idCandidat = id_candidat
	FROM INSERTED

	SELECT @nbOffres = COUNT(statut)
	FROM offre
	WHERE id_candidat = @idCandidat AND (statut = 'I' OR statut = 'E')

-- comparing dates
	IF @nbOffres > 3
	BEGIN
		RAISERROR('[max_3_candidats_per_offer] Le candidat ne peut pas avoir plus de 3 offres actives', 7, 1)
		ROLLBACK TRANSACTION
		RETURN
	END

END

----CONFIRMATION----
--commit
INSERT INTO Offre(id_offre, montant, date_offre, statut, id_candidat, id_bien)
VALUES (21,152000,CONVERT(smalldatetime, '15/10/2012', 103),'I', 2,4);
INSERT INTO Offre(id_offre, montant, date_offre, statut, id_candidat, id_bien)
VALUES (22,152000,CONVERT(smalldatetime, '15/10/2012', 103),'I', 2,6);
INSERT INTO Offre(id_offre, montant, date_offre, statut, id_candidat, id_bien)
VALUES (23,152000,CONVERT(smalldatetime, '15/10/2012', 103),'I', 2,7);
--Si 0 de base : error
INSERT INTO Offre(id_offre, montant, date_offre, statut, id_candidat, id_bien)
VALUES (24,152000,CONVERT(smalldatetime, '15/10/2012', 103),'I', 2,10);

3.

CREATE TRIGGER max_10_percent_of_bien_per_offer ON offre
AFTER INSERT, UPDATE
AS
BEGIN


IF NOT UPDATE(montant)
	RETURN

-- declaring variables

DECLARE @idBien		INTEGER
DECLARE @newMontant NUMERIC(10,2)
DECLARE @oldMontant NUMERIC(10,2)

DECLARE crsrNewMontants CURSOR
FOR
	SELECT id_bien, montant
	FROM INSERTED

OPEN crsrNewMontants
FETCH crsrNewMontants INTO @idBien, @newMontant

WHILE @@fetch_status=0 --  fetch a réussi, non-réussi = nb négatif
	BEGIN
		SELECT @oldMontant = MIN(montant)
		FROM historique_prix
		WHERE id_bien = @idBien

		IF @newMontant > (@oldMontant * 1.1)
		BEGIN
			RAISERROR('[max_10_percent_of_bien_per_offer] Le montant d’une offre ne peut pas être supérieur de plus de 10% au prix du bien concerné.', 7, 1)
			ROLLBACK TRANSACTION
			RETURN
		END

		FETCH crsrNewMontants INTO @idBien, @newMontant
	END
	CLOSE crsrNewMontants
	DEALLOCATE crsrNewMontants
END


----CONFIRMATION----
INSERT INTO Offre(id_offre, montant, date_offre, statut, id_candidat, id_bien)
VALUES (21,200000,CONVERT(smalldatetime, '15/10/2012', 103),'I', 2,4);
INSERT INTO Offre(id_offre, montant, date_offre, statut, id_candidat, id_bien)
VALUES (22,500000,CONVERT(smalldatetime, '15/10/2012', 103),'I', 2,4);



SELECT COUNT(statut)
	FROM offre
	WHERE id_candidat = 2 AND (statut = 'I' OR statut = 'E')

DELETE FROM offre WHERE id_offre = 21

select * from offre

drop trigger max_3_candidats_per_offer


4.
CREATE TRIGGER forbidenHigherBienPrice ON historique_prix
AFTER INSERT, UPDATE
AS
BEGIN

IF NOT UPDATE(montant) RETURN

	-- declaring variables
	DECLARE @idBien		INTEGER
	DECLARE @newMontant NUMERIC(10,2)
	DECLARE @oldMontant NUMERIC(10,2)

	-- declaring variables
	DECLARE crsrNewMontants CURSOR
	FOR
		SELECT id_bien, montant
		FROM INSERTED

	OPEN crsrNewMontants
	FETCH crsrNewMontants INTO @idBien, @newMontant

	WHILE @@fetch_status = 0 --  fetch a réussi, non-réussi = nb négatif
		BEGIN
			IF EXISTS (select * from deleted)
				BEGIN
					SELECT @oldMontant = montant
					FROM deleted
				END
			ELSE
				BEGIN
					SELECT @oldMontant = MIN(montant)
					FROM historique_prix
					WHERE montant != @prix_actuel AND id_bien = @idBien
				END

			print @newMontant
			print @oldMontant

			IF @newMontant > @oldMontant
			BEGIN
				RAISERROR('[forbidenHigherBienPrice] Vous ne pouvez pas augmenter le montant d''un bien dont le montant a déjà été fourni.', 7, 1)
				ROLLBACK TRANSACTION
				RETURN
			END

			FETCH crsrNewMontants INTO @idBien, @newMontant
		END

	CLOSE crsrNewMontants
	DEALLOCATE crsrNewMontants
END


----CONFIRMATION----

SELECT id_prix, montant
FROM historique_prix
WHERE id_bien = 3

UPDATE historique_prix
SET montant = 150000
WHERE id_prix = 91

INSERT INTO historique_prix(id_prix, montant, date_prix, id_bien)
VALUES(92, 150002, CONVERT(smalldatetime, '17/03/2025', 103), 3)




DELETE FROM historique_prix WHERE id_prix = 91

select * from offre

drop trigger forbidenHigherBienPrice

SELECT MIN(montant)
FROM historique_prix
WHERE id_bien = 3


5.
CREATE TRIGGER newBienToLowestVendeur ON bien
AFTER INSERT
AS
BEGIN

	-- declaring variables
	DECLARE @idBien		INTEGER
	DECLARE @idLowestVendeur	INTEGER

	SELECT @idBien = id_bien
	FROM INSERTED

	SELECT TOP 1 @idLowestVendeur = v.id_vendeur
    FROM Vendeur v
    LEFT JOIN Gerer g ON v.id_vendeur = g.id_vendeur
    WHERE NOT EXISTS (
      SELECT 1 FROM offre o
      WHERE o.id_bien = g.id_bien AND o.statut = 'A'
    )
    GROUP BY v.id_vendeur
    ORDER BY COUNT(g.id_bien)

    -- insert
	INSERT INTO Gerer (id_bien, id_vendeur)
	VALUES (@idBien, @idLowestVendeur)

	PRINT '[newBienToLowestVendeur] Le bien ' + CAST(@idbien AS VARCHAR(10)) + ' a été attribué au vendeur ' + CAST(@idLowestVendeur AS VARCHAR(10))

END

----CONFIRMATION----
INSERT INTO bien(id_bien, rue, numero, localite, code_postal,
description, surface_habitable, surface_jardin, nb_pav, nb_chac,
nb_garage, nb_facade, nb_sdb, date_mise_en_vente, id_client,
id_catsituation, id_catetat, id_catcuisine, id_catbien)
VALUES (990,'rue du bosquet','8','Herve',4650,
'Grande maison bourgeoise à rénover de +- 200 m² habitable donnant accès deux rues
calmes. Maison jouissant d''une excellente situation. Possibilité de garage.',
200,650,3,6,0,4,2, CONVERT(smalldatetime, '12/10/2012', 103),15,3,5, 5,3);


-- correction prof :
SELECT TOP 1 @idVendeur = v.id_vendeur 
FROM Vendeur v 
LEFT JOIN Gerer g ON v.id_vendeur = g.id_vendeur AND 
g.id_bien NOT IN (SELECT id_bien FROM Offre WHERE statut = 'A') 
GROUP BY v.id_vendeur 
ORDER BY COUNT(g.id_bien) ASC

6.
-- prof --
CREATE TRIGGER pas_pseudo_dans_message ON message  
   AFTER INSERT
AS 
BEGIN
	DECLARE @pseudo		VARCHAR(10)
	DECLARE @idmessage   INTEGER
	DECLARE @texte		 VARCHAR(250)
	DECLARE @pos		 INTEGER	

	
	SELECT @idmessage = id_message, @texte=texte
	FROM INSERTED
	
	DECLARE vendeursCurseur CURSOR FOR
		SELECT pseudo
		FROM vendeur

	OPEN vendeursCurseur
	FETCH vendeursCurseur INTO @pseudo
	
	WHILE @@fetch_status = 0
	BEGIN
		SELECT @pos = CHARINDEX(@pseudo, @texte)
		IF  @pos > 0
		BEGIN
			SELECT @texte = REPLACE(@texte , @pseudo, '*****')
		END
		FETCH vendeursCurseur INTO @pseudo
	END
	
	UPDATE message
	SET texte = @texte
	WHERE id_message = @idmessage
	
	CLOSE vendeursCurseur
	DEALLOCATE vendeursCurseur
	
END

7.
CREATE TABLE Audit (
    id_audit    NUMERIC(10) NOT NULL PRIMARY KEY,
    id_bien     NUMERIC(10) NOT NULL,
    adresse     VARCHAR(250) NOT NULL,
    type_bien   VARCHAR(50) NOT NULL,
    date_action SMALLDATETIME NOT NULL,
    message     VARCHAR(500) NOT NULL,
    FOREIGN KEY (id_bien) REFERENCES Bien(id_bien) -- ?
);


7.1
CREATE TRIGGER trg_AuditBienAfterInsert ON Bien
    AFTER INSERT
    AS
    BEGIN

        DECLARE @newIdAudit INT
        DECLARE @idBien     VARCHAR(10)
        DECLARE @adresse    VARCHAR(100)
        DECLARE @typBien    VARCHAR(25)
        DECLARE @message    VARCHAR(250)
        DECLARE @usernameClient VARCHAR(100)

        DECLARE CRSinsertedBiens CURSOR
        FOR
        SELECT i.id_bien,
               i.rue+', '+CAST(i.numero AS VARCHAR(10))+' - '+CAST(i.code_postal AS VARCHAR(10))+' '+i.localite,
               (SELECT cb.description FROM Categorie_bien cb WHERE cb.id_catbien = i.id_catbien),
               (SELECT c.prenom+' '+c.nom FROM client c WHERE c.id_client = i.id_client)
        FROM INSERTED i
        OPEN CRSinsertedBiens

        FETCH CRSinsertedBiens INTO @idBien, @adresse, @typBien, @usernameClient

        WHILE @@fetch_status = 0
        BEGIN

            SELECT @newIdAudit = ISNULL(MAX(id_audit), 0)+1
            FROM Audit

            SELECT @message = 'Bien mis en ventre par '+@usernameClient

            INSERT INTO Audit (id_audit, id_bien, adresse, type_bien, date_action, message)
            VALUES (@newIdAudit, @idBien, @adresse, @typBien, GETDATE(), @message);

            PRINT '[trg_AuditBienAfterInsert] new audit insert with id_audit : '+ CAST(@newIdAudit AS VARCHAR(10))

            FETCH CRSinsertedBiens INTO @idBien, @adresse, @typBien, @usernameClient
        end

        CLOSE CRSinsertedBiens
        DEALLOCATE CRSinsertedBiens

    end

----CONFIRMATION----
INSERT INTO bien(id_bien, rue, numero, localite, code_postal,
description, surface_habitable, surface_jardin, nb_pav, nb_chac,
nb_garage, nb_facade, nb_sdb, date_mise_en_vente, id_client,
id_catsituation, id_catetat, id_catcuisine, id_catbien)
VALUES (990,'rue du bosquet','8','Herve',4650,
'Grande maison bourgeoise à rénover de +- 200 m² habitable donnant accès deux rues
calmes. Maison jouissant d''une excellente situation. Possibilité de garage.',
200,650,3,6,0,4,2,
CONVERT(smalldatetime, '12/10/2012', 103),15,3,5, 5,3);

7.2
CREATE TRIGGER trg_AuditBienRefusOffre ON Offre
    AFTER UPDATE
    AS
    BEGIN

IF EXISTS(SELECT statut FROM INSERTED WHERE statut <> 'R') RETURN

        DECLARE @newIdAudit INT
        DECLARE @idBien     VARCHAR(10)
        DECLARE @adresse    VARCHAR(100)
        DECLARE @typBien    VARCHAR(25)
        DECLARE @message    VARCHAR(250)
        DECLARE @usernameClient   VARCHAR(100)
        DECLARE @usernameCandidat VARCHAR(100)
        DECLARE @minMontant INT
        DECLARE @priceBien  INT


        SELECT @idBien = i.id_bien,
               @adresse = b.rue+', '+CAST(b.numero AS VARCHAR(10))+' - '+CAST(b.code_postal AS VARCHAR(10))+' '+b.localite,
               @typBien=  (SELECT cb.description FROM Categorie_bien cb WHERE cb.id_catbien = b.id_catbien),
               @usernameClient = (SELECT c.prenom+' '+c.nom FROM client c WHERE c.id_client = b.id_client),
               @usernameCandidat = (SELECT ca.prenom+' '+ca.nom FROM candidat ca WHERE i.id_candidat = ca.id_candidat),
               @minMontant = i.montant,
               @priceBien = (SELECT MIN(hp.montant) FROM Historique_prix hp WHERE b.id_bien = hp.id_bien)
        FROM INSERTED i
        JOIN Bien b ON i.id_bien = b.id_bien

        SELECT @newIdAudit = ISNULL(MAX(id_audit), 0)+1
        FROM Audit

        SELECT @message = 'Offre de '+CAST(@minMontant AS VARCHAR(10))+' € remise par '+@usernameCandidat+' refusée par le client '+@usernameClient+' (Prix : '+CAST(@priceBien AS VARCHAR(10))+')'

        INSERT INTO Audit (id_audit, id_bien, adresse, type_bien, date_action, message)
        VALUES (@newIdAudit, @idBien, @adresse, @typBien, GETDATE(), @message);

        PRINT '[trg_AuditBienRefusOffre] new audit insert with id_audit : '+ CAST(@newIdAudit AS VARCHAR(10))

    end

----CONFIRMATION----
INSERT INTO bien(id_bien, rue, numero, localite, code_postal,
description, surface_habitable, surface_jardin, nb_pav, nb_chac,
nb_garage, nb_facade, nb_sdb, date_mise_en_vente, id_client,
id_catsituation, id_catetat, id_catcuisine, id_catbien)
VALUES (990,'rue du bosquet','8','Herve',4650,
'Grande maison bourgeoise à rénover de +- 200 m² habitable donnant accès deux rues
calmes. Maison jouissant d''une excellente situation. Possibilité de garage.',
200,650,3,6,0,4,2,
CONVERT(smalldatetime, '12/10/2012', 103),15,3,5, 5,3);

INSERT INTO historique_prix(id_prix, montant, date_prix, id_bien)
VALUES (990,165000,CONVERT(smalldatetime, '08/09/2012', 103),990);

INSERT INTO Offre(id_offre, montant, date_offre, statut, id_candidat, id_bien)
VALUES (990,15000,CONVERT(smalldatetime, '15/10/2012', 103),'E', 8,990);

UPDATE Offre
SET statut = 'R'
WHERE id_offre = 990


7.3
-- a faire



7.4

CREATE TRIGGER trg_AuditBienAfterDelete ON Bien
    AFTER DELETE
    AS
    BEGIN

        DECLARE @newIdAudit INT
        DECLARE @idBien     VARCHAR(10)
        DECLARE @adresse    VARCHAR(100)
        DECLARE @typBien    VARCHAR(25)
        DECLARE @dateSince  SMALLDATETIME
        DECLARE @daysSince  INT
        DECLARE @message    VARCHAR(250)

        DECLARE CRSdeletedBiens CURSOR
        FOR
        SELECT d.id_bien,
               d.rue+', '+CAST(d.numero AS VARCHAR(10))+' - '+CAST(d.code_postal AS VARCHAR(10))+' '+d.localite,
               (SELECT cb.description FROM Categorie_bien cb WHERE cb.id_catbien = d.id_catbien),
               d.date_mise_en_vente
        FROM DELETED d
        OPEN CRSdeletedBiens

        FETCH CRSdeletedBiens INTO @idBien, @adresse, @typBien, @dateSince

        WHILE @@fetch_status = 0
        BEGIN
            PRINT 'id_bien : '+@idBien+ ', adresse : '+@adresse+', typeBien : '+@typBien+', date_mise_en_vente : '+CAST(@dateSince AS VARCHAR(50))

            SELECT @newIdAudit = ISNULL(MAX(id_audit), 0)+1
            FROM Audit
            PRINT 'New id_audit : '+CAST(@newIdAudit AS VARCHAR(10))

            SELECT @daysSince = DATEDIFF(DD, @dateSince, GETDATE())
            PRINT 'daysSince : '+CAST(@daysSince AS VARCHAR(10))

            SELECT @message = 'Bien supprimé après '+CAST(@daysSince AS VARCHAR(10))+' jours de mise en vente.'
            PRINT 'message : '+@message

            INSERT INTO Audit (id_audit, id_bien, adresse, type_bien, date_action, message)
            VALUES (@newIdAudit, @idBien, @adresse, @typBien, GETDATE(), @message);

            PRINT '[auditMessageAfterBienDelete] bien '+@idBien+' a été supprimé. Ajout d''un message dans la table audit avec l''id : '+CAST(@newIdAudit AS VARCHAR(10))

            FETCH CRSdeletedBiens INTO @idBien, @adresse, @typBien, @dateSince
        end

        CLOSE CRSdeletedBiens
        DEALLOCATE CRSdeletedBiens

    end

----CONFIRMATION----
INSERT INTO bien(id_bien, rue, numero, localite, code_postal,
description, surface_habitable, surface_jardin, nb_pav, nb_chac,
nb_garage, nb_facade, nb_sdb, date_mise_en_vente, id_client,
id_catsituation, id_catetat, id_catcuisine, id_catbien)
VALUES (990,'rue du bosquet','8','Herve',4650,
'Grande maison bourgeoise à rénover de +- 200 m² habitable donnant accès deux rues
calmes. Maison jouissant d''une excellente situation. Possibilité de garage.',
200,650,3,6,0,4,2,
CONVERT(smalldatetime, '12/10/2012', 103),15,3,5, 5,3);



DELETE from Bien where id_bien = 990

drop TRIGGER trg_AuditBienAfterDelete

SELECT sm.definition
FROM sys.sql_modules sm
JOIN sys.objects o ON sm.object_id = o.object_id
WHERE o.type = 'TR' AND o.name = 'trg_AuditBienAfterDelete';

SELECT *
from Bien
ORDER BY id_bien desc

SELECT *
FROM audit