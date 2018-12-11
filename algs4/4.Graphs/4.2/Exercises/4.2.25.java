import edu.princeton.cs.algs4.*;

// 习题中注明…… 含有汉密尔顿路径时 拓扑排序就是唯一的
class HamiltonianPath {
    private Digraph G;
    HamiltonianPath(Digraph G) {
        this.G = G;
    }

    public boolean isHamiltonian() {
        DepthFirstOrder dfs = new DepthFirstOrder(G);
        int prev = -1;
        for (int s: dfs.reservePost()) {
            if (prev < 0) {
                prev = s;
                continue;
            }

            if (!G.hasEdge(prev, s)) return false;
            prev = s;
        }
        return true;
    }
}
