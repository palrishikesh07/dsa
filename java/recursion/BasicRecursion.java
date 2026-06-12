
class BasicRecursion {
    static int counter = 1;

    public static void printFn() {
        if (counter == 4) {
            return;
        }
        System.out.println(counter);
        counter++;
        printFn();
    }

    public static void main(String[] args) {
        printFn();
    }
}