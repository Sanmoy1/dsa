//https://leetcode.com/problems/top-k-frequent-elements/


//optimized solution using hashmap O(n logn)

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for (int i=0;i<nums.length;i++)
        {
            if(!map.containsKey(nums[i]))
            {
                map.put(nums[i],1);
            }
            else
            {
                int currentValue=map.get(nums[i]);
                map.put(nums[i],currentValue+1);
            }
        }

        System.out.println("this is the hashmap = "+map);


        List<Map.Entry<Integer,Integer>> list=new ArrayList<>(map.entrySet());//converting hashmap to list
        System.out.println("this is the list = "+list);
        list.sort((entry1,entry2)-> entry2.getValue().compareTo(entry1.getValue()));//sorting the list

        int ans[]=new int[k];
        for (int i=0;i<k;i++)//returning the top k elements
        {
            ans[i]=list.get(i).getKey();
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums[]={1,1,1,2,2,3};
        int k=2;
        System.out.println(topKFrequent(nums,k));
    }
}

