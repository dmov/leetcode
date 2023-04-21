class Solution {
    public int maxArea(int[] height) {
        int beginIndex = 0;
        int endIndex = height.length - 1;

        int maxArea = 0;

        while (beginIndex <= endIndex) {
            final int containerHeight = Math.min(height[beginIndex], height[endIndex]);
            final int containerLength = endIndex - beginIndex;
            maxArea = Math.max(maxArea, containerHeight * containerLength);

            if (height[beginIndex] <= height[endIndex]) {
                beginIndex++;
            } else {
                endIndex--;
            }
        }
        return maxArea;
    }
}