public class MyFourNode<E> implements FourNode<E> {
  //implement this class
  //
	private FourNode<E> left, leftMiddle, rightMiddle, right, parent;
	private E smallItem, middleItem, largeItem;
	private int numberOfChildren;
	
  public MyFourNode(E element, FourNode<E> parent, FourNode<E> left, FourNode<E> leftMiddle, FourNode<E> rightMiddle, FourNode<E> right) {
    setParent(parent);
    setLeft(left);
    setLeftMiddle(leftMiddle);
    setRightMiddle(rightMiddle);
    setRight(right);
  }

	public MyFourNode(FourNode<E> parent) {
		this.parent = parent;
	}

	public int getNumberOfChildren() {
		return numberOfChildren;
	}

	public void setNumberOfChildren(int k) {
		numberOfChildren = k;
	}

	public E getSmallItem() {
		return smallItem;
	}

	public E getMiddleItem() {
		return middleItem;
	}

	public E getLargeItem() {
		return largeItem;
	}

	public void setSmallItem(E e) {
		smallItem = e;
	}

	public void setMiddleItem(E e) {
		middleItem = e;
	}

	public void setLargeItem(E e) {
		largeItem = e;
	}

	public FourNode<E> getLeft() {
		return left;
	}

	public FourNode<E> getLeftMiddle() {
		return leftMiddle;
	}

	public FourNode<E> getRightMiddle() {
		return rightMiddle;
	}

	public FourNode<E> getRight() {
		return right;
	}

	public FourNode<E> getParent() {
		return parent;
	}

	public void setLeft(FourNode<E> v) {
		left = v;
	}

	public void setLeftMiddle(FourNode<E> v) {
		leftMiddle = v;
	}

	public void setRightMiddle(FourNode<E> v) {
		rightMiddle = v;
	}

	public void setRight(FourNode<E> v) {
		right = v;
	}

	public void setParent(FourNode<E> v) {
		parent = v;
	}
}
