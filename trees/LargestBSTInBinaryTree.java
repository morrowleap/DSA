/*
 * https://www.geeksforgeeks.org/problems/largest-bst/1
*/

package trees;

public class LargestBSTInBinaryTree {

    static TreeNode parent = null;
    static int largestSortedCount = Integer.MIN_VALUE;
    static int counter = 0;

    static int largestBst(TreeNode node) {
        if (node == null) {
            return largestSortedCount;
        }

        largestBst(node.left);
        TreeNode temp = parent;
        parent = node;
        if (temp != null) {
            if (temp.val >= node.val) {
                largestSortedCount = Math.max(largestSortedCount, counter);
                counter = 0;
            }
        }
        counter++;
        largestBst(node.right);

        return largestSortedCount;
    }

    public static void main(String[] args) {
        String str = "6,6,2,null,2,1,3";

        TreeNode root = BuildTreeSerializeAndDeserializeBinaryTree.deserialize(str);
        TreeNode.log(root);

        System.out.println(LargestBSTInBinaryTree.largestBst(root));
    }
}
