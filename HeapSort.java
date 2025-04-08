import java.util.*;

public class HeapSort {

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distSq;
        int idx;

        public Point(int x, int y, int distSq, int idx) {
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2) {
            return this.distSq - p2.distSq; // ascending order
        }

    }

    public static void heapify(int arr[], int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;

        if (left < size && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }

        if (right < size && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }

        if (maxIdx != i) {
            // swap
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(arr, maxIdx, size);

        }
    }

    public static void heapSort(int arr[]) {
        // step1 - build maxHeap
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, i, n);
        }

        // step2 - push largest at the end
        for (int i = n - 1; i > 0; i--) {
            // swap (largest - first with last)
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }
    }

    // int pts[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
    // int k = 2;

    // PriorityQueue<Point> pq = new PriorityQueue<>();
    // for (int i = 0; i < pts.length; i++) {
    // int distSq = pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1];
    // pq.add(new Point(pts[i][0], pts[i][1], distSq, i));

    // }

    // // nearest k cars
    // for (int i = 0; i < k; i++) {
    // System.out.println("C" + pq.remove().idx);
    // }

    // int ropes[] = { 2, 3, 3, 4, 6 };
    // PriorityQueue<Integer> pq = new PriorityQueue<>();
    // for (int i = 0; i < ropes.length; i++) {
    // pq.add(ropes[i]);
    // }

    // int cost = 0;
    // while (pq.size() > 1) {
    // int min = pq.remove();
    // int min2 = pq.remove();
    // cost += min + min2;
    // pq.add(min + min2);
    // }

    // System.out.print("cost of connecting n ropes = " + cost);

    static class Row implements Comparable<Row> {
        int soldiers;
        int idx;

        public Row(int soldiers, int idx) {
            this.soldiers = soldiers;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row r2) {
            if (this.soldiers == r2.soldiers) {
                return this.idx - r2.idx;
            } else {
                return this.soldiers - r2.soldiers;
            }
        }
    }

    public static void main(String[] args) {
        int army[][] = { { 1, 0, 0, 0 },
                { 1, 1, 1, 1 },
                { 1, 0, 0, 0 },
                { 1, 0, 0, 0 }, };

        int k = 2;

        PriorityQueue<Row> pq = new PriorityQueue<>();

        for (int i = 0; i < army.length; i++) {
            int count = 0;
            for (int j = 0; j < army[0].length; j++) {
                count += army[i][j] == 1 ? 1 : 0;
            }
            pq.add(new Row(count, i));
        }

        for (int i = 0; i < k; i++) {
            System.out.println("R" + pq.remove().idx);
        }

    }

}
