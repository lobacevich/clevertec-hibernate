create TABLE IF NOT EXISTS persons (
    id SERIAL PRIMARY KEY,
    uuid UUID NOT NULL,
    passport_series VARCHAR(255) NOT NULL,
    passport_number VARCHAR(255) NOT NULL,
    sex VARCHAR(6) NOT NULL REFERENCES person_sex(sex),
    create_date TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL,
    house_id BIGINT REFERENCES houses(id) NOT NULL,
    UNIQUE(passport_series, passport_number)
);

INSERT INTO persons(uuid, passport_series, passport_number, sex, create_date, update_date, house_id)
VALUES('ce269928-7cc7-401e-ae7b-ecf949f7e73c', 'MP', '3509853', 'MALE', '2018-08-29T06:12:15.156', '2018-08-29T06:12:15.156', 1),
      ('128db5a4-56f9-4f16-a7fe-ccd8d0acb91a', 'MC', '2895433', 'FEMALE', '2018-08-29T06:12:15.156', '2018-08-29T06:12:15.156', 2),
      ('3d229f49-6a9f-4577-b4d1-118afa561413', 'KH', '4239703', 'FEMALE', '2018-08-29T06:12:15.156', '2018-08-29T06:12:15.156', 3),
      ('9cde630d-b508-4ff6-a40d-97d94f4190d1' , 'MP', '9947320', 'MALE', '2018-08-29T06:12:15.156', '2018-08-29T06:12:15.156', 4),
      ('fae0524d-9b7d-4190-be7c-04ada3e92fbf' , 'MP', '6533099', 'MALE', '2018-08-29T06:12:15.156', '2018-08-29T06:12:15.156', 3),
      ('2356e59a-1d8d-4c0a-b0ea-3c5a8eb634c6' , 'MP', '7746355', 'FEMALE', '2018-08-29T06:12:15.156', '2018-08-29T06:12:15.156', 3),
      ('24fec567-516a-4da4-824b-18e88e5d18ac' , 'MP', '1885774', 'MALE', '2018-08-29T06:12:15.156', '2018-08-29T06:12:15.156', 1),
      ('10bbf15d-105d-4e0a-9826-a0dae467d922' , 'MP', '9983699', 'FEMALE', '2018-08-29T06:12:15.156', '2018-08-29T06:12:15.156', 1),
      ('0edc74f9-74b5-4977-8135-4cef16c9e9dc' , 'MP', '6468905', 'FEMALE', '2018-08-29T06:12:15.156', '2018-08-29T06:12:15.156', 1),
      ('1142c867-3ed0-4244-bcdb-d4fd9dcafcc0' , 'MP', '1125355', 'FEMALE', '2018-08-29T06:12:15.156', '2018-08-29T06:12:15.156', 1);