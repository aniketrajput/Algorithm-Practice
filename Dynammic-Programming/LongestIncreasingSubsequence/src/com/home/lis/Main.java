package com.home.lis;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {

            int elemnet = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            arr[i] = elemnet;
        }

        findLongestIncreasingSubsequence(arr);

    }

    private static void findLongestIncreasingSubsequence(int[] arr) {

        int n = arr.length;
        int[] lengthArr = new int[n];
        int[] subsequenceArr = new int[n];

        for (int i = 0; i < n; i++) {
            lengthArr[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {

                if (arr[j] < arr[i]) {
                    if (!(lengthArr[j] + 1 < lengthArr[i])){    //we update lengthArr and subsequenceArr only when lengthArr[j] + 1 > lengthArr[i]. If they are equal then also we update, in that case subsequenceArr will have latest j index
                        lengthArr[i] = Math.max(lengthArr[j] + 1, lengthArr[i]);
                        subsequenceArr[i] = j;
                    }
                }
            }
        }

        int maxElement = Integer.MIN_VALUE;
        int maxIndex = 0;

        for (int i = 0; i < n; i++) {
            if (lengthArr[i] > maxElement) {
                maxElement = lengthArr[i];
                maxIndex = i;
            }
        }

        StringBuffer sb = new StringBuffer();

        /*while (maxIndex != 0){

            sb.insert(0, arr[subsequenceArr[maxIndex]]);
            sb.insert(0, " ");

            maxIndex = subsequenceArr[maxIndex];
        }
*/
        List<Integer> tempArr = new ArrayList<>();
        int i = 0;

        while (maxIndex != 0){

            tempArr.add(maxIndex);
            maxIndex = subsequenceArr[maxIndex];
        }

        System.out.println(tempArr);

    }
}













