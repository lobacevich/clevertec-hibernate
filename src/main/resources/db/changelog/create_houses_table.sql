create TABLE IF NOT EXISTS houses (
    id SERIAL PRIMARY KEY,
    uuid UUID NOT NULL,
    area VARCHAR(255) NOT NULL,
    country VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    street VARCHAR(255) NOT NULL,
    number INTEGER NOT NULL,
    create_date TIMESTAMP NOT NULL
);

INSERT INTO houses(uuid, area, country, city, street, number, create_date)
VALUES('04978a98-4f44-451a-8d6c-618750b95bbd', 'Минская', 'Беларусь', 'Минск', 'Академическая', 20, '2018-08-29T06:12:15.156'),
      ('580128f9-090f-4e07-8b20-588796788d95', 'Минская', 'Беларусь', 'Минск', 'Воронянского', 31, '2018-08-29T06:12:15.156'),
      ('45f2e21e-5193-4704-accb-5ee63dc2a4a9', 'Минская', 'Беларусь', 'Минск', 'Инженерная', 15, '2018-08-29T06:12:15.156'),
      ('33e6a373-baa2-4e61-8d1c-88a492704722', 'Минская', 'Беларусь', 'Минск', 'Смолячкова', 10, '2018-08-29T06:12:15.156'),
      ('8bd04963-56eb-4bb6-a0eb-aac128020489', 'Минская', 'Беларусь', 'Минск', 'Радиальная', 73, '2018-08-29T06:12:15.156');