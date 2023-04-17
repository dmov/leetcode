class Solution {
    public int search(int[] nums, int target) {
        int startIndex = 0;
        int endIndex = nums.length - 1;

        while (startIndex <= endIndex) {
            int midIndex = (startIndex + endIndex) / 2;
            int midElement = nums[midIndex];

            if (midElement == target) {
                return midIndex;
            }

            if (nums[startIndex] <= midElement) { // if left part is sorted
                if (target >= nums[startIndex] && target <= midElement) { // if inside sorted part then let's look in it
                    endIndex = midIndex - 1;
                } else { // let's look in other part
                    startIndex = midIndex + 1;
                }
            } else { // if right part is sorted
                if (target <= nums[endIndex] && target >= midElement) { // if inside sorted part then let's look in it
                    startIndex = midIndex + 1;
                } else {  // let's look in other part
                    endIndex = midIndex - 1;
                }
            }
        }
        return -1;
    }
}