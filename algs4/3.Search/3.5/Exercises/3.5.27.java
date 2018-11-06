import java.util.Iterator;
import edu.princeton.cs.algs4.*;

class List<Item extends Comparable<Item>> implements Iterable<Item> {
    ST<Item, Integer> st;
    RedBlackBST<Integer, Item> index;
    
    List() {
        st = new ST<Item, Integer>();
        index = new RedBlackBST<Integer, Item>();
    }

    public void add(int i, Item item) {
        if (index.get(i) != null) {
            st.delete(index.get(i));
            index.delete(i);
        }
        st.put(item, i);
        index.put(i, item);
    }

    public void addFront(Item item) {
        if (st.size() == 0) {
            add(0, item);
            return;
        }
        int min = index.min();
        add(min - 1, item);
    }

    public void addBack(Item item) {
        if (st.size() == 0) {
            add(0, item);
            return;
        }
        int max = index.max();
        add(max + 1, item);
    }

    public void delete(Item item) {
        int i = st.get(item);
        st.delete(item);
        index.delete(i);
    }

    public Item delete(int i) {
        Item item = index.get(i);
        if (item != null) {
            st.delete(item);
            index.delete(i);
        }
        return item;
    }

    public Item deleteFront() {
        return delete(index.min());
    }

    public Item deleteBack() {
        return delete(index.max());
    }

    public boolean contains(Item item) {
        return item.equals(index.get(st.get(item)));
    }

    public boolean isEmpty() {
        return st.size() == 0;
    }

    public int size() {
        return st.size();
    }
    
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private RedBlackBST<Integer, Item> _index;
        private ST<Item, Integer> _st;
        private int index = 0;

        public ListIterator() {
            this._index = List.this.index;
            this._st = st;
        }
        public boolean hasNext() {
            return index < _index.size();
        }
        public void remove() { }
        public Item next() {
            return _index.get(_index.select(index++));
        }
    }

    public static void main(String[] args) {
        List<String> list = new List<String>();
        list.add(0, "B");
        list.add(1, "C");
        list.add(2, "D");
        list.addFront("A");
        list.addBack("E");
        list.deleteFront();
        for (String key: list) {
            System.out.print(key + " ");
        }
        System.out.println();
    }
}