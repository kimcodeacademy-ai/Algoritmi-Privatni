//На еден светски познат предавач секоjдневно му пристигнуваат понуди да држи
//предавања. За секоjа понуда се дадени датуми, време на почеток, градот и износот на хонорарот за предавањето (во долари). Ваша задача е за даден датум да
//го прикажете предавањето кое би му донело наjголема заработка на предавачот.
//Доколку нема понуди за дадениот датум да се испечати „No offers”.
//Влез: Во првиот ред од влезот е даден броjот на понуди, а во секоj нареден
//ред се дадени: датумот и времето на предавањето (формат dd/mm/yyyyhh:mm),
//градот во коj ´ке се одржува предавањето и износот на хонорарот. Во последниот
//ред е даден датумот за коj треба да испечатите коjа понуда е наjдобра за тоj
//датум.
//        Излез: Деталите на понудата за тоj датум.
//Пример:
//Влез:
//7
//27/01/2016 14:00 NewYork 6000
//28/01/2016 08:00 Paris 3000
//28/01/2016 14:00 Munich 5000
//27/01/2016 09:00 Beijing 8000
//27/01/2016 08:00 Seattle 4000
//28/01/2016 09:00 SaltLakeCity 10000
//28/01/2016 09:00 Lagos 12000
//27/01/2016
//Излез:
//        09:00 Beijing 8000


// книга: 189 страна

package HashTables.CBHT.Zadaci;

import HashTables.CBHT.PodStrukturi.CBHT;
import HashTables.CBHT.PodStrukturi.MapEntry;
import HashTables.CBHT.PodStrukturi.SLLNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

class Lecture implements Comparable<Lecture>{
    String hour;
    String city;
    int price;

    // alt + insert
    public Lecture(String hour, String city, int price) {
        this.hour = hour;
        this.city = city;
        this.price = price;
    }

    @Override
    public String toString() {
        return  hour + " " + city + " " + price;
    }

    @Override
    public int compareTo(Lecture o) {
        if(this.price > o.price)
            return 1;
        else if(this.price < o.price)
            return -1;
        else
            return 0;
    }
}

public class  BestOffer {

    // izlez: vreme grad zarabotka na predacacot
    // key: string (Celosniot datum)
    // value: sopstvena klasa
    public static void main(String[] args) throws IOException {
        // Scanner
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        CBHT<String, Lecture> lectures = new CBHT<>(2*N);
//        50/100 = 0.5
        for(int i = 0; i < N; i++){
            //27/01/2016 14:00 NewYork 6000
            String lecture = br.readLine();
            String [] parts = lecture.split(" ");
            String datum = parts[0];
            Lecture l1 = new Lecture(parts[1], parts[2], Integer.parseInt(parts[3]));

            if(lectures.search(datum) != null){
                SLLNode<MapEntry<String, Lecture>> me = lectures.search(datum);
                if(l1.compareTo(me.element.value) == 1){
                    lectures.delete(datum);
                    lectures.insert(datum, l1);
                }
            }
            else{
                lectures.insert(datum, l1);
            }
        }

        String date = br.readLine();
        SLLNode<MapEntry<String, Lecture>> me = lectures.search(date);
        if(me != null){
            System.out.println(me.element.value);
        }
        else{
            System.out.println("No offers");
        }

    }

}
