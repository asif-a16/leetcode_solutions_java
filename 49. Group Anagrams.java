import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagrams = new HashMap<>();
        
        for (String word:strs) {
            char[] anagramKeyChars = word.toCharArray();
            Arrays.sort(anagramKeyChars);
            String anagramKey = new String(anagramKeyChars);

            if (anagrams.containsKey(anagramKey)) {
                List<String> group = anagrams.get(anagramKey);
                group.add(word);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(word);
                anagrams.put(anagramKey, newList);
            }
        }

        List<List<String>> result = new ArrayList<>();
        anagrams.forEach((_, value) -> {
            result.add(value);
        });

        return result;
    }
}