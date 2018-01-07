/** Programming exercises with arrays and ArrayList. */

public class MagicSquare {

    public static void main(String[] args) {
        int[][] array = {
                {16, 3, 2, 13},
                {5, 10, 11, 8},
                {9, 6, 7, 12},
                {4, 15, 14, 1}
        };
        if(isMagicSquare(array)){
            System.out.println("Is magic square!");
        } else System.out.println("Try again.");
    }

    /** This method tests to see whether an NxN array contains a magic square. */
    static boolean isMagicSquare(int[][] array) {
        int sum = 0;	//stores sum of first row.
        for (int i = 0; i < array[0].length; i++){
            sum += array[0][i];
        }
        /* Check the other rows, the columns and diagonals if equal with sum. */
        if(checkRows(array, sum)) {
            if(checkColumns(array, sum)) {
                if(checkDiagonals(array, sum))
                    return true;
            }
        }
        return false;
    }
    /* This method returns true if every row(less the first one) in an array is
     * equal with a sentinel. */
    private static boolean checkRows(int[][] array, int sentinel) {
        for (int i = 1; i < array.length; i++) {
            int sum = 0;
            for (int j = 0; j < array[1].length; j++) {
                sum += array[i][j];
            }
            if (sum != sentinel) return false;
        }
        return true;
    }

    /* This method returns true if every column in an array is equal with a sentinel. */
    private static boolean checkColumns(int[][] array, int sentinel) {
        for (int i = 0; i < array[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < array.length; j++) {
                sum += array[j][i];
            }
            if (sum != sentinel) return false;
        }
        return true;
    }

    /* This method returns true if the diagonals in an array are equal with a sentinel. */
    private static boolean checkDiagonals(int[][] array, int sentinel) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i][i];	//first diagonal
            if (i == array.length - 1){
                if (sum != sentinel) {
                    return false;
                } else {
                    sum = 0;
                    for (int j = 0; j < array.length; j++){
                        sum += array[j][i-j]; //second diagonal
                    }
                    if (sum != sentinel) return false;
                }
            }
        }
        return true;
    }
}
