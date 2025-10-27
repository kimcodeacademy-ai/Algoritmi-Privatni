package ZadaciListi.DLL;

//Задача: Направи листа од N цели броеви и отстрани си сите појавувања на бројот X. Испечати ја листата по отстранувањето.

//Влез
//7
//5 1 2 5 3 5 4
//5
//
//Излез
//1<->2<->3<->4


import PodatocniStrukturi.DLL;
import PodatocniStrukturi.DLLNode;

import java.util.Scanner;

public class OtstraniPojavuvanjaNaX {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        DLL<Integer> lista = new DLL<Integer>();
        for(int i = 0; i < N; i++){
            lista.insertLast(sc.nextInt());
        }

        int X = sc.nextInt();

        DLLNode<Integer> tmp = lista.getFirst();
        while(tmp != null){
            DLLNode<Integer> next = tmp.succ;
            if(tmp.element == X){
                lista.delete(tmp);
            }
            tmp = next;
        }
        System.out.println(lista.toString());
    }

}

