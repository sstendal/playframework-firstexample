# Default schema

# --- !Ups

CREATE TABLE tasks (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    label varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

# --- !Downs

DROP TABLE User;