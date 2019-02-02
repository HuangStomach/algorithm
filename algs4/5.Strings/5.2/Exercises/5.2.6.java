import edu.princeton.cs.algs4.*;

class StringSET {
    private static int R = 256;
    private Node root;

    private static class Node {
        private boolean exist;
        private Node[] next = new Node[R];
    }

    public void add(String key) {
        if (contains(key)) return;
        root = add(root, key, 0);
    }

    private Node add(Node x, String key, int d) {
        if (x == null) x = new Node();
        if (d == key.length()) {
            x.exist = true;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = add(x.next[c], key, d + 1);
        return x;
    }

    public void delete(String key) {
        root = delete(root, key, 0);
    }

    private Node delete(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) x.exist = false;
        else {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d + 1);
        }

        if (!x.exist) return x;
        for (char c = 0; c < R; c++) {
            if (x.next[c] != null) return x;
        }
        return null;
    }

    public boolean contains(String key) {
        Node x = contains(root, key, 0);
        return x != null && x.exist;
    }

    private Node contains(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d);
        return contains(x.next[c], key, d + 1);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        int cnt = 0;
        if (x.exist) cnt++;
        for (char c = 0; c < R; c++) {
            cnt += size(x.next[c]);
        }
        return cnt;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        collect(root, "", sb);
        return sb.toString();
    }

    private void collect(Node x, String key, StringBuilder sb) {
        if (x.exist) {
            sb.append(key + "\n");
        }
        for (int i = 0; i < R; i++) {
            if (x.next[i] != null) {
                String next = new String(key);
                next += Character.toString(Alphabet.EXTENDED_ASCII.toChar(i));
                collect(x.next[i], next, sb);
            }
        }
    }

    public static void main(String[] args) {
        StringSET set = new StringSET();
        set.add("xNova");
        set.add("maybe");
        set.add("ameame");
        set.add("chalice");
        set.add("fy");
        System.out.println(set.size());
        set.delete("maybe");
        System.out.println(set.size());
        set.add("xm");
        System.out.println(set.toString());
    }
}