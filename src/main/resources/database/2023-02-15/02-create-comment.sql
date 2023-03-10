--liquibase formatted sql
--changeset vlpr:1
create table if not exists COMMENT (
                                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       post_id BIGINT NOT NULL,
                                       content VARCHAR(2000) NULL,
                                       created timestamp
);

ALTER TABLE COMMENT
    ADD CONSTRAINT comment_post_id
        FOREIGN KEY(post_id) REFERENCES post(id)