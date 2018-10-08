import java.util.Iterator;

// 1.3.14

public class ResizingArrayQueueOfStrings<String> implements Iterable<String> {
    private String[] a = new String[1];
    private int N = 0;
    
    private void resize(int size) {
        String[] temp = new String[size];
        for (int i = 0; i < a.length; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(String str) {
        if (N == a.length) resize(size * 2);
        a[N++] = str;
    }

    public String dequeue() {
        String first = a[0];
        for (int i = 1;i < N; i++){
            a[i - 1] = a[i];
        }
        a[N--] = null; //避免对象游离，回收机制不能及时回收
        return first;
    }
}