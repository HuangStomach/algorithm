import java.util.Date;

public class Transaction {
    private final String who;
    private final Date when;
    private final double amount;
    private int hash = -1;
    
    public int hashCode() {
        if (this.hash > 0) return this.hash;
        int hash = 17;
        hash = 31 * hash + who.hashCode();
        hash = 31 * hash + when.hashCode();
        hash = 31 * hash + ((Double) amount).hashCode();
        return hash;
    }
}