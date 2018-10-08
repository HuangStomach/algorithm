// 1.4.24
public class ThrowEgg {
    public static void main(String[] args) {
        int N = 100;
        int F = 78;

        int low = 0;
        int high = 1;
        int mid = 0;
        int eggs = 0;

        while (high < F) {
            low = high;
            high *= 2;
        }

        if (high > N) high = N; // 超过层数了定义为最高层上限
        eggs++; // 鸡蛋摔坏了一个

        while(low < high) {
            mid = low + (high - low) / 2;
            if (mid < F) {
                low = mid + 1;
            }
            else {
                egg++; // 又碎一个
                high = mid  - 1;
            }
        }

        System.out.println(high);
    }
}