class Solution {
    // complexity O(n)
    // space complexity O(n)
    // we use stack here and pop the elements from the stack when we see an operator and again push the result
    // there is no brute force approach for this problem
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        int l=tokens.length;
        
        for(int i=0;i<l;i++)
        {
            if(tokens[i].equals("+"))// always use equals for strings
            {
                
                int c1=stack.pop();
                int c2=stack.pop();
                stack.push(c2+c1);
            }
            else if(tokens[i].equals("-"))
            {
                int c1=stack.pop();
                int c2=stack.pop();
                stack.push(c2-c1);
            }
            else if(tokens[i].equals("*"))
            {
                int c1=stack.pop();
                int c2=stack.pop();
                stack.push(c2*c1);
            }
            else if(tokens[i].equals("/"))
            {
                int c1=stack.pop();
                int c2=stack.pop();
                stack.push(c2/c1);
            }
            else
            stack.push(Integer.valueOf(tokens[i]));
        }
        return stack.peek();
    }
}