public class FurthestCouple {
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

        // 使用遍历 时间复杂度 O(N)
        min = Double.MAX_VALUE;
        max = Double.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) min = array[i];
            if (max < array[i]) max = array[i];
        }

        // 符合线性级别
        System.out.println(Math.abs(max - min));
    }
}