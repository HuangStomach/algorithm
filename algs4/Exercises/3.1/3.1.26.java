import java.util.Arrays;

import edu.princeton.cs.algs4.*;

class FrequencyCounter {
    public static void main(String[] args) {
        ST<String, Integer> st = new ST<String, Integer>();
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (!st.contains(word)) st.put(word, 1);
            else st.put(word, st.get(word) + 1);
        }

        Item[] list = new Item[st.size()];
        int i = 0;
        for (String word : st.keys()) {
            list[i] = new Item(word, st.get(word));
            i++;
        };
        
        for (i = 0; i < list.length; i++) {
            System.out.print(list[i].key + " ");
        }

        Arrays.sort(list);
        System.out.println();
        for (i = 0; i < list.length; i++) {
            System.out.print(list[i].key + " ");
        }
    }
}

class Item implements Comparable<Item> {
    public String key;
    public int val;
    Item(String key, int val) {
        this.key = key;
        this.val = val;
    }

    public int compareTo(Item that) {
        return this.val - that.val;
    }
}
