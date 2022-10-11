package stringModificationChallenge;

public class StringModSolution {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abcd";
        System.out.println(isOneModification(str1, str2));
    }

    private static boolean isOneModification(String string1, String string2) {

        int lengthSubtraction = Math.abs(string1.length() - string2.length());
        boolean result;

        if (lengthSubtraction > 1) {
            return false;
        }
        if (lengthSubtraction == 0) {
            result = countDiffSymbols(string1, string2) <= 1;

        } else {
            String smallString = getSmallestString(string1, string2);
            String bigString = getBiggestString(string1, string2);
            result = countDiffSymbols2(smallString, bigString) == 1;
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
        int diffSymbolCounter = 0;

        for (int i = 0; i < string1.length(); i++) {
            if (charArr1[i] != charArr2[i]) {
                diffSymbolCounter++;
            }
            if (diffSymbolCounter > 1)
                break;
        }
        return diffSymbolCounter;
    }

    private static int countDiffSymbols2(String smallString, String bigString) {
        int diffSymbolCounter = 0;
        char[] smallArray = smallString.toCharArray();
        char[] bigArray = bigString.toCharArray();
        int smallArrayPos = 0;

        for (char c : bigArray) {
            if (c == smallArray[smallArrayPos]) {
                if (smallArrayPos < smallArray.length - 1)
                    smallArrayPos++;
            } else
                diffSymbolCounter++;

            if (diffSymbolCounter > 1)
                break;
        }
        return diffSymbolCounter;
    }
}
