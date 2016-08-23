package net.anotheria.queen;

public class PositionsFinder {


    private int[] positions = {0, 0, 0, 0, 0, 0, 0, 0};

    private int rowIndex = 0;

    private int fieldCount = 1;


    public void findPositions() {


        while (positions[0] < 8) {

            if (isPositionValid()) {
                if (rowIndex == 7) {
                    printCurrentPositionsAsMatrix();
                    positions[rowIndex]++;
                } else {
                    rowIndex++;
                }
            } else {
                positions[rowIndex]++;
            }
        }
    }

    private boolean isPositionValid() {

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

//    private void printCurrentPositions() {
//        int shiftToAlphabet = 97;
//
//        System.out.println((fieldCount++) + ": "
//                + (char) (positions[0] + shiftToAlphabet) + "1 "
//                + (char) (positions[1] + shiftToAlphabet) + "2 "
//                + (char) (positions[2] + shiftToAlphabet) + "3 "
//                + (char) (positions[3] + shiftToAlphabet) + "4 "
//                + (char) (positions[4] + shiftToAlphabet) + "5 "
//                + (char) (positions[5] + shiftToAlphabet) + "6 "
//                + (char) (positions[6] + shiftToAlphabet) + "7 "
//                + (char) (positions[7] + shiftToAlphabet) + "8 ");
//    }

    private void printCurrentPositionsAsMatrix() {
        System.out.println("Combination: " + fieldCount++);
        int[][] board = new int[8][8];


        for (int i = 0; i < positions.length; i++) {
            board[i][positions[i]] = 1;
        }

        for (int i = 0; i < 8; i++) {
            System.out.print(i + 1 + "  ");
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("   a b c d e f g h");
        System.out.println();
    }
}

