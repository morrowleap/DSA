package trees;

import java.util.ArrayList;

import utils.TreeNode;

public class TreeTraversal {
    public static ArrayList<Integer> inOrderTraversal(TreeNode root) {
        ArrayList<Integer> out = new ArrayList<Integer>();
        if (root == null) {
            return out;
        }

        out.addAll(inOrderTraversal(root.left));
        out.add(root.val);
        out.addAll(inOrderTraversal(root.right));

        return out;
    }

    public static ArrayList<Integer> postOrderTraversal(TreeNode root) {
        ArrayList<Integer> out = new ArrayList<Integer>();
        if (root == null) {
            return out;
        }

        out.addAll(postOrderTraversal(root.left));
        out.addAll(postOrderTraversal(root.right));
        out.add(root.val);

        return out;
    }

    public static ArrayList<Integer> preOrderTraversal(TreeNode root) {
        ArrayList<Integer> out = new ArrayList<Integer>();
        if (root == null) {
            return out;
        }

        out.add(root.val);
        out.addAll(preOrderTraversal(root.left));
        out.addAll(preOrderTraversal(root.right));

        return out;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // root.left = new TreeNode(2);
        // root.right = new TreeNode(3);
        // root.right.left = new TreeNode(6);
        // root.right.left.right = new TreeNode(7);

        TreeNode.log(root);

        System.out.println(preOrderTraversal(root));
        System.out.println(inOrderTraversal(root));
        System.out.println(postOrderTraversal(root));
    }
}
