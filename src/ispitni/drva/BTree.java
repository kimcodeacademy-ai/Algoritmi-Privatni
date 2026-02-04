// da se pronajde sumata na celo drvo


// dopolnitelno: da se presmeta sumata na jazlite koi sto imaat samo levi deca

package ispitni.drva;

public class BTree<E> {
    
    public BNode<E> root;
    
    public BTree() {
        root = null;
    }
    
    public BTree(E info) {
        root = new BNode<E>(info);
    }
    
    public void makeRoot(E elem) {
        root = new BNode<E>(elem);
    }
    
    public BNode<E> addChild(BNode<E> node, int where, E elem) {
        
        BNode<E> tmp = new BNode<E>(elem);
        
        if (where == BNode.LEFT) {
            if (node.left != null)  // veke postoi element
                return null;
            node.left = tmp;
        } else {
            if (node.right != null) // veke postoi element
                return null;
            node.right = tmp;
        }
        
        return tmp;
    }
    
    public void inorder() {
        System.out.print("INORDER: ");
        inorderR(root);
        System.out.println();
    }
    
    public void inorderR(BNode<E> n) {
        // levo - koren - desno
        if (n != null) {
            inorderR(n.left);
            System.out.print(n.info.toString()+" ");
            inorderR(n.right);
        }
    }

    public void preorder() {
        System.out.print("PREORDER: ");
        preorderR(root);
        System.out.println();
    }
    
    public void preorderR(BNode<E> n) {
        // koren - levo - desno
        if (n != null) {
            System.out.print(n.info.toString()+" ");
            preorderR(n.left);
            preorderR(n.right);
        }
    }
    
    public void postorder() {
        System.out.print("POSTORDER: ");
        postorderR(root);
        System.out.println();
    }
    
    public void postorderR(BNode<E> n) {
        // levo - desno - koren
        if (n != null) {
            postorderR(n.left);
            postorderR(n.right);
            System.out.print(n.info.toString() + " ");
        }
    }

    public void findJazol(E elem){
        BNode<E> jazol = findJazolR(root, elem);
        if (jazol != null){
            System.out.println("Jazolot so element bla bla: " + elem.toString() + " e prisuten vo ova drvo");
        }
        else{
            System.out.println("Jazolot so element bla bla: " + elem.toString() + " NE E prisuten vo ova drvo");
        }
    }

    private BNode<E> findJazolR(BNode<E> node, E elem){
        if(node == null){
            return null;
        }

        if(node.info.equals(elem)){
            return node;
        }

        BNode<E> left = findJazolR(node.left, elem);
        if(left != null){
            return left;
        }

        BNode<E> right = findJazolR(node.right, elem);
        return right;

    }

    public void deleteLeaves(){
        deleateLeavesR(root);
    }

    private BNode<E> deleateLeavesR(BNode<E> node){
        if(node == null){
            return null;
        }

        if(node.left == null && node.right == null){
            return null;
        }

        node.left = deleateLeavesR(node.left);
        node.right = deleateLeavesR(node.right);

        return node;
    }

}
