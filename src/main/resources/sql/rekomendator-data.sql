/**
 * Author:  nemanja
 * Created: Aug 1, 2016
 */

--SYSTEM DATA

INSERT INTO `rekomendator`.`ROLE` (`TITLE`) VALUES ('USER');
INSERT INTO `rekomendator`.`ROLE` (`TITLE`) VALUES ('SUPER');
INSERT INTO `rekomendator`.`ROLE` (`TITLE`) VALUES ('ADMIN');

INSERT INTO `rekomendator`.`PAGE` (`TITLE`, `PAGE`) VALUES ('MOVIE-ALL', 'movie-list?src=all');
INSERT INTO `rekomendator`.`PAGE` (`TITLE`, `PAGE`) VALUES ('MOVIE-SEARCH', 'movie-list?src=search');
INSERT INTO `rekomendator`.`PAGE` (`TITLE`, `PAGE`) VALUES ('MOVIE-FAVORITES', 'movie-list?src=favorites');
INSERT INTO `rekomendator`.`PAGE` (`TITLE`, `PAGE`) VALUES ('MOVIE-EDIT', 'movie-edit');
INSERT INTO `rekomendator`.`PAGE` (`TITLE`, `PAGE`) VALUES ('USER-LIST', 'user-list');
INSERT INTO `rekomendator`.`PAGE` (`TITLE`, `PAGE`) VALUES ('GENRE-LIST', 'genre-list');
INSERT INTO `rekomendator`.`PAGE` (`TITLE`, `PAGE`) VALUES ('GENRE-EDIT', 'genre-edit');
INSERT INTO `rekomendator`.`PAGE` (`TITLE`, `PAGE`) VALUES ('EVENT-LIST', 'event-list');
INSERT INTO `rekomendator`.`PAGE` (`TITLE`, `PAGE`) VALUES ('EVENT-EDIT', 'event-edit');
INSERT INTO `rekomendator`.`PAGE` (`TITLE`, `PAGE`) VALUES ('COMMENT-LIST', 'comment-list');
INSERT INTO `rekomendator`.`PAGE` (`TITLE`, `PAGE`) VALUES ('REPORTS', 'reports');

INSERT INTO `rekomendator`.`PERMISSION` (`TITLE`) VALUES ('MOVIE-VIEW');
INSERT INTO `rekomendator`.`PERMISSION` (`TITLE`) VALUES ('MOVIE-UPLOAD');
INSERT INTO `rekomendator`.`PERMISSION` (`TITLE`) VALUES ('MOVIE-RATE');
INSERT INTO `rekomendator`.`PERMISSION` (`TITLE`) VALUES ('MOVIE-FAVORITE');
INSERT INTO `rekomendator`.`PERMISSION` (`TITLE`) VALUES ('MOVIE-COMMENT');
INSERT INTO `rekomendator`.`PERMISSION` (`TITLE`) VALUES ('USER-VIEW');
INSERT INTO `rekomendator`.`PERMISSION` (`TITLE`) VALUES ('USER-ACTIVATION');
INSERT INTO `rekomendator`.`PERMISSION` (`TITLE`) VALUES ('EVENT-ACTIVATION');
INSERT INTO `rekomendator`.`PERMISSION` (`TITLE`) VALUES ('EVENT-VIEW');
INSERT INTO `rekomendator`.`PERMISSION` (`TITLE`) VALUES ('EVENT-PHOTO');
INSERT INTO `rekomendator`.`PERMISSION` (`TITLE`) VALUES ('COMMENT-REMOVE');

INSERT INTO `rekomendator`.`ROLE_PAGE` (`Role_TITLE`, `pages_TITLE`) VALUES ('USER', 'MOVIE-ALL');
INSERT INTO `rekomendator`.`ROLE_PAGE` (`Role_TITLE`, `pages_TITLE`) VALUES ('USER', 'MOVIE-SEARCH');
INSERT INTO `rekomendator`.`ROLE_PAGE` (`Role_TITLE`, `pages_TITLE`) VALUES ('USER', 'MOVIE-FAVORITES');
INSERT INTO `rekomendator`.`ROLE_PAGE` (`Role_TITLE`, `pages_TITLE`) VALUES ('USER', 'MOVIE-EDIT');
INSERT INTO `rekomendator`.`ROLE_PAGE` (`Role_TITLE`, `pages_TITLE`) VALUES ('USER', 'EVENT-LIST');

INSERT INTO `rekomendator`.`ROLE_PAGE` (`Role_TITLE`, `pages_TITLE`) VALUES ('SUPER', 'MOVIE-ALL');
INSERT INTO `rekomendator`.`ROLE_PAGE` (`Role_TITLE`, `pages_TITLE`) VALUES ('SUPER', 'MOVIE-SEARCH');
INSERT INTO `rekomendator`.`ROLE_PAGE` (`Role_TITLE`, `pages_TITLE`) VALUES ('SUPER', 'MOVIE-FAVORITES');
INSERT INTO `rekomendator`.`ROLE_PAGE` (`Role_TITLE`, `pages_TITLE`) VALUES ('SUPER', 'MOVIE-EDIT');
INSERT INTO `rekomendator`.`ROLE_PAGE` (`Role_TITLE`, `pages_TITLE`) VALUES ('SUPER', 'EVENT-LIST');
INSERT INTO `rekomendator`.`ROLE_PAGE` (`Role_TITLE`, `pages_TITLE`) VALUES ('SUPER', 'EVENT-EDIT');

INSERT INTO `rekomendator`.`ROLE_PAGE` (`Role_TITLE`, `pages_TITLE`) VALUES ('ADMIN', 'USER-LIST');
INSERT INTO `rekomendator`.`ROLE_PAGE` (`Role_TITLE`, `pages_TITLE`) VALUES ('ADMIN', 'GENRE-LIST');
INSERT INTO `rekomendator`.`ROLE_PAGE` (`Role_TITLE`, `pages_TITLE`) VALUES ('ADMIN', 'GENRE-EDIT');
INSERT INTO `rekomendator`.`ROLE_PAGE` (`Role_TITLE`, `pages_TITLE`) VALUES ('ADMIN', 'EVENT-LIST');
INSERT INTO `rekomendator`.`ROLE_PAGE` (`Role_TITLE`, `pages_TITLE`) VALUES ('ADMIN', 'COMMENT-LIST');
INSERT INTO `rekomendator`.`ROLE_PAGE` (`Role_TITLE`, `pages_TITLE`) VALUES ('ADMIN', 'REPORTS');

INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('USER', 'MOVIE-VIEW');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('USER', 'MOVIE-RATE');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('USER', 'MOVIE-FAVORITE');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('USER', 'MOVIE-COMMENT');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('USER', 'EVENT-VIEW');

INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('SUPER', 'MOVIE-VIEW');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('SUPER', 'MOVIE-RATE');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('SUPER', 'MOVIE-FAVORITE');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('SUPER', 'MOVIE-COMMENT');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('SUPER', 'MOVIE-UPLOAD');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('SUPER', 'EVENT-VIEW');

INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('ADMIN', 'USER-VIEW');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('ADMIN', 'USER-ACTIVATION');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('ADMIN', 'EVENT-ACTIVATION');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('ADMIN', 'EVENT-PHOTO');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('ADMIN', 'COMMENT-REMOVE');


INSERT INTO `rekomendator`.`USER` (`ID`, `PASSWORD`, `USERNAME`, `ROLE_TITLE`, `NAME`, `SURNAME`, `MBR`, `EMAIL`) 
VALUES ('6c614e2b-e206-4503-8723-9f62e1e1afc4','user', 'UserMarko1234567890', 'USER', 'Marko', 'Markovic', '123456789123456', 'nemanjam@blic.net');

INSERT INTO `rekomendator`.`USER` (`ID`, `PASSWORD`, `USERNAME`, `ROLE_TITLE`, `NAME`, `SURNAME`, `MBR`, `EMAIL`) 
VALUES ('c62cb541-18a1-40c6-b721-2bb1b0653375', 'admin','AdministratorNemanja', 'ADMIN', 'Nemanja', 'Marjanovic', '123456789123456', 'nemanjam@blic.net');

INSERT INTO `rekomendator`.`USER` (`ID`, `PASSWORD`, `USERNAME`, `ROLE_TITLE`, `NAME`, `SURNAME`, `MBR`, `EMAIL`) 
VALUES ('d4d75e2a-df2e-4cb0-8967-290d73747699', 'super','SuperJelena1234567890', 'SUPER', 'Jelena', 'Marjanovic', '123456789123456', 'nemanjam@blic.net');

-- DATA

INSERT INTO `rekomendator`.`GENRE` (`TITLE`) VALUES ('ACTION');
INSERT INTO `rekomendator`.`GENRE` (`TITLE`) VALUES ('COMEDY');
INSERT INTO `rekomendator`.`GENRE` (`TITLE`) VALUES ('HORROR');
INSERT INTO `rekomendator`.`GENRE` (`TITLE`) VALUES ('CRIME');
INSERT INTO `rekomendator`.`GENRE` (`TITLE`) VALUES ('DOCUMENTARY');
INSERT INTO `rekomendator`.`GENRE` (`TITLE`) VALUES ('SCI-FI');
INSERT INTO `rekomendator`.`GENRE` (`TITLE`) VALUES ('FAMILY');



