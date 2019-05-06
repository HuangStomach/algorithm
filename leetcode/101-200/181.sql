- 超过经理收入的员工
- Employee 表包含所有员工，他们的经理也属于员工。每个员工都有一个 Id，此外还有一列对应员工的经理的 Id。
SELECT A.NAME AS Employee FROM Employee AS A
JOIN Employee AS B ON A.ManagerId = B.Id AND A.Salary > B.Salary