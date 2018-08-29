import edu.princeton.cs.algs4.*;

class GPA {
    public static void main(String[] args) {
        SequentialSearchST<String, Double> st = new SequentialSearchST<String, Double>();
        
        while (!StdIn.isEmpty()) {
            String line = StdIn.readLine();
            String[] score = line.split(" ");
            st.put(score[0], Double.parseDouble(score[1]));
        }
    }
}

class SequentialSearchST<Key, Value> {
    private int N;
    private Node first;
    private class Node {
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) return x.val;
        }
        return null;
    }

    public void put(Key key, Value val) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        N++;
    }

    public Key delete(Key key) {
        Node prev = null;
        for (Node x = first; x != null; prev = x, x = x.next) {
            if (key.equals(x.key)) {
                prev.next = x.next;
                N--;
                return key;
            }
        }
        return null;
    }

    public int size() {
        return N;
    }

    public Iterable<Key> keys() {
        List<Key> list = new ArrayList<Key>();
        for (Node x = first; x != null; x = x.next) {
            list.add(x.key);
        }
        return list;
    }
}