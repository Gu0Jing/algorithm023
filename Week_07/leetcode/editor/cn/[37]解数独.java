//编写一个程序，通过填充空格来解决数独问题。 
//
// 一个数独的解法需遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 空白格用 '.' 表示。 
//
// 
//
// 一个数独。 
//
// 
//
// 答案被标成红色。 
//
// 提示： 
//
// 
// 给定的数独序列只包含数字 1-9 和字符 '.' 。 
// 你可以假设给定的数独只有唯一解。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 回溯算法 
// 👍 756 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] rowUsed = new boolean[9][9];
        boolean[][] colUsed = new boolean[9][9];
        boolean[][][] boxUsed = new boolean[3][3][9];

        //初始化
        for (int i = 0; i < 81; i++) {
            int m = i / 9, n = i % 9;
            if (board[m][n]!='.') {
                int num = board[m][n] - '1';
                rowUsed[m][num] = colUsed[n][num] = boxUsed[m / 3][n / 3][num] = true;
            }
        }
        //填充数字,从0号格子递归到最后第80号格子，剪枝
        fillNum(board, 0, rowUsed, colUsed, boxUsed);
    }

    private boolean fillNum(char[][] board, int n, boolean[][] rowUsed, boolean[][] colUsed, boolean[][][] boxUsed) {
        if (n == 81) {//终止条件：填完最后一个格子
            return true;
        }
        int i = n / 9, j = n % 9;
        if (board[i][j] == '.') {//当前格子未填
            for (int num = 0; num < 9; num++) {//依次填入9个数字
                if (rowUsed[i][num] || colUsed[j][num] || boxUsed[i / 3][j / 3][num]) {
                    continue;//不满足条件，剪枝
                }
                board[i][j] = (char) (num + '1');//填充
                rowUsed[i][num] = colUsed[j][num] = boxUsed[i / 3][j / 3][num] = true;
                if (fillNum(board, n + 1, rowUsed, colUsed, boxUsed)) {//当前格子已填，继续
                    return true;
                } else {//递归失败，回溯
                    board[i][j] = '.';
                    rowUsed[i][num] = colUsed[j][num] = boxUsed[i / 3][j / 3][num] = false;
                }
            }
        } else {
            return fillNum(board, n + 1, rowUsed, colUsed, boxUsed);//当前格子已填，继续
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
