class Solution {
    public static int findMin(int[] nums) {
        int beginIndex = 0;
        int endIndex = nums.length - 1;

        int min = 5000;

        while (beginIndex <= endIndex) {
            int midIndex = (beginIndex + endIndex) / 2;
            int midElement = nums[midIndex];

            if (nums[beginIndex] <= midElement) { // if left part is sorted
                if (nums[beginIndex] < min) { // we are interested only in minimum element from this part
                    min = nums[beginIndex];
                }
                beginIndex = midIndex + 1; // then go check other part
            } else { // if right part is sorted
                if (midElement < min) { // we are interested only in minimum element from this part
                    min = midElement;
                }
                endIndex = midIndex - 1; // then go check other part
            }
        }
        return min;
    }
}