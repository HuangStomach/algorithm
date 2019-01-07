import edu.princeton.cs.algs4.*;

class SPT {
    public static void main(String[] args) {
        int V = StdIn.readInt();
        int E = StdIn.readInt();

        EdgeWeightedDigraph G = new EdgeWeightedDigraph(V);
        for (int i = 0; i < E; i++) {
            int v = StdIn.readInt();
            int w = StdIn.readInt();
            double weight = StdIn.readDouble();
            G.addEdge(new DirectedEdge(v, w, weight));
        }

        DijkstraSP sp = new DijkstraSP(G, 1);
        System.out.println("最短路径是:" + sp.distTo(3));
    }
}