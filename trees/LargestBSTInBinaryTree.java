/*
 * https://www.geeksforgeeks.org/problems/largest-bst/1
*/

package trees;

import org.w3c.dom.Node;

public class LargestBSTInBinaryTree {

    static int largestBst(Node root) {
        // Write your code here

    }

    public static void main(String[] args) {
        String str = "5,2,4,1,3";

        TreeNode root = BuildTreeSerializeAndDeserializeBinaryTree.deserialize(str);
        TreeNode.log(root);

        System.out.println(largestBst(root));
    }
}
