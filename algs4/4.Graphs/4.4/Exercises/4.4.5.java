import edu.princeton.cs.algs4.*;

class SPT {
    public static void main(String[] args) {
        int V = StdIn.readInt();
        int E = StdIn.readInt();

        EdgeWeightedDigraph positive = new EdgeWeightedDigraph(V);
        for (int i = 0; i < E; i++) {
            int v = StdIn.readInt();
            int w = StdIn.readInt();
            double weight = StdIn.readDouble();
            positive.addEdge(new DirectedEdge(v, w, weight));
        }

        DijkstraSP pSP = new DijkstraSP(positive, 2);

        System.out.println("正向 最短路径树");
        for (int v = 0; v < V; v++) {
            System.out.print(v);
            if (pSP.pathTo(v) == null) continue;
            for (DirectedEdge e: pSP.pathTo(v)) {
                System.out.printf(" → [%d %d %.2f]", e.from(), e.to(), e.weight());
            }
            System.out.println();
        }
    }
}
