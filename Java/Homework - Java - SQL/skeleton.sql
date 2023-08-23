-- 1. Write a SQL query that outputs all information about all departments.
Select * from departments;

-- 2. Write a SQL query that outputs all department names.
SELECT name
From departments;

-- 3. Write a SQL query that outputs first and last name of each employee, along with their salary.
SELECT first_name, last_name, salary
FROM employees;

-- 4. Write a SQL query that outputs the full name of each employee.
SELECT
    concat(first_name,' ',last_name) Fullname
FROM
    employees;

-- 5. Write a SQL query to generate an email addresses for each employee. Consider that the email domain is company.com. For example, John Doe's email would be "John.Doe@company.com". The produced column should be named "Full Email Addresses".
ALTER TABLE employees
    ADD `Full Email Addresses` varchar(100);
UPDATE employees e SET e.`Full Email Addresses` = CONCAT(e.first_name,'.',e.last_name,'@company.com');

-- 6. Write a SQL query to find all the different employee salaries.
SELECT DISTINCT salary
FROM employees;

-- 7. Write a SQL query that outputs all information about the employees whose job title is "Sales Representative".
SELECT * FROM employees
where job_title = 'Sales Representative';

-- 8. Write an SQL query to find all employees who have a salary that is bigger than their manager's.
SELECT * FROM employees w, employees m
WHERE w.manager_id = m.employee_id
  AND w.salary > m.salary;

-- 9. Write a SQL query to find the names of all employees whose first name starts with "SA".
SELECT first_name
FROM employees
WHERE first_name REGEXP '^SA';

-- 10. Write a SQL query to find the names of all employees whose last name contains "ei".
SELECT last_name
FROM employees
WHERE last_name LIKE '%ei%';

-- 11. Write a SQL query to find all employees whose salary is in the range [20000…30000].
SELECT * FROM employees
WHERE salary BETWEEN 20000 and 30000;

-- 12. Write a SQL query to find the names of all employees whose salary is 25000, 14000, 12500 or 23600.
SELECT first_name, last_name
FROM employees
WHERE salary IN (25000, 14000, 12500, 23600);

-- 13. Write a SQL query to find all employees that do not have manager.
SELECT * FROM employees
where manager_id is null;

-- 14. Write a SQL query to find the names of all employees who were hired before their managers.
SELECT * FROM employees w, employees m
WHERE w.manager_id = m.employee_id
  AND w.hire_date > m.hire_date;

-- 15. Write a SQL query to find all employees whose salary is more than 50000. Order them in decreasing order, based on their salary.
SELECT * FROM employees
WHERE salary > 50000
order by salary desc;

-- 16. Write a SQL query to find the top 5 best paid employees.
SELECT * FROM employees
order by salary desc
limit 5;

-- 17. Write a SQL query that outputs all employees along their address.
SELECT e.employee_id, e.first_name, e.last_name,a.address_id, a.text as address
FROM employees e
         JOIN addresses a
              ON e.address_id = a.address_id;

-- 18. Write a SQL query to find all employees whose middle name is the same as the first letter of their town.
SELECT e.employee_id, e.first_name,e.middle_name, e.last_name, a.address_id, t.name
FROM employees e
         INNER JOIN addresses a on e.address_id = a.address_id
         INNER JOIN towns t on a.town_id = t.town_id
WHERE left(e.middle_name, 1) = left(t.name, 1);

-- 19. Write a SQL query that outputs all employees (first and last name) that have a manager, along with their manager (first and last name).
SELECT e.first_name, e.last_name, m.first_name, m.last_name AS ManagerName
FROM Employees e
         JOIN Employees m
              ON e.manager_id = m.employee_id;

-- 20. Write a SQL query that outputs all employees that have a manager (first and last name), along with their manager (first and last name) and the employee's address.
SELECT e.first_name, e.last_name, m.first_name, m.last_name AS ManagerName, a.address_id, a.text as address
FROM Employees e
         JOIN addresses a
              ON e.address_id = a.address_id
         JOIN Employees m
              ON e.manager_id = m.employee_id;

-- 21. Write a SQL query to find all departments and all town names in a single column.
SELECT Name
FROM Departments
UNION
SELECT Name
FROM Towns;

-- 22. Write a SQL query to find all employees and their manager, along with the employees that do not have manager. If they do not have a manager, output "n/a".
SELECT e.first_name, e.last_name, m.first_name, m.last_name AS ManagerName
FROM Employees e
         LEFT OUTER JOIN Employees m
                         ON e.manager_id = m.employee_id;

-- 23. Write a SQL query to find the names of all employees from the departments "Sales" AND "Finance" whose hire year is between 1995 and 2005.
SELECT * FROM employees
WHERE department_id in (3, 10)
  AND YEAR(`hire_date`) >= 1995
  AND YEAR(`hire_date`) <= 2005;
