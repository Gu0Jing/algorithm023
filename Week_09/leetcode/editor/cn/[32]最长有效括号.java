//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 104 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 字符串 动态规划 
// 👍 1197 👎 0


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        //1、动态规划
        //dp[i]:以下标为i的字符结尾的最长有效括号的长度
        //当s[i]=='(',dp[i]=0；
        //当s[i]==')'时：
        //  当s[i-1]=='(',dp[i] = 2 + dp[i-2]
        //      解释：当... ()时，当前最长=自身一对+前面的最长
        //  当s[i-1]==')',dp[i] = 2 + dp[i - 1] + dp[ i-dp[i-1]-1 - 1]
        //      解释：当... ( (...) )时，当前最长=自身一对+自身中间包裹的长度+前面的最长
        int maxL = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i)==')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = 2 + (i >= 2 ? dp[i - 2] : 0);
                } else {//s.charAt(i - 1) == ')'
                    int oppSideIndex = i - dp[i - 1] - 1;//当前括号的对边下标
                    if (oppSideIndex >= 0 && s.charAt(oppSideIndex) == '(') {
                        dp[i] = 2 + dp[i - 1] + (oppSideIndex > 0 ? dp[oppSideIndex - 1] : 0);
                    }
                }
                maxL = Math.max(maxL, dp[i]);
            }
        }
        return maxL;

        //2、栈：利用下标计算长度
//        Deque<Integer> stack = new ArrayDeque<>();
//        stack.offer(-1);//辅助下标计算长度
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(') {//遇左括号，当前下标入栈
//                stack.offer(i);
//            } else {//s.charAt(i) == ')'遇右括号，当前栈顶出栈
//                stack.pollLast();
//                if (stack.isEmpty()) {//栈空了，代表当前是不成对的')'，入栈
//                    stack.offer(i);
//                } else {//栈不为空，是成对的')'，比较长度
//                    maxL = Math.max(maxL, i - stack.peekLast());
//                }
//            }
//        }
//        return maxL;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
