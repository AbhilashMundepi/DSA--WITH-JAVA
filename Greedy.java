import java.lang.reflect.Array;
import java.util.*;
import java.util.ArrayList;

// int start[] = { 1, 3, 0, 5, 8, 5 };
// int end[] = { 2, 4, 6, 7, 9, 9 };

// // sorting
// int activities[][] = new int[start.length][3];
// for (int i = 0; i < start.length; i++) {
//     activities[i][0] = i;
//     activities[i][1] = start[i];
//     activities[i][2] = end[i];
// }

// // lamda function -shortform
// Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

// // end time basis sorted
// int maxAct = 0;
// ArrayList<Integer> ans = new ArrayList<>();

// // 1st Activity
// maxAct = 1;
// ans.add(activities[0][0]);
// int lastEnd = activities[0][2];
// for (int i = 1; i < end.length; i++) {
//     if (activities[i][1] >= lastEnd) {
//         // activity select
//         maxAct++;
//         ans.add(activities[i][0]);
//         lastEnd = activities[i][2];
//     }
// }

// System.out.println("max activities = " + maxAct);
// for (int i = 0; i < ans.size(); i++) {
//     System.out.print(" A" + ans.get(i));
// }
// System.out.println();

// Min absolute difference pair
// int val[] = { 60, 100, 120 };
//         int weight[] = { 10, 20, 30 };
//         int w = 50;

//         double ratio[][] = new double[val.length][2];
//         // 0th col => idx; 1st col => ratio

//         for (int i = 0; i < val.length; i++) {
//             ratio[i][0] = i;
//             ratio[i][1] = val[i] / (double) weight[i];
//         }

//         // acending order
//         Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

//         int capacity = w;
//         int finalVal = 0;
//         for (int i = ratio.length - 1; i >= 0; i--) {
//             int idx = (int) ratio[i][0];
//             if (capacity >= weight[idx]) {// include full item
//                 finalVal += val[idx];
//                 capacity -= weight[idx];
//             } else {
//                 // include fractional item
//                 finalVal += (ratio[i][1] * capacity);
//                 capacity = 0;
//                 break;
//             }

//         }
//         System.out.println("final value =" + finalVal);

// max length of chain pairs
// int pairs[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } }; // O(nlogn)

// Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

// int chainLen = 1;
// int chainEnd = pairs[0][1]; // Last selected pair end // chain end

// for (int i = 1; i < pairs.length; i++) {
//     if (pairs[i][0] > chainEnd) {
//         chainLen++;
//         chainEnd = pairs[i][1];
//     }
// }
// System.out.println("max length of chain = " + chainLen);

// indian coins

// Integer coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };

// Arrays.sort(coins, Comparator.reverseOrder());

// int countOfCoins = 0;
// int amount = 590;
// ArrayList<Integer> ans = new ArrayList<>();

// for (int i = 0; i < coins.length; i++) {
//     if (coins[i] <= amount) {
//         while (coins[i] <= amount) {
//             countOfCoins++;
//             ans.add(coins[i]);
//             amount -= coins[i];
//         }
//     }
// }

// System.out.println("total (min) coins used = " + countOfCoins);

// for (int i = 0; i < ans.size(); i++) {
//     System.out.print(ans.get(i) + " ");
// }
// System.out.println();

// job sequence problem
// 

// public class Greedy {

//     static class Job {
//         int deadline;
//         int profit;
//         int id;

//         public Job(int i, int d, int p) {
//             id = i;
//             deadline = d;
//             profit = p;

//         }
//     }static class Job {
//     int deadline;
//     int profit;
//     int id;

//     public Job(int i, int d, int p) {
//         id = i;
//         deadline = d;
//         profit = p;

//     }
// }

// public static void main(String args[]) {
//     int jobsInfo[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };

//     ArrayList<Job> jobs = new ArrayList<>();

//     for (int i = 0; i < jobsInfo.length; i++) {
//         jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
//     }

//     Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);
//     // descending order of profit

//     ArrayList<Integer> seq = new ArrayList<>();
//     int time = 0;
//     for (int i = 0; i < jobs.size(); i++) {
//         Job curr = jobs.get(i);
//         if (curr.deadline > time) {
//             seq.add(curr.id);
//             time++;

//         }
//     }

//     // print seq
//     System.out.println("max jobs = " + seq.size());
//     for (int i = 0; i < seq.size(); i++) {
//         System.out.print(seq.get(i) + " ");
//     }
//     System.out.println();

public class Greedy {

    public static void main(String args[]) {
        int n = 4, m = 6;
        Integer costVer[] = { 2, 1, 3, 1, 4 }; // m-1
        Integer costHor[] = { 4, 1, 2 }; // n-1

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0, v = 0;
        int hp = 1, vp = 1;
        int cost = 0;

        while (h < costHor.length && v < costVer.length) {
            if (costVer[v] <= costHor[h]) {// horizontal cut
                cost += (costHor[h] * vp);
                hp++;
                h++;
            } else { // vertical cut
                cost += (costVer[v] * hp);
                vp++;
                v++;
            }

        }

        while (h < costHor.length) {
            cost += (costHor[h] * vp);
            hp++;
            h++;
        }

        while (v < costVer.length) {
            cost += (costVer[v] * hp);
            vp++;
            hp++;
        }

        System.out.println("min cost of cuts =  " + cost);

    }
}
