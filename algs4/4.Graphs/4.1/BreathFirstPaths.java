import java.util.Queue;

import edu.princeton.cs.algs4.*;

public class BreathFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;
    private int count;

    public DepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(v);
        while (queue.size() > 0) {
            int w = queue.dequeue();
            for (int i: G.adj(v)) {
                if (marked[i]) continue;
                edgeTo[w] = i;
                marked[w] = true;
                queue.enqueue(i);
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
}