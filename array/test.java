import java.util.Arrays;

public class test{

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int length = numbers.length;
        int right = length - 1;
        int ans[] = new int[2];
        while (left < right) {            

            if ((numbers[left] + numbers[right]) == target) 
            {
                ans[0] = left + 1;
                ans[1] = right + 1;
                return ans;
            } 
            else 
            {
                int mid = (left + right) / 2;
                if (mid > target) {
                    right = mid - 1;
                } else {
                    left=left+1;
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        test obj=new test();
        int nums[]={2,7,11,15};
        int target=9;
        System.out.println(Arrays.toString(obj.twoSum(nums,target)));
    }
}