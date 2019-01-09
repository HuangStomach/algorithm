import edu.princeton.cs.algs4.*;

class DijkstraSP {
    private int[] t;
    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;

    public DijkstraSP(EdgeWeightedDigraph G, int[] s, int[] t) {
        int start = G.V();
        EdgeWeightedDigraph temp = new EdgeWeightedDigraph(start + 1);
        for (DirectedEdge e: G.edges()) {
            temp.addEdge(e);
        }
        for (int i = 0; i < s.length; i++) {
            temp.addEdge(new DirectedEdge(start, s[i], 0.0));
        }
        G = temp;

        this.t = t;
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        pq = new IndexMinPQ<Double>(G.V());

        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[start] = 0.0;

        pq.insert(start, 0.0);
        while(!pq.isEmpty()) relax(G, pq.delMin());
    }

    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e: G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);
                else if (!Arrays.asList(this.t).contains(w)) {
                    pq.insert(w, distTo[w]);
                }
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
        int V = StdIn.readInt();
        int E = StdIn.readInt();

        EdgeWeightedDigraph G = new EdgeWeightedDigraph(V);
        for (int i = 0; i < E; i++) {
            int v = StdIn.readInt();
            int w = StdIn.readInt();
            double weight = StdIn.readDouble();
            G.addEdge(new DirectedEdge(v, w, weight));
        }

        int[] s = {0, 1};
        DijkstraSP sp = new DijkstraSP(G, s);
        for (int v = 0; v < V; v++) {
            for (DirectedEdge e: sp.pathTo(v)) {
                if (e.from() > V) continue;
                System.out.printf(" → [%d %d %.2f]", e.from(), e.to(), e.weight());
            }
            System.out.println();
        }
    }
}