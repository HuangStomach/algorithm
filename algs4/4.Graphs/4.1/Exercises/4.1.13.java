import java.util.Queue;

import edu.princeton.cs.algs4.*;

public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;
    private int count;

    public BreadthFirstPaths(Graph G, int s) {
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
                if (marked[i]) continue;
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

    public int distTo(int v) {
        return pathTo(v).size();
    }
}