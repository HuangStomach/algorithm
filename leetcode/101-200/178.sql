# 分数排名
# 编写一个 SQL 查询来实现分数排名。如果两个分数相同，则两个分数排名（Rank）相同。请注意，平分后的下一个名次应该是下一个连续的整数值。换句话说，名次之间不应该有“间隔”。
SELECT a.score AS Score, COUNT(DISTINCT b.score) AS Rank
FROM scores a, scores b 
WHERE b.score >= a.score 
GROUP BY a.id 
ORDER BY a.score DESC
