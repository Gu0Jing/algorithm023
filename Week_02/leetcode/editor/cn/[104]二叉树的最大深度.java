//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 递归 
// 👍 769 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        //1、递归: 深度 = Max(左子树，右子树)+1
        //最底层 = Max(0，0)+1
//        if (root == null) {
//            return 0;
//        } else {
//            int leftHeight = maxDepth(root.left);
//            int rightHeight = maxDepth(root.right);
//            return Math.max(leftHeight, rightHeight) + 1;
//        }

        //2、广度优先BFS：队列，层序遍历
        Queue<TreeNode> queue = new ArrayDeque<>();
        //根节点入队
        if (root != null) {
            queue.offer(root);
        }
        int deep = 0;
        //循环遍历入队
        while (!queue.isEmpty()) {
            //当前层节点计数
            int size = queue.size();
            //当前层节点循环出队，同时入队子节点，知道当前层节点计数为0
            while (size > 0) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                size--;
            }
            deep++;
        }
        return deep;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
