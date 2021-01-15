//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1514 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<String> resList = new ArrayList<>();

    //递归形式类似二叉树深度优先遍历，遍历的同时判断(剪枝)
    public List<String> generateParenthesis(int n) {
        //递归枚举出所有情况，通过条件过滤出有效的括号
        //递归时过滤条件：左括号数量==n、右括号数量<=左括号数量
        recursion(0, 0, n,"");
        return resList;
    }

    private void recursion(int leftCount, int rightCount, int n,String s) {
        //终止条件
        if (leftCount == n && rightCount == n) {
            resList.add(s);
            return;
        }

        //下探:每个格子都有两者可能
        if (leftCount < n) {
            recursion(leftCount + 1, rightCount, n, s + "(");
        }
        if (rightCount < leftCount) {
            recursion(leftCount, rightCount + 1, n, s + ")");
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
