package AsimptotskaAnaliza;

import java.util.Scanner;

public class AsimptotskaAnalizaPrimer {

    // tuka pisuvame dopolnitelna staticka funkcija

    // psvm
    public static void main(String[] args) {
        // se izvrsuva kodot
        int n;
        char c;
        String bukva;

        // cin -> C++
        Scanner citaj = new Scanner(System.in);

        n = citaj.nextInt();

        // sout
        System.out.println("Primer tuka printam neshto");
        System.out.print("Blabla \n");
        System.out.print("Bukva");

        System.out.println(n);


        // Asimptotska Analiza

        int r;
        r = 15; // O(1)

        for(int i = 1; i <= n; i++){ // O(n)
            for(int j = 1; j <= r; j++){  // O(n^2)
                for(int p = 1; j <= r; j++){  // O(n^3)

                }
            }

            for(int k = 1; k < 5; k++){ // O(n^2)

            }
        }

        // slozenost na if/else:
        // slozenosta se odreduva taka sto se gleda delot od uslovot sto ima pogolema slozenost
        if(n%2==0){
            r = 1; // O(1)
        }
        else{
            for(int k = 1; k < 5; k++){ // O(N)

            }
        }

        // O(n^3)

        // O(1), O(logn), O(N), O(nlogn), O(N^2), .. , O(e^N)
    }
}


// Struktura na programa vo C++
//#include <iostream>
//using namespace std;
//
//int main(){
//    // sdassa
//    return 0;
//}
