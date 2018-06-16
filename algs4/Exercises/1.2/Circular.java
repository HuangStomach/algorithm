import edu.princeton.cs.algs4.*;

public class Circular {
    public static void main(String[] args) {
        String s = args[0];  
        String t = args[1];  
        System.out.println(s.length() == t.length() && s.concat(s).indexOf(t) != -1);
    }
}