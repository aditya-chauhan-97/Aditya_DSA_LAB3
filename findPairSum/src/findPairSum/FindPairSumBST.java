package findPairSum;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}

public class FindPairSumBST {
	
	public static Node insert(Node root, int key)
    {
        if (root == null) {
            return new Node(key);
        }
 
        if (key < root.data) {
            root.left = insert(root.left, key);
        }
 
        else {
            root.right = insert(root.right, key);
        }
 
        return root;
    }
 
    public static boolean findPair(Node root, int sum, Set<Integer> set)
    {
        if (root == null) {
            return false;
        }
 
        if (findPair(root.left, sum, set)) {
            return true;
        }
 
        if (set.contains(sum - root.data))
        {
            System.out.println("Pair is (" + (sum - root.data) + ", "
                                    + root.data + ")");
            return true;
        }
 
        else {
            set.add(root.data);
        }
 
        return findPair(root.right, sum, set);
    }

	public static void main(String[] args) {
		int[] keys = { 40, 20, 60, 10, 30, 50, 70 };
		 
        Node root = null;
        for (int key: keys) {
            root = insert(root, key);
        }
 
        int sum;
        try (Scanner sc = new Scanner(System.in)) {
			sum = sc.nextInt();
		}
        Set<Integer> set = new HashSet<>();
 
        if (!findPair(root, sum, set)) {
            System.out.println("nodes are not found");
        }
	}

}
