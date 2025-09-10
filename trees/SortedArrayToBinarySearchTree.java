/*
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 * Scaler
*/

package trees;

import java.util.Arrays;

import utils.TreeNode;

public class SortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return null;
        }

        int mid = n / 2;
        TreeNode root = new TreeNode(nums[mid]);

        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid + 1, n);

        root.left = sortedArrayToBST(left);
        root.right = sortedArrayToBST(right);

        return root;
    }

    public static void main(String[] args) {
        int[] nums = { -10, -3, 0, 5, 9 };

        TreeNode root = new SortedArrayToBinarySearchTree().sortedArrayToBST(nums);

        System.out.println(BuildTreeSerializeAndDeserializeBinaryTree.serialize(root));

        TreeNode.log(root);
    }
}
