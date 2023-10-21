package lab6;

public class SinglyLinkedList<E> {
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size;

	public SinglyLinkedList() {
		super();
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public E first() {
		return this.head.getData();
	}

	public E last() {
		return this.tail.getData();
	}

	public void addFirst(E e) {
		Node<E> newNode = new Node<E>(e);
		newNode.setNext(this.head);
		this.head = newNode;
		if (this.size == 0) {
			this.tail = this.head;
		}
		this.size++;
	}

	public void addLast(E e) {
		Node<E> newNode = new Node<E>(e);
		if (this.size == 0) {
			this.head = this.tail = newNode;
		} else {
			this.tail.setNext(newNode);
		}
		this.tail = newNode;
		this.size++;
	}

	// Removes and returns the first element of the list.
	public E removeFirst() {
		if (this.size == 0) {
			return null;
		}
		E temp = this.head.getData();
		this.head = this.head.getNext();
		this.size--;
		if (this.size == 0) {
			this.head = this.tail = null;
		}
		return temp;
	}

	// Removes and returns the last element of the list.
	public E removeLast() {
		if (this.size == 0) {
			return null;
		}
		E temp = this.tail.getData();
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
		} else {
			Node<E> current = this.head;
			while (current.getNext() != this.tail) {
				current = current.getNext();
			}
			current.setNext(null);
			this.tail = current;
		}
		this.size--;
		return temp;
	}
}
