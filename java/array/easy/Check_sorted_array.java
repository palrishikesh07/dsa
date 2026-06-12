
public class Check_sorted_array {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        boolean isSortedArray = isSorted(arr);
        if (isSortedArray) {
            System.out.println("Array is sorted");

        } else {
            System.out.println("Array is Not a sorted");

        }

    }

    public static boolean isSorted(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
