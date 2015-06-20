package tree;

public class MinimumDepthofBinaryTree {

	int min = 0;
	
	private void findDepth(TreeNode root, int depth){
			
		if(root == null)
			return;
		if(root.left == null && root.right == null){
			if(min == 0){
				min = depth;
			}else if(depth < min){
				min = depth;
			}
			return;
		}
		if(root.left != null){
			findDepth(root.left, depth+1);
		}
		if(root.right != null){
			findDepth(root.right, depth+1);
		}
		
	}
	
    public int minDepth(TreeNode root) {

    	findDepth(root, 1);
    	
    	return min;
    }
    
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = null;
		root.right = null;
		TreeNode left1 = new TreeNode(2);
		left1.left = null;
		left1.right = null;
		TreeNode right1 = new TreeNode(3);
		right1.left = null;
		right1.right = null;
		TreeNode left2 = new TreeNode(4);
		left2.left = null;
		left2.right = null;
		
		left1.left = left2;
		root.left = left1;
		root.right = right1;

		MinimumDepthofBinaryTree mdbt = new MinimumDepthofBinaryTree();
		int res = mdbt.minDepth(new TreeNode(1));
		System.out.println("---");
		System.out.printf("Depth: %d\n", res);
		
	}

}
