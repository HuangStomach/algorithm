-- 第N高的薪水
-- 编写一个 SQL 查询，获取 Employee 表中第 n 高的薪水（Salary）。
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
    SELECT (
      IF (
        (SELECT COUNT(*) FROM (SELECT DISTINCT e.Salary FROM Employee e) e) >= N,
        (SELECT MIN(e.Salary) FROM (SELECT DISTINCT e.Salary FROM Employee e ORDER BY e.Salary desc LIMIT N) e), 
        NULL
      )
    )
  );
END