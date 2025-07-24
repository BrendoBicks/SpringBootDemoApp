CREATE TABLE assets (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(20) UNIQUE NOT NULL,
    description VARCHAR(255),
    created_at DATETIME,
    updated_at DATETIME);