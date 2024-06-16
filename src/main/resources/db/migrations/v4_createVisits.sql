CREATE TABLE visits (
    id BIGINT NOT NULL AUTO_INCREMENT,
    idSchool BIGINT,
    idUser BIGINT,
    visit_Date DATE,
    visit_Period VARCHAR(255),
    PRIMARY KEY (id),
    FOREIGN KEY (idSchool) REFERENCES schools(id),
    FOREIGN KEY (idUser) REFERENCES users(id)
)
