<?php
// 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

class Solution {

    /**
     * @param String $s
     * @param String[] $wordDict
     * @return Boolean
     */
    function wordBreak($s, $wordDict) {
        $length = strlen($s);
        $array = [true];
        
        for ($i = 1; $i <= $length; $i++) {
            for ($j = 0; $j < $i; $j++) {
                if ($array[$j] && in_array(substr($s, $j, $i - $j), $wordDict)) {
                    $array[$i] = true;
                    break;
                }
            }
        }

        return $array[$length];
    }
}
?>