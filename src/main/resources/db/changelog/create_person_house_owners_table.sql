CREATE TABLE IF NOT EXISTS person_house_owners (
    person_id BIGINT REFERENCES persons(id),
    house_id BIGINT REFERENCES houses(id),
    PRIMARY KEY(person_id, house_id)
);

INSERT INTO person_house_owners (person_id, house_id)
VALUES(1, 1),
      (1, 2),
      (1, 3),
      (3, 1),
      (5, 1);