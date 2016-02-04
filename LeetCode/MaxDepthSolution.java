/*
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
*/

/* TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MaxDepthSolution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int ldepth = maxDepth(root.left);
        int rdepth = maxDepth(root.right);
        return (1+ Math.max(ldepth,rdepth));
    }
}