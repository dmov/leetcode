class Solution {
    public int[] twoSum(int[] nums, int target) {
        final Map<Integer, Integer> numberToIndexMap = new HashMap<>();
        numberToIndexMap.put(nums[0], 0);

        for (int i = 1; i < nums.length; i++) {
            final int secondOperand =  target - nums[i];
            if (numberToIndexMap.containsKey(secondOperand)) {
                return new int[] {numberToIndexMap.get(secondOperand), i};
            } else {
                numberToIndexMap.put(nums[i], i);
            }
        }
        return null;
    }
}