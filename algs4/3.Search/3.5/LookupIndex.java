import edu.princeton.cs.algs4.*;

public class LookupIndex {
    public static void main(String[] args) {
        In in = new In(args[0]);
        String sp = args[1];
        ST<String, Queue<String>> st = new ST();
        ST<String, Queue<String>> ts = new ST();
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(sp);
            String key = a[0];
            for (int i = 1; i < a.length; i++) {
                String val = a[i];
                if (!st.contains(key)) st.put(key, new Queue<String>());
                if (!ts.contains(val)) ts.put(val, new Queue<String>());
                st.get(key).enqueue(val);
                ts.get(val).enqueue(key);
            }
        }

        while (!StdIn.isEmpty()) {
            String query = StdIn.readLine();
            if (st.contains(query)) {
                for (String s: st.get(query)) System.out.println(" " + s);
            }

            if (ts.contains(query)) {
                for (String s: ts.get(query)) System.out.println(" " + s);
            }
        }
    }
}