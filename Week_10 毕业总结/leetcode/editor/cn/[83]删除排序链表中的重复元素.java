//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表 
// 👍 485 👎 0
import Week_01.leetcode.editor.cn.ListNode;
import com.sun.org.apache.xpath.internal.objects.XNull;

import java.util.HashSet;
import java.util.Set;

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
class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        //1、哈希表，无所谓有序
//        ListNode pre = new ListNode(-1);
//        pre.next = head;
//        Set<Integer> set = new HashSet<>();
//        while (pre.next != null) {
//            if (set.contains(pre.next.val)) {
//                pre.next = pre.next.next;
//            } else {
//                set.add(pre.next.val);
//                pre = pre.next;
//            }
//        }
//        return head;

        //2、有序链表(重复的都挨在一块)：快慢指针
        if (head == null) {
            return null;
        }
        ListNode fast = head,slow =head;
        while (fast != null) {
            if (fast.val != slow.val) {//跨越中间的重复元素
                slow.next = fast;
                slow = fast;
            }
            fast = fast.next;
        }
        slow.next = null;//断开与后面重复元素的连接
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
