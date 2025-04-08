import java.util.*;
import java.util.LinkedList;

public class QueueB {
    // static class Node {
    // int data;
    // Node next;

    // Node(int data) {
    // this.data = data;
    // this.next = null;
    // }
    // }

    // static class Queue {
    // static Node head = null;
    // static Node tail = null;

    // public static boolean isEmpty() {
    // return head == null && tail == null;
    // }

    // // add
    // public static void add(int data) {
    // Node newNode = new Node(data);
    // if (head == null) {
    // head = tail = newNode;
    // return;
    // }
    // tail.next = newNode;
    // tail = newNode;

    // }

    // // remove
    // public static int remove() {
    // if (isEmpty()) {
    // System.out.println("empty queue");
    // return -1;
    // }
    // int front = head.data;
    // // single element
    // if (tail == head) {
    // tail = head = null;
    // } else {
    // head = head.next;
    // }
    // return front;

    // }

    // // peek
    // public static int peek() {
    // if (isEmpty()) {
    // System.out.println("empty queue");
    // return -1;
    // }
    // return head.data;
    // }

    // }

    // static class Queue {
    // static Stack<Integer> s1 = new Stack<>();
    // static Stack<Integer> s2 = new Stack<>();

    // public static boolean isEmpty() {
    // return s1.empty();
    // }

    // // add O(n)
    // public static void add(int data) {
    // while (!s1.empty()) {
    // s2.push(s1.pop());
    // }

    // s1.push(data);

    // while (!s2.isEmpty()) {
    // s1.push(s2.pop());
    // }
    // }

    // // remove
    // public static int remove() {
    // if (isEmpty()) {
    // System.out.println("queue is empty");
    // return -1;
    // }
    // return s1.pop();
    // }

    // // peek
    // public static int peek() {
    // if (isEmpty()) {
    // System.out.println("queue is empty");
    // return -1;
    // }
    // return s1.peek();
    // }

    // }

    static class Stack {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        public static void push(int data) {
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        public static int pop() {
            if (isEmpty()) {
                System.out.println("empty stack");
                return -1;
            }
            int top = -1;

            // case 1
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) {
                        break;
                    }
                    q2.add(top);
                }
            } else { // case 2
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) {
                        break;
                    }
                    q1.add(top);
                }

            }
            return top;
        }

        // peek
        public static int peek() {
            if (isEmpty()) {
                System.out.println("empty stack");
                return -1;
            }
            int top = -1;

            // case 1
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }
            } else { // case 2
                while (!q1.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }

            }
            return top;
        }

    }

    public static void main(String args[]) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }

    }

}
