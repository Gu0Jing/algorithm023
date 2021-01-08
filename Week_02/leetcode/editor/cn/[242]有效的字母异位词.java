//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 326 👎 0


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        //1、哈希表：查询O(1)
//        HashMap<Character, Integer> map = new HashMap<>();
//        for (Character c : s.toCharArray()) {
//            Integer count = map.getOrDefault(c, 0);
//            map.put(c, count + 1);
//        }
//        for (Character c : t.toCharArray()) {
//            if (map.containsKey(c)) {
//                Integer count = map.get(c);
//                if (count <= 0) {
//                    return false;
//                } else {
//                    map.put(c, --count);
//                }
//            } else {
//                return false;
//            }
//        }
//        return true;

        //2、排序后直接比较
//        char[] chars = s.toCharArray();
//        char[] chars1 = t.toCharArray();
//        Arrays.sort(chars);
//        Arrays.sort(chars1);
//        return Arrays.equals(chars, chars1);

        //3、数组
//        if (s.length() != t.length()) {
//            return false;
//        }
//        int[] table = new int[26];
//        for (int i = 0; i < s.length(); i++) {
//            table[s.charAt(i) - 'a']++;
//        }
//        for (int i = 0; i < t.length(); i++) {
//            table[t.charAt(i) - 'a']--;
//            if (table[t.charAt(i) - 'a'] < 0) {
//                return false;
//            }
//        }
//        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
