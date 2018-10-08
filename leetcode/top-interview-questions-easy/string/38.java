class Solution {
    public String countAndSay(int n) {
        int m = 1;
        String str = "1";
        while (m < n) {
            StringBuilder temp = new StringBuilder();
            char x = ' ';
            int y = 0;
            for (int i = 0; i < str.length(); i++) {
                char j = str.charAt(i);
                if (x == ' ') {
                    x = j;
                    y++;
                }
                else if (x == j) y++;
                else {
                    temp.append(y);
                    temp.append(x);
                    x = j;
                    y = 1;
                }
            }
            temp.append(y);
            temp.append(x);
            str = temp.toString();
            m++;
        }
        return str;
    }
}