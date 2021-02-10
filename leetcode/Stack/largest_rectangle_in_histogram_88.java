package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */

class Solution {
    public int largestRectangleArea(int[] heights) {
        //固定宽度
        int maxArea = 0;
        for(int i=0;i<heights.length;i++) {
            int minHeight = Integer.MAX_VALUE;
            for(int j = i;j<heights.length;j++) {
                minHeight = Math.min(minHeight,heights[j]);
                maxArea = Math.max(maxArea,(j-i+1) * minHeight);
            }
        }
        return maxArea;
    }

    public int largestRectangleArea2(int[] heights) {
        //固定高度
        int length = heights.length;
        int maxArea = 0;
        for(int mid = 0; mid < length;mid++) {
            int left = mid,right = mid;
            while(left-1>=0 && heights[left-1] >= heights[mid]){
                left--;
            }
            while(right+1<length && heights[right+1] >= heights[mid]){
                right++;
            }
            maxArea = Math.max(maxArea,(right-left+1) * heights[mid]);
        }
        return maxArea;
     }

     public int largestRectangleArea3(int[] heights) {
         //1. 首节点哨兵，避免非空判断
         //2. 尾节点哨兵，避免最后一个值最大导致需要再次弹栈的情况
         if(heights.length == 0) return 0;
         if(heights.length == 1) return heights[0];
         int len = heights.length;
         int[] newHeights = new int[len+2];
         newHeights[0] = 0;
         newHeights[len] = 0;
         System.arraycopy(heights, 0, newHeights, 1, len);
         len = len+2;
         heights = newHeights;
         Deque<Integer> stack = new ArrayDeque<>();
         stack.addLast(0);
         int maxArea = 0;
         for (int i = 1; i < heights.length; i++) {
             //栈顶元素大于当前值时,说明找到右边界了,此时可遍历弹出计算之前的面积
             while(heights[stack.peekLast()] > heights[i]){
                 int height = heights[stack.removeLast()];
                 //单调栈的原因,左边界为上个元素
                 int width = i - stack.peekLast() -1;
                 maxArea = Math.max(maxArea, height * width);
             }
             stack.addLast(i);
         }
         return maxArea;
     }
}