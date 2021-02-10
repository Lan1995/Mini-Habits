package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class trapping_rain_water_42  {
    public int trap(int[] height) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            while(!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int top = stack.pop();
                if(stack.isEmpty()){
                    break;
                }

                int distance = i-stack.peek()-1;
                int h = Math.min(height[i],height[stack.peek()]) - height[top];
                res +=distance * h;
            }
            stack.push(i);
        }
        return res;
    }
}