import java.util.Comparator;

import edu.princeton.cs.algs4.*;

class KeyEdge {
    private DirectedEdge key;
    
    private class ByDistanceFromSource implements Comparator<DirectedEdge> {
        public int compare(DirectedEdge e, DirectedEdge f) {
            double dist1 = distTo[e.from()] + e.weight();
            double dist2 = distTo[f.from()] + f.weight();
            return Double.compare(dist1, dist2);
        }
    }

    KeyEdge(EdgeWeightedDigraph G, int x, int y) {
        DijkstraSP sp = new DijkstraSP(G, x, null);
        double weight = sp.distTo(y);

        MinPQ<DirectedEdge> pq = new MinPQ<DirectedEdge>(new ByDistanceFromSource());
        for (DirectedEdge e: sp.pathTo(y)) {
            pq.insert(e);
        }

        while (!pq.isEmpty()) {
            DirectedEdge e = pq.delMin();
            sp = new DijkstraSP(G, x, e);
            if (weight < sp.distTo(y)) {
                weight = sp.distTo(y);
                this.key = e;
            }
        }
    }

    public DirectedEdge key() {
        return this.key;
    }
}

class DijkstraSP {
    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;
    private DirectedEdge skip;

    public DijkstraSP(EdgeWeightedDigraph G, int s, DirectedEdge skip) {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        pq = new IndexMinPQ<Double>(G.V());
        this.skip = skip;

        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;

        pq.insert(s, 0.0);
        while(!pq.isEmpty()) relax(G, pq.delMin());
    }

    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e: G.adj(v)) {
            if (this.skip.equals(e)) continue;

            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);
                else pq.insert(w, distTo[w]);
            }
        }
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
        }
        return path;
    }
}
