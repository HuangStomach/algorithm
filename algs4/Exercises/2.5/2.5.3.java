// amount为私有属性无法被that直接获取
public class Balance implements Comparable<Balance> {
    private double amount;

    public int compareTo(Balance that) {
        if (this.amount < that.amount - 0.005) return -1;
        if (this.amount > that.amount + 0.005) return 1;
        return 0;
    }
}