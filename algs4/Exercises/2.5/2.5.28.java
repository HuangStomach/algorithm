import java.io.File;

import edu.princeton.cs.algs4.*;

class FileSorter {
    public static void main(String[] args) {
        MaxPQ pq = new MaxPQ();
        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            File file = new File(name);
            pq.insert(file);
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.delMax().getName());
        }
    }
}

class MaxPQ {
    private Node head;
    private int N = 0;
    private class Node {
        File val;
        Node next;
        Node(File val) {
            this.val = val;
        }
    }

    public MaxPQ() {
        head = null;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(File v) {
        if (head == null) {
            head = new Node(v);
        }
        else {
            Node top = head;
            while (top != null) {
                if (top.val.getName().compareTo(v.getName()) < 0) {
                    Node node = new Node(v);
                    node.next = top.next;
                    top.val = v;
                    top.next = node;
                    break;
                }

                if (top.next == null) {
                    Node node = new Node(v);
                    top.next = node;
                    break;
                }

                top = top.next;
            }
        }
        N++;
    }

    public File delMax() {
        File val = head.val;
        head = head.next;
        N--;
        return val;
    }
}