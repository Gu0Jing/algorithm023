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
// 👍 351 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private String t1;
    private String t2;

    public int longestCommonSubsequence(String text1, String text2) {
        t1 = text1;
        t2 = text2;
        int m = t1.length();
        int n = t2.length();

        //递归
//        return recursion(m-1, n-1);

        //动态规划
        //定义状态空间:dp[i][j]存储t1前i个字符和t2前j个字符的最长公共子序列长度
        int[][] dp = new int[m + 1][n + 1];//+1表示包含空字串
        //定义状态转移方程
        //当t1[i]==t2[j], dp[i][j]=dp[i-1][j-1]+1
        //当t1[i]!=t2[j], dp[i][j]=Max(dp[i-1][j],dp[i][j-1])
        //定义初始状态
        //dp[0][j]=dp[i][0]=0
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;//二维数组初始化元素即为0，可省略此步，i、j从1开始
                } else
                    if (t1.charAt(i-1) == t2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    private int recursion(int m, int n) {
        if (m == -1 || n == -1) {
            return 0;
        }
        if (t1.charAt(m) == t2.charAt(n)) {
            return recursion(m - 1, n - 1) + 1;
        } else {
            return Math.max(recursion(m - 1, n), recursion(m, n - 1));
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
