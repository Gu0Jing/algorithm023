import java.util.*;

/**
 * 类作用:
 * 项目名称:  whale
 * 包:      PACKAGE_NAME
 * 类名称:   Debug
 * 类描述:   类功能详细描述
 * 创建人:    GuoJing
 * 创建时间:  2021/1/4/0004 9:20
 */
public class Debug02 {
    private List<Integer> res = new ArrayList<>();


    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = new int[nums.length - k + 1];
        //1、大根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (a, b) -> b - a);
        //填满窗口
        for (int i = 0; i < k; i++) {
            heap.offer(nums[i]);
        }
        int maxIndex = 0;
        for (int i = k; i < nums.length; i++) {
            res[maxIndex++] = heap.poll();
            heap.offer(nums[i]);
        }
    }

}
