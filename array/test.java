import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class test{
    public static void main(String[] args) {
        Queue<Integer> q = new PriorityQueue<>();
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(4);
        s.push(2);
        s.push(10);
        s.push(5);
        s.pop();
        System.out.println("stack"+s);
        System.out.println("stack peek"+s.peek());
              q.add(1);
              q.add(4);
              q.add(2);
              q.add(10);
              q.add(5);
              q.poll();
              q.poll();
              q.poll();
              q.poll();
              q.poll();
              System.out.println(q.poll());
              System.out.println("queue"+q);
              System.out.println("queue peek"+q.peek());
    }
}