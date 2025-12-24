package ZadaciRedica;

import EdnodimenzionalniPodStrukturi.LinkedQueue;

import java.util.LinkedList;

public class QueuePrimer {
    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<Integer>();

        System.out.println("Primer za redica: ");

        queue.enqueue(4);
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(60);
        // 4 -> 3 -> 2 -> 60

        System.out.println("Usluzeni po red: ");
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue() + " ");
            //queue.dequeue();
        }

        System.out.println("Site broevi se uzluzeni!");
    }
}
