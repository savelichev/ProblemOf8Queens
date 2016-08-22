package net.anotheria.queen;

public class PositionsFinder {


    private static int[] positions = {0, 0, 0, 0, 0, 0, 0, 0};

    private static int rowIndex = 0;
    private static int fieldCount = 1;

    public static void main(String[] args) {

        int ShiftToAlphabet = 65;

        while (positions[0] < 8) {

            if (isPositionValid()) {
                if (rowIndex == 7) {
                    System.out.println((fieldCount++) + ": "
                            + (char) (positions[0] + ShiftToAlphabet) + "1 "
                            + (char) (positions[1] + ShiftToAlphabet) + "2 "
                            + (char) (positions[2] + ShiftToAlphabet) + "3 "
                            + (char) (positions[3] + ShiftToAlphabet) + "4 "
                            + (char) (positions[4] + ShiftToAlphabet) + "5 "
                            + (char) (positions[5] + ShiftToAlphabet) + "6 "
                            + (char) (positions[6] + ShiftToAlphabet) + "7 "
                            + (char) (positions[7] + ShiftToAlphabet) + "8 ");
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
}

