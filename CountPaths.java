public class CountPaths {

	public static void main(String[] args){
		boolean[][] grid = {
				{true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true},
		};
		int[][] paths = new int[grid.length][grid.length];
		System.out.println(countPaths(grid, 0, 0, paths));
	}
	
	static int countPaths(boolean[][] grid, int row, int col, int[][] paths)
	{
		if (!isValidSquare(grid, row, col))
			return (0);
		if (isAtEnd(grid, row, col))
			return (1);
		if (paths[row][col] == 0)
			paths[row][col] = countPaths(grid, row + 1, col, paths) + countPaths(grid, row, col + 1, paths);
		return (paths[row][col]);
	}
	
	static boolean isValidSquare(boolean[][] grid, int row, int col){
		return (row < grid.length && col < grid.length && grid[row][col]);
	}
	
	static boolean isAtEnd(boolean[][] grid, int row, int col){
		return ((row + 1 == grid.length) && (col + 1 == grid.length));
	}
}
