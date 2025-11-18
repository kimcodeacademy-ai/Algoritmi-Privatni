//Дадена е единечно поврзана листа од цели броеви и број x.
//Треба да ја прераспоредиш така што:
//- сите елементи помали од x ќе бидат на почеток,
//- сите елементи поголеми или еднакви на x ќе бидат после нив, a редоследот во двете групи мора да остане ист
//како што бил.
//
//Важно:
//✔ Се користат истите јазли (не се создава нова листа).
//✔ Може да се користат само 2 фиктивни (dummy) глави за олеснување.
//
//Што значи стабилна партиција?
//Ако во листата има две вредности кои се помали од x, нивниот меѓусебен ред мора да остане ист.
//Исто и за сите поголеми/еднакви елементи.
//
//Пример за нестабилна партиција (НЕ СМЕЕ така):
//5 1 8 0 3 5 2 7 со x=5 → 2 1 0 3 5 7 8 5 ❌
//(редоследот на елементите е изменет)
//
//Пример за стабилна партиција (СМЕЕ):
//1 0 3 2 5 8 5 7 ✔
//(редоследот во двете групи е ист како оригиналниот)
//
//Како се решава?
//Користиме две мини-листи:
//before: елементи < x
//after: елементи ≥ x
//И двете почнуваат со фиктивни глави (dummy nodes), само за полесно поврзување.
//
//Алгоритам:
//Итерираш низ оригиналната листа.
//Секој јазол го одвојуваш (cur.succ = null).
//Ако cur < x → оди во “before”.
//Инаку → оди во “after”.
//На крај ги спојуваш:
//before → after
//Нема дуплирање, нема нови вредности, само преповрзување.
//
//Примери
//Пример 1
//Влез:
//8
//5 1 8 0 3 5 2 7
//x = 5
//
//Група < 5:   1, 0, 3, 2
//Група ≥ 5:   5, 8, 5, 7
//
//Излез:
//1->0->3->2->5->8->5->7
//(редоследот е целосно зачуван)
//
//Пример 2 — сите се помали
//Влез:
//5
//1 0 2 2 3
//x = 10
//
//Сè е < 10 → листата останува иста
//
//Излез:
//1->0->2->2->3
//
//Пример 3 — сите се поголеми или еднакви
//Влез:
//5
//9 9 10 12 7
//x = 5
//
//Сè оди во after-групата → редоследот се чува
//
//Излез:
//9->9->10->12->7
//
//Пример 4 — мешано со повторувања
//Влез:
//7
//4 4 6 1 7 3 5
//x = 5
//
//<5: 4, 4, 1, 3
//≥5: 6, 7, 5
//
//Излез:
//4->4->1->3->6->7->5
//
//Пример 5 — x се појавува сред листа
//Влез:
//6
//2 5 3 5 1 5
//x = 5
//
//<5: 2, 3, 1
//≥5: 5, 5, 5
//
//Излез:
//2->3->1->5->5->5

package PripremiIspiti.Listi;

import PodatocniStrukturi.SLL;
import PodatocniStrukturi.SLLNode;

public class StablePartitionSLL {
    public static void partition(SLL<Integer> list, int x) {
        if (list.getFirst() == null) return;
        SLLNode<Integer> beforeHead = new SLLNode<>(0, null);
        SLLNode<Integer> beforeTail = beforeHead;
        SLLNode<Integer> afterHead = new SLLNode<>(0, null);
        SLLNode<Integer> afterTail = afterHead;

        SLLNode<Integer> cur = list.getFirst();
        while (cur != null) {
            SLLNode<Integer> next = cur.succ;
            cur.succ = null;
            if (cur.element < x) {
                beforeTail.succ = cur;
                beforeTail = cur;
            } else {
                afterTail.succ = cur;
                afterTail = cur;
            }
            cur = next;
        }
        // конкатенација
        beforeTail.succ = afterHead.succ;
        // осигурај завршеток
        if (afterTail != null) afterTail.succ = null;
        list.first = (beforeHead.succ != null) ? beforeHead.succ : afterHead.succ;
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int n = sc.nextInt();
        SLL<Integer> list = new SLL<>();
        for (int i = 0; i < n; i++) list.insertLast(sc.nextInt());
        int x = sc.nextInt();
        partition(list, x);
        System.out.println(list.toString());
        sc.close();
    }
}
