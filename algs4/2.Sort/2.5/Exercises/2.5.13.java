import edu.princeton.cs.algs4.*;

class LPT {
    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        MaxPQ pq = new MaxPQ(M);
        while(!StdIn.isEmpty()) {
            String str = StdIn.readString();
            String[] array = str.split(":");
            Task task = new Task(array[0], Integer.parseInt(array[1]));
            pq.insert(task);
        }
        
        for (int i = 0; i < M; i++) {
            System.out.println(pq.index[i]);
        }
    }
}

class MaxPQ {
    private int N = 0;
    public int index[];
    private Task pq[];

    public MaxPQ(int count) {
        index = new int[4];
        pq = new Task[4];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Task v) {
        int cpu = 0;
        for (int i = 1; i < index.length; i++) {
            if (index[i] < index[cpu]) cpu = i;
        }

        Task task = pq[cpu];
        if (task == null) pq[cpu] = v;
        else {
            while (task.next != null) task = task.next;
            task.next = v;
        }
        index[cpu] += v.cost;
        N++;
    }
}

class Task implements Comparable<Task> {
    public String name;
    public int cost;
    public Task next;

    Task() {}

    Task(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public int compareTo(Task that) {
        return this.cost  - that.cost;
    }

    public String info() {
        return this.name + ": " + this.cost;
    }
}