package Week_07.leetcode.editor.cn;//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 输入："abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 输入："aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 输入的字符串长度不会超过 1000 。 
// 
// Related Topics 字符串 动态规划 
// 👍 480 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //参考解题：https://leetcode-cn.com/problems/palindromic-substrings/solution/liang-dao-hui-wen-zi-chuan-de-jie-fa-xiang-jie-zho/
    public int countSubstrings(String s) {

        //1、动态规划
        //dp[i][j]表示字符区间[i,j]的子串是不是回文串
        //dp[i][j]是回文串 == dp[i+1][j-1]是回文串
//        boolean[][] dp = new boolean[s.length()][s.length()];
//        int count = 0;
//        //注意i是左边界，j是右边界；
//        for (int j = 0; j < s.length(); j++) {//固定右边界
//            for (int i = 0; i <= j; i++) {//遍历左边界
//                if (s.charAt(i) == s.charAt(j)//左右边界相等 且
//                        && (j - i < 2 || dp[i + 1][j - 1])) {//左右边界相邻or去掉左右边界后还是回文串
//                    dp[i][j]=true;
//                    count++;
//                }
//            }
//        }
//        return count;

        //2、中心扩散法: 左右指针由中心向两边扩散比较
        //回文中心的奇偶性：可以是1个字符(总数len) 或者 2个字符(总数len-1)
        int count = 0;
        int left, right;
        for (int center = 0; center < s.length(); center++) {
            //回文中心是1个字符
            left = center;
            right = center;
            while (left >= 0 && right < s.length()
                    && s.charAt(left) == s.charAt(right)) {
                left--;right++;
                count++;
            }
            //回文中心是2个字符
            left = center;
            right = center + 1;
            while (left >= 0 && right < s.length()
                    && s.charAt(left) == s.charAt(right)) {
                left--;right++;
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
