// 242. Valid Anagram
// Given two strings s and t, return true if t is an anagram of s, and false otherwise.

// Example 1:
// Input: s = "anagram", t = "nagaram"
// Output: true

// Example 2:
// Input: s = "rat", t = "car"
// Output: false

//Code

class Solution {
    public boolean isAnagram(String s, String t) {

        // Length different => not anagram
        if (s.length() != t.length()) {
            return false;
        }

        // Array for character count
        int[] count = new int[26];

        // Count characters
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        // Check all counts become 0
        for (int num : count) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }
}
