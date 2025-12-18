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

        for(int i = 0; i < N; i++){
            lista.insertLast(sc.nextInt());
        }

        System.out.println(lista);

        int K = sc.nextInt();

        if (K >= N){
            System.out.println(lista);
            return;
        }

        DLLNode<Integer> tmp = lista.getLast();
        int counter = 0;

        while(counter < K && tmp != null){
            //DLLNode<Integer> current = tmp;
            lista.delete(tmp);
            lista.insertFirst(tmp.element);

            tmp = tmp.pred;
            counter++;
        }

        System.out.println(lista);
    }
}
