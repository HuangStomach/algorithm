class SeparateChainingHashST<Key, Value> {
    private int N;
    private int M;
    private SequentialSearchST<Key, Value>[] st;

    public SeparateChainingHashST() {
        this(997);
    }

    public SeparateChainingHashST(int M) {
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST();
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int cap) {
        SeparateChainingHashST<Key, Value> t = new SeparateChainingHashST(cap);
        for (int i = 0; i < M; i++) {
            if (st[i] != null) t.put(keys[i], vals[i]);
        }
        this.st = t.st;
        this.M = t.M;
    }

    public Value get(Key key) {
        return (Value) st[hash(key)].get(key);
    }

    public void put(Key key, Value val) {
        if (N >= 8 * M) resize(2 * M);
        st[hash(key)].put(key, val, this.N);
        N = 0;
        for (int i = 0; i < M; i++) {
            if (st[i] != null) this.N += st[i].size();
        }
    }

    public void delete(Key key) {
        if (!contains(key)) return;
        st[hash(key)].delete(key);
        N--;
        if (N > 0 && N <= 2 * M) resize(M / 2);
    }

    public void deleteBelow(int k) {
        for (int i = 0; i < M; i++) {
            if (st[i] != null) st[i].deleteBelow(k);
        }
        if (N > 0 && N <= 2 * M) resize(M / 2);
    }

    private class SequentialSearchST<Key, Value> {
        private int N;
        private Node first;
        private class Node {
            Key key;
            Value val;
            Node next;
            int index;

            public Node(Key key, Value val, Node next, int index) {
                this.key = key;
                this.val = val;
                this.next = next;
                this.index = index;
            }
        }

        public Value get(Key key) {
            for (Node x = first; x != null; x = x.next) {
                if (key.equals(x.key)) return x.val;
            }
            return null;
        }

        public void put(Key key, Value val, int index) {
            for (Node x = first; x != null; x = x.next) {
                if (key.equals(x.key)) {
                    x.val = val;
                    return;
                }
            }
            first = new Node(key, val, first, index);
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

        public void deleteBelow(int k) {
            if (first == null) return;
            Node node = first;
            while (node != null) {
                if (node.index <= k) delete(node.key);
                else node = node.next;
            }
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
}
