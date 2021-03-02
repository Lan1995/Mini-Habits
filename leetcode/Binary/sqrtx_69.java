package Binary;

public class sqrtx_69 {
    public int mySqrt(int x) {
        if(x < 2) return x;
        long left = 2, right = x / 2 + 1, guess;
        long result = Integer.MAX_VALUE;
        while(left <= right) {
            long mid = left + (right - left) / 2;
            guess = mid * mid;
            if(guess == x) return (int)mid;
            if(guess > x) {
                right = mid - 1;
                result = Math.min(result, mid-1);
            } else {
                left = mid + 1;
            }
        }
        return (int) result;
    }
}
