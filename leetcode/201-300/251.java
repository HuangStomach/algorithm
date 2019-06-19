/**
 * 展开二维向量
 * 请设计并实现一个能够展开二维向量的迭代器。该迭代器需要支持 next 和 hasNext 两种操作。
 */
class Vector2D {
    public int[][] v;
    public int i;
    public int j;

    public Vector2D(int[][] v) {
        this.v = v;
        this.i = 0;
        this.j = 0;
        while (i < v.length && j >= this.v[i].length) {
            i++;
            j = 0;
        }
    }
    
    public int next() {
        int val = v[i][j];
        j++;
        while (i < v.length && j >= v[i].length) {
            i++;
            j = 0;
        }
        return val;
    }
    
    public boolean hasNext() {
        return i == v.length - 1 ? (j < v[i].length) : i < v.length - 1;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */