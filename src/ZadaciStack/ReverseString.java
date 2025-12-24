package ZadaciStack;

// nie vnesuvame nekoja recenica od tastatura i treba da ja zapisheme na ekran vo obraten redosled

// pr: hello
// izlez: olleh

import EdnodimenzionalniPodStrukturi.ArrayStack;
import java.util.Scanner;

public class ReverseString {

    public static void reverseString(String text){
        ArrayStack<Character> stack = new ArrayStack<Character>(text.length());

        // karakter po karakter
        for(char c : text.toCharArray()){
            stack.push(c);
        }

        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(stack.size());

        while(!stack.isEmpty()){
//            char c = stack.pop();
//            stringBuilder.append(c);
            System.out.print(stack.pop());
        }

        System.out.println();
        //System.out.println(stringBuilder.toString());
        System.out.println(stack.size());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String result = sc.nextLine();
        System.out.println(result);
        reverseString(result);
    }
}
