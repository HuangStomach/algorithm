import edu.princeton.cs.algs4.*;

class LookupCSV {
    public static void main(String[] args) {
        In in = new In(args[0]);
        int keyField = Integer.parseInt(args[1]);
        int valField = Integer.parseInt(args[2]);
        ST<String, Queue<String>> st = new ST<String, Queue<String>>();
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] tokens = line.split(",");
            String key = tokens[keyField];
            String val = tokens[valField];
            Queue<String> q = st.get(key);
            if (q == null) q = new Queue<String>();
            q.enqueue(val);
            st.put(key, q);
        }

        while (!StdIn.isEmpty()) {
            String query = StdIn.readString();
            if (st.contains(query)) {
                Queue<String> q = st.get(query);
                while (q.size() > 0) {
                    System.out.print(q.dequeue() + " ");
                }
                System.out.println();
            }
        }
    }
}