package net.anotheria.queen;

import net.anotheria.queen.writer.ConsoleWriter;
import net.anotheria.queen.writer.DBWriter;
import net.anotheria.queen.writer.IWriter;

/**
 * Finds all possible combinations of the queens on the board when there no queen under attack.
 */
public class PositionsFinder {

    /**
     * Array of queens position on board.
     * index of element is the row number, values is the column number.
     */
    private int[] positions = {0, 0, 0, 0, 0, 0, 0, 0};

    /**
     * Index of current row.
     */
    private int rowIndex;

    /**
     * Size of board.
     */
    private int boardSize = 8;

    /**
     * Object of Field printer prints current field.
     */
    private IWriter resultWriter = new DBWriter();


    /**
     * Finds all possible combinations of the queens.
     */
    public void findPositions() {


        while (positions[0] < boardSize) {

            if (isPositionValid()) {
                if (rowIndex == boardSize - 1) {

                    resultWriter.write(positions);
                    positions[rowIndex]++;
                } else {
                    rowIndex++;
                }
            } else {
                positions[rowIndex]++;
            }


        }
    }

    //Checks that current position of the queen in't under attack  of other queens.
    //Return boolean value: "true" if position valid, "false" if under attack.
    private boolean isPositionValid() {

        if (rowIndex == 0) {
            return true;
        }


        //Checking is  column value bigger than board size,
        //if true, it means that there no possible positions for queen
        //and it needs to step back.
        if (positions[rowIndex] > boardSize - 1) {
            positions[rowIndex] = 0;
            rowIndex--;
            return false;
        }


        //Checking that column and diagonals is not under attack
        for (int i = 0; i < rowIndex; i++) {
            if ((positions[rowIndex] == positions[i])
                    || ((Math.abs(positions[rowIndex] - positions[i])) == (rowIndex - i))) {
                return false;
            }
        }
        return true;
    }

}

