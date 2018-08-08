import edu.princeton.cs.algs4.*;

class SPT {
    public static void main(String[] args) {
        MinPQ pq = new MinPQ();
        while(!StdIn.isEmpty()) {
            String str = StdIn.readString();
            String[] array = str.split(":");
            Task task = new Task(array[0], Integer.parseInt(array[1]));
            pq.insert(task);
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.delMin());
        }
    }
}

class MinPQ {
    private Task head;
    private int N = 0;

    public MinPQ() {
        head = null;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Task v) {
        if (head == null) {
            head = v;
        }
        else {
            Task top = head;
            while (top != null) {
                if (top.compareTo(v) > 0) {
                    Task task = new Task(top.name, top.cost);
                    task.next = top.next;

                    top.name = v.name;
                    top.cost = v.cost;
                    top.next = task;
                    break;
                }

                if (top.next == null) {
                    top.next = v;
                    break;
                }
                
                top = top.next;
            }
        }
        N++;
    }

    public String delMin() {
        String info = head.info();
        head = head.next;
        N--;
        return info;
    }
}

class Task implements Comparable<Task> {
    public String name;
    public int cost;
    public Task next;

    Task() {

    }

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