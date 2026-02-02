//Задача 3. Избриши листови
//За дадено бинарно пребарувачко дрво да се напише функциjа коjа ´ке направи
//бришење на сите терминирачки jазли - листови од дрвото.

package ispitni.drva;

public class brisilistovi {

    public static void main(String[] args) {
        BTree<Integer> tree = new BTree<>();

        tree.makeRoot(10);

        BNode<Integer> n1 = tree.addChild(tree.root, BNode.LEFT, 5);
        BNode<Integer> n2 = tree.addChild(tree.root, BNode.RIGHT, 15);

        tree.addChild(n1, BNode.LEFT, 3);
        tree.addChild(n1, BNode.RIGHT, 7);
        tree.addChild(n2, BNode.RIGHT, 18);

        System.out.println("Pred brishenje: ");
        tree.inorder();

        tree.deleteLeaves();

        System.out.println("Po brishenje na site listovi: ");
        tree.inorder();


    }
}
