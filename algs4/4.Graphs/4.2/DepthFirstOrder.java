import java.util.Stack;

import edu.princeton.cs.algs4.*;

class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reservePost;

    DepthFirstOrder (Digraph G) {
        pre = new Queue<Integer>();
        post = new Queue<Integer>();
        reservePost = new Stack<Integer>();
        marked = new boolean[G.V()];

        for (int i = 0; i < G.V(); i++) {
            if (!marked[i]) dfs(G, i);
        }
    }

    private void dfs(Digraph G, int v) {
        pre.enqueue(v);

        marked[v] = true;
        for (int w: G.adj(v)) {
            if (!marked[w]) dfs(G, w);
        }

        post.enqueue(v);
        reservePost.push(v);
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post() {
        return post;
    }

    public Integer<Integer> reservePost() {
        return reservePost;
    }
}
