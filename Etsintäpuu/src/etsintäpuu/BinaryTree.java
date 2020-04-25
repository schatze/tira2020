package etsintäpuu;

import etsintäpuu.Lue;

public class BinaryTree {

    private Node root;
    public static BinaryTree found; // findWithPreOrder()-operaation apurakenne

    public BinaryTree(String rootValue) {
        //System.out.println("Uuden rootin arvo on:" + Integer.parseInt(rootValue));
        root = new Node(Integer.parseInt(rootValue));
        root.setRootTree(this);
    }

    public BinaryTree(Node rootNode) {
        root = new Node(rootNode);
        root.setRootTree(this);
    }

    public BinaryTree() {

    }

    public void addValue(Node node) {
        if (root == null) {
            node.setRootTree(this);
            root = node;
            return;
        }
        if (root.getData() > node.getData()) {   // Vasemmalle

            if (root.left() != null) {
                root.left().addValue(node);
            } else {
                BinaryTree tree = new BinaryTree();
                node.setParent(this.getRoot());
                node.setRootTree(tree);
                tree.setRoot(node);
                root.setLeft(tree);
                return;
            }
            
        } else {

            if (root.right() != null) {
                root.right().addValue(node);
            } else {
                BinaryTree tree = new BinaryTree();
                node.setParent(this.getRoot());
                node.setRootTree(tree);
                tree.setRoot(node);
                root.setRight(tree);
                return;
            }
            
        }

    }

    /*public BinaryTree(String rootValue, BinaryTree left, BinaryTree right){
        root = new Node(rootValue, left, right);
    } */
    public void preOrder() {
        if (root != null) {
            System.out.println(root.getData() + ",");
            if (root.left() != null) // pääseeekö vasemmalle?
            {
                root.left().preOrder();
            }
            if (root.right() != null) // pääseekö oikealle?
            {
                root.right().preOrder();
            }
        }

    }
    
    public Node findLeftmostInRightChild(Node node) {   // Etsi oikeapuolimmaisen noden vasemmanpuolisin node
        if(node == null || node.right() == null)
            return null;
        
        Node rightNode = node.right().getRoot();
        if(rightNode.left() == null)    // Ei ole vasemmalla puolella mitään
            return rightNode;
        
        Node leftmostNode = rightNode.left().getRoot();
        while(leftmostNode.left() != null) {
            leftmostNode = leftmostNode.left().getRoot();
        }
        
        return leftmostNode;
    }

    public Node findNodeByValue(int value) {
        if (root.getData() == value) {
            //System.out.println("Löytyi node arvolla " + value);
            return root;
        }

        if (value < root.getData()) {   // Vasemmalle
            if (root.left() != null) {
                return root.left().findNodeByValue(value);
            } else {

            }
        } else {
            if (root.right() != null) {
                return root.right().findNodeByValue(value);
            } else {

            }
        }

        //System.out.println("Ei löytynyt nodea arvolla " + value);
        return null;
    }

    public void clearNode(Node node) {
        node.getRootTree().setRoot(null);
        node.setParent(null);
        node.setLeft(null);
        node.setRight(null);
        node = null;
    }

    public boolean deleteNodeByValue(int value) {

        Node poistettavaNode = findNodeByValue(value);

        if (poistettavaNode == null) {   // Poistettavaa nodea ei löytynyt
            return false;
        }

        if (poistettavaNode.left() == null && poistettavaNode.right() == null) {     // Ei ole alipuita, voi poistaa suoraan
            clearNode(poistettavaNode);
            return true;
        }

        if (poistettavaNode.left() != null && poistettavaNode.right() != null) {     // Molemmilla puolilla alipuut
            Node leftmostNodeOnRight = findLeftmostInRightChild(poistettavaNode);
            poistettavaNode.setData(leftmostNodeOnRight.getData());
            clearNode(leftmostNodeOnRight);
            leftmostNodeOnRight = null;
            return true;
        }

        // Vain toisella puolella alipuu
        if (poistettavaNode.left() != null) {    // vasemmalla on lapsinode
            if (poistettavaNode == root) {   // poistettava solmu on juuri
                root = poistettavaNode.left().getRoot();
                root.setParent(null);
                root.setRootTree(this);
                poistettavaNode = null;
                //clearNode(poistettavaNode);
                return true;
            } else {
                if (poistettavaNode.getParent().left() != null) {   // pitää tarkistaa ettei ole null, muuten tulee exception seuraavassa vertailussa
                    if (poistettavaNode.getParent().left().getRoot() == poistettavaNode) {   // poistettava node on vasemmalla puolella
                        poistettavaNode.getParent().setLeft(poistettavaNode.left());
                        clearNode(poistettavaNode);
                        return true;
                    }
                }

                if (poistettavaNode.getParent().right() != null) {   // pitää tarkistaa ettei ole null, muuten tulee exception seuraavassa vertailussa
                    if (poistettavaNode.getParent().right().getRoot() == poistettavaNode) {   // poistettava node on vasemmalla puolella
                        poistettavaNode.getParent().setRight(poistettavaNode.left());
                        clearNode(poistettavaNode);
                        return true;
                    }
                }
            }

        }
        if (poistettavaNode.right() != null) {   // oikealla on lapsinode
            if (poistettavaNode == root) {   // poistettava solmu on juuri
                root = poistettavaNode.right().getRoot();
                root.setParent(null);
                root.setRootTree(this);
                poistettavaNode = null;
                //clearNode(poistettavaNode);
                return true;
            } else {
                if (poistettavaNode.getParent().left() != null) {   // pitää tarkistaa ettei ole null, muuten tulee exception seuraavassa vertailussa
                    if (poistettavaNode.getParent().left().getRoot() == poistettavaNode) {   // poistettava node on vasemmalla puolella
                        poistettavaNode.getParent().setLeft(poistettavaNode.right());
                        clearNode(poistettavaNode);
                        return true;
                    }
                }

                if (poistettavaNode.getParent().right() != null) {   // pitää tarkistaa ettei ole null, muuten tulee exception seuraavassa vertailussa
                    if (poistettavaNode.getParent().right().getRoot() == poistettavaNode) {   // poistettava node on vasemmalla puolella
                        poistettavaNode.getParent().setRight(poistettavaNode.right());
                        clearNode(poistettavaNode);
                        return true;
                    }
                }

            }

        }

        return false;
    }

    // l�ydetty alipuu asetetaan staattiseen muuttujaan found
    public void findWithPreOrder() {

        if (root != null) {
            System.out.print(root.getData() + ": muokkaatko tätä?");
            if (root.left() == null) {
                System.out.print(" (vasemmalla tilaa)");
            }
            if (root.right() == null) {
                System.out.println(" (oikealla tilaa)");
            }
            char select = Lue.merkki();
            if (select == 'k') {
                found = this;
                return;
            }
            if (found == null && root.left() != null) // p��seek� vasemmalle?
            {
                root.left().findWithPreOrder();
            }
            if (found == null && root.right() != null) // p��seek� oikealle?
            {
                root.right().findWithPreOrder();
            }
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

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node node) {
        if (node == null) {
            root = null;
        } else {
            root = node;
        }
    }
}
