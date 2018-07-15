/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 采用二分法 每次都取中间部分来作为节点的值
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return tree(nums, 0, nums.length - 1);
    }
     
    public TreeNode tree(int[] nums, int l, int r){
        if (l > r) return null;
        
        int mid = (l + r) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = tree(nums, l, mid - 1);
        node.right = tree(nums, mid + 1, r);
        return node;
    }
}
