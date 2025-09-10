package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

import utils.TreeNode;

public class BuildTreeFromLevelorderInorder {

    private static int levelorderIdx = 0;

    public static void main(String[] args) {
        ArrayList<Integer> levelOrder = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        ArrayList<Integer> inorder = new ArrayList<>(Arrays.asList(4, 2, 5, 1, 6, 3, 7));

        TreeNode root = buildTree(inorder, levelOrder);

        TreeNode.log(root);

        System.out.println(LevelOrderTraversal.levelOrder(root));
        System.out.println(TreeTraversal.inOrderTraversal(root));
    }

    private static TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> levelOrder) {
        if (inorder.isEmpty())
            return null;
        levelorderIdx = 0;
        ArrayDeque<Segment> queue = new ArrayDeque<>();
        queue.add(new Segment(0, inorder.size() - 1, null, false));
        TreeNode root = null;

        while (!queue.isEmpty()) {
            Segment seg = queue.remove();
            if (seg.start > seg.end)
                continue;

            int val = levelOrder.get(levelorderIdx++);
            TreeNode node = new TreeNode(val);
            if (seg.parent == null) {
                root = node;
            } else if (seg.isLeft) {
                seg.parent.left = node;
            } else {
                seg.parent.right = node;
            }

            int idx = seg.start;
            while (idx <= seg.end && inorder.get(idx) != val)
                idx++;

            queue.add(new Segment(seg.start, idx - 1, node, true));
            queue.add(new Segment(idx + 1, seg.end, node, false));
        }

        return root;
    }

    private static class Segment {
        int start, end;
        TreeNode parent;
        boolean isLeft;

        Segment(int s, int e, TreeNode p, boolean l) {
            start = s;
            end = e;
            parent = p;
            isLeft = l;
        }
    }
}
