import edu.princeton.cs.algs4.*;

public class Cuckoo<Key, Value> {
    private int N;
    private int M;
    private Key[] keysA;
    private Value[] valsA;
    private Key[] keysB;
    private Value[] valsB;

    public Cuckoo() {
        this(11);
    }

    public Cuckoo(int M) {
        this.M = M;
        keysA = (Key[]) new Object[this.M];
        valsA = (Value[]) new Object[this.M];
        keysB = (Key[]) new Object[this.M];
        valsB = (Value[]) new Object[this.M];
    }

    private int hashA(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }
    private int hashB(Key key) {
        return ((key.hashCode() & 0x7fffffff) % M) * 11 % M;
    }

    private void resize(int cap) {
        Cuckoo<Key, Value> cuckoo = new Cuckoo(cap);
        for (int i = 0; i < M; i++) {
            if (keysA[i] != null) t.put(keysA[i], valsA[i]);
            if (keysB[i] != null) t.put(keysB[i], valsB[i]);
        }
        this.keysA = t.keysA;
        this.valsA = t.valsA;
        this.keysB = t.keysB;
        this.valsB = t.valsB;
        this.M = t.M;
    }

    public void put(Key key, Value val) {
        if (N >= M / 2) resize(2 * M);

        if (grab(key, val, hashA(key))) return;
        if (grab(key, val, hashB(key))) return;
        
        resize(2 * M);
        put(key, val);
    }

    private boolean grab(Key key, Value val, int i) {
        if (keysA[i] == null) {
            keysA[i] = key;
            valsA[i] = val;
            N++;
            return true;
        }

        Key keyA = keysA[i];
        Value valA = valsA[i];
        keysA[i] = key;
        valsA[i] = val;

        if (keysB[i] == null) {
            keysB[i] = keyA;
            valsB[i] = valA;
            N++;
            return true;
        }

        Key keyB = keysB[i];
        Value valB = valsB[i];
        keysB[i] = keyA;
        valsB[i] = valA;
        keysA[i] = keyB;
        valsA[i] = valB;
        return false;
    }
    
    public Value get(Key key) {
        int i = hashA(key);
        int j = hashB(key);

        if (keysA[i].equals(key)) return valsA[i];
        if (keysB[i].equals(key)) return valsB[i];
        if (keysA[j].equals(key)) return valsA[j];
        if (keysB[j].equals(key)) return valsB[j];

        return null;
    }
}