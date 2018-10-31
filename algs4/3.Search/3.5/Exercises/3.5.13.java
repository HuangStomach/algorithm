import edu.princeton.cs.algs4.*;

class RangeLookupCSV {
    public static void main(String[] args) {
        In in = new In(args[0]);
        int keyField = Integer.parseInt(args[1]);
        int valField = Integer.parseInt(args[2]);
        ST<String, String> st = new ST<String, String>();
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] tokens = line.split(",");
            String key = tokens[keyField];
            String val = tokens[valField];
            st.put(key, val);
        }

        while (!StdIn.isEmpty()) {
            String minKey = StdIn.readString();
            String maxKey = StdIn.readString();
            for (String key: st.keys()) {
                if (key.compareTo(minKey) > 0 && key.compareTo(maxKey) < 0) {
                    System.out.println(key + ": " + st.get(key));
                }
            }
        }
    }
}
