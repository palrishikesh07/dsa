
public class Pallindrome {
    
    public static void main(String[] args) {
        int number = 12321;
        boolean reversed = checkPallindrome(number);
        System.out.println("Reversed number of " + number + " is: " + reversed);
    }

    public static boolean checkPallindrome(int num) {
        int reversedNumber= 0;
        int dupNum = num;
        while (num > 0) {
            int ld = num % 10;
            reversedNumber  = (reversedNumber * 10) +ld;
            num = num/10;
        }
        return dupNum == reversedNumber ? true : false;
    }
}
