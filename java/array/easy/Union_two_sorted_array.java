import java.util.ArrayList;
import java.util.List;

public class Union_two_sorted_array {

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 4, 5, 6 };
        int[] arr2 = { 2, 3, 5, 7, 8, 8, 9, 10, 10, 11 };

        List<Integer> union = findUnion(arr1, arr2);

        System.out.print("Union of the two arrays: ");
        for (int num : union) {
            System.out.print(num + " ");
        }
    }

    public static List<Integer> findUnion(int[] arr1, int[] arr2) {
        int arr1_length = arr1.length;
        int arr2_length = arr2.length;
        List<Integer> UnionList = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < arr1_length && j < arr2_length) {
            if (arr1[i] < arr2[j]) {
                // Add if empty or not duplicate
                if (UnionList.isEmpty() || UnionList.get(UnionList.size() - 1) != arr1[i]) {
                    UnionList.add(arr1[i]);
                    i++;
                }
            } else if (arr2[j] < arr1[i]) {
                if (UnionList.isEmpty() || UnionList.get(UnionList.size() - 1) != arr2[j]) {
                    UnionList.add(arr2[j]);
                    j++;
                }
            } else {
                if (UnionList.isEmpty() || UnionList.get(UnionList.size() - 1) != arr1[i]) {
                    UnionList.add(arr1[i]);

                }
                i++;
                j++;
            }

        }
        // Append remaining elements from arr1
        while (i < arr1_length) {
            if (UnionList.isEmpty() || UnionList.get(UnionList.size() - 1) != arr1[i]) {
                UnionList.add(arr1[i]);
            }
            i++;

        }
        while (j < arr2_length) {
            if (UnionList.isEmpty() || UnionList.get(UnionList.size() - 1) != arr2[j]) {
                UnionList.add(arr2[j]);
            }
            j++;

        }

        return UnionList;

    }

}