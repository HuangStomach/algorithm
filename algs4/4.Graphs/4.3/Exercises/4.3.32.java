import edu.princeton.cs.algs4.*;

class designatedMST {
    private Queue<Edge> mst;
    private double weight;

    public designatedMST(EdgeWeightedGraph G, Iterable<Edge> S) {
        mst = new Queue<Edge>();
        MinPQ<Edge> pq = new MinPQ<Edge>();
        UF uf = new UF(G.V());

        for (Edge e: S) {
            int v = e.either();
            int w = e.other(v);

            uf.union(v, w);
            mst.enqueue(e);
            weight += e.weight();
        }

        for (Edge e: G.edges()) {
            int v = e.either();
            int w = e.other(v);

            if (uf.connected(v, w)) continue;
            pq.insert(e);
        }
        
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