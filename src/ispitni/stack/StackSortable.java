//Дадена е влезна редица чии елементи се првите n природни броеви (генерирани
//        по случаен редослед). Ваша задача е да проверите дали елементите од влезната
//        редица може да се сортираат во растечки редослед во друга излезна редица,
//        притоа користеj´ки jа податочната структура стек.
//        Дозволени операции се само следниве:
//        1. Каj влезната редица може да се применуваат само операциите dequeue и
//        peek.
//        2. Каj магацинот може да се применуваат стандардните операции за магацин
//        (push, pop, peek).
//        3. Каj излезната редица може да се применуваат само операциите enqueue и
//        peek.
//        Влез: Во влезот во првиот ред е даден броjот n. Во вториот ред се дадени
//        елементите по редослед како што треба да се додадат во влезната редица.
//        Излез: На излез треба да се испечати “da” доколку е можно да се сортираат
//        броевите или “nе” доколку не е можно да се сортираат.
//        Забелешка: При реализациjа на задачата е дозволено да се користат само
//        две редици и еден стек. Не е дозволено да се користат дополнителни структури
//        како низи и листи.
//        Пример 1:
//        Влез:
//        5
//        5 1 2 3 4
//        Излез:
//        Да
//
//        Пример 2:
//        Влез:
//        6
//        5 1 2 6 3 4
//        Излез:
//        Не



package ispitni.stack;

import java.util.Scanner;

public class StackSortable {
    public static boolean canBeSorted(ArrayQueue<Integer> input, int n) {
        ArrayQueue<Integer> output = new ArrayQueue<>(n);
        ArrayStack<Integer> stack = new ArrayStack<>(n);

        int expected = 1;

        while (!input.isEmpty()) {
            if (input.peek() == expected) {
                output.enqueue(input.dequeue());
                expected++;
            } else if (!stack.isEmpty() && stack.peek() == expected) {
                output.enqueue(stack.pop());
                expected++;
            } else {
                stack.push(input.dequeue());
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() != expected) {
                return false;
            }
            output.enqueue(stack.pop());
            expected++;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayQueue<Integer> input = new ArrayQueue<>(n);

        for (int i = 0; i < n; i++) {
            input.enqueue(sc.nextInt());
        }

        boolean result = StackSortable.canBeSorted(input, n);

        if (result) {
            System.out.println("Da");
        } else {
            System.out.println("Ne");
        }
    }
}
