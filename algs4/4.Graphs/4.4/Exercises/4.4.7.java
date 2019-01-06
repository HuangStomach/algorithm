import edu.princeton.cs.algs4.*;

class DijkstraSP {
    private DirectedEdge[] edgeTo;
    public boolean hashAnotherEdge;
    private DirectedEdge[] anotherEdgeTo;
    private double[] distTo;
    private double[] anotherDistTo;
    private IndexMinPQ<Double> pq;

    public DijkstraSP(EdgeWeightedDigraph G, int s) {
        edgeTo = new DirectedEdge[G.V()];
        anotherEdgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        anotherDistTo = new double[G.V()];
        pq = new IndexMinPQ<Double>(G.V());

        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;

        pq.insert(s, 0.0);
        while(!pq.isEmpty()) relax(G, pq.delMin());
    }

    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e: G.adj(v)) {
            int w = e.to();

            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                anotherEdgeTo[w] = e;
                if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);
                else pq.insert(w, distTo[w]);
            }
            else if (distTo[w] == distTo[v] + e.weight()) {
                anotherEdgeTo[w] = e;
                hashAnotherEdge = true;
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

    public Iterable<DirectedEdge> anotherPathTo(int v) {
        if (!hashAnotherEdge) return null;
        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
        for (DirectedEdge e = anotherEdgeTo[v]; e != null; e = anotherEdgeTo[e.from()]) {
            path.push(e);
        }
        return path;
    }

    public static void main(String[] args) {
        int V = StdIn.readInt();
        int E = StdIn.readInt();

        EdgeWeightedDigraph positive = new EdgeWeightedDigraph(V);
        for (int i = 0; i < E; i++) {
            int v = StdIn.readInt();
            int w = StdIn.readInt();
            double weight = StdIn.readDouble();
            positive.addEdge(new DirectedEdge(v, w, weight));
        }

        DijkstraSP sp = new DijkstraSP(positive, 0);
        for (DirectedEdge e: sp.pathTo(3)) {
            System.out.printf(" → [%d %d %.2f]", e.from(), e.to(), e.weight());
        }
        System.out.println();
        for (DirectedEdge e: sp.anotherPathTo(3)) {
            System.out.printf(" → [%d %d %.2f]", e.from(), e.to(), e.weight());
        }
        System.out.println();
    }
}