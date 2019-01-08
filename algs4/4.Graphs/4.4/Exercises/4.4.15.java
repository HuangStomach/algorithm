import edu.princeton.cs.algs4.*;

class SPT {
    public static void main(String[] args) {
        int V = StdIn.readInt();
        int E = StdIn.readInt();
        EdgeWeightedDigraph G1 = new EdgeWeightedDigraph(V);

        // 正常得出最短路径
        for (int i = 0; i < E; i++) {
            int v = StdIn.readInt();
            int w = StdIn.readInt();
            double weight = StdIn.readDouble();
            G1.addEdge(new DirectedEdge(v, w, weight));
        }

        BellmanFordSP bfsp = new BellmanFordSP(G1, 6);
        System.out.print(6);
        for (DirectedEdge e: bfsp.pathTo(1)) {
            System.out.printf(" → [%d %d %.2f]", e.from(), e.to(), e.weight());
        }
        System.out.println();
    }
}
