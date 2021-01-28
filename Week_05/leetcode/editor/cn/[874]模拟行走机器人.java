//机器人在一个无限大小的 XY 网格平面上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令 commands ： 
//
// 
// -2 ：向左转 90 度 
// -1 ：向右转 90 度 
// 1 <= x <= 9 ：向前移动 x 个单位长度 
// 
//
// 在网格上有一些格子被视为障碍物 obstacles 。第 i 个障碍物位于网格点 obstacles[i] = (xi, yi) 。 
//
// 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续尝试进行该路线的其余部分。 
//
// 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。（即，如果距离为 5 ，则返回 25 ） 
//
// 
// 
// 
// 
// 
// 
//
// 
// 注意： 
//
// 
// 北表示 +Y 方向。 
// 东表示 +X 方向。 
// 南表示 -Y 方向。 
// 西表示 -X 方向。 
// 
// 
// 
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：commands = [4,-1,3], obstacles = []
//输出：25
//解释：
//机器人开始位于 (0, 0)：
//1. 向北移动 4 个单位，到达 (0, 4)
//2. 右转
//3. 向东移动 3 个单位，到达 (3, 4)
//距离原点最远的是 (3, 4) ，距离为 32 + 42 = 25 
//
// 示例 2： 
//
// 
//输入：commands = [4,-1,4,-2,4], obstacles = [[2,4]]
//输出：65
//解释：机器人开始位于 (0, 0)：
//1. 向北移动 4 个单位，到达 (0, 4)
//2. 右转
//3. 向东移动 1 个单位，然后被位于 (2, 4) 的障碍物阻挡，机器人停在 (1, 4)
//4. 左转
//5. 向北走 4 个单位，到达 (1, 8)
//距离原点最远的是 (1, 8) ，距离为 12 + 82 = 65 
//
// 
//
// 提示： 
//
// 
// 1 <= commands.length <= 104 
// commands[i] is one of the values in the list [-2,-1,1,2,3,4,5,6,7,8,9]. 
// 0 <= obstacles.length <= 104 
// -3 * 104 <= xi, yi <= 3 * 104 
// 答案保证小于 231 
// 
// Related Topics 贪心算法 
// 👍 121 👎 0


import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        //1、障碍物位置描述：
        //第i个障碍物坐标：x = obstacles[i][0], y = obstacles[i][1]
        //如何检查当前点是不是障碍点？装入set字典实时查询
        //2、指令描述：
        //2.1 转向：向左、向右
        //坐标平面上北下南左西右东方向对应：direction[0，1，2，3]
        //右转一次后方向=（原方向+1）% 4
        //左转一次=右转三次方向=（原方向+3）% 4
        //2.2 位移：步长1
        //位移方向只有上北下南左西右东四个，对应的xy坐标变化move[[0,1],[1,0],[0,-1],[-1,0]]，一维下标对应方向
        //位移公式: x += move[ direction[i] ][0]
        //        y += move[ direction[i] ][1]

        //构建位移数组, 对应方向数组[0, 1, 2, 3]
        int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        //构建障碍物坐标字典
        Set<Pair<Integer, Integer>> obstaclesSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstaclesSet.add(new Pair<>(obstacle[0], obstacle[1]));
        }
        int res = 0;//题求最大欧式距离

        //开始执行命令，初始位置（0，0），初始方向北=0
        int currX = 0, currY = 0;
        int currDire = 0;
        for (int cmd : commands) {
            //先处理转向命令:-1右转，-2左转
            if (cmd < 0) {
                currDire = cmd == -1 ? (currDire + 1) % 4 : (currDire + 3) % 4;
            }
            //处理位移命令
            for (int i = 1; i <= cmd; i++) {
                int newX = currX + move[currDire][0];
                int newY = currY + move[currDire][1];
                //检查障碍点
                if (obstaclesSet.contains(new Pair<>(newX, newY))) {
                    break;//遇到障碍点，中断位移
                } else {
                    currX = newX;
                    currY = newY;
                    res = Math.max(res, currX * currX + currY * currY);
                }
            }

        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
