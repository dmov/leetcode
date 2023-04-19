class Solution {
    public int numIslands(char[][] grid) {
        int counter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    counter++;
                    sinkTheWholeIsland(grid, i, j);
                }
            }
        }

        return counter;
    }

    private void sinkTheWholeIsland(char[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length
                && j >= 0 && j < grid[0].length
                && grid[i][j] == '1') {
            grid[i][j] = '0';
            sinkTheWholeIsland(grid, i + 1, j);
            sinkTheWholeIsland(grid, i - 1, j);
            sinkTheWholeIsland(grid, i, j + 1);
            sinkTheWholeIsland(grid, i, j - 1);
        }
    }
}