// podeli ja listata na dve drugi listi: neparna i parna lista
package ZadaciListi.SLL;

import PodatocniStrukturi.SLL;
import PodatocniStrukturi.SLLNode;

import java.util.Scanner;

public class PodeliParniNeparni {

    public static SLL<Integer> splitEven(SLL<Integer> lista){
        SLL<Integer> parnaLista = new SLL<Integer>();
        SLLNode<Integer> tmp = lista.getFirst();
//        while(tmp.succ != null){
//            if(tmp.element % 2 == 0){
//                parnaLista.insertLast(tmp.element);
//            }
//        }
//        if(tmp.element % 2 == 0){
//            parnaLista.insertLast(tmp.element);
//        }

        while(tmp != null){
            if(tmp.element % 2 == 0){
                parnaLista.insertLast(tmp.element);
            }
            tmp = tmp.succ;
        }
        return parnaLista;
    }

    public static SLL<Integer> splitOdd(SLL<Integer> lista){
        SLL<Integer> neparnaLista = new SLL<Integer>();
        SLLNode<Integer> tmp = lista.getFirst();
//        while(tmp.succ != null){
//            if(tmp.element % 2 == 0){
//                neparnaLista.insertLast(tmp.element);
//            }
//        }
//        if(tmp.element % 2 == 0){
//            neparnaLista.insertLast(tmp.element);
//        }

        while(tmp != null){
            if(tmp.element % 2 != 0){
                neparnaLista.insertLast(tmp.element);
            }
            tmp = tmp.succ;
        }
        return neparnaLista;
    }
    public static void main(String[] args) {
        SLL<Integer> lista = new SLL<Integer>();
        Scanner sc = new Scanner(System.in);
        int N;
        N = sc.nextInt();
        // polnenje na lista
        for(int i = 0; i < N; i++){
            lista.insertLast(sc.nextInt());
        }

        System.out.println("Celata lista izgleda vaka: ");
        System.out.println(lista);

        System.out.println("Parnata lista izgleda vaka: ");
        System.out.println(splitEven(lista));

        System.out.println("Neparnata lista izgleda vaka: ");
        System.out.println(splitOdd(lista));
    }
}
