import java.math.BigDecimal;

import edu.princeton.cs.algs4.*;

class Arbitrage {
    public static void main(String[] args) {
        int V = StdIn.readInt();
        String[] name = new String[V];
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(V);
        for (int v = 0; v < V; v++) {
            name[v] = StdIn.readString();
            for (int w = 0; w < V; w++) {
                double rate = StdIn.readDouble();
                DirectedEdge e = new DirectedEdge(v, w, -Math.log(rate));
                G.addEdge(e);
            }
        }

        for (int v = 0; v < V; v++) {
            BellmanFordSP spt = new BellmanFordSP(G, v);
            if (spt.hasNegativeCycle()) {
                String stake = "0.0";
                System.out.print(name[v] + " ");
                for (DirectedEdge e: spt.negativeCycle()) {
                    System.out.printf("→ [%s %s] ", name[e.from()], name[e.to()]);
                    BigDecimal b1 = new BigDecimal(stake);
                    BigDecimal b2 = new BigDecimal(String.format("%.4f", e.weight()));
                    stake = b1.add(b2).toString();
                }
                System.out.println(stake);
            }
            else System.out.println("别想了赚不了的");
        }
    }
}