/*
 * 2385. Amount of Time for Binary Tree to Be Infected
 * https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/description/
*/

package trees;

public class BurnBinaryTreeFromNode {
    int burnTime = 0;
    int singleStringCounter = 0;

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
        if (l) {
            singleStringCounter++; // for left node
            int rightHeight = 1 + height(root.right);
            burnTime = Math.max(burnTime, singleStringCounter + rightHeight);
            return true;
        }
        boolean r = calculateBurnTime(root.right, start);
        if (r) {
            singleStringCounter++; // for right node
            int leftHeight = 1 + height(root.left);
            burnTime = Math.max(burnTime, singleStringCounter + leftHeight);
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
        String str = "1,5,3,null,4,10,6,9,2";

        TreeNode root = BuildTreeSerializeAndDeserializeBinaryTree.deserialize(str);
        TreeNode.log(root);

        System.out.println(new BurnBinaryTreeFromNode().amountOfTime(root, 3));
    }
}
