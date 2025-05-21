package trees;

import java.util.Arrays;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void log(TreeNode root) {
        int h = height(root), w = (1 << h) - 1;
        String[][] a = new String[h][w];
        for (String[] row : a)
            Arrays.fill(row, " ");
        fill(root, a, 0, 0, w - 1);
        for (String[] row : a) {
            for (String s : row)
                System.out.print(s);
            System.out.println();
        }
    }

    private static int height(TreeNode n) {
        return n == null ? 0 : 1 + Math.max(height(n.left), height(n.right));
    }

    private static void fill(TreeNode n, String[][] a, int d, int l, int r) {
        if (n == null || l > r)
            return;
        int m = (l + r) / 2;
        a[d][m] = String.valueOf(n.val);
        fill(n.left, a, d + 1, l, m - 1);
        fill(n.right, a, d + 1, m + 1, r);
    }
}