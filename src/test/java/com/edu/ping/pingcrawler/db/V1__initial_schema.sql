-- CREATE SEQUENCE id_master_seq
--   INCREMENT 1
--   MINVALUE 1
--   MAXVALUE 9223372036854775807
--   START 6
--   CACHE 1;
DROP TABLE IF EXISTS webpage;
CREATE TABLE webpage
(
    id    bigint                      NOT NULL,
    title varchar(1000) COLLATE "default",
    html  TEXT,
    text  TEXT,
    url   varchar(4096),
    seen  timestamp without time zone NOT NULL,
    primary key (id)
);
