//
//Листа од цели броеви помеѓу 1 и 999 е цик цак листа доколку паровите од соседни елементи
//се наизменично во строго опаѓачки и строго растечки редослед и првиот пар е во растечки редослед.
//На пример:
//
//1 <-> 5 <-> 1 <-> 5
//1 <-> 12 <-> 2 <-> 15 <-> 10
//6 <-> 10 <-> 8 <-> 9 <-> 2 <-> 4 <-> 3
//
//Додека пак следните листи не се цик цак листи:
//
//5 <-> 1 <-> 5 <-> 1
//1 <-> 5 <-> 10 <-> 5 <-> 1
//5 <-> 10 <-> 7 <-> 5 <-> 7
//1 <-> 10 <-> 10 <-> 1
//
//Секоја листа од цели броеви можеме да ја претвориме во цик цак листа.
//На пример, во листите:
//
//1 <-> 5 <-> 10 <-> 5 <-> 1
//првиот пар кој што не прави наизменична промена е парот 5 <-> 10, кој би требало да е
//во опаѓачки редослед бидејќи пред него има пар во растечки редослед.
//
//5 <-> 10 <-> 7 <-> 5 <-> 7
//првиот пар кој што не прави наизменична промена е парот 7 <-> 5, кој би требало да е во
//растечки редослед бидејќи пред него има пар во опаѓачки редослед.
//
//Кога има пар што е во растечки редослед, а треба да е во опаѓачки, како на пример 5 <-> 10,
//или пар што е во опаѓачки редослед, а треба да е во растечки, како на пример 7 <-> 5, можеме да го отстраниме
//јазелот кој што е втор во парот, во овој случај јазелот со вредност 10 во првиот пар и 5 во вториот пар.
//
//Имплементирајте го методот makeZigZag кој што ќе ја трансформира листата аргумент во цик цак листа.
//
//Влез: Во првиот ред од влезот е даден цел број N, кој го претставува бројот на јазли во листата,
//а потоа во следниот ред N цели броеви одделени со празно место помеѓу 1 и 999.
//
//Излез: На излез треба да се испечатат променетата листа после нејзината трансформација во цик цак листа.
//
//Пример:
//
//Влез:
//
//5
//1 5 10 5 1
//
//
//Излез:
//
//1 <-> 5 <-> 10 <-> 5 <-> 1
//1 <-> 5 <-> 1
//
//

package ispitni.listi;

import java.util.Scanner;

public class ZigZag {

    // TODO: implement function
    public static void makeZigZag(DLL<Integer> list) {
        if (list.getFirst() == null || list.getFirst().succ == null)
            return;

        DLLNode<Integer> curr = list.getFirst();
        boolean shouldRise = true;

        while (curr != null && curr.succ != null) {
            int a = curr.element;
            int b = curr.succ.element;

            if (shouldRise) {
                if (a < b) {
                    shouldRise = false;
                    curr = curr.succ;
                } else {
                    list.delete(curr.succ);
                }
            } else {
                if (a > b) {
                    shouldRise = true;
                    curr = curr.succ;
                } else {
                    list.delete(curr.succ);
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tests = input.nextInt();
        for (int t = 1; t <= tests; t++) {
            System.out.println("Test case " + t);
            //input.next();
            int n = input.nextInt();

            DLL<Integer> list = new DLL<>();

            for (int i = 0; i < n; i++) {
                list.insertLast(input.nextInt());
            }

            System.out.println(list);

            makeZigZag(list);

            System.out.println(list);

        }

        input.close();
    }
}


class DLLNode<E> {
    protected E element;
    protected DLLNode<E> pred, succ;
    public DLLNode(E elem, DLLNode<E> pred, DLLNode<E> succ) {
        this.element = elem;
        this.pred = pred;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}


class DLL<E> {
    private DLLNode<E> first, last;

    public DLL() {
        this.first = null;
        this.last = null;
    }

    public void insertFirst(E o) {
        DLLNode<E> ins = new DLLNode<E>(o, null, first);
        if (first == null)
            last = ins;
        else
            first.pred = ins;
        first = ins;
    }

    public void insertLast(E o) {
        if (first == null)
            insertFirst(o);
        else {
            DLLNode<E> ins = new DLLNode<E>(o, last, null);
            last.succ = ins;
            last = ins;
        }
    }

    public void insertAfter(E o, DLLNode<E> after) {
        if (after == last) {
            insertLast(o);
            return;
        }
        DLLNode<E> ins = new DLLNode<E>(o, after, after.succ);
        after.succ.pred = ins;
        after.succ = ins;
    }

    public void insertBefore(E o, DLLNode<E> before) {
        if (before == first) {
            insertFirst(o);
            return;
        }
        DLLNode<E> ins = new DLLNode<E>(o, before.pred, before);
        before.pred.succ = ins;
        before.pred = ins;
    }

    public E deleteFirst() {
        if (first != null) {
            DLLNode<E> tmp = first;
            first = first.succ;
            if (first != null) first.pred = null;
            if (first == null)
                last = null;
            return tmp.element;
        } else
            return null;
    }

    public E deleteLast() {
        if (first != null) {
            if (first.succ == null)
                return deleteFirst();
            else {
                DLLNode<E> tmp = last;
                last = last.pred;
                last.succ = null;
                return tmp.element;
            }
        } else
            return null;
    }

    public E delete(DLLNode<E> node) {
        if (node == first) {
            return deleteFirst();
        }
        if (node == last) {
            return deleteLast();
        }
        node.pred.succ = node.succ;
        node.succ.pred = node.pred;
        return node.element;
    }

    public DLLNode<E> find(E o) {
        if (first != null) {
            DLLNode<E> tmp = first;
            while (!tmp.element.equals(o) && tmp.succ != null)
                tmp = tmp.succ;
            if (tmp.element.equals(o)) {
                return tmp;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
        return null;
    }

    public void deleteList() {
        first = null;
        last = null;
    }

    public int getSize() {
        int listSize = 0;
        DLLNode<E> tmp = first;
        while(tmp != null) {
            listSize++;
            tmp = tmp.succ;
        }
        return listSize;
    }

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            DLLNode<E> tmp = first;
            ret += tmp.toString();
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += "<->" + tmp.toString();
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public DLLNode<E> getFirst() {
        return first;
    }

    public DLLNode<E> getLast() {
        return last;
    }
}
