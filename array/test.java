import java.util.Stack;

public class test{
    Stack<Integer> stack;
    Stack<Integer> minstack;

    public test() {
        stack=new Stack<>();
        minstack=new Stack<>();
        
    }
    
    public void push(int val) {
        stack.push(val);
        if(!minstack.isEmpty())
        {
            minstack.push(Math.min(val,minstack.peek()));
        }
        else
        minstack.push(val);
        
    }
    
    public void pop() {
        int element=stack.pop();;
        if(element==minstack.peek() )
        {
            // System.out.println("Current min: " + minstack.peek());
            minstack.pop();
            
        }
        
        
    }
    
    public int top() {
        
        return stack.peek();
    }
    
    public int getMin() {
        
        return minstack.peek();
    }

    public static void main(String[] args) {
        test minStack = new test();
        minStack.push(2);
        System.out.println("Current min: " + minStack.getMin());
        minStack.push(0);
        System.out.println("Current min: " + minStack.getMin());
        minStack.push(3);
        System.out.println("Current min: " + minStack.getMin());
        minStack.push(0);
        
        System.out.println("Current min: " + minStack.getMin()); 
        minStack.pop();
        System.out.println("Current min: " + minStack.getMin()); 
        minStack.pop();
        System.out.println("Current min: " + minStack.getMin()); 
        minStack.pop();
        // Assuming we want to handle the case when getMin is called on an empty stack
        try {
            System.out.println("Current min: " + minStack.getMin()); // Should throw exception
        } catch (IllegalStateException e) {
            System.out.println("Stack is empty. Cannot perform getMin.");
        }
    }
}