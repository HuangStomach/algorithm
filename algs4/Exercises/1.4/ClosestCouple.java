import java.util.Arrays;
import java.util.Random;

// 1.4.16
public class ClosestCouple {
    public static void main(String[] args) {
        // 先定义一串double数组 视为输入 不计算入运行时间
        int N = 100;
        double min = 1.0;
        double max = 10.0;
        double[] array = new double[N];
        Random rn = new Random();
        for (int i = 0; i < N; i++) {
            array[i] = min + rn.nextDouble() * (max - min);
        }

        // 先使用并归排序 时间复杂度O(NlogN)
        Arrays.sort(array);

        // 时间复杂度 O(N);
        min = Double.MAX_VALUE;
        for (int i = 0; i < array.length - 1; i++) {
            min = Math.min(min, Math.abs(array[i + 1] - array[i]));
        }

        // 总体时间复杂度 O(NlogN + N) 符合线性对数级别
        System.out.println(min);
    }
}