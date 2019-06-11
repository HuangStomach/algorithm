-- 第N高的薪水
-- 编写一个 SQL 查询，获取 Employee 表中第 n 高的薪水（Salary）。
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  SET N = N - 1;
  RETURN (
    SELECT
      IFNULL(
        (SELECT DISTINCT Salary AS NthHighestSalary
        FROM Employee
        ORDER BY Salary DESC
        LIMIT 1 OFFSET N),
      NULL) 
      AS NthHighestSalary
  );
END