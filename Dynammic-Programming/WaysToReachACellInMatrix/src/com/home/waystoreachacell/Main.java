package com.home.waystoreachacell;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
* LeetCode - Unique Paths
* */

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = findWays(n, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
        scanner.close();
    }

    private static int findWays(int n, int m) {
        int [][] tempArr = new int[n][m];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {

                if (i == 0 || j == 0) {
                    tempArr[i][j] = 1;
                }
                else {
                    tempArr[i][j] = tempArr[i-1][j] + tempArr[i][j-1];
                }
            }
        }

        return tempArr[n-1][m-1];
    }
}
