-- Company table
CREATE TABLE company (
    company_id     BIGSERIAL PRIMARY KEY,
    company_name   VARCHAR(255) NOT NULL,
    company_email  VARCHAR(255) UNIQUE NOT NULL,
    company_phone  VARCHAR(255) NOT NULL
);

-- Manager table
CREATE TABLE manager (
    user_id    BIGSERIAL PRIMARY KEY,
    email      VARCHAR(255) UNIQUE NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255) NOT NULL,
    company_id BIGINT NOT NULL REFERENCES company(company_id) ON DELETE CASCADE
);

-- Alter employees to link them to company
ALTER TABLE employees
    ADD COLUMN company_id BIGINT NOT NULL REFERENCES company(company_id) ON DELETE CASCADE;

-- Optional: index for faster lookups
CREATE INDEX idx_employees_company ON employees(company_id);
CREATE INDEX idx_managers_company ON manager(company_id);
