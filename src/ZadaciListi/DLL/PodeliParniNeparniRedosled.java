package ZadaciListi.DLL;

//Задача: Реорганизирај ја листата така што сите парни броеви ќе
//бидат пред сите непарни, но задржи го редоследот во рамките на секоја група

//Влез
//8
//3 2 4 7 8 5 6 1
//
//Излез
//2<->4<->8<->6<->3<->7<->5<->1

import PodatocniStrukturi.DLL;
import PodatocniStrukturi.DLLNode;

import java.util.Scanner;

public class PodeliParniNeparniRedosled {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        DLL<Integer> lista = new DLL<Integer>();

        for(int i = 0; i < N; i++){
            lista.insertLast(sc.nextInt());
        }

        DLLNode<Integer> tmp = lista.getFirst();

        while(tmp != null && tmp.element % 2 == 0){
            tmp = tmp.succ;
        }

        if(tmp == null){
            System.out.println(lista.toString());
            return;
        }

        // vo tmp go imame prviot neparen element vo listata

        DLLNode<Integer> node = tmp.succ;
        while(node != null){
            DLLNode<Integer> next = node.succ;
            if(node.element % 2 == 0){
                // gi postavuvame parnite elementi pred tmp - prviot neparen element vo listata
                int val = node.element;
                lista.delete(node);
                lista.insertBefore(val, tmp);
            }
            node = next;
        }

        System.out.println(lista.toString());
    }

}
