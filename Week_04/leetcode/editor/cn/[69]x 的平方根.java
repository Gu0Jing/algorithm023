//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 576 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        //1、二分查找
//        int left = 1;
//        int right = x;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            int tmp = x / mid;
//            if (tmp == mid) {
//                if (x % mid == 0) {
//                    return mid;
//                }
//                left = mid + 1;
//            }
//            if (tmp < mid) {
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return right;

        //2、牛顿迭代法
        if (x == 1 || x == 2) {
            return 1;
        }
        long r = x/2;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
