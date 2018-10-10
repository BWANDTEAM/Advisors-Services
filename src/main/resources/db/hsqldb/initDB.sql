DROP TABLE advisor_specialties IF EXISTS;
DROP TABLE advisors IF EXISTS;
DROP TABLE specialties IF EXISTS;


CREATE TABLE advisors (
  id         INTEGER IDENTITY PRIMARY KEY,
  first_name VARCHAR(30),
  last_name  VARCHAR(30)
);
CREATE INDEX advisors_last_name ON advisors (last_name);

CREATE TABLE specialties (
  id   INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(80)
);
CREATE INDEX specialties_name ON specialties (name);

CREATE TABLE advisor_specialties (
  advisor_id       INTEGER NOT NULL,
  specialty_id INTEGER NOT NULL
);
ALTER TABLE advisor_specialties ADD CONSTRAINT fk_advisor_specialties_advisors FOREIGN KEY (advisor_id) REFERENCES advisors (id);
ALTER TABLE advisor_specialties ADD CONSTRAINT fk_advisor_specialties_specialties FOREIGN KEY (specialty_id) REFERENCES specialties (id);
