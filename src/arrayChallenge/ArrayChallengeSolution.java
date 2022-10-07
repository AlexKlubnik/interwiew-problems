package arrayChallenge;

import java.util.*;

public class ArrayChallengeSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(ArrayChallenge(array));
    }

    public static int ArrayChallenge(int[] array) {
        Map<Integer, Integer> temp = new LinkedHashMap<>();
        int valueOfMaxRepeats = array[0];
        int maxRepeats = 0;

        for (Integer num : array) {

            int tempRepeater = temp.getOrDefault(num, 0) + 1;

            temp.put(num, tempRepeater);

            if (tempRepeater > maxRepeats) {
                maxRepeats = tempRepeater;
                valueOfMaxRepeats = num;

            }
        }

        System.out.println(temp);
        if (maxRepeats == 1)
            return -1;
        else return valueOfMaxRepeats;
    }
}
