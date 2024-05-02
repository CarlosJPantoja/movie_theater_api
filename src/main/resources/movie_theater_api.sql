-- CREATE'S --
CREATE TABLE "APP_USER"
(
    "ID"               NUMBER   NOT NULL AUTO_INCREMENT,
    "USERNAME"         VARCHAR2 NOT NULL,
    "PASSWORD"         VARCHAR2 NOT NULL,
    "ENABLED"          BOOLEAN  NOT NULL DEFAULT TRUE,
    "ACCOUNT_EXPIRED"  BOOLEAN  NOT NULL DEFAULT FALSE,
    "ACCOUNT_LOCKED"   BOOLEAN  NOT NULL DEFAULT FALSE,
    "PASSWORD_EXPIRED" BOOLEAN  NOT NULL DEFAULT FALSE,
    "VERSION"          NUMBER   NOT NULL,
    CONSTRAINT "APP_USER_PK" PRIMARY KEY ("ID")
);

CREATE TABLE "APP_ROLE"
(
    "ID"          NUMBER   NOT NULL AUTO_INCREMENT,
    "AUTHORITY"   VARCHAR2 NOT NULL,
    "DESCRIPTION" VARCHAR2 NOT NULL,
    "PROJECT"     VARCHAR2 NOT NULL,
    "VERSION"     NUMBER   NOT NULL,
    CONSTRAINT "APP_ROLE_PK" PRIMARY KEY ("ID")
);

CREATE TABLE "APP_USER_ROLE"
(
    "ID_USER" NUMBER NOT NULL,
    "ID_ROLE" NUMBER NOT NULL,
    CONSTRAINT "APP_USER_ROLE_PK" PRIMARY KEY ("ID_USER", "ID_ROLE"),
    CONSTRAINT "APP_USER_ROLE_USER_FK" FOREIGN KEY ("ID_USER") REFERENCES "APP_USER" ("ID"),
    CONSTRAINT "APP_USER_ROLE_ROLE_FK" FOREIGN KEY ("ID_ROLE") REFERENCES "APP_ROLE" ("ID")
);

-- INSERT'S --
INSERT INTO APP_USER
VALUES (DEFAULT, 'admin@movietheater.com', '$2a$10$Raii9Sk3FctSiSs1DzXn4OAlP938GB74HAbFe/voL.Th6NG8z7DOK', DEFAULT, DEFAULT,
        DEFAULT, DEFAULT, 0);

INSERT INTO APP_ROLE
VALUES (DEFAULT, 'ROLE_ADM', 'ADMINISTRADOR DEL CINE', 'MOVIE_THEATER', 0);

INSERT INTO APP_USER_ROLE
VALUES (1, 1);