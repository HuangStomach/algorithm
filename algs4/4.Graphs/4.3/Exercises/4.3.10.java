import edu.princeton.cs.algs4.*;

class EdgeWeightedGraph {
    private final int V;
    private int E;
    private double[][] weight;
    //private Bag<Edge>[] adj;

    public EdgeWeightedGraph(int v) {
        this.V = v;
        this.E = 0;
        this.weight = new double[v][v];
    }
    
    public EdgeWeightedGraph(In in) {
        this(in.readInt());
        E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            addEdge(v, w, weight);
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w, double weight) {
        this.weight[v][w] = weight;
        this.weight[w][v] = weight;
        E++;
    }

    public Iterable<Edge> adj(int v) {
        Bag<Edge> b = new Bag<Edge>();
        for (int i = 0; i < this.V(); i++) {
            if (this.weight[v][i] > 0) {
                b.add(new Edge(v, i, this.weight[v][i]));
            }
        }
        return b;
    }

    public Iterable<Edge> edges() {
        Bag<Edge> b = new Bag<Edge>();
        for (int v = 0; v < V; v++) {
            for (Edge e: this.adj(v)) {
                if (e.other(v) > v) b.add(e);
            }
        }
        return b;
    }
}