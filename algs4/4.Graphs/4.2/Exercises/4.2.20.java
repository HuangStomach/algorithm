import edu.princeton.cs.algs4.*;

class Euler {
    public static void main(String[] args) {
        Digraph G = new Digraph(Integer.parseInt(args[0]));
        KosarajuSCC scc = new KosarajuSCC(G);
        if (scc.count() != 1) return;
        
        Degrees degrees = new Degrees(G);
        for (int i = 0; i < G.V(); i++) {
            if (degrees.indegree(i) != degrees.outdegree(i)) return;
        }
        return;
    }
}