import java.util.Random;

import edu.princeton.cs.algs4.*;

class RandomEdgeWeightedDigraph {
    private int V;
    private int E;
    private Random rn;

    public RandomEdgeWeightedDigraph(EdgeWeightedDigraph G, int V, int E) {
        this.V = V;
        this.E = E;
        this.rn = new Random();
    }
    
    public EdgeWeightedDigraph average() {
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(V);
        for (int i = 0; i < E; i++) {
            int v = rn.nextInt(V);
            int w = rn.nextInt(V);
            double weight = rn.nextDouble();
            G.addEdge(DirectedEdge(v, w, weight));
        }
        return G;
    }

    public EdgeWeightedDigraph gaussian() {
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(V);
        for (int i = 0; i < E; i++) {
            int v = rn.nextInt(V);
            int w = rn.nextInt(V);
            double weight = rn.nextGaussian() + 2.0;
            G.addEdge(DirectedEdge(v, w, weight));
        }
        return G;

    }
}