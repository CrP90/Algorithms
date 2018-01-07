/** This program checks a sudoku solution or solves a given sudoku game */

public class Sudoku {

    public static void main(String[] args) {
        int[][] array = {
                {9, 1, 4, 3, 7, 5, 2, 6, 8},
                {2, 8, 7, 4, 9, 6, 1, 5, 3},
                {3, 6, 5, 8, 1, 2, 4, 7, 9},
                {8, 4, 6, 5, 2, 1, 3, 9, 7},
                {5, 2, 9, 6, 3, 7, 8, 1, 4},
                {7, 3, 1, 9, 8, 4, 5, 2, 6},
                {1, 5, 3, 7, 4, 9, 6, 8, 2},
                {6, 9, 8, 2, 5, 3, 7, 4, 1},
                {4, 7, 2, 1, 6, 8, 9, 3, 5}
        };
        if(checkSudokuSolution(array))
            System.out.println("GJ");
        else
            System.out.println("Try again.");
    }

    /* This method checks if an 9x9 array of ints represents a valid solution
     * of a sudoku game. */
    static boolean checkSudokuSolution(int[][] grid)
    {
        if(checkRowsAndColumns(grid) && checkSqares(grid))
            return (true);
        return (false);
    }

    /* This method check every row and column of an 9x9 array of ints and returns true if
     * the values are unique for each row and column. */
    private static boolean checkRowsAndColumns(int[][] grid)
    {
        int	i;
        int j;
        /* checkRows and checkColumns keeps track of how many times a number has been
         * encountered on each row and column. */
        int[] checkRows = new int[10];
        int[] checkColumns = new int[10];

        i = 0;
        while(i < 9)
        {
            j = 0;
            while(j < 9)
            {
                if(grid[i][j] < 1 || grid[i][j] > 9 || grid[j][i] < 1 || grid[j][i] > 9)
                    return (false);
                if(checkRows[grid[i][j]] == i && checkColumns[grid[j][i]] == i)
                {
                    checkRows[grid[i][j]]++;
                    checkColumns[grid[j][i]]++;
                }
                else
                    return (false);
                j++;
            }
            i++;
        }
        return (true);
    }

    /* This method checks every 3x3 square of an 9x9 array of ints value and
     * return true if every value in each square is unique. */
    private static boolean checkSqares(int[][] grid)
    {
        int[] check = new int[10];

        for(int row = 0; row < 9; row += 3)
        {
            for(int col = 0; col < 9; col += 3)
            {
                for(int i = 0; i < 9; i++)
                {
                    if(check[grid[(i + row) % 3][(i + col) / 3]] != 0)
                        return (false);
                }
            }
        }
        return (true);
    }
}
