//给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。 
//
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。 
//例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
// 
//
// 若这两个字符串没有公共子序列，则返回 0。 
//
// 
//
// 示例 1: 
//
// 输入：text1 = "abcde", text2 = "ace" 
//输出：3  
//解释：最长公共子序列是 "ace"，它的长度为 3。
// 
//
// 示例 2: 
//
// 输入：text1 = "abc", text2 = "abc"
//输出：3
//解释：最长公共子序列是 "abc"，它的长度为 3。
// 
//
// 示例 3: 
//
// 输入：text1 = "abc", text2 = "def"
//输出：0
//解释：两个字符串没有公共子序列，返回 0。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= text1.length <= 1000 
// 1 <= text2.length <= 1000 
// 输入的字符串只含有小写英文字符。 
// 
// Related Topics 动态规划 
// 👍 373 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private String t1;
    private String t2;
    private int[][] temp;

    public int longestCommonSubsequence(String text1, String text2) {
        t1 = text1;
        t2 = text2;
        int m = t1.length();
        int n = t2.length();
        temp = new int[m][n];

        return recursion(m - 1, n - 1);
    }

    private int recursion(int m, int n) {
        if (m == -1 || n == -1) {
            return 0;
        }
        if (temp[m][n] != 0) {
            return temp[m][n];
        }
        int res;
        if (t1.charAt(m) == t2.charAt(n)) {
            res = recursion(m - 1, n - 1) + 1;
        } else {
            res = Math.max(recursion(m - 1, n), recursion(m, n - 1));
        }
        temp[m][n] = res;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
