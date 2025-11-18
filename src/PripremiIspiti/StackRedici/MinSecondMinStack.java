//Имаш обичен стек направен со LinkedStack<Integer>, и треба да имплементираш нова структура MinStack која поддржува:
//push(x)
//pop()
//top()
//getMin() → го враќа тековниот минимум
//getSecondMin() → го враќа вториот минимум (второ најмало)

//Сите операции мора да бидат O(1) (амортизирано), без скенирање на целиот стек.
//❗ Забрането: креирање дополнителни листи, скенирање, сортирање…
//✔ Дозволено: користење на помошен стек за да следиш минимални состојби.

//Клучната идеја
//Се користат два стека:
//data – ги чува сите вредности (како обичен стек)
//aux – за секој push чува специјален запис со:
//тековниот минимум
//број колку пати се појавува минимумот
//тековниот втор минимум
//број колку пати се појавува вториот минимум



package PripremiIspiti.StackRedici;

import EdnodimenzionalniPodStrukturi.LinkedStack;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class MinSecondMinStack {
    private static class State {
        int min;
        int minCount;
        Integer secondMin; // null ако нема втор минимум
        int secondCount;
        State(int min, int minCount, Integer secondMin, int secondCount) {
            this.min = min; this.minCount = minCount;
            this.secondMin = secondMin; this.secondCount = secondCount;
        }
        State copy() { return new State(min, minCount, secondMin, secondCount); }
    }

    private final LinkedStack<Integer> data = new LinkedStack<>();
    private final LinkedStack<State> aux = new LinkedStack<>();

    public void push(int x) {
        data.push(x);
        if (aux.isEmpty()) {
            aux.push(new State(x, 1, null, 0));
            return;
        }
        State s = aux.peek();
        State ns = s.copy();
        if (x < s.min) {
            ns.secondMin = s.min;
            ns.secondCount = s.minCount;
            ns.min = x;
            ns.minCount = 1;
        } else if (x == s.min) {
            ns.minCount++;
        } else {
            // x > min
            if (s.secondMin == null || x < s.secondMin) {
                ns.secondMin = x;
                ns.secondCount = 1;
            } else if (s.secondMin != null && x == s.secondMin) {
                ns.secondCount++;
            }
        }
        aux.push(ns);
    }

    public int pop() {
        aux.pop();
        return data.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return aux.peek().min;
    }

    public int getSecondMin() {
        State s = aux.peek();
        if (s.secondMin == null) throw new NoSuchElementException("Nema vtor minimum");
        return s.secondMin;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = Integer.parseInt(sc.nextLine().trim());
        MinSecondMinStack ms = new MinSecondMinStack();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < q; i++) {
            String line = sc.nextLine().trim();
            if (line.startsWith("PUSH")) {
                int x = Integer.parseInt(line.split("\\s+")[1]);
                ms.push(x);
            } else if (line.equals("POP")) {
                ms.pop();
            } else if (line.equals("TOP")) {
                out.append(ms.top()).append('\n');
            } else if (line.equals("MIN")) {
                out.append(ms.getMin()).append('\n');
            } else if (line.equals("SECOND_MIN")) {
                out.append(ms.getSecondMin()).append('\n');
            }
        }
        System.out.print(out.toString());
        sc.close();
    }
}