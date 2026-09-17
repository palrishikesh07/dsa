
//Two Pointers
public class Ten_Valid_Palindrome {
    public static void main(String[] args) {

        String s = "A man, a plan, a canal: Panama";
        // BruteForceSolution bruteForceSolution = new BruteForceSolution();
        // System.out.println(bruteForceSolution.isPalindrome(s));

        TwoPointerApprach twoPointerApprach = new TwoPointerApprach();
        System.out.println(twoPointerApprach.isPalindrome(s));
    }
}

class BruteForceSolution {

    public boolean isPalindrome(String s) {

        StringBuilder cleanStr = new StringBuilder();

        // Step 1: Remove non-alphanumeric characters
        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                cleanStr.append(Character.toLowerCase(ch));
            }
        }

        // Step 2: Reverse
        String original = cleanStr.toString();
        String reverse = cleanStr.reverse().toString();

        // Step 3: Compare

        return original.equals(reverse);

    }
}

class TwoPointerApprach {

    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0;
        int right = n - 1;

        while (left < right) {

            // Skip non-alphanumeric characters
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters, if not maches return false
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return  false;
            }

            left++;
            right--;
        }
        return  true;

    }
}