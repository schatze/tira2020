package etsintäpuu;


import etsintäpuu.Lue;

public class BinaryTree {

    private Node root;
    public static BinaryTree found; // findWithPreOrder()-operaation apurakenne

    public BinaryTree(String rootValue) {
        //System.out.println("Uuden rootin arvo on:" + Integer.parseInt(rootValue));
        root = new Node(Integer.parseInt(rootValue));
    }
    
    public BinaryTree(Node rootNode) {
        root = new Node(rootNode);
    }
    
    public void addValue(Node node) {
        if(root == null) {
            root = node;
        }
        if(root.getData() > node.getData()) {   // Vasemmalle
            
            if(root.left() != null) {
                root.left().addValue(node);
            } else {
                
                BinaryTree tree = new BinaryTree(node);
                root.setLeft(tree);
                
            }
            
        } else {
            
            if(root.right() != null) {
                root.right().addValue(node);
            } else {
                
                BinaryTree tree = new BinaryTree(node);
                root.setRight(tree);
                
            }
            
        }
        
    }

    /*public BinaryTree(String rootValue, BinaryTree left, BinaryTree right){
        root = new Node(rootValue, left, right);
    } */

    public void preOrder() {
        if (root != null) {
            System.out.println(root.getData()+",");
            if (root.left() != null) // pääseeekö vasemmalle?
                root.left().preOrder();
            if (root.right() != null) // pääseekö oikealle?
                root.right().preOrder();
        }

    }
    
    public Node findNodeByValue(int value) {
        if(root.getData() == value) {
            //System.out.println("Löytyi node arvolla " + value);
            return root;
        }
        
        if(value < root.getData()) {   // Vasemmalle
            if(root.left() != null) {
                return root.left().findNodeByValue(value);
            } else {
                
            }
        } else {
            if(root.right() != null) {
                return root.right().findNodeByValue(value);
            } else {
                
            }
        }
        
        //System.out.println("Ei löytynyt nodea arvolla " + value);
        return null;
    }

    // l�ydetty alipuu asetetaan staattiseen muuttujaan found
    public void findWithPreOrder() {

        if (root != null) {
            System.out.print(root.getData()+ ": muokkaatko tätä?");
            if (root.left()== null)
                System.out.print(" (vasemmalla tilaa)");
            if (root.right() == null)
                System.out.println(" (oikealla tilaa)");
            char select = Lue.merkki();
            if (select =='k') {
                found = this;
                return;
            }
            if (found==null && root.left() != null) // p��seek� vasemmalle?
                root.left().findWithPreOrder();
            if (found== null && root.right() != null) // p��seek� oikealle?
                root.right().findWithPreOrder();
        }

    }
    public void setNotFound() {
        found = null;
    }
    public static BinaryTree getFound() {
        return found;
    }

    public void setLeft(BinaryTree tree) {
        root.setLeft(tree);
    }

    public void setRight(BinaryTree tree) {
        root.setRight(tree);
    }
}
