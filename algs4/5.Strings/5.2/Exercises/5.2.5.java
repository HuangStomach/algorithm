import edu.princeton.cs.algs4.*;

public class TST<Value> {
    private Node root;
    private class Node {
        char c;
        Node left, mid, right;
        Value val;
    }

    public Value get(String key) {
        Node x = root;
        int d = 0;
        while (true) {
            if (x == null) return null;
            char c = key.charAt(d);
            if (c < x.c) x = x.left;
            else if (c > x.c) x = x.right;
            else if (d < key.length() - 1) {
                x = x.mid;
                d++;
            }
            else {
                return (Value) x.val;
            }
        }
        return null;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        char c = key.charAt(d);
        if (c < x.c) return get(x.left, key, d);
        else if (c > x.c) return get(x.right, key, d);
        else if (d < key.length() - 1) return get(x.mid, key, d + 1);
        else return x;
    }

    public void put(String key, Value val) {
        Node x = root;
        int d = 0;
        while (true) {
            char c = key.charAt(d);
            if (c < x.c) {
                if (x.left == null) {
                    x.left = new Node();
                    x.left.c = c;
                }
                x = x.left;
            }
            else if (c > x.c) {
                if (x.right == null) {
                    x.right = new Node();
                    x.right.c = c;
                }
                x = x.right;
            }
            else if (d < key.length() - 1) {
                if (x.mid == null) {
                    x.mid = new Node();
                    x.mid.c = c;
                }
                x = x.mid;
                d++;
            }
            else {
                x.val = val;
                return;
            }
        }
        return;
    }
}