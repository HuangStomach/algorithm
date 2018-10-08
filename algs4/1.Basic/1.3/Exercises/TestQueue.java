import edu.princeton.cs.algs4.*;

// 1.3.15
public class TestQueue {  
    public static void main(String[] args) {
        int index = Integer.parseInt(args[0]);
        String[] array = {"这是五", "这是四", "这是三", "这是二", "这是一"};
        
        Queue<String> q = new Queue<String>();
        for (int i = 0; i < array.length; i++) {
            q.enqueue(array[i]);
        }
        
        String str = "";
        while (q.size() >= index) {
            str = q.dequeue();
        }
        System.out.println(str);
    }
}
