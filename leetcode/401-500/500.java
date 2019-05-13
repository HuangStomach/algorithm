/**
 * 键盘行
 * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。
 */
import java.util.ArrayList;

class Solution {

    public String[] findWords(String[] words) {
        char[] abc = new char[]{
            1, 2, 2, 1, 0, 1, 1, //A,B,C,D,E,F,G
            1, 0, 1, 1, 1, 2, 2, //H,I,J,K,L,M,N
            0, 0, 0, 0, 1, 0, //O,P,Q,R,S,T
            0, 2, 0, 2, 0, 2 //U,V,W,X,Y,Z
        };
        
        ArrayList<String> list = new ArrayList<>();
        for (String word : words) {
            int a = word.charAt(0) > 'Z' ? word.charAt(0) - 'a' : word.charAt(0) - 'A';
            boolean flag = true;
            for (int i = 1; i < word.length(); i++) {
                int b = word.charAt(i) > 90 ? word.charAt(i) - 'a' : word.charAt(i) - 'A';
                if (abc[a] != abc[b]) {
                    flag = false;
                    break;
                }
            }
            if (flag) list.add(word);
        }

        String[] res = new String[list.size()];
        int i = 0;
        for (String word : list) {
            res[i++] = word;
        }
        return res;
    }
}