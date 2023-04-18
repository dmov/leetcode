class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        final List<Integer> result = new ArrayList<>();

        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            if (isAnagram(s.substring(i, i + p.length()), p)) {
                result.add(i);
            }
        }
        return result;
    }

    public boolean isAnagram(String s, String t) {
        final int[] sCount = new int[26];
        final int[] tCount = new int[26];
        
        for (char character : s.toCharArray()) {
            sCount[character - 'a']++;
        }

        for (char character : t.toCharArray()) {
            tCount[character - 'a']++;
        }

        return Arrays.equals(sCount, tCount);
    }
}