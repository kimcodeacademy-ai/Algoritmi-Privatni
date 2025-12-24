//Дадени се N деца и M колачиња.
//Секое дете има минимална желба за големина на колаче.
//Секое колаче може да се даде најмногу на едно дете.
//
//Цел:
//Да се одреди максималниот број на деца кои можат да бидат задоволни, така што секое дете ќе добие колаче чија големина е еднаква или поголема од неговата желба.
//
//Влез:
//
//Низа wishes[] – минималната големина на колаче што ја посакува секое дете
//Низа cookies[] – големините на достапните колачиња
//
//Излез:
//Цел број што го претставува максималниот број на задоволни деца

package tehnikinaalgoritmi;

import java.util.Arrays;

public class Cookies {

    public static void main(String[] args) {
        int[] wishes = {1, 2, 7, 10};
        int[] cookies = {1, 3, 5, 9};

        System.out.println("Zadovolni deca: " + zadovolniDeca(wishes, cookies));
    }

    static int zadovolniDeca(int[] wishes, int[] cookies) {
        Arrays.sort(wishes);
        Arrays.sort(cookies);

        int zadovolni = 0;
        int i = 0; // kids
        int j = 0; // cookies

        while (i < wishes.length && j < cookies.length) {
            if (cookies[j] >= wishes[i]) {
                zadovolni++;
                i++;
                j++;
            } else {
                j++; // local optimum
            }
        }
        return zadovolni;
    }
}
