/** Class implementing a node of a binary red-black tree */
public class RBNode<E> {
    protected E element; // element stored at this node
    protected boolean isRed; // we add a color field
    protected RBNode<E> left, right, parent; // adjacent nodes

    public RBNode(E element, RBNode<E> parent, RBNode<E> left, RBNode<E> right) {
        setElement(element);
        setParent(parent);
        setLeft(left);
        setRight(right);
    isRed = true;
    }

	public RBNode(RBNode<E> parent, E element, boolean isRed) {
		this.parent = parent;
		this.isRed = isRed;
		this.element = element;
	}
    

    /** Returns the elements stored at this position. */
    public E element() { return element; }

    /** Sets the element stored at this position. */
    public void setElement(E o) { element = o; }

    /** Returns the left child of this position. */
    public RBNode<E> getLeft() { return left; }

    /** Sets the left child of this position. */
    public void setLeft(RBNode<E> v) { left = v; }

    /** Returns the right child of this position. */
    public RBNode<E> getRight() { return right; }

    /** Sets the right child of this position. */
    public void setRight(RBNode<E> v) { right = v; }

    /** Returns the parent of this position. */
    public RBNode<E> getParent() { return parent; }

    /** Sets the parent of this position. */
    public void setParent(RBNode<E> v) { parent = v; }

    public boolean isRed() {return isRed;}

    public void makeRed() {isRed = true;}
    
    public void makeBlack() {isRed = false;}
    
    public void setColour(boolean colour) {isRed = colour;}
}
