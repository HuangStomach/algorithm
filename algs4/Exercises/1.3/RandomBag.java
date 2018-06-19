import java.util.Iterator;
import edu.princeton.cs.algs4.StdRandom;

// 1.3.34
public class RandomBag<Item> implements Iterable<Item> {
    private Item[] bag = (Item[]) new Object[1];
    private int N = 0;

    public int size() {
        return N;
    }

    public Boolean isEmpty() {
        return N == 0;
    } 

    // 数组变动大小, 并且复制有值的数组 头尾留下位置
    private void resize(int size) {  
        Item tmp[] = (Item[]) new Object[size];
        for (int i = 0; i < bag.length; i++) {
            tmp[i] = bag[i];
        }
        bag = tmp;
    }

    public void add(Item item) { 
        if (N == bag.length) resize(2 * size());
        bag[N++] = item;
    }
    
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Item[] randomBag = bag;
        private int index = 0;

        public ListIterator() {
            for (int i = 0; i < N; i++) {
                int r = StdRandom.uniform(N - 1);
                int temp = randomBag[i];
                randomBag[i] = randomBag[r];
                randomBag[r] = temp;
            }
        }
        public boolean hasNext() {
            return index < randomBag.length - 1;
        }
        public void remove() { }
        public Item next() {
            return randomBag[index++];
        }
    }
}