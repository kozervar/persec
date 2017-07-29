INSERT INTO permission (id, name, parent_id) VALUES (nextval('permission_seq'), 'RootPermission', NULL);
INSERT INTO permission (id, name, parent_id) VALUES (nextval('permission_seq'), 'SpecialPermission', NULL);
INSERT INTO permission (id, name, parent_id) VALUES (nextval('permission_seq'), 'UserPermission', NULL);
INSERT INTO permission (id, name, parent_id) VALUES (nextval('permission_seq'), 'PlainUserPermission', NULL);
INSERT INTO permission (id, name, parent_id) VALUES (nextval('permission_seq'), 'GuestPermission', NULL);
INSERT INTO permission (id, name, parent_id) VALUES (nextval('permission_seq'), 'User', NULL);
INSERT INTO permission (id, name, parent_id) VALUES (nextval('permission_seq'), 'UserPanel', 6);
INSERT INTO permission (id, name, parent_id) VALUES (nextval('permission_seq'), 'PermissionPanel', 6);

INSERT INTO role (id, name) VALUES (nextval('role_seq'), 'ROOT');
INSERT INTO role (id, name) VALUES (nextval('role_seq'), 'USER');
INSERT INTO role (id, name) VALUES (nextval('role_seq'), 'PLAIN_USER');
INSERT INTO role (id, name) VALUES (nextval('role_seq'), 'GUEST');

INSERT INTO role_permission (id, role_id, permission_id, c, r, u, d)
VALUES (nextval('role_permission_seq'), 1, 1, TRUE, TRUE, TRUE, TRUE);
INSERT INTO role_permission (id, role_id, permission_id, c, r, u, d)
VALUES (nextval('role_permission_seq'), 1, 2, TRUE, TRUE, TRUE, TRUE);
INSERT INTO role_permission (id, role_id, permission_id, c, r, u, d)
VALUES (nextval('role_permission_seq'), 1, 3, TRUE, TRUE, TRUE, TRUE);
INSERT INTO role_permission (id, role_id, permission_id, c, r, u, d)
VALUES (nextval('role_permission_seq'), 1, 4, TRUE, TRUE, TRUE, TRUE);
INSERT INTO role_permission (id, role_id, permission_id, c, r, u, d)
VALUES (nextval('role_permission_seq'), 1, 5, TRUE, TRUE, TRUE, TRUE);

INSERT INTO role_permission (id, role_id, permission_id, c, r, u, d)
VALUES (nextval('role_permission_seq'), 2, 3, TRUE, TRUE, TRUE, TRUE);
INSERT INTO role_permission (id, role_id, permission_id, c, r, u, d)
VALUES (nextval('role_permission_seq'), 2, 4, TRUE, TRUE, TRUE, TRUE);
INSERT INTO role_permission (id, role_id, permission_id, c, r, u, d)
VALUES (nextval('role_permission_seq'), 2, 5, TRUE, TRUE, TRUE, TRUE);

INSERT INTO role_permission (id, role_id, permission_id, c, r, u, d)
VALUES (nextval('role_permission_seq'), 3, 4, TRUE, TRUE, TRUE, TRUE);
INSERT INTO role_permission (id, role_id, permission_id, c, r, u, d)
VALUES (nextval('role_permission_seq'), 3, 5, TRUE, TRUE, TRUE, TRUE);

INSERT INTO role_permission (id, role_id, permission_id, c, r, u, d)
VALUES (nextval('role_permission_seq'), 4, 5, TRUE, TRUE, TRUE, TRUE);

INSERT INTO role_permission (id, role_id, permission_id, c, r, u, d)
VALUES (nextval('role_permission_seq'), 1, 6, TRUE, TRUE, TRUE, TRUE);

INSERT INTO role_permission (id, role_id, permission_id, c, r, u, d)
VALUES (nextval('role_permission_seq'), 1, 7, TRUE, TRUE, TRUE, TRUE);

INSERT INTO role_permission (id, role_id, permission_id, c, r, u, d)
VALUES (nextval('role_permission_seq'), 1, 8, TRUE, TRUE, TRUE, TRUE);

INSERT INTO usr (id, enabled, email, first_name, last_name, user_name, password, salt)
VALUES (nextval('usr_seq'), TRUE, 'contact@itworkswell.pl', 'admin', 'admin', 'admin', 'admin', 'salt');

INSERT INTO usr (id, enabled, email, first_name, last_name, user_name, password, salt)
VALUES (nextval('usr_seq'), TRUE, 'contact@itworkswell.pl', 'test', 'test', 'test', 'test', 'salt');

INSERT INTO usr_role (id, usr_id, role_id) VALUES (nextval('usr_role_seq'), 1, 1);
INSERT INTO usr_role (id, usr_id, role_id) VALUES (nextval('usr_role_seq'), 2, 2);
INSERT INTO usr_role (id, usr_id, role_id) VALUES (nextval('usr_role_seq'), 2, 3);

