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

        for (int i = 0; i < numInts.length - 1; i++) {
            numList.append(numInts[i]);

            int result = numInts[i] % 2 + numInts[i + 1] % 2;

            if (result==0
                    && numInts[i] != 0
                    && numInts[i + 1] != 0) {
                numList.append("*");
            }

            if (result==2
                    && numInts[i] != 0
                    && numInts[i + 1] != 0) {
                numList.append("-");
            }
        }
        numList.append(numInts[numInts.length - 1]);
        return numList.toString();
    }

}
