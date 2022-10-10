package stringModificationChallenge;

public class StringModSolution {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";
        System.out.println(isOneModification(str1, str2));
    }

    private static boolean isOneModification(String string1, String string2) {

        int lengthSubtraction = Math.abs(string1.length() - string2.length());
        boolean result=false;

        if (lengthSubtraction > 1) {
            return false;

        } else if (lengthSubtraction == 0) {
            result = countDiffSymbols(string1, string2) <= 1;

        } else {
            String smallString = getSmallestString(string1, string2);
            String bigString = getBiggestString(string1, string2);
            if (countSimilarSymbols(smallString, bigString) == smallString.length()
                    || countSimilarSymbols(smallString, bigString) == smallString.length()+1)
                result = true;
        }
        return result;
    }

    private static String getSmallestString(String string1, String string2) {
        return string1.length() - string2.length() < 0 ? string1 : string2;
    }

    private static String getBiggestString(String string1, String string2) {
        return string1.length() - string2.length() > 0 ? string1 : string2;
    }

    private static int countDiffSymbols(String string1, String string2) {
        char[] charArr1 = string1.toCharArray();
        char[] charArr2 = string2.toCharArray();
        int modifyCounter = 0;

        for (int i = 0; i < string1.length(); i++) {
            if (charArr1[i] != charArr2[i]) {
                modifyCounter++;
            }
            if (modifyCounter > 1)
                break;
        }
        return modifyCounter;
    }

    private static int countSimilarSymbols(String smallString, String bigString) {
        int similarSymbolCounter = 0;
        char[] smallArray = smallString.toCharArray();
        char[] bigArray = bigString.toCharArray();

        for (int i = 0; i < smallArray.length; i++) {
            for (int j = i; j < bigArray.length; j++) {
                if (smallArray[i] == bigArray[j]) {
                    similarSymbolCounter++;
                }
                if (similarSymbolCounter > smallArray.length) {
                    break;
                }
            }
        }
        return similarSymbolCounter;
    }
}
