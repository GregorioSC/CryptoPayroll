CREATE TABLE employees (
  id           BIGSERIAL PRIMARY KEY,
  email        VARCHAR(255) UNIQUE NOT NULL,
  full_name    VARCHAR(255)        NOT NULL,
  wallet_addr  VARCHAR(64)         NOT NULL,
  salary_usd   NUMERIC(12,2)       NOT NULL,
  is_active    BOOLEAN             NOT NULL DEFAULT true,
  created_at   TIMESTAMPTZ         NOT NULL DEFAULT NOW()
);

CREATE TABLE payroll_runs (
  id            BIGSERIAL PRIMARY KEY,
  period_start  DATE NOT NULL,
  period_end    DATE NOT NULL,
  fx_rate_usd_to_token NUMERIC(18,8) NOT NULL,
  network       VARCHAR(32) NOT NULL,
  status        VARCHAR(32) NOT NULL,
  created_at    TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE TABLE payouts (
  id             BIGSERIAL PRIMARY KEY,
  payroll_run_id BIGINT NOT NULL REFERENCES payroll_runs(id),
  employee_id    BIGINT NOT NULL REFERENCES employees(id),
  amount_token   NUMERIC(36,18) NOT NULL,
  tx_hash        VARCHAR(100),
  status         VARCHAR(32) NOT NULL,
  created_at     TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE INDEX idx_payouts_run ON payouts(payroll_run_id);
