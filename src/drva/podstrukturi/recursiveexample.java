package drva.podstrukturi;

import java.util.Scanner;


public class recursiveexample {

    public static int sum(int n){
        if (n==0){
            return 0;
        }

        return n + sum(n-1);
    }

    public static int prozivod(int n){
        if (n==1){
            return 1;
        }

        return n * prozivod(n-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = sum(n);
        int result1 = prozivod(n);
        System.out.println(result);
        System.out.println(result1);
    }

}

