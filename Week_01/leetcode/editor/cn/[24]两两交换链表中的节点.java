//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
// Related Topics 递归 链表 
// 👍 769 👎 0
import Week_01.leetcode.editor.cn.ListNode;

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//迭代：循环结构，例如for，while循环
//递归：选择结构，例如if else 调用自己，并在合适时机退出
class Solution {
    //解法一：递归
    //递归：选择结构，例如if else 调用自己，并在合适时机退出
    //迭代是更新变量的旧值。递归是在函数内部调用自身
    //递归3要素：
    //1、终止条件：递归应该在什么时候结束？
    //2、返回值：返回给上一级递归的是什么
    //3、单次操作：本级递归要做什么，用上返回值
//    public ListNode swapPairs(ListNode head) {
//
//        //1、终止条件:头节点为空或者只有一个节点
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        //2、返回值：返回已经处理好的链表的头节点doneHead
//        ListNode next = head.next;
//        ListNode newHead = next.next;
//        ListNode doneHead = swapPairs(newHead);
//
//        //3、本次递归需要做：交换当前头节点和次节点
//        next.next = head;//次节点指向头节点
//        head.next = doneHead;//头节点指向处理好的链表的头节点
//
//        return next;
//    }

    //解法二：迭代
    //迭代：循环结构，例如for，while循环
    //迭代是更新变量的旧值。递归是在函数内部调用自身
    public ListNode swapPairs(ListNode head) {
        //建立辅助头节点
        ListNode dummyNode = new ListNode(0);
        //指向头节点
        dummyNode.next = head;

        //指定辅助节点作为临时节点，开始迭代
        ListNode tempNode = dummyNode;
        while (tempNode.next != null && tempNode.next.next != null) {
            //定义参与迭代的次节点1、次次节点2
            ListNode node1 = tempNode.next;
            ListNode node2 = tempNode.next.next;
            //从头至尾，依次变更指向
            tempNode.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            //临时节点更新
            tempNode = node1;
        }

        //迭代完毕之后，辅助节点指向的即为结果链表
        return dummyNode.next;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
