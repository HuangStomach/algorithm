import java.util.Comparator;

import edu.princeton.cs.algs4.*;

class DijkstraSP {
    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private boolean[] marked;
    private MinPQ<DirectedEdge> pq;
    
    private class ByDistanceFromSource implements Comparator<DirectedEdge> {
        public int compare(DirectedEdge e, DirectedEdge f) {
            double dist1 = distTo[e.from()] + e.weight();
            double dist2 = distTo[f.from()] + f.weight();
            return Double.compare(dist1, dist2);
        }
    }

    public DijkstraSP(EdgeWeightedDigraph G, int s) {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        pq = new MinPQ<DirectedEdge>(new ByDistanceFromSource());

        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;

        for (DirectedEdge e: G.edges()) {
            pq.insert(e);
        }

        while (!pq.isEmpty()) {
            DirectedEdge e = pq.delMin();
            int w = e.to();
            relax(G, w);
        }
    }

    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
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

    public static void main(String[] args) {
        int V = StdIn.readInt();
        int E = StdIn.readInt();

        EdgeWeightedDigraph G = new EdgeWeightedDigraph(V);
        for (int i = 0; i < E; i++) {
            int v = StdIn.readInt();
            int w = StdIn.readInt();
            double weight = StdIn.readDouble();
            G.addEdge(new DirectedEdge(v, w, weight));
        }

        DijkstraSP sp = new DijkstraSP(G, 0);
        for (int v = 0; v < V; v++) {
            System.out.print(v);
            for (DirectedEdge e: sp.pathTo(v)) {
                System.out.printf(" → [%d %d %.2f]", e.from(), e.to(), e.weight());
            }
            System.out.println();
        }
    }
}