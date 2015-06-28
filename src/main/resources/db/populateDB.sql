DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM meals;
ALTER SEQUENCE global_seq RESTART WITH 100000;

-- password
INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password');
-- admin
INSERT INTO users (name, email, password)
VALUES ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES ('ROLE_USER', 100000);
INSERT INTO user_roles (role, user_id) VALUES ('ROLE_ADMIN', 100001);

INSERT INTO meals (user_id, time, calories, description) VALUES (100000,'1994-11-27', 150, 'бутербродик с черной икрой');
INSERT INTO meals (user_id, time, calories, description) VALUES (100000,'1994-11-28', 300, 'лапша мивина');
INSERT INTO meals (user_id, time, calories, description) VALUES (100001,'1994-11-28', 0, 'что такое еда?');
