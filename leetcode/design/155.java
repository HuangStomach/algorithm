class MinStack {
    TreeNode first = null;

    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        if (first == null) first = new TreeNode(x, x);
        else {
            TreeNode node = new TreeNode(x, Math.min(x, first.min));
            node.next = first;
            first = node;
        }
    }
    
    public void pop() {
        if (first == null) return;
        first = first.next;
    }
    
    public int top() {
        return first.val;
    }
    
    public int getMin() {
        return first.min;
    }

    private class TreeNode {
        int val;
        int min;
        TreeNode next;
        TreeNode(int x, int min) { 
            this.val = x; 
            this.min = min; 
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */