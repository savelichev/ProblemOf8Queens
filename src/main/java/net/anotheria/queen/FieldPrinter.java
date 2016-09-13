package net.anotheria.queen;


/**
 * Print combination of the queens and counter of combination.
 */
public class FieldPrinter {


    /**
     * Print into the console.
     *
     * @param positions  queens combination.
     * @param fieldCount counter of combination.
     */
    public void printToConsole(int[] positions, int fieldCount) {

        System.out.println("Combination: " + fieldCount);
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
