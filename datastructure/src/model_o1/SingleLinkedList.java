package model_o1;


public class SingleLinkedList {
	private Node head;
	private Node point;
	private int count;

	private class Node {
		private Object data;

		public Object getData() {
			return data;
		}

		public void setData(Object data) {
			this.data = data;
		}

		private Node next;

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Node() {
		}

		public Node(Object data) {
			this.data = data;
		}
	}

	public SingleLinkedList() {
		head = new Node();
		head.data = null;
		head.next = null;
		count = 0;
	}

	/**
	 * 增加节点
	 * 
	 * @param args
	 */
	public void addNode(Node node) {
		if (head == null) {
			head.data = node;
			head.next = null;
		} else {
			head.next = node;
			point = node;
		}
		this.count++;
	}

	public int size() {
		return count;
	}

	public boolean isEmpty() {
		return this.head == null ? true : false;
	}

	public boolean contain(Object data) {
		return isContain(this.head, data);
	}

	private boolean isContain(Node head2, Object data) {
		// TODO Auto-generated method stub
		if (head2 == null) {
			return false;
		}
		if (head2.getData() == data) {
			return true;
		}
		while (head2.getNext() != null) {
			point = head2.getNext();
			if (point.getData() == data) {
				return true;
			}
			head2 = point;
		}
		return false;
	}

	public Object getData(int index) {
		if (index < 0 || index >= this.count) {
			return null;
		}
		return getDataByIndex(this.head, 0, index);
	}

	private Object getDataByIndex(Node head2, int i, int index) {
		// TODO Auto-generated method stub
		if (index < 0 || index > count) {
			return null;
		}
		if (i == index) {
			return head2.getData();
		}
		return getDataByIndex(head2, i++, index);
	}

	public void deleteNodeByData(Node node, Object data) {
		if (this.head.getData() == data) {
			this.head = head.getNext();
			count--;
			return;
		}
		while (node.getNext() != null) {
			if (data.equals(node.getNext().getData())) {
				point = node.getNext();
				node.setNext(point.getNext());
				this.count--;
				return;
			} else {
				node = node.getNext();
			}
		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
