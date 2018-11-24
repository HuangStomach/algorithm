import edu.princeton.cs.algs4.*;

class GraphProperties {
    int[] eccentricitys;
    int diameter = Integer.MIN_VALUE;
    int radius = Integer.MAX_VALUE;
    int center;
    Graph G;
    GraphProperties(Graph G) {
        CC cc = new CC(G);
        if (cc.count() > 1) throw new Exception("Error");
        eccentricitys = new int[G.V()];
        this.G = G;
        for (int i = 0; i < G.V(); i++) {
            BreadthFirstPaths bfs = new BreadthFirstPaths(this.G, i);
            for (int j = 0; i < G.V(); i++) {
                eccentricitys[i] = Math.max(eccentricitys[i], bfs.pathTo(j).size());
            }
            diameter = Math.max(diameter, eccentricitys[i]);
            radius = Math.min(radius, eccentricitys[i]);
            if (radius == eccentricitys[i]) center = i;
        }
    }

    public int eccentricity(int v) {
        return eccentricitys[v];
    }

    public int diameter() {
        return diameter;
    }

    public int radius() {
        return radius;
    }

    public int center() {
        return center;
    }
}
