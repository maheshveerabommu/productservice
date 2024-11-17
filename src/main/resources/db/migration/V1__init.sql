CREATE TABLE category
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    title         VARCHAR(255)          NULL,
    `description` VARCHAR(255)          NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE jt_instructor
(
    id             BIGINT       NOT NULL,
    specialization VARCHAR(255) NULL,
    CONSTRAINT pk_jt_instructor PRIMARY KEY (id)
);

CREATE TABLE jt_mentor
(
    id         BIGINT       NOT NULL,
    company    VARCHAR(255) NULL,
    avg_rating INT          NOT NULL,
    CONSTRAINT pk_jt_mentor PRIMARY KEY (id)
);

CREATE TABLE jt_student
(
    id     BIGINT       NOT NULL,
    course VARCHAR(255) NULL,
    batch  VARCHAR(255) NULL,
    CONSTRAINT pk_jt_student PRIMARY KEY (id)
);

CREATE TABLE jt_user
(
    id           BIGINT       NOT NULL,
    name         VARCHAR(255) NULL,
    email        VARCHAR(255) NULL,
    phone_number VARCHAR(255) NULL,
    password     VARCHAR(255) NULL,
    CONSTRAINT pk_jt_user PRIMARY KEY (id)
);

CREATE TABLE msc_instructor
(
    id             BIGINT       NOT NULL,
    name           VARCHAR(255) NULL,
    email          VARCHAR(255) NULL,
    phone_number   VARCHAR(255) NULL,
    password       VARCHAR(255) NULL,
    specialization VARCHAR(255) NULL,
    CONSTRAINT pk_msc_instructor PRIMARY KEY (id)
);

CREATE TABLE msc_mentor
(
    id           BIGINT       NOT NULL,
    name         VARCHAR(255) NULL,
    email        VARCHAR(255) NULL,
    phone_number VARCHAR(255) NULL,
    password     VARCHAR(255) NULL,
    company      VARCHAR(255) NULL,
    avg_rating   INT          NOT NULL,
    CONSTRAINT pk_msc_mentor PRIMARY KEY (id)
);

CREATE TABLE msc_student
(
    id           BIGINT       NOT NULL,
    name         VARCHAR(255) NULL,
    email        VARCHAR(255) NULL,
    phone_number VARCHAR(255) NULL,
    password     VARCHAR(255) NULL,
    course       VARCHAR(255) NULL,
    batch        VARCHAR(255) NULL,
    CONSTRAINT pk_msc_student PRIMARY KEY (id)
);

CREATE TABLE product
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    title         VARCHAR(255)          NULL,
    `description` VARCHAR(255)          NULL,
    price         DOUBLE                NOT NULL,
    category_id   BIGINT                NULL,
    qty           INT                   NOT NULL,
    stock         INT                   NOT NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE st_user
(
    id             BIGINT       NOT NULL,
    dtype          VARCHAR(31)  NULL,
    name           VARCHAR(255) NULL,
    email          VARCHAR(255) NULL,
    phone_number   VARCHAR(255) NULL,
    password       VARCHAR(255) NULL,
    course         VARCHAR(255) NULL,
    batch          VARCHAR(255) NULL,
    specialization VARCHAR(255) NULL,
    company        VARCHAR(255) NULL,
    avg_rating     INT          NOT NULL,
    CONSTRAINT pk_st_user PRIMARY KEY (id)
);

CREATE TABLE tpc_instructor
(
    id             BIGINT       NOT NULL,
    name           VARCHAR(255) NULL,
    email          VARCHAR(255) NULL,
    phone_number   VARCHAR(255) NULL,
    password       VARCHAR(255) NULL,
    specialization VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_instructor PRIMARY KEY (id)
);

CREATE TABLE tpc_mentor
(
    id           BIGINT       NOT NULL,
    name         VARCHAR(255) NULL,
    email        VARCHAR(255) NULL,
    phone_number VARCHAR(255) NULL,
    password     VARCHAR(255) NULL,
    company      VARCHAR(255) NULL,
    avg_rating   INT          NOT NULL,
    CONSTRAINT pk_tpc_mentor PRIMARY KEY (id)
);

CREATE TABLE tpc_student
(
    id           BIGINT       NOT NULL,
    name         VARCHAR(255) NULL,
    email        VARCHAR(255) NULL,
    phone_number VARCHAR(255) NULL,
    password     VARCHAR(255) NULL,
    course       VARCHAR(255) NULL,
    batch        VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_student PRIMARY KEY (id)
);

CREATE TABLE tpc_user
(
    id           BIGINT       NOT NULL,
    name         VARCHAR(255) NULL,
    email        VARCHAR(255) NULL,
    phone_number VARCHAR(255) NULL,
    password     VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_user PRIMARY KEY (id)
);

ALTER TABLE jt_instructor
    ADD CONSTRAINT FK_JT_INSTRUCTOR_ON_ID FOREIGN KEY (id) REFERENCES jt_user (id);

ALTER TABLE jt_mentor
    ADD CONSTRAINT FK_JT_MENTOR_ON_ID FOREIGN KEY (id) REFERENCES jt_user (id);

ALTER TABLE jt_student
    ADD CONSTRAINT FK_JT_STUDENT_ON_ID FOREIGN KEY (id) REFERENCES jt_user (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);