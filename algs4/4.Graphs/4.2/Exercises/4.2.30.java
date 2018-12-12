import edu.princeton.cs.algs4.*;

class QueueReservePost {
    private Digraph G;
    private int[] indefree;
    Queue<Integer> queue;

    QueueReservePost(Digraph G) {
        this.G = G;
        this.queue = new Queue<Integer>();
        Degrees degrees = new Degrees(G);
        this.indefree = degrees.indefree;
        for (int s: degrees.sources()) {
            queue.enqueue(s);
        }
    }

    reservePost() {
        boolean[] deleted = new boolean[this.G.V()];
        while (queue.size() > 0) {
            int v = queue.dequeue();
            if (deleted[v] == true) continue;
            deleted[v] = true;
            
            for (int s: G.adj(v)) {
                indefree[s]--;
                if (indefree[s] == 0) queue.enqueue(s);
            }
        }    
    }
}