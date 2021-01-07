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
public class Debug02 implements Comparable {

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public static void main(String[] args) {
        String [] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        ArrayList<List<String>> lists = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (map.containsKey(key)) {
                List<String> list = map.get(key);
                list.add(s);
                map.put(key, list);
            } else {
                map.put(key, new ArrayList<>());
            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            lists.add(entry.getValue());
        }
    }

}
