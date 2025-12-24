//Дадена е стандардна шаховска табла со димензии 8 × 8.
//Потребно е да се одреди на колку различни начини можат да се постават две кралици на таблата така што да не се напаѓаат меѓусебно.
//
//Две кралици се смета дека се напаѓаат доколку:
//се наоѓаат во иста редица
//се наоѓаат во иста колона
//се наоѓаат на иста дијагонала
//
//Влез:
//Нема влезни податоци (таблата е со фиксна големина 8 × 8)
//
//Излез:
//Цел број што го претставува бројот на валидни начини за поставување на две кралици

package tehnikinaalgoritmi;

public class BruteForceKralici {

    public static void main(String[] args) {
        System.out.println("Broj na nacini: " + brojNaNacini());
    }

    static int brojNaNacini() {

        int rezultat = 0;

        for (int i1 = 0; i1 < 8; i1++) {
            for (int j1 = 0; j1 < 8; j1++) {
                for (int i2 = 0; i2 < 8; i2++) {
                    for (int j2 = 0; j2 < 8; j2++) {

                        if (i1 == i2 && j1 == j2) continue;

                        if (!daliSeNapagaat(i1, j1, i2, j2)) {
                            rezultat++;
                        }
                    }
                }
            }
        }
        // секој пар е броен двапати
        return rezultat / 2;
    }

    static boolean daliSeNapagaat(int i1, int j1, int i2, int j2) {
        return i1 == i2 ||
                j1 == j2 ||
                Math.abs(i1 - i2) == Math.abs(j1 - j2);
    }
}
