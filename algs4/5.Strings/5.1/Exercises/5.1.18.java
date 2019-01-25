import java.util.Random;

import edu.princeton.cs.algs4.*;

class RandomString {
    public static void randomDecimalKeys(int N, int W) {
        String[] strs = new String[N];
        Random rn = new Random();
        for (int i = 0; i < N; i++) {
            String str = "";
            int dot = rn.nextInt(W - 1) + 1;
            for (int j = 0; j < W; j++) {
                if (dot == j) str += ".";
                int number = rn.nextInt(10);
                str += number;
            }
            strs[i] = str;
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        randomDecimalKeys(50, 7);
    }
}
