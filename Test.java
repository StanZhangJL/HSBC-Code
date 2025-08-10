
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
