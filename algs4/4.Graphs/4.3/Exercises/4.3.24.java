
import java.util.HashSet;

import edu.princeton.cs.algs4.*;

class DeleteMST {
    private Queue<Edge> mst;
    private HashSet set;

    public DeleteMST(EdgeWeightedGraph G) {
        mst = new Queue<Edge>();
        set = new HashSet<Double>();
        MaxPQ<Edge> pq = new MaxPQ<Edge>();
        for (Edge e: G.edges()) {
            pq.insert(e);
        }
        
        while (pq.size() > 0) {
            Edge max = pq.delMax();
            EdgeWeightedGraph temp = new EdgeWeightedGraph(G.V());
            for (Edge e: G.edges()) {
                if (set.contains(e.weight()) || e.weight() == max.weight()) continue;
                temp.addEdge(e);
            }

            CC cc = new CC(temp);
            if (cc.count() > 1) mst.enqueue(max);
            else set.add(max.weight());
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        DeleteMST mst = new DeleteMST(G);
        for (Edge e: mst.edges()) {
            System.out.println(e);
        }
        // System.out.println(mst.weight());
    }
}
