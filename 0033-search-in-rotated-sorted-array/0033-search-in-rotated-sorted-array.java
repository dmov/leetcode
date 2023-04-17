class Solution {
    public int search(int[] nums, int target) {
        int startIndex = 0;
        int endIndex = nums.length - 1;

        while (startIndex <= endIndex) {
            int midIndex = (startIndex + endIndex) / 2;
            int midElement = nums[midIndex];
            
            if (midElement == target) {
                return midIndex;
            } else if (target > midElement) {
                if (target <= nums[endIndex]) {
                    startIndex = midIndex + 1;
                } else {
                    endIndex = endIndex - 1;
                }
            } else {
                if (target >= nums[startIndex]) {
                    endIndex = midIndex - 1;
                } else {
                    startIndex = startIndex + 1;
                }
            }
        }
        return -1;
    }
}