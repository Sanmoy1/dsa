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

    
}

// more optimized solution using bucket sort O(n)

// use hashmap to store the frequency of each element and use a bucket to store the elements with the same frequency in an array

 
class Solution {
    public static int[] topKFrequent(int[] nums, int k) {
        int l=nums.length;
        Map<Integer, Integer> map=new HashMap<>();// this is for storing the freq of each element in the array
        List<Integer> [] freq=new List[nums.length+1];// this is the bucket list

        for(int i=0;i<freq.length;i++)
        {
            freq[i]=new ArrayList<>();
        }

        for(int n:nums)// storing the freq of each element in a hashmap
        {
            map.put(n,map.getOrDefault(n,0)+1);
        }

        for( Map.Entry<Integer,Integer> entry:map.entrySet())// groups elements by their freq
        {
            freq[entry.getValue()].add(entry.getKey());
        }

        int res[]=new int[k];// to store the result 
        int index=0;// as we are using a bucket sort we need to keep track of the index
        for(int i=freq.length-1; i>0 && index < k ;i--)// this extracts the top k freq elements from the freq array
        {
            for(int n:freq[i])
            {
                res[index++]=n;
                if(index==k)
                {
                    return res;
                }
            }
        }
        return res;

    }
    public static void main(String[] args) {
        int nums[]={1,1,1,2,2,2,3};
        int k=2;
        System.out.println(Arrays.toString(topKFrequent(nums,k)));
    }
    
}


