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
VALUES (nextval('usr_seq'), TRUE, 'contact@itworkswell.pl', 'admin', 'admin', 'admin', 'b9d7e6c96d2a46e52c6097db7b885c28186cf127aed7bcad41868b96faea27d392c1b503abdd40ffe622ee75bac7049c4781fa925bf325477681410d6b6df48d0461d068e3dd8edcfe945361bb07107eda04c2928db93b5b5afe72b05a09c29c6695744d8a26e636b7d0d9ff773c2e8b5450661fd03b7cee9d74fae036446e56f774e7b99bebde75460c58db6a23fddad07f28263e72b043159aa957da3657c423213fdfa85a1c2fb0236723ce6ef360d1a455679ad758174d1edd8773777ad5aa42668e763986c7e6c13a8fa0e786cfc3b2ab78f5702657b46d96d0', 'salt');

INSERT INTO usr (id, enabled, email, first_name, last_name, user_name, password, salt)
VALUES (nextval('usr_seq'), TRUE, 'contact@itworkswell.pl', 'test', 'test', 'test', 'b9d7e6c96d2a46e52c6097db7b885c28186cf127aed7bcad41868b96f9e125d892c5b45fa88043fae42eec21b8c7059146d0f99c5bf4254b74d2415c6e6cf7d90436d56fe4888ed9f996516fb8501679da00c0c28eec395d5bac70b75b5ec0986391714b8976e73bb2d9dbfb723728845351661fd26c79bc9f74fbe537416f03f627e7bf9ebcdc70455c59d06b78fa8fd02a2b703c74b015169faa50dd3157c7272a3fd8ab5d1c7db0246729ca6bf46fd3f35436988c5e1b4d4fda8571717b85ad1363d2713c84c4e1c03a8f5b70c4b24ef518c7e907025429da3e93', 'salt');

INSERT INTO usr (id, enabled, email, first_name, last_name, user_name, password, salt)
VALUES (nextval('usr_seq'), TRUE, 'contact@itworkswell.pl', 'user', 'user', 'user', 'b9d7e6c96d2a46e52c6097db7b885c28186cf127aed7bcad41868b96fab6258292c0b551a88941afe22ae876bbc407964481f89a58f4224574d246566e64f48c063ad23be28b8edafd92516fbb51167cda00c2918eeb38085afe70e75808c2cd6693714b8a77e461b7dbd9fa723e29d65454661fd1697deb9c20f9e637416e56f527e2eb9fb5de7442095bd36822fa89d32f29723c71b0161593ab02d8665190262e38d4aa0d1c2db5706578cb6ff36fd6f45562988c5a1b4e48ddd373777b85a91464dc756d84c5e6c53a8fb608b1c1e8be5146aa0ad57a4c5a44b8', 'salt');

INSERT INTO usr_role (id, usr_id, role_id) VALUES (nextval('usr_role_seq'), 1, 1);
INSERT INTO usr_role (id, usr_id, role_id) VALUES (nextval('usr_role_seq'), 2, 2);
INSERT INTO usr_role (id, usr_id, role_id) VALUES (nextval('usr_role_seq'), 2, 3);

