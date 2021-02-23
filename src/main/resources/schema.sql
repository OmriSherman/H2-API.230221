DROP TABLE IF EXISTS CATALOG;

CREATE TABLE CATALOG (
                         item_no INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(30) NOT NULL,
                         amount INT NOT NULL,
                         inv_code INT NOT NULL );