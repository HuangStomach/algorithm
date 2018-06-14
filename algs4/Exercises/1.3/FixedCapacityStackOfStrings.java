import java.util.Arrays;

// 1.3.1
public class FixedCapacityStackOfStrings {
    private String[] a;
    private int N;
    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public boolean isFull() {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            System.out.println(low);
            if (a[middle] instanceof String) low = middle + 1;
            else {
                return false;
            }
        }
        return true;
    }
    public int size() {
        return N;
    }
    public void push(String item) {
        a[N++] = item;
    }
    public String pop() {
        return a[--N];
    }

    public static void main(String[] args) {
        System.out.println("begin");
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(2);
        stack.push("a");
        System.out.println(stack.isFull());
        stack.push("b");
        System.out.println(stack.isFull());
    }
}