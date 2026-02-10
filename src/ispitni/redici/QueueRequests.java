//Наредени луѓе со број на барања, им се извршува едно барање и се враќаат назад во редот.
// Печати редослед на завршување на луѓето.
//
//Input
//5
//Nenad 3
//Slave 1
//Martin 2
//Ana 1
//Igor 2
//
//Output
//Slave
//Ana
//Martin
//Igor
//Nenad

package ispitni.redici;

import java.util.Scanner;

class Person {
    String name;
    int requests;

    public Person(String name, int requests) {
        this.name = name;
        this.requests = requests;
    }
}

public class QueueRequests {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        ArrayQueue<Person> queue = new ArrayQueue<>(n);

        // Vnesuvanje na lugjeto vo redot
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            String name = parts[0];
            int requests = Integer.parseInt(parts[1]);
            queue.enqueue(new Person(name, requests));
        }

        // Obrabotka na redot
        while (!queue.isEmpty()) {
            Person p = queue.dequeue();
            p.requests--;
            if (p.requests == 0) {
                System.out.println(p.name);
            } else {
                queue.enqueue(p);
            }
        }
    }
}
