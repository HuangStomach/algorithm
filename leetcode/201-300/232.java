/**
 * 用栈实现队列
 * 使用栈实现队列的下列操作：
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 */
import java.util.Stack;

class MyQueue {
    public Stack<Integer> putStack;
    public Stack<Integer> outStack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        putStack = new Stack<>();
        outStack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        putStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        transfer();
        return outStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        transfer();
        return outStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return putStack.isEmpty() && outStack.isEmpty();
    }

    public void transfer() {
        if (outStack.isEmpty()) {
            while (!putStack.isEmpty()) outStack.push(putStack.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */