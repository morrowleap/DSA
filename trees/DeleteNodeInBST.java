/*
 * https://leetcode.com/problems/delete-node-in-a-bst/
 * 
 * 
*/

package trees;

import utils.TreeNode;

public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode[] res = findNodeAndParent(root, key, null);

        // Node with key value does not exist
        if (res == null) {
            return root;
        }

        TreeNode node = res[0], parent = res[1];

        if (parent == null) {
            if (node.right != null) {
                TreeNode cur = this.pickSmallestOnRight(node);
                int val = cur.val;
                node = deleteNode(node, cur.val);
                node.val = val;
            } else if (node.left != null) {
                TreeNode cur = this.pickBiggestOnLeft(node);
                int val = cur.val;
                node = deleteNode(node, cur.val);
                node.val = val;
            } else {
                return null;
            }

            return node;
        }

        if (node.left == null && node.right == null) {
            if (parent.left == node) {
                parent.left = null;
            } else if (parent.right == node) {
                parent.right = null;
            }
        } else if (node.left == null && node.right != null) {
            if (parent.left == node) {
                parent.left = node.right;
            } else if (parent.right == node) {
                parent.right = node.right;
            }
        } else if (node.left != null && node.right == null) {
            if (parent.left == node) {
                parent.left = node.left;
            } else if (parent.right == node) {
                parent.right = node.left;
            }
        } else {
            TreeNode cur = this.pickSmallestOnRight(node);
            int val = cur.val;
            node = deleteNode(node, cur.val);
            node.val = val;
        }

        return root;
    }

    private TreeNode[] findNodeAndParent(TreeNode root, int key, TreeNode parent) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            return new TreeNode[] { root, parent };
        }

        TreeNode[] nodeParent = null;
        if (root.val > key) {
            nodeParent = findNodeAndParent(root.left, key, root);
        } else {
            nodeParent = findNodeAndParent(root.right, key, root);
        }
        return nodeParent;
    }

    private TreeNode pickSmallestOnRight(TreeNode root) {
        // Find inorder successor
        TreeNode cur = root.right;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }

    private TreeNode pickBiggestOnLeft(TreeNode root) {
        // Find inorder predecessor
        TreeNode cur = root.left;
        while (cur.right != null) {
            cur = cur.right;
        }
        return cur;
    }
}
