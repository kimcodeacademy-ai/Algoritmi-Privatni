package ZadaciRedica;

import EdnodimenzionalniPodStrukturi.LinkedQueue;

import java.util.LinkedList;

public class QueuePrimer {
    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<Integer>();

        System.out.println("Ova e redica za chekanje");

        queue.enqueue(4);
        queue.enqueue(6);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Usluzeni se broevite: ");

        while (!queue.isEmpty()){
            System.out.print(queue.peek() + " ");
            queue.dequeue();
        }

        System.out.println("Site elementi od redicata se ostraneti");
    }
}
