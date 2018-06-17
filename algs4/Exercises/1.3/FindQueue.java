import edu.princeton.cs.algs4.*;

// 1.3.21
public class FindQueue {
    public static void main(String[] args) {
        int find = Integer.parseInt(args[0]);
        Queue<Integer> q = new Queue<Integer>();
        for (int i = 0; i < 100; i++) {
            q.enqueue(i);
        }

        boolean goal = false;
        for(int node: q) {
            if (node == find) {
                goal = true;
                break;
            }
        }

        System.out.println(goal);
    }
}
