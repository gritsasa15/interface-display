DROP TABLE interface_rela;
CREATE TABLE interface_rela (ID int(4) NOT NULL AUTO_INCREMENT, SRC_APP varchar(32) NOT NULL, DES_APP varchar(32) NOT NULL, CON_TYPE varchar(16) NOT NULL, PRIMARY KEY (ID)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO interface_rela (ID, SRC_APP, DES_APP, CON_TYPE) VALUES (1, 'AirChina', 'DOM', 'MQ');
INSERT INTO interface_rela (ID, SRC_APP, DES_APP, CON_TYPE) VALUES (2, 'AirChina', 'TQP', 'DB Access');
INSERT INTO interface_rela (ID, SRC_APP, DES_APP, CON_TYPE) VALUES (3, 'SVA', 'AirChina', 'MQ');
INSERT INTO interface_rela (ID, SRC_APP, DES_APP, CON_TYPE) VALUES (4, 'PKIO', 'AG', 'HTTPS');
INSERT INTO interface_rela (ID, SRC_APP, DES_APP, CON_TYPE) VALUES (5, 'KS', 'SAP', 'RFC');
INSERT INTO interface_rela (ID, SRC_APP, DES_APP, CON_TYPE) VALUES (6, 'SAP', 'KS', 'RFC');
INSERT INTO interface_rela (ID, SRC_APP, DES_APP, CON_TYPE) VALUES (7, 'AirChina', 'PLUNK', 'Share Folder');
INSERT INTO interface_rela (ID, SRC_APP, DES_APP, CON_TYPE) VALUES (8, 'PWE', 'SAP', 'RFC');
INSERT INTO interface_rela (ID, SRC_APP, DES_APP, CON_TYPE) VALUES (9, 'SAP', 'PWE', 'RFC');
INSERT INTO interface_rela (ID, SRC_APP, DES_APP, CON_TYPE) VALUES (10, 'PWE', 'PWE Conn', 'DB Access');
INSERT INTO interface_rela (ID, SRC_APP, DES_APP, CON_TYPE) VALUES (11, 'SAP', 'PressQ', 'RFC');
INSERT INTO interface_rela (ID, SRC_APP, DES_APP, CON_TYPE) VALUES (12, 'JUS', 'PWE', 'KM');
INSERT INTO interface_rela (ID, SRC_APP, DES_APP, CON_TYPE) VALUES (13, 'PLC', 'JUS', 'KM');
INSERT INTO interface_rela (ID, SRC_APP, DES_APP, CON_TYPE) VALUES (14, 'Cool System', 'PLUNK', 'MQ');
INSERT INTO interface_rela (ID, SRC_APP, DES_APP, CON_TYPE) VALUES (15, 'Cool System', 'AirChina', 'MQ');
INSERT INTO interface_rela (ID, SRC_APP, DES_APP, CON_TYPE) VALUES (16, 'JUS', 'SYS', 'MQ');
INSERT INTO interface_rela (ID, SRC_APP, DES_APP, CON_TYPE) VALUES (17, 'LSA', 'JUS', 'TCP');
INSERT INTO interface_rela (ID, SRC_APP, DES_APP, CON_TYPE) VALUES (18, 'LSA', 'PWE', 'TCP');
INSERT INTO interface_rela (ID, SRC_APP, DES_APP, CON_TYPE) VALUES (19, 'PressQ', 'FM', 'DB Link');
INSERT INTO interface_rela (ID, SRC_APP, DES_APP, CON_TYPE) VALUES (20, 'FM', 'PressQ', 'DB Link');
INSERT INTO interface_rela (ID, SRC_APP, DES_APP, CON_TYPE) VALUES (21, 'LSA', 'PSS', 'DB Link');
INSERT INTO interface_rela (ID, SRC_APP, DES_APP, CON_TYPE) VALUES (22, 'PSS', 'PSS Conn', 'DB Access');