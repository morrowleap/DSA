/*
 * https://www.geeksforgeeks.org/problems/largest-bst/1
*/

package trees;

public class LargestBSTInBinaryTree {

    TreeNode parent = null;
    int largestSortedCount = Integer.MIN_VALUE;

    public int largestBst(TreeNode node) {
        dfs(node);
        return largestSortedCount;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int l = dfs(node.left);
        int r = dfs(node.right);

        if (isValidBST(node)) {
            largestSortedCount = Math.max(largestSortedCount, 1 + l + r);
        }

        return 1 + l + r;
    }

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
        // String str = "5,2,4,1,3";
        String str = "6,6,2,null,2,1,3";

        TreeNode root = BuildTreeSerializeAndDeserializeBinaryTree.deserialize(str);
        TreeNode.log(root);

        System.out.println(new LargestBSTInBinaryTree().largestBst(root));
    }
}
