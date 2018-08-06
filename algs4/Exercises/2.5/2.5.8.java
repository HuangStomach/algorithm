import java.util.Arrays;
import java.util.Comparator;

import edu.princeton.cs.algs4.*;

class Frequency {
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        int n = a.length;
        Arrays.sort(a);
        
        Record[] records = new Record[n];
        String word = a[0];
        int count = 1; // 该单词出现的次数
        int index = 0; // 第几个单词
        for (int i = 1; i < n; i++) {
            // 如果当前单词和上一个单词不一致了 则进行记录
            if (!a[i].equals(word)) {
                records[index++] = new Record(word, count); // 数组中记录下该单词和出现的次数
                word = a[i];
                count = 0;
            }
            count++; // 相同则记录出现次数+1
        }
        records[index++] = new Record(word, count); // 补全最后一个单词

        Comparator c = new C();
        Arrays.sort(records, 0, index, c);
        for (int i = index - 1; i >= index - 10; i--) {
            StdOut.println(records[i]);
        }
    }
}

class Record {
    public int count;
    public String word;
    Record(String word, int count) {
        this.word = word;
        this.count = count;
    }

    @Override
    public String toString() {
        return this.word + ": " + this.count;
    }
}

class C implements Comparator<Record> {
    public int compare(Record a, Record b) {
        return a.count - b.count;
    }
}