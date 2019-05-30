/**
 * 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<List> list = new ArrayList<>();
        subsets(nums, 0, list);
        return res;
    }
    
    void subsets(int [] nums, int start, List list){
        res.add(new ArrayList(list));
        if (start == nums.length) return;

        for(int i = start; i < nums.length; i++){
            list.add(nums[i]);
            subsets(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
