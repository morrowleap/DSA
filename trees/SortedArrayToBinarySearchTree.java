/*
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 * Scaler
*/

package trees;

public class SortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {

    }

    public static void main(String[] args) {
        int[] nums = { -10, -3, 0, 5, 9 };

        TreeNode root = new SortedArrayToBinarySearchTree().sortedArrayToBST(nums);

        System.out.println(BuildTreeSerializeAndDeserializeBinaryTree.serialize(root));

        TreeNode.log(root);
    }
}
