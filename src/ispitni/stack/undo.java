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

import java.util.Scanner;

public class undo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        Stack<String> stack = new ArrayStack<>(N);

        for(int i = 0; i < N; i++){

            String line = sc.nextLine();

            if(line.startsWith("TYPE")){
                String [] parts = line.split(" ");
                if(parts[1] != null)
                    stack.push(parts[1]);
            }
            else if(line.startsWith("UNDO")){
                if(!stack.isEmpty())
                    stack.pop();
            }
            else{

                // H, S, R
                // SHOW: H S R
                // TYPE M
                // H, S, R, M

                ArrayStack<String> stack2 = new ArrayStack<>(N);

                while(!stack.isEmpty()){
                    String el = stack.pop();
                    System.out.println(el);
                    stack2.push(el);
                }

                while(!stack2.isEmpty()){
                    stack.push(stack2.pop());
                }

            }

        }


    }

}
