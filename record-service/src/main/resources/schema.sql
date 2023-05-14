CREATE TABLE record
(
    id      serial PRIMARY KEY,
    user_id BIGINT       NOT NULL,
    name    VARCHAR(255) NOT NULL
);
