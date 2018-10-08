import edu.princeton.cs.algs4.*;

class Stock {
    public double price;
    public int count;
    public Stock next;
    public static PQ buyPQ;
    public static PQ sellPQ;

    public Stock(double price, int count) {
        this.price = price;
        this.count = count;
    }

    public int compareTo(Stock that) {
        return (int)(this.price - that.price);
    }

    public static void trade() {
        Stock sell = sellPQ.peek();
        Stock buy = buyPQ.peek();
        while (sell != null && sell != null && sell.price <= buy.price) {
            int count = sellPQ.del(buy.count);
            buyPQ.del(count);
            System.out.println("股票以" + sell.price + "的价格成交了" + count + "比");
            sell = sellPQ.peek();
            buy = buyPQ.peek();
        }
    }

    public static void main(String[] args) {
        buyPQ = new PQ(1);
        sellPQ = new PQ(0);
        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            String[] array = str.split(":");
            Stock stock = new Stock(Double.parseDouble(array[1]), Integer.parseInt(array[2]));
            
            if (array[0].equals("buy")) buyPQ.insert(stock);
            else sellPQ.insert(stock);
            if (!sellPQ.isEmpty() && !buyPQ.isEmpty()) trade();
        }
    }
}

class PQ {
    private Stock head;
    private int flag = 0; // 0 为面向最小队列 1 为面向最大队列
    private int N = 0;

    public PQ(int flag) {
        this.flag = flag;
        head = null;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Stock v) {
        N++;
        if (head == null) {
            head = v;
            return;
        }
        
        Stock top = head;
        while (top != null) {
            Boolean result = flag == 0 
            ? top.compareTo(v) > 0
            : top.compareTo(v) < 0;
            if (result) {
                Stock current = new Stock(top.price, top.count);
                current.next = top.next;

                top.price = v.price;
                top.count = v.count;
                top.next = current;
                break;
            }

            if (top.next == null) {
                top.next = v;
                break;
            }
            
            top = top.next;
        }
    }

    public int del(int count) {
        if (head.count > count) {
            head.count -= count;
        }
        else {
            count = head.count;
            head = head.next;
            N--;
        }

        return count;
    }

    public Stock peek() {
        return head;
    }
}
