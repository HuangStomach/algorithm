import edu.princeton.cs.algs4.*;

class DegreesOfSeparation {
    public static void main(String[] args) {
        SymbolGraph sg = new SymbolGraph(args[0], "/");
        Graph G = sg.G();

        int s = sg.index("Bacon, Kevin");
        System.out.println("Source: Bacon, Kevin");
        DepthFirstPaths dfs = new DepthFirstPaths(G, s);

        while (!StdIn.isEmpty()) {
            String sink = StdIn.readLine();
            System.out.println("Query: " + sink);
            if (sg.contains(sink)) {
                int t = sg.index(sink);
                if (dfs.hasPathTo(t)) {
                    for (int v: dfs.pathTo(t)) {
                        System.out.println(" " + sg.name(v));
                    }
                }
                else System.out.println("Not connected");
            }
            else System.out.println("Not in database.");
        }
    }
}