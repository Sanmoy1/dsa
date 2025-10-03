
// O(logn) time complexity
// O(1) space complexity
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If the mid element is greater than the rightmost element,
            // the pivot (minimum) must be in the right half.
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Otherwise, the pivot is in the left half (including mid),
                // as this half is not sorted in ascending order.
                right = mid;
            }
        }

        // When the loop ends, left and right converge on the minimum element.
        return nums[left];
    }
}