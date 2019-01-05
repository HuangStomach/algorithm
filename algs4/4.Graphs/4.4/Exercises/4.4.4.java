import edu.princeton.cs.algs4.*;

class SPT {
    public static void main(String[] args) {
        int V = StdIn.readInt();
        int E = StdIn.readInt();

        EdgeWeightedDigraph positive = new EdgeWeightedDigraph(V);
        EdgeWeightedDigraph negative = new EdgeWeightedDigraph(V);
        for (int i = 0; i < E; i++) {
            int v = StdIn.readInt();
            int w = StdIn.readInt();
            double weight = StdIn.readDouble();
            positive.addEdge(new DirectedEdge(v, w, weight));
            negative.addEdge(new DirectedEdge(w, v, weight));
        }

        DijkstraSP pSP = new DijkstraSP(positive, 0);
        DijkstraSP nSP = new DijkstraSP(negative, 0);

        System.out.println("正向 最短路径树");
        for (int v = 1; v < V; v++) {
            if (pSP.pathTo(v) == null) continue;
            System.out.print(v);
            for (DirectedEdge e: pSP.pathTo(v)) {
                System.out.printf(" → [%d %d %.2f]", e.from(), e.to(), e.weight());
            }
            System.out.println();
        }

        System.out.println("反向 最短路径树");
        for (int v = 1; v < V; v++) {
            if (nSP.pathTo(v) == null) continue;
            System.out.print(v);
            for (DirectedEdge e: nSP.pathTo(v)) {
                System.out.printf(" → [%d %d %.2f]", e.from(), e.to(), e.weight());
            }
            System.out.println();
        }
    }
}
