//给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使
//用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l"
//,"v"]], words = ["oath","pea","eat","rain"]
//输出：["eat","oath"]
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], words = ["abcb"]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 12 
// board[i][j] 是一个小写英文字母 
// 1 <= words.length <= 3 * 104 
// 1 <= words[i].length <= 10 
// words[i] 由小写英文字母组成 
// words 中的所有字符串互不相同 
// 
// Related Topics 字典树 回溯算法 
// 👍 329 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int m;
    int n;
    char[][] board;
    String word;
    int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<String> findWords(char[][] board, String[] words) {
        m = board.length;
        n = board[0].length;
        this.board = board;
        ArrayList<String> res = new ArrayList<>();

        //1、DFS+回溯
        for (String w : words) {
            this.word = w;
            if(existWord(board, word)){
                res.add(word);
            }
        }

        //2、字典树Trie
        //...

        return res;
    }

    private boolean existWord(char[][] board, String word) {
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
                board[i][j] = tmp;//匹配到目标值之后要还原现场，继续匹配下一个word
                return true;
            }
        }
        board[i][j] = tmp;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
