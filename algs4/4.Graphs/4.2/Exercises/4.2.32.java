import java.util.Random;

import edu.princeton.cs.algs4.*;

class RandomSimpleDigraph {
    public static void main(String[] args) {
        int v = Integer.parseInt(args[0]);
        int e = Integer.parseInt(args[1]);

        Digraph g = new Digraph(v);
        RandomBag<Integer> rbA = new RandomBag<Integer>();
        RandomBag<Integer> rbB = new RandomBag<Integer>();
        for (int i = 0; i < v; i++) {
            rbA.add(i);
            rbB.add(i);
        }

        for (int i = 1; i <= e; i++) {
            int a = rbA.iterator().next();
            int b = rbB.iterator().next();
            if (g.hasEdge(a, b) || a == b) {
                rbA.add(a);
                rbB.add(b);
                i--;
            }
            g.addEdge(a, b);
        }
    }
}