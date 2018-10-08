// 1.5.11
// 实际上时间复杂度不会少 反而会变多
public class WeightedQuickFindUF {
    private int[] id;
    private int[] sz;
    private int count;

    public WeightedQuickFindUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
        sz = new int[N];
        for (int i = 0; i < N; i++) sz[i] = i;
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
        
        if (sz[i] > sz[j]) {
            sz[i] += sz[j];
            for (int k = 0; k < id.length; k++) {
                if (id[k] == j) {
                    id[k] = i;
                    sz[k] = sz[i];
                }
            }
        }
        else {
            sz[j] += sz[i];
            for (int k = 0; k < id.length; k++) {
                if (id[k] == i) {
                    id[k] = j;
                    sz[k] = sz[j];
                }
            }
        }
        count--;
    }
}