package Week_02.leetcode.editor.cn;

import java.util.List;

/**
 * 类作用:
 * 项目名称:  whale
 * 包:      PACKAGE_NAME
 * 类名称:   Node
 * 类描述:   类功能详细描述
 * 创建人:    GuoJing
 * 创建时间:  2021/1/8/0008 21:56
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
