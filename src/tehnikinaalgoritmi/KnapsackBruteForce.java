package tehnikinaalgoritmi;

//Проблем: Максимална вредност во Knapsack (0/1 knapsack)
// treba da se maksizmizira vrednosta sto ja vrakame nazad, a da ne se nadminuva tezinata vnesena od tastatura

import java.util.Scanner;

public class KnapsackBruteForce {

    static int knapsack(int W, int[] wt, int[] val, int n){ // 50, {60, 100, 120}, {10, 20, 30}, 3
        // brute force resenie so kombinacija na divide - conquer
        if(n==0 || W == 0) return 0; // edge case
        if (wt[n-1] > W){ // edge case: koga tezinata na predmite ja nadminuvaat predivdenata tezina
            return knapsack(W, wt, val, n-1);
        }
        else{
            return Math.max(val[n-1] + knapsack(W - wt[n-1], wt, val, n-1), knapsack(W, wt, val, n-1));
            // vo prviot del povikuvame rekurzivno Vrednsota momentalna, + procesiranje od slendiot predmet. Vo vtoriot del samo procesiranje na sledniot predmet.
        }
    }
    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt(); // 50
        System.out.println(knapsack(W, wt, val, val.length));
    }

}
