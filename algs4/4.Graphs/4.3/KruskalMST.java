import edu.princeton.cs.algs4.*;

public class KruskalMST {
    private Queue<Edge> mst;
    private double weight;
    
    public KruskalMST(EdgeWeightedGraph G) {
        mst = new Queue<Edge>();
        weight = 0.0;
        MinPQ<Edge> pq = new MinPQ<Edge>();
        for (Edge e: G.edges()) {
            pq.insert(e);
        }
        UF uf = new UF(G.V());
        
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);

            if (uf.connected(v, w)) continue;
            uf.union(v, w);
            mst.enqueue(e);
            weight += e.weight();
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        return weight;
    }
}
