package Week_04.leetcode.editor.cn;

import Week_02.leetcode.editor.cn.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 深度/广度遍历树，按层输出节点
 * [3]
 * [5, 1]
 * [6, 2, 0, 8]
 * [7, 4]
 */
public class BFS_DFS_SAMPLE {

    public static void main(String[] args) {
        //模拟 剑指Offer 68
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        node3.left = node5; node3.right = node1;
        node5.left = node6; node5.right = node2;
        node2.left = node7; node2.right = node4;
        node1.left = node0; node1.right = node8;

        System.out.println("BFS:");
        List<List<Integer>> lists_bfs = levelOrder_bfs(node3);
        lists_bfs.forEach(list-> System.out.println(list.toString()));

        System.out.println("DFS:");
        List<List<Integer>> lists_dfs = levelOrder_bfs(node3);
        lists_dfs.forEach(list-> System.out.println(list.toString()));
    }

    public static List<List<Integer>> levelOrder_bfs(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();
        if (root == null) {
            return allResults;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            List<Integer> results = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                results.add(node.val);
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
            allResults.add(results);
        }
        return allResults;
    }

    public static List<List<Integer>> levelOrder_dfs(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();
        if(root==null){
            return allResults;
        }
        travel(root,0,allResults);
        return allResults;
    }


    private static void travel(TreeNode root,int level,List<List<Integer>> results){
        if(results.size()==level){
            results.add(new ArrayList<>());
        }
        results.get(level).add(root.val);
        if(root.left!=null){
            travel(root.left,level+1,results);
        }
        if(root.right!=null){
            travel(root.right,level+1,results);
        }
    }



}
