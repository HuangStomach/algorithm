import java.util.Comparator;

public class LazyDijkstraSP {
    private boolean[] marked;        // has vertex v been relaxed?
    private double[] distTo;         // distTo[v] = length of shortest s->v path
    private DirectedEdge[] edgeTo;   // edgeTo[v] = last edge on shortest s->v path
    private MinPQ<DirectedEdge> pq;  // PQ of fringe edges

    private class ByDistanceFromSource implements Comparator<DirectedEdge> {
        public int compare(DirectedEdge e, DirectedEdge f) {
            double dist1 = distTo[e.from()] + e.weight();
            double dist2 = distTo[f.from()] + f.weight();
            return Double.compare(dist1, dist2);
        }
    }

    // single-source shortest path problem from s
    public LazyDijkstraSP(EdgeWeightedDigraph G, int s) {
        for (DirectedEdge e : G.edges()) { 
            if (e.weight() < 0)
                throw new IllegalArgumentException("edge " + e + " has negative weight");
        }

        pq = new MinPQ<DirectedEdge>(new ByDistanceFromSource());
        marked = new boolean[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];

        // initialize
        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        distTo[s] = 0.0;
        relax(G, s);

        // run Dijkstra's algorithm
        while (!pq.isEmpty()) {
            DirectedEdge e = pq.delMin();
            int v = e.from(), w = e.to();
            if (!marked[w]) relax(G, w);   // lazy, so w might already have been relaxed
        }

        // check optimality conditions
        assert check(G, s);
    }

    // relax vertex v
    private void relax(EdgeWeightedDigraph G, int v) {
        marked[v] = true;
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                pq.insert(e);
            }
        }
    }
        

    // length of shortest path from s to v, infinity if unreachable
    public double distTo(int v) {
        return distTo[v];
    }

    // is there a path from s to v?
    public boolean hasPathTo(int v) {  
        return marked[v];
    }

    // return view of shortest path from s to v, null if no such path
    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
        }
        return path;
    }

    // check optimality conditions: either 
    // (i) for all edges e:            distTo[e.to()] <= distTo[e.from()] + e.weight()
    // (ii) for all edge e on the SPT: distTo[e.to()] == distTo[e.from()] + e.weight()
    private boolean check(EdgeWeightedDigraph G, int s) {

        // all edge are nonnegative
        for (DirectedEdge e : G.edges()) {
            if (e.weight() < 0) {
                System.err.println("negative edge weight detected");
                return false;
            }
        }

        // check that distTo[v] and edgeTo[v] are consistent
        if (distTo[s] != 0.0 || edgeTo[s] != null) {
            System.err.println("distTo[s] and edgeTo[s] inconsistent");
            return false;
        }
        for (int v = 0; v < G.V(); v++) {
            if (v == s) continue;
            if (edgeTo[v] == null && distTo[v] != Double.POSITIVE_INFINITY) {
                System.err.println("distTo[s] and edgeTo[s] inconsistent");
                return false;
            }
        }

        // check that all edges e = v->w satisfy dist[w] <= dist[v] + e.weight()
        for (int v = 0; v < G.V(); v++) {
            for (DirectedEdge e : G.adj(v)) {
                int w = e.to();
                if (distTo[v] + e.weight() < distTo[w]) {
                    System.err.println("edge " + e + " not relaxed");
                    return false;
                }
            }
        }

        // check that all edges e = v->w on SPT satisfy dist[w] == dist[v] + e.weight()
        for (int w = 0; w < G.V(); w++) {
            if (edgeTo[w] == null) continue;
            DirectedEdge e = edgeTo[w];
            int v = e.from();
            if (w != e.to()) return false;
            if (distTo[v] + e.weight() != distTo[w]) {
                System.err.println("edge " + e + " on shortest path not tight");
                return false;
            }
        }
        StdOut.println("Satisfies optimality conditions");
        StdOut.println();
        return true;
    }



    public static void main(String[] args) {
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In());

        // print graph
        StdOut.println("Graph");
        StdOut.println("--------------");
        StdOut.println(G);


        // run Dijksra's algorithm from vertex 0
        int s = 0;
        LazyDijkstraSP spt = new LazyDijkstraSP(G, s);
        StdOut.println();

        StdOut.println("Shortest paths from " + s);
        StdOut.println("------------------------");
        for (int v = 0; v < G.V(); v++) {
            if (spt.hasPathTo(v)) {
                StdOut.printf("%d to %d (%.2f)  ", s, v, spt.distTo(v));
                for (DirectedEdge e : spt.pathTo(v)) {
                    StdOut.print(e + "   ");
                }
                StdOut.println();
            }
            else {
                StdOut.printf("%d to %d         no path\n", s, v);
            }
        }
    }

}
