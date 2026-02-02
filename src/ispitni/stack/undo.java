//Se vnesuva n i potoa se vnesuvaat N komandi.Komandite se UNDO sto go brise posledniot element
// ,ako nema posleden element se ignorira komandata.
// SHOW gi pecati vnesenite karakteri i TYPE X vesuva karakter x.
//
//        primer
//4
//TYPE H
//TYPE S
//UNDO
//SHOW
//
//        output:H

package ispitni.stack;

import java.util.Queue;
import java.util.Scanner;

public class undo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        ArrayStack<String> stack = new ArrayStack<>(n);

        for(int i = 0; i < n; i++){
            String line =  sc.nextLine();

            //Type + char
            String [] parts = line.split(" ");
            //String del = parts[1];

            if(line.startsWith("TYPE")){
                stack.push(parts[1]);
            }
            else if(line.startsWith("UNDO")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else if(line.startsWith("SHOW")){
                ArrayStack<String> stack2 = new  ArrayStack<>(stack.size());

                while(!stack.isEmpty()){
                    String tmp = stack.pop();
                    System.out.println(tmp);
                    stack2.push(tmp);
                }

                while(!stack2.isEmpty()){
                    stack.push(stack2.pop());
                }
            }
        }

    }

}
