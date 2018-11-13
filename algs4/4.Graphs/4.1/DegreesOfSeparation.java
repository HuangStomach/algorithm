import edu.princeton.cs.algs4.*;

public class DegreesOfSeparation {
    public static void main(String[] args) {
        SymbolGraph sg = new SymbolGraph(args[0], args[1]);
        Graph G = sg.G();

        String source = args[2];
        if (!sg.contains(source)) {
            System.out.println(source + "not in database.");
            return;
        }

        int s = sg.index(source);
        BreathFirstPaths bfs = new BreathFirstPaths(G, s);

        while (!StdIn.isEmpty()) {
            String sink = StdIn.readLine();
            if (sg.contains(sink)) {
                int t = sg.index(sink);
                if (bfs.hasPathTo(t)) {
                    for (int v: bfs.pathTo(t)) {
                        System.out.println(" " + sg.name(v));
                    }
                }
                else System.out.println("Not connected");
            }
            else System.out.println("Not in database.");
        }
    }
}