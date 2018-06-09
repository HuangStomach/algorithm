import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

public class SuffleTest {

    private static void shuffle(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int r = StdRandom.uniform(N - 1);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    // 1.1.36
    public static void main(String[] args) {
        int M = 10;
        int N = Integer.parseInt(args[0]);
        int[][] table = new int[M][M];
        
        for (int i = 0; i < N; i++) {
            int[] array = new int[M];
            for (int j = 0; j < M; j++) {
                array[j] = j;
            }

            shuffle(array);
            for (int j = 0; j < M; j++) {
                for (int m = 0; m < M; m++) {
                    if (j == array[m]) {
                        table[j][m]++;
                    }
                }
            }
        }

        for (int i = 0; i < M; i++) {
            System.out.println(Arrays.toString(table[i]));
        }
    }

}