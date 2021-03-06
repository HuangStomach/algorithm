/** 
 * 猜数字大小
 * 我们正在玩一个猜数字游戏。 游戏规则如下：
 * 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
 * 每次你猜错了，我会告诉你这个数字是大了还是小了。
 * 你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
 * The guess API is defined in the parent class GuessGame.
 * @param num, your guess
 * @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
 * int guess(int num); 
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 0;
        int r = n;
        int mid = 0;
        if (guess(n) == 0) return n;
        while (l < r) {
            mid = l + (r - l) / 2;
            int res = guess(mid);
            if (res == -1) r = mid - 1; 
            else if (guess(mid) == 1) l = mid + 1;
            else return mid;
        }
        return l;
    }
}