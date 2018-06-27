import java.util.Random;

// 1.5.17
// 我是真的没能证明出来
public class ErdosRenyi {
    public static int count(int N) {
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N - 1);
        Random random = new Random();

        int count = 0;
        while (uf.count() > 1) {
            int a = random.nextInt(N - 1);
            int b = random.nextInt(N - 1);
            if (!uf.connected(a, b)) {
                uf.union(a, b);    
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        
        int total = 0;
        for (int i = 0; i < 100; ++i) {
            total += count(N);
        }

        System.out.println("实验结果：" + total / 100);
        System.out.println("1/2NlnN：" + Math.log10((double)N) * N * 0.5);
    }
}