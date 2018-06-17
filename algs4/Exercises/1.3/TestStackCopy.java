import edu.princeton.cs.algs4.*;

 /* public static <T> Stack<T> copy(Stack<T> s)  
{  
    Iterator<T> it = s.iterator();  
    Stack<T> result = new Stack<T>();  
    Stack<T> temp = new Stack<T>();  
    while (it.hasNext()) {  
        temp.push(it.next());  
    }  
    it = temp.iterator();  
    while (it.hasNext()) {  
        result.push(it.next());  
    }  
    return result;  
} */

// 1.3.12
public class TestStackCopy {  
    public static void main(String[] args) {
        Stack<String> s1 = new Stack<String>();  
        s1.push("a");  
        s1.push("b");  
        s1.push("c");  
          
        Stack<String> s2 = Stack.copy(s1);  
        while (!s2.isEmpty()) {  
            System.out.println(s2.pop());  
        }
    }
}
