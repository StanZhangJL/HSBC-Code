
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

public class Solution
{
    public static double minPosLen(int posk, int[] retailerXcord, int headXcord, int headYcord)
    {
        double answer = Double.MAX_VALUE;

        int n = retailerXcord.length;
        if (n == 0) return 0;

        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        for (int x : retailerXcord) {
            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);
        }

        int startX = retailerXcord[posk];

        double path1 = Math.abs(startX - minX) + (maxX - minX) +
                Math.sqrt((maxX - headXcord) * (maxX - headXcord) + headYcord * headYcord);


        double path2 = Math.abs(startX - maxX) + (maxX - minX) +
                Math.sqrt((minX - headXcord) * (minX - headXcord) + headYcord * headYcord);

        double path3 = Math.abs(startX - minX) +
                Math.sqrt((minX - headXcord) * (minX - headXcord) + headYcord * headYcord) +
                Math.sqrt((headXcord - maxX) * (headXcord - maxX) + headYcord * headYcord);

        double path4 = Math.abs(startX - maxX) +
                Math.sqrt((maxX - headXcord) * (maxX - headXcord) + headYcord * headYcord) +
                Math.sqrt((headXcord - minX) * (headXcord - minX) + headYcord * headYcord);

        double path5 = Math.sqrt((startX - headXcord) * (startX - headXcord) + headYcord * headYcord) +
                Math.sqrt((headXcord - minX) * (headXcord - minX) + headYcord * headYcord) +
                (maxX - minX);

        double path6 = Math.sqrt((startX - headXcord) * (startX - headXcord) + headYcord * headYcord) +
                Math.sqrt((headXcord - maxX) * (headXcord - maxX) + headYcord * headYcord) +
                (maxX - minX);

        answer = Math.min(path1, Math.min(path2, Math.min(path3, Math.min(path4, Math.min(path5, path6)))));

        return answer;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int posk = in.nextInt();

        int retailerXcord_size = in.nextInt();
        int retailerXcord[] = new int[retailerXcord_size];
        for(int idx = 0; idx < retailerXcord_size; idx++)
        {
            retailerXcord[idx] = in.nextInt();
        }
        int headXcord = in.nextInt();
        
        int headYcord = in.nextInt();

        double result = minPosLen(posk, retailerXcord, headXcord, headYcord);
        System.out.printf("%.6f\n", result);
    }
}
