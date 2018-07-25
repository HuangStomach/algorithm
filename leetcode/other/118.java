import java.util.ArrayList;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if (numRows == 0) return list;

        List<Integer> top = new ArrayList<Integer>();
        top.add(1);
        list.add(top);

        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<Integer>();
            List<Integer> prev = list.get(i - 1);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) row.add(1);
                else {
                    row.add(prev.get(j - 1) + prev.get(j));
                }
            }
            list.add(row);
        }

        return list;
    }
}
