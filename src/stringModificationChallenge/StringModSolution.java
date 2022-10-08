package stringModificationChallenge;

public class StringModSolution {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";
        System.out.println(isModifiable(str1, str2));
    }

    private static boolean isModifiable(String string1, String string2) {

        int lengthSubtraction = Math.abs(string1.length() - string2.length());
        boolean result = false;

        if (lengthSubtraction >= 2) {
            return result;
        } else if (lengthSubtraction == 0) {
            char[] charArr1 = string1.toCharArray();
            char[] charArr2 = string2.toCharArray();
            int modifyCounter = 0;

            for (int i = 0; i < string1.length(); i++) {
                if (charArr1[i] != charArr2[i]) {
                    modifyCounter++;
                }
            }
            result = modifyCounter <= 1;
        } else if (lengthSubtraction == 1) {
            int similarSymbolCounter = 0;
            char[] smallArray = getSmallestArray(string1, string2);
            char[] bigArray = getBiggestArray(string1, string2);

            for (char char1 : smallArray) {
                for (char char2 : bigArray) {
                    if (char1 == char2) {
                        similarSymbolCounter++;
                    }
                }
            }
            result = similarSymbolCounter == smallArray.length;
        }
        return result;
    }

    private static char[] getSmallestArray(String string1, String string2) {
        return string1.length() - string2.length() < 0 ? string1.toCharArray() : string2.toCharArray();
    }

    private static char[] getBiggestArray(String string1, String string2) {
        return string1.length() - string2.length() > 0 ? string1.toCharArray() : string2.toCharArray();
    }
}
