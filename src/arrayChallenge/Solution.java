package arrayChallenge;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(ArrayChallenge(array));
    }

    public static int ArrayChallenge(int[] array) {
        Map<Integer, Integer> temp = new HashMap<>();
        int valueOfMaxRepeats = array[0];
        int maxRepeats = 0;

        for (Integer num : array) {

            if (temp.containsKey(num)) {
                int tempRepeater = temp.get(num) + 1;
                temp.put(num, tempRepeater);
                if (tempRepeater >= maxRepeats) {
                    maxRepeats = tempRepeater;
                    valueOfMaxRepeats = num;
                }
            } else {
                temp.put(num, 1);
            }
        }
        System.out.println(temp);
        if (maxRepeats == 0)
            return -1;
        else return valueOfMaxRepeats;
    }
}
