CREATE TABLE Zone (
   zid INT AUTO_INCREMENT,
   nom VARCHAR(50) NOT NULL,
   description VARCHAR(150) NOT NULL,
   PRIMARY KEY(zid)
);

CREATE TABLE Categorie (
   cid INT AUTO_INCREMENT,
   intitule VARCHAR(50) NOT NULL,
   PRIMARY KEY(cid)
);

CREATE TABLE Emplacement (
   eid INT AUTO_INCREMENT,
   code VARCHAR(50) NOT NULL,
   zid INT NOT NULL,
   PRIMARY KEY(eid),
   UNIQUE(code),
   FOREIGN KEY (zid) REFERENCES Zone(zid)
);

CREATE TABLE Brocanteur (
   bid INT AUTO_INCREMENT,
   nom VARCHAR(50) NOT NULL,
   prenom VARCHAR(50) NOT NULL,
   courriel VARCHAR(150) NOT NULL,
   mot_passe VARCHAR(255) NOT NULL,
   photo VARCHAR(100),
   description VARCHAR(500) NOT NULL,
   visible BOOLEAN DEFAULT 0,
   est_administrateur BOOLEAN DEFAULT 0,
   eid INT,
   PRIMARY KEY(bid),
   UNIQUE(courriel),
   FOREIGN KEY(eid) REFERENCES Emplacement(eid)
);

CREATE TABLE Objet (
   oid INT AUTO_INCREMENT,
   intitule VARCHAR(100) NOT NULL,
   image VARCHAR(150),
   description VARCHAR(500) NOT NULL,
   cid INT NOT NULL,
   bid INT NOT NULL,
   PRIMARY KEY(oid),
   FOREIGN KEY(cid) REFERENCES Categorie(cid),
   FOREIGN KEY(bid) REFERENCES Brocanteur(bid)
);

CREATE TABLE query_logs (
   id INT AUTO_INCREMENT PRIMARY KEY,
   query_text TEXT,
   executed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_zid ON Emplacement(zid);
CREATE INDEX idx_eid ON Brocanteur(eid);
CREATE INDEX idx_cid ON Objet(cid);
CREATE INDEX idx_bid ON Objet(bid);

-------------
-- INSERTS --
-------------

INSERT INTO Q240183.Zone (zid, nom, description) VALUES (1, 'Zone A', 'Hall principal');
INSERT INTO Q240183.Zone (zid, nom, description) VALUES (2, 'Zone B', 'Hall avant-gauche');
INSERT INTO Q240183.Zone (zid, nom, description) VALUES (3, 'Zone C', 'Hall arrière-gauche');
INSERT INTO Q240183.Zone (zid, nom, description) VALUES (4, 'Zone D', 'Hall avant-droit');
INSERT INTO Q240183.Zone (zid, nom, description) VALUES (5, 'Zone E', 'Hall arrière-droit');

INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (1, 'ZA-E1-001', 1);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (2, 'ZA-E1-002', 1);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (3, 'ZA-E1-003', 1);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (4, 'ZA-E1-004', 1);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (5, 'ZA-E1-005', 1);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (6, 'ZA-E1-006', 1);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (7, 'ZA-E1-007', 1);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (8, 'ZA-E1-008', 1);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (9, 'ZA-E1-009', 1);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (10, 'ZA-E1-010', 1);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (11, 'ZA-E1-011', 1);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (12, 'ZA-E1-012', 1);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (13, 'ZA-E1-013', 1);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (14, 'ZA-E1-014', 1);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (15, 'ZA-E1-015', 1);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (16, 'ZA-E1-016', 1);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (17, 'ZA-E1-017', 1);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (18, 'ZA-E1-018', 1);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (19, 'ZA-E1-019', 1);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (20, 'ZA-E1-020', 1);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (21, 'ZB-E1-001', 2);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (22, 'ZB-E1-002', 2);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (23, 'ZB-E1-003', 2);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (24, 'ZB-E1-004', 2);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (25, 'ZB-E1-005', 2);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (26, 'ZB-E1-006', 2);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (27, 'ZB-E1-007', 2);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (28, 'ZB-E1-008', 2);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (29, 'ZB-E1-009', 2);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (30, 'ZB-E1-010', 2);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (31, 'ZC-E1-001', 3);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (32, 'ZC-E1-002', 3);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (33, 'ZC-E1-003', 3);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (34, 'ZC-E1-004', 3);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (35, 'ZC-E1-005', 3);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (36, 'ZC-E1-006', 3);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (37, 'ZC-E1-007', 3);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (38, 'ZC-E1-008', 3);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (39, 'ZC-E1-009', 3);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (40, 'ZC-E1-010', 3);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (41, 'ZD-E1-001', 4);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (42, 'ZD-E1-002', 4);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (43, 'ZD-E1-003', 4);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (44, 'ZD-E1-004', 4);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (45, 'ZD-E1-005', 4);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (46, 'ZD-E1-006', 4);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (47, 'ZD-E1-007', 4);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (48, 'ZD-E1-008', 4);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (49, 'ZD-E1-009', 4);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (50, 'ZD-E1-010', 4);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (51, 'ZE-E1-001', 5);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (52, 'ZE-E1-002', 5);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (53, 'ZE-E1-003', 5);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (54, 'ZE-E1-004', 5);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (55, 'ZE-E1-005', 5);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (56, 'ZE-E1-006', 5);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (57, 'ZE-E1-007', 5);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (58, 'ZE-E1-008', 5);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (59, 'ZE-E1-009', 5);
INSERT INTO Q240183.Emplacement (eid, code, zid) VALUES (60, 'ZE-E1-010', 5);

INSERT INTO Q240183.Categorie (cid, intitule) VALUES (1, 'Drôle');
INSERT INTO Q240183.Categorie (cid, intitule) VALUES (2, 'Légendaire');
INSERT INTO Q240183.Categorie (cid, intitule) VALUES (3, 'Mythique');
INSERT INTO Q240183.Categorie (cid, intitule) VALUES (4, 'Normal');
INSERT INTO Q240183.Categorie (cid, intitule) VALUES (5, 'Rare');
INSERT INTO Q240183.Categorie (cid, intitule) VALUES (6, 'Vintage');

INSERT INTO Q240183.Brocanteur (nom, prenom, courriel, mot_passe, photo, description, visible, est_administrateur, eid, a_paye) VALUES (1, 'admin', 'admin', 'admin@admin.aa', 'Admin', 'uploads/admin_admin_20032025_ABCDE.jpg', 'Im the admin', 0, 1, null, 0);
INSERT INTO Q240183.Brocanteur (nom, prenom, courriel, mot_passe, photo, description, visible, est_administrateur, eid, a_paye) VALUES (2, 'Broc', 'Broc', 'broc@broc.aa', 'Broc', 'uploads/default_avatar.jpg', 'Je suis un brocanteur de test. J&#039;ai besoin de tester une description assez longue pour pouvoir déterminer si un petit bug d\'affichage traine. Au lieu de m&#039;attaquer à de de plus gros morceaux de code, je perds mon temps sur des détails que personne ne remarquera et encore moins augmentera ma côte finale. Mais au moins je serais fier de mon travail.', 1, 0, 3, 1);
INSERT INTO Q240183.Brocanteur (nom, prenom, courriel, mot_passe, photo, description, visible, est_administrateur, eid, a_paye) VALUES (3, 'test2', 'test2', 'test2@test2.aa', 'test2', 'uploads/default_avatar.jpg', 'test2', 1, 0, null, 0);
INSERT INTO Q240183.Brocanteur (nom, prenom, courriel, mot_passe, photo, description, visible, est_administrateur, eid, a_paye) VALUES (4, 'Nita', 'Nat', 'nn@nn.aa', 'Nita', 'uploads/nat_nita_25032025161738_O2pLd.jpg', 'Je m\'appelle Nat, j\'aime les PEZ.', 1, 0, 45, 1);
INSERT INTO Q240183.Brocanteur (nom, prenom, courriel, mot_passe, photo, description, visible, est_administrateur, eid, a_paye) VALUES (5, 'Louage', 'Julie', 'jl@jl.aa', 'Louage', 'uploads/julie_louage_25032025161738_f65i7.jpg', 'Hello, julie ici. J\'adore travailler dans le monde du marché au puces, et je m\'amuse énormément depuis que je me suis mise à la revente de dispenseurs de PEZ.', 1, 0, 57, 1);
INSERT INTO Q240183.Brocanteur (nom, prenom, courriel, mot_passe, photo, description, visible, est_administrateur, eid, a_paye) VALUES (6, 'Wamba', 'Tristan', 'tw@tw.aa', 'Wamba', 'uploads/tristan_wamba_25032025161738_WG12y.jpg', 'Je m\'appelle Tristan Wamba, c\'est ma première participation à un marché au puces.', 0, 0, 14, 1);
INSERT INTO Q240183.Brocanteur (nom, prenom, courriel, mot_passe, photo, description, visible, est_administrateur, eid, a_paye) VALUES (7, 'test6', 'test6', 'test6@test6.aa', 'test6', 'uploads/default_avatar.jpg', 'test6', 0, 0, null, 0);
INSERT INTO Q240183.Brocanteur (nom, prenom, courriel, mot_passe, photo, description, visible, est_administrateur, eid, a_paye) VALUES (11, 'Kim', 'Peter', 'pk@pk.aa', 'Kim', 'uploads/peter_kim_25032025161738_hGf5x.jpg', 'Profesionnel de la vente de seconde main depuis 20 ans.', 1, 0, 27, 1);
INSERT INTO Q240183.Brocanteur (nom, prenom, courriel, mot_passe, photo, description, visible, est_administrateur, eid, a_paye) VALUES (12, 'Petit', 'David', 'dp@dp.aa', 'Petit', 'uploads/david_petit_25032025161738_946k7.jpg', 'My name is David Petit. That\'s it. Mic drop.', 1, 0, null, 1);
INSERT INTO Q240183.Brocanteur (nom, prenom, courriel, mot_passe, photo, description, visible, est_administrateur, eid, a_paye) VALUES (13, 'Hammil', 'Mark', 'mh@mh.aa', 'Hammil', 'uploads/marc_hammil_23032025213604_Jg5cq.jpg', 'Star wars, pew pew.', 1, 0, null, 1);
INSERT INTO Q240183.Brocanteur (nom, prenom, courriel, mot_passe, photo, description, visible, est_administrateur, eid, a_paye) VALUES (14, 'hatar', 'Julius', 'jh@jh.aa', 'Hatar', 'uploads/julius_hatar_24032025212754_HulWX.jpg', 'Venez venez ...', 1, 0, null, 1);
INSERT INTO Q240183.Brocanteur (nom, prenom, courriel, mot_passe, photo, description, visible, est_administrateur, eid, a_paye) VALUES (15, 'Dogvi', 'Micha', 'md@md.aa', 'Dogvi', 'uploads/micha_dogvi_24032025211245_6XPiV.jpg', 'Never good at these.', 1, 0, null, 1);
INSERT INTO Q240183.Brocanteur (nom, prenom, courriel, mot_passe, photo, description, visible, est_administrateur, eid, a_paye) VALUES (17, 'McTay', 'Tommy', 'tm@tm.aa', 'McTay', 'uploads/tommy_mctay_25032025161738_faQVC.jpg', 'yeeeehhaaaa.', 1, 0, 40, 1);
INSERT INTO Q240183.Brocanteur (nom, prenom, courriel, mot_passe, photo, description, visible, est_administrateur, eid, a_paye) VALUES (18, 'Mighty', 'Jinny', 'jm@jm.aa', 'Mighty', 'uploads/jinny_mighty_24032025212027_HGvqn.jpg', 'Salut, je suis Jinny.', 1, 0, null, 1);
INSERT INTO Q240183.Brocanteur (nom, prenom, courriel, mot_passe, photo, description, visible, est_administrateur, eid, a_paye) VALUES (19, 'Hamilton', 'Hanna', 'hh@hh.aa', 'Hamilton', 'uploads/Hanna_Hamilton_26032025115227_FeE25.jpg', 'Yo, I\'m Hanna.', 1, 0, 17, 1);
INSERT INTO Q240183.Brocanteur (nom, prenom, courriel, mot_passe, photo, description, visible, est_administrateur, eid, a_paye) VALUES (20, 'Thompson', 'Milly', 'mt@mt.aa', 'Thompson', 'uploads/Milly_Thompson_29032025074112_bQ12P.jpg', 'Hello there, I come directly from Australia to participate in this event and sell tons of PEZ&#039;s dispensers. I hope to see many of you there, cya.', 1, 0, 35, 1);
INSERT INTO Q240183.Brocanteur (nom, prenom, courriel, mot_passe, photo, description, visible, est_administrateur, eid, a_paye) VALUES (22, 'Dallas', 'Korben', 'kd@kd.aa', 'Dallas', 'uploads/Korben_Dallas_30032025103109_fNTGM.jpg', 'The 5th Element is a must-watch. All my PEZ dispensers are derived from the movie. Enjoy.', 1, 0, null, 0);

INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (1, 'Donkey Kong', 'uploads/MjGws7KLUr_28032025192540.jpg', 'Donkey Kong', 2, 2);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (2, 'Grumpy Bear', 'uploads/klmxBkPM68_27032025215845.jpg', 'Le dispenseur de PEZ Grumpy Bear fait partie de la serie "Les Bisounours" sortie en 1993.', 4, 2);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (3, 'Red Bird', 'uploads/8koxBkPM68_27032025215828.jpg', 'Le dispenseur de PEZ Red Bird fait partie de la serie "Angry Birds" sortie en 2019.', 4, 2);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (4, 'Black Bird', 'uploads/123xBkPM68_27032025215825.jpg', 'Le dispenseur de PEZ Black Bird fait partie de la serie "Angry Birds" sortie en 2019.', 4, 2);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (5, 'Meat Ball', 'uploads/abyxBkPM68_27032025215821.jpg', 'Le dispenseur de PEZ Meat Ball fait partie de la serie "..." sortie en 2019.', 4, 2);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (6, 'Sweet Bear', 'uploads/AHOxBkPM68_27032025215823.jpg', 'Le dispenseur de PEZ Sweet Bear fait partie de la serie &quot;Les Bisounours&quot; sortie en 1993.', 4, 2);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (7, 'Good Luck Bear', 'uploads/ehz4rI2UVB_27032025220028.jpg', 'Le dispenseur de PEZ Sweet Bear fait partie de la serie &quot;Les Bisounours&quot; sortie en 1993.', 4, 2);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (8, 'Cheer Bear', 'uploads/ZAw4nVNKsF_28032025173132.jpg', 'Le dispenseur de PEZ Cheer Bear fait partie de la serie &quot;Les Bisounours&quot; sortie en 1994.', 6, 2);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (9, 'Sleepy Garfield', 'uploads/kcJ0e5THEm_27032025221332.jpg', 'Sleepy Garfield', 1, 2);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (10, 'The Grinch', 'uploads/uM3QY0H5kb_27032025221505.jpg', 'The Grinch', 6, 2);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (11, 'Masha', 'uploads/30OZcFGmUu_28032025110702.jpg', 'Masha', 6, 6);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (12, 'Kermit', 'uploads/TbKDdBFCyi_28032025185149.jpg', 'Kermit', 3, 2);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (14, 'Mario', 'uploads/WZTNmv8jEJ_28032025195110.jpg', 'Mario', 3, 2);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (15, 'Wall-e', 'uploads/cMIQF7ZoUq_30032025143931.jpg', 'Test3', 1, 2);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (16, 'Pluto', 'uploads/g5k9pTeIWD_30032025104926.jpg', 'Pluto est le chien de Mickey Mouse. Sa première apparition date d&#039;avant votre naissance.', 6, 6);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (17, 'Donald', 'uploads/q2SQwza6H5_30032025142709.jpg', 'Donald', 1, 2);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (18, 'Peter Pan', 'uploads/HE36aKyDkd_30032025142803.jpg', 'Peter Pan, hideous', 6, 2);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (19, 'Cendrillon', 'uploads/JvCSNhmU4M_30032025142937.jpg', 'Objet 3 de catégorie 1', 3, 2);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (20, 'Belle', 'uploads/Z0cIaMWu4N_30032025143003.jpg', 'Objet 1 de catégorie 2', 2, 2);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (21, 'Lampo', 'uploads/w138kiEufj_30032025143026.jpg', 'Objet 2 de catégorie 2', 2, 2);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (22, 'Toad', 'uploads/SgqjpeyI7w_30032025143052.jpg', 'Objet 3 de catégorie 2', 2, 2);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (23, 'Yoshi', 'uploads/kc4Y9Sgt7C_30032025143110.jpg', 'Objet 1 de catégorie 3', 3, 2);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (24, 'Troll Fille', 'uploads/MkXPOdWHVr_30032025143133.jpg', 'Objet 2 de catégorie 3', 3, 2);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (25, 'Troll Dude', 'uploads/X5y6JBU9Mi_30032025143157.jpg', 'Objet 3 de catégorie 3', 3, 2);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (26, 'Penguin A', 'uploads/vGI6UmyC73_30032025143220.jpg', 'Objet 1 de catégorie 4', 4, 2);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (27, 'Penguin B', 'uploads/h2M4KwzStn_30032025143259.jpg', 'Objet 2 de catégorie 4', 4, 2);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (28, 'Penguin C', 'uploads/j5cqgHKrVY_30032025143315.jpg', 'Objet 3 de catégorie 4', 4, 2);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (29, 'Penguin D', 'uploads/fi5pt7Nc1e_30032025143332.jpg', 'Objet 1 de catégorie 5', 5, 2);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (30, 'Fiona', 'uploads/Q5p9xYMegD_30032025143422.jpg', 'Objet 2 de catégorie 5', 5, 2);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (31, 'Shrek', 'uploads/9VTvum7rjx_30032025143435.jpg', 'Objet 3 de catégorie 5', 5, 2);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (32, 'Tigre', 'uploads/M9KPsIYBJy_30032025143450.jpg', 'Objet 1 de catégorie 6', 6, 2);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (33, 'Kung Fu Panda', 'uploads/sdCYlETRpV_30032025143512.jpg', 'Objet 2 de catégorie 6', 6, 2);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (34, 'Eve', 'uploads/5yGx2ndu3B_30032025143529.jpg', 'Objet 3 de catégorie 6', 6, 2);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (35, 'Woody', 'uploads/N1Y2DVcxZo_30032025144129.jpg', 'Objet 1 de catégorie 1', 1, 4);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (36, 'Martian', 'uploads/yknAWYDJq4_30032025144447.jpg', 'Objet 2 de catégorie 1', 1, 4);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (37, 'Dog', 'uploads/cINQORfDbp_30032025144504.jpg', 'Objet 3 de catégorie 1', 1, 4);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (38, 'Rex', 'uploads/5hmFGTdeJn_30032025144517.jpg', 'Objet 1 de catégorie 2', 2, 4);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (39, 'Buzz', 'uploads/hWmoeSin6x_30032025144532.jpg', 'Objet 2 de catégorie 2', 2, 4);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (40, 'Grumpy chef', 'uploads/Ems2dMYOfS_30032025144552.jpg', 'Objet 3 de catégorie 2', 2, 4);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (41, 'Useless cook', 'uploads/2oIamiV57J_30032025144613.jpg', 'Objet 1 de catégorie 3', 3, 4);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (42, 'Ratatouille', 'uploads/Z4XQNBURgW_30032025144644.jpg', 'Objet 2 de catégorie 3', 3, 4);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (43, 'Jack Sparrow', 'uploads/UyPfDSeb0R_30032025144730.jpg', 'Objet 3 de catégorie 3', 3, 4);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (44, 'Purple monster', 'uploads/ju5m01tnvc_30032025144748.jpg', 'Objet 1 de catégorie 4', 4, 4);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (45, 'One eye', 'uploads/E9F8sT6XD7_30032025144816.jpg', 'Objet 2 de catégorie 4', 4, 4);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (46, 'Moana', 'uploads/ndDIAqMbYo_30032025144839.jpg', 'Objet 3 de catégorie 4', 4, 4);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (47, 'Timon', 'uploads/8cEwIQ93pJ_30032025144906.jpg', 'Objet 1 de catégorie 5', 5, 4);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (48, 'Simba', 'uploads/VFnibxUwfH_30032025144936.jpg', 'Objet 2 de catégorie 5', 5, 4);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (49, 'Pumbaa', 'uploads/ZFlbfKvMX5_30032025144952.jpg', 'Objet 3 de catégorie 5', 5, 4);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (50, 'Simba adult', 'uploads/Kx5oXUtRPG_30032025145221.jpg', 'Objet 1 de catégorie 6', 6, 4);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (51, 'Lion girl', 'uploads/y3Xs0f4bTU_30032025145155.jpg', 'Objet 2 de catégorie 6', 6, 4);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (52, 'Violet', 'uploads/sWpHGB8zN9_30032025145247.jpg', 'Objet 3 de catégorie 6', 6, 4);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (53, 'Bob', 'uploads/5PFjvkBJDV_30032025145445.jpg', 'Objet 1 de catégorie 1', 1, 5);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (54, 'Helen', 'uploads/e8LyvXBqPY_30032025145500.jpg', 'Objet 2 de catégorie 1', 1, 5);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (55, 'Dash', 'uploads/A37zuZ6mNl_30032025145516.jpg', 'Objet 3 de catégorie 1', 1, 5);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (56, 'Olaf', 'uploads/BkjiX1q0us_30032025145605.jpg', 'Objet 1 de catégorie 2', 2, 5);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (57, 'Elsa', 'uploads/IndLa4OfFi_30032025145623.jpg', 'Objet 2 de catégorie 2', 2, 5);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (58, 'Dory', 'uploads/rBKVDlgYTO_30032025145712.jpg', 'Objet 3 de catégorie 2', 2, 5);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (59, 'McQueen', 'uploads/Zw4XDN72zj_30032025145728.jpg', 'Objet 1 de catégorie 3', 3, 5);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (60, 'Nemo', 'uploads/qlpn4HgvQW_30032025145745.jpg', 'Objet 2 de catégorie 3', 3, 5);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (61, 'Winnie', 'uploads/8XPWrvGo9R_30032025145835.jpg', 'Objet 3 de catégorie 3', 3, 5);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (62, 'Tigrou', 'uploads/AH9gjxSLYd_30032025145852.jpg', 'Objet 1 de catégorie 4', 4, 5);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (63, 'Boeuf', 'uploads/a2kufMJmcP_30032025145921.jpg', 'Objet 2 de catégorie 4', 4, 5);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (64, 'Scary Simplet', 'uploads/KmjpETuRNO_30032025150007.jpg', 'Objet 3 de catégorie 4', 4, 5);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (65, 'Grincheux', 'uploads/mrLh4xJ1gs_30032025150038.jpg', 'Objet 1 de catégorie 5', 5, 5);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (66, 'Pocahontas', 'uploads/Rj7UVMLCse_30032025150102.jpg', 'Objet 2 de catégorie 5', 5, 5);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (67, 'Irish girl', 'uploads/WqdyBDIezb_30032025150130.jpg', 'Objet 3 de catégorie 5', 5, 5);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (68, 'Jasmine', 'uploads/BojEVzDXnJ_30032025150159.jpg', 'Objet 1 de catégorie 6', 6, 5);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (69, 'Obj17-5', 'uploads/default_image.jpg', 'Objet 2 de catégorie 6', 6, 5);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (70, 'Obj18-5', 'uploads/default_image.jpg', 'Objet 3 de catégorie 6', 6, 5);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (71, 'Obj01-6', 'uploads/default_image.jpg', 'Objet 1 de catégorie 1', 1, 6);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (72, 'Obj02-6', 'uploads/default_image.jpg', 'Objet 2 de catégorie 1', 1, 6);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (73, 'Obj03-6', 'uploads/default_image.jpg', 'Objet 3 de catégorie 1', 1, 6);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (74, 'Obj04-6', 'uploads/default_image.jpg', 'Objet 1 de catégorie 2', 2, 6);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (75, 'Obj05-6', 'uploads/default_image.jpg', 'Objet 2 de catégorie 2', 2, 6);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (76, 'Obj06-6', 'uploads/default_image.jpg', 'Objet 3 de catégorie 2', 2, 6);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (77, 'Obj07-6', 'uploads/default_image.jpg', 'Objet 1 de catégorie 3', 3, 6);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (78, 'Obj08-6', 'uploads/default_image.jpg', 'Objet 2 de catégorie 3', 3, 6);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (79, 'Obj09-6', 'uploads/default_image.jpg', 'Objet 3 de catégorie 3', 3, 6);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (80, 'Obj10-6', 'uploads/default_image.jpg', 'Objet 1 de catégorie 4', 4, 6);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (81, 'Obj11-6', 'uploads/default_image.jpg', 'Objet 2 de catégorie 4', 4, 6);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (82, 'Obj12-6', 'uploads/default_image.jpg', 'Objet 3 de catégorie 4', 4, 6);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (83, 'Obj13-6', 'uploads/default_image.jpg', 'Objet 1 de catégorie 5', 5, 6);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (84, 'Obj14-6', 'uploads/default_image.jpg', 'Objet 2 de catégorie 5', 5, 6);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (85, 'Obj15-6', 'uploads/default_image.jpg', 'Objet 3 de catégorie 5', 5, 6);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (86, 'Obj16-6', 'uploads/default_image.jpg', 'Objet 1 de catégorie 6', 6, 6);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (87, 'Obj17-6', 'uploads/default_image.jpg', 'Objet 2 de catégorie 6', 6, 6);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (88, 'Obj18-6', 'uploads/default_image.jpg', 'Objet 3 de catégorie 6', 6, 6);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (89, 'Obj01-11', 'uploads/default_image.jpg', 'Objet 1 de catégorie 1', 1, 11);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (90, 'Obj02-11', 'uploads/default_image.jpg', 'Objet 2 de catégorie 1', 1, 11);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (91, 'Obj03-11', 'uploads/default_image.jpg', 'Objet 3 de catégorie 1', 1, 11);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (92, 'Obj04-11', 'uploads/default_image.jpg', 'Objet 1 de catégorie 2', 2, 11);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (93, 'Obj05-11', 'uploads/default_image.jpg', 'Objet 2 de catégorie 2', 2, 11);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (94, 'Obj06-11', 'uploads/default_image.jpg', 'Objet 3 de catégorie 2', 2, 11);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (95, 'Obj07-11', 'uploads/default_image.jpg', 'Objet 1 de catégorie 3', 3, 11);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (96, 'Obj08-11', 'uploads/default_image.jpg', 'Objet 2 de catégorie 3', 3, 11);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (97, 'Obj09-11', 'uploads/default_image.jpg', 'Objet 3 de catégorie 3', 3, 11);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (98, 'Obj10-11', 'uploads/default_image.jpg', 'Objet 1 de catégorie 4', 4, 11);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (99, 'Obj11-11', 'uploads/default_image.jpg', 'Objet 2 de catégorie 4', 4, 11);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (100, 'Obj12-11', 'uploads/default_image.jpg', 'Objet 3 de catégorie 4', 4, 11);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (101, 'Obj13-11', 'uploads/default_image.jpg', 'Objet 1 de catégorie 5', 5, 11);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (102, 'Obj14-11', 'uploads/default_image.jpg', 'Objet 2 de catégorie 5', 5, 11);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (103, 'Obj15-11', 'uploads/default_image.jpg', 'Objet 3 de catégorie 5', 5, 11);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (104, 'Obj16-11', 'uploads/default_image.jpg', 'Objet 1 de catégorie 6', 6, 11);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (105, 'Obj17-11', 'uploads/default_image.jpg', 'Objet 2 de catégorie 6', 6, 11);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (106, 'Obj18-11', 'uploads/default_image.jpg', 'Objet 3 de catégorie 6', 6, 11);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (107, 'Obj01-17', 'uploads/default_image.jpg', 'Objet 1 de catégorie 1', 1, 17);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (108, 'Obj02-17', 'uploads/default_image.jpg', 'Objet 2 de catégorie 1', 1, 17);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (109, 'Obj03-17', 'uploads/default_image.jpg', 'Objet 3 de catégorie 1', 1, 17);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (110, 'Obj04-17', 'uploads/default_image.jpg', 'Objet 1 de catégorie 2', 2, 17);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (111, 'Obj05-17', 'uploads/default_image.jpg', 'Objet 2 de catégorie 2', 2, 17);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (112, 'Obj06-17', 'uploads/default_image.jpg', 'Objet 3 de catégorie 2', 2, 17);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (113, 'Obj07-17', 'uploads/default_image.jpg', 'Objet 1 de catégorie 3', 3, 17);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (114, 'Obj08-17', 'uploads/default_image.jpg', 'Objet 2 de catégorie 3', 3, 17);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (115, 'Obj09-17', 'uploads/default_image.jpg', 'Objet 3 de catégorie 3', 3, 17);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (116, 'Obj10-17', 'uploads/default_image.jpg', 'Objet 1 de catégorie 4', 4, 17);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (117, 'Obj11-17', 'uploads/default_image.jpg', 'Objet 2 de catégorie 4', 4, 17);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (118, 'Obj12-17', 'uploads/default_image.jpg', 'Objet 3 de catégorie 4', 4, 17);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (119, 'Obj13-17', 'uploads/default_image.jpg', 'Objet 1 de catégorie 5', 5, 17);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (120, 'Obj14-17', 'uploads/default_image.jpg', 'Objet 2 de catégorie 5', 5, 17);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (121, 'Obj15-17', 'uploads/default_image.jpg', 'Objet 3 de catégorie 5', 5, 17);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (122, 'Obj16-17', 'uploads/default_image.jpg', 'Objet 1 de catégorie 6', 6, 17);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (123, 'Obj17-17', 'uploads/default_image.jpg', 'Objet 2 de catégorie 6', 6, 17);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (124, 'Obj18-17', 'uploads/default_image.jpg', 'Objet 3 de catégorie 6', 6, 17);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (125, 'Obj01-19', 'uploads/default_image.jpg', 'Objet 1 de catégorie 1', 1, 19);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (126, 'Obj02-19', 'uploads/default_image.jpg', 'Objet 2 de catégorie 1', 1, 19);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (127, 'Obj03-19', 'uploads/default_image.jpg', 'Objet 3 de catégorie 1', 1, 19);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (128, 'Obj04-19', 'uploads/default_image.jpg', 'Objet 1 de catégorie 2', 2, 19);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (129, 'Obj05-19', 'uploads/default_image.jpg', 'Objet 2 de catégorie 2', 2, 19);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (130, 'Obj06-19', 'uploads/default_image.jpg', 'Objet 3 de catégorie 2', 2, 19);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (131, 'Obj07-19', 'uploads/default_image.jpg', 'Objet 1 de catégorie 3', 3, 19);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (132, 'Obj08-19', 'uploads/default_image.jpg', 'Objet 2 de catégorie 3', 3, 19);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (133, 'Obj09-19', 'uploads/default_image.jpg', 'Objet 3 de catégorie 3', 3, 19);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (134, 'Obj10-19', 'uploads/default_image.jpg', 'Objet 1 de catégorie 4', 4, 19);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (135, 'Obj11-19', 'uploads/default_image.jpg', 'Objet 2 de catégorie 4', 4, 19);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (136, 'Obj12-19', 'uploads/default_image.jpg', 'Objet 3 de catégorie 4', 4, 19);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (137, 'Obj13-19', 'uploads/default_image.jpg', 'Objet 1 de catégorie 5', 5, 19);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (138, 'Obj14-19', 'uploads/default_image.jpg', 'Objet 2 de catégorie 5', 5, 19);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (139, 'Obj15-19', 'uploads/default_image.jpg', 'Objet 3 de catégorie 5', 5, 19);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (140, 'Obj16-19', 'uploads/default_image.jpg', 'Objet 1 de catégorie 6', 6, 19);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (141, 'Obj17-19', 'uploads/default_image.jpg', 'Objet 2 de catégorie 6', 6, 19);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (142, 'Obj18-19', 'uploads/default_image.jpg', 'Objet 3 de catégorie 6', 6, 19);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (143, 'Obj01-20', 'uploads/default_image.jpg', 'Objet 1 de catégorie 1', 1, 20);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (144, 'Obj02-20', 'uploads/default_image.jpg', 'Objet 2 de catégorie 1', 1, 20);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (145, 'Obj03-20', 'uploads/default_image.jpg', 'Objet 3 de catégorie 1', 1, 20);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (146, 'Obj04-20', 'uploads/default_image.jpg', 'Objet 1 de catégorie 2', 2, 20);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (147, 'Obj05-20', 'uploads/default_image.jpg', 'Objet 2 de catégorie 2', 2, 20);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (148, 'Obj06-20', 'uploads/default_image.jpg', 'Objet 3 de catégorie 2', 2, 20);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (149, 'Obj07-20', 'uploads/default_image.jpg', 'Objet 1 de catégorie 3', 3, 20);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (150, 'Obj08-20', 'uploads/default_image.jpg', 'Objet 2 de catégorie 3', 3, 20);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (151, 'Obj09-20', 'uploads/default_image.jpg', 'Objet 3 de catégorie 3', 3, 20);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (152, 'Obj10-20', 'uploads/default_image.jpg', 'Objet 1 de catégorie 4', 4, 20);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (153, 'Obj11-20', 'uploads/default_image.jpg', 'Objet 2 de catégorie 4', 4, 20);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (154, 'Obj12-20', 'uploads/default_image.jpg', 'Objet 3 de catégorie 4', 4, 20);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (155, 'Obj13-20', 'uploads/default_image.jpg', 'Objet 1 de catégorie 5', 5, 20);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (156, 'Obj14-20', 'uploads/default_image.jpg', 'Objet 2 de catégorie 5', 5, 20);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (157, 'Obj15-20', 'uploads/default_image.jpg', 'Objet 3 de catégorie 5', 5, 20);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (158, 'Obj16-20', 'uploads/default_image.jpg', 'Objet 1 de catégorie 6', 6, 20);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (159, 'Obj17-20', 'uploads/default_image.jpg', 'Objet 2 de catégorie 6', 6, 20);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (160, 'Obj18-20', 'uploads/default_image.jpg', 'Objet 3 de catégorie 6', 6, 20);
INSERT INTO Q240183.Objet (oid, intitule, image, description, cid, bid) VALUES (161, 'Aladdin', 'uploads/V3tSRGi26Y_30032025142848.jpg', 'Aladdin', 4, 2);



/*
INSERT INTO Q240183.Objet (intitule, image, description, cid, bid) VALUES

('Obj01-2', 'uploads/default_image.jpg', 'Objet 1 de catégorie 1', 1, 2),
('Obj02-2', 'uploads/default_image.jpg', 'Objet 2 de catégorie 1', 1, 2),
('Obj03-2', 'uploads/default_image.jpg', 'Objet 3 de catégorie 1', 1, 2),
('Obj04-2', 'uploads/default_image.jpg', 'Objet 1 de catégorie 2', 2, 2),
('Obj05-2', 'uploads/default_image.jpg', 'Objet 2 de catégorie 2', 2, 2),
('Obj06-2', 'uploads/default_image.jpg', 'Objet 3 de catégorie 2', 2, 2),
('Obj07-2', 'uploads/default_image.jpg', 'Objet 1 de catégorie 3', 3, 2),
('Obj08-2', 'uploads/default_image.jpg', 'Objet 2 de catégorie 3', 3, 2),
('Obj09-2', 'uploads/default_image.jpg', 'Objet 3 de catégorie 3', 3, 2),
('Obj10-2', 'uploads/default_image.jpg', 'Objet 1 de catégorie 4', 4, 2),
('Obj11-2', 'uploads/default_image.jpg', 'Objet 2 de catégorie 4', 4, 2),
('Obj12-2', 'uploads/default_image.jpg', 'Objet 3 de catégorie 4', 4, 2),
('Obj13-2', 'uploads/default_image.jpg', 'Objet 1 de catégorie 5', 5, 2),
('Obj14-2', 'uploads/default_image.jpg', 'Objet 2 de catégorie 5', 5, 2),
('Obj15-2', 'uploads/default_image.jpg', 'Objet 3 de catégorie 5', 5, 2),
('Obj16-2', 'uploads/default_image.jpg', 'Objet 1 de catégorie 6', 6, 2),
('Obj17-2', 'uploads/default_image.jpg', 'Objet 2 de catégorie 6', 6, 2),
('Obj18-2', 'uploads/default_image.jpg', 'Objet 3 de catégorie 6', 6, 2),

('Obj01-4', 'uploads/default_image.jpg', 'Objet 1 de catégorie 1', 1, 4),
('Obj02-4', 'uploads/default_image.jpg', 'Objet 2 de catégorie 1', 1, 4),
('Obj03-4', 'uploads/default_image.jpg', 'Objet 3 de catégorie 1', 1, 4),
('Obj04-4', 'uploads/default_image.jpg', 'Objet 1 de catégorie 2', 2, 4),
('Obj05-4', 'uploads/default_image.jpg', 'Objet 2 de catégorie 2', 2, 4),
('Obj06-4', 'uploads/default_image.jpg', 'Objet 3 de catégorie 2', 2, 4),
('Obj07-4', 'uploads/default_image.jpg', 'Objet 1 de catégorie 3', 3, 4),
('Obj08-4', 'uploads/default_image.jpg', 'Objet 2 de catégorie 3', 3, 4),
('Obj09-4', 'uploads/default_image.jpg', 'Objet 3 de catégorie 3', 3, 4),
('Obj10-4', 'uploads/default_image.jpg', 'Objet 1 de catégorie 4', 4, 4),
('Obj11-4', 'uploads/default_image.jpg', 'Objet 2 de catégorie 4', 4, 4),
('Obj12-4', 'uploads/default_image.jpg', 'Objet 3 de catégorie 4', 4, 4),
('Obj13-4', 'uploads/default_image.jpg', 'Objet 1 de catégorie 5', 5, 4),
('Obj14-4', 'uploads/default_image.jpg', 'Objet 2 de catégorie 5', 5, 4),
('Obj15-4', 'uploads/default_image.jpg', 'Objet 3 de catégorie 5', 5, 4),
('Obj16-4', 'uploads/default_image.jpg', 'Objet 1 de catégorie 6', 6, 4),
('Obj17-4', 'uploads/default_image.jpg', 'Objet 2 de catégorie 6', 6, 4),
('Obj18-4', 'uploads/default_image.jpg', 'Objet 3 de catégorie 6', 6, 4),

('Obj01-5', 'uploads/default_image.jpg', 'Objet 1 de catégorie 1', 1, 5),
('Obj02-5', 'uploads/default_image.jpg', 'Objet 2 de catégorie 1', 1, 5),
('Obj03-5', 'uploads/default_image.jpg', 'Objet 3 de catégorie 1', 1, 5),
('Obj04-5', 'uploads/default_image.jpg', 'Objet 1 de catégorie 2', 2, 5),
('Obj05-5', 'uploads/default_image.jpg', 'Objet 2 de catégorie 2', 2, 5),
('Obj06-5', 'uploads/default_image.jpg', 'Objet 3 de catégorie 2', 2, 5),
('Obj07-5', 'uploads/default_image.jpg', 'Objet 1 de catégorie 3', 3, 5),
('Obj08-5', 'uploads/default_image.jpg', 'Objet 2 de catégorie 3', 3, 5),
('Obj09-5', 'uploads/default_image.jpg', 'Objet 3 de catégorie 3', 3, 5),
('Obj10-5', 'uploads/default_image.jpg', 'Objet 1 de catégorie 4', 4, 5),
('Obj11-5', 'uploads/default_image.jpg', 'Objet 2 de catégorie 4', 4, 5),
('Obj12-5', 'uploads/default_image.jpg', 'Objet 3 de catégorie 4', 4, 5),
('Obj13-5', 'uploads/default_image.jpg', 'Objet 1 de catégorie 5', 5, 5),
('Obj14-5', 'uploads/default_image.jpg', 'Objet 2 de catégorie 5', 5, 5),
('Obj15-5', 'uploads/default_image.jpg', 'Objet 3 de catégorie 5', 5, 5),
('Obj16-5', 'uploads/default_image.jpg', 'Objet 1 de catégorie 6', 6, 5),
('Obj17-5', 'uploads/default_image.jpg', 'Objet 2 de catégorie 6', 6, 5),
('Obj18-5', 'uploads/default_image.jpg', 'Objet 3 de catégorie 6', 6, 5),

('Obj01-6', 'uploads/default_image.jpg', 'Objet 1 de catégorie 1', 1, 6),
('Obj02-6', 'uploads/default_image.jpg', 'Objet 2 de catégorie 1', 1, 6),
('Obj03-6', 'uploads/default_image.jpg', 'Objet 3 de catégorie 1', 1, 6),
('Obj04-6', 'uploads/default_image.jpg', 'Objet 1 de catégorie 2', 2, 6),
('Obj05-6', 'uploads/default_image.jpg', 'Objet 2 de catégorie 2', 2, 6),
('Obj06-6', 'uploads/default_image.jpg', 'Objet 3 de catégorie 2', 2, 6),
('Obj07-6', 'uploads/default_image.jpg', 'Objet 1 de catégorie 3', 3, 6),
('Obj08-6', 'uploads/default_image.jpg', 'Objet 2 de catégorie 3', 3, 6),
('Obj09-6', 'uploads/default_image.jpg', 'Objet 3 de catégorie 3', 3, 6),
('Obj10-6', 'uploads/default_image.jpg', 'Objet 1 de catégorie 4', 4, 6),
('Obj11-6', 'uploads/default_image.jpg', 'Objet 2 de catégorie 4', 4, 6),
('Obj12-6', 'uploads/default_image.jpg', 'Objet 3 de catégorie 4', 4, 6),
('Obj13-6', 'uploads/default_image.jpg', 'Objet 1 de catégorie 5', 5, 6),
('Obj14-6', 'uploads/default_image.jpg', 'Objet 2 de catégorie 5', 5, 6),
('Obj15-6', 'uploads/default_image.jpg', 'Objet 3 de catégorie 5', 5, 6),
('Obj16-6', 'uploads/default_image.jpg', 'Objet 1 de catégorie 6', 6, 6),
('Obj17-6', 'uploads/default_image.jpg', 'Objet 2 de catégorie 6', 6, 6),
('Obj18-6', 'uploads/default_image.jpg', 'Objet 3 de catégorie 6', 6, 6),

('Obj01-11', 'uploads/default_image.jpg', 'Objet 1 de catégorie 1', 1, 11),
('Obj02-11', 'uploads/default_image.jpg', 'Objet 2 de catégorie 1', 1, 11),
('Obj03-11', 'uploads/default_image.jpg', 'Objet 3 de catégorie 1', 1, 11),
('Obj04-11', 'uploads/default_image.jpg', 'Objet 1 de catégorie 2', 2, 11),
('Obj05-11', 'uploads/default_image.jpg', 'Objet 2 de catégorie 2', 2, 11),
('Obj06-11', 'uploads/default_image.jpg', 'Objet 3 de catégorie 2', 2, 11),
('Obj07-11', 'uploads/default_image.jpg', 'Objet 1 de catégorie 3', 3, 11),
('Obj08-11', 'uploads/default_image.jpg', 'Objet 2 de catégorie 3', 3, 11),
('Obj09-11', 'uploads/default_image.jpg', 'Objet 3 de catégorie 3', 3, 11),
('Obj10-11', 'uploads/default_image.jpg', 'Objet 1 de catégorie 4', 4, 11),
('Obj11-11', 'uploads/default_image.jpg', 'Objet 2 de catégorie 4', 4, 11),
('Obj12-11', 'uploads/default_image.jpg', 'Objet 3 de catégorie 4', 4, 11),
('Obj13-11', 'uploads/default_image.jpg', 'Objet 1 de catégorie 5', 5, 11),
('Obj14-11', 'uploads/default_image.jpg', 'Objet 2 de catégorie 5', 5, 11),
('Obj15-11', 'uploads/default_image.jpg', 'Objet 3 de catégorie 5', 5, 11),
('Obj16-11', 'uploads/default_image.jpg', 'Objet 1 de catégorie 6', 6, 11),
('Obj17-11', 'uploads/default_image.jpg', 'Objet 2 de catégorie 6', 6, 11),
('Obj18-11', 'uploads/default_image.jpg', 'Objet 3 de catégorie 6', 6, 11),

('Obj01-17', 'uploads/default_image.jpg', 'Objet 1 de catégorie 1', 1, 17),
('Obj02-17', 'uploads/default_image.jpg', 'Objet 2 de catégorie 1', 1, 17),
('Obj03-17', 'uploads/default_image.jpg', 'Objet 3 de catégorie 1', 1, 17),
('Obj04-17', 'uploads/default_image.jpg', 'Objet 1 de catégorie 2', 2, 17),
('Obj05-17', 'uploads/default_image.jpg', 'Objet 2 de catégorie 2', 2, 17),
('Obj06-17', 'uploads/default_image.jpg', 'Objet 3 de catégorie 2', 2, 17),
('Obj07-17', 'uploads/default_image.jpg', 'Objet 1 de catégorie 3', 3, 17),
('Obj08-17', 'uploads/default_image.jpg', 'Objet 2 de catégorie 3', 3, 17),
('Obj09-17', 'uploads/default_image.jpg', 'Objet 3 de catégorie 3', 3, 17),
('Obj10-17', 'uploads/default_image.jpg', 'Objet 1 de catégorie 4', 4, 17),
('Obj11-17', 'uploads/default_image.jpg', 'Objet 2 de catégorie 4', 4, 17),
('Obj12-17', 'uploads/default_image.jpg', 'Objet 3 de catégorie 4', 4, 17),
('Obj13-17', 'uploads/default_image.jpg', 'Objet 1 de catégorie 5', 5, 17),
('Obj14-17', 'uploads/default_image.jpg', 'Objet 2 de catégorie 5', 5, 17),
('Obj15-17', 'uploads/default_image.jpg', 'Objet 3 de catégorie 5', 5, 17),
('Obj16-17', 'uploads/default_image.jpg', 'Objet 1 de catégorie 6', 6, 17),
('Obj17-17', 'uploads/default_image.jpg', 'Objet 2 de catégorie 6', 6, 17),
('Obj18-17', 'uploads/default_image.jpg', 'Objet 3 de catégorie 6', 6, 17),

('Obj01-19', 'uploads/default_image.jpg', 'Objet 1 de catégorie 1', 1, 19),
('Obj02-19', 'uploads/default_image.jpg', 'Objet 2 de catégorie 1', 1, 19),
('Obj03-19', 'uploads/default_image.jpg', 'Objet 3 de catégorie 1', 1, 19),
('Obj04-19', 'uploads/default_image.jpg', 'Objet 1 de catégorie 2', 2, 19),
('Obj05-19', 'uploads/default_image.jpg', 'Objet 2 de catégorie 2', 2, 19),
('Obj06-19', 'uploads/default_image.jpg', 'Objet 3 de catégorie 2', 2, 19),
('Obj07-19', 'uploads/default_image.jpg', 'Objet 1 de catégorie 3', 3, 19),
('Obj08-19', 'uploads/default_image.jpg', 'Objet 2 de catégorie 3', 3, 19),
('Obj09-19', 'uploads/default_image.jpg', 'Objet 3 de catégorie 3', 3, 19),
('Obj10-19', 'uploads/default_image.jpg', 'Objet 1 de catégorie 4', 4, 19),
('Obj11-19', 'uploads/default_image.jpg', 'Objet 2 de catégorie 4', 4, 19),
('Obj12-19', 'uploads/default_image.jpg', 'Objet 3 de catégorie 4', 4, 19),
('Obj13-19', 'uploads/default_image.jpg', 'Objet 1 de catégorie 5', 5, 19),
('Obj14-19', 'uploads/default_image.jpg', 'Objet 2 de catégorie 5', 5, 19),
('Obj15-19', 'uploads/default_image.jpg', 'Objet 3 de catégorie 5', 5, 19),
('Obj16-19', 'uploads/default_image.jpg', 'Objet 1 de catégorie 6', 6, 19),
('Obj17-19', 'uploads/default_image.jpg', 'Objet 2 de catégorie 6', 6, 19),
('Obj18-19', 'uploads/default_image.jpg', 'Objet 3 de catégorie 6', 6, 19),

('Obj01-20', 'uploads/default_image.jpg', 'Objet 1 de catégorie 1', 1, 20),
('Obj02-20', 'uploads/default_image.jpg', 'Objet 2 de catégorie 1', 1, 20),
('Obj03-20', 'uploads/default_image.jpg', 'Objet 3 de catégorie 1', 1, 20),
('Obj04-20', 'uploads/default_image.jpg', 'Objet 1 de catégorie 2', 2, 20),
('Obj05-20', 'uploads/default_image.jpg', 'Objet 2 de catégorie 2', 2, 20),
('Obj06-20', 'uploads/default_image.jpg', 'Objet 3 de catégorie 2', 2, 20),
('Obj07-20', 'uploads/default_image.jpg', 'Objet 1 de catégorie 3', 3, 20),
('Obj08-20', 'uploads/default_image.jpg', 'Objet 2 de catégorie 3', 3, 20),
('Obj09-20', 'uploads/default_image.jpg', 'Objet 3 de catégorie 3', 3, 20),
('Obj10-20', 'uploads/default_image.jpg', 'Objet 1 de catégorie 4', 4, 20),
('Obj11-20', 'uploads/default_image.jpg', 'Objet 2 de catégorie 4', 4, 20),
('Obj12-20', 'uploads/default_image.jpg', 'Objet 3 de catégorie 4', 4, 20),
('Obj13-20', 'uploads/default_image.jpg', 'Objet 1 de catégorie 5', 5, 20),
('Obj14-20', 'uploads/default_image.jpg', 'Objet 2 de catégorie 5', 5, 20),
('Obj15-20', 'uploads/default_image.jpg', 'Objet 3 de catégorie 5', 5, 20),
('Obj16-20', 'uploads/default_image.jpg', 'Objet 1 de catégorie 6', 6, 20),
('Obj17-20', 'uploads/default_image.jpg', 'Objet 2 de catégorie 6', 6, 20),
('Obj18-20', 'uploads/default_image.jpg', 'Objet 3 de catégorie 6', 6, 20);
*/