//Задача 1. Епидемиjа
//Поради епидемиjа на сезонски грип при секое тестирање на даден пациент се
//зачувува општината во коjа живее, неговото презиме и информациjа дали е позитивен или негативен на вирусот. Потребни се статистички податоци за да се
//одреди ризик факторот за дадена општина. Ваша задача е за дадена општина на
//излез да го испечатите ризик факторот во дадената општина. Ризик факторот
//се пресметува на следниот начин:
//Ризик фактор =
//        броj на позитивни пациенти /
//броj на негативни пациенти + броj на позитивни пациенти
//Забелешка: Можно е да се поjават пациенти со исто презиме. Истите треба
//да се земат како посебни вредности во статистиката.
//Влез: На влез наjпрво е даден броjот на пациенти 𝑁, а потоа секоj пациент е
//даден во нов ред во форматот: „Општина во коjа живее” „Презиме на пациент”
//        „Резултати од тестот(positive/negative)”. На краj е дадена општината за коjа
//треба да се пресмета ризик факторот.
//Излез: Децимален броj заокружен на две децимали коj го претставува ризик
//факторот за дадената општина.
//Пример:
//Влез:
//6
//Centar Stojanoski negative
//Centar Trajkovski positive
//Centar Petkovski positive
//Karpos Stojanoski positive
//Karpos Trajkovski negative
//Centar Trajkovski positive
//        Centar
//Излез:
//        0.75


//6
//Centar Stojanoski negative
//Centar Trajkovski positive
//Centar Petkovski positive
//Karpos Stojanoski positive
//Karpos Trajkovski negative
//Centar Trajkovski positive



// resnie1: Da si izgradish sopstvena klasa
// kluc: String (opstina), Vrednost Lista<Klasa>

// resenie2: Da napravish 2 hash tabeli
// kluc: String (opstina), 2 hash tabeli


package ispitni.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pacientihash {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 0.5/0.75 - prost broj
        CBHT<String, Integer> positivePatients = new CBHT<>(2*N);
        CBHT<String, Integer> negativePatients = new CBHT<>(2*N);

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String [] parts = line.split(" ");
            String opstina = parts[0];
            String rezultat = parts[2];

            if(rezultat.equals("positive")) {
                SLLNode<MapEntry<String, Integer>> pozPaci = positivePatients.search(opstina);
                if(pozPaci == null) {
                    positivePatients.insert(opstina, 1);
                }
                else{
                    Integer numPositive = pozPaci.element.value;
                    positivePatients.insert(opstina, numPositive+1);
                }
            }

            else{
                SLLNode<MapEntry<String, Integer>> negPaci = negativePatients.search(opstina);
                if(negPaci == null) {
                    negativePatients.insert(opstina, 1);
                }
                else{
                    Integer numNegative = negPaci.element.value;
                    negativePatients.insert(opstina, numNegative+1);
                }
            }
        }

        String opstina = br.readLine();
        SLLNode<MapEntry<String, Integer>> pozPaci = positivePatients.search(opstina);
        SLLNode<MapEntry<String, Integer>> negPaci = negativePatients.search(opstina);

        int pozitivni = pozPaci.element.value;
        int negativni = negPaci.element.value;

        //        броj на позитивни пациенти /
//броj на негативни пациенти + броj на позитивни пациенти
        double rizik_faktor = pozitivni * 1.0 / (negativni+pozitivni);

        System.out.println(rizik_faktor);
    }

}
