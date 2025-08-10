
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    // arr represents the given list of numbers.
    public static int[] interchange(int[] arr) {
        int[] answer = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            answer[arr[i]] = i;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // input for arr
        int arr_size = in.nextInt();
        int[] arr = new int[arr_size];
        for (int idx = 0; idx < arr_size; idx++) {
            arr[idx] = in.nextInt();
        }

        int[] result = interchange(arr);
        for (int idx = 0; idx < result.length - 1; idx++) {
            System.out.print(result[idx] + " ");
        }
        System.out.print(result[result.length - 1]);
    }
}

===================================================================================

import java.util.*;

public class Solution {

    public static double minPossLen(int posK, int[] retailerXCord, int headXCord, int headYCord) {
        int n = retailerXCord.length;
        List<int[]> points = new ArrayList<>();
        points.add(new int[]{retailerXCord[posK - 1], 0});
        for (int i = 0; i < n; i++) {
            if (i != posK - 1) {
                points.add(new int[]{retailerXCord[i], 0});
            }
        }

        points.add(new int[]{headXCord, headYCord});
        List<int[]> others = points.subList(1, points.size());
        List<List<int[]>> permutations = new ArrayList<>();
        permute(others, 0, permutations);

        double minDistance = Double.MAX_VALUE;

        for (List<int[]> perm : permutations) {
            double totalDistance = 0;
            int[] prev = points.get(0); 

            for (int[] p : perm) {
                totalDistance += distance(prev, p);
                prev = p;
            }

            if (totalDistance < minDistance) {
                minDistance = totalDistance;
            }
        }

        return minDistance;
    }

    private static double distance(int[] a, int[] b) {
        return Math.sqrt(Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
    }

    private static void permute(List<int[]> arr, int k, List<List<int[]>> result) {
        if (k == arr.size()) {
            result.add(new ArrayList<>(arr));
        } else {
            for (int i = k; i < arr.size(); i++) {
                Collections.swap(arr, k, i);
                permute(arr, k + 1, result);
                Collections.swap(arr, k, i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int posK = in.nextInt();

        int retailerXCordsize = in.nextInt();
        int[] retailerXCord = new int[retailerXCordsize];
        for (int idx = 0; idx < retailerXCordsize; idx++) {
            retailerXCord[idx] = in.nextInt();
        }

        int headXCord = in.nextInt();

        int headYCord = in.nextInt();

        double result = minPossLen(posK, retailerXCord, headXCord, headYCord);
        System.out.print(result);
    }
}
