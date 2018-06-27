// 1.5.12
public class CompressQuickUnionUF {
    private int[] id;
    private int[] path;
    private int count;

    public CompressQuickUnionUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
        path = new int[N];
        for (int i = 0; i < N; i++) path[i] = i;
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        int root = p;
        while (root != id[p]) root = id[p];
        while (root != p) {
            int parent = id[p];
            id[p] = root;
            p = parent;
        }
        return root;
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        
        id[i] = j;
        count--;
    }
}