import edu.princeton.cs.algs4.*;

class ShortestAncestralPath {
    Digraph G;
    Digraph reserveG;
    int s;

    public ShortestAncestralPath(Digraph G, int s) {
        this.G = G;
        this.reserveG = G.reserve();
        this.s = s;
    }

    public Iterable<Integer> path(int v, int w) {
        BreadthFirstDirectedPaths bfs = new BreadthFirstDirectedPaths(this.reserveG, this.s);
        int distV = bfs.distTo(v);
        int distW = bfs.distTo(w);
        
        return distV < distW ? bfs.pathTo(v) : bfs.pathTo(w);
    }

}
