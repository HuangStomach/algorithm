class MaxPQ<Key extends Comparable<Key>> {
    public Node head;
    private Node last;
    private int N = 0;
    private class Node {
        Key val;
        int code;
        Node parent;
        Node left;
        Node right;
        Node(Key val) {
            this.val = val;
            this.code = N + 1;
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        Node node = new Node(v);
        double level = Math.log(N + 1) / Math.log(2);

        if (head == null) {
            head = node;
        }
        else if (level == Math.ceil(level)) {
            // 当 N + 1 是 2 的 M 次方的时候
            Node top = head;
            while (top.left != null) {
                top = top.left;
            }
            top.left = node;
            node.parent = top;
        }
        else {
            Node parent = last.parent;
            node.parent = parent;
            if (parent.right == null) parent.right = node;
            else {
                parent = lastParent(head);
                node.parent = parent;
                if (parent.left == null) parent.left = node;
                else if (parent.right == null) parent.right = node;
            }
        }
        last = node;
        N++;
        swim(node);
    }

    private Node lastParent(Node node) {
        if (node.right == null) return node;
        Node left = lastParent(node.left);
        Node right = lastParent(node.right);
        return left == null ? left : right;
    }

    private void last(Node node) {
        if (node == null) return;
        if (node.code == N) last = node;
        last(node.left);
        last(node.right);
    }

    public Key delMax() {
        Key max = head.val;
        double level = Math.log(N) / Math.log(2);

        if (last == head) {
            head = null;
            last = null;
            return max;
        }
        
        head.val = last.val;
        N--;
        if (level == Math.ceil(level)) {
            last.parent.left = null;
        }
        else if (last.parent.right != null) {
            last.parent.right = null;
        }
        else if (last.parent.left != null && last.parent.right == null) {
            last.parent.left = null;
        }
        last(head);
        
        sink(head);
        return max;
    }

    private boolean less(Key i, Key j) {
        return i.compareTo(j) < 0;
    }

    private void swim(Node node) {
        Key val = node.val;
        while (node.parent != null && less(node.parent.val, val)) {
            node.val = node.parent.val;
            node = node.parent;
        }
        node.val = val;
    }

    private void sink(Node node) {
        Key val = node.val;
        while (node.left != null || node.right != null) {
            if (node.left != null && node.right != null) {
                if (node.right.val.compareTo(node.left.val) <= 0 && less(val, node.left.val)) {
                    node.val = node.left.val;
                    node = node.left;
                }
                else if (node.left.val.compareTo(node.right.val) <= 0 && less(val, node.right.val)) {
                    node.val = node.right.val;
                    node = node.right;
                }
                else {
                    break;
                }
            }
            else if (less(val, node.left.val)) {
                node.val = node.left.val;
                node = node.left;
            }
            else {
                break;
            }
        }
        node.val = val;
    }

    public static void main(String[] args) {
        MaxPQ pq = new MaxPQ();
        String[] array = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
        for (int i = 0; i < array.length; i++) {
            pq.insert(array[i]);
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(pq.delMax());
        }
        System.out.println();
    }
}