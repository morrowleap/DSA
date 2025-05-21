package trees;

import java.util.ArrayList;
import java.util.Arrays;

public class BuildTreeFromInorderAndPostorder {
    public static TreeNode buildTree(ArrayList<Integer> inOrder, ArrayList<Integer> postorder) {
        return null;
    }

    public static void main(String[] args) {
        ArrayList<Integer> inOrder = new ArrayList<>(Arrays.asList(6, 1, 3, 2));
        ArrayList<Integer> postOrder = new ArrayList<>(Arrays.asList(6, 3, 2, 1));

        TreeNode root = buildTree(inOrder, postOrder);

        
    }
}
