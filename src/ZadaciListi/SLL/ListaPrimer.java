package ZadaciListi.SLL;

import PodatocniStrukturi.SLL;
import PodatocniStrukturi.SLLNode;

public class ListaPrimer {
    public static void main(String[] args) {

        SLL<Integer> primerLista = new SLL<Integer>();

        primerLista.insertLast(3);
        primerLista.insertLast(2);
        primerLista.insertLast(100);
        primerLista.insertFirst(72);

        SLLNode<Integer> insA = primerLista.find(3);
        primerLista.insertAfter(55, insA);

        SLLNode<Integer> insB = primerLista.find(100);
        primerLista.insertBefore(65, insB);

        System.out.println(primerLista);

        // posle 3tiot element vo listata - posle indeks 2
        SLLNode<Integer> tmp = primerLista.getFirst();
        int counter = 1;
        while (tmp.succ != null && counter < 2) {
            tmp = tmp.succ;
            counter++;
        }
        primerLista.insertAfter(43, tmp);
        System.out.println(primerLista);

        primerLista.delete(tmp);
        System.out.println(primerLista);

        System.out.println(primerLista.size());

    }
}
