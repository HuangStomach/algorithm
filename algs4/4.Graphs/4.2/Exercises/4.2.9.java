import edu.princeton.cs.algs4.*;

class CheckPermutation {
    public boolean main(int[] points, Digraph G) {
        Topological top = new Topological(G);
        int i = 0;
        for (int v: top.order()) {
            if (points[i] != v) return false;
            i++;
        }
        return true;
    }
}
