/*
 * https://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
*/

package trees;

import java.util.ArrayList;
import java.util.Arrays;

import utils.TreeNode;

public class BuildTreeFromInorderPreorder {
    private static int preOrderIdx = 0;

    public static void main(String[] args) {
        ArrayList<Integer> preOrder = new ArrayList<>(Arrays.asList(1, 2, 4, 5, 3, 6, 7));
        ArrayList<Integer> inorder = new ArrayList<>(Arrays.asList(4, 2, 5, 1, 6, 3, 7));

        TreeNode root = buildTree(inorder, preOrder);

        TreeNode.log(root);

        System.out.println(TreeTraversal.preOrderTraversal(root));
        System.out.println(TreeTraversal.inOrderTraversal(root));
    }

    private static TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> preorder) {
        TreeNode root = dfs(inorder, preorder);
        return root;
    }

    private static TreeNode dfs(ArrayList<Integer> inorder, ArrayList<Integer> preorder) {
        if (inorder.size() == 0) {
            return null;
        }

        int val = preorder.get(preOrderIdx++);
        TreeNode node = new TreeNode(val);

        int index = 0;
        while (index < inorder.size()) {
            if (inorder.get(index) == val) {
                break;
            }
            index++;
        }
        ArrayList<Integer> left = new ArrayList<>(inorder.subList(0, index));
        ArrayList<Integer> right = new ArrayList<>(inorder.subList(index + 1, inorder.size()));

        node.left = dfs(left, preorder);
        node.right = dfs(right, preorder);

        return node;
    }
}
