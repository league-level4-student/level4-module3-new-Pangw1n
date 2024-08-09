package _05_Intro_to_AVL_Trees;

import java.util.Scanner;

import _03_Intro_to_Binary_Trees.BinaryTree;

public class AVLTreeDemo {

    /*
     * An AVLTree is a special BinaryTree that is capable of balancing itself.
     * With a regular binary tree, depending on the elements inserted, you might
     * have a root with one very long right branch and one very long left branch
     * with nothing else in between.
     * 
     * 1.) Read through the AVLNode and AVLTree. Notice that the methods are
     * similar to those in BinaryTree with two important distinctions:
     * 
     * a) Each Node has a balance factor that keeps track of how many levels
     * "down" it is relative to the rest of the tree.
     * 
     * b) There are "rotate" helper methods used when a given node gets too
     * unbalanced(> 1 level out of sync with the rest of the tree) to rotate
     * branches back into place.
     * 
     * 2.) Create a BinaryTree and an AVLTree.
     * 
     * 3.) Insert the same values into both trees and observe how they differ
     * using the print method. Make sure the values you pick unbalance the
     * binary tree.
     * 
     * 4.) Try removing elements from both and see how they change using one of
     * the print methods.
     */

    public static void main(String[] args) {
    	BinaryTree<Integer> bt = new BinaryTree<Integer>();
    	AVLTree<Integer> avlt = new AVLTree<Integer>();
    	
    	bt.insert(10);
    	avlt.insert(10);
    	
    	bt.insert(5);
    	avlt.insert(5);
    	
    	bt.insert(4);
    	avlt.insert(4);
    	
    	bt.insert(3);
    	avlt.insert(3);
    	
    	bt.insert(2);
    	avlt.insert(2);
    	
    	bt.insert(1);
    	avlt.insert(1);
    	
    	bt.insert(15);
    	avlt.insert(15);
    	
    	bt.insert(16);
    	avlt.insert(16);
    	
    	bt.insert(17);
    	avlt.insert(17);
    	
    	bt.insert(18);
    	avlt.insert(18);
    	
    	bt.insert(19);
    	avlt.insert(19);
    	
    	bt.printVertical();
    	avlt.printVertical();
    	
    	Scanner scanner = new Scanner(System.in);
    	scanner.nextLine();
    	scanner.close();
    	
    	bt.delete(3);
    	avlt.delete(3);
    	
    	bt.printVertical();
    	avlt.printVertical();
    }

}
