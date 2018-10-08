// 1.3.41

public class CopyQueue<Item> implements Iterable<Item> {
    public CopyQueue(CopyQueue<Item> q) {
        while (size() < q.size()) {
            Item item = q.dequeue();
            enqueue(item);
            q.enqueue(item);
        }
    }
}