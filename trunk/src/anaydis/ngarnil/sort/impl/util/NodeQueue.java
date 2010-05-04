package anaydis.ngarnil.sort.impl.util;


public class NodeQueue<T> {

	private Node<T> head, tail;

	public NodeQueue() {
		head = null;
		tail = null;
	}

	public void put(Node<T> node) {
		Node<T> t = tail;
		tail = node;
		if (empty()) {
			head = tail;
		} else {
			t.next = tail;
		}
	}

	public Node<T> get() {
		Node<T> v = head;
		v.next = null;
		head = head.next;
		return v;
	}

	public boolean empty() {
		return head == null;
	}
	

	public void printList() {
		Node<T> aux = head;
		while (aux != null) {
			System.out.println(aux.value);
			aux = aux.next;
		}
	}
	
	public Node<T> getHead() {
		return head;
	}
}