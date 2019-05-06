/**
 * 总持续时间可被 60 整除的歌曲
 * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
 * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望索引的数字  i < j 且有 (time[i] + time[j]) % 60 == 0。
 */
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        if (time.length == 1) return 0;

        int[] list = new int[60];
        for (int i = 0; i < time.length; i++) {
            list[time[i] % 60] += 1;
        }
        
        int count = (list[0] * (list[0] - 1) + list[30] * (list[30] - 1)) / 2;

        for (int i = 1; i < 30; i++) {
            count += list[i] * list[60 - i];
        }

        return count;
    }
}
