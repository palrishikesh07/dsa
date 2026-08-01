//https://leetcode.com/problems/product-of-array-except-self/description/   

import java.util.Arrays;

public class Product_of_Array_Except_Self {

    public static void main(String[] args) {
        int[] arr = { 8, 10, 2 };
        int[] result = arrayOfArrayProducts(arr);
        System.out.println(Arrays.toString(result));
    }

    static int[] arrayOfArrayProducts(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int productValue = 1;
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                productValue = productValue * arr[j];
            }
            result[i] = productValue;
        }
        return result;
    }

}
