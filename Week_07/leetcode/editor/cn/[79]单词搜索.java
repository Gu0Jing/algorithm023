//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false 
//
// 
//
// 提示： 
//
// 
// board 和 word 中只包含大写和小写英文字母。 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics 数组 回溯算法 
// 👍 781 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int m;
    int n;
    char[][] board;
    String word;
    int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        this.board = board;
        this.word = word;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int index) {
        if (i < 0 || i > m - 1 || j < 0 || j > n - 1 || index > word.length() - 1) {
            return false;
        }
        if (word.charAt(index) != board[i][j]) {
            return false;
        }
        if (index == word.length()-1) {
            return true;
        }
        char tmp = board[i][j];
        board[i][j] = ' ';
        for (int[] dir : direction) {
            int newX = i + dir[0];
            int newY = j + dir[1];
            if (dfs(newX, newY, index + 1)) {
                return true;
            }
        }
        board[i][j] = tmp;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
