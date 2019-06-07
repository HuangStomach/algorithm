/**
 * 单词接龙
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 */
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;

        Set<String> beginSet = new HashSet<String>();
        Set<String> endSet = new HashSet<String>();

        beginSet.add(beginWord);
        endSet.add(endWord);

        int step = 1;
        while (beginSet.size() > 0) {
            for (String s : beginSet) {
                wordList.remove(s);
            }

            step++;
            Set<String> tempSet = new HashSet<>();
            for (String b : beginSet) {
                for (String w: wordList) {
                    if (diff(b, w) > 1) continue;
                    
                    if (endSet.contains(w)) return step;
                    
                    tempSet.add(w);
                }
            }

            /*
             * 这里的tempSet其实是nextBeginSet, 判断一下从哪边走简单就从哪边走
             */
            if (tempSet.size() > endSet.size()) {
                beginSet = endSet;
                endSet = tempSet;
            } else {
                beginSet = tempSet;
            }
        }
        return 0;
    }
    
    private int diff(String w1, String w2) {
        int deviation = 0;
        for (int i = 0; i < w1.length() && deviation < 2; ++i) {
            if (w1.charAt(i) != w2.charAt(i)) {
                ++deviation;
            }
        }
        return deviation;
    }
}