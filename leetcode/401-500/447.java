/**
 * 回旋镖的数量
 * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 * 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
 */
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int len = points.length;
        int count = 0;
        
        HashMap<Double, Integer> map = new HashMap<Double, Integer>();
        
	    for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) continue;
                double dis = Math.pow(points[i][0] - points[j][0], 2)
                    + Math.pow(points[i][1] - points[j][1], 2);

                if (!map.containsKey(dis)) map.put(dis, 1);
                else {
                    int n = map.get(dis);
                    // 假设当前同一距离的数量为 n, 回旋镖数量为 n * (n - 1),
                    // 在有一个数量的时候 数量为 n * (n + 1)
                    // 相差2n 于是当发现增多的时候 直接补充差值
                    count += 2 * n;
                    map.put(dis, n + 1);
                }
            }
            map.clear(); // 每一个点都是回旋镖的拐点，都是唯一的，由于记录的是距离会重复，每次进行清空
        }

	    return count;
    }
}