class Solution {

    // Time complexity is O(nlog(n))
    //space complexity is O(n)
    // use treemap as sorting is required in descending order
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer,Integer> map=new TreeMap<>(Collections.reverseOrder());
        int l=position.length;
        for(int i=0;i<l;i++)
        {
            map.put(position[i],speed[i]);
        }
        Stack<Double> stack=new Stack<>();// storing the time taken to reach the target
        for(Map.Entry<Integer,Integer> m:map.entrySet())
        {
            int posi=m.getKey();
            int s=m.getValue();
            double calculate=(double)(target-posi)/s;
            if(stack.isEmpty() || calculate>stack.peek())
            stack.push(calculate);
        }
        return stack.size();// the size of the stack is the peek value     
        

    }
}