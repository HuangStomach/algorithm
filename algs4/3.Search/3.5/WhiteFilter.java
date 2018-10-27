import java.util.HashSet;
import edu.princeton.cs.algs4.*;

public class WhiteFilter {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet();
        In in = new In(args[0]);
        while (!in.isEmpty()) {
            set.add(in.readString());
        }

        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (set.contains(word)) {
                System.out.print(word + " ");
            }
        }
        System.out.println();
    }
    
}