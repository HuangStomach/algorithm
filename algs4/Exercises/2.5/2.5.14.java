import edu.princeton.cs.algs4.*;
import java.util.Arrays;

class Domain implements Comparable<Domain> {
    private String name;

    Domain(String name) {
        this.name = name;
    }

    public int compareTo(Domain that) {
        String[] a = this.reserv();
        String[] b = that.reserv();

        int length = Math.max(a.length, b.length);
        for (int i = 0; i < length; i++) {
            if (i == a.length) return 1;
            else if (i == b.length) return -1;

            String m = a[i];
            String n = b[i];
            int result = m.compareTo(n);
            if (result != 0) return result;
        }

        return 0;
    }

    public String[] reserv() {
        String[] name = this.name.split("\\.");
        int length = name.length / 2;
        for (int i = 0; i < name.length / 2; i++) {
            String str = name[i];
            name[i] = name[length - i];
            name[length - i] = str;
        }
        return name;
    }

    public String name() {
        return this.name;
    }

    public static void main(String[] args) {
        Domain[] list = new Domain[9];
        int index = 0;
        while(!StdIn.isEmpty()) {
            String str = StdIn.readString();
            Domain domain = new Domain(str);
            list[index++] = domain;
        }
        Arrays.sort(list);

        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i].name());
        }
    }
}