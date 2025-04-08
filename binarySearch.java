import java.util.*;

public class binarySearch {

    public static int binaryS(int arr[], int target) {
        int si = 0, ei = arr.length - 1;

        while (si <= ei) {
            int mid = si + (ei - si) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }

        }
        return -1;

    }

    public static int linearSearch(int arr[], int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int largest(int arr[] ){
      int largest = Integer.MIN_VALUE;
      int smallest = Integer.MAX_VALUE;
      for(int i=0; i<arr.length; i++) {
        if(largest < arr[i]){
            largest = arr[i];
           
        }
        if(smallest > arr[i]){
            smallest = arr[i];
        }
      }
      System.out.println("smallest number is : "+ smallest);
      return   largest;
    }

    public static void reverseArray(int arr[]){
        int si = 0;
        int ei = arr.length-1;
        while(si < ei){
            int temp = arr[si];
            arr[si] = arr[ei];
            arr[ei] = temp;
            si++;
            ei--;
        }

        for(int i=0; i<arr.length; i++){
            System.out.print( arr[i] +" ");
        }
        System.out.println();
    }

    public static void printPairs(int arr[]){
         int tp = 0;
        for(int i=0; i<arr.length; i++) {
            int curr = arr[i];
            for(int j=i+1; j<arr.length; j++) {
               System.out.print("("+ curr+"," + arr[j]+")");
               tp++;
            }
            System.out.println();
        }
        System.out.print("Total pairs:" + tp);
    }

    public static void printSubArray(int arr[]){
        int totalSubarray = 0;
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
         for(int i=0;i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                currSum = 0;
                for(int k=i; k<=j; k++){
                    currSum = currSum +arr[k];//subarray sum
                  
                }
               System.out.println(currSum);
                if(maxSum < currSum){
                    maxSum = currSum;
                }
            }
           
        }
        System.out.println("Maximum subArraysum  :"+ maxSum);
    }

    public static void maxSubArraySum(int arr[]){
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        
        for(int i=0; i<arr.length; i++){
            for(int j=i;j<arr.length; j++){
                currSum = 0;
                for(int k=i; k<=j; k++){
                    currSum = currSum + arr[k];
                }
                System.out.println(currSum);
                if(maxSum < currSum){
                    maxSum = currSum;
                }
            }
        }
        System.out.println("Maximum subArray sum is: "+maxSum);
    }

    public static void prefixSum(int arr[]){
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[arr.length];

        //calculate prefix
        prefix[0] = arr[0];
      for(int i=1;i<arr.length; i++){
        prefix[i] = prefix[i-1]+arr[i];
      }

      for(int i=0; i<arr.length; i++){
        currSum = 0;
        for(int j=i; j<arr.length; j++){

            currSum = i == 0 ? prefix[j] :prefix[j] - prefix[i-1];
        }
        if(maxSum < currSum){
            maxSum = currSum;
        }
      }
      System.out.println("max SubArray sum is: "+ maxSum);
    }

    public static void kadanes(int arr[]){
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++){
            currSum = currSum + arr[i];
            if(currSum < 0){
                currSum = 0;
            }
            maxSum = Math.max(maxSum, currSum);
        }

        System.out.println("Maximum sum of subArray is : "+ maxSum);

    }

    public static int buyAndSellStock(int prices[]){
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i=0; i<prices.length; i++){
            if(buyPrice < prices[i]){//profit
            int profit = prices[i]-buyPrice;// todays profit
            maxProfit = Math.max(maxProfit, profit);
          } else {
            buyPrice = prices[i];
          }
        }

        return maxProfit;
    }

    public static boolean twice(int nums[] ){
      HashSet<Integer> hs = new HashSet<>();

      for(int num: nums){
        if(hs.contains(num)){
            return true;
        }
        hs.add(num);
      }
       

        return false;
    }

    public static void bubbleSort(int nums[]){

        for(int i=0; i<nums.length-1; i++){
            for(int j =0; j<nums.length -1-i; j++ ){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j]  = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }

       
    }

    public static void selectionSort(int nums[]) {

        for(int i=0; i<nums.length-1; i++){
            int minPos = i;
            for(int j=i+1; j<nums.length; j++){
                if(nums[minPos] > nums[j]){
                    minPos = j;
                }
            }
            //swap 
            int temp = nums[minPos];
            nums[minPos] =  nums[i];
            nums[i]  = temp;
        }
    }

    public static void insertionSort(int arr[]){
        for(int i=1; i<arr.length; i++ ){
            int curr = arr[i];
            int prev = i-1;

            while(prev >= 0 && arr[prev] > curr){
                arr[prev+1] = arr[prev];
                prev--;
            }
            // insertion
            arr[prev+1] = curr;
        }
    }

    public static void print(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }





    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // int arr[] = new int[9];
        // System.out.println("enter a number");
        // for (int i = 0; i < arr.length; i++) {
        // arr[i] = sc.nextInt();
        // }
        // int arr[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
      

        // //System.out.println("your key is found at index :" + linearSearch(arr, key));
        //  kadanes(arr);

        // int prices[] = {7, 1, 5, 3, 6, 4};
        // System.out.println(buyAndSellStock(prices));

        int arr[] = {5, 4, 1, 3, 2};

        //bubbleSort(nums);
        //selectionSort(arr);
        insertionSort(arr);
        print(arr);

    }
}

