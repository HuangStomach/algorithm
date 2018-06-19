import edu.princeton.cs.algs4.Queue;

// 1.3.37
public class Josephus {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int M = Integer.parseInt(args[1]);

        Queue<Integer> q = new Queue<Integer>();
        for (int i = 0; i < N; i++) {
           q.enqueue(i);
        }

        while (q.size() > 1) {
            int i = 1;
            while(true) {
                int person = q.dequeue();
                if (i == M) {
                    System.out.println(person);
                    break;
                }
                q.enqueue(person);
                i++;
            }
        }
        System.out.println("Josephus活了下来，他在:" + q.dequeue());
    }
}