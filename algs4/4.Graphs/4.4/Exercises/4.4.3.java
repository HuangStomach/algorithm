import edu.princeton.cs.algs4.*;

class EdgeWeightedDigraph {
    private final int V;
    private int E;
    private double[][] weight;

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