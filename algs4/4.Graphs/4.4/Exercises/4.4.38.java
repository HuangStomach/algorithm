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
                else pq.insert(w, distTo[w]);
            }
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
        In in = new In(args[0]);
        int s = Integer.parseInt(args[1]);
        int t = Integer.parseInt(args[2]);

        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);

        double[][] sensitivity = new double[G.V()][G.V()];
        boolean[][] edges = new boolean[G.V()][G.V()];
        for (DirectedEdge e: G.edges()) {
            edges[e.from()][e.to()] = true;
        }

        DijkstraSP sp = new DijkstraSP(G, s);
        double weight = sp.distTo(t);

        for (int v = 0; v < G.V(); v++) {
            for (int w = 0; w < G.V(); w++) {
                if (!edges[v][w]) continue;
                
                EdgeWeightedDigraph temp = new EdgeWeightedDigraph(G.V());
                for (DirectedEdge e: G.edges()) {
                    if (e.from() == v && e.to() == w) temp.addEdge(new DirectedEdge(v, w, e.weight() + 0.1));
                    else temp.addEdge(e);
                }
                sp = new DijkstraSP(temp, s);
                if (sp.distTo(t) > weight) sensitivity[v][w] = true;
            }
        }
    }
}