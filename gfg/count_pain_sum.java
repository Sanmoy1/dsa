//https://www.geeksforgeeks.org/problems/count-pair-sum5956/1?page=1&category=Hash&sortBy=difficulty

//here we are using two pointer approach just like binary search  as the array is sorted

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