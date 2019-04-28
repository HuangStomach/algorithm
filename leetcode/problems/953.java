// 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
// 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
import java.util.HashMap;

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i++) {
            for(int j = i + 1; j < words.length; j++) {
                int k = 0, m = 0;
                int len1 = words[i].length();
                int len2 = words[j].length();
                
                while (k < len1 && m < len2) {
                    int c1 = map.get(words[i].charAt(k));
                    int c2 = map.get(words[j].charAt(m));
                    
                    if (c1 > c2) return false;
                    else if (c1 < c2) break;
                    
                    k++;
                    m++;
                }

                if (k != len1 && m == len2) return false;
            }
        }

        return true;
    }
}