-- DROP SCHEMA public CASCADE;
-- CREATE SCHEMA public;
--
-- GRANT ALL ON SCHEMA public TO postgres;
-- GRANT ALL ON SCHEMA public TO PUBLIC;

CREATE TABLE usr (
  id                       BIGINT       NOT NULL CONSTRAINT USR_pkey PRIMARY KEY,
  enabled                  BOOLEAN      NOT NULL DEFAULT FALSE,
  expired                  BOOLEAN      NOT NULL DEFAULT FALSE,
  credentials_expired      BOOLEAN      NOT NULL DEFAULT FALSE,
  locked                   BOOLEAN      NOT NULL DEFAULT FALSE,
  last_password_reset_date TIMESTAMP,
  last_update_date         TIMESTAMP,
  first_name               VARCHAR(50)  NOT NULL,
  last_name                VARCHAR(50)  NOT NULL,
  user_name                VARCHAR(50)  NOT NULL CONSTRAINT uk_usr_username UNIQUE,
  email                    VARCHAR(50)  NOT NULL,
  password                 VARCHAR(2048) NOT NULL,
  salt                     VARCHAR(256) NOT NULL,
  modified_by              VARCHAR(255)
);

CREATE SEQUENCE usr_seq;

CREATE TABLE ROLE
(
  id   BIGINT       NOT NULL CONSTRAINT role_pkey PRIMARY KEY,
  name VARCHAR(255) NOT NULL CONSTRAINT uk_role_name UNIQUE
);

CREATE SEQUENCE role_seq;

CREATE TABLE PERMISSION
(
  id        BIGINT       NOT NULL CONSTRAINT permission_pkey PRIMARY KEY,
  name      VARCHAR(255) NOT NULL CONSTRAINT uk_permission_name UNIQUE,
  parent_id BIGINT       NULL CONSTRAINT ref_permission_permission_id REFERENCES PERMISSION (id)
);

CREATE SEQUENCE permission_seq;

CREATE TABLE ROLE_PERMISSION
(
  id            BIGINT  NOT NULL CONSTRAINT role_permission_pkey PRIMARY KEY,
  role_id       BIGINT  NOT NULL CONSTRAINT ref_role_permission_role_id REFERENCES ROLE (id),
  permission_id BIGINT  NOT NULL CONSTRAINT ref_role_permission_permission_id REFERENCES PERMISSION (id),
  c             BOOLEAN NOT NULL DEFAULT TRUE,
  r             BOOLEAN NOT NULL DEFAULT TRUE,
  u             BOOLEAN NOT NULL DEFAULT TRUE,
  d             BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE SEQUENCE role_permission_seq;

CREATE TABLE USR_ROLE
(
  id      BIGINT NOT NULL CONSTRAINT usr_role_pkey PRIMARY KEY,
  usr_id  BIGINT NOT NULL CONSTRAINT usr_role_usr_id REFERENCES USR (id),
  role_id BIGINT NOT NULL CONSTRAINT usr_role_role_id REFERENCES ROLE (id)
);

CREATE SEQUENCE usr_role_seq;