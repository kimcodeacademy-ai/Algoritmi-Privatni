package ZadaciListi.DLL;

//Задача: За дадена листа од N цели броеви, отстрани го првиот и последниот елемент, потоа испечати ја листата напред и назад.
//
//Влез
//5
//10 20 30 40 50
//
//Излез
//20<->30<->40
//40<->30<->20

import PodatocniStrukturi.DLL;
import PodatocniStrukturi.DLLNode;

import java.util.Scanner;


public class OtstraniPrvIPosleden {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        DLL<Integer> list = new DLL<Integer>();

        for(int i = 0; i < N; i++){
            list.insertLast(sc.nextInt());
//            DLLNode<Integer> lastEl = list.getLast();
//            list.insertAfter(sc.nextInt(), lastEl);
        }
//        10 20 30 40 ...

        list.deleteFirst();
        list.deleteLast();

        System.out.println(list.toString());
        System.out.println(list.toStringR());
    }

}
