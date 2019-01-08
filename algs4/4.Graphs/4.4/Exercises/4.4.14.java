import edu.princeton.cs.algs4.*;

class SPT {
    public static void main(String[] args) {
        int V = StdIn.readInt();
        int E = StdIn.readInt();
        EdgeWeightedDigraph G1 = new EdgeWeightedDigraph(V);
        EdgeWeightedDigraph G2 = new EdgeWeightedDigraph(V);
        EdgeWeightedDigraph G3 = new EdgeWeightedDigraph(V);

        // 正常得出最短路径
        for (int i = 0; i < E; i++) {
            int v = StdIn.readInt();
            int w = StdIn.readInt();
            double weight = StdIn.readDouble();
            G1.addEdge(new DirectedEdge(v, w, weight));
            G2.addEdge(new DirectedEdge(v, w, weight + 2.00));
            G3.addEdge(new DirectedEdge(v, w, weight));
        }

        BellmanFordSP bfsp = new BellmanFordSP(G1, 0);
        System.out.print(0);
        for (DirectedEdge e: bfsp.pathTo(1)) {
            System.out.printf(" → [%d %d %.2f]", e.from(), e.to(), e.weight());
        }
        System.out.println();

        // 权重加正值进行计算
        DijkstraSP dsp = new DijkstraSP(G2, 0);
        System.out.print(0);
        for (DirectedEdge e: dsp.pathTo(1)) {
            System.out.printf(" → [%d %d %.2f]", e.from(), e.to(), e.weight());
        }
        System.out.println();

        // 直接计算
        dsp = new DijkstraSP(G3, 0);
        System.out.print(0);
        for (DirectedEdge e: dsp.pathTo(1)) {
            System.out.printf(" → [%d %d %.2f]", e.from(), e.to(), e.weight());
        }
        System.out.println();
    }
}