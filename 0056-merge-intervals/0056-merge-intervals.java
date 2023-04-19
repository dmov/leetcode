class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (firstInterval, secondInterval) -> Integer.compare(firstInterval[0], secondInterval[0]));

        final List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            final int[] previousInterval = result.get(result.size() - 1);
            final int[] currentInterval = intervals[i];
            if (previousInterval[1] >= currentInterval[0]) {
                previousInterval[1] = Math.max(previousInterval[1], currentInterval[1]);
            } else {
                result.add(currentInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}