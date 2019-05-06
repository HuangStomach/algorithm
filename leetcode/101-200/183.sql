- 从不订购的客户
- 某网站包含两个表，Customers 表和 Orders 表。编写一个 SQL 查询，找出所有从不订购任何东西的客户。
SELECT Name AS Customers FROM Customers AS A
WHERE 
NOT EXISTS (SELECT * FROM Orders AS B WHERE B.CustomerId = A.Id)