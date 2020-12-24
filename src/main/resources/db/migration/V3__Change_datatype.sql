DROP TABLE IF EXISTS book;
CREATE TABLE book (
                      id bigint NOT NULL,
                      created_date timestamp NOT NULL,
                      last_modified_date timestamp NOT NULL,
                      version integer NOT NULL,
                      author varchar(255) NOT NULL,
                      isbn varchar(255) NOT NULL,
                      price float8 NOT NULL,
                      publishing_year integer,
                      title varchar(255) NOT NULL,
                      PRIMARY KEY (id),
                      UNIQUE (isbn)
);