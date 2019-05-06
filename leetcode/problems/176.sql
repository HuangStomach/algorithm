- 第二高的薪水
- 编写一个 SQL 查询，获取 Employee 表中第二高的薪水（Salary） 。
SELECT (
SELECT DISTINCT
Salary FROM Employee 
ORDER BY Salary DESC limit 1,1) AS SecondHighestSalary;