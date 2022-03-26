package graph.leetcode200;

public class Solution {
    private static final int[][] moves = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    private static final char UNVISITED_ISLAND = '1';
    private static final char VISITED_ISLAND_OR_VISITED = '0';

    private int rowsNumber;
    private int colsNumber;

    public int numIslands(char[][] grid) {
        if (grid == null || grid[0].length == 0)
            return 0;

        rowsNumber = grid.length;
        colsNumber = grid[0].length;

        int islandsCount = 0;

        for (int i = 0; i < rowsNumber; i++) {
            for (int j = 0; j < colsNumber; j++) {
                if (grid[i][j] == UNVISITED_ISLAND) {
                    islandsCount++;
                    traverse(i, j, grid);
                }
            }
        }
        return islandsCount;
    }

    private void traverse(int row, int col, char[][] grid) {

        grid[row][col] = VISITED_ISLAND_OR_VISITED;

        for (int[] move : moves) {
            int newRow = row + move[0];
            int newCol = col + move[1];

            if (newRow < 0 || newRow >= rowsNumber || newCol < 0 || newCol >= colsNumber || grid[newRow][newCol] == VISITED_ISLAND_OR_VISITED)
                continue;

            traverse(newRow, newCol, grid);
        }
    }
}


