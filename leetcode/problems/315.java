/**
 * 计算右侧小于当前元素的个数
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 */
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    TreeNode root; // 记录搜索树根节点
    Map<TreeNode,Integer> map = new HashMap<>(); // 节点,当前节点的子树个数+1

    class TreeNode{
        int small;
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val, int count) {
            this.val = val;
            this.small = count;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        List<Integer> res = new LinkedList<>();
        for (int i = len - 1; i >= 0; i--) {
            res.add(0, buildTree(nums[i]));// 从后到前依次加入二叉搜索树
        }
        return res;
    }
    
    public int buildTree(int x){
        if (root == null) { //初次
            root = new TreeNode(x, 0);
            return 0;
        }

        TreeNode node = root;
        int count = 0;
        while(true) {
            //先更新map里的node
            if (map.containsKey(node)) map.put(node, map.get(node) + 1);
            else map.put(node, num(node) + 1);
            
            if (node.val < x) {
                //加上node及其左子树
                if (map.containsKey(node.left)) count += map.get(node.left) + 1;
                else {
                    int y = num(node.left);
                    count += y + 1;
                    map.put(node.left, y);
                }

                //node往右
                if (node.right != null) node = node.right;
                else{
                    //终点
                    node.right = new TreeNode(x, count);
                    break;
                }
            }
            else {
                if (node.left != null) node = node.left;
                else{
                    node.left = new TreeNode(x, count);
                    break;
                }
            }
        }
        return count;
    }
    
    public int num(TreeNode x) {//计算
        if (x == null) return 0;
        return num(x.left) + num(x.right) + 1;
    }
}