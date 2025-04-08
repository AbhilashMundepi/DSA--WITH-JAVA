import java.util.*;

public class Recursion {
    public static void printNumbers(int n) {
        if (n == 10) {
            System.out.println(n);
            return;
        }
        System.out.println(n + " ");
        printNumbers(n + 1);
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int factNm1 = factorial(n - 1);
        int factorial = n * factNm1;
        return factorial;
    }

    public static int printSum(int n) {
        if (n == 0) {
            return 0;
        }
        int sum = 0;
        sum = n + printSum(n - 1);
        return sum;

    }

    public static int printFibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int fibNm1 = printFibonacci(n - 1);
        int fibNm2 = printFibonacci(n - 2);
        int fibN = fibNm1 + fibNm2;

        return fibN;

    }

    public static boolean isSorted(int arr[], int i) {

        if (i == arr.length - 1) {
            return true;
        }

        if (arr[i] > arr[i + 1]) {
            return false;
        }
        return isSorted(arr, i + 1);
    }

    public static int firstOccurence(int arr[], int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == key) {
            return i;

        }
        return firstOccurence(arr, key, i + 1);
    }

    public static int pow(int x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * pow(x, n - 1);
    }

    public static int optimizedPower(int a, int n) {
        if (n == 0) {
            return 1;
        }
        int halfPowerSq = optimizedPower(a, n / 2) * optimizedPower(a, n / 2);

        // n is odd
        if (n % 2 != 0) {
            halfPowerSq = a * halfPowerSq;
        }

        return halfPowerSq;
    }

    public static int tilingProblem(int n) {// 2xn (floor size)
        if (n == 0 || n == 1) {
            return 1;
        }

        // kaam
        // vertical
        int fnm1 = tilingProblem(n - 1);

        // horizontal choice
        int fnm2 = tilingProblem(n - 2);

        int totWays = fnm1 + fnm2;
        return totWays;
    }

    public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[]) {
        if (idx == str.length()) {
            System.out.println(newStr);
            return;
        }
        // kaam
        char currChar = str.charAt(idx);
        if (map[currChar - 'a'] == true) {
            // duplicate
            removeDuplicates(str, idx + 1, newStr, map);
        } else {
            map[currChar - 'a'] = true;
            removeDuplicates(str, idx + 1, newStr.append(currChar), map);
        }

    }

    public static int friendsPairing(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        // kaam
        // single
        int fnm1 = friendsPairing(n - 1);

        // pair
        int fnm2 = friendsPairing(n - 2);
        int pairways = (n - 1) * fnm2;

        // totways
        int totWays = fnm1 + pairways;
        return totWays;
    }

    public static void printBinStrigs(int n, int lastPlace, String str) {
        // base case
        if (n == 0) {
            System.out.println(str);
            return;
        }
        // kaam
        printBinStrigs(n - 1, 0, str + "0");
        if (lastPlace == 0) {
            printBinStrigs(n - 1, 1, str + "1");
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        printBinStrigs(3, 0, "");

    }

}
