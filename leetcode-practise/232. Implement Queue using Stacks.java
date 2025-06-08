//tinme complexity for push is O(n)

class MyQueue {
    Stack<Integer> s1, s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    // we use 2 stacks and store the elements in a way that the last element is at the top
    public void push(int x) {
        if (!s1.isEmpty()) {
            while (!s1.isEmpty()) {
                int element = s1.pop();
                s2.push(element);
            }
            s1.push(x);
            while (!s2.isEmpty()) {
                int element = s2.pop();
                s1.push(element);
            }

        }
        else
        s1.push(x);

    }

    public int pop() {
        return s1.pop();
    }

    public int peek() {
       return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty();
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