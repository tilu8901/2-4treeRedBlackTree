public interface FourNode<E> {
  public int getNumberOfChildren();
  public void setNumberOfChildren(int k);
  public E getSmallItem();
  public E getMiddleItem();
  public E getLargeItem();
  public void setSmallItem(E e);
  public void setMiddleItem(E e);
  public void setLargeItem(E e);
  public FourNode<E> getLeft();
  public FourNode<E> getLeftMiddle();
  public FourNode<E> getRightMiddle();
  public FourNode<E> getRight();
  public FourNode<E> getParent();
  public void setLeft(FourNode<E> v);
  public void setLeftMiddle(FourNode<E> v);
  public void setRightMiddle(FourNode<E> v);
  public void setRight(FourNode<E> v);
  public void setParent(FourNode<E> v);
}
