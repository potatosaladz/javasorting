package anaydis.ngarnil.sort.impl.util;

public class LinkedList<T> {

	private Node<T> head;
	private Node<T> actual;
	
	public void add(Node<T> x) {
		if(head == null) {
			head = x;
			actual = head;
		} else {
			actual.next = x;
			actual = x;
		}
	}
	
	public void print() {
		Node<T> aux = head;
		System.out.println("aux: " + head);
		while (aux != null) {
			System.out.println(aux.value);
			aux = aux.next;
		}
	}
	
	public Node<T> getHead() {
		return head;
	}
}
