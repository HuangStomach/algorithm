import edu.princeton.cs.algs4.*;

public class TrieST<Value> {
    private static int R = 256;
    private Node root;

    private static class Node {
        private Object val;
        private Node[] next = new Node[R];
    }

    public Value get(String key) {
        Node x = get(root, key, 0);
        if (x == null) return null;
        return (Value) x.val;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d);
        return get(x.next[c], key, d + 1);
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    public Node put(Node x, String key, Value val, int d) {
        if (x == null) x = new Node();
        if (d == key.length()) {
            x.val = val;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d + 1);
        return x;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        int cnt = 0;
        if (x.val != null) cnt++;
        for (char c = 0; c < R; c++) {
            cnt += size(next[c]);
        }
        return cnt;
    }

    public String floor(String key) {
        String floor = "";
        Node node = floor(root, floor, key, 0);
        if (node == null) return null;
        return floor;
    }

    public Node floor(Node node, String floor, String key, int d) {
        if (node == null) return null;
        if (floor == key && x.val != null) return x;
        char c = key.charAt(d);

        for (int i = c; i >= c; i--) {
            if (node.next[i] != null) {
                floor += i;
                return floor(node.next[i], floor, key, d + 1);
            }
        }
        return null;
    }

    public String ceiling(String key) {
        String ceiling = "";
        Node node = ceiling(root, ceiling, key, 0);
        if (node == null) return null;
        return ceiling;
    }

    public Node ceiling(Node node, String ceiling, String key, int d) {
        if (node == null) return null;
        if (ceiling == key && x.val != null) return x;
        char c = key.charAt(d);

        for (int i = c; i < R; i++) {
            if (node.next[i] != null) {
                ceiling += i;
                return ceiling(node.next[i], ceiling, key, d + 1);
            }
        }
        return null;
    }

    public int rank(String key) {
        return rank(key, root, 0);
    }

    private int rank(String key, Node node, int d) {
        if (node == null) return 0;
        char c = key.charAt(d);
        int rank = rank(key, node.next[c], d + 1);

        for (int i = c - 1; i >= c; i--) {
            if (node.next[i] != null) rank += size(node);
        }
        return rank;
    }

    public Stirng select(int k) {
        int i = 0;
        for (String key: keys()) {
            if (k == i) return key;
            i++;
        }
        return null;
    }

    public Iterable<String> keys() {
        return keysWithPrefix("");
    }

    public Iterable<Stirng> keysWithPrefix(String pre) {
        Queue<String> q = new Queue<String>();
        collect(get(root, pre, 0), pre, q);
        return q;
    }

    public Iterable<String> keysThatMatch(String pat) {
        Queue<String> q = new Queue<Stirng>();
        collect(root, "", pat, q);
        return q;
    }

    public String longestPrefixOf(String s) {
        int length = search(root, s, 0, 0);
        return s.substring(0, length);
    }

    private void collect(Node x, String pre, Queue<String> q) {
        if (x == null) return;
        if (x.val != null) q.enqueue(pre);
        for (char c = 0; c < R; c++) {
            collect(x.next[c], pre + c, q);
        }
    }

    private void collect(Node x, String pre, String pat, Queue<String> q) {
        int d = pre.length();
        if (x == null) return;
        if (d == pat.length() && x.val != null) q.enqueue(pre);
        if (d == pat.length()) return;

        char next = pat.charAt(d);
        for (char c = 0; c < R; c++) {
            if (next == '.' || next == c) collect(x.next[c], pre + c, pat, q);
        }
    }

    private int search(Node x, String s, int d, int length) {
        if (x == null) return length;
        if (x.val != null) length = d;
        if (d == s.length()) return length;
        char c = s.charAt(d);
        return search(x.next[c], s, d + 1, length);
    }

    public void delete(String key) {
        root = delete(root, key, 0);
    }

    private Node delete(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) x.val = null;
        else {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d + 1);
        }

        if (x.val != null) return x;
        for (char c = 0; c < R; c++) {
            if (x.next[c] != null) return x;
        }
        return null;
    }
}