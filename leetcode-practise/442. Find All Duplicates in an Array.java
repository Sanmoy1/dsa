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
}