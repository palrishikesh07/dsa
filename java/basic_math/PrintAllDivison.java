import java.util.*;

public class PrintAllDivison {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        // printDivisors(num);
        printDivisorOptmizal(num);
    }

    public static void printDivisors(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i);
            }
        }
    }

    public static void printDivisorOptmizal(int n){
        List<Integer> res = new ArrayList<>();

        for(int i=1; i * i <=n; i++){
            if(n%i == 0){
                res.add(i);
            }
            // If N / i is different from i, add N / i too

            if(i != n/i){
                res.add(n/i);
            }
        }

        res.sort(Integer::compareTo);

        for(int val: res){
            System.out.print(val+" ");
        }
    }
}
