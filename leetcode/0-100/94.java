/**
 * 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode T = root;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        while (T != null || !stack.isEmpty()) {
            while (T != null) {
                stack.push(T);
                T = T.left;
            }

            // 用栈来做： 
            // 1、从根节点开始一直往左走，将经过的所有节点压栈； 
            // 2、栈不空则出栈，将出栈节点添加到list并且转向该节点的右子树； 
            // 3、栈为空则重复执行上述两个步骤。
            if (!stack.isEmpty()) {
                T = stack.pop();
                list.add(T.val);
                T = T.right;
            }
        }

        return list;
    }
}
