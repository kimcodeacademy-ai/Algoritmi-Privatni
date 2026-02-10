//Треба да се имплементира систем кој ќе управува со информации за одредени артикли (производи).
// Секој артикл е дефиниран со неговиот уникатен код, модел и име на сопственикот.
// Системот треба да овозможи брзо пронаоѓање на информации за артиклот доколку одредена тежина го надминува дефинираниот праг.
//
//Влез:
//Во првиот ред се внесува цел број N (број на артикли кои ќе се внесат во системот).
//Во следните N редови се внесуваат информациите за секој артикл во формат: кодот моделот сопственикот
//
//По внесувањето на сите артикли, се внесува цел број T кој претставува гранична тежина (праг).
//Потоа следуваат редови со команди во формат: тежина_на_пратката код_на_артикл
//Системот треба да ги обработува овие команди сè додека не се внесе командата -1 break.
//
//Излез:
//За секоја команда, доколку тежина_на_пратката е строго поголема од прагот T,
//треба да се испечатат моделот и името на сопственикот за соодветниот код. Во спротивно, не се печати ништо.
//
//Пример:
//Влез:
//
//2
//12345 iPhone15 Petar
//67890 SamsungS24 Marija
//50
//60 12345
//40 67890
//70 67890
//-1 break
//Излез:
//iPhone15 Petar
//SamsungS24 Marija


package ispitni.hash;

import java.util.Scanner;

public class IspitnaHash {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        CBHT<String, String> map = new CBHT<>(2 * n);

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            String kod = parts[0];
            String model = parts[1];
            String ime = parts[2];

            map.insert(kod, model + " " + ime);
        }

        int t = Integer.parseInt(sc.nextLine());

        // 4. Процесирање на команди
        while (true) {
            String line = sc.nextLine();
            if (line.equals("-1 break")) {
                break;
            }

            String[] parts = line.split(" ");
            int tezhina = Integer.parseInt(parts[0]);
            String kod = parts[1];

            if (tezhina > t) {
                SLLNode<MapEntry<String, String>> node = map.search(kod);
                if (node != null) {
                    System.out.println(node.element.value);
                }
            }
        }
        sc.close();
    }
}
