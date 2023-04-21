class Solution {
    public List<Integer> partitionLabels(String s) {
        final Map<Character, Integer> charToMaxIndexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            charToMaxIndexMap.put(s.charAt(i), i);
        }

        final List<Integer> result = new ArrayList<>();

        int currentPartitionIndex = 0;
        int previousPartitionIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            currentPartitionIndex = Math.max(currentPartitionIndex, charToMaxIndexMap.get(s.charAt(i)));
            if (i == currentPartitionIndex) { // if we are in a last possible index for this char
                result.add(currentPartitionIndex - previousPartitionIndex);
                previousPartitionIndex = currentPartitionIndex;
            }
        }
        return result;
    }
}