class MathSET<Key> {
    Key[] universe;
    boolean[] keys;
    int M;
    int N;
    
    MathSET(Key[] universe) {
        this(universe, 997);
    }
    
    MathSET(Key[] universe, int M) {
        this.universe = universe;
        this.keys = new boolean[M];
        this.M = M;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void add(Key key) {
        if (!contains(key)) N++;
        keys[hash(key)] = true;
    }

    public void delete(Key key) {
        if (!contains(key)) return;
        keys[hash(key)] = false;
        N--;
    }

    public boolean contains(Key key) {
        return keys[hash(key)];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public MathSET<Key> complement() {
        MathSET<Key> st = new MathSET<Key>(this.universe);
        for (int i = 0; i < this.universe.length; i++) {
            if (!keys[hash(this.universe[i])]) st.add(this.universe[i]);
        }
        return st;
    }

    public void union(MathSET<Key> a) {
        for (int i = 0; i < a.keys.length; i++) {
            if (a.keys[i] && !this.keys[i]) this.keys[i] = true;
        }
    }

    public void intersection(MathSET<Key> a) {
        for (int i = 0; i < this.keys.length; i++) {
            if (!a.keys[i]) this.keys[i] = false;
        }
    }
}
