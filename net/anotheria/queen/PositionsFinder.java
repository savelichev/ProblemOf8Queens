package net.anotheria.queen;

public class PositionsFinder {


    private static int[] positions = {0, 0, 0, 0, 0, 0, 0, 0};

    private static int rowIndex = 0;
    private static int fieldCount = 1;

    public static void main(String[] args) {


        while (positions[0] < 8) {

            if (isPositionValid()) {
                if (rowIndex == 7) {
                    printCurrentPositions();
                    positions[rowIndex]++;
                } else {
                    rowIndex++;
                }
            } else {
                positions[rowIndex]++;
            }
        }
    }

    static boolean isPositionValid() {

        if (rowIndex == 0) {
            return true;
        }

        if (positions[rowIndex] > 7) {
            positions[rowIndex] = 0;
            rowIndex--;
            return false;
        }

        for (int i = 0; i < rowIndex; i++) {
            if ((positions[rowIndex] == positions[i])
                    || ((Math.abs(positions[rowIndex] - positions[i])) == (rowIndex - i))) {
                return false;
            }
        }
        return true;
    }

    private static void printCurrentPositions() {
        int shiftToAlphabet = 97;

        System.out.println((fieldCount++) + ": "
                + (char) (positions[0] + shiftToAlphabet) + "1 "
                + (char) (positions[1] + shiftToAlphabet) + "2 "
                + (char) (positions[2] + shiftToAlphabet) + "3 "
                + (char) (positions[3] + shiftToAlphabet) + "4 "
                + (char) (positions[4] + shiftToAlphabet) + "5 "
                + (char) (positions[5] + shiftToAlphabet) + "6 "
                + (char) (positions[6] + shiftToAlphabet) + "7 "
                + (char) (positions[7] + shiftToAlphabet) + "8 ");
    }
}

