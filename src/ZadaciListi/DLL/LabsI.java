package ZadaciListi.DLL;

import PodatocniStrukturi.DLL;
import PodatocniStrukturi.DLLNode;

import java.util.Scanner;

// pomesti k pozicii levo ciklicna lista

public class LabsI {
    public static void main(String[] args) {
        int N;
        DLL<Integer> lista = new DLL<Integer>();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for(int i = 0; i < N; i++){
            lista.insertLast(sc.nextInt());
        }

        int M = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(lista);
        // ke go najdam prvoto pojavuvanje na M
        DLLNode<Integer> temp = lista.getFirst();
        while (temp != null){
            if(temp.element == M){
                break;
            }
            temp = temp.succ;
        }

        if(temp == null){
            System.out.println("Elementot ne postoi vo listata");
        }

        int counter = 0;
        DLLNode<Integer> last = temp;
        if(temp != null) {
            lista.delete(temp);
        }

        while(last != null){
            if(counter == K){
                lista.insertBefore(M, last);
                break;
            }
            last = last.pred;
            counter++;
            if(last == null){
                last = lista.getLast();
                counter++; // izbrisi go ova ako testot im e greska
            }
        }
        System.out.println(lista);
    }
}