package com.home.abbreviations;

/*

1. You are given a word.
2. You have to generate all abbreviations of that word.

Example -
Input -
    pep
Outputs -
    pep
    pe1
    p1p
    p2
    1ep
    1e1
    2p
    3

Explaination -
    p e p
    0 0 0   ->  pep
    0 0 1   ->  pe1
    0 1 0   ->  p1p
    0 1 1   ->  p2
    1 0 0   ->  1ep
    1 0 1   ->  1e1
    1 1 0   ->  2p
    1 1 1   ->  3

We cannot change 0s. If you two or more 1s are consecutive then add them.

*/


import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String str = scanner.nextLine();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        solution(str, "", 0, 0);
    }

    private static void solution(String str, String asf, int count, int pos) {      //asf - answer so far

        if (pos == str.length()) {
            if (count == 0){
                System.out.println(asf);
            }else {
                System.out.println(asf + count);
            }
            return;
        }

        //yes call
        if (count > 0){
            solution(str, asf + count + str.charAt(pos), 0, pos + 1);
        }else {
            solution(str, asf + str.charAt(pos), 0, pos + 1);
        }

        //no call
        solution(str, asf, count + 1, pos + 1);
    }
}






























