import java.util.*;

public class DP {

    public static int fib(int n, int f[]) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (f[n] != 0) {// fib(n) is already calculated
            return f[n];
        }
        f[n] = fib(n - 1, f) + fib(n - 2, f);
        return f[n];

    }

    public static int fibTaulation(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // memoization - O(n) \ recursion O(2^n)
    public static int CountWays(int n, int ways[]) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }

        if (ways[n] != -1) { // already calculated
            return ways[n];

        }
        ways[n] = CountWays(n - 1, ways) + CountWays(n - 2, ways);
        return ways[n];
    }

    public static int CountWaysTab(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;

        // tabulation O(n)
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1] + 0;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {

        int n = 5; // n =3 ->3 ways & n =4 -> 5 ways = total ways = 8 ways
        int ways[] = new int[n + 1]; // 0 0 0 0
        Arrays.fill(ways, -1); // -1 -1 -1 -1
        System.out.println(CountWays(n, ways));
        System.out.println(CountWaysTab(n));

    }

}
