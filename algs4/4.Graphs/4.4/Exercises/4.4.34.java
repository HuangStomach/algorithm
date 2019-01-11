import edu.princeton.cs.algs4.*;

class DijkstraSP {
    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;

    public DijkstraSP(EdgeWeightedDigraph G, int s) {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        pq = new IndexMinPQ<Double>(G.V());

        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;

        for (DirectedEdge e: G.edges()) {
            pq.insert(e.from(), e.weight());
        }

        while (!pq.isEmpty()) {
            int v = pq.delMin();
            for (DirectedEdge e: G.adj(v)) {
                relax(G, v, e);
            }
        }
    }

    private void relax(EdgeWeightedDigraph G, int v, DirectedEdge e) {
        int w = e.to();
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
        }
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
        }
        return path;
    }

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

        DijkstraSP sp = new DijkstraSP(G, 0);
        for (int v = 0; v < V; v++) {
            System.out.print(v);
            for (DirectedEdge e: sp.pathTo(v)) {
                System.out.printf(" → [%d %d %.2f]", e.from(), e.to(), e.weight());
            }
            System.out.println();
        }
    }
}