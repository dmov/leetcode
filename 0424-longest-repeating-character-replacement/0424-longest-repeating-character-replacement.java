class Solution {
    public int characterReplacement(String s, int k) {
        final Map<Character, Integer> slidingWindowCharToCountMap = new HashMap<>();

        int maxSlidingWindowSize = 0;
        int maxRepeatingCount = 0;

        int windowBeginIndex = 0;
        for (int windowEndIndex = 0; windowEndIndex < s.length(); windowEndIndex++) {
            final char currentChar = s.charAt(windowEndIndex);
            slidingWindowCharToCountMap.put(
                    currentChar,
                    slidingWindowCharToCountMap.getOrDefault(currentChar, 0) + 1
            );

            maxRepeatingCount = Math.max(maxRepeatingCount, slidingWindowCharToCountMap.get(currentChar));

            final int numberOfOtherSymbolsToReplace = windowEndIndex - windowBeginIndex + 1 - maxRepeatingCount;
            if (numberOfOtherSymbolsToReplace > k) {
                final char windowBeginChar = s.charAt(windowBeginIndex);
                slidingWindowCharToCountMap.put(
                        windowBeginChar,
                        slidingWindowCharToCountMap.get(windowBeginChar) - 1
                );
                windowBeginIndex++;
            }
            maxSlidingWindowSize = Math.max(maxSlidingWindowSize, windowEndIndex - windowBeginIndex + 1);
        }
        return maxSlidingWindowSize;
    }
}