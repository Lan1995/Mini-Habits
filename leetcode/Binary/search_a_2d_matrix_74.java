package Binary;

public class search_a_2d_matrix_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int len = row * col;
        int left = 0,right = len - 1;
        while(left <= right) {
            //n*col + curCol = mid;
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / col][mid % col];
            if(target == midValue) return true;
            if(target > midValue) left = mid + 1;
            if(target < midValue) right = mid - 1;
        }
        return false;
    }
}
