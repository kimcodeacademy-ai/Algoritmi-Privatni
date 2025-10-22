package ZadaciNizi;

import PodatocniStrukturi.Array;

import java.util.Scanner;

public class TestNiza {

    public static void main(String[] args) {
        Array<Integer> niza = new Array<>(10);

//        niza.insertLast(4);
//        niza.insertLast(3);
//        niza.insertLast(2);

        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();

        for(int i = 0; i < 10; i++){
            niza.insertLast(sc.nextInt());
        }

        System.out.println(niza.getSize());
        System.out.println(niza);

        niza.set(3, 100);
        niza.delete(7);

        System.out.println(niza.getSize());
        System.out.println(niza);

        niza.insert(6, 111);
        System.out.println(niza);

        niza.insertLast(115);
        niza.insertLast(200);
        System.out.println(niza);

        System.out.println(niza.find(6));
    }
}
