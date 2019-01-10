import edu.princeton.cs.algs4.*;

class DijkstraSP {
    private DirectedEdge[] edgeTo;
    private boolean[] marked;
    private double[] distTo;

    public DijkstraSP(EdgeWeightedDigraph G, int s) {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        pq = new IndexMinPQ<Double>(G.V());

        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;

        for (DirectedEdge e: G.adj(s)) {
            distTo[e.to()] = e.weight();
        }

        for (int v = 0; v < G.V(); v++) {
            double min = Double.POSITIVE_INFINITY;
            int u;
            for (int w = 0; w < G.V(); w++) {
                if (!marked[w] && min > distTo[w]) {
                    min = distTo[w];
                    u = w;
                }
            }

            marked[u] = true;
            for (DirectedEdge e: G.adj(u)) {
                if (distTo[e.to()] > distTo[e.from()] + e.weight()) {
                    distTo[e.to()] = distTo[e.from()] + e.weight();
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
}

class EdgeWeightedDigraph {
    private final int V;
    private int E;
    public double[][] weight;

    public EdgeWeightedDigraph(int v) {
        this.V = v;
        this.E = 0;
        this.weight = new double[v][v];
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                this.weight[i][j] = Double.POSITIVE_INFINITY;
            }
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(DirectedEdge e) {
        this.weight[e.from()][e.to()] = e.weight();
        E++;
    }

    public Iterable<DirectedEdge> adj(int v) {
        Bag<DirectedEdge> adj = new Bag<DirectedEdge>();
        for (int i = 0; i < this.V(); i++) {
            if (weight[v][i] != Double.POSITIVE_INFINITY) {
                adj.add(new DirectedEdge(v, i, weight[v][i]));
            }
        }
        return adj;
    }

    public Iterable<DirectedEdge> edges() {
        Bag<DirectedEdge> bag = new Bag<DirectedEdge>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge e: this.adj(v)) {
                bag.add(e);
            }
        }
        return bag;
    }

    public String toString() {
        String s = V + " vertices, " + E + " edges \n";
        for (int v = 0; v < V; v++) {
            s += v + "; ";
            for (DirectedEdge e: this.adj(v)) s += e.to() + " ";
            s += "\n";
        }
        return s;
    }

}