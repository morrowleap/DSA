/*
 * 2385. Amount of Time for Binary Tree to Be Infected
 * https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/description/
*/

package trees;

public class BurnBinaryTreeFromNode {
    int burnTime = 0;

    public int amountOfTime(TreeNode root, int start) {
        calculateBurnTime(root, start);
        return burnTime;
    }

    private boolean calculateBurnTime(TreeNode root, int start) {
        if (root == null) {
            return false; // burnt node not found
        }

        if (root.val == start) {
            burnTime = Math.max(burnTime, height(root));
            return true; // burnt node found
        }

        boolean l = calculateBurnTime(root.left, start);
        boolean r = calculateBurnTime(root.right, start);

        if (l) {
            burnTime = 1 + burnTime; // for left node
            burnTime = Math.max(burnTime, 1 + height(root.right));
            return true;
        }
        if (r) {
            burnTime = 1 + burnTime; // for right node
            burnTime = Math.max(burnTime, 1 + height(root.left));
            return true;
        }

        return false;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void main(String[] args) {
        String str = "1,2,null,3,null,4,null,5";

        TreeNode root = BuildTreeSerializeAndDeserializeBinaryTree.deserialize(str);
        TreeNode.log(root);

        System.out.println(new BurnBinaryTreeFromNode().amountOfTime(root, 3));
    }
}
