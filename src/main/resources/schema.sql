-- DROP TABLE IF EXISTS prices
CREATE TABLE IF NOT EXISTS prices (
                           id INTEGER PRIMARY KEY,
                           source TEXT NOT NULL,
                           instrument TEXT NOT NULL,
                           amount REAL NOT NULL DEFAULT 0,
                           created TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP
);