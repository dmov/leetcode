class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        final Map<String, Integer> wordToFrequencyMap = new HashMap<>();
        for (String word : words) {
            wordToFrequencyMap.put(word, wordToFrequencyMap.getOrDefault(word, 0) + 1);
        }

        final PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((firstEntry, secondEntry) -> {
            final int compareFrequency = secondEntry.getValue().compareTo(firstEntry.getValue());
            if (compareFrequency == 0) {
                // if the frequency is the same, then let's compare words lexicographically
                return firstEntry.getKey().compareTo(secondEntry.getKey());
            }
            return compareFrequency;
        });
        queue.addAll(wordToFrequencyMap.entrySet());

        final List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(Objects.requireNonNull(queue.poll()).getKey());
        }
        return result;
    }
}