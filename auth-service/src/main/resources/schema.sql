CREATE TABLE IF NOT EXISTS users
(
    id       serial PRIMARY KEY,
    login    VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255)        NOT NULL
);
