package net.anotheria.queen;

public class ProblemOf8Queens {


    private static int[] field = {0, 0, 0, 0, 0, 0, 0, 0};

    private static int index = 0;
    private static int fieldNumber = 1;

    public static void main(String[] args) {

        int ShiftToAlphabet = 65;

        while (field[0] < 8) {

            if (isPositionValid()) {
                if (index == 7) {
                    System.out.println((fieldNumber++) + ": "
                            + (char) (field[0] + ShiftToAlphabet) + "1 "
                            + (char) (field[1] + ShiftToAlphabet) + "2 "
                            + (char) (field[2] + ShiftToAlphabet) + "3 "
                            + (char) (field[3] + ShiftToAlphabet) + "4 "
                            + (char) (field[4] + ShiftToAlphabet) + "5 "
                            + (char) (field[5] + ShiftToAlphabet) + "6 "
                            + (char) (field[6] + ShiftToAlphabet) + "7 "
                            + (char) (field[7] + ShiftToAlphabet) + "8 ");
                    field[index]++;
                } else {
                    index++;
                }
            } else {
                field[index]++;
            }
        }
    }

    static boolean isPositionValid() {

        if (index == 0) {
            return true;
        }

        if (field[index] > 7) {
            field[index] = 0;
            index--;
            return false;
        }

        for (int i = 0; i < index; i++) {
            if ((field[index] == field[i]) || ((Math.abs(field[index] - field[i])) == (index - i))) {
                return false;
            }
        }

        return true;
    }
}

