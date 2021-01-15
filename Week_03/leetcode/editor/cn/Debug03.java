package Week_03.leetcode.editor.cn;

import Week_02.leetcode.editor.cn.TreeNode;

import java.util.HashMap;

public class Debug03 {

    private static int[] res = new int[9];
    private static int index = 0;

    public static void main(String[] args) {
        //模拟 剑指Offer 68
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node5 = new TreeNode(5);
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node6 = new TreeNode(6);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node0 = new TreeNode(0);
//        TreeNode node8 = new TreeNode(8);
//        TreeNode node7 = new TreeNode(7);
//        TreeNode node4 = new TreeNode(4);
//        node3.left = node5;
//        node3.right = node1;
//        node5.left = node6;
//        node5.right = node2;
//        node2.left = node7;
//        node2.right = node4;
//        node1.left = node0;
//        node1.right = node8;
//
//        TreeNode resNode = lowestCommonAncestor(node3, node5, node4);
//        System.out.println(resNode.val);
        int n = 10;
        int[] res = new int[n + 2];
        res[1] = 1;
        res[2] = 2;
        for (int i = 3; i <= n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }

    }

    //前序遍历
    public static void preOrder(TreeNode root){
        if (root != null) {
            res[index++] = root.val;
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    //给定一个二叉树, 找到该树中两个指定节点的最近公共祖先
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //终止条件
        if (root == null || root == p || root == q) {
            return root;
        }
        //递归遍历左子树，找到 p or q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //递归遍历右子树，找到 p or q
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {//p、q不在当前节点的左子树，右子树第一个被找到的节点本身即为所求
            return right;
        } else if (right == null) {//p、q不在当前节点的右子树，左子树第一个被找到的节点本身即为所求
            return left;
        } else {//p、q在当前节点的异侧,当前节点即为所求
            return root;
        }
    }

}
