//Дадени се две двоjно поврзани листи чии што jазли содржат по една природен
//броj. Од првата листа треба да се избришат сите поjавувања на втората листа
//        (поjавување на една листа во друга значи првата листа да е подлиста на втората).
//Jазлите што ´ке останат во првата листа треба да се прикажат на излез. Ако не
//остане ниту еден jазел се печати Prazna lista.
//Влез: Во првиот ред од влезот е даден броjот на jазли на првата листа, потоа
//во вториот ред се дадени броевите од кои се составени jазлите по редослед во
//првата листа разделени со празно место. Во третиот ред е даден броjот на jазли
//на втората листа, а во четвртиот ред броевите од кои се составени jазлите по
//редослед во втората листа.
//Излез: На излез треба да се испечатат jазлите по редослед во резултантната
//        (првата) листа. Ако не остане ниту еден jазел се печати Prazna lista.
//Пример.
//        Влез:
//        22
//        1 2 3 4 5 6 1 2 3 4 5 6 1 2 6 5 1 3 4 1 5 2
//        3
//        4 5 6 Излез:
//        1 2 3 1 2 3 1 2 6 5 1 3 4 1 5 2

package kolokviumska;

import PodatocniStrukturi.DLL;
import PodatocniStrukturi.DLLNode;
import java.util.Scanner;

public class DvojnoPovrzanaListaKolok {

    public static void brisiPodList(DLL<Integer> lista1, DLL<Integer> lista2){

        if (lista2.getFirst() == null) {
            return;
        }

        DLLNode<Integer> current = lista1.getFirst();

        while (current != null){
            DLLNode<Integer> temp1 = current;
            DLLNode<Integer> temp2 = lista2.getFirst();
            // prvata lista ni e pogolema od vtorata

            // temp2 == null, temp1 != null - se sovpadnale podlistite
            // temp2 != null, temp1 == null - ne se sovpadnale podlistite
            // temp2 == null, temp1 == null - se sovpadnale podlistite
            // temp1 != null, temp2 != null - ne se sovpadnale podlistite
            while(temp1 != null && temp2 != null && temp1.element.equals(temp2.element)){
                temp1=temp1.succ;
                temp2=temp2.succ;
            }

            if(temp2 == null){
                // najdena podlista, brisi gi jazlite
                DLLNode<Integer> delStart = current;
                DLLNode<Integer> delEnd = temp1;  // temp1 - prviot element posle podnizata sto treba da go izbriseme

                while(delStart != delEnd){
                    DLLNode<Integer> next = delStart.succ;
                    lista1.delete(delStart);
                    delStart = next;
                }
                current = delEnd;
            }
            else{
                current = current.succ;
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        DLL<Integer> lista1 = new DLL<Integer>();
        for(int i = 0; i < n1; i++){
            lista1.insertLast(sc.nextInt());
        }

        int n2 = sc.nextInt();
        DLL<Integer> lista2 = new DLL<Integer>();
        for(int i = 0; i < n2; i++){
            lista2.insertLast(sc.nextInt());
        }

        brisiPodList(lista1, lista2);

        if(lista1.getFirst() == null){
            System.out.println("Prazna lista");
        }
        else{
            DLLNode<Integer> tmp = lista1.getFirst();
            while(tmp != null){
                System.out.print(tmp.element + " ");
                tmp = tmp.succ;
            }
            System.out.println();
        }
    }


}
