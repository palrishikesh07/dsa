public class Classroom_Implicit_Graph {


    // 4 possible directions
    static int[][] directions = {
            {-1, 0}, // Up
            {1, 0},  // Down
            {0, -1}, // Left
            {0, 1}   // Right
    };

    public static void main(String[] args) {

        int[][] grid = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // Current position
        int row = 1;
        int col = 1;

        System.out.println("Current Cell = (" + row + "," + col + ")");
        System.out.println("Value = " + grid[row][col]);

        System.out.println("\nNeighbours:");

        for (int[] dir : directions) {

            int newRow = row + dir[0];
            int newCol = col + dir[1];

            // Boundary check
            if (newRow >= 0 &&
                newRow < grid.length &&
                newCol >= 0 &&
                newCol < grid[0].length) {

                System.out.println(
                        "(" + newRow + "," + newCol + ") -> " +
                        grid[newRow][newCol]);
            }
        }
    }
}