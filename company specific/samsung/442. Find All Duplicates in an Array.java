class Solution {
    //time complexity O(n)
    //space complexity O(n)
    //better than brurte force(n^2)
    //store the elements in a hashset and check for duplicates
    public List<Integer> findDuplicates(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            if(set.contains(nums[i]))
            {
                arr.add(nums[i]);
                   
            }
            else
            set.add(nums[i]);


        }
        return arr;
    }
    // here we have to change the value of the element in the array to negative if we have visited the number already
    // time complexity O(n)
    //space complexity O(1)
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            int position=nums[Math.abs(nums[i])-1];
            if(position<0)
            ans.add(Math.abs(nums[i]));
            else
            nums[Math.abs(nums[i])-1]=position-2*position;
        }
        return ans;
    }
}