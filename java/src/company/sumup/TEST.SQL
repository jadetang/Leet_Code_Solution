SELECT  TO_CHAR('day', 'YYYY-MM-DD') AS day,
    department.name AS department_name,
    SUM( ABS(EXTRACT(epoch FROM timesheet.logout - timesheet.login)/3600) ) AS total_hours
FROM timesheet
INNER JOIN department
ON timesheet.department_id = department.id
GROUP BY department_name, TO_CHAR('day', 'YYYY-MM-DD')
ORDER BY DAY, department_name