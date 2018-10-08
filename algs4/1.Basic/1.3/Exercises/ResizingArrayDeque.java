// 1.3.33
public class ResizingArrayDeque<Item> implements Iterable<Item> {
    private int left = 1;
    private int right = 1;
    private Item[] deque = (Item[]) new Object[3];

    public int size() {
        return right - left;
    }

    public Boolean isEmpty() {
        return right == left;
    } 

    // 数组变动大小, 并且复制有值的数组 头尾留下位置
    private void resize(int size) {  
        if (size < 3) size = 3;

        Item tmp[] = (Item[]) new Object[size];
        int j = size / 3;
        for (int i = head; i < tail; i++) {
            tmp[j++] = deque[i];
        }
        deque = tmp;
        head = size / 3;
        tail = j;
    }

    public void pushLeft(Item item) { 
        if (head == 0) resize(3 * size());
        deque[--head] = item;
    }
    
    public void pushRight(Item item) {  
        if (tail == deque.length) resize(3 * size());
        deque[tail++] = item;
    }  
      
    public Item popLeft() {  
        if (isEmpty()) return null;
        if (size() * 6 < deque.length) resize(size() * 3);
        return deque[head++];
    }  
      
    public Item popRight() {  
        if (isEmpty()) return null;
        if (size() * 6 < deque.length) resize(size() * 3);
        return deque[--tail];
    }  
}