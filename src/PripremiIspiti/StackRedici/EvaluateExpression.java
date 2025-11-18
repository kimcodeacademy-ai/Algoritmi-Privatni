//Даден е аритметички израз во инфикс нотација, кој може да содржи:
//цели броеви (позитивни или негативни)
//оператори: +, -, *, /, ^
//унарни + и - (пример: -5, +(3+2))
//загради: ( и )
//правилен приоритет на оператори
//^ е десно-асоцијативен (значи 2 ^ 3 ^ 2 = 2 ^ (3 ^ 2))
//Треба да го израчунаш резултатот со два стека:
//стек за вредности (броеви)
//стек за оператори (+, -, …)
//Влез
//Еден ред кој содржи валиден аритметички израз, пример:
//-3 + (2 * 4) - 5^2
//Може да има празни места.
//Излез
//Еден единствен цел број — резултатот на изразот.


        package PripremiIspiti.StackRedici;

import EdnodimenzionalniPodStrukturi.LinkedStack;

import java.util.Scanner;

public class EvaluateExpression {
    static boolean isOp(char c){ return "+-*/^".indexOf(c)>=0; }
    static int prec(char c){
        if (c=='^') return 3;
        if (c=='*'||c=='/') return 2;
        if (c=='+'||c=='-') return 1;
        return 0;
    }
    static boolean rightAssoc(char c){ return c=='^'; }

    static void apply(LinkedStack<Integer> vals, LinkedStack<Character> ops) {
        char op = ops.pop();
        int b = vals.pop();
        int a = vals.pop();
        long res;
        switch(op){
            case '+': res = (long)a + b; break;
            case '-': res = (long)a - b; break;
            case '*': res = (long)a * b; break;
            case '/':
                if (b==0) throw new ArithmeticException("Delba so nula");
                res = a / b; break;
            case '^':
                // целобројна степен, претпостави b>=0 за испит; ако не, фрли
                if (b<0) throw new ArithmeticException("Negativen stepen");
                long pow=1, base=a;
                int e=b;
                while(e>0){ if((e&1)==1) pow*=base; base*=base; e>>=1; }
                res = pow; break;
            default: throw new RuntimeException("Nepoznat op");
        }
        // ограничување во int опсег за испит
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) throw new ArithmeticException("Preliv");
        vals.push((int)res);
    }

    public static int eval(String s){
        LinkedStack<Integer> vals = new LinkedStack<>();
        LinkedStack<Character> ops = new LinkedStack<>();
        s = s.replaceAll("\\s+","");
        int n=s.length();
        int i=0;
        boolean expectUnary = true;
        while(i<n){
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                long v=0;
                while(i<n && Character.isDigit(s.charAt(i))){
                    v = v*10 + (s.charAt(i)-'0');
                    i++;
                }
                if (v>Integer.MAX_VALUE) throw new ArithmeticException("Preliv");
                vals.push((int)v);
                expectUnary=false;
                continue;
            } else if (c=='('){
                ops.push(c);
                expectUnary=true;
            } else if (c==')'){
                while(!ops.isEmpty() && ops.peek()!='(') apply(vals,ops);
                if (ops.isEmpty()) throw new RuntimeException("Nevalidni zagradi");
                ops.pop(); // remove '('
                expectUnary=false;
            } else if (isOp(c)){
                // унарни +/-
                if (expectUnary && (c=='+'||c=='-')){
                    // трансформирај унарен на бинарен со 0 op x
                    vals.push(0);
                }
                while(!ops.isEmpty() && isOp(ops.peek())){
                    char top = ops.peek();
                    int pt = prec(top), pc = prec(c);
                    if (pt > pc || (pt==pc && !rightAssoc(c))){
                        apply(vals,ops);
                    } else break;
                }
                ops.push(c);
                expectUnary=true;
            } else {
                throw new RuntimeException("Nevaliden znak: "+c);
            }
            i++;
        }
        while(!ops.isEmpty()){
            char top = ops.peek();
            if (top=='(' || top==')') throw new RuntimeException("Nevalidni zagradi");
            apply(vals,ops);
        }
        if (vals.size()!=1) throw new RuntimeException("Nevaliden izraz");
        return vals.pop();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String expr = sc.nextLine();
        System.out.println(eval(expr));
        sc.close();
    }
}
