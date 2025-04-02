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

---- TOFIX -----
CREATE TRIGGER max_10_percent_of_bien_per_offer ON offre
AFTER INSERT
AS
BEGIN
-- declaring variables

DECLARE @idBien INTEGER
DECLARE @newMontant INTEGER
DECLARE @oldMontant INT

-- initializing variables
	SELECT @newMontant = montant
	FROM INSERTED

	SELECT @oldMontant = montant
	FROM offre
	WHERE id_bien = @idBien

-- comparing dates
	IF @newMontant > (@oldMontant * 1.1)
	BEGIN
		RAISERROR('[max_10_percent_of_bien_per_offer] Le montant d’une offre ne peut pas être supérieur de plus de 10% au prix du bien concerné.', 7, 1)
		ROLLBACK TRANSACTION
		RETURN
	END

END

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


---- UPDATE VERSION ----
CREATE TRIGGER max_10_percent_of_bien_per_offer ON offre
AFTER INSERT, UPDATE
AS
BEGIN
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
END


CLOSE crsrNewMontants 

DEALLOCATE crsrNewMontants




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