/*
 * @lc app=leetcode.cn id=383 lang=java
 *
 * [383] Ransom Note
 *
 * https://leetcode.cn/problems/ransom-note/description/
 *
 * algorithms
 * Easy (61.56%)
 * Likes:    804
 * Dislikes: 0
 * Total Accepted:    386.9K
 * Total Submissions: 628.4K
 * Testcase Example:  '"a"\n"b"'
 *
 * Given two strings ransomNote and magazine, return true if ransomNote can be
 * constructed by using the letters from magazine and false otherwise.
 * 
 * Each letter in magazine can only be used once in ransomNote.
 * 
 * 
 * Example 1:
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= ransomNote.length, magazine.length <= 10^5
 * ransomNote and magazine consist of lowercase English letters.
 * 
 * 
 */

// @lc code=start

//如果ransomNote的字符数>magezine中的字符数，直接返回false
// 不需要考虑大写字母
// 将magezine字符保存到hash表中，在循环ransomNote中的字符是否存在。不存在 false ，存在就remove,继续循环。
//构建一个可以映射到26个字母数组的hash函数，
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] alphabet = new int[26];
        char[] ransomNoteChars = ransomNote.toCharArray();
        char[] magezineChars = magazine.toCharArray();
        for (char mChar : magezineChars) {
            alphabet[mChar - 'a']++;
        }
        for (char rChar : ransomNoteChars) {
            alphabet[rChar - 'a']--;
            if (alphabet[rChar - 'a'] < 0) {
                return false;
            }

        }
        return true;
    }
}
// @lc code=end
