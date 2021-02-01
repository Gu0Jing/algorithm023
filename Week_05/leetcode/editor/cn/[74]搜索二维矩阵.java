//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics 数组 二分查找 
// 👍 305 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        //2、转换成一维数组二分
        // 关键在于下标映射 matrix[row][col] = matrix[mid/n][mid%n]
        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int curr = matrix[mid / n][mid % n];
            if (curr == target) {
                return true;
            } else if (curr > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;

        //1、双重二分查找
//        int headM = 0;
//        int tailM = matrix.length-1;
//        while (headM <= tailM) {
//            int midM = headM + (tailM - headM) / 2;
//            int nFirst = matrix[midM][0];
//            int nLast = matrix[midM][matrix[midM].length-1];
//            if (target < nFirst) {
//                tailM = midM - 1;
//            } else if (target > nLast) {
//                headM = midM + 1;
//            } else {
//                int headN = 0;
//                int tailN = matrix[midM].length - 1;
//                while (headN <= tailN) {
//                    int midN = headN + (tailN - headN) / 2;
//                    int curr = matrix[midM][midN];
//                    if (target==curr) {
//                        return true;
//                    } else if (target < curr) {
//                        tailN = midN - 1;
//                    } else {
//                        headN = midN + 1;
//                    }
//                }
//                return false;
//            }
//        }
//        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
