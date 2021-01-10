//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法 
// 👍 175 👎 0


import java.util.Arrays;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        //1、直接排序
//        Arrays.sort(arr);
//        return Arrays.copyOfRange(arr, 0, k);

        //2、堆
        int[] res = new int[k];
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> a-b);
        for (int i : arr) {
            heap.offer(i);
        }
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
