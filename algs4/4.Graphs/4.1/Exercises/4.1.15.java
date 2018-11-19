import edu.princeton.cs.algs4.*;

class Graph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    public Graph(Graph G) {
        this.V = G.V();
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < this.V; v++) {
            for (int w: G.adj(v)) {
                addEdge(v, w);
            }
        }
    }
    
    public Graph(In in) {
        this(in.readInt());
        E = in.readInt();
        in.readLine();
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] array = line.split(" ");
            for (int i = 1; i < array.length; i++) {
                addEdge(Integer.parseInt(array[0]), Integer.parseInt(array[i]));
            }
        }
    }

    public int V() { return V; }

    public int E() { return E; }

    public void addEdge(int v, int w) {
        if (v == w || hasEdge(v, w)) return;
        adj[v].add(w);
        adj[w].add(v);
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

    public String toString() {
        String s = V + " vertices, " + E + " edges \n";
        for (int v = 0; v < V; v++) {
            s += v + "; ";
            for (int w: this.adj(v)) s += w + " ";
            s += "\n";
        }
        return s;
    }

    public static int degree(Graph G, int v) {
        int degree = 0;
        for (int w: G.adj(v)) degree++;
        return degree;
    }

    public static int maxDegree(Graph G) {
        int max = 0;
        for (int v = 0; v < G.V(); v++) {
            if (degree(G, v) > max) max = degree(G, v);
        }
        return max;
    }

    public static double avgDegree(Graph G) {
        return 2.0 * G.E() / G.V();
    }

    public static int numberOfSelfLoops(Graph G) {
        int count = 0;
        for (int v = 0; v < G.V(); v++) {
            for (int w: G.adj(v)) {
                if (v == w) count++;
            }
        }
        return count / 2;
    }

    public static void main(String[] args) {
        String filename = args[0];
        In in = new In(filename);
        Graph g = new Graph(in);
        System.out.println(g.toString());
    }
}