package Recursion.DivideConquer;

public class powx_n_50 {
    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }


    public static void main(String[] args) {
        powx_n_50 test = new powx_n_50();
        System.out.println(test.myPow(2,-2147483648));
    }
}
