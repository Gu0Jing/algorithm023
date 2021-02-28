//给你两个数组，arr1 和 arr2， 
//
// 
// arr2 中的元素各不相同 
// arr2 中的每个元素都出现在 arr1 中 
// 
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末
//尾。 
//
// 
//
// 示例： 
//
// 
//输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr1.length, arr2.length <= 1000 
// 0 <= arr1[i], arr2[i] <= 1000 
// arr2 中的元素 arr2[i] 各不相同 
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中 
// 
// Related Topics 排序 数组 
// 👍 159 👎 0


import java.util.*;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //1、自定义比较器排序
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < arr2.length; i++) {
//            map.put(arr2[i], i);
//        }
//        List<Integer> res = Arrays.stream(arr1).boxed().collect(Collectors.toList());
//        res.sort((n1, n2) -> {
//            if (map.containsKey(n1) || map.containsKey(n2)) {
//                return map.getOrDefault(n1, 1000) - map.getOrDefault(n2, 1000);
//            } else {
//                return n1 - n2;
//            }
//        });
//        return res.stream().mapToInt(i -> i).toArray();

        //2、计数排序
        int[] frequency = new int[1001];
        //统计频次,当前数作下标
        for (int num1 : arr1) {
            frequency[num1]++;
        }
        //先排序arr2中的数
        int[] res = new int[arr1.length];
        int index = 0;
        for (int num2 : arr2) {
            while (frequency[num2]-- > 0) {
                res[index++] = num2;
            }
        }
        //再排序arr1剩下的数
        for (int i = 0; i < frequency.length; i++) {
            while (frequency[i]-- > 0) {
                res[index++] = i;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
