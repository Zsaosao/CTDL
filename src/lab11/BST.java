package lab11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BST<E extends Comparable<E>> {
	private BNode<E> root;

	public BST() {
		this.root = null;
	}

	// Add element e into BST
	public void add(E e) {
		if (root == null) {
			root = new BNode<E>(e);
		} else {
			BNode<E> current = root;
			while (true) {
				if (e.compareTo(current.getData()) < 0) {
					if (current.getLeft() == null) {
						current.setLeft(new BNode<E>(e));
						break;
					} else {
						current = current.getLeft();
					}
				} else if (e.compareTo(current.getData()) > 0) {
					if (current.getRight() == null) {
						current.setRight(new BNode<E>(e));
						break;
					} else {
						current = current.getRight();
					}
				} else {
					current.setData(e);
					break;
				}
			}
		}
	}

	// Add a collection of elements col into BST
	public void add(Collection<E> col) {
		for (E e : col) {
			add(e);
		}
	}

	// compute the depth of a node in BST
	public int depth(E node) {
		if (root == null) {
			return -1;
		}
		BNode<E> current = root;
		int depth = 0;
		while (true) {
			if (node.compareTo(current.getData()) < 0) {
				if (current.getLeft() == null) {
					return -1;
				} else {
					current = current.getLeft();
					depth++;
				}
			} else if (node.compareTo(current.getData()) > 0) {
				if (current.getRight() == null) {
					return -1;
				} else {
					current = current.getRight();
					depth++;
				}
			} else {
				return depth;
			}
		}
	}

	// compute the height of BST
	public int height() {
		return computeHeight(root);

	}

	private int computeHeight(BNode<E> node) {
		if (node == null) {
			return -1;
		}
		int leftHeight = computeHeight(node.getLeft());
		int rightHeight = computeHeight(node.getRight());
		return Math.max(leftHeight, rightHeight) + 1;
	}

	// Compute total nodes in BST
	public int size() {
		return computeSize(root);
	}

	private int computeSize(BNode<E> node) {
		if (node == null) {
			return 0;
		}
		return computeSize(node.getLeft()) + computeSize(node.getRight()) + 1;
	}

	// Check whether element e is in BST
	public boolean contains(E e) {
		if (root == null) {
			return false;
		}
		return depth(e) != -1;
	}

	// Find the minimum element in BST
	public E findMin() {
		if (root == null) {
			return null;
		}
		BNode<E> current = root;
		while (current.getLeft() != null) {
			current = current.getLeft();
		}
		return current.getData();

	}

	// Find the maximum element in BST
	public E findMax() {
		if (root == null) {
			return null;
		}
		BNode<E> current = root;
		while (current.getRight() != null) {
			current = current.getRight();
		}
		return current.getData();
	}

	// Remove element e from BST
	public boolean remove(E e) {
		if (root == null) {
			return false;
		}
		BNode<E> current = root;
		BNode<E> parent = null;
		while (true) {
			if (e.compareTo(current.getData()) < 0) {
				if (current.getLeft() == null) {
					return false;
				} else {
					parent = current;
					current = current.getLeft();
				}
			} else if (e.compareTo(current.getData()) > 0) {
				if (current.getRight() == null) {
					return false;
				} else {
					parent = current;
					current = current.getRight();
				}
			} else {
				break;
			}
		}
		if (current.getLeft() == null) {
			if (parent == null) {
				root = current.getRight();
			} else {
				if (current == parent.getLeft()) {
					parent.setLeft(current.getRight());
				} else {
					parent.setRight(current.getRight());
				}
			}
		} else {
			BNode<E> rightMost = current.getLeft();
			BNode<E> rightMostParent = current;
			while (rightMost.getRight() != null) {
				rightMostParent = rightMost;
				rightMost = rightMost.getRight();
			}
			current.setData(rightMost.getData());
			if (rightMost == rightMostParent.getLeft()) {
				rightMostParent.setLeft(rightMost.getLeft());
			} else {
				rightMostParent.setRight(rightMost.getLeft());
			}
		}
		return true;
	}

	// get the descendants of a node
	public List<E> descendants(E data) {
		if (root == null) {
			return null;
		}

		BNode<E> current = findNode(data, root);
		if (current == null) {
			return null;
		}

		List<E> descendants = new ArrayList<>();
		collectDescendants(current, descendants);
		return descendants;
	}

	private BNode<E> findNode(E data, BNode<E> node) {
		while (node != null) {
			int cmp = data.compareTo(node.getData());
			if (cmp < 0) {
				node = node.getLeft();
			} else if (cmp > 0) {
				node = node.getRight();
			} else {
				return node;
			}
		}
		return null;
	}

	private void collectDescendants(BNode<E> node, List<E> descendants) {
		if (node != null) {
			collectDescendants(node.getLeft(), descendants);
			descendants.add(node.getData());
			collectDescendants(node.getRight(), descendants);
		}
	}

	// get the ancestors of a node
	public List<E> ancestors(E data) {
		if (root == null) {
			return null;
		}
		BNode<E> current = root;
		List<E> ancestors = new ArrayList<E>();
		while (true) {
			if (data.compareTo(current.getData()) < 0) {
				if (current.getLeft() == null) {
					return null;
				} else {
					ancestors.add(current.getData());
					current = current.getLeft();
				}
			} else if (data.compareTo(current.getData()) > 0) {
				if (current.getRight() == null) {
					return null;
				} else {
					ancestors.add(current.getData());
					current = current.getRight();
				}
			} else {
				return ancestors;
			}
		}
	}

	// display BST using inorder approach
	public void inorder() {
		inorderTraversal(root);
	}

	private void inorderTraversal(BNode<E> node) {
		if (node != null) {
			inorderTraversal(node.getLeft());
			System.out.print(node.getData() + " ");
			inorderTraversal(node.getRight());
		}
	}

	// display BST using preorder approach
	public void preorder() {
		preorderTraversal(root);
	}

	private void preorderTraversal(BNode<E> node) {
		if (node != null) {
			System.out.print(node.getData() + " ");
			preorderTraversal(node.getLeft());
			preorderTraversal(node.getRight());
		}
	}

	// display BST using postorder approach
	public void postorder() {
		postorderTraversal(root);
	}

	private void postorderTraversal(BNode<E> node) {
		if (node != null) {
			postorderTraversal(node.getLeft());
			postorderTraversal(node.getRight());
			System.out.print(node.getData() + " ");
		}
	}

}