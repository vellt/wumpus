CREATE TABLE IF NOT EXISTS hero (
     id IDENTITY NOT NULL PRIMARY KEY,
     shortcut VARCHAR(1) NOT NULL,
     h_column INTEGER NOT NULL,
     h_row INTEGER NOT NULL,
     start_column INTEGER NOT NULL,
     start_row INTEGER NOT NULL,
     arrow_count INTEGER NOT NULL,
     direction INTEGER NOT NULL,
     name VARCHAR(50) NOT NULL,
     step INTEGER NOT NULL,
     gold INTEGER NOT NULL,
     matrix_length INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS field (
     id IDENTITY NOT NULL PRIMARY KEY,
     shortcut VARCHAR(1) NOT NULL,
     f_column INTEGER NOT NULL,
     f_row INTEGER NOT NULL,
     hero_id INTEGER NOT NULL,
     matrix_length INTEGER NOT NULL
);