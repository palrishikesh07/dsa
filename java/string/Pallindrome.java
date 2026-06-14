class Pallindrome {
    public static void main(String[] args) {
        String str = "madam1";
        boolean checkPalindrome = isPalindrome(str);
        if (checkPalindrome) {
            System.out.println("Its a palindrome");
        } else {
            System.out.println("Not a palindrome");

        }
    }

    public static boolean isPalindrome(String str) {
        char[] arr = str.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
