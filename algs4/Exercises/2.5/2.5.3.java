// 其中当amount相等的时候compareTo的顺序会使结果一样
public class Balance implements Comparable<Balance> {
    private double amount;

    public int compareTo(Balance that) {
        if (this.amount < that.amount - 0.005) return -1;
        if (this.amount > that.amount + 0.005) return 1;
        return 0;
    }
}