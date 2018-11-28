import java.util.Random;

import edu.princeton.cs.algs4.*;

class ErdosRenyiGraph {
    public static void main(String[] args) {
        int v = Integer.parseInt(args[0]);
        int e = Integer.parseInt(args[1]);

        Graph g = new Graph(v);
        Random rn = new Random();
        for (int i = 0; i < e; i++) {
            g.addEdge(rn.nextInt(v), rn.nextInt(v));
        }
    }
}