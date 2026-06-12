class NumberOfDigit {
    public static void main(String[] args) {
        int number = 12345;
        // int digitCount = countDigits(number);
        // System.out.println("Number of digits in " + number + " is: " + digitCount);
        System.out.println("Number of digits with log10: " + number + " is: " + (int)(Math.log10(number) + 1));
    }

    public static int countDigits(int num) {
        if (num == 0) {
            return 1; // Special case for 0
        }
        int count = 0;
        while (num != 0) {
            num /= 10; // Remove the last digit
            count++;
        }
        return count;
    }
}