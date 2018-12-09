import edu.princeton.cs.algs4.*;

class LCA {
    Digraph G;
    int[] length;

    public LCA(Digraph G) {
        this.G = G;
        this.length = new int[G.V()];
        length(0, 0);
    }

    public void length(int s, int path) {
        path++;
        for (int v: G.adj(s)) {
            length[v] = Math.max(length[v], path);
            length(v, path);
        }
    }

    public int ancestor(int v, int w) {
        DirectedCycle dc = new DirectedCycle(G);
        if (dc.hasCycle()) return -1;
        
        DepthFirstDirectedPaths dfs = new DepthFirstDirectedPaths(G, 0);
        Iterable<Integer> vPath = dfs.pathTo(v);
        Iterable<Integer> wPath = dfs.pathTo(w);

        int ancestor = -1;
        while (vPath.hasNext() && wPath.hasNext()) {
            int vNext = vPath.next();
            int wNext = wPath.next();
            if (vNext != wNext) continue;

            int length = this.length[vNext];
            if (ancestor == -1 
            || this.length[vNext] > this.length[ancestor]) {
                ancestor = vNext;
                continue;
            }
        }
        return ancestor;
    }

}
