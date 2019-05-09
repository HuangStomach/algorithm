/**
 * 数组中的K-diff数对
 * 给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.
 */
import java.util.HashMap;

class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;
	    int ans = 0;
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int num : nums){
	        map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
	    if (k == 0) {
	        for (int num : map.keySet()) {
		        if (map.get(num) > 1) ans++;
	        }
        }
        else {
	        for (int num : map.keySet()) {
		        if (map.containsKey(num + k)) ans++;
		    }
	    }
        return ans;
    }
}