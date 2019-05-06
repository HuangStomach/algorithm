/**
 * 单词拆分 II
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * 说明：
 *    分隔时可以重复使用字典中的单词。
 *    你可以假设字典中没有重复的单词。
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
    ArrayList<String> list = new ArrayList<String>();
    List<String> wordDict;

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.wordDict = wordDict;
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        // 先使用动态规划 检查是否可以进行切分
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // 如果这个点被切分过则可以视为起点
                if (dp[j] && this.wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        // 如果最后一个点不能被切分 则肯定无法符合要求
        if (!dp[s.length()]) return this.list;

        StringBuilder sb = new StringBuilder();
        dfs(s, sb, 0);
        return this.list;
    }

    public void dfs(String s, StringBuilder sb, int start) {
        if (start == s.length()) {
            this.list.add(sb.toString().trim());
        }

        for (int i = start + 1; i <= s.length(); i++) {
            String str = s.substring(start, i);
            if (this.wordDict.contains(str)) {
                int length = sb.length();
                sb.append(str + " ");
                this.dfs(s, sb, i);
                // 为了防止后续的递归影响这里对sb的操作，要将长度重置为递归之前
                sb.setLength(length);
            }
        }
    }
}