-- src/main/resources/database/data.sql

INSERT INTO employee
  (name, age, position, position_job, report)
VALUES
  ('Alice Johnson', 28, 'Developer',  'Backend',  'No direct reports'),
  ('Bob Santoso',    34, 'Developer',  'Frontend', 'No direct reports'),
  ('Citra Dewi',     40, 'Manager',    'Product',  'Leads 5 engineers'),
  ('Dedi Kusuma',    25, 'Analyst',    'Data',     'Supports BI team');
