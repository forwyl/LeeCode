package tree;

public class BalancedBinaryTree {

	private int getHeight(TreeNode root){
		
		if(root == null)
			return 0;
		
		int leftHeight = getHeight(root.left);
		if(leftHeight == -1)
			return -1;
		int rightHeight = getHeight(root.right);
		if(rightHeight == -1)
			return -1;
		if(Math.abs(leftHeight-rightHeight) > 1)
			return -1;
		
		return  1+Math.max(leftHeight, rightHeight);
	}
	
    public boolean isBalanced(TreeNode root) {
    	
    	return (getHeight(root) != -1);
    }
    
	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = null;
		root.right = null;
		TreeNode left1 = new TreeNode(2);
		left1.left = null;
		left1.right = null;
		TreeNode right1 = null;
//		right1.left = null;
//		right1.right = null;
		TreeNode left2 = new TreeNode(4);
		left2.left = null;
		left2.right = null;
		
		left1.left = left2;
		root.left = left1;
		root.right = right1;
		
		BalancedBinaryTree bbt = new BalancedBinaryTree();
		boolean res = bbt.isBalanced(root);
		System.out.printf("%s\n", res);
	}

}
