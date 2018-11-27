import edu.princeton.cs.algs4.*;

public class SymbolGraph {
    private ST<String, Integer> st;
    private ST<Integer, String> keys;
    
    private final int V;
    private int E;
    private ST<Integer, Bag<Integer>> adj;

    public SymbolGraph(String stream, String sp) {
        this.V = 0;
        this.E = 0;
        adj = new ST<Integer, Bag<Integer>>();
        st = new ST<String, Integer>();
        keys = new ST<String, Integer>();
        In in = new In(stream);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(sp);
            if (!st.contains(a[0])) {
                int size = st.size();
                st.put(a[i], size);
                keys.put(size, a[i]);
                this.V++;
            }
            int v = st.get(a[0]);

            for (int i = 1; i < a.length; i++) {
                if (st.contains(a[i])) continue;

                int size = st.size();
                st.put(a[i], size);
                keys.put(size, a[i]);
                this.addEdge(v, size);
                this.V++;
            }
        }
    }

    public boolean contains(String s) {
        return st.contains(s);
    }

    public int index(String s) {
        return st.get(s);
    }

    public String name(int v) {
        return keys.get(v);
    }

    public int V() { return V; }

    public int E() { return E; }

    public void addEdge(int v, int w) {
        if (v == w || hasEdge(v, w)) return;
        adj.get(v).add(w);
        adj.get(w).add(v);
        E++;
    }

    public boolean hasEdge(int v, int w) {
        for (int u: adj.get(v)) {
            if (w == u) return true;
        }
        return false;
    }

    public Iterable<Integer> adj(int v) {
        return adj.get(v);
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

    public static void main(String[] args) {
        String filename = args[0];
        STring delim = args[1];
        SymboalGraph sg = new SymbolGraph(filename, delim);

        Graph G = sg.G();

        while (StdIn.hasNextLine()) {
            String source = StdIn.readLine();
            for (int w: G.adj(sg.index(source))) {
                System.out.println(" " + sg.name(w));
            }
        }
    }
}