// 49. Group Anagrams
// Given an array of strings strs, group the anagrams together. You can return the answer in any order.

// Example 1:
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
// Explanation:
// There is no string in strs that can be rearranged to form "bat".
// The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
// The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
  
// Example 2:
// Input: strs = [""]
// Output: [[""]]
// Example 3:
// Input: strs = ["a"]
// Output: [["a"]]

import java.util.*;

public class Main {

    // Function to group anagrams
    public static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String word : strs) {

            // Convert string to char array
            char[] chars = word.toCharArray();

            // Sort characters
            Arrays.sort(chars);

            // Create key
            String key = new String(chars);

            // If key not present
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // Add word to list
            map.get(key).add(word);
        }

        // Return grouped anagrams
        return new ArrayList<>(map.values());
    }

    // Main function
    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> result = groupAnagrams(strs);

        // Print result
        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}
