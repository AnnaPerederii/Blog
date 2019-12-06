DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS posts;

create table users
(
    user_id     BIGINT IDENTITY                    NOT NULL,
    age         INT,
    first_name  VARCHAR(30),
    second_name VARCHAR(30),
    username    varchar(50),
    password    varchar(250),
    created_at  datetime DEFAULT CURRENT_TIMESTAMP NOT NULL
);

create table posts
(
    post_id     BIGINT IDENTITY                    NOT NULL,
    title  VARCHAR(70),
    text VARCHAR(280),
    created_at  datetime DEFAULT CURRENT_TIMESTAMP NOT NULL
);

INSERT INTO posts (title, text) VALUES ('TEST TITLE', 'TEXTETETETETETETETETETET');
