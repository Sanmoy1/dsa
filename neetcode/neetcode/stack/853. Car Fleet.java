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
            double calculate=(double)(target-posi)/s;// we perform explicit type casting because for some calculations the value may truncate the fractional part
            if(stack.isEmpty() || calculate>stack.peek())
            stack.push(calculate);
        }
        return stack.size();// the size of the stack is the peek value     
        

    }

    public int carFleet(int target, int[] position, int[] speed) {
        int res = 0;
        double[] time = new double[target];

        for(int i = 0; i < position.length; i++){
            time[position[i]] = (double)(target - position[i]) / speed[i];
        }

        double prev = 0.0;

        for(int i = target - 1; i > -1; i--){
            double cur = time[i];

            //if time arrival to target of a car less than its front car so that mean they gonna meet somewhere on the way to target;

            //if time of front car greater than car behind so that mean they become a car fleet
            if(cur > prev){
                prev = cur;
                res++;
            }
        }
        return res;
    }
}