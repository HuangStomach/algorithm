// 1.5.7
public class QuickFindUF {
    private int[] id;
    private int count;

    public QuickFindUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        return id[p];
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        
        for (int k = 0; k < id.length; k++) {
            if (id[k] == i) id[k] = j;
        }
        count--;
    }
}