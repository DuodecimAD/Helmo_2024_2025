1.
SELECT c.nom || ' ' || c.prenom as client, cb.description, b.date_mise_en_vente,
CASE
    WHEN b.nb_sdb = 1 AND b.date_mise_en_vente < ADD_MONTHS(SYSDATE, -12) THEN 'Possibilité de négocier'
    WHEN b.nb_sdb > 1 AND b.date_mise_en_vente < ADD_MONTHS(SYSDATE, -12) THEN 'Bien luxueux - Possibilité de négocier'
    WHEN b.date_mise_en_vente > ADD_MONTHS(SYSDATE, -3) THEN 'Nouveauté ! Bien en vente depuis peu'
    ELSE 'en vente'
    END AS message

FROM client c
JOIN bien b ON c.id_client = b.id_client
JOIN categorie_bien cb ON b.id_catbien = cb.id_catbien
WHERE cb.description IN ('Villa', 'Maison', 'Bungalow', 'Château');

2.
SELECT b.id_bien,
        b.rue || ' - ' || b.localite as adresse,
        b.description
FROM bien b
JOIN categorie_bien cb ON b.id_catbien = cb.id_catbien
WHERE cb.description = 'Maison'

INTERSECT

SELECT o.id_bien,
        b.rue || ' - ' || b.localite as adresse,
        b.description
FROM offre o
JOIN candidat c ON o.id_candidat = c.id_candidat
JOIN bien b ON o.id_bien = b.id_bien
WHERE c.localite IN('Liège', 'Spa', 'Verviers')

3.
SELECT TO_CHAR(m.date_message, 'MM-YYYY') as mois, m.id_message, count(*) as nbvendeurs
FROM message m
JOIN alerter a ON a.id_message = m.id_message
WHERE a.statut = 'N'
GROUP BY TO_CHAR(m.date_message, 'MM-YYYY'), m.id_message
HAVING count(*) > 1
ORDER BY count(*) ASC;

4.
SELECT SUBSTR(c.prenom, 1, 1) || '. ' || c.nom as , c.telephone
FROM candidat c
WHERE c.id_candidat = ANY (SELECT o.id_candidat
FROM offre o
WHERE o.montant < 150000 AND o.date_offre > TO_DATE('01/08/2012', 'DD/MM/YYYY'));


5.
SELECT cb.description, count(*) as nb_offres
FROM categorie_bien cb
JOIN bien b ON cb.id_catbien = b.id_catbien
JOIN offre o ON b.id_bien = o.id_bien
GROUP BY cb.description
ORDER BY cb.description;



6.
/*
En utilisant les requêtes imbriquées et sans utiliser de jointure, afficher
l’identifiant, la rue et les 50 premiers caractères de la description des
biens pour lesquels il n’y a pas d’offre postérieure au 15 septembre 2012 qui
soit refusée. Pour indiquer que la description est incomplète, on ajoutera 3
petits points (...) à la fin de la chaîne de caractères tronquée.
*/

7.
/*
Affichez l’identifiant, la localité, le code postal et le type de tous les
biens mis en vente avant 2015. Pour le type, on affichera soit « Bien
extraordinaire », soit « Pour les bricoleurs», soit « A voir absolument » en
fonction des conditions suivantes :

La mention « Bien extraordinaire » sera affichée pour les « Châteaux », «
Biens exceptionnels » et « Maisons de maître », mais seulement si ces biens
sont en « Excellent état » ou ont été « Remis à neuf ». La mention « Pour
les bricoleurs » sera affichée pour les biens qui sont dans un état « A
rafraîchir » ou « A rénover ». La mention « A voir absolument » sera affichée
pour tous les autres biens.
*/

8.
/*
En utilisant un opérateur ensembliste, afficher l'adresse (rue et localité)
et la catégorie de bien des biens des catégories 'Maison', 'Maison de
maître', 'Fermette' ou 'Bungalow' qui n'ont fait l’objet d’aucune offre d'un
montant supérieur à 150.000€.
*/

9.
/*
On veut afficher le nombre de messages lus par les vendeurs pour autant
que ce nombre soit strictement supérieur à 3. On se limitera aux vendeurs
dont le numéro de téléphone est un numéro de gsm (préfixe de 4 chiffres
commençant par '04' et suivi d'un '/'). Pour ces vendeurs, on affichera leur
pseudo et le nombre de messages qu'ils ont lu. Le résultat sera trié par
ordre décroissant du nombre de messages lus.
*/
SELECT v.prenom || ' ' || v.nom as pseudo, count(*) as nbMessageLus
FROM message m
JOIN alerter a ON m.id_message = a.id_message
JOIN vendeur v ON a.id_vendeur = v.id_vendeur
WHERE a.statut = 'L' and v.telephone LIKE '04__/%'
group by v.prenom, v.nom
HAVING count(*) > 3
ORDER BY count(*) DESC

10.
/*
En utilisant les requêtes imbriquées et sans utiliser de jointure, afficher
l’identifiant, la rue et les 50 premiers caractères de la description des
biens pour lesquels il n’y a pas d’offre postérieure au 15 septembre 2012 qui
soit refusée. Pour indiquer que la description est incomplète, on ajoutera 3
petits points (...) à la fin de la chaîne de caractères tronquée.
*/
