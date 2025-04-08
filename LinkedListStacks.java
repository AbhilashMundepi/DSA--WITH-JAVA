import java.util.*;

public class LinkedListStacks {

    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.empty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while (idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;

        }

        StringBuilder result = new StringBuilder("");
        while (!s.empty()) {
            char curr = s.pop();
            result.append(curr);
        }
        return result.toString();
    }

    public static void reverseStack(Stack<Integer> s) {
        if (s.empty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    public static void printStack(Stack<Integer> s) {
        while (!s.empty()) {
            System.out.println(s.pop());
        }
    }

    public static void stockSpan(int stocks[], int span[]) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for (int i = 1; i < stocks.length; i++) {
            int currPrice = stocks[i];
            while (!s.empty() && currPrice > stocks[s.peek()]) {
                s.pop();
            }
            if (s.empty()) {
                span[i] = i + 1;
            } else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }

            s.push(i);
        }
    }

    // next greater element of some element

    // int arr[] = { 6, 8, 0, 1, 3 };
    // Stack<Integer> s = new Stack<>();
    // int nxtGreater[] = new int[arr.length];

    // for (int i = arr.length - 1; i >= 0; i--) {
    // // 1 while
    // while (!s.empty() && arr[s.peek()] <= arr[i]) {
    // s.pop();
    // }
    // // if_else
    // if (s.empty()) {
    // nxtGreater[i] = -1;
    // } else {
    // nxtGreater[i] = arr[s.peek()];
    // }

    // // push in stack
    // s.push(i);

    // }

    // for (int i = 0; i < nxtGreater.length; i++) {
    // System.out.print(nxtGreater[i] + " ");
    // }
    // System.out.println();
    // }

    public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {// opening
                s.push(ch);
            } else {
                // closing
                if (s.empty()) {
                    return false;
                }
                if ((s.peek() == '(' && ch == ')') // ()
                        || (s.peek() == '{' && ch == '}') // {}
                        || (s.peek() == '[' && ch == ']')) { // []
                    s.pop();
                } else {
                    return false;
                }
            }

        }
        if (s.empty()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // closing
            if (ch == ')') {
                int count = 0;
                while (s.peek() != '(') {
                    s.pop();
                    count++;
                }
                if (count < 1) {
                    return true; // duplicate
                } else {
                    s.pop(); // opening pair
                }
            } else {
                // openning
                s.push(ch);
            }
        }
        return false;
    }

    public static void main(String args[]) {
        String str = "((a+b))"; // true
        String str2 = "(a-b)"; // false
        System.out.println(isDuplicate(str2));

    }
}