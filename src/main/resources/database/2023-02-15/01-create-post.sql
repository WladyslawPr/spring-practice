--liquibase formatted sql
--changeset vlpr:1
create table if not exists POST (
                                    id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                    title VARCHAR(400) NOT NULL,
                                    content VARCHAR(2000) NULL,
                                    created timestamp
);