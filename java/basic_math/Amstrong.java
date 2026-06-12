
public class Amstrong {
    public static void main(String[] args) {
        // int number = 153;
        int number = 100;
        boolean reversed = checkAmstrong(number);
        System.out.println("Reversed number of " + number + " is: " + reversed);
    }

    public static boolean checkAmstrong(int num) {
        int reversedNumber = 0;
        int dupNum = num;
        int sum = 0;
        while (num > 0) {
            int ld = num % 10;
            sum = sum + (ld * ld * ld);
            reversedNumber = (reversedNumber * 10) + ld;
            num = num / 10;
        }
        return dupNum == sum ? true : false;
    }
}
