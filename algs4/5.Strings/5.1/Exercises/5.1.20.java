import java.util.Random;

import edu.princeton.cs.algs4.*;

class RandomString {
    public static void randomFixedLengthWords(int N, int W) {
        String[] strs = new String[N];
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        Random rn = new Random();
        for (int i = 0; i < N; i++) {
            String str = "";
            for (int j = 0; j < W; j++) {
                str += alphabet[rn.nextInt(26)];
            }
            strs[i] = str;
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        randomFixedLengthWords(50, 7);
    }
}
