//За дадено бинарното дрво и jазел за коj се вчитува податочниот елемент од
//тастатура, да се провери дали вредноста на jазелот постои во бинарното дрво.

package drva.podstrukturi;

public class NajdiJazol {

    public static void main(String[] args) {
        System.out.println("Vnesi 6 jazli: ");
        BTree<String> stringBTree = new BTree<>();
        stringBTree.makeRoot("vojdan");

        BNode<String> nasko = stringBTree.addChild(stringBTree.root, 1, "nasko");
        BNode<String> mila = stringBTree.addChild(stringBTree.root, 2, "mila");
        stringBTree.addChild(nasko, 1, "dusan");
        BNode<String> jana = stringBTree.addChild(mila, 2, "jana");
        stringBTree.addChild(jana, 1, "blaze");

        stringBTree.preorder();

        stringBTree.findJazol("blaze");
        stringBTree.findJazol("iva");
    }
}
