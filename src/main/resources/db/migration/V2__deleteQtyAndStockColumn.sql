ALTER TABLE product
DROP
COLUMN qty;

ALTER TABLE product
DROP
COLUMN stock;

ALTER TABLE st_user
    MODIFY avg_rating INT NOT NULL;

ALTER TABLE st_user
    MODIFY dtype VARCHAR (31) NULL;