- 上升的温度
- 给定一个 Weather 表，编写一个 SQL 查询，来查找与之前（昨天的）日期相比温度更高的所有日期的 Id。
SELECT A.Id
FROM Weather A
JOIN Weather B
ON A.Temperature > B.Temperature
AND DATEDIFF(A.RecordDate, B.RecordDate) = 1