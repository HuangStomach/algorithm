import edu.princeton.cs.algs4.*;

class startIndex {
    static int Q = 997;
    static int R = 256;
    static int RM = 1;
    public static void main(String[] args) {
        String pat = args[0];
        String txt = args[1];
        
        RabinKarp rb = new RabinKarp(pat);
        int index = -1;
        int count = 0;

        int num = 0;
        int prev = -1;
        for (int offset: rb.searchAll(txt)) {
            if (prev >= 0) {
                if (offset == prev + pat.length()) num++;
                else num = 0;

                if (num >= 2 && num > count) {
                    index = offset - num * pat.length();
                    count = num;
                }
            }
            prev = offset;
        }
        System.out.println("首次出现位置：" + index);
    }
}
