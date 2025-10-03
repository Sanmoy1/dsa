
//time complexity for each operation is O(1)

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minstack;

    public MinStack() {
        stack=new Stack<>();
        minstack=new Stack<>();
        
    }
    
    public void push(int val) {// we push either the val or the min of minstack
        stack.push(val);
        if(!minstack.isEmpty())
        {
            minstack.push(Math.min(val,minstack.peek()));
        }
        else
        minstack.push(val);
        
    }
    
    public void pop() {
        stack.pop();
        minstack.pop();
    }
        
        
    
    
    public int top() {
        
        return stack.peek();
    }
    
    public int getMin() {
        
        return minstack.peek();
    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */