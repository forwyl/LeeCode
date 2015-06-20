package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class SymmetricTree {
	
	private String convert(TreeNode node){
		if(node == null){
			return "#";
		}else{
			return String.valueOf(node.val);
		}
	}
	
	private boolean isPalindrome(List<TreeNode> list){

		int len = list.size();
		if(len==1) return true;
		Stack<String> s = new Stack<String>();
		for(int i=0; i<len; i++){
			if(i<len/2)
				s.push(convert(list.get(i)));
			if(len%2==0 && i>=len/2){
				if(!s.pop().equals(convert(list.get(i)))) return false;
			}else if(len%2==1 &&  i>=len/2+1){
				if(!s.pop().equals(convert(list.get(i)))) return false;
			}
		}
		
		return true;		
	}
	
	public boolean isSymmetric(TreeNode root){
		
		/* null or single node cases*/
		if(root == null || (root.left==null&&root.right==null) ) return true;
		boolean isSym = true;
		Queue<TreeNode> nodeQ = new LinkedList<TreeNode>();
		nodeQ.offer(root);
		while(!nodeQ.isEmpty()){
			List<TreeNode> nodeList = new LinkedList<TreeNode>();
			while(!nodeQ.isEmpty())
				nodeList.add(nodeQ.poll());
			isSym = isPalindrome(nodeList);
			if(isSym){
				boolean isAllNull = true;
				for(TreeNode node: nodeList){
						if(node != null){
							if(node.left != null | node.right != null)
								isAllNull = false;
							nodeQ.offer(node.left);
							nodeQ.offer(node.right);
						}
				}
				if(isAllNull)
					nodeQ.clear();
			}
		}
		
		return isSym;
	}
	
	public static void main(String[] args) {
		SymmetricTree st = new SymmetricTree();
		TreeNode root = new TreeNode(1); 
		TreeNode left1 = new TreeNode(2); 
		TreeNode right1 = new TreeNode(2);
		left1.left = new TreeNode(3);
		left1.right = null;
		right1.left = new TreeNode(3);
		right1.right = null;
		root.left = left1;
		root.right = right1;
		System.out.printf("%s\n", st.isSymmetric(root));
	}

}
