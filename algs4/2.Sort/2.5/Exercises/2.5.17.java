import java.util.ArrayList;
import java.util.Arrays;

class Selection {
    public static void sort(Comparable[] a) {
        int length = a.length;
        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i + 1; j < length;  j++) {
                if (a[j].compareTo(a[min]) < 0) min = j;
            }
            exch(a, i, min);
        }
    }

    protected static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static boolean check(ArrayList list, Comparable[] a) {
        Selection.sort(a);
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i].compareTo(a[i + 1]) == 0) {
                int x = list.indexOf(a[i]);
                int y = list.indexOf(a[i + 1]);
                if (x > y) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<Letter> list = new ArrayList<Letter>();
        String[] strs = {"E", "T", "S", "Y", "Q", "U", "E", "S", "A", "I", "O", "N"};
        Letter[] array = new Letter[strs.length];
        for (int i = 0; i < array.length; i++) {
            Letter letter = new Letter(strs[i]);
            array[i] = letter;
            list.add(letter);
        }
        
        String flag = Selection.check(list, array) ? "稳定" : "不稳定";
        System.out.println("该排序结果是" + flag + "的。");
    }
}

class Letter implements Comparable<Letter> {
    String name;

    Letter(String name) {
        this.name = name;
    }

    public int compareTo(Letter that) {
        return this.name.compareTo(that.name);
    }

    public String toString() {
        return this.name;
    }
    
}