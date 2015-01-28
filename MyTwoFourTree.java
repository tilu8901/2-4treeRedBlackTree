
public class MyTwoFourTree<E> {

  protected FourNode<E> root;
  protected int size;

  public MyRedBlackTree<E> convertToRB() {
	  	RBNode<E> rbNode = new RBNode<E>(null, null, false);
		MyRedBlackTree<E> redBlackTree = new MyRedBlackTree<E>();
		/*if no root throw exception*/
		if (root == null)
			return redBlackTree;
		/*else process the node*/
		processNode(root, rbNode);
		redBlackTree.root = rbNode;
		redBlackTree.size = this.size;
		return redBlackTree;
  }
  /*function to process the given node(position it in the right location)*/
  private void processNode(FourNode<E> twoFourNode, RBNode<E> blackNode){

	int numberOfChildren = 0;
		if(twoFourNode.getLeft()!=null)						//if child exists +1
			numberOfChildren++;
		if(twoFourNode.getLeftMiddle()!=null)
			numberOfChildren++;
		if(twoFourNode.getRightMiddle()!=null)
			numberOfChildren++;
		if(twoFourNode.getRight()!=null)
			numberOfChildren++;
		
	if(numberOfChildren == 0){ //leaf node        
		int i = 0;
		if(twoFourNode.getSmallItem() != null)			//if item exists +1
			i++;
		if(twoFourNode.getMiddleItem() != null)
			i++;
		if(twoFourNode.getLargeItem() != null)
			i++;
		if(i == 0)
			throw new RuntimeException("Invalid two four tree");
                //contains 1 item
		if(i == 1){
			blackNode.setElement(twoFourNode.getSmallItem());
		}
                //contains 2 item
		if(i == 2){
			blackNode.setElement(twoFourNode.getMiddleItem());
			RBNode redNode = new RBNode(blackNode, null, true);
			blackNode.setLeft(redNode);
			redNode.setElement(twoFourNode.getSmallItem());
		}
                //contains 3 item
		if(i == 3){
			blackNode.setElement(twoFourNode.getMiddleItem());
			RBNode redNode = new RBNode(blackNode, null, true);
			blackNode.setLeft(redNode);
			redNode.setElement(twoFourNode.getSmallItem());
			redNode = new RBNode(blackNode, null, true);
			blackNode.setRight(redNode);
			redNode.setElement(twoFourNode.getLargeItem());
		}
	}
        //The 2-4 node creates a black node(parent)
	else if(numberOfChildren == 2){
		if(twoFourNode.getSmallItem() == null)
			throw new RuntimeException("Invalid two four tree");
		blackNode.setElement(twoFourNode.getSmallItem());
		RBNode subBlackNode = new RBNode(blackNode, null, false);
		blackNode.setLeft(subBlackNode);
		processNode(twoFourNode.getLeft(), subBlackNode);
		subBlackNode = new RBNode(blackNode, null, false);
		blackNode.setRight(subBlackNode);
		processNode(twoFourNode.getLeftMiddle(), subBlackNode);
	}
        //create a black node(parent) and a red node(child)
	else if(numberOfChildren == 3){
		if(twoFourNode.getSmallItem() == null || twoFourNode.getMiddleItem() == null)
			throw new RuntimeException("Invalid two four tree");
		blackNode.setElement(twoFourNode.getMiddleItem());
		RBNode redNode = new RBNode(blackNode, twoFourNode.getSmallItem(), true);
		blackNode.setLeft(redNode);
		RBNode subBlackNode = new RBNode(redNode, null, false);
		redNode.setLeft(subBlackNode);
		processNode(twoFourNode.getLeft(), subBlackNode);
		subBlackNode = new RBNode(redNode, null, false);
		redNode.setRight(subBlackNode);
		processNode(twoFourNode.getLeftMiddle(), subBlackNode);
		subBlackNode = new RBNode(blackNode, null, false);
		blackNode.setRight(subBlackNode);
		processNode(twoFourNode.getRightMiddle(), subBlackNode);
	}
        //create a black node(parent) and two red nodes(children)
	else if(numberOfChildren == 4){
		if(twoFourNode.getSmallItem() == null || twoFourNode.getMiddleItem() == null || twoFourNode.getLargeItem() == null)
			throw new RuntimeException("Invalid two four tree");
		blackNode.setElement(twoFourNode.getMiddleItem());
		RBNode redNode = new RBNode(blackNode, twoFourNode.getSmallItem(), true);
		blackNode.setLeft(redNode);
		RBNode subBlackNode = new RBNode(redNode, null, false);
		redNode.setLeft(subBlackNode);
		processNode(twoFourNode.getLeft(), subBlackNode);
		subBlackNode = new RBNode(redNode, null, false);
		redNode.setRight(subBlackNode);
		processNode(twoFourNode.getLeftMiddle(), subBlackNode);
		redNode = new RBNode(blackNode, twoFourNode.getLargeItem(), true);
		blackNode.setRight(redNode);
		subBlackNode = new RBNode(redNode, null, false);
		redNode.setLeft(subBlackNode);
		processNode(twoFourNode.getRightMiddle(), subBlackNode);
		subBlackNode = new RBNode(redNode, null, false);
		redNode.setRight(subBlackNode);
		processNode(twoFourNode.getRight(), subBlackNode);
	}
  }

  // all methods below are provided for your use.
  // you can add methods, but do not change any of the given methods

  public boolean isEmpty() { return (size == 0);  } 
  public int size() { return size;  } 

  public boolean isRoot(FourNode<E> v) { return (v == root());  }
  public FourNode<E> root() {  // returns the root of the tree
    if (root == null) throw new RuntimeException("The tree is empty");
    return root;
  } 
  public FourNode<E> left(FourNode<E> v) { 
    FourNode<E> pos = v.getLeft();
    if (pos == null) throw new RuntimeException("No left child");
    return pos;
  }
  public FourNode<E> leftMiddle(FourNode<E> v) { 
    FourNode<E> pos = v.getLeftMiddle();
    if (pos == null) throw new RuntimeException("No left child");
    return pos;
  }
  /** Returns the right child of a node. */
  public FourNode<E> rightMiddle(FourNode<E> v) { 
    FourNode<E> pos = v.getRightMiddle();
    if (pos == null) throw new RuntimeException("No right child");
    return pos;
  }
  /** Returns the right child of a node. */
  public FourNode<E> right(FourNode<E> v) { 
    FourNode<E> pos = v.getRight();
    if (pos == null) throw new RuntimeException("No right child");
    return pos;
  }
  /** Returns the parent of a node. */
  public FourNode<E> parent(FourNode<E> v) { 
    FourNode<E> pos = v.getParent();
    if (pos == null) throw new RuntimeException("No parent");
    return pos; 
  }

  public FourNode<E> createNode(E element, FourNode<E> parent, 
      FourNode<E> left, FourNode<E> leftMiddle,
      FourNode<E> rightMiddle, FourNode<E> right) {
    return new MyFourNode<E>(element,parent,left,leftMiddle,rightMiddle,right); }

  public FourNode<E> addRoot(E e) {
    if(!isEmpty()) throw new RuntimeException("Tree already has a root");
    size = 1;
    root = createNode(e,null,null,null,null,null);
    return root;
  }
}
