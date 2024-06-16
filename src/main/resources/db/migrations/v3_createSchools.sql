CREATE TABLE schools (
    id BIGINT NOT NULL AUTO_INCREMENT,
    latitude VARCHAR(255),
    longitude VARCHAR(255),
    name VARCHAR(255),
    security_level INTEGER,
    selected_for_visit BOOLEAN,
    urgent_call BOOLEAN,
    PRIMARY KEY (id)
)
