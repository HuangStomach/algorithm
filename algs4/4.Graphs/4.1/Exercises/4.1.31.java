import edu.princeton.cs.algs4.*;

class ParallelCheck {
    public static void main(String[] args) {
        String filename = args[0];
        In in = new In(filename);
        Graph g = new Graph(in);

        for (int i = 0; i < g.V(); i++) {
            if (g.hasEdge(i, i)) {
                System.out.println("true");
                return;
            }
        }
        System.out.println("false");
    }
}