/*
 * 2385. Amount of Time for Binary Tree to Be Infected
 * https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/description/
*/

package trees;

public class BurnBinaryTreeFromNode {

    int level = 0;
    int height = 0;
    boolean startFound = false;

    public int amountOfTime(TreeNode root, int start) {
        int height = distanceToStart(root, start);
        return height + level;
    }

    private int distanceToStart(TreeNode root, int start) {
        if (root == null) {
            return -1;
        }

        if (startFound) {
            level--;
        }

        int l = distanceToStart(root.left, start);
        int r = distanceToStart(root.right, start);

        if (root.val == start) {
            startFound = true;
            height = Math.max(height, 1 + Math.max(l, r));
            return 0;
        }

        if (startFound) {
            level++;
        }

        height = Math.max(height, 1 + Math.max(l, r));

        return 1 + Math.max(l, r);
    }

    public static void main(String[] args) {
        String str = "1,2,null,3,null,4,null,5";

        TreeNode root = BuildTreeSerializeAndDeserializeBinaryTree.deserialize(str);
        TreeNode.log(root);

        System.out.println(new BurnBinaryTreeFromNode().amountOfTime(root, 3));
    }
}
