/*
 * https://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
*/

package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class BuildTreeFromInorderPreorder {
    private static ArrayDeque<Integer> preorderStack = new ArrayDeque<>();

    public static void main(String[] args) {
        ArrayList<Integer> preOrder = new ArrayList<>(Arrays.asList(1, 2, 4, 5, 3, 6, 7));
        ArrayList<Integer> inorder = new ArrayList<>(Arrays.asList(4, 2, 5, 1, 6, 3, 7));

        TreeNode root = buildTree(inorder, preOrder);

        TreeNode.log(root);

        System.out.println(TreeTraversal.preOrderTraversal(root));
        System.out.println(TreeTraversal.inOrderTraversal(root));
    }

    private static TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> preOrder) {
        for (int i = preOrder.size() - 1; i >= 0; i--) {
            preorderStack.push(preOrder.get(i));
        }

        TreeNode root = dfs(inorder);
        return root;
    }

    private static TreeNode dfs(ArrayList<Integer> inorder) {
        if (inorder.size() == 0) {
            return null;
        }

        int val = preorderStack.pop();
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

        node.left = dfs(left);
        node.right = dfs(right);

        return node;
    }
}
