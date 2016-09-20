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
INSERT INTO `rekomendator`.`PAGE` (`TITLE`, `PAGE`) VALUES ('MOVIE-CREATE', 'movie-edit');
INSERT INTO `rekomendator`.`PAGE` (`TITLE`, `PAGE`) VALUES ('USER-LIST', 'user-list');
INSERT INTO `rekomendator`.`PAGE` (`TITLE`, `PAGE`) VALUES ('GENRE-LIST', 'genre-list');
INSERT INTO `rekomendator`.`PAGE` (`TITLE`, `PAGE`) VALUES ('GENRE-EDIT', 'genre-edit');
INSERT INTO `rekomendator`.`PAGE` (`TITLE`, `PAGE`) VALUES ('EVENT-LIST', 'event-list');
INSERT INTO `rekomendator`.`PAGE` (`TITLE`, `PAGE`) VALUES ('EVENT-EDIT', 'event-edit');
INSERT INTO `rekomendator`.`PAGE` (`TITLE`, `PAGE`) VALUES ('COMMENT-LIST', 'comment-list');
INSERT INTO `rekomendator`.`PAGE` (`TITLE`, `PAGE`) VALUES ('REPORTS', 'reports');

INSERT INTO `rekomendator`.`PERMISSION` (`TITLE`) VALUES ('MOVIE-LIST');
INSERT INTO `rekomendator`.`PERMISSION` (`TITLE`) VALUES ('MOVIE-VIEW');
INSERT INTO `rekomendator`.`PERMISSION` (`TITLE`) VALUES ('MOVIE-EDIT');
INSERT INTO `rekomendator`.`PERMISSION` (`TITLE`) VALUES ('MOVIE-UPLOAD');
INSERT INTO `rekomendator`.`PERMISSION` (`TITLE`) VALUES ('EVENT-ACTIVATION');
INSERT INTO `rekomendator`.`PERMISSION` (`TITLE`) VALUES ('EVENT-PHOTO');
INSERT INTO `rekomendator`.`PERMISSION` (`TITLE`) VALUES ('EVENT-VIEW');
INSERT INTO `rekomendator`.`PERMISSION` (`TITLE`) VALUES ('USER-VIEW');
INSERT INTO `rekomendator`.`PERMISSION` (`TITLE`) VALUES ('USER-EDIT');
INSERT INTO `rekomendator`.`PERMISSION` (`TITLE`) VALUES ('COMMENT-REMOVE');

INSERT INTO `rekomendator`.`ROLE_PAGE` (`Role_TITLE`, `pages_TITLE`) VALUES ('USER', 'MOVIE-ALL');
INSERT INTO `rekomendator`.`ROLE_PAGE` (`Role_TITLE`, `pages_TITLE`) VALUES ('USER', 'MOVIE-SEARCH');
INSERT INTO `rekomendator`.`ROLE_PAGE` (`Role_TITLE`, `pages_TITLE`) VALUES ('USER', 'MOVIE-FAVORITES');
INSERT INTO `rekomendator`.`ROLE_PAGE` (`Role_TITLE`, `pages_TITLE`) VALUES ('USER', 'MOVIE-CREATE');
INSERT INTO `rekomendator`.`ROLE_PAGE` (`Role_TITLE`, `pages_TITLE`) VALUES ('USER', 'EVENT-LIST');

INSERT INTO `rekomendator`.`ROLE_PAGE` (`Role_TITLE`, `pages_TITLE`) VALUES ('SUPER', 'MOVIE-ALL');
INSERT INTO `rekomendator`.`ROLE_PAGE` (`Role_TITLE`, `pages_TITLE`) VALUES ('SUPER', 'MOVIE-SEARCH');
INSERT INTO `rekomendator`.`ROLE_PAGE` (`Role_TITLE`, `pages_TITLE`) VALUES ('SUPER', 'MOVIE-FAVORITES');
INSERT INTO `rekomendator`.`ROLE_PAGE` (`Role_TITLE`, `pages_TITLE`) VALUES ('SUPER', 'MOVIE-CREATE');
INSERT INTO `rekomendator`.`ROLE_PAGE` (`Role_TITLE`, `pages_TITLE`) VALUES ('SUPER', 'EVENT-LIST');
INSERT INTO `rekomendator`.`ROLE_PAGE` (`Role_TITLE`, `pages_TITLE`) VALUES ('SUPER', 'EVENT-EDIT');

INSERT INTO `rekomendator`.`ROLE_PAGE` (`Role_TITLE`, `pages_TITLE`) VALUES ('ADMIN', 'MOVIE-ALL');
INSERT INTO `rekomendator`.`ROLE_PAGE` (`Role_TITLE`, `pages_TITLE`) VALUES ('ADMIN', 'MOVIE-CREATE');
INSERT INTO `rekomendator`.`ROLE_PAGE` (`Role_TITLE`, `pages_TITLE`) VALUES ('ADMIN', 'MOVIE-SEARCH');
INSERT INTO `rekomendator`.`ROLE_PAGE` (`Role_TITLE`, `pages_TITLE`) VALUES ('ADMIN', 'USER-LIST');
INSERT INTO `rekomendator`.`ROLE_PAGE` (`Role_TITLE`, `pages_TITLE`) VALUES ('ADMIN', 'GENRE-LIST');
INSERT INTO `rekomendator`.`ROLE_PAGE` (`Role_TITLE`, `pages_TITLE`) VALUES ('ADMIN', 'GENRE-EDIT');
INSERT INTO `rekomendator`.`ROLE_PAGE` (`Role_TITLE`, `pages_TITLE`) VALUES ('ADMIN', 'EVENT-LIST');
INSERT INTO `rekomendator`.`ROLE_PAGE` (`Role_TITLE`, `pages_TITLE`) VALUES ('ADMIN', 'COMMENT-LIST');
INSERT INTO `rekomendator`.`ROLE_PAGE` (`Role_TITLE`, `pages_TITLE`) VALUES ('ADMIN', 'REPORTS');

INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('USER', 'MOVIE-LIST');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('USER', 'MOVIE-VIEW');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('USER', 'EVENT-VIEW');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('USER', 'MOVIE-EDIT');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('USER', 'USER-EDIT');

INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('SUPER', 'MOVIE-LIST');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('SUPER', 'MOVIE-VIEW');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('SUPER', 'EVENT-VIEW');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('SUPER', 'MOVIE-EDIT');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('SUPER', 'MOVIE-UPLOAD');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('SUPER', 'USER-EDIT');

INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('ADMIN', 'MOVIE-LIST');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('ADMIN', 'MOVIE-VIEW');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('ADMIN', 'MOVIE-EDIT');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('ADMIN', 'USER-VIEW');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('ADMIN', 'USER-EDIT');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('ADMIN', 'EVENT-VIEW');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('ADMIN', 'EVENT-ACTIVATION');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('ADMIN', 'EVENT-PHOTO');
INSERT INTO `rekomendator`.`ROLE_PERMISSION` (`Role_TITLE`, `permissions_TITLE`) VALUES ('ADMIN', 'COMMENT-REMOVE');

INSERT INTO `rekomendator`.`USER` (`ID`, `PASSWORD`, `USERNAME`, `ROLE_TITLE`, `NAME`, `SURNAME`, `MBR`, `EMAIL`, `ACTIVE`) 
VALUES ('c62cb541-18a1-40c6-b721-2bb1b0653375', '41305dc336ca683188da00a90b61045e','AdministratorNemanja', 'ADMIN', 'Nemanja', 'Marjanovic', '123456789123456', 'nemanjam@blic.net', true);

-- DATA

INSERT INTO `rekomendator`.`GENRE` (`TITLE`) VALUES ('ACTION');
INSERT INTO `rekomendator`.`GENRE` (`TITLE`) VALUES ('COMEDY');
INSERT INTO `rekomendator`.`GENRE` (`TITLE`) VALUES ('HORROR');
INSERT INTO `rekomendator`.`GENRE` (`TITLE`) VALUES ('CRIME');
INSERT INTO `rekomendator`.`GENRE` (`TITLE`) VALUES ('DOCUMENTARY');
INSERT INTO `rekomendator`.`GENRE` (`TITLE`) VALUES ('SCI-FI');
INSERT INTO `rekomendator`.`GENRE` (`TITLE`) VALUES ('FAMILY');



