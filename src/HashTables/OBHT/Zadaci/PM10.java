////Задача 2. Квалитет на воздух
//// Дадени се мерења на PM10 честички за населбите во Скопjе. Ваша задача е за
//// дадена населба да jа наjдете просечната концентрациjа на PM10 честички.
////  Влез: Во првиот ред од влезот е даден броjот на мерења, а во секоj нареден ред се
////  дадени населбата и концентрациjата на PM10 честички разделени со
////  празно место. Во последниот ред е дадена населбата за коjа треба да наjдете
////  просечна концентрациjа на PM10 честички.
////  Излез: Просечната концентрациjа на PM10 честички за дадената населба
////  (заокружена на 2 децимали, притоа прво нао´гате просечна концентрациjа, па заокружувате).
////
////        Пример:
////        Влез:
//8
//Centar 319.61
//Karposh 296.74
//Centar 531.98
//Karposh 316.44
//GaziBaba 384.05
//GaziBaba 319.3
//Karposh 393.37
//GaziBaba 326.42
//Karposh
////        Излез:
////        335.52
//
//

package HashTables.OBHT.Zadaci;

import HashTables.OBHT.PodStrukturi.OBHT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PM10{

    public static void main(String[] args) throws IOException {
        // key: string - naselba
        // value: double - pm10
        int N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        OBHT<String, ArrayList<Double>> hashTable = new OBHT<>(2*N);

        for(int i =0; i < N; i++){
            String input = br.readLine();
            String [] parts = input.split(" ");

            String neighbourhood = parts[0];
            double pm10 = Double.parseDouble(parts[1]);

            // nikogash zafatena
            if(hashTable.search(neighbourhood) == -1){
                ArrayList<Double> list = new ArrayList<>();
                list.add(pm10);
                hashTable.insert(neighbourhood, list);
            }
            // zafatena
            else{
                ArrayList<Double> list = hashTable.getBucket(hashTable.search(neighbourhood)).value;
                list.add(pm10);
                hashTable.insert(neighbourhood, list);
            }
        }

        String neighbourhood = br.readLine();
        ArrayList<Double> list = hashTable.getBucket(hashTable.search(neighbourhood)).value;
        if(!list.isEmpty()){
            double sum = 0;
            for(double v : list){
                sum += v;
            }
            System.out.printf("%.2f", sum/list.size());
        }
        else{
            System.out.println("Nema merenja za taa naselba");
        }

    }
}

