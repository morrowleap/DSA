/*
 * https://www.geeksforgeeks.org/construct-a-binary-tree-from-postorder-and-inorder/
*/

package trees;

import java.util.ArrayList;
import java.util.Arrays;

import utils.TreeNode;

public class BuildTreeFromInorderPostorder {

    private static int postOrderIdx = 0;

    public static TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {
        postOrderIdx = postorder.size() - 1;
        TreeNode root = dfs(inorder, postorder);
        return root;
    }

    private static TreeNode dfs(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {
        if (inorder.isEmpty()) {
            return null;
        }

        int val = postorder.get(postOrderIdx--);
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

        node.right = dfs(right, postorder);
        node.left = dfs(left, postorder);

        return node;
    }

    public static void main(String[] args) {
        ArrayList<Integer> inorder = new ArrayList<>(Arrays.asList(4, 2, 5, 1, 6, 3, 7));
        ArrayList<Integer> postOrder = new ArrayList<>(Arrays.asList(4, 5, 2, 6, 7, 3, 1));

        TreeNode root = buildTree(inorder, postOrder);

        TreeNode.log(root);

        System.out.println(TreeTraversal.inOrderTraversal(root));
        System.out.println(TreeTraversal.postOrderTraversal(root));
    }
}
