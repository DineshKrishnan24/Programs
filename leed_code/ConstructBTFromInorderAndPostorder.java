/* 

Question:

Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

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
class ConstructBTFromInorderAndPostorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(IntStream.of(inorder).boxed().collect(Collectors.toList()),IntStream.of(postorder).boxed().collect(Collectors.toList()));
        
    }
    
    static TreeNode build(List<Integer> inorder,List<Integer> postorder) {
        if(inorder.size() == 0)
            return null;
        int rootIndex = inorder.indexOf(postorder.get(postorder.size()-1));
        TreeNode root = new TreeNode();
        root.val = postorder.get(postorder.size()-1);
        inorder.remove(inorder.indexOf(root.val));
        postorder.remove(postorder.indexOf(root.val));
        if(rootIndex >= 0 && rootIndex <=postorder.size()) {
            root.left = build(inorder.subList(0,rootIndex),postorder.subList(0,rootIndex));
            root.right = build(inorder,postorder);    
        }
        
        return root;   
    }
}