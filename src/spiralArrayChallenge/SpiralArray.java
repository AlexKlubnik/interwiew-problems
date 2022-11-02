package spiralArrayChallenge;

public class SpiralArray {

    public static void main(String[] args) {
        int[][] spiralArray = new int[10][10];

        int coordinateX = 0;
        int coordinateY = 0;
        int diagIndex = 0;
        int number = 0;


        fillSpiralArray(spiralArray, coordinateX, coordinateY, diagIndex, number);

        for (int i = 0; i < spiralArray.length; i++) {
            System.out.println(" ");
            for (int j = 0; j < spiralArray.length; j++) {
                System.out.print(spiralArray[i][j] + "      ");
            }
        }
    }

    public static int[][] fillSpiralArray(int[][] spiralArray, int x, int y, int diagIndex, int number) {

        int length = spiralArray.length;

        if (spiralArray[length  / 2][(length - 1)/ 2] != 0) {
            return spiralArray;
        }


        if (x == diagIndex && y < length - diagIndex - 1) {
            spiralArray[x][y] = number;
            y++;
            number++;
            return fillSpiralArray(spiralArray, x, y, diagIndex, number);
        }
        if (x < length - diagIndex - 1 && y == length - diagIndex - 1) {
            spiralArray[x][y] = number;
            x++;
            number++;
            return fillSpiralArray(spiralArray, x, y, diagIndex, number);
        }
        if (x == length - diagIndex - 1 && y > diagIndex) {
            spiralArray[x][y] = number;
            y--;
            number++;
            return fillSpiralArray(spiralArray, x, y, diagIndex, number);
        }

        if (x >= diagIndex && y == diagIndex) {
            spiralArray[x][y] = number;
            x--;
            number++;

            if (x == diagIndex) {
                diagIndex++;
                x = diagIndex;
                y = diagIndex;
            }

            return fillSpiralArray(spiralArray, x, y, diagIndex, number);
        }

        return spiralArray;
    }
}
