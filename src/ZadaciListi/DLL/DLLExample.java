package ZadaciListi.DLL;

import PodatocniStrukturi.DLL;
import PodatocniStrukturi.DLLNode;

import java.util.Scanner;

public class DLLExample {

    public static void main(String[] args) {
        DLL<Integer> lista = new DLL<Integer>();
        int N;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for(int i = 0; i < 15; i++){
            lista.insertLast(i);
        }

        System.out.println("Inicijalna lista: ");
        System.out.println(lista);

        lista.insertLast(9);
        System.out.println("Lisata posle dodavanje na 9 na posledna pozicija: ");
        System.out.println(lista);

        DLLNode<Integer> jazol = lista.find(9);
        lista.insertBefore(111, jazol);
        System.out.println("Lisata posle dodavanje na 111 pred prvata 9ka: ");
        System.out.println(lista);

        lista.insertAfter(112, jazol);
        System.out.println("Lisata posle dodavanje na 112 posle prvata 9ka: ");
        System.out.println(lista);

        DLLNode<Integer> jazol1 = lista.find(14);

        lista.delete(jazol1);
        System.out.println("Lisata posle brisenje na jazolot  so element 14 od listata: ");
        System.out.println(lista);

        System.out.println("Pecatenje na izbrisaniot jazol");
        System.out.println(jazol1.succ);
        System.out.println(jazol1.pred);


        //System.out.println(lista);
    }
}
