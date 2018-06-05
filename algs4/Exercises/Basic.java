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

    // 1.1.15
    public static int[] histogram(int[] a, int m) {
        int[] result = new int[m];
        for (int i = 0; i < a.length; i ++) {
            result[a[i]]++;
        }
        return result;
    }

    // 1.1.19
    public static long[] f = new long[100];
    public static long F(int N) {
        if (Basic.f[N] > 0) return Basic.f[N];
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N - 1) + F(N -2);
    }

    // 1.1.20
    public static long ln(int N) {
        if (N == 1) return 1;
        return N * ln(N - 1);
    }

    // 1.1.24
    public static int gcd(int p, int q) {
        System.out.println(p + " " + q);
        if (p % q == 0) return q;
        return gcd(q, p % q);
    }

    // 1.1.27
    public static double[][] binomials = new double[101][51];
    public static int binomialDeep = 0;
    public static double binomial(int N, int k, double p) {
        System.out.println(Basic.binomialDeep++);
        if (N == 0 && k == 0) return 1.0;
        if (N < 0 || k < 0) return 0.0;
        if (Basic.binomials[N][k] > 0) return Basic.binomials[N][k];
        
        Basic.binomials[N][k] = (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
        return Basic.binomials[N][k];
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

        // 1.1.15
        int[] histogram = { 2, 3, 5, 7, 2, 3, 3, 4, 6, 8, 2, 2, 4, 6, 7, 9, 4, 3, 1 };
        System.out.println(Arrays.toString(histogram(histogram, 10)));

        // 1.1.19 原题是100 不过输出有点多 我懒得看……
        for (int N = 0; N < 10; N++) {
            long result = F(N);
            Basic.f[N] = result;
            System.out.println(N + " " + result);
        }

        // 1.1.20
        System.out.println(ln(4));

        // 1.1.24
        System.out.println("最大公约数是" + gcd(1111111, 1234567));

        // 1.1.27
        binomial(100, 50, 0.25);
    }

}