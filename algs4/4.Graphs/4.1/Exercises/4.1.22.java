import edu.princeton.cs.algs4.*;

class BaconHistogram {
    public static void main(String[] args) {
        SymbolGraph sg = new SymbolGraph(args[0], "/");
        Graph G = sg.G();

        int s = sg.index("Bacon, Kevin");
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);
        
        ST<String, Integer> st = new ST<String, Integer>();
        In in = new In(args[0]);
        while (in.hasNextLine()) {
            String[] staff = in.readLine().split("/");
            for (int i = 1; i < staff.length; i++) {
                int index = sg.index(staff[i]);
                int bk = Integer.MAX_VALUE;
                if (bfs.hasPathTo(index)) {
                    int j = 0;
                    for (int v: bfs.pathTo(index)) j++;
                    bk = j / 2;
                }
                
                if (!st.contains(staff[i])) st.put(staff[i], bk);
                else st.put(staff[i], Math.min(bk, st.get(staff[i])));
            }
        }

        RedBlackBST<Integer, Integer> bst = new RedBlackBST();
        for (String staff: st.keys()) {
            int bk = st.get(staff);
            if (!bst.contains(bk)) bst.put(bk, 1);
            else bst.put(bk, bst.get(bk) + 1);
        }

        int i = 0;
        StdDraw.setXscale(0, bst.size() + 1);
        StdDraw.setYscale(0, 100000);
        for (int key: bst.keys()) {
            double[] x = { 1.0 * i, 1.0 * i + 0.75, 1.0 * i + 0.75, 1.0 * i};
            double[] y = { 1.0 * bst.get(key), 1.0 * bst.get(key), 0.0, 0.0};
            StdDraw.filledPolygon(x, y);
            i++;
        }
    }
}