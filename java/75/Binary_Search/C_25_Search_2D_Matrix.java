
public class C_25_Search_2D_Matrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 3;

        BruteForce bruteForce = new BruteForce();
        System.out.println(bruteForce.searchMatrix(matrix, target));

        BinarySearchMatrix binarySearchMatrix = new BinarySearchMatrix();
        System.out.println(binarySearchMatrix.searchMatrix(matrix, target));

        SingleArrayBinary singleArrayBinary = new SingleArrayBinary();
        System.out.println(singleArrayBinary.searchMatrix(matrix, target)); 

    }
}

class BruteForce {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        for (int row = 0; row < rowLength; row++) {

            for (int col = 0; col < colLength; col++) {
                if (matrix[row][col] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}

class BinarySearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        for (int[] row : matrix) {
            int left = 0;
            int right = row.length - 1;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (row[mid] == target) {
                    return true;
                }

                if (row[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}

class SingleArrayBinary {

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int row = mid / cols;
            int col = mid % cols;
            int value = matrix[row][col];

            if (value == target) {
                return true;
            }

            if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;

    }
}