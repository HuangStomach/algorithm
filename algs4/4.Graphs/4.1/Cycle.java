import edu.princeton.cs.algs4.*;

public class Cycle {
    private boolean[] marked;
    private boolean hashCycle;
    public Cycle(Graph G) {
        marked = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) dfs(G, s, s); 
        }
    }

    private void dfs(Graph G, int v, int u) {
        marked[v] = true;
        for (int w: G.adj(v)) {
            if (!marked[w]) dfs(G, w, v);
            else if (w != u) hashCycle = true;
        }
    }

    public boolean hashCycle() {
        return hashCycle;
    }
}