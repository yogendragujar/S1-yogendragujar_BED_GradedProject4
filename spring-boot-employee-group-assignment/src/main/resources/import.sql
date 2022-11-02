
insert into users (user_id, username, password) values (1, 'rahul', '$2a$10$OtuDwYtrJtnAHBvE8qmSDu8cPOP7ulv39eoCdztsGY5ykDNWNWZGe');
insert into users (user_id, username, password) values (2, 'neha', '$2a$10$PJm69R7waM9udHFuajfHhOtcg7exPLc.FCNkCMQx0M3WO8.3JNDNC');

insert into role (role_id, role_name) values (1, 'USER');
insert into role (role_id, role_name) values (2, 'ADMIN');

insert into user_roles (role_id, user_id) values (1, 1), (1, 2), (2,2);