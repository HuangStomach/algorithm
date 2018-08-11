import java.util.ArrayList;
import java.util.Arrays;

class Selection {
    public static void sort(Comparable[] a) {
        ArrayList<Item> list = new ArrayList<Item>();
        int length = a.length;
        Item[] b = new Item[length];
        for (int i = 0; i < length; i++) {
            b[i] = new Item(a[i]);
            list.add(b[i]);
        }

        // 此处可以是任意sort 选择排序为例子
        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i + 1; j < length;  j++) {
                if (b[j].compareTo(b[min]) < 0) min = j;
            }
            exch(b, i, min);
        }

        correct(list, b);

        for (int i = 0; i < length; i++) {
            a[i] = b[i].value();
        }
    }

    protected static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void correct(ArrayList list, Comparable[] b) {
        for (int i = 1; i < b.length; i++) {
            if (b[i].compareTo(b[i - 1]) != 0) continue;
            int j = i;
            // 范围插入排序
            while (b[j].compareTo(b[j - 1]) != 0) {
                int x = list.indexOf(b[j]);
                int y = list.indexOf(b[j - 1]);
                if (x > y) exch(b, j, j - 1);
                else break;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        String[] array = {"E", "T", "S", "Y", "Q", "U", "E", "S", "A", "I", "O", "N"};
        Selection.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }
}

class Item implements Comparable<Item> {
    Comparable value;

    Item(Comparable value) {
        this.value = value;
    }

    public int compareTo(Item that) {
        return this.value.compareTo(that.value);
    }

    public Comparable value() {
        return this.value;
    }
    
}