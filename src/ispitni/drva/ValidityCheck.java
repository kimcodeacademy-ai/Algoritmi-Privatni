////Да се напише функција ValidityCheck што ќе провери дали кај дадено дрво важи дека за секој јазел
////неговите деца имаат info-поле со помала или еднаква вредност од вредноста на info-полето
////на тој јазел и во зависност од тоа да се испечати true или false.
//
//package ispitni.drva;
//
//import java.io.*;
//import java.util.*;
//
//public class ValidityCheck {
//    public static void main(String[] args) throws Exception {
//        int i;
//        int index;
//        String action;
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        // Читање на бројот на јазли
//        String firstLine = br.readLine();
//        if (firstLine == null) return;
//        int N = Integer.parseInt(firstLine.trim());
//
//        BNode<Integer> nodes[] = new BNode[N];
//        BTree<Integer> tree = new BTree<Integer>();
//
//        // Иницијализација на низата од јазли
//        for (i = 0; i < N; i++)
//            nodes[i] = new BNode<Integer>(0);
//
//        for (i = 0; i < N; i++) {
//            String line = br.readLine();
//            if (line == null) break;
//
//            // КОРИСТЕЊЕ НА SPLIT НАМЕСТО STRINGTOKENIZER
//            String[] parts = line.trim().split("\\s+");
//
//            index = Integer.parseInt(parts[0]);
//            nodes[index].info = Integer.parseInt(parts[1]);
//            action = parts[2];
//
//            if (action.equals("LEFT")) {
//                int parentIndex = Integer.parseInt(parts[3]);
//                tree.addChild(nodes[parentIndex], BNode.LEFT, nodes[index].info);
//            } else if (action.equals("RIGHT")) {
//                int parentIndex = Integer.parseInt(parts[3]);
//                tree.addChild(nodes[parentIndex], BNode.RIGHT, nodes[index].info);
//            } else {
//                // "ROOT" случај
//                tree.makeRoot(nodes[index].info);
//            }
//        }
//
//        br.close();
//
//        // Повикување на функцијата за проверка
//        System.out.println(validTree(tree.root));
//    }
//
//    // Рекурзивна функција за проверка на валидност
//    public static boolean validTree(BNode<Integer> root) {
//        // Празно дрво или лист се секогаш валидни
//        if (root == null) {
//            return true;
//        }
//
//        // Проверка на лево дете: ако постои, мора да е помало или еднакво
//        if (root.left != null && root.left.info > root.info) {
//            return false;
//        }
//
//        // Проверка на десно дете: ако постои, мора да е помало или еднакво
//        if (root.right != null && root.right.info > root.info) {
//            return false;
//        }
//
//        // Рекурзивно провери ги двете поддрва
//        return validTree(root.left) && validTree(root.right);
//    }
//}