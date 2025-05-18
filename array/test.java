import java.util.Arrays;
class test {
    public int longestConsecutive(int[] nums) {

        for (int i=0;i<nums.length-1;i++)
        {
            int min=i;
            for(int j=i+1;j<nums.length;j++)
            { 
                if (nums[j]<nums[min])
                min=j;
            }
            int t=nums[i];
            nums[i]=nums[min];
            nums[min]=t;
        }
        System.out.println(Arrays.toString(nums));
        int c=0;
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i+1]-nums[i]==1)
            c++;
            System.out.println(nums[i+1]+"-"+nums[i]+"="+c);
            
        }
        return c+1;    
    }
    public static void main(String[] args) {
        int arr[]={9,1,4,7,3,-1,0,5,8,-1,6};
        test obj=new test();

        System.out.println(obj.longestConsecutive(arr));
    }
}