<?php
// 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
// 返回 s 所有可能的分割方案。
class Solution {
    public $array = [];
    /**
     * @param String $s
     * @return String[][]
     */
    function partition($s) {
        $this->nextWords($s, 0);
        return $this->array;
    }

    function nextWords($s, $index, $ss = []) {
        if (strlen($s) == $index) {
            $this->array[] = $ss;
            return;
        }

        for ($i = $index; $i < strlen($s); $i++) {
            $sub = substr($s, $index, $i - $index + 1);
            if ($this->isPartition($sub)) {
                $ss[] = $sub;
                $this->nextWords($s, $i + 1, $ss);
                array_pop($ss);
            }
        }
    }

    function isPartition($s) {
        $length = strlen($s);
        for ($i = 0; $i < floor($length / 2); $i++) {
            if ($s[$i] != $s[$length - $i - 1]) return false;
        }
        return true;
    }
}
?>