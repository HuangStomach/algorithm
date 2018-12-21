import edu.princeton.cs.algs4.*;

class WeightRange {
    public static double max = Double.MIN_VALUE;
    public static void main(String[] args) {
        In in = new In(args[0]);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        LazyPrimMST mst = new LazyPrimMST(G);

        int v = Integer.parseInt(args[1]);
        int w = Integer.parseInt(args[2]);
        if (v >= G.V() || w >= G.V()) return;

        // 目前分析 无论加入哪条边都会产生一个唯一环
        EdgeWeightedGraph minG = new EdgeWeightedGraph(G.V());
        for (Edge e: mst.edges()) {
            minG.addEdge(e);
        }
        minG.addEdge(new Edge(v, w, 0));
        // 利用最小树生成一个新图 找出该环
        bfs(minG, v, w, w);
        System.out.println(max);
    }

    public static boolean bfs(EdgeWeightedGraph G, int start, int end, int skip) {
        for (Edge e: G.adj(start)) {
            int v = e.other(start);
            if (v == skip) continue;

            if (v == end || bfs(G, v, end, start)) {
                max = Math.max(max, e.weight());
                return true;
            }
        }
        return false;
    }
}
