DROP TABLE IF EXISTS plains;

CREATE TABLE plains
(
    id    SERIAL PRIMARY KEY ,
    name  VARCHAR(200) NOT NULL,
    type VARCHAR(200),
    route VARCHAR(200),
    year INTEGER
);