import edu.princeton.cs.algs4.*;

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