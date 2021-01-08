//给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。 
//
// 示例: 
//
// 输入: 38
//输出: 2 
//解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
// 
//
// 进阶: 
//你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？ 
// Related Topics 数学 
// 👍 306 👎 0


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int addDigits(int num) {
        //1、递归
        //终止条件
//        if (num < 10) {
//            return num;
//        }
//        //分解成个位数的同时相加
//        int sum = 0;
//        while (num > 0) {
//            int remainder = num % 10;
//            sum += remainder;
//            num /= 10;
//        }
//        return addDigits(sum);

        //2、求数根公式
        return (num - 1) % 9 + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
