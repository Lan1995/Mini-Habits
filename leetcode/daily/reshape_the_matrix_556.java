package daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class reshape_the_matrix_556 {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (r <= 0 || c <= 0) return nums;
        List<Integer> list = new ArrayList<>();
        for (int[] num : nums) {
            for (int i : num) {
                list.add(i);
            }
        }
        if ((r * c) != list.size()) return nums;
        int[][] res = new int[r][c];
        for (int row = 0; row < res.length; row++) {
            int[] col = new int[c];
            for (int i = 0; i < c; i++) {
                col[i] = list.get(row * c + i);
            }
            res[row] = col;
        }
        return res;
    }

    public int[][] matrixReshape2(int[][] nums, int r, int c) {
        if (r <= 0 || c <= 0) return nums;
        int oldCol = nums[0].length;
        int oldRow = nums.length;
        if ((r * c) != oldCol * oldRow) return nums;
        int[][] res = new int[r][c];
        for (int i = 0; i < oldCol * oldRow; i++) {
            res[i / c][i % c] = nums[i / oldCol][i % oldCol];
        }
        return res;
    }
}
