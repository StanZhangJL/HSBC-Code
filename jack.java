package com.stan.employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.*;
import java.util.Scanner;

public class Solution {
    public static double minPossLen(int posK, int[] retailerXCord, int headXCord, int headYCord) {
        int n = retailerXCord.length;
        List<int[]> points = new ArrayList<>();

        // 添加起始点 K (X轴上的点)
        points.add(new int[]{retailerXCord[posK - 1], 0});

        // 添加其他 X 轴上的点（排除 K）
        for (int i = 0; i < n; i++) {
            if (i != posK - 1) {
                points.add(new int[]{retailerXCord[i], 0});
            }
        }

        // 添加首领零售商
        points.add(new int[]{headXCord, headYCord});

        // 生成除起点外的所有点的排列
        List<int[]> others = points.subList(1, points.size());
        List<List<int[]>> permutations = new ArrayList<>();
        permute(others, 0, permutations);

        double minDistance = Double.MAX_VALUE;

        // 计算每种排列的总距离
        for (List<int[]> perm : permutations) {
            double totalDistance = 0;
            int[] prev = points.get(0); // 起点 K

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

    // 计算两点之间的欧几里得距离
    private static double distance(int[] a, int[] b) {
        return Math.sqrt(Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
    }

    // 生成全排列
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

        // input for posK
        int posK = in.nextInt();

        // input for retailerXCord
        int retailerXCordsize = in.nextInt();
        int[] retailerXCord = new int[retailerXCordsize];
        for (int idx = 0; idx < retailerXCordsize; idx++) {
            retailerXCord[idx] = in.nextInt();
        }

        // input for headXCord
        int headXCord = in.nextInt();

        // input for headYCord
        int headYCord = in.nextInt();

        double result = minPossLen(posK, retailerXCord, headXCord, headYCord);
        System.out.print(result);
    }
}


