package com.codewithmosh.algorthm2.binarytrees;

public class BT_DepthFirstTraversals {
    public static void main(String[] args) {
        BT_DepthFirstTraversals btd = new BT_DepthFirstTraversals();
        BinarySearchTree bt = new BinarySearchTree();
        bt.insert(20);
        bt.insert(10);
        bt.insert(30);
        bt.insert(6);
        bt.insert(14);
        bt.insert(24);
        bt.insert(3);
        bt.insert(8);
        bt.insert(26);
        System.out.println("PreOrder -------------- ");
        btd.preOrderTraversal(bt.getRoot());
        System.out.println("\nInOrder -------------- ");
        btd.inOrderTraversal(bt.getRoot());
        System.out.println("\nPostOrder -------------- ");
        btd.postOrderTraversal(bt.getRoot());

        System.out.println("\n\nHeight == "+ btd.height(bt.getRoot()));

        System.out.println("\n\nMinimum == "+ btd.minimum(bt.getRoot()));


        System.out.println("\n\nMaximum == "+ btd.maximum(bt.getRoot()));

    }

    void preOrderTraversal(BinarySearchTree.Node node ){//root left right
        if(node==null)
            return;
        System.out.print(node.getValue()+"\t ");
        preOrderTraversal(node.getLeftChild());
        preOrderTraversal(node.getRightChild());

    }
    void inOrderTraversal(BinarySearchTree.Node node ) { // left root right
        if (node == null)
            return;
        inOrderTraversal(node.getLeftChild());
        System.out.print(node.getValue() + "\t ");
        inOrderTraversal(node.getRightChild());

    }
    void postOrderTraversal(BinarySearchTree.Node node ) { // left right root
        if (node == null)
            return;
        postOrderTraversal(node.getLeftChild());
        postOrderTraversal(node.getRightChild());
        System.out.print(node.getValue() + "\t ");
    }

    int height(BinarySearchTree.Node node){
        if(node==null)
            return -1;
        if(node.getLeftChild()==null && node.getRightChild()==null)
            return 0;
        return 1+ Math.max(height(node.getLeftChild()),height(node.getRightChild()));
    }

    int minimum(BinarySearchTree.Node node){
        if(node.getLeftChild()!=null){
            return minimum(node.getLeftChild());
        }
        return node.getValue();
    }


    int maximum(BinarySearchTree.Node node){
        if(node.getRightChild()!=null){
            return maximum(node.getRightChild());
        }
        return node.getValue();
    }


}
