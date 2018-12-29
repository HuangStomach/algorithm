import java.util.HashSet;

import edu.princeton.cs.algs4.*;

class VyssotskyMST {
    private Queue<Edge> edges;
    private EdgeWeightedGraph mst;
    private HashSet set;
    private double max;
    
    public VyssotskyMST(EdgeWeightedGraph G) {
        edges = new Queue<Edge>();
        set = new HashSet<Double>();
        mst = new EdgeWeightedGraph(G.V());
        boolean[] marked = new boolean[G.V()];
        for (Edge e: G.edges()) {
            int v = e.either();
            int w = e.other(v);
            if (marked[v] && marked[w]) {
                edges.enqueue(e);
                continue;
            }
            
            marked[v] = true;
            marked[w] = true;
            mst.addEdge(e);
        }

        while (edges.size() > 0) {
            Edge e = edges.dequeue();
            max = e.weight();
            mst.addEdge(e);
            
            int v = e.either();
            dfs(v, e.other(v), e.other(v));
            set.add(max);
        }
    }

    public boolean dfs(int start, int end, int skip) {
        for (Edge e: mst.adj(start)) {
            if (set.contains(e.weight())) continue;

            int v = e.other(start);
            if (v == skip) continue;

            if (v == end || dfs(v, end, start)) {
                max = Math.max(max, e.weight());
                return true;
            }
        }
        return false;
    }

    public Iterable<Edge> edges() {
        Queue<Edge> queue = new Queue<Edge>();
        for (Edge e: mst.edges()) {
            if (set.contains(e.weight())) continue;
            queue.enqueue(e);
        }
        return queue;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        VyssotskyMST mst = new VyssotskyMST(G);
        for (Edge e: mst.edges()) {
            System.out.println(e);
        }
        // System.out.println(mst.weight());
    }
}