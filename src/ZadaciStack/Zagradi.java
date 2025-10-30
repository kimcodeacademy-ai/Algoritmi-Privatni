package ZadaciStack;
import EdnodimenzionalniPodStrukturi.ArrayStack;

import java.util.Scanner;

//Да се провери дали во даден стринг сите отворени и затворени загради (), {}, [] се правилно подредени.
//        Пример:
//
//Влез: { [ ( ) ] }
//Излез: True
//
//Влез: ( [ ) ]
//Излез: False


public class Zagradi {

    public static boolean isBalanced(String expression){
        ArrayStack<Character> stack = new ArrayStack<Character>(expression.length());

        for(char c : expression.toCharArray()){
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }

            else if(c == ')' || c == ']' || c == '}'){
                if(stack.isEmpty())
                    return false;
                char top = stack.pop();
                if(!isMatching(top, c))
                    return false;
            }
        }

        return stack.isEmpty();
        // {([( )])
    }

    private static boolean isMatching(char open, char close){
        if(open == '(' && close == ')')
            return true;
        else if (open == '{' && close == '}')
            return true;
        else if (open == '[' && close == ']')
            return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        boolean result = isBalanced(input);
        if(result){
            System.out.println("True");
        }
        else {
            System.out.println("False");
        }
    }

}
