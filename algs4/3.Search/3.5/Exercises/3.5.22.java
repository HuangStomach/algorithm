import edu.princeton.cs.algs4.*;

public class FullLookupCSV {
    public static void main(String[] args) {
        In in = new In(args[0]);
        ST<Integer, Queue<String>> st = new ST<Integer, Queue<String>>();
        if (in.hasNextLine()) {
            String line = in.readLine();
            String[] tokens = line.split(",");
            for (int i = 0; i < tokens.length; i++) {
                Queue<String> q = new Queue();
                q.enqueue(tokens[i]);
                st.put(i, q);
            }
        }
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] tokens = line.split(",");
            for (int i = 0; i < tokens.length; i++) {
                q = st.get(i);
                q.enqueue(tokenss[i]);
            }
        }
    }
}
