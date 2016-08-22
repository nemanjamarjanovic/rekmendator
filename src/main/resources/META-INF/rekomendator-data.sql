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

INSERT INTO `rekomendator`.`USER` (`ID`, `PASSWORD`, `USERNAME`, `ROLE_TITLE`) VALUES ('0', 'guest', 'guest', 'GUEST');
INSERT INTO `rekomendator`.`USER` (`ID`, `PASSWORD`, `USERNAME`, `ROLE_TITLE`) VALUES ('1', 'user', 'user', 'USER');
INSERT INTO `rekomendator`.`USER` (`ID`, `PASSWORD`, `USERNAME`, `ROLE_TITLE`) VALUES ('2', 'super', 'super', 'SUPER');
INSERT INTO `rekomendator`.`USER` (`ID`, `PASSWORD`, `USERNAME`, `ROLE_TITLE`) VALUES ('3', 'admin', 'admin', 'ADMIN');

-- DATA

INSERT INTO `rekomendator`.`ACTOR` (`ID`, `NAME`) VALUES ('0', 'Keanu Reeves');
INSERT INTO `rekomendator`.`ACTOR` (`ID`, `NAME`) VALUES ('1', 'Laurence Fishburne');
INSERT INTO `rekomendator`.`ACTOR` (`ID`, `NAME`) VALUES ('2', 'Hugo Weaving');
INSERT INTO `rekomendator`.`ACTOR` (`ID`, `NAME`) VALUES ('3', 'Carrie-Anne Moss');

INSERT INTO `rekomendator`.`MOVIE` (`ID`, `DESCRIPTION`, `DURATION`, `PUBLISHINGDATE`, `TITLE`) VALUES ('0', 'It depicts a dystopian future in which reality as perceived by most humans is actually a simulated reality called the Matrix, created by sentient machines to subdue the human population, while their bodies heat and electrical activity are used as an energy source. Computer programmer Neo learns this truth and is drawn into a rebellion against the machines, which involves other people who have been freed from the dream world.', '136', '1999-03-31', 'The Matrix');

INSERT INTO `rekomendator`.`GENRE` (`TITLE`) VALUES ('ACTION');
INSERT INTO `rekomendator`.`GENRE` (`TITLE`) VALUES ('SCI-FI');
INSERT INTO `rekomendator`.`MOVIE_GENRE` (`Movie_ID`, `genre_TITLE`) VALUES ('0', 'SCI-FI');
INSERT INTO `rekomendator`.`MOVIE_GENRE` (`Movie_ID`, `genre_TITLE`) VALUES ('0', 'ACTION');

INSERT INTO `rekomendator`.`MOVIE_ACTOR` (`Movie_ID`, `actors_ID`) VALUES ('0', '0');
INSERT INTO `rekomendator`.`MOVIE_ACTOR` (`Movie_ID`, `actors_ID`) VALUES ('0', '1');
INSERT INTO `rekomendator`.`MOVIE_ACTOR` (`Movie_ID`, `actors_ID`) VALUES ('0', '2');
INSERT INTO `rekomendator`.`MOVIE_ACTOR` (`Movie_ID`, `actors_ID`) VALUES ('0', '3');


