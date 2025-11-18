//Дадена е двојно поврзана листа и цел број k. Треба да ја ротираш листата циклично, без да создаваш нови јазли
//и без да копираш вредности — само со преповрзување на постојните јазли.
//
//Ако k > 0 → ротираш надесно
//Ако k < 0 → ротираш налево
//k може да биде огромен (поголем од должината) или негативен, па мора да се нормализира.
//
//Идеја на задачата
//Ротација значи дека дел од крајот преминува на почеток или обратно.
//Примери:
//Десна ротација за 1: 1 2 3 4 → 4 1 2 3
//Лева ротација за 2: 1 2 3 4 5 → 3 4 5 1 2
//
//Клучниот трик: нормализирање на k
//Листата има должина L.
//Секое поместување може да се претвори во десна ротација во опсег 0..L-1 така што:
//k = ((k % L) + L) % L
//
//
//Пример:
//k = 7, L = 5 → k = 2
//k = -1, L = 5 → k = 4
//k = -13, L = 7 → k = 1
//k = 0 → нема промена
//
//Што правиш после нормализацијата?
//Ако k == 0 → листата не се менува.
//Новиот tail (последен јазол) е (L - k - 1)-от јазол.
//Новиот head е tail.succ.
//Старите врски се прекинуваат и се поврзуваат:
//newTail.succ = null
//newHead.pred = null
//oldLast.succ = oldFirst
//oldFirst.pred = oldLast
//Ги ажурираш first и last во листата.
//
//Примери
//Пример 1 — десна ротација
//Влез:
//7
//1 2 3 4 5 6 7
//k = 3
//
//Десна ротација за 3 → последните 3 одат напред.
//
//Излез:
//5<->6<->7<->1<->2<->3<->4
//
//
//Пример 2 — десна ротација со k поголемо од должината
//Листа: 10 20 30 40
//k = 10
//
//L = 4
//k = 10 % 4 = 2
//
//Ротација за 2 надесно:
//30 40 10 20
//
//Пример 3 — негативна ротација (лева)
//Листа: 1 2 3 4 5
//k = -1   (лева ротација за 1)
//
//Нормализација:
//k = ((-1 % 5) + 5) % 5 = 4
//
//Излез:
//2 3 4 5 1
//
//Пример 4 — негативно и огромно k
//Листа: 8 9 10
//k = -100
//
//L = 3
//k = ((-100 % 3) + 3) % 3
//k = (-1 + 3) % 3 = 2
//
//Ротација за 2 надесно:
//
//10 8 9
//
//Пример 5 — k = 0 (без промена)
//Листа: 4 4 4 4
//k = 0
//
//Излез:
//4 4 4 4


package PripremiIspiti.Listi;

import PodatocniStrukturi.DLL;
import PodatocniStrukturi.DLLNode;

public class RotateDLL {
    public static void rotate(DLL<Integer> list, int k) {
        if (list.getFirst() == null || list.getFirst().succ == null) return;

        int len = 0;

        DLLNode<Integer> p = list.getFirst();
        DLLNode<Integer> last = null;

        while (p != null) { last = p; len++; p = p.succ; }

        int rk = ((k % len) + len) % len;
        if (rk == 0) return;
        // L - rk -тиот е нов tail
        int steps = len - rk - 1;
        DLLNode<Integer> newTail = list.getFirst();
        for (int i = 0; i < steps; i++) newTail = newTail.succ;
        DLLNode<Integer> newHead = newTail.succ;
        newTail.succ = null;
        newHead.pred = null;
        last.succ = list.getFirst();
        list.getFirst().pred = last;
        // ажурирај first/last
        list.first = newHead;
        list.last = newTail;
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int n = sc.nextInt();
        DLL<Integer> list = new DLL<>();
        for (int i = 0; i < n; i++) list.insertLast(sc.nextInt());
        int k = sc.nextInt();
        rotate(list, k);
        System.out.println(list.toString());
        sc.close();
    }
}
