package com.home.suduko;

/*

        1. You are give a partially filled 9*9 2-D array(arr) which represents an incomplete Sudoku state.
        2. You are required to assign the digits from 1 to 9 to the empty cells following some rules.
        Rule 1 - Digits from 1-9 must occur exactly once in each row.
        Rule 2 - Digits from 1-9 must occur exactly once in each column.
        Rule 3 - Digits from 1-9 must occur exactly once in each 3x3 sub-array of the given 2D array.

*/

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            }
        }

        solveSuduko(arr, 0, 0);

        scanner.close();
    }

    private static void solveSuduko(int[][] board, int i, int j) {

        if (i == board.length){
            display(board);
            return;
        }

        int ni = 0;
        int nj = 0;

        if (j == board[0].length - 1) {
            ni = i + 1;
            nj = 0;
        }else {
            ni = i;
            nj = j + 1;
        }

        if (board[i][j] != 0) {
            solveSuduko(board, ni, nj);
        }else {
            for (int po = 1; po <= 9 ; po++) {
                if (isValid(board, i, j, po) == true){
                    board[i][j] = po;
                    solveSuduko(board, ni, nj);
                    board[i][j] = 0;
                }
            }
        }
    }

    private static boolean isValid(int[][] board, int x, int y, int val) {

        for (int j = 0; j < board[0].length; j++) {                                 //board[0].length give columns length, board.length will give rows length
            if (board[x][j] == val){
                return false;
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][y] == val){
                return false;
            }
        }

        int smi = x/3 * 3;
        int smj = y/3 * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[smi + i][smj + j] == val){
                    return false;
                }
            }
        }

        return true;
    }

    private static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println();
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }
    }
}
