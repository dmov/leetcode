class Solution {
    public static List<List<String>> groupAnagrams(String[] strs) {
        final Map<String, List<String>> keyToAnagrams = new HashMap<>();
        for (String str : strs) {
            final PriorityQueue<Character> strKey = new PriorityQueue<>();
            for (Character character : str.toCharArray()) {
                strKey.add(character);
            }

            final char[] sortedKey = new char[strKey.size()];
            int i = 0;
            while (strKey.size() > 0) {
                sortedKey[i] = strKey.poll();
                i++;
            }
            final List<String> anagrams = keyToAnagrams.computeIfAbsent(new String(sortedKey), k -> new ArrayList<>());
            anagrams.add(str);
        }

        return new ArrayList<>(keyToAnagrams.values());
    }
}