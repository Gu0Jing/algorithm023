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
// 👍 771 👎 0
import Week_02.leetcode.editor.cn.TreeNode;

import javax.swing.*;
import java.util.ArrayDeque;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)


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
        //1、DFS
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        //当前节点深度=左右子树的最大深度+当前节点本身(1)
        return Math.max(leftDepth, rightDepth) + 1;

        //2、BFS：队列
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        int deep = 0;
//        //根节点入队
//        if (root != null) {
//            queue.offer(root);
//        }
//        //循环遍历子节点入队
//        while (!queue.isEmpty()) {
//            //当前层的节点计数
//            int size = queue.size();
//            //当前层节点依次出队的同时入队它的子节点
//            //size=0时，当前层出队完毕，下一层入队完毕
//            while (size > 0) {
//                TreeNode currRoot = queue.poll();
//                size--;
//                if (currRoot.left != null) {
//                    queue.offer(currRoot.left);
//                }
//                if (currRoot.right != null) {
//                    queue.offer(currRoot.right);
//                }
//            }
//            deep++;
//        }
//        return deep;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
