package Array;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/ 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。 在坐标内画 n
 * 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 说明：你不能倾斜容器。
 **/


/**
 * 题目解析： 问题转换：假设ai,aj(j>=i)为所选择的两条线，则当Min(ai,aj) * (j-i)为最大值时容纳水最多
 * <p>
 * 思路一:暴力求解法 双重循环遍历得出最大值
 * <p>
 * 思路二：控制变量法 公式:Min(ai,aj) * (j-i),首先保持(j-i)最大，然后逐渐逼近 没想到的点: 如何判断移动指针方向 假设Min(ai,aj)=ai即，ai<aj时候，:Min(ai,aj) * (j-i) =
 * ai*(j-i), 如果此时移动右指针,结果为aj1 当aj1 >= aj时:Min(ai,aj1) = ai 当aj1 < aj时，Min(ai,aj1) <=ai 此时距离j-i-1，面积始终变小
 */
public class Q11 {


  public int maxArea(int[] height) {
    if (height == null || height.length == 0) {
      return 0;
    }
    int i = 0;
    int j = height.length - 1;
    int max = (j - i) * Math.min(height[i], height[j]);
    for (; i < j; ) {
      int tmp = (j - i) * Math.min(height[i], height[j]);
      max = tmp > max ? tmp : max;
      if (height[i] - height[j] >= 0) {
        j--;
      } else {
        i++;
      }
    }
    return max;
  }


  public int beautifulMaxArea(int[] height) {
    int i = 0, j = height.length - 1, max = 0;
    while (i < j) {
      max = height[i] < height[j] ?
          Math.max(max, (j - i) * Math.min(height[i++], height[j]))
          : Math.max(max, (j - i) * Math.min(height[i], height[j--]));
    }
    return max;
  }
}
