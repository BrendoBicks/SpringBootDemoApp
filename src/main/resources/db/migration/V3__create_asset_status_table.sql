CREATE TABLE asset_status (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20),
    code VARCHAR(3) NOT NULL,
    description VARCHAR(255),
    created_at DATETIME,
    updated_at DATETIME);


ALTER TABLE assets
    ADD COLUMN asset_status_id BIGINT NOT NULL;


ALTER TABLE assets
    ADD CONSTRAINT FK_asset_status
        FOREIGN KEY (asset_status_id) REFERENCES asset_status(id);