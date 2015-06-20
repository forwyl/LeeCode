package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        
    	List<List<Integer>> resList = new ArrayList<List<Integer>>();
    	if(root == null)
    		return resList;

		List<Integer> rList = new ArrayList<Integer>();
		rList.add(root.val);
		resList.add(rList);
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		
		while(!q.isEmpty()){
			List<TreeNode> nodeList = new ArrayList<TreeNode>();
			List<Integer> levelList = new ArrayList<Integer>();
			do{
				nodeList.add(q.poll());
			}while(!q.isEmpty());
			
			for(TreeNode node:nodeList){
				if(node.left != null){
					TreeNode lNode = node.left;
					q.offer(lNode);
					levelList.add(lNode.val);
				}
				if(node.right != null){
					TreeNode rNode = node.right;
					q.offer(rNode);
					levelList.add(rNode.val);
				}
			}
			
			if(levelList.size() > 0)
				resList.add(levelList);
			
		}
		
    	return resList;
    }
    
	public static void main(String[] args) {
		
		BinaryTreeLevelOrderTraversal btot = new BinaryTreeLevelOrderTraversal();

	}

}
