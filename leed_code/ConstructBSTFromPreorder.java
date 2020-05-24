/*

Construct Binary Search Tree from Preorder Traversal

Question:

Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.

Example 1:

Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]

*/

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

class ConstructBSTFromPreorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        for(int i : preorder) {
            root = build(root,i);
        }
        return root;
    }
    
    static TreeNode build(TreeNode root, int val) {
        if(root == null) {
            root = new TreeNode(val);
        } else if(root.val > val) {
           root.left = build(root.left, val);
        } else {
           root.right = build(root.right, val);
        }
        return root;
    }
}