package Binary;

public class valid_perfect_square_367 {

    public boolean isPerfectSquare(int num) {
        if(num < 2 ) return true;
        long left = 2 ,right = num/2,guess;
        while(left <= right) {
            long x = left + (right - left) / 2;
            guess = x * x;
            if(guess == num) return true;
            if(guess > num) right = x - 1;
            if(guess < num) left = x + 1;
        }
        return false;
    }

    public boolean isPerfectSquareForce(int num) {
        if(num == 1) return true;
        for (int i = 0; i < num; i++) {
            if(i*i == num) return true;
        }
        return false;
    }
}
