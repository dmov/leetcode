class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int num = nums[mid];
            if (num < target) {
                start = mid + 1;
            } else if (num > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return start;     
    }
}