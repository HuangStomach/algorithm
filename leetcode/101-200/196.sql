- 删除重复的电子邮箱
- 编写一个 SQL 查询，来删除 Person 表中所有重复的电子邮箱，重复的邮箱里只保留 Id 最小 的那个。
DELETE A FROM 
Person AS A, 
Person AS B 
WHERE A.Email = B.Email AND A.Id > B.Id;