//Задача 1. Родендени
//Во заводот на статистика се прави ново истражување каде што се открива броjот
//на луге родени во секоj месец. Ваша задача е за даден месец да прикажете колку
//луге се родени во тоj месец.
//Влез: Во првиот ред од влезот е даден броjот на луге 𝑁, а во секоj нареден
//ред е даден датумот на рагање. Во последниот ред е даден месецот за коj треба
//да се прикаже броjот на луге родени во тоj месец.
//        Излез: Броj на луге кои се родени во тоj месец. Доколку нема луге родени
//во тоj месец да се испечати „Empty”.
//Пример:
//Влез:
//4
//20.7.1976
//16.7.1988
//18.7.1966
//5.6.1988
//7
//Излез: 3

package HashTables.CBHT.Zadaci;

import HashTables.CBHT.PodStrukturi.CBHT;
import HashTables.CBHT.PodStrukturi.MapEntry;
import HashTables.CBHT.PodStrukturi.SLLNode;

import java.util.Scanner;

public class Rodendeni {

    public static void main(String[] args) {
        // 12 meseci, 13, 23
        //n/m
        CBHT<String, Integer> hashTabela = new CBHT<String, Integer>(23);
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < n; i++){
            String line = sc.nextLine();
            String [] data = line.split("\\.");
            String mesec = data[1];
            //System.out.println(data[1]);
            if(hashTabela.search(mesec) == null){
                hashTabela.insert(mesec, 1);
            }
            else{
                SLLNode<MapEntry<String, Integer>> br = hashTabela.search(mesec);
                hashTabela.insert(mesec, br.element.value + 1);
            }
        }

        String mesec = sc.nextLine();
        SLLNode<MapEntry<String, Integer>> mesecKofa = hashTabela.search(mesec);
        if (mesecKofa != null){
            System.out.println(mesecKofa.element.value);
        }
        else{
            System.out.println("Empty");
        }

    }

}
