package model_02;

import java.util.Stack;

import javax.swing.RootPaneContainer;

/**
 * 二叉树实现
 * 
 * @author 57451
 *
 */
public class BinaryTree {

	private Node root = null;

	public BinaryTree(int value) {
		// TODO Auto-generated constructor stub
		root = new Node(value);
		root.leftChild = null;
		root.rightChild = null;
	}

	// 查找
	public Node findKey(int value) {
		return null;

	}

	// 插入
	public String insert(int value) {
		String error = null;
		Node node = new Node(value);

		Node current = root;
		Node parent = null;
		if (root == null) {
			root = new Node(value);
			root.leftChild = null;
			root.rightChild = null;
		} else {
			while (true) {
				if (value < current.value) {
					parent = current;
					current = parent.leftChild;
					if (current == null) {
						parent.leftChild = node;
						break;
					}
				} else if (value > current.value) {
					parent = current;
					current = parent.rightChild;
					if (current == null) {
						parent.rightChild = node;
						break;
					}
				} else {
					error = "having same value in binary tree";
				}
			}
		}
		return error;
	}

	public void inOrderTraverse() {
		System.out.print("中序遍历:");
		inOrderTraverse(root);
		System.out.println();
	} // 中序遍历递归操作

	private void inOrderTraverse(Node node) {
		// TODO Auto-generated method stub
		if (node == null) {
			return;
		}
		inOrderTraverse(node.leftChild);
		node.display();
		inOrderTraverse(node.rightChild);
	}

	/** 
     * 中序非递归遍历： 
     *     1）对于任意节点current，若该节点不为空则将该节点压栈，并将左子树节点置为current，重复此操作，直到current为空。 
     *     2）若左子树为空，栈顶节点出栈，访问节点后将该节点的右子树置为current 
     *     3) 重复1、2步操作，直到current为空且栈内节点为空。 
     */  
	public void inOrderByStack() {
		System.out.print("中序非递归遍历:");  
        Stack<Node> stack = new Stack<Node>();  
        Node current = root;
        while (current != null || !stack.isEmpty()) {
    		
        	while(current != null) {
        		stack.push(current);
        		current = current.leftChild;
        	}
        	if (!stack.isEmpty()) {
        		current = stack.pop();
        		current.display();
        		current = current.rightChild;
        		
        	}
        }
        stack.peek();
        System.out.println(); 

	} // 中序遍历非递归操作
	

	/**
	 * //前序遍历(递归)： 1、访问这个节点 2、调用自身来遍历节点的左子树 3、调用自身来遍历节点的右子树
	 */
	public void preOrderTraverse() {
		System.out.print("前序遍历:");
		System.out.print("root初始值:" + root.value);
		preOrderTraverse(root);
		System.out.println();

	}

	private void preOrderTraverse(Node node) {
		// TODO Auto-generated method stub
		node.display();
		if (node.leftChild != null) {
			preOrderTraverse(node.leftChild);
		}
		if (node.rightChild != null) {
			preOrderTraverse(node.rightChild);
		}

	}

	public void preOrderByStack() {
	} // 前序遍历非递归操作

	public void postOrderTraverse() {
		System.out.print("前序遍历:");
		postOrderTraverse(root);
		System.out.println();
	} // 后序遍历

	private void postOrderTraverse(Node node) {
		// TODO Auto-generated method stub
		if (node == null) {
			return;
		}
		postOrderTraverse(node.leftChild);
		postOrderTraverse(node.rightChild);
		node.display();
	}

	public void postOrderByStack() {
	} // 后序遍历非递归操作

	public int getMinValue() {
		return 0;
	} // 得到最小(大)值

	public boolean delete(int value) {
		return false;
	} // 删除

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt = new BinaryTree(52);
		bt.insert(580);
		bt.insert(12);
		bt.insert(50);
		// bt.insert(52);
		bt.insert(9);
		bt.insert(888);
		bt.insert(248);
		bt.insert(32);
		bt.insert(666);
		bt.insert(455);
		bt.insert(777);
		bt.insert(999);
		bt.preOrderTraverse();
		bt.inOrderByStack();
	}

}
