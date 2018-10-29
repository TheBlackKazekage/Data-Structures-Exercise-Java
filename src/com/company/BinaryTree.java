package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class BinaryTree {
    /*Binary trees have a max of 2 children per parent node
    * The value in the left child node is lesser than the parent's value
    * The value in the right child node is greater than the parent's value
    * A node without a child is called a leaf
    * */

    private Node root;

    private void display(Node t){
        if(t != null){
            display(t.getLeft());
            System.out.println(t.getValue());
            display(t.getRight());
        }
    }

    private void addNode(int val){
        Node newNode = new Node(val);

        if(root == null){
            root = newNode;
        }else{
            Node child = root;

            Node futureParent;

            while(true){
                futureParent = child;

                if(val < futureParent.getValue()){
                    child = child.getLeft();

                    if(child == null){
                        //leaf node
                        futureParent.setLeft(newNode);
                        return;
                    }
                }else{
                    child = child.getRight();

                    if(child == null){
                        //leaf node
                        futureParent.setRight(newNode);
                        return;
                    }
                }
            }
        }
    }

    private static BufferedReader input;

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        System.out.print("Enter the number of nodes you want to enter: ");
        int num = getInput();
        Random random = new Random();
        random.ints(num);

        for(int i = 0; i < num; i++){
            tree.addNode(random.nextInt(50));
        }

        //tree.display(tree.root);

        //tree.root.print();

        //printBinaryTree(tree.root, 0);
    }

    private static int getInput(){
        int nodes = 0;

        try{
            input = new BufferedReader(new InputStreamReader(System.in));
            nodes = Integer.parseInt(input.readLine());
        }catch (IOException e){
            e.getMessage();
        }finally {
            if(input != null){
                try {
                    input.close();
                } catch (IOException e) {
                    e.getMessage();
                }
            }
        }

        return nodes;
    }

}

class Node {
    private int value;
    private Node left;
    private Node right;

    public Node(int val){
        this.value = val;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void print() {
        print("", this, false);
    }

    public void print(String prefix, Node n, boolean isLeft) {
        if (n != null) {
            System.out.println (prefix + (isLeft ? "|-- " : "\\-- ") + n.getValue());
            print(prefix + (isLeft ? "|   " : "    "), n.getLeft(), true);
            print(prefix + (isLeft ? "|   " : "    "), n.getRight(), false);
        }
    }

    public static void printBinaryTree(Node root, int level){
        if(root == null)
            return;

        printBinaryTree(root.getRight(), level+1);

        if(level != 0){
            for(int i = 0;i < level-1; i++)
                System.out.print("|\t");
            System.out.println("|-------" + root.getValue());
        }
        else
            System.out.println(root.getValue());
        printBinaryTree(root.left, level+1);
    }

}
