//HashSet
// https://www.youtube.com/watch?v=dGZjzA9zLW8
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Seven_Valid_Sudoku {
    public static void main(String[] args) {
        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        char[][] board1 = {
                { '8', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        // SetApproach setApproach = new SetApproach();
        // System.out.println(setApproach.isValidSudoku(board));
        // System.out.println(setApproach.isValidSudoku(board1));

        Solution solution = new Solution();
        System.out.println(solution.isValidSudoku(board));
        System.out.println(solution.isValidSudoku(board1));

    }
}

class SetApproach {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        System.out.println("rows: " + Arrays.toString(rows));
        System.out.println("cols: " + Arrays.toString(cols));
        System.out.println("boxes: " + Arrays.toString(boxes));

        for (int r = 0; r < 9; r++) {

            for (int c = 0; c < 9; c++) {

                char value = board[r][c];

                if (value == '.') {
                    continue;
                }

                int boxIndex = (r / 3) * 3 + (c / 3);
                // Check if the value is already in the current row, column, or box
                if (!rows[r].add(value)
                        || !cols[c].add(value)
                        || !boxes[boxIndex].add(value)) {

                    return false;
                }
            }
        }
        return true;
    }
}

class Solution {

    // Function to validate one 3 x 3 box
    public boolean validBox( char[][] board,int startRow,int endRow,int startCol,int endCol) {

        HashSet<Character> set = new HashSet<>();

        for (int row = startRow; row <= endRow; row++) {

            for (int col = startCol; col <= endCol; col++) {

                char value = board[row][col];

                // Ignore empty cell
                if (value == '.') {
                    continue;
                }

                // Duplicate found
                if (set.contains(value)) {
                    return false;
                }

                set.add(value);
            }
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {

        // --------------------------------
        // 1. Validate ROWS
        // --------------------------------

        for (int row = 0; row < 9; row++) {

            HashSet<Character> set = new HashSet<>();

            for (int col = 0; col < 9; col++) {

                char value = board[row][col];

                if (value == '.') {
                    continue;
                }

                if (set.contains(value)) {
                    return false;
                }

                set.add(value);
            }
        }

        // --------------------------------
        // 2. Validate COLUMNS
        // --------------------------------

        for (int col = 0; col < 9; col++) {

            HashSet<Character> set = new HashSet<>();

            for (int row = 0; row < 9; row++) {

                char value = board[row][col];

                if (value == '.') {
                    continue;
                }

                if (set.contains(value)) {
                    return false;
                }

                set.add(value);
            }
        }

        // --------------------------------
        // 3. Validate 3 x 3 BOXES
        // --------------------------------

        for (int startRow = 0; startRow < 9; startRow += 3) {

            int endRow = startRow + 2;

            for (int startCol = 0; startCol < 9; startCol += 3) {

                int endCol = startCol + 2;

                // Call separate function
                if (!validBox(board, startRow, endRow, startCol, endCol)) {
                    return false;
                }
            }
        }

        return true;
    }
}