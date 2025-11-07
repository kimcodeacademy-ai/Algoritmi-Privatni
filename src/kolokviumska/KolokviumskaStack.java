//Да се напише алгоритам со коj ´ке се имплементира играта за мобилен телефон
//        “Подреди топчиња според боjа”. Во оваа игра на располагање имате топчиња во
//        три различни бои (R-црвена, G-зелена и B-сина). На екран имате 3 кутии. Во
//        првата кутиjа се нао´гаат топчињата кои што ви ги доделува апликациjата на почеток на играта. Играта завршува кога ´ке се подредат топчињата според боjа (во
//        третата кутиjа) и тоа во следниот редослед RGB (односно прво ´ке бидат црвените, па зелените и на краj сините топчиња), а другите кутии се празни. Втората
//        кутиjа може да jа користите како помошна при распределбата на топчињата.
//        Притоа треба да се води грижа дека во еден момент само едно топче може да
//        се вади или става од врвот на кутиjата. Исто така за оваа игра важи следново
//        правило: Доколку на влез доjдат последователно три топчиња од црвена боjа,
//        тоа значи “бомба”. Ова значи поништување на сите топчиња последователно што
//        се нао´гаат во таа кутиjа (што се црвена боjа), се додека не се доjде до топче од
//        различна боjа.
//        Влез: Во влезот е даден прво вкупниот броj на топчиња. Следно се дава во
//        секоj нареден ред соодветно секвенцата од топчиња коjа што треба да jа сместите
//        во првата кутиjа.
//        Излез: На излез треба да се испечати состоjбата на топчињата во третата
//        кутиjа.
//        Пример 1:
//        Влез:
//        4
//        R
//        R
//        R
//        G
//        Излез:
//        G
//        Пример 2:
//        Влез:
//        3
//        B
//        B
//        B
//        Излез:
//        B B B

// vlez: G B R R B
// izlez: R R G B B

package kolokviumska;

import EdnodimenzionalniPodStrukturi.ArrayStack;

import java.util.Scanner;

public class KolokviumskaStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayStack<String> stack1 = new ArrayStack<String>(n);
        ArrayStack<String> stack2 = new ArrayStack<String>(n);
        ArrayStack<String> stack3 = new ArrayStack<String>(n);

        // handlame vmetnuvanje i proveruvanje na bomba vo prvata kutija
        for (int i = 0; i < n; i++) {
            String ball = sc.next();

            stack1.push(ball);

            // proverka za bomba - tri posledovatelni crveni topcinja
            if(stack1.size() >= 3){
                String a = stack1.pop();
                String b = stack1.pop();
                String c = stack1.pop();

                if(a.equals("R") && b.equals("R") && c.equals("R")){
                    // bomba
                    while(!stack1.isEmpty() && stack1.peek().equals("R")){
                        stack1.pop();
                    }
                }
                else{
                    stack1.push(a);
                    stack2.push(b);
                    stack3.push(c);
                }
            }
        }

        // prvo za R
        moveByColor(stack1, stack2, stack3, "R");

        // vtoro za G
        moveByColor(stack1, stack2, stack3, "G");

        // treto za B
        moveByColor(stack1, stack2, stack3, "B");

        if(stack3.isEmpty()){
            System.out.println("Empty");
        }
        else{
            ArrayStack<String> reverse = new ArrayStack<String>(n);
            while(!stack3.isEmpty()){
                reverse.push(stack3.pop());
            }
            while(!reverse.isEmpty()){
                System.out.println(reverse.pop() + " ");
            }
        }

    }

    private static void moveByColor(ArrayStack<String> s1, ArrayStack<String> s2, ArrayStack<String> s3, String color){
        while(!s1.isEmpty()){
            String top = s1.pop();
            if(top.equals(color)){
                s3.push(top);
            }
            else{
                s2.push(top);
            }
        }
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }
}
