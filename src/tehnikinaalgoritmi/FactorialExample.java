package tehnikinaalgoritmi;

public class FactorialExample {

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Factorial of " + n + " = " + factorial(n));
    }

    static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int result = n * factorial(n - 1);
        return result;
    }


}