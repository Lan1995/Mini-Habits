package Array;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。 尽量减少操作次数。
 * <p>
 * 解题思路： 思路一：直接遍历 如果值是0就后移，不对
 * <p>
 * 思路二：双指针法 最开始想到的就是双指针法，脑子中模拟的时候，思路正确，模拟结果不对，后续最好画出来
 * 思考错误的原因：想着交换的时候，顺序会被打乱，其实并没有，思路不够清晰
 * 按照快的思想，取0为基准点，不等于于0的放左侧，等于于0的放右侧
 * 则左指针的左侧为不等于0的值，右侧为等于0的值，右指针不断右移遍历
 */
public class Q283MoveZeroes {

  public void moveZeroes(int[] nums) {
    int l = 0, r = 0, h = nums.length - 1;
    while (r < h) {
      if (nums[r] != 0) {
        swap(nums, l, r);
        l++;
      }
      r++;
    }
  }


  public static void swap(int[] nums, int l, int r) {
    int temp = nums[l];
    nums[l] = nums[r];
    nums[r] = temp;

  }
}
