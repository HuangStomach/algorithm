import edu.princeton.cs.algs4.*;

class FrequencyCounter {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long start = runtime.freeMemory(); // 开始时的剩余内存  
        ST<String, Integer> st = new ST<String, Integer>();
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (!st.contains(word)) st.put(word, 1);
            else st.put(word, st.get(word) + 1);
        }

        String max = " ";
        st.put(max, 0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max)) max = word;
        }
        long free = start - runtime.freeMemory(); // 剩余内存 现在

        System.out.println("占用内存: " + free);
    }
}