import java.util.Queue;

import edu.princeton.cs.algs4.*;

public class KosarajuSCC {
    private Digraph G;
    private boolean[] marked;
    private int[] id;
    private int count;

    public KosarajuSCC(Digraph G) {
        this.G = G;
        marked = new boolean[G.V()];
        id = new int[G.V()];
        DepthFirstOrder order = new DepthFirstOrder(G.reserve());
        for (int s: order.reservePost()) {
            if (!marked[s]) {
                dfs(G, s);
                count++;
            }
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w: G.adj(v)) {
            if (!marked[w]) dfs(G, w);
        }
    }

    public boolean stronglyConnected(int w, int v) {
        return id[v] == id[w];
    }

    public Digraph scc(int v) {
        Digraph tmp = new Digraph(this.G.V());
        boolean[] marked = new boolean[this.marked.length];
        sccdfs(tmp, marked, v);
        return tmp;
    }

    private void sccDfs(Digraph tmp, boolean[] marked, int v) {
        for (int w: this.G.adj(v)) {
            if (!marked[w]) {
                tmp.addEdge(v, w);
                dfs(G, w);
            }
        }
    }

    public Digraph[] allScc(int v) {
        Digraph[] tmps = new Digraph[this.count];
        for (int i = 0; i < id.length; i++) {
            if (tmps[id[i]] == null) tmps[id[i]] = scc(i);
        }
        return tmps;
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }
}
