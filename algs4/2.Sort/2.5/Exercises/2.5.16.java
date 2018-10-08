import edu.princeton.cs.algs4.*;
import java.util.Arrays;

class California {
    private String name;
    public California next;
    private String weight = "LFYDPUKEICTNXZGSBHAVMJOQWR";

    California(String name) {
        this.name = name;
    }

    public String name() {
        return this.name;
    }

    public void name(String name) {
        this.name = name;
    }

    public int compareTo(California that) {
        String[] a = this.name.split(" ");
        String[] b = that.name.split(" ");

        int length = Math.min(a.length, b.length);
        for (int i = 0; i < length; i++) {
            String m = a[i];
            String n = b[i];
            int strLength = Math.min(m.length(), n.length());
            for (int j = 0; j < strLength; j++) {
                String x = Character.toString(m.charAt(j)).toUpperCase();
                String y = Character.toString(n.charAt(j)).toUpperCase();
                int diff = weight.indexOf(x) - weight.indexOf(y);
                if (diff != 0) return diff;
            }

            int lengthDiff = m.length() - n.length();
            if (lengthDiff != 0) return lengthDiff;
        }

        return a.length - b.length;
    }
    
    public static void main(String[] args) {
        MinPQ pq = new MinPQ();
        while(!StdIn.isEmpty()) {
            String str = StdIn.readLine();
            California c = new California(str);
            pq.insert(c);
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.delMin());
        }
    }
}

class MinPQ {
    private California head;
    private int N = 0;

    public MinPQ() {
        head = null;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(California v) {
        if (head == null) {
            head = v;
        }
        else {
            California top = head;
            while (top != null) {
                if (top.compareTo(v) > 0) {
                    California c = new California(top.name());
                    c.next = top.next;

                    top.name(v.name());
                    top.next = c;
                    break;
                }

                if (top.next == null) {
                    top.next = v;
                    break;
                }
                
                top = top.next;
            }
        }
        N++;
    }

    public String delMin() {
        String name = head.name();
        head = head.next;
        N--;
        return name;
    }
}
