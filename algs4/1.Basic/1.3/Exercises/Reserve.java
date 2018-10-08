import edu.princeton.cs.algs4.*;

// 1.3.30
public class Reserve {

    public Node reserve(Node n) {
        Node first = n;
        Node reserve = null;
        while (first != null) {
            Node second = first.next;
            first.next = reserve;
            reserve = first;
            first = second;
        }
        return reserve;
    }

    public static void main(String[] args) {
        
    }
}