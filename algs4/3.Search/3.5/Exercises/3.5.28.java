import edu.princeton.cs.algs4.*;

class UniQueue<Key extends Comparable<Key>> {
    private Queue<Key> queue;
    private SET<Key> set;

    UniQueue() {
        this.set = new SET<Key>();
        this.queue = new Queue<Key>();
    }

    public void add(Key key) {
        if (set.contains(key)) return;
        set.add(key);
        queue.enqueue(key);
    }

    public Iterable<Key> keys() {
        return queue;
    }

    public static void main(String[] args) {
        UniQueue<String> q = new UniQueue<String>();
        q.add("A");
        q.add("A");
        q.add("B");
        q.add("C");
        q.add("C");
        q.add("D");
        for (String key: q.keys()) {
            System.out.print(key + " ");
        }
        System.out.println();
    }
}