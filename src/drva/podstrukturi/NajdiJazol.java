//За дадено бинарното дрво и jазел за коj се вчитува податочниот елемент од
//тастатура, да се провери дали вредноста на jазелот постои во бинарното дрво.

package drva.podstrukturi;

public class NajdiJazol {

    public static void main(String[] args) {

        System.out.println("Vnesi jazli vo drvoto: ");
        BTree<String> stringBTree = new BTree<String>("gligorce");
        //stringBTree.makeRoot("gligorce");

        BNode<String> riste = stringBTree.addChild(stringBTree.root, 1, "riste");
        BNode<String> petar = stringBTree.addChild(stringBTree.root, 2, "petar");

        BNode<String> kole = stringBTree.addChild(riste, 1, "kole");
        BNode<String> zvone = stringBTree.addChild(riste, 2, "zvone");

        BNode<String> vladimir = stringBTree.addChild(zvone, 1, "vladimir");
        BNode<String> branko = stringBTree.addChild(zvone, 2, "branko");

        stringBTree.preorder();
//        stringBTree.inorder();
//        stringBTree.postorder();

        stringBTree.findJazol("kole");
        stringBTree.findJazol("petko");

    }


}
