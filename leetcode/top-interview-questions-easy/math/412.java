import java.util.ArrayList;

class Solution {
    public List<String> fizzBuzz(int n) {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            if (i > 5 && i % 5 == 0 && i % 3 == 0) {
                list.add("FizzBuzz");
            }
            else if (i >= 3 && i % 3 == 0) {
                list.add("Fizz");
            }
            else if (i >= 5 && i % 5 == 0) {
                list.add("Buzz");
            }
            else {
                list.add(Integer.toString(i));
            }
        }
        return list;
    }
}