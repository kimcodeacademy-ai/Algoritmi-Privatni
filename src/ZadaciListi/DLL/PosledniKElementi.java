//Дадена е двострано поврзана листа од цели броеви. Дополнително,
//даден е и уште еден природен број k. Последните k елементи од листата треба
//да се поместат на почетокот на листата, во истиот редослед.

//Влез: Во првиот ред од влезот е даден бројот на елементи во листата - N,
//па во следните следниот ред самите елементи одделени со празно место.
//
//На крај, во последниот ред даден е и природниот број k. (k<=N)
//Излез: На излез треба да се испечати листата пред и после промената.
//Input Result
//5
//1 2 3 4 5
//2
//1<->2<->3<->4<->5
//4<->5<->1<->2<->3
//4 1 3 5 7 4
//1<->3<->5<->7
//1<->3<->5<->7

package ZadaciListi.DLL;

import PodatocniStrukturi.DLL;
import PodatocniStrukturi.DLLNode;
import java.util.Scanner;

public class PosledniKElementi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        DLL<Integer> lista = new DLL<>();

        for (int i = 0; i < N; i++) {
            lista.insertLast(sc.nextInt());
        }

        int K = sc.nextInt();

        System.out.println(lista.toString());

        // Ako k == 0 ili K == N togash listata ostanuva ista
        if (K <= 0 || K >= N) {
            System.out.println(lista.toString());
            return;
        }

        DLLNode<Integer> first = lista.getFirst();
        DLLNode<Integer> tmp = lista.getLast(); // pocni od nazad za da gi zamenuvash so insert before i vmetnuvaj gi sekogash pred prviot
        int counter = 0;

        // se dodeka tmp != nuull ili counterot ne ja dostigne vrednosta na k
        // od nazad kon napred
        while (tmp != null && counter < K) {
            DLLNode<Integer> previous = tmp.pred;
            int value = tmp.element;

            lista.delete(tmp);
            lista.insertBefore(value, first); // vmetnuvaj pred incijaniot first

            first = lista.getFirst(); // zemi nov first
            tmp = previous;
            counter++; // osvezi counter za while ciklus
        }
        System.out.println(lista.toString());
    }
}
