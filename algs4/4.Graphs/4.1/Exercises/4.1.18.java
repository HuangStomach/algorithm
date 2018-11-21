import java.util.Queue;

import edu.princeton.cs.algs4.*;

class CC {
    private boolean[] marked;
    private int[] id;
    private int count;

    public CC(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            if (!marked[i]) {
                dfs(G, i);
                count++;
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        System.out.print(count + " | ");
        for (int i = 0; i < marked.length; i++) {
            System.out.print((marked[i] ? "T" : "F") + " ");
        }
        System.out.print("| ");
        for (int i = 0; i < id.length; i++) {
            System.out.print(id[i] + " ");
        }
        System.out.println();
        for (int w: G.adj(v)) {
            if (!marked[w]) dfs(G, w);
        }
    }

    public boolean connected(int w, int v) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        String filename = args[0];
        In in = new In(filename);
        Graph g = new Graph(in);
        CC cc = new CC(g);
    }
}