import java.util.Random;

import edu.princeton.cs.algs4.*;

class RandomString {
    public static void randomPlatesCA(int N) {
        String[] strs = new String[N];
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        Random rn = new Random();
        for (int i = 0; i < N; i++) {
            String str = Integer.toString(rn.nextInt(9) + 1);

            for (int j = 0; j < 3; j++) {
                str += alphabet[rn.nextInt(26)];
            }
            for (int j = 0; j < 3; j++) {
                str += rn.nextInt(10);
            }
            strs[i] = str;
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        randomPlatesCA(50);
    }
}
