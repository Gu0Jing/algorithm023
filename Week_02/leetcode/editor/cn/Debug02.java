import java.util.HashMap;

/**
 * 类作用:
 * 项目名称:  whale
 * 包:      PACKAGE_NAME
 * 类名称:   Debug
 * 类描述:   类功能详细描述
 * 创建人:    GuoJing
 * 创建时间:  2021/1/4/0004 9:20
 */
public class Debug02 implements Comparable {

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public static void main(String[] args) {
        int n=3;
        int[] res = new int[n + 1];
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            res[n] = res[n - 1] + res[n - 2];
        }
    }

}
