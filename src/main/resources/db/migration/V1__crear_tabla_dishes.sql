CREATE TABLE dishes (
    id UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    food_type VARCHAR(50) NOT NULL CHECK (food_type IN ('APERITIVO', 'PLATO_PRINCIPAL', 'GUARNICION', 'POSTRE','BEBIDA')),
    chef VARCHAR(100) NOT NULL,
    description TEXT,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);
