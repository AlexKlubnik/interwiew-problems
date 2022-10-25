package PairsChallenge;

import java.util.*;

public class PairsSolution {

    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(2, 3, 4, 6, 7, 4, 5, 3, 1);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number, which should be sum of two ints from the list...");
        int number = scanner.nextInt();
        scanner.close();
        System.out.println(getPairsOfSum(nums, number));

    }

    private static Map<Integer,Integer> getPairsOfSum(List<Integer> nums, int number) {
        Map<Integer,Integer> pairs = new LinkedHashMap<>();
        Set<Integer> tempSet = new HashSet<>();

        for (int currentNum : nums) {
            int difference = number - currentNum;
            if (!tempSet.contains(difference)) {
                tempSet.add(currentNum);
            } else pairs.put(currentNum, difference);
        }
        return pairs;
    }

//    private static Map<Integer, Integer> getPairsOfSum(List<Integer> nums, int number) {
//        Map<Integer, Integer> pairs = new LinkedHashMap<>();
//
//        for (int i = 0; i < nums.size(); i++) {
//            for (int j = i + 1; j < nums.size(); j++) {
//                if (nums.get(i) + nums.get(j) == number) {
//                    pairs.put(nums.get(i), nums.get(j));
//                }
//            }
//        }


//        return pairs;
//    }
}
