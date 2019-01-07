import edu.princeton.cs.algs4.*;

class EdgeWeightedCycleFinder {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    private boolean[] onStack;

    public EdgeWeightedCycleFinder(EdgeWeightedDigraph G) {
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        for (int i = 0; i < G.V(); i++) {
            if (!marked[i]) dfs(G, i);
        }
    }

    private void dfs(EdgeWeightedDigraph G, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (DirectedEdge e: G.adj(v)) {
            if (this.hasCycle()) return;
            else if (!marked[e.to()]) {
                edgeTo[e.to()] = v;
                dfs(G, e.to());
            }
            else if (onStack[e.to()]) {
                cycle = new Stack<Integer>();
                for (int x = v; x != e.to(); x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(e.to());
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }
}

class EdgeWeightedTopological {
    private Iterable<Integer> order;

    public EdgeWeightedTopological(EdgeWeightedDigraph G) {
        EdgeWeightedCycleFinder cyclefinder = new EdgeWeightedCycleFinder(G);
        if (!cyclefinder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            this.order = dfs.reservePost();
        }
    }

    public Iterable<Integer> order() {
        return order;
    }

    public boolean isDAG() {
        return order != null;
    }
}