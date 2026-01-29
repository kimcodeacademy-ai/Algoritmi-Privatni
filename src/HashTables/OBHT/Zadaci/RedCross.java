//Задача 1. Црвен крст
//Во рамки на една хуманитарна организациjа, потребно е да се направи статистика за крвните групи кои се на располагање за донациjа, и од кои донатори.
//Подгрупите А1+, А2+ припа´гаат на крвна група А+, додека А1- , А2- припа´гаат
//на група А-.
//Влез: Во првиот ред од влезот е даден броjот на парови 𝑁, а во секоj нареден
//ред се дадени паровите (донатор, крвна група).
//Излез: Да се испечати по колку донатори има од секоjа крвна група согласно
//внесените податоци.
//Пример:
//Влез:
//        5
//Alek A1+
//Dejan B−
//Sandra A+
//Trajce 0+
//Rebeka A1−
//Излез:
//A+=2
//B−=1
// 0+=1
//A−=1
//

package HashTables.OBHT.Zadaci;

import HashTables.OBHT.PodStrukturi.OBHT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RedCross{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // Key: krvna grupa - string
        // Value: counter za krvna grupa - integer
        OBHT<String, Integer> hashTable = new OBHT<>(2*N);

        for(int i = 0; i < N; i++){
            String input = br.readLine();
            String [] row = input.split(" ");
            String key = row[1];

            key = key.replaceAll("[1-2]", "");

            if(hashTable.search(key) == -1){
                hashTable.insert(key, 1);
            }
            else {
                int currentValue = hashTable.getBucket(hashTable.search(key)).value;
                hashTable.insert(key, currentValue + 1);
            }
        }
        System.out.println(hashTable);
    }

}



