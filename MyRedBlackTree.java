
public class MyRedBlackTree<E> {

	protected RBNode<E> root;
	protected int size;

	/*function to convert from red-black tree to 2-4 tree*/
	public MyTwoFourTree<E> convertTo24() {
		FourNode<E> twoFourNode = new MyFourNode<E>(null);
		MyTwoFourTree<E> twoFourTree = new MyTwoFourTree<E>();
		/*check if the root exists*/
		if (root == null)	
			return twoFourTree;
		/*if exist process the node*/
		processNode(twoFourNode, root);
		twoFourTree.root = twoFourNode;
		twoFourTree.size = this.size;
		return twoFourTree;
	}
	
	/*function to process the given node(position it in the right location)*/
	private void processNode(FourNode<E> fourNode, RBNode<E> rbNode) {
		/*if the node is red throw exception*/
		if(rbNode.isRed())
			throw new RuntimeException("Invalid red black tree");

                /*create a 2-4 node with one element and two children*/
		if(rbNode.getLeft()!=null && !rbNode.getLeft().isRed()	&& rbNode.getRight()!=null && !rbNode.getRight().isRed()
			|| rbNode.getLeft()==null && rbNode.getRight()==null
			|| rbNode.getLeft()==null && rbNode.getRight() != null && !rbNode.getRight().isRed()
			|| rbNode.getRight()==null && rbNode.getRight() != null && !rbNode.getLeft().isRed()){
			fourNode.setSmallItem(rbNode.element());
			if(rbNode.getLeft()!=null){
				FourNode<E> subfourNode = new MyFourNode<E>(fourNode);
				fourNode.setLeft(subfourNode);
				processNode(subfourNode, rbNode.getLeft());
			}
			if(rbNode.getRight()!=null){
				FourNode<E> subfourNode = new MyFourNode<E>(fourNode);
				fourNode.setLeftMiddle(subfourNode);
				processNode(subfourNode, rbNode.getRight());
			}
		}
                /*create a 2-4 node with two elements and three children when the left children is red*/
		else if (rbNode.getLeft()!=null && rbNode.getLeft().isRed() && (rbNode.getRight()==null || !rbNode.getRight().isRed())){
			RBNode<E> redNode = rbNode.getLeft();
			fourNode.setMiddleItem(rbNode.element());
			fourNode.setSmallItem(redNode.element());
			if(redNode.getLeft()!=null){
				FourNode<E> subfourNode = new MyFourNode<E>(fourNode);
				fourNode.setLeft(subfourNode);
				processNode(subfourNode, redNode.getLeft());
			}
			if(redNode.getRight()!=null){
				FourNode<E> subfourNode = new MyFourNode<E>(fourNode);
				fourNode.setLeftMiddle(subfourNode);
				processNode(subfourNode, redNode.getRight());
			}
			if(rbNode.getRight()!=null){
				FourNode<E> subfourNode = new MyFourNode<E>(fourNode);
				fourNode.setRightMiddle(subfourNode);
				processNode(subfourNode, rbNode.getRight());
			}
		}
                /*create a 2-4 node with two elements and three children when the right children is red*/
		else if (rbNode.getRight()!=null && rbNode.getRight().isRed() && (rbNode.getLeft()==null || !rbNode.getLeft().isRed())){
			RBNode<E> redNode = rbNode.getRight();
			fourNode.setMiddleItem(redNode.element());
			fourNode.setSmallItem(rbNode.element());
			if(redNode.getLeft()!=null){
				FourNode<E> subfourNode = new MyFourNode<E>(fourNode);
				fourNode.setLeftMiddle(subfourNode);
				processNode(subfourNode, redNode.getLeft());
			}
			if(redNode.getRight()!=null){
				FourNode<E> subfourNode = new MyFourNode<E>(fourNode);
				fourNode.setRightMiddle(subfourNode);
				processNode(subfourNode, redNode.getRight());
			}
			if(rbNode.getLeft()!=null){
				FourNode<E> subfourNode = new MyFourNode<E>(fourNode);
				fourNode.setLeft(subfourNode);
				processNode(subfourNode, rbNode.getLeft());
			}
		}
                //create a 2-4 node with three elements and four children
		else {
			RBNode<E> redNode = rbNode.getLeft();
			fourNode.setMiddleItem(rbNode.element());
			fourNode.setSmallItem(redNode.element());
			if(redNode.getLeft()!=null){
				FourNode<E> subfourNode = new MyFourNode<E>(fourNode);
				fourNode.setLeft(subfourNode);
				processNode(subfourNode, redNode.getLeft());
			}
			if(redNode.getRight()!=null){
				FourNode<E> subfourNode = new MyFourNode<E>(fourNode);
				fourNode.setLeftMiddle(subfourNode);
				processNode(subfourNode, redNode.getRight());
			}
			redNode = rbNode.getRight();
			fourNode.setLargeItem(redNode.element());
			if(redNode.getLeft()!=null){
				FourNode<E> subfourNode = new MyFourNode<E>(fourNode);
				fourNode.setRightMiddle(subfourNode);
				processNode(subfourNode, redNode.getLeft());
			}
			if(redNode.getRight()!=null){
				FourNode<E> subfourNode = new MyFourNode<E>(fourNode);
				fourNode.setRight(subfourNode);
				processNode(subfourNode, redNode.getRight());
			}
		}
		/*count the number of children*/
		int i = 0;
		if(fourNode.getLeft()!=null)
			i++;
		if(fourNode.getLeftMiddle()!=null)
			i++;
		if(fourNode.getRightMiddle()!=null)
			i++;
		if(fourNode.getRight()!=null)
			i++;
		fourNode.setNumberOfChildren(i);
	}

	// all methods below are provided for your use.
	// you can add methods, but DO NOT CHANGE any of the given methods
	public boolean isEmpty() {
		return (size == 0);
	}

	public int size() {
		return size;
	}

	public boolean isRoot(RBNode<E> v) {
		return (v == root());
	}

	public RBNode<E> root() { // returns the root of the tree
		if (root == null)
			throw new RuntimeException("The tree is empty");
		return root;
	}

	public RBNode<E> left(RBNode<E> v) {
		RBNode<E> leftPos = v.getLeft();
		if (leftPos == null)
			throw new RuntimeException("No left child");
		return leftPos;
	}

	/** Returns the right child of a node. */
	public RBNode<E> right(RBNode<E> v) {
		RBNode<E> rightPos = v.getRight();
		if (rightPos == null)
			throw new RuntimeException("No right child");
		return rightPos;
	}

	/** Returns the parent of a node. */
	public RBNode<E> parent(RBNode<E> v) {
		RBNode<E> pos = v.getParent();
		if (pos == null)
			throw new RuntimeException("No parent");
		return pos;
	}

	public RBNode<E> createNode(E element, RBNode<E> parent,
					    RBNode<E> left, RBNode<E> right) {
		return new RBNode<E>(element, parent, left, right);
	}

	public RBNode<E> addRoot(E e) {
		if (!isEmpty())
			throw new RuntimeException("Tree already has a root");
		size = 1;
		root = createNode(e, null, null, null);
		return root;
	}
}
