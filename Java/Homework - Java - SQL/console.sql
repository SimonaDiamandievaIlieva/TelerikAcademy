# 1.
Select * from departments;

# 2.
SELECT name
From departments;

# 3.
SELECT first_name, last_name, salary
FROM employees;

# 4.
SELECT
    concat(first_name,' ',last_name) Fullname
FROM
    employees;

# 5.
ALTER TABLE employees
ADD `Full Email Addresses` varchar(100);
UPDATE employees e SET e.`Full Email Addresses` = CONCAT(e.first_name,'.',e.last_name,'@company.com');

# 6.
SELECT DISTINCT salary
FROM employees;

# 7.
SELECT * FROM employees
where job_title = 'Sales Representative';

# 8.
SELECT * FROM employees w, employees m
WHERE w.manager_id = m.employee_id
AND w.salary > m.salary;

# 9.
SELECT first_name
FROM employees
WHERE first_name REGEXP '^SA';

# 10.
SELECT last_name
FROM employees
WHERE last_name LIKE '%ei%';

# 11.
SELECT * FROM employees
WHERE salary BETWEEN 20000 and 30000;

# 12.
SELECT first_name, last_name
FROM employees
WHERE salary IN (25000, 14000, 12500, 23600);

# 13.
SELECT * FROM employees
where manager_id is null;

# 14.
SELECT * FROM employees w, employees m
WHERE w.manager_id = m.employee_id
AND w.hire_date > m.hire_date;

# 15.
SELECT * FROM employees
WHERE salary > 50000
order by salary desc;

# 16.
SELECT * FROM employees
order by salary desc
limit 5;

# 17.
SELECT e.employee_id, e.first_name, e.last_name,a.address_id, a.text as address
FROM employees e
         JOIN addresses a
              ON e.address_id = a.address_id;

# 18.
SELECT e.employee_id, e.first_name,e.middle_name, e.last_name, a.address_id, t.name
FROM employees e
INNER JOIN addresses a on e.address_id = a.address_id
INNER JOIN towns t on a.town_id = t.town_id
WHERE left(e.middle_name, 1) = left(t.name, 1);

# 19.
SELECT e.first_name, e.last_name, m.first_name, m.last_name AS ManagerName
FROM Employees e
         JOIN Employees m
            ON e.manager_id = m.employee_id;

# 20.
SELECT e.first_name, e.last_name, m.first_name, m.last_name AS ManagerName, a.address_id, a.text as address
FROM Employees e
    JOIN addresses a
    ON e.address_id = a.address_id
     JOIN Employees m
    ON e.manager_id = m.employee_id;

# 21.
SELECT Name
FROM Departments
UNION
SELECT Name
FROM Towns;

# 22.
SELECT e.first_name, e.last_name, m.first_name, m.last_name AS ManagerName
FROM Employees e
    LEFT OUTER JOIN Employees m
                    ON e.manager_id = m.employee_id;

# 23.
SELECT * FROM employees
WHERE department_id in (3, 10)
  AND YEAR(`hire_date`) >= 1995
  AND YEAR(`hire_date`) <= 2005;