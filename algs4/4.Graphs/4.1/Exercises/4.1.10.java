import edu.princeton.cs.algs4.*;

class DepthFirstSearch {
    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph G, int s, int skip) {
        marked = new boolean[G.V()];
        dfs(G, s, skip);
    }

    private void dfs(Graph G, int v, int skip) {
        marked[v] = true;
        count++;
        for (int w: G.adj(v)) {
            if (w == skip) continue;
            if (!marked[w]) dfs(G, w, skip);
        }
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        String filename = args[0];
        In in = new In(filename);
        Graph g = new Graph(in);

        for (int i = 1; i < g.V(); i++) {
            DepthFirstSearch dfs  = new DepthFirstSearch(g, 0, i);
            if (dfs.count == g.V() - 1) {
                System.out.println("顶点" + i + "不影响图的连通性！");
                return;
            }
        }

        DepthFirstSearch dfs  = new DepthFirstSearch(g, 1, 0);
        if (dfs.count == g.V() - 1) {
            System.out.println("顶点0不影响图的连通性！");
            return;
        }

        System.out.println("不存在的。");
    }
}