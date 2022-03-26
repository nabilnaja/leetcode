package graph.leetcode417;

import java.util.*;

public class Solution {
    private static final int[][] moves = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};

    private int rowsNumber;
    private int colNumbers;
    private int[][] heights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights.length==0 || heights[0].length == 0)
            return new ArrayList<>();

        this.heights = heights;
        rowsNumber = this.heights.length;
        colNumbers = this.heights[0].length;

        boolean[][] pacificReachable = new boolean[rowsNumber][colNumbers];
        boolean[][] atlanticReachable = new boolean[rowsNumber][colNumbers];

        for (int i = 0; i < rowsNumber; i++) {
            traverse(i, 0, pacificReachable);
            traverse(i, colNumbers - 1, atlanticReachable);
        }
        for (int i = 0; i < colNumbers; i++) {
            traverse(0, i, pacificReachable);
            traverse(rowsNumber - 1, i, atlanticReachable);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rowsNumber; i++) {
            for (int j = 0; j < colNumbers; j++) {
                if(pacificReachable[i][j] &&  atlanticReachable[i][j]){
                    result.add(List.of(i,j));
                }
            }
        }
        return result;

    }

    private void traverse(int row, int col, boolean[][] reachable){

        reachable[row][col] = true;

        for (int[] move : moves){
            int newRow = row + move[0];
            int newCol = col + move[1];

            if(newRow < 0 || newRow >= rowsNumber || newCol< 0 || newCol >= colNumbers)
                continue;

            if(reachable[newRow][newCol])
                continue;

            if(heights[newRow][newCol] < heights[row][col])
                continue;

            traverse(newRow, newCol, reachable);
        }
    }
}


