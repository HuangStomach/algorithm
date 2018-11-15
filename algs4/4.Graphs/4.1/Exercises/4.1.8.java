import edu.princeton.cs.algs4.*;

public class Search {
    private int[] id;
    private int[] sz;
    private int s;
    private int count;

    public Search(Graph G, int s) {
        count = G.V();
        this.s = s;
        id = new int[G.V()];
        for (int i = 0; i < N; i++) id[i] = i;
        sz = new int[G.V()];
        for (int i = 0; i < N; i++) sz[i] = 1;
        dfs(G, v);
    }

    private void dfs(Graph G, int v) {
        union(this.s, v);
        for (int w: G.adj(v)) {
            if (!marked[w]) dfs(G, w);
        }
    }

    public boolean marked(int w) {
        return find(s) == find(w);
    }

    private int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    private void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[i] += sz[j];
        }
        else {
            id[j] = i;
            sz[j] += sz[i];
        }
        count--;
    }

    public int count() {
        return count;
    }
}