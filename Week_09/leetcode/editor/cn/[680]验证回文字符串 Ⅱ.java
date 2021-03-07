//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。 
//
// 示例 1: 
//
// 
//输入: "aba"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "abca"
//输出: True
//解释: 你可以删除c字符。
// 
//
// 注意: 
//
// 
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。 
// 
// Related Topics 字符串 
// 👍 324 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        int count = 0;
        return recursion(count, l, r, s);
    }

    private boolean recursion(int count, int l, int r, String s) {
        if (count > 1) {
            return false;
        }
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;r--;
            } else {
                count++;
                return recursion(count, l + 1, r, s) || recursion(count, l, r - 1, s);
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
