package ZadaciListi.SLL;

//Дадена е еднострано поврзана листа чии што jазли содржат цели броеви. За
//даден броj од тастатура, потребно е да се отстрани неговото последно поjавување
//        (да се избрише jазолот што го содржи броjот).
//Влез: Во првата линиjа е даден броjот на елементи n. Во следните n линии
//се дадени елементите на листата. Во последната линиjа е даден броjот коj треба
//да се отстрани (неговото последно поjавување).
//Излез: На излез треба да се испечатат jазлите на резултантната листа.

import PodatocniStrukturi.SLL;
import PodatocniStrukturi.SLLNode;

import java.util.Scanner;

public class IzbrishiPosleden {
    public static void main(String[] args) {

        // N: kolku elementi listata
        // Da gi procitame elementite sto ke bidat vo listata
        // Elementot sto sakame da go ostranime
        SLL<Integer> lista = new SLL<Integer>();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            lista.insertLast(sc.nextInt());
        }

        System.out.println(lista);
        int todelete = sc.nextInt();

        SLLNode<Integer> current = lista.getFirst();
        SLLNode<Integer> toDeleteNode = null;

        while(current != null){
            if(current.element.equals(todelete)){
                toDeleteNode = current;
//                break;
            }
            current = current.succ;
        }

        if(toDeleteNode != null){
            lista.delete(toDeleteNode);
        }

        System.out.println(lista);
    }
}
