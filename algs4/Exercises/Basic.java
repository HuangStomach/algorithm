import java.util.Arrays;

public class Basic {

    // 1.1.14 
    public static int lg(int a) {
        a = a > 1 ? a : 1;
        int index = 0;
        int result = 1;
        while (result * 2 <= a) {
            result *= 2;
            index++;
        }
        return index;
    }

    public static void main (String[] args) {
        // 1.1.9
        String s = "";
        for (int n = 1024; n > 0; n /= 2) {
            s = (n % 2) + s;
        }
        System.out.println(s);

        boolean[][] a = {
            { true, true, false },
            { false, true, false },
            { false, true, true }
        };

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j ++) {
                System.out.print(a[i][j] ? "T" : "F");
            }
        }
        System.out.println();

        // 1.1.13
        int[][] b = {
            { 1, 0, 0 },
            { 0, 1, 0 },
            { 0, 0, 1 }
        };
        int[][] c = new int[3][3];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j ++) {
                c[j][i] = b[i][j];
            }
        }

        // 1.1.14
        System.out.println(lg(1025));
    }

}