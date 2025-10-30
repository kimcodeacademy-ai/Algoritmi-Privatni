package ZadaciStack;

// nie vnesuvame nekoja recenica od tastatura i treba da ja zapisheme na ekran vo obraten redosled

// pr: hello
// izlez: olleh

import EdnodimenzionalniPodStrukturi.ArrayStack;
import java.util.Scanner;

public class ReverseString {

    public static String reverseString(String text){
        ArrayStack<Character> stack = new ArrayStack<Character>(text.length());

        for(char c : text.toCharArray()){
            stack.push(c);
        }

        StringBuilder stringBuilder = new StringBuilder();
        //String str = "";
        while(!stack.isEmpty()){
            stringBuilder.append(stack.pop());
            //str += stack.pop();
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String result = sc.nextLine();

        System.out.println(result);

        System.out.println(reverseString(result));

        //ArrayStack<Character> stack = new ArrayStack<Character>();


    }

}
