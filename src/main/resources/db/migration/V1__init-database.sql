drop table if exists accounts;
drop table if exists blog_posts;
drop table if exists comments;

create table if not exists accounts (
    id  BIGINT PRIMARY KEY AUTO_INCREMENT,
    account_status VARCHAR(32) NOT NULL,
    creation_date DATETIME NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(32) NOT NULL,
    username VARCHAR(255) UNIQUE NOT NULL
) engine = InnoDB;

create table if not exists blog_posts (
    id  BIGINT PRIMARY KEY AUTO_INCREMENT,
    content LONGTEXT NOT NULL,
    created_date DATETIME NOT NULL,
    title VARCHAR(255) NOT NULL,
    account_id BIGINT NOT NULL,
    FOREIGN KEY (account_id) REFERENCES accounts(id)
) engine = InnoDB;

create table comments (
    id  BIGINT PRIMARY KEY AUTO_INCREMENT,
    comment_body LONGTEXT NOT NULL,
    creation_date DATETIME NOT NULL,
    account_id BIGINT NOT NULL,
    post_id BIGINT NOT NULL,
    FOREIGN KEY (account_id) REFERENCES accounts(id),
    FOREIGN KEY (post_id) REFERENCES blog_posts(id)
) engine = InnoDB;
