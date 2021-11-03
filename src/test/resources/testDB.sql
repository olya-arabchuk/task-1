DROP SCHEMA IF EXISTS test CASCADE;
CREATE SCHEMA test;

DROP TABLE IF EXISTS plains;
create table test.plains
(
    id    SERIAL PRIMARY KEY ,
    name  VARCHAR(200) NOT NULL,
    type VARCHAR(200),
    route VARCHAR(200),
    year INTEGER
);

INSERT INTO plains(name, type, route, year) VALUES
('c320', 'test Airbus', 'London-Warsaw', 2000),
('c321', 'test Airbus A321ceo', 'Reykjavik-Berlin', 2010);


