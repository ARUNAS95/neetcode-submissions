/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int pathMax){
        if(node == null) return 0;

        int goodNode = node.val >= pathMax ? 1 : 0;
        pathMax = Math.max(node.val , pathMax);

        return goodNode + dfs(node.left, pathMax) + dfs(node.right, pathMax);
    }
}
