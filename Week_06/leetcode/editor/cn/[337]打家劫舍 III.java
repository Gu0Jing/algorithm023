//在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“
//房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。 
//
// 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。 
//
// 示例 1: 
//
// 输入: [3,2,3,null,3,null,1]
//
//     3
//    / \
//   2   3
//    \   \ 
//     3   1
//
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7. 
//
// 示例 2: 
//
// 输入: [3,4,5,1,3,null,1]
//
//     3
//    / \
//   4   5
//  / \   \ 
// 1   3   1
//
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
// 
// Related Topics 树 深度优先搜索 
// 👍 713 👎 0
import Week_02.leetcode.editor.cn.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private HashMap<TreeNode, Integer> map = new HashMap<>();
    private int count = 0;
    public int rob(TreeNode root) {
        //1、递归
        //设当前节点为currNode
        //情况1：偷 currNode + currNode的左孩子的子树+右孩子的子树
        //情况2：偷 currNode的左孩子 + currNode的右孩子
//        if (root==null) {
//            return 0;
//        }
//        //情况1：
//        int money1 = root.val;
//        if (root.left != null) {
//            money1 += rob(root.left.left) + rob(root.left.right);
//        }
//        if (root.right != null) {
//            money1 += rob(root.right.left) + rob(root.right.right);
//        }
//        //情况2
//        int money2 = rob(root.left) + rob(root.right);
//        return Math.max(money1,money2);

        //2.1 递归 + map保存中间结果
//        if (root==null) {
//            return 0;
//        }
//        if (map.containsKey(root)) {
//            return map.get(root);
//        }
//        //情况1：
//        int money1 = root.val;
//        if (root.left != null) {
//            money1 += rob(root.left.left) +rob(root.left.right);
//        }
//        if (root.right != null) {
//            money1 += rob(root.right.left)+ rob(root.right.right);
//        }
//        //情况2
//        int money2 = rob(root.left) + rob(root.right);
//
//        int max = Math.max(money1,money2);
//        map.put(root, max);
//        return max;

        //2.2 递归 + 数组保存多种情况结果
        return Math.max(dfs(root)[0], dfs(root)[1]);
    }

    private int[] dfs(TreeNode node) {
        //res[0]:不偷当前节点时的最大金额
        //res[1]:偷当前节点时的最大金额
        int[] res = new int[2];
        if (node == null) {
             return res;
        }

        int[] left = dfs(node.left);//偷左儿子的结果
        int[] right = dfs(node.right);//偷右儿子的结果

        //不抢当前节点，那么儿子节点偷和不偷都可以，取[0]/[1]最大值
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //抢当前节点，那么儿子节点不能抢，只能取[0]
        res[1] = node.val + left[0] + right[0];

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
