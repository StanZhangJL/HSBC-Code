import java.util.*;
import java.lang.*;
import java.io.*;
public class Solution
{
    public static double minPosLen(int posk, int[] retailerXcord, int headXcord, int headYcord)
    {
        double answer = Double.MAX_VALUE;

        // 所有城市零售商都在Y=0的直线上
        int n = retailerXcord.length;
        if (n == 0) return 0;

        // 找到最左边和最右边的零售商
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (retailerXcord[i] < minX) {
                minX = retailerXcord[i];
            }
            if (retailerXcord[i] > maxX) {
                maxX = retailerXcord[i];
            }
        }

        // 起始位置的X坐标
        int startX = retailerXcord[posk];

        // 计算六种可能的路径

        // 路径1: start -> 左端 -> 右端 -> 总部
        double path1 = Math.abs(startX - minX) + (maxX - minX) +
                Math.sqrt((maxX - headXcord) * (maxX - headXcord) + headYcord * headYcord);

        // 路径2: start -> 右端 -> 左端 -> 总部
        double path2 = Math.abs(startX - maxX) + (maxX - minX) +
                Math.sqrt((minX - headXcord) * (minX - headXcord) + headYcord * headYcord);

        // 路径3: start -> 左端 -> 总部 -> 右端
        double path3 = Math.abs(startX - minX) +
                Math.sqrt((minX - headXcord) * (minX - headXcord) + headYcord * headYcord) +
                Math.sqrt((headXcord - maxX) * (headXcord - maxX) + headYcord * headYcord);

        // 路径4: start -> 右端 -> 总部 -> 左端
        double path4 = Math.abs(startX - maxX) +
                Math.sqrt((maxX - headXcord) * (maxX - headXcord) + headYcord * headYcord) +
                Math.sqrt((headXcord - minX) * (headXcord - minX) + headYcord * headYcord);

        // 路径5: start -> 总部 -> 左端 -> 右端
        double path5 = Math.sqrt((startX - headXcord) * (startX - headXcord) + headYcord * headYcord) +
                Math.sqrt((headXcord - minX) * (headXcord - minX) + headYcord * headYcord) +
                (maxX - minX);

        // 路径6: start -> 总部 -> 右端 -> 左端
        double path6 = Math.sqrt((startX - headXcord) * (startX - headXcord) + headYcord * headYcord) +
                Math.sqrt((headXcord - maxX) * (headXcord - maxX) + headYcord * headYcord) +
                (maxX - minX);

        // 返回最短路径
        answer = Math.min(path1, path2);
        answer = Math.min(answer, path3);
        answer = Math.min(answer, path4);
        answer = Math.min(answer, path5);
        answer = Math.min(answer, path6);

        return answer;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        // input for posk
        int posk = in.nextInt();

        //input for retailerXcord
        int retailerXcord_size = in.nextInt();
        int retailerXcord[] = new int[retailerXcord_size];
        for(int idx = 0; idx < retailerXcord_size; idx++)
        {
            retailerXcord[idx] = in.nextInt();
        }
        // input for headXcord
        int headXcord = in.nextInt();

        // input for headYcord
        int headYcord = in.nextInt();

        double result = minPosLen(posk, retailerXcord, headXcord, headYcord);
        System.out.printf("%.6f\n", result);

        in.close();
    }
}
