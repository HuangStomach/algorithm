import java.util.ArrayList;

// 1.5.20
public class QueueWeightedQuickUnionUF {
    private ArrayList<Integer> id = new ArrayList<Integer>();
    private ArrayList<Integer> sz = new ArrayList<Integer>();
    private int count = 0;

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int NewSite() {
        id.add(id.size(), id.size());
        sz.add(id.size(), 1);
        this.count++;
        return id.size() - 1;
    }

    public int find(int p) {
        while (p != id.get(p)) p = id.get(p);
        return p;
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);

        int szi = sz.get(i);
        int szj = sz.get(j);

        if (szi < szj) {
            id.set(i, j);
            sz.set(i, szi + szj);
        }
        else {
            id.set(j, i);
            sz.set(j, szi + szj);
        }
        count--;
    }
}