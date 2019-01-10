import edu.princeton.cs.algs4.*;

class LineSP {
    private double[] distTo;
    private boolean[] marked;

    LineSP(EdgeWeightedGraph G) {
        distTo = new double[G.V()];
        
        // v + 4e 符合线性
        int s = -1;
        for (int v = 0; v < G.V(); v++) {
            int count = 0 ;
            for (Edge e: G.adj(v)) count++;
            if (count == 1) {
                s = v;
                break;
            }
        }

        dfs(G, s, 0.0);
    }

    private void dfs(EdgeWeightedGraph G, int v, double weight) {
        marked[v] = true;
        distTo[v] = weight;
        for (Edge e: G.adj(v)) {
            if (!marked[e.other(v)]) {
                dfs(G, w, weight + e.weight());
            }
        }
    }

    public double dist(int v, int w) {
        return Math.abs(dist[w] - dist[v]);
    }
}