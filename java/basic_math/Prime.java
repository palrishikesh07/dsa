public class Prime {
    public static boolean checkPrime(int n) {
        int count = 0;

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                count++;
                System.out.println("O i: "+i);
                System.out.println("O n: "+n/i);
                if (n / i != i) {
                    System.out.println("i: "+i);
                    System.out.println("n: "+n/i);
                    count++;
                }
            }
        }
        System.out.println(count);
        return count == 2;
    }

    public static void main(String[] args) {
        int n = 19;
        boolean isPrime = checkPrime(n);
        if (isPrime) {
            System.out.println(n + " is a prime number.");
        } else {
            System.out.println(n + " is not a prime number.");
        }
    }
}
