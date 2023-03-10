--liquibase formatted sql
--changeset vlpr:1
INSERT INTO post (id, title, content) values (1, 'Test post 1', 'Content 1');
INSERT INTO post (id, title, content) values (2, 'Test post 2', 'Content 2');
INSERT INTO post (id, title, content) values (3, 'Test post 3', 'Content 3');
INSERT INTO post (id, title, content) values (4, 'Test post 4', 'Content 4');
INSERT INTO post (id, title, content) values (5, 'Test post 5', 'Content 5');
INSERT INTO post (id, title, content) values (6, 'Test post 6', 'Content 6');
INSERT INTO post (id, title, content) values (7, 'Test post 7', 'Content 7');
INSERT INTO post (id, title, content) values (8, 'Test post 8', 'Content 8');
INSERT INTO post (id, title, content) values (9, 'Test post 9', 'Content 9');
INSERT INTO post (id, title, content) values (10, 'Test post 10', 'Content 10');
INSERT INTO post (id, title, content) values (11, 'Test post 11', 'Content 11');
INSERT INTO post (id, title, content) values (12, 'Test post 12', 'Content 12');
INSERT INTO post (id, title, content) values (13, 'Test post 13', 'Content 13');

INSERT INTO comment(id, post_id, content) values (1, 1, 'Content 1');
INSERT INTO comment(id, post_id, content) values (2, 2, 'Content 2');
INSERT INTO comment(id, post_id, content) values (3, 3, 'Content 3');
INSERT INTO comment(id, post_id, content) values (4, 4, 'Content 4');
INSERT INTO comment(id, post_id, content) values (5, 5, 'Content 5');
INSERT INTO comment(id, post_id, content) values (6, 6, 'Content 6');
INSERT INTO comment(id, post_id, content) values (7, 7, 'Content 7');
INSERT INTO comment(id, post_id, content) values (8, 8, 'Content 8');
INSERT INTO comment(id, post_id, content) values (9, 9, 'Content 9');
INSERT INTO comment(id, post_id, content) values (10, 10, 'Content 10');