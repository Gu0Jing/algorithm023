package Week_03;

/**
 * 一些注意事项：
 * 1、不要【人肉进行递归】，直接看函数本身开始写
 * 2、找到最近最简方法，拆解成【重复子问题】
 * 3、运用【数学归纳法】思维，n=1，n=2，找 n 成立时，n+1 也成立的规律
 */
public class 递归模板 {
    private int MAX_LEVEL = 0;

    public void recur(int level, int param) {
        // 1-终止条件
        if (level > MAX_LEVEL) {
            return;
        }
        // 2-处理当前层逻辑
        process(level, param);

        // 3-下探到下一层
        recur(level+1, newParam(param));

        // 4-清理当前层

    }

    private int newParam(int param) {
        return 0;
    }

    private void process(int level, int param) {
    }
}
