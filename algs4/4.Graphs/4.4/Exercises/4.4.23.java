import edu.princeton.cs.algs4.*;

class DijkstraSP {
    private int t;
    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;

    public DijkstraSP(EdgeWeightedDigraph G, int s, int t) {
        this.t = t;
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        pq = new IndexMinPQ<Double>(G.V());

        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;

        pq.insert(s, 0.0);
        while(!pq.isEmpty()) relax(G, pq.delMin());
    }

    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e: G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);
                else if (w != t) pq.insert(w, distTo[w]);
            }
        }
    }

    public double distTo() {
        return distTo[t];
    }

    public boolean hasPathTo() {
        return distTo[t] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo() {
        if (!hasPathTo()) return null;
        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
        for (DirectedEdge e = edgeTo[t]; e != null; e = edgeTo[e.from()]) {
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

        DijkstraSP sp = new DijkstraSP(G, 0, 6);
        for (DirectedEdge e: sp.pathTo()) {
            System.out.printf(" → [%d %d %.2f]", e.from(), e.to(), e.weight());
        }
        System.out.println();
    }
}