import edu.princeton.cs.algs4.*;

class BreathFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;
    private int count;

    public BreathFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new Queue<Integer>();
        marked[s] = true;
        queue.enqueue(s);
        while (queue.size() > 0) {
            int v = queue.dequeue();
            for (int w: G.adj(v)) {
                if (marked[w]) continue;
                edgeTo[w] = v;
                marked[w] = true;
                queue.enqueue(w);
            }
        }
    }

    public boolean hasPathTo(int w) {
        return marked[w];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> stack = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x]) {
            stack.push(x);
        }
        stack.push(s);
        return stack;
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        String filename = args[0];
        In in = new In(filename);
        Graph g = new Graph(in);

        BreathFirstPaths dfs  = new BreathFirstPaths(g, 0);
        for (int i = 0; i < g.V(); i++) {
            System.out.print(i + ": ");
            if (dfs.pathTo(i) != null) for (int j: dfs.pathTo(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}