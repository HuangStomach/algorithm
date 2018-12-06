import edu.princeton.cs.algs4.*;

class Degrees {
    Digraph G;
    int[] indefree;
    int[] outdegree;
    public Degrees(Digraph G) {
        this.G = G;
        indefree = new int[G.V()];
        outdegree = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            int count = 0;
            for (int j: G.adj(i)) {
                count++;
                indefree[j]++;
            }
            outdegree[i] = count;
        }
    }

    public int indegree(int v) {
        return indegree[v];
    }

    public int outdegree(int v) {
        return outdegree[v];
    }

    public Iterable<Integer> sources() {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < G.V(); i++) {
            if (indefree[i] == 0) stack.push(i);
        }
        return stack;
    }

    public Iterable<Integer> sinks() {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < G.V(); i++) {
            if (outdegree[i] == 0) stack.push(i);
        }
        return stack;
    }

    public boolean isMap() {
        for (int i = 0; i < G.V(); i++) {
            if (outdegree[i] != 1) return false;
        }
        return true;
    }
}