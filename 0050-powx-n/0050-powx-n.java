class Solution {
    public double myPow(double x, int n) {
        long N = n;  // Use long to handle Integer.MIN_VALUE negation safely

        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }

    private double fastPow(double x, long n) {
        if (n == 0) return 1.0;          // Base case: x^0 = 1

        double half = fastPow(x, n / 2); // Recursive half power

        if (n % 2 == 0) {
            return half * half;           // Even: x^n = (x^n/2)²
        } else {
            return half * half * x;       // Odd:  x^n = (x^n/2)² × x
        }
    }
}