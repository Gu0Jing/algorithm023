//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 890 👎 0
import Week_02.leetcode.editor.cn.TreeNode;

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
//完整解题思路：
//官方题解
//or
//https://leetcode-cn.com/problems/validate-binary-search-tree/solution/san-chong-jie-jue-fang-shi-liang-chong-ji-bai-liao/
class Solution {

    private TreeNode preNode;

    public boolean isValidBST(TreeNode root) {
        //1、中序递归：对于二叉搜索树，中序遍历一定是有序递增的

//        if (root == null) {return true;}
//        //遍历左子树
//        if (!isValidBST(root.left)) {return false;}
//
//        //不考虑相同节点的情况下，判断当前节点和前节点大小
//        if (preNode != null && preNode.val >= root.val) {return false;}
//        //前节点更新
//        preNode = root;
//
//        //遍历右子树
//        if (!isValidBST(root.right)) {return false;}
//        return true;

        //2、递归：比较节点的上下界
        return isValidBST(root,null,null);

    }

    private boolean isValidBST(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {return true;}
        if (upper != null && root.val >= upper
                || lower != null && root.val <= lower) {
            return false;
        }
        //遍历左子树，当前节点值作为上界
        if (!isValidBST(root.left, lower, root.val)) {
            return false;
        }
        //遍历右子树，当前节点值作为下界
        if (!isValidBST(root.right, root.val, upper)) {
            return false;
        }
        return true;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
