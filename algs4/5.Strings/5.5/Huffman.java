import edu.princeton.cs.algs4.*;

class Huffman {
    private static int R = 256;

    private static class Node implements Comparable<Node> {
        private char ch;
        private int freq;
        private final Node left, right;

        Node(char ch, int freq, Node left, Node right) {
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        public int compareTo(Node that) {
            return this.freq - that.freq;
        }
    }

    private static Node readTrie() {
        if (BinaryStdIn.readBoolean()) return new Node(BinaryStdIn.readChar(), 0, null, null);
        return new Node('\0', 0, readTrie(), readTrie());
    }

    private static String[] buildCode(Node root) {
        String[] st = new String[R];
        buildCode(st, root, "");
        return st;
    }

    private static void buildCode(String[] st, Node x, String s) {
        if (x.isLeaf()) {
            st[x.ch] = s;
            return;
        }
        buildCode(st, x.left, s + '0');
        buildCode(st, x.right, s + '1');
    }

    private static Node buildTrie(int[] freq) {
        MinPQ<Node> pq = new MinPQ<Node>();
        for (char c = 0; c < R; c++) {
            if (freq[c] > 0) pq.insert(new Node(c, freq[c], null, null));
        }

        while (pq.size() > 1) {
            Node x = pq.delMin();
            Node y = pq.delMin();
            Node parent = new Node('\0', x.freq + y.freq, x, y);
            pq.insert(parent);
        }
        return pq.delMin();
    }

    public static void expand() {
        Node root = readTrie();
        int N = BinaryStdIn.readInt();
        for (int i = 0; i < N; i++) {
            Node x = root;
            while (!x.isLeaf()) {
                if (BinaryStdIn.readBoolean()) x = x.right;
                else x = x.left;
            }
            BinaryStdOut.write(x.ch);
        }
        BinaryStdOut.close();
    }
    
    public static void main(String[] args) {
        
    }
}
