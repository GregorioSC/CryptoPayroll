-- 1) Add columns (nullable for now to avoid failing on existing rows)
ALTER TABLE employees
  ADD COLUMN IF NOT EXISTS first_name VARCHAR(255),
  ADD COLUMN IF NOT EXISTS last_name  VARCHAR(255);

-- 2) Backfill from full_name (best-effort split: first token = first_name, rest = last_name)
UPDATE employees
SET
  first_name = CASE
                 WHEN full_name IS NULL OR full_name = '' THEN NULL
                 ELSE split_part(full_name, ' ', 1)
               END,
  last_name  = CASE
                 WHEN full_name IS NULL OR full_name = '' THEN NULL
                 WHEN strpos(full_name, ' ') = 0 THEN ''                  -- single token name
                 ELSE substring(full_name from position(' ' in full_name)+1)
               END
WHERE first_name IS NULL OR last_name IS NULL;

-- 3) Make them NOT NULL (if you want strictness; otherwise skip these lines)
ALTER TABLE employees
  ALTER COLUMN first_name SET NOT NULL,
  ALTER COLUMN last_name  SET NOT NULL;

-- 4) (Optional) Drop full_name once your code no longer uses it
-- ALTER TABLE employees DROP COLUMN full_name;
