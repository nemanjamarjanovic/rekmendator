/**
 * Author:  nemanja
 * Created: Aug 1, 2016
 */

--SYSTEM DATA

INSERT INTO `rekomendator`.`ROLE` (`TITLE`) VALUES ('GUEST');
INSERT INTO `rekomendator`.`ROLE` (`TITLE`) VALUES ('USER');
INSERT INTO `rekomendator`.`ROLE` (`TITLE`) VALUES ('SUPER');
INSERT INTO `rekomendator`.`ROLE` (`TITLE`) VALUES ('ADMIN');

INSERT INTO `rekomendator`.`PERMISSION` (`TITLE`) VALUES ('MOVIES-LIST');
INSERT INTO `rekomendator`.`PERMISSION` (`TITLE`) VALUES ('MOVIES-DETAILS');
INSERT INTO `rekomendator`.`PERMISSION` (`TITLE`) VALUES ('ADMIN-PAGES');
INSERT INTO `rekomendator`.`PERMISSION` (`TITLE`) VALUES ('USER-PAGES');
INSERT INTO `rekomendator`.`PERMISSION` (`TITLE`) VALUES ('LOGIN');
INSERT INTO `rekomendator`.`PERMISSION` (`TITLE`) VALUES ('LOGOUT');
INSERT INTO `rekomendator`.`PERMISSION` (`TITLE`) VALUES ('REGISTER');
INSERT INTO `rekomendator`.`PERMISSION` (`TITLE`) VALUES ('GENRE-LIST');
INSERT INTO `rekomendator`.`PERMISSION` (`TITLE`) VALUES ('GENRE-CREATE');
INSERT INTO `rekomendator`.`PERMISSION` (`TITLE`) VALUES ('USER-LIST');

INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('GUEST', 'LOGIN');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('GUEST', 'REGISTER');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('GUEST', 'MOVIES-LIST');

INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('USER', 'LOGOUT');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('USER', 'USER-PAGES');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('USER', 'MOVIES-LIST');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('USER', 'MOVIES-DETAILS');

INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('SUPER', 'LOGOUT');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('SUPER', 'USER-PAGES');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('SUPER', 'MOVIES-LIST');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('SUPER', 'MOVIES-DETAILS');

INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('ADMIN', 'ADMIN-PAGES');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('ADMIN', 'LOGOUT');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('ADMIN', 'GENRE-LIST');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('ADMIN', 'GENRE-CREATE');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('ADMIN', 'USER-LIST');

INSERT INTO `rekomendator`.`USER` (`ID`, `PASSWORD`, `USERNAME`, `ROLE_TITLE`, `NAME`, `SURNAME`, `MBR`, `EMAIL`) 
VALUES ('6c614e2b-e206-4503-8723-9f62e1e1afc4','Ógaà½OZ�-NÑý� \', 'UserMarko1234567890', 'USER', 'Marko', 'Markovic', '123456789123456', 'nemanjam@blic.net');

INSERT INTO `rekomendator`.`USER` (`ID`, `PASSWORD`, `USERNAME`, `ROLE_TITLE`) 
VALUES ('c62cb541-18a1-40c6-b721-2bb1b0653375', 'œ5OJÖæ_Õï5%¼¯','AdministratorNemanja', 'ADMIN', 'Nemanja', 'Marjanovic', '123456789123456', 'nemanjam@blic.net');

INSERT INTO `rekomendator`.`USER` (`ID`, `PASSWORD`, `USERNAME`, `ROLE_TITLE`) 
VALUES ('d4d75e2a-df2e-4cb0-8967-290d73747699', 'ÚûÚhçg`*
CqŸÆÚ¸','SuperJelena1234567890', 'SUPER', 'Jelena', 'Marjanovic', '123456789123456', 'nemanjam@blic.net');

-- DATA

INSERT INTO `rekomendator`.`GENRE` (`TITLE`) VALUES ('ACTION');
INSERT INTO `rekomendator`.`GENRE` (`TITLE`) VALUES ('SCI-FI');



