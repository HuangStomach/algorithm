import edu.princeton.cs.algs4.*;

class FlowNetwork {
    private final int V;
    private int E;
    private Bag<FlowEdge>[] adj;

    public FlowNetwork(int v) {
        this.V = v;
        this.E = 0;
        adj = (Bag<FlowEdge>[]) new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<FlowEdge>();
        }
    }
    
    public FlowNetwork(In in) {
        this(in.readInt());
        E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            addEdge(new FlowEdge(v, w, weight));
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(FlowEdge e) {
        int v = e.either;
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public Iterable<FlowEdge> adj(int v) {
        return adj[v];
    }

    public Iterable<FlowEdge> edges() {
        Bag<FlowEdge> b = new Bag<FlowEdge>();
        for (int v = 0; v < V; v++) {
            for (FlowEdge e: adj[v]) {
                if (e.other(v) > v) b.add(e);
            }
        }
        return b;
    }

    public String toString() {
        String s = V + " vertices, " + E + " edges \n";
        for (int v = 0; v < V; v++) {
            s += v + "; ";
            for (FlowEdge e: this.adj(v)) s += e.other(v) + " ";
            s += "\n";
        }
        return s;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        MST mst = new MST(G);
        for (FlowEdge e: mst.edges()) {
            System.out.println(e);
        }
        System.out.println(mst.weight());
    }
}