package com.dev.rangetree;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Node represents a range that will be stored in a BST
 * 
 * @author martinarmenta
 *
 */
class Node {

	Node(int lo, int hi, Node parent) {
		this.lo = lo;
		this.hi = hi;
	}

	/*
	 * lo represents lower value in range
	 */
	int lo;

	/**
	 * hi represents upper value in range
	 */
	int hi;

	Node left;
	Node right;
}

/**
 * Class RangeTree uses a BST data structure to store zip code ranges that in turn maybe combined
 * for efficient storage and removal
 * @author martinarmenta
 *
 */
public class RangeTree {

	/**
	 * List of ranges that will be returned
	 */
	List<String> ranges;

	Node root;

	public RangeTree() {
		ranges = new ArrayList<String>();
	}

	/**
	 * Returns the ranges in order
	 * 
	 * @param inputArray
	 * @return List<String>
	 */
	public List<String> processRanges(String[][] inputArray) {
		for (String[] value : inputArray) {
			// if first value then insert at root
			if (root == null) {
				System.out.println("root: " + value[0] + "," + value[1]);
				root = new Node(Integer.parseInt(value[0]), Integer.parseInt(value[1]), null);
			} else {
				// insert rest of the values
				insert(Integer.parseInt(value[0]), Integer.parseInt(value[1]), root);
			}
		}

		return readRanges(root);
	}

	/**
	 * insert method checks if range lies between the lo and hi of current node
	 * if so it then updates the corresponding values instead of creating a new
	 * node
	 * 
	 * @param x
	 * @param y
	 * @param current
	 */
	private Node insert(int x, int y, Node current) {
		System.out.println("Inserting " + x + "," + y);

		// find current node to insert

		// check if values are in range of current node
		// is there overlap in lower bound?
		if ((x >= current.lo) && y <= current.lo) {
			// do nothing no need to create a new node
		} else if (y < current.lo) {
			// add left node
			if (current.left == null) {
				System.out.println("Current(" + current.lo + "," + current.hi + ")->left: " + x + "," + y);
				current.left = new Node(x, y, current);
			} else
				insert(x, y, current.left);
		} else if (x > current.hi) {
			// add right node
			if (current.right == null) {
				System.out.println("Current(" + current.lo + "," + current.hi + ")->right: " + x + "," + y);
				current.right = new Node(x, y, current);
			} else
				insert(x, y, current.right);
		}
		// // first check parent
		// else if(current.parent.lo>= x && current.parent.hi >= y && y >=
		// current.lo) {
		//
		// }
		else if (y >= current.lo && x <= current.lo) {
			// node overlaps to the left so we need to update lower bound of
			// range
			System.out.println("Updating Node: " + current.lo + "," + current.hi);
			current.lo = x;
			System.out.println("Updated Node lo " + current.lo + "," + current.hi);
			// visit children nodes
			updateLeft(current);
		} else if (x <= current.hi && y >= current.hi) {
			// node overlaps to the right so we need to update upper bound of
			// range
			System.out.println("Updating Node: " + current.lo + "," + current.hi);
			current.hi = y;
			System.out.println("Updated Node hi " + current.lo + "," + current.hi);
			updateRight(current);
		}
		return current;
	}

	/**
	 * method updateLeft Recusively update left sub-tree
	 * 
	 * @param current
	 */
	private void updateLeft(Node current) {
		// if left node is in range then delete and update
		if (current == null)
			return;
		else {
			if (current.left != null) {
				// compare
				if (current.lo <= current.left.hi) {
					// update
					current.lo = current.left.lo;
				}
				updateLeft(current.left);
				current.left = null;
			}

		}

	}

	/**
	 * method updateRight Recusively update left sub-tree
	 * 
	 * @param current
	 */
	private void updateRight(Node current) {
		// if left node is in range then delete and update
		if (current == null)
			return;
		else {
			if (current.right != null) {
				// compare
				if (current.hi >= current.right.lo) {
					// update
					current.hi = current.right.hi;
				}
				updateRight(current.right);
				current.right = null;
			}

		}

	}

	/**
	 * readRanges method visits the nodes of the tree "In Order" and prints the
	 * corresponding values
	 * 
	 * @param current
	 * @return List<String>
	 */
	public List<String> readRanges(Node current) {
		if (current == null)
			return null;
		readRanges(current.left);
		// is there an overlap to the left?
		// if(current)
		ranges.add("[" + current.lo + "," + current.hi + "] ");
		readRanges(current.right);
		return ranges;
	}

}
