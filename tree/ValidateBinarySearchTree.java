package tree;

public class ValidateBinarySearchTree {

	int pre = 0;
	int counter = 0;
	
    public boolean isValidBST(TreeNode root) {
		if(root == null) return	true;
		if(!isValidBST(root.left)) return false;
		if(counter > 0){
			if(root.val <= pre) return false;
			else pre = root.val;
		}else{
			pre = root.val;
			counter++;
		}
		if(!isValidBST(root.right)) return false;
		
		return true;
    }
    
	public static void main(String[] args) {
		
		ValidateBinarySearchTree vbst = new ValidateBinarySearchTree();
		TreeNode root = new TreeNode(2);
//		root.right = new TreeNode(1);
		root.left = new TreeNode(1);
		System.out.println(vbst.isValidBST(root));
		
	}

}
