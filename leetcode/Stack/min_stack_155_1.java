package Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 *
 * 示例:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *  
 *
 * 提示：
 *
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 *
 */

import java.util.Deque;
import java.util.LinkedList;

/**
 * 思路：
 * 检索常数空间 -> push/pop 时计算最小值
 */
public class min_stack_155_1 {

  Deque<Integer> stack;
  Integer min;

  /** initialize your data structure here. */
  public min_stack_155_1() {
    stack = new LinkedList<>();
    min =Integer.MAX_VALUE;
  }

  public void push(int x) {

    min = stack.isEmpty()?x:Math.min(x,getStackMin());
    stack.push(x);
  }

  public void pop() {
    Integer pop = stack.pop();
    if (min.equals(pop)) {
      min = Integer.MAX_VALUE;
    }
    min = getStackMin();
  }

  public int top() {
    return stack.getFirst();
  }

  public int getMin() {
    return min;
  }

  public int getStackMin(){
    for (Integer e : stack) {
      min = e < min?e:min;
    }
    return min;
  }

  public static void main(String[] args) {
    min_stack_155_1 minStack = new min_stack_155_1();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    minStack.getMin();
    minStack.pop();
    minStack.top();
    minStack.getMin();

  }
}
