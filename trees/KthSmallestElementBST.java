/*
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * 
 * https://takeuforward.org/data-structure/kth-largest-smallest-element-in-binary-search-tree/
 * https://youtu.be/9TJYWh0adfk
*/

package trees;

import utils.TreeNode;

public class KthSmallestElementBST {
    int count = 0;
    int val = -1;

    private void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        inorder(root.left, k);
        count++;
        if (count == k) {
            val = root.val;
            return;
        }
        inorder(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return val;
    }
}
