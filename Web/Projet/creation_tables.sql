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

-- Indexes for foreign key columns
CREATE INDEX idx_zid ON Emplacement(zid);
CREATE INDEX idx_eid ON Brocanteur(eid);
CREATE INDEX idx_cid ON Objet(cid);
CREATE INDEX idx_bid ON Objet(bid);