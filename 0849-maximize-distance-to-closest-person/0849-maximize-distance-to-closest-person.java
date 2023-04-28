class Solution {
    public int maxDistToClosest(int[] seats) {
        int zeroCount = 0;
        int beginZeroCount = -1;
        int midMaxZeroCount = -1;
        int endZeroCount = -1;

        for (int seat : seats) {
            if (seat == 0) {
                zeroCount++;
            } else {
                if (beginZeroCount == -1) {
                    beginZeroCount = zeroCount;
                } else {
                    midMaxZeroCount = Math.max(midMaxZeroCount, zeroCount);
                }
                zeroCount = 0;
            }
        }
        endZeroCount = zeroCount;

        return Math.max(
                Math.max(beginZeroCount, endZeroCount),
                midMaxZeroCount % 2 == 0 ? midMaxZeroCount / 2 : midMaxZeroCount / 2 + 1
        );
    }
}