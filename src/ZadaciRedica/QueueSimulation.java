package ZadaciRedica;

import EdnodimenzionalniPodStrukturi.LinkedQueue;
import java.util.Scanner;

//Задача 1 (: Симулирај редица на луѓе
//
//Опис:
//Да се симулира чекање во ред (queue). Корисникот внесува имиња на луѓе кои влегуваат во редица,
//а секој пат кога ќе се внесе зборот "next", од редицата се вади лицето што е прво (т.е. кој е на ред).
//
//Пример:
//
//Влез:
//Enqueue: Ana
//Enqueue: Boris
//Enqueue: Marko
//Command: next
//Command: next
//
//Излез:
//Ana е услужена.
//Boris е услужен.



public class QueueSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedQueue<String> queue = new LinkedQueue<String>();

        while (true){
            System.out.println("Vnesi ime ili next/end");
            String input = sc.nextLine();
            if(input.equals("end"))
                break;
            if(input.equals("next")){
                if(!queue.isEmpty()){
                    System.out.println(queue.dequeue() + " e usluzhen");
                }
                else {
                    System.out.println("Nema vekje lugje vo redicata");
                }
            }
            else{
                queue.enqueue(input);
                System.out.println(input + " e vo redicata");
            }
        }
    }
}
