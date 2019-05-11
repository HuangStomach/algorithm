/**
 * 供暖器
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 * 现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。
 * 所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。
 */
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        
        int min = 0;
        for (int n : houses) {
            int m = 0;
             // 如果该处房屋的位置比第一处取暖器小 或者比最后一处要大 记录一下极限半径
            if (n <= heaters[0]) m = heaters[0] - n;
            if (n >= heaters[heaters.length - 1])  m = Math.max((n - heaters[heaters.length - 1]), m);
        
            int left = 0;
            int right = heaters.length - 1;
            boolean found = false;
            // 看看该处房屋有没有暖气覆盖
            while (left + 1 < right) {
                int mid = left + (right - left) / 2;
                if (heaters[mid] == n) {
                    found = true;
                    break;
                }
                if (heaters[mid] > n)  right = mid;
                else left = mid;
            }
            
            // 没有覆盖的时候可以取到区间，利用区间计算最小半径
            if (!found) {
                m = Math.max(m, Math.min(heaters[right] - n, n - heaters[left]));
                min = Math.max(min, m);
            }
        }
        
        return min;
    }
}