class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;

        int sum = 0;
        final Map<Integer, Integer> sumToCountMap = new HashMap<>();
        sumToCountMap.put(sum, 1);

        for (int num : nums) {
            sum += num;

            final int previousSum = sum - k;
            if (sumToCountMap.containsKey(previousSum)) {
                result += sumToCountMap.get(previousSum);
            }
            sumToCountMap.put(sum, sumToCountMap.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}