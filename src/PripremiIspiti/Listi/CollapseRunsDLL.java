//Дадена е сортирана двојно поврзана листа од цели броеви, каде што еднаквите елементи секогаш стојат еден до друг. Треба да ја преработиш листата така што:
//Секоја група од повеќе последователни исти броеви (пример: x x x x) ќе ја замениш со два јазли:
//- прво x
//- потоа бројот k, каде k е големината на групата.
//
//Ако бројот се јавува само еднаш, тогаш останува како што е, без да се додава број 1.
//
//Пример:
//Влезна листа:    2 2 2 5 5 7
//Излезна листа:   2 3 5 2 7
//
//Објаснување:
//2 се појавува 3 пати → станува 2 <-> 3
//5 се појавува 2 пати → станува 5 <-> 2
//7 се појавува 1 пат → останува 7
//
//Што треба да направиш:
//Прооди низ листата од почеток.
//За секој блок од исти броеви: изброј колку пати се повторува (k)
//задржи го само првиот јазел со вредност x
//ако k > 1, веднаш по него вметни нов јазел со вредност k
//избриши ги останатите k-1 јазли
//
//Влез:
//Бројот N (N ≥ 1)
//Потоа N броеви што ја формираат DLL
//
//Излез:
//Модифицираната DLL, печатена во формат:
//a<->b<->c

package PripremiIspiti.Listi;

import PodatocniStrukturi.DLL;
import PodatocniStrukturi.DLLNode;

public class CollapseRunsDLL {
    public static void transform(DLL<Integer> list) {
        DLLNode<Integer> cur = list.getFirst();
        while (cur != null) {
            DLLNode<Integer> runStart = cur;
            int val = cur.element;
            int count = 0;
            while (cur != null && cur.element == val) {
                count++;
                cur = cur.succ;
            }
            // cur е првиот различен по run или null
            // runStart покажува на првиот x
            // Отстрани сите освен првиот од овој run
            DLLNode<Integer> del = runStart.succ;
            for (int i = 1; i < count; i++) {
                DLLNode<Integer> next = del.succ;
                list.delete(del);
                del = next;
            }
            if (count > 1) {
                list.insertAfter(count, runStart);
            }
            // Постави cur на јазол после (евентуално) вметнатиот count
            cur = (count > 1) ? runStart.succ.succ : runStart.succ;
        }
    }

    public static void main(String[] args) throws Exception {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int n = sc.nextInt();
        DLL<Integer> list = new DLL<>();
        for (int i = 0; i < n; i++) list.insertLast(sc.nextInt());
        transform(list);
        System.out.println(list.toString());
        sc.close();
    }
}
