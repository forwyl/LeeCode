package tree;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
    	
    	if(root == null) return root;
    	if(root.left != null) root.left = invertTree(root.left);
    	if(root.right != null) root.right = invertTree(root.right);
    	
    	TreeNode tmp = null;
    	tmp = root.left;
    	root.left = root.right;
    	root.right = tmp;
    	
    	return root;
    }
    
    private void inorder(TreeNode root){
    	if(root == null) return;
    	inorder(root.left);
    	System.out.printf("%d\t", root.val);
    	inorder(root.right);
    }
    
	public static void main(String[] args) {

		InvertBinaryTree ibt = new InvertBinaryTree();
		
		TreeNode root = new TreeNode(4); 
		TreeNode left1 = new TreeNode(2); 
		TreeNode right1 = new TreeNode(7);
		left1.left = new TreeNode(1);
		left1.right = new TreeNode(3);
		right1.left = new TreeNode(6);
		right1.right = new TreeNode(9);
		root.left = left1;
		root.right = right1;
		ibt.inorder(root);
		System.out.println();
		TreeNode result = ibt.invertTree(root);
		ibt.inorder(result);
		
	}

}
