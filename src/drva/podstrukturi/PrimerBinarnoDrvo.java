package drva.podstrukturi;

public class PrimerBinarnoDrvo {

    public static void main(String[] args) {
        System.out.println("vnesi 5 jazli vo drvoto: ");

        BTree<String> stringBTree = new BTree<String>();

        stringBTree.makeRoot("crvena");

        BNode<String> violetova = stringBTree.addChild(stringBTree.root, 1, "violetova");
        BNode<String> zolta = stringBTree.addChild(stringBTree.root, 2, "zolta");
        BNode<String> sina = stringBTree.addChild(zolta, 2, "sina");
        BNode<String> crna = stringBTree.addChild(zolta, 1, "crna");

        stringBTree.preorder();
        stringBTree.inorder();
        stringBTree.postorder();
    }
}
