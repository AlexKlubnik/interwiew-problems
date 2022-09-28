package stringChallenge;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print(StringChallenge(scan.nextLine()));
    }

    public static String StringChallenge(String num) {

        String[] numStrings = num.split("");
        int[] numInts = new int[numStrings.length];

        for (int i = 0; i < numInts.length; i++) {
            numInts[i] = Integer.parseInt(numStrings[i]);
        }

        StringBuilder numList = new StringBuilder();

        for (int i = 0; i < numInts.length; i++) {
            numList.append(numInts[i]);

            if (i != numInts.length - 1
                    && numInts[i] % 2 == 0
                    && numInts[i + 1] % 2 == 0
                    && numInts[i] != 0
                    && numInts[i + 1] != 0) {
                numList.append("*");
            }

            if (i != numInts.length - 1
                    && numInts[i] % 2 == 1
                    && numInts[i + 1] % 2 == 1
                    && numInts[i] != 0
                    && numInts[i + 1] != 0
                    && i != numInts.length - 1) {
                numList.append("-");
            }

        }
        return numList.toString();
    }

}
