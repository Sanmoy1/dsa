//https://www.geeksforgeeks.org/problems/count-pair-sum5956/1?page=1&category=Hash&sortBy=difficulty

//here we are using two pointer approach just like binary search  as the array is sorted
//O(n+m) 

public class Solution {
    static int countPairs(int arr1[], int arr2[], int x) {
        // code here.
        int count=0;
        int n=arr1.length;
        int m=arr2.length;                
        int point1=0;
        int point2=m-1;
        while(point1<n && point2>=0)
        {
            int sum=arr1[point1]+arr2[point2];
            if(sum<x)
            {
                point1++;
            }
            else if(sum==x){
            count++;
            point1++;
            }
            
            else
            point2--;
        }
        return count;
    }
}

//solve using hash map
// generally we use hashmap when the array is not sorted but we can also achieve O(n+m) time complexity

static int countPairs(int arr1[], int arr2[], int x) {
    // Initialize variables
    int count = 0;
    int n = arr1.length;
    int m = arr2.length;
    
    // Create a hashmap to store elements of arr2
    HashMap<Integer, Integer> map = new HashMap<>();
    
    // Populate hashmap with elements from arr2
    for (int i = 0; i < m; i++) {
        map.put(arr2[i], map.getOrDefault(arr2[i], 0) + 1);
    }
    
    // Iterate through arr1 to find pairs
    for (int i = 0; i < n; i++) {
        int target = x - arr1[i];
        if (map.containsKey(target)) {
            count += map.get(target); // Add the frequency of target
        }
    }
    
    return count;
}