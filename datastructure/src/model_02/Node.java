package model_02;

public class Node {
	int value;
	Node leftChild;
	Node rightChild;

	public Node(int value) {
		// TODO Auto-generated constructor stub

		this.value = value;
	}

	public void display() {
		System.out.println(this.value + " ");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(value);
	}
}
