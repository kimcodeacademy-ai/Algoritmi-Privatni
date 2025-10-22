package ZadaciNizi;

//За дадена низа од N (1<=N<=50) природни броеви да се избришат дупликат
//вредностите кои се jавуваат на соседни позии. Односно доколку две и пове´ке
//вредности се една до друга во низата, да се остави само едно поjавување.
//На пример низата 1, 2, 2, 2, 3, 2, 4, 4, 1 по обработката ´ке биде 1, 2, 3, 2, 4, 1.
//Првиот броj од влезот е броjот на елементи во низата N, а потоа во секоj ред
//се дадени броевите.

import PodatocniStrukturi.Array;
import java.util.Scanner;

public class BrisiDupli {

    public static Array<Integer> findDuplicates(Array<Integer> arr, int n){
        for(int i = 0; i < arr.getSize(); i++){
            if(i+1 < arr.getSize()) {
                if (arr.get(i).equals(arr.get(i + 1))) {
                    arr.delete(i);
                    i--;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {

        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        Array<Integer> testNiza = new Array<>(n);
        for(int i=0;i<n;i++) {
            testNiza.insertLast(sc.nextInt());
//            testNiza.insert(i, sc.nextInt());
        }

        System.out.println(testNiza);

        testNiza = BrisiDupli.findDuplicates(testNiza, n);
        System.out.println(testNiza);

    }
}
