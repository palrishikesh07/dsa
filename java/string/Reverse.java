
public class Reverse {
    public static void main(String[] args) {
        String str = "hello";
        System.out.println(reverseString(str)); // olleh
    }

    public static String reverseString(String str){
        char[] arr = str.toCharArray();
        int length = arr.length;
        int left = 0;
        int right = length -1;
        
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = (char)temp;
            left++;
            right--;
        }
        
        return new String(arr);
    }
}
