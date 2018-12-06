import edu.princeton.cs.algs4.*;

class Digraph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    public int V() { return V; }

    public int E() { return E; }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    public boolean hasEdge(int v, int w) {
        for (int u: adj[v]) {
            if (w == u) return true;
        }
        return false;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reserve() {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w: adj(v)) {
                R.addEdge(w, v);
            }
        }
        return R;
    }

    public static void main(String[] args) {
        Digraph graph = new Digraph(4);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(0, 3);

        System.out.println(graph.hasEdge(1, 2));
        System.out.println(graph.hasEdge(2, 3));
        System.out.println(graph.hasEdge(0, 3));

        Digraph reserv = graph.reserve();

        System.out.println(reserv.hasEdge(2, 1));
        System.out.println(reserv.hasEdge(3, 2));
        System.out.println(reserv.hasEdge(3, 0));
    }
}