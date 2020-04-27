package jcapivertailu;

public class Node {
    private int data;
    private BinaryTree left;
    private BinaryTree right;
    private BinaryTree rootTree;
    private Node parent;

    public Node(int value) {
        //System.out.println("Uusi node arvolla " + value);
        data = value;
        left = right = null;
    }
    
    public Node(Node node) {
        //System.out.println("Uusi node arvolla " + node.getData());
        data = node.getData();
        left = right = null;
    }
    
    public  Node (int value, BinaryTree left, BinaryTree right) {
        data = value;
        this.left = left;
        this.right = right;
    }
    public int getData() {
        return data;
    }
    public BinaryTree left() {
        return left;
    }
    public BinaryTree right() {
        return right;
    }
    
    public void setParent(Node parent) {
        this.parent = parent;
    }
    
    public Node getParent() {
        return parent;
    }
    
    public void setLeft(BinaryTree tree) {
        left = tree;
    }
    public void setRight(BinaryTree tree) {
        right = tree;
    }

    public void setRootTree(BinaryTree root) {
        if(root == null)
            rootTree = null;
        else
            rootTree = root;
    }
    
    public BinaryTree getRootTree() {
        return rootTree;
    }
    
    public void setData(int data) {
        this.data = data;
    }
}
