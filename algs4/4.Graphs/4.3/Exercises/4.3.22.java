import edu.princeton.cs.algs4.*;

public class KruskalMST {
    private Queue<Edge>[] mst;
    
    public KruskalMST(EdgeWeightedGraph G) {
        CC cc = new CC(G);
        mst = new Queue<Edge>[cc.count()];
        
        MinPQ<Edge> pq = new MinPQ<Edge>();
        for (Edge e: G.edges()) {
            pq.insert(e);
        }
        UF[] uf = new UF[cc.count()];
        
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);

            int count = cc.id(v);
            if (uf[count] == null) uf[count] = new UF(cc.size(v));
            if (uf[count].connected(v, w)) continue;

            uf[count].union(v, w);
            mst[count].enqueue(e);
        }
    }

    public Iterable<Edge>[] edges(int count) {
        return mst;
    }
}
