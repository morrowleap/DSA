/*
 * https://leetcode.com/problems/validate-binary-search-tree/description/
*/

package trees;

public class ValidateBinarySearchTree {
    TreeNode parent = null;

    public boolean isValidBST(TreeNode node) {
        if (node == null) {
            return true;
        }

        boolean l = isValidBST(node.left);
        TreeNode temp = parent;
        parent = node;
        if (temp != null) {
            if (temp.val >= node.val) {
                return false;
            }
        }
        boolean r = isValidBST(node.right);

        return l && r;
    }

    public static void main(String[] args) {
        String str = "2,2,2";

        TreeNode root = BuildTreeSerializeAndDeserializeBinaryTree.deserialize(str);
        TreeNode.log(root);

        System.out.println(new ValidateBinarySearchTree().isValidBST(root));
    }
}
