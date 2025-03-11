1)
UPDATE vin
SET degre = degre * 1.1
WHERE region = 'Bourgogne';

2)
UPDATE vin
SET qualite = 'A'
WHERE region = 'Bourgogne' AND milesime BETWEEN 1970 AND 1990;

3)
UPDATE vin
SET qualite 'B'
WHERE milesime < 1980;

UPDATE vin
SET qualite 'C'
WHERE milesime >= 1980;

4)
UPDATE vin
SET milesime = milesime+5
WHERE cru LIKE '%A%';