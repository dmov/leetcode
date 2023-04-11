class Solution {
    public int singleNonDuplicate(int[] nums) {
        int startIndex = 0;
        int endIndex = nums.length - 1;

        while (startIndex <= endIndex) {
            final int midIndex = (startIndex + endIndex) / 2;
            final int midElem = nums[midIndex];

            final int prevIndex = midIndex - 1;
            final int nextIndex = midIndex + 1;

            int pairIndex = -1;

            if (prevIndex >= 0) {
                int prevElem = nums[prevIndex];
                if (midElem == prevElem) {
                    pairIndex = prevIndex;
                }
            }
            if (pairIndex == -1 && nextIndex <= nums.length - 1) {
                int nexElem = nums[nextIndex];
                if (midElem == nexElem) {
                    pairIndex = nextIndex;
                }
            }

            if (pairIndex == -1) {
                return midElem;
            }

            final int leftArraySize = pairIndex < midIndex ? pairIndex - startIndex : midIndex - startIndex;
            final boolean isLeftArraySizeEven = leftArraySize % 2 == 0;

            if (!isLeftArraySizeEven) {
                endIndex = Math.min(pairIndex, midIndex) - 1;
            } else {
                startIndex = Math.max(pairIndex, midIndex) + 1;
            }
        }

        return -1;
    }
}