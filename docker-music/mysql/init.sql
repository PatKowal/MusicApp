CREATE TABLE `album`
(
    `id`   int          NOT NULL AUTO_INCREMENT,
    `logo` varchar(255) NOT NULL,
    `name` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `artist`
(
    `id`        int          NOT NULL AUTO_INCREMENT,
    `firstname` varchar(255) NOT NULL,
    `lastname`  varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `track`
(
    `id`          int          NOT NULL AUTO_INCREMENT,
    `title`      varchar(255) NOT NULL,
    `duration`      int DEFAULT NULL,
    `artist_id` int   DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `track_album`
(
    `track_id`  int DEFAULT NULL,
    `album_id` int DEFAULT NULL
);

-- INSERTY DLA ALBUM (zamiast cinema)
INSERT INTO `album`(`id`, `logo`, `name`)
VALUES ('1', 'https://upload.wikimedia.org/wikipedia/en/4/42/Queen_A_Night_At_The_Opera.png', 'A Night at the Opera');
INSERT INTO `album`(`id`, `logo`, `name`)
VALUES ('2', 'https://upload.wikimedia.org/wikipedia/en/f/f5/Dua_Lipa_-_Future_Nostalgia.png', 'Future Nostalgia');
INSERT INTO `album`(`id`, `logo`, `name`)
VALUES ('3', 'https://upload.wikimedia.org/wikipedia/en/0/03/Hans_Zimmer_Inception_OST.jpg', 'Inception OST');
INSERT INTO `album`(`id`, `logo`, `name`)
VALUES ('4', 'https://upload.wikimedia.org/wikipedia/en/9/9c/MilesDavisKindofBlue.jpg', 'Kind of Blue');
INSERT INTO `album`(`id`, `logo`, `name`)
VALUES ('5', 'https://upload.wikimedia.org/wikipedia/en/a/a0/Lady_Gaga_-_Chromatica.png', 'Chromatica');

-- INSERTY DLA ARTIST (zamiast director)
INSERT INTO `artist`(`id`, `firstname`, `lastname`)
VALUES ('1', 'Freddie', 'Mercury');
INSERT INTO `artist`(`id`, `firstname`, `lastname`)
VALUES ('2', 'Dua', 'Lipa');
INSERT INTO `artist`(`id`, `firstname`, `lastname`)
VALUES ('3', 'Hans', 'Zimmer');
INSERT INTO `artist`(`id`, `firstname`, `lastname`)
VALUES ('4', 'Miles', 'Davis');
INSERT INTO `artist`(`id`, `firstname`, `lastname`)
VALUES ('5', 'Lady', 'Gaga');

-- INSERTY DLA TRACK (zamiast movie)
-- (id, title, duration, artist_id)
INSERT INTO `track`(`id`, `title`, `duration`, `artist_id`)
VALUES ('1', 'Bohemian Rhapsody', '354', '1');
INSERT INTO `track`(`id`, `title`, `duration`, `artist_id`)
VALUES ('2', 'Levitating', '203', '2');
INSERT INTO `track`(`id`, `title`, `duration`, `artist_id`)
VALUES ('3', 'Time', '275', '3');
INSERT INTO `track`(`id`, `title`, `duration`, `artist_id`)
VALUES ('4', 'So What', '562', '4');
INSERT INTO `track`(`id`, `title`, `duration`, `artist_id`)
VALUES ('5', 'Stupid Love', '193', '5');

-- INSERTY DLA TRACK_ALBUM (zamiast movie_cinema)
INSERT INTO `track_album`(`track_id`, `album_id`)
VALUES ('1', '1');
INSERT INTO `track_album`(`track_id`, `album_id`)
VALUES ('2', '2');
INSERT INTO `track_album`(`track_id`, `album_id`)
VALUES ('3', '3');
INSERT INTO `track_album`(`track_id`, `album_id`)
VALUES ('4', '4');
INSERT INTO `track_album`(`track_id`, `album_id`)
VALUES ('5', '5');

-- UŻYTKOWNICY I ROLE (bez zmian)
CREATE TABLE user
(
    id       int primary key auto_increment,
    username VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE role
(
    id       int primary key auto_increment,
    username VARCHAR(255),
    role     VARCHAR(255)
);

INSERT INTO user(username, password)
VALUES ('dbuser1', '$2a$10$eiA5dKnoUk77EKXZhJvq7O3XBy5ECYupA0FCEm0gS58QSY6PoPcOS'),
       ('dbuser2', '$2a$10$eiA5dKnoUk77EKXZhJvq7O3XBy5ECYupA0FCEm0gS58QSY6PoPcOS'),
       ('dbuser3', '$2a$10$eiA5dKnoUk77EKXZhJvq7O3XBy5ECYupA0FCEm0gS58QSY6PoPcOS');


INSERT INTO role(username, role)
VALUES ('dbuser1', 'USER_ADMIN'),
       ('dbuser2', 'AUTHOR_ADMIN'),
       ('dbuser3', 'BOOK_ADMIN');




