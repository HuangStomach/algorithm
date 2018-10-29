import java.io.File;
import java.util.Set;
import edu.princeton.cs.algs4.*;

public class FileIndex {
    public static void main(String[] args) {
        ST<String, Set<File>> st = new ST();
        for (String filename: args) {
            File file = new File(filename);
            In in = new In(file);
            while (!in.isEmpty()) {
                String word = in.readString();
                if (!st.contains(word)) st.put(word, new Set<File>());
                Set<File> set = st.get(word);
                set.add(file);
            }
        }

        while (!StdIn.isEmpty()) {
            String query = StdIn.readString();
            if (st.contains(query)) {
                for (File file: st.get(query)) {
                    System.out.println(" " + file.getName());
                }
            }
        }
    }
}