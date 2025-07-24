CREATE TABLE asset_types (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20) UNIQUE NOT NULL,
    description VARCHAR(255),
    created_at DATETIME,
    updated_at DATETIME);

ALTER TABLE assets
    ADD COLUMN asset_type_id BIGINT NOT NULL;


ALTER TABLE assets
    ADD CONSTRAINT FK_asset_type
    FOREIGN KEY (asset_type_id) REFERENCES asset_types(id);