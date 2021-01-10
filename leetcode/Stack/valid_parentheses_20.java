package Stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 */
public class valid_parentheses_20 {

  /**
   * 思路一：
   * 1. 遍历循环，将左括号放入栈中
   * 2. 碰见右括号则弹出栈顶，如果和左括号匹配则继续
   *
   * 栈：保存遍历集合
   * hashmap:保存映射
   * @param
   * @return
   */
  public static boolean isValid(String s) {
    if(s.length() % 2 != 0){
      return false;
    }
    HashMap<Character,Character> hashMap = new HashMap<>();
    hashMap.put('(',')');
    hashMap.put('{','}');
    hashMap.put('[',']');
    char[] chars = s.toCharArray();
    Deque<Character> list = new LinkedList<>();
    for (char c : chars) {
      if (hashMap.containsKey(c)) {
        list.push(c);
      }else if(list.isEmpty() || !hashMap.get(list.pop()).equals(c)){
        return false;
      }
    }

    return list.isEmpty();
  }

  public static void main(String[] args) {
    isValid("()");
  }
}
