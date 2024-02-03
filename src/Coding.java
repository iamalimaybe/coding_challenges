import java.util.*;

public class Coding {

    // 500, 100, 50
    public static void main(String[] args) {
//        printDenominations(1350);
//        int[] nums1 = {1,2,3,0,0,0};
//        int[] nums1 = {2,2,1,1,1,2,2};
//        int[] nums1 = {1,2,3,4,5,6,7};
        int[] nums1 = {7,1,5,3,6,4};
//        int[] nums1 = {2,4,1};
//        int[] nums1 = {3,2,3};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
//        merge(nums1, m, nums2, n);
//        System.out.println(majorityElement(nums1));
//        rotate(nums1, 3);
//        Arrays.stream(nums1).forEach(System.out::println);
        System.out.println(maxProfit(nums1));
    }

    public static void printDenominations(int amount) {
        int fives = 0;
        int hundreds = 0;
        int fifties = 0;
        if (amount > 0) {

            fives = amount / 500;
            amount = amount - (fives * 500);

            hundreds = amount / 100;
            amount = amount - (hundreds * 100);

            fifties = amount / 50;
            amount = amount - (fifties * 50);

            System.out.println(
                    "Total Five Hundreds: ".concat(String.valueOf(fives)).
                            concat(" Total Hundreds: ").concat(String.valueOf(hundreds)).
                            concat(" Total Fifties: ").concat(String.valueOf(fifties))
            );
        }


    }

    // Merge sorted arrays..
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        if (n >= 0) System.arraycopy(nums2, 0, nums1, m, n);

        for (int i = 0; i < m + n; i++) {
            for (int j = i; j < m + n; j++) {
                if (nums1[i] > nums1[j]) {
                    int temp = nums1[i];
                    nums1[i] = nums1[j];
                    nums1[j] = temp;
                }
            }
        }
    }

    public static int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                k++;
            } else {
                nums[i] = val + 1;
            }
        }
        return k;
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        return Collections.max(freqMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static int maxProfit(int[] prices) {

        Dictionary<Integer, Integer> dict = new Hashtable<>();
        for (int i = 0; i < prices.length; i++) {
            if (i + 1 < prices.length) {
                int loc = maxLocation(prices, i + 1);
                if (loc > -1) {
                    dict.put(prices[i], prices[loc]);
                }
            }
        }
        var keys = dict.keys();
        int key = 0, max = 0;
        while(keys.hasMoreElements()) {
            key = keys.nextElement();
            int val = dict.get(key) - key;
        }
        return 0;
    }

    public static int maxLocation(int[] prices, int start) {
        int loc = -1;
        int max = prices[start - 1];
        for (int i = start; i < prices.length; i++) {
            if (max < prices[i]) {
                max = prices[i];
                loc = i;
            }
        }
        return loc;
    }


}
