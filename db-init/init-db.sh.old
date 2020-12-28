#!/bin/sh
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL

CREATE TABLE Persistent_Logins (
username varchar(64) not null,
series varchar(64) not null,
token varchar(64) not null,
last_used timestamp not null,
PRIMARY KEY (series)
);

insert into App_User (USER_ID, USER_NAME, ENCRYTED_PASSWORD, ENABLED) values (2, 'dbuser1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', true);
insert into App_User (USER_ID, USER_NAME, ENCRYTED_PASSWORD, ENABLED) values (1, 'dbadmin1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', true);
insert into app_role (ROLE_ID, ROLE_NAME) values (1, 'ROLE_ADMIN');
insert into app_role (ROLE_ID, ROLE_NAME) values (2, 'ROLE_USER');
insert into user_role (ID, USER_ID, ROLE_ID) values (1, 1, 1);
insert into user_role (ID, USER_ID, ROLE_ID) values (2, 1, 2);
insert into user_role (ID, USER_ID, ROLE_ID) values (3, 2, 2);

EOSQL