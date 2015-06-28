DROP TABLE IF EXISTS USER_ROLES;
DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS MEALS;
DROP SEQUENCE IF EXISTS GLOBAL_SEQ;

CREATE SEQUENCE GLOBAL_SEQ START 100000;

CREATE TABLE USERS
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('GLOBAL_SEQ'),
  name       VARCHAR,
  email      VARCHAR NOT NULL,
  password   VARCHAR NOT NULL,
  registered TIMESTAMP DEFAULT now(),
  enabled    BOOL DEFAULT TRUE
);
CREATE UNIQUE INDEX unique_email ON USERS (email);

CREATE TABLE USER_ROLES
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE MEALS
(
  user_id INTEGER NOT NULL ,
  time    TIMESTAMP NOT NULL ,
  calories INTEGER NOT NULL ,
  description VARCHAR NOT NULL,
  FOREIGN KEY (user_id) REFERENCES USERS (id) ON DELETE CASCADE
);