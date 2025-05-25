/*
 * 2385. Amount of Time for Binary Tree to Be Infected
 * https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/description/
*/

package trees;

public class BurnBinaryTreeFromNode {

    int heightBelowFire = 0;
    boolean startFound = false;

    public int amountOfTime(TreeNode root, int start) {
        int height = distanceToStart(root, start);
        return height + startFoundAtDepth;
    }

    private int distanceToStart(TreeNode root, int start) {
        if (root == null) {
            return -1;
        }

        startFoundAtDepth++;

        int l = distanceToStart(root.left, start);
        int r = distanceToStart(root.right, start);

        if (root.val == start) {
            heightBelowFire = 1 + Math.max(l, r);
            return 0;
        }

        return 1 + Math.max(l, r);
    }

    public static void main(String[] args) {
        String str = "1,2,null,3,null,4,null,5";

        TreeNode root = BuildTreeSerializeAndDeserializeBinaryTree.deserialize(str);
        TreeNode.log(root);

        System.out.println(new BurnBinaryTreeFromNode().amountOfTime(root, 3));
    }
}
