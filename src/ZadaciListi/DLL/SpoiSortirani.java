package ZadaciListi.DLL;

//Задача: Дадени се две зголемувачки сортирани низи A и B.
//Направи две двојно поврзани листи и спои ги во една сортирана листа (без користење готови сортирања).

//Влез
//5
//1 2 2 7 10
//4
//2 3 7 8
//
//Излез
//1<->2<->2<->2<->3<->7<->7<->8<->10

import PodatocniStrukturi.DLL;

import java.util.Scanner;

public class SpoiSortirani {

    public static DLL<Integer> merge(DLL<Integer> A, DLL<Integer> B) {
        DLL<Integer> result = new DLL<>();

        var nodeA = A.getFirst();
        var nodeB = B.getFirst();

        while (nodeA != null && nodeB != null) {
            int valA = nodeA.element;
            int valB = nodeB.element;

            if (valA <= valB) {
                result.insertLast(valA);
                nodeA = nodeA.succ;
            } else {
                result.insertLast(valB);
                nodeB = nodeB.succ;
            }
        }

        // Add remaining elements
        while (nodeA != null) {
            result.insertLast(nodeA.element);
            nodeA = nodeA.succ;
        }

        while (nodeB != null) {
            result.insertLast(nodeB.element);
            nodeB = nodeB.succ;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        DLL<Integer> A = new DLL<>();
        for (int i = 0; i < n; i++) {
            A.insertLast(sc.nextInt());
        }

        int m = sc.nextInt();
        DLL<Integer> B = new DLL<>();

        for (int i = 0; i < m; i++) {
            B.insertLast(sc.nextInt());
        }

        DLL<Integer> merged = merge(A, B);
        System.out.println(merged);
    }
}
