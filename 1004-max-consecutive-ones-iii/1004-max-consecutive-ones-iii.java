class Solution {
    public int longestOnes(int[] nums, int k) {
        int begin = 0;
        int end = 0;

        int max = 0;
        while (end < nums.length) {
            int num = nums[end];
            if (num == 1) {
                end++;
            } else {
                if (k <= 0) {
                    int beginNum = nums[begin];
                    if (beginNum == 0) {
                        k++;
                    }
                    begin++;
                } else {
                    k--;
                    end++;
                }
            }
            max = Math.max(max, end - begin);
        }
        return max;
    }
}