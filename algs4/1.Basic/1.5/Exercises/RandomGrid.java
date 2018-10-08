import java.util.Random;

import edu.princeton.cs.algs4.*;

// 1.5.18
// 1.5.19
public class RandomGrid {
    private static class Connection {
        public int p;
        public int q;
    
        public Connection (int x, int y) {
            p = x;
            q = y;
        }
    }

    public static RandomBag<Connection> generate(int N) {
        RandomBag<Connection> bag = new RandomBag<Connection>();
        Random random = new Random();

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N - 1; ++j) {
                // 取出每一个点 和横向对应的下一个点 N -1 不取结尾点
                // 1 / 2 几率调换前后点
                if (random.nextInt(10) > 4) {
                    bag.add(new Connection(i * N + j, (i * N) + j + 1));
                }
                else {
                    bag.add(new Connection((i * N) + j + 1, i * N + j));
                }
            }
        }

        for (int j = 0; j < N; ++j) {
            for (int i = 0; i < N - 1; ++i) {
                // 取出每一个点 和横向对应的下一个点 N -1 不取结尾点
                // 1 / 2 几率调换前后点
                if (random.nextInt(10) > 4) {
                    bag.add(new Connection(i * N + j, ((i + 1) * N) + j));
                }
                else {
                    bag.add(new Connection(((i + 1) * N) + j, i * N + j));
                }
            }
        }
        return bag;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        RandomBag<Connection> bag = generate(N);
        QuickUnionUF uf = new QuickUnionUF(N * N);

        StdDraw.setXscale(-1, N);
        StdDraw.setYscale(-1, N);
        for(Connection c: bag) {
            if (c == null) continue;
            
            int p = c.p;
            int q = c.q;
            if (uf.connected(p, q)) continue;

            uf.union(p, q);
            StdDraw.setPenRadius(.05);

            StdDraw.point(p % N, p / N);
            StdDraw.point(q % N, q / N);
            StdDraw.setPenRadius(.005);
            StdDraw.line(p % N, p / N, q % N, q / N);
        }
    }
}
