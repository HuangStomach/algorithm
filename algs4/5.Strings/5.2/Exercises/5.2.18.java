import java.util.HashSet;
import edu.princeton.cs.algs4.*;

public class WhiteFilter {
    public static void main(String[] args) {
        TST<Integer> st = new TST<Integer>();
        In in = new In(args[0]);
        while (!in.isEmpty()) {
            st.add(in.readString(), 1);
        }

        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (st.contains(word)) {
                System.out.print(word + " ");
            }
        }
        System.out.println();
    }
    
}