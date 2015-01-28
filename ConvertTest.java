import junit.framework.TestCase;

public class ConvertTest extends TestCase {
  protected MyRedBlackTree<MyEntry<Integer, String>> rb1;
  protected MyRedBlackTree<MyEntry<Integer, String>> rb2;
  protected MyRedBlackTree<MyEntry<Integer, String>> rb3;
  protected MyRedBlackTree<MyEntry<Integer, String>> rb4;
  protected MyRedBlackTree<MyEntry<Integer, String>> rb5;
  protected MyRedBlackTree<MyEntry<Integer, String>> rb6;

  protected MyTwoFourTree<MyEntry<Integer, String>> tf1;
  protected MyTwoFourTree<MyEntry<Integer, String>> tf2;
  protected MyTwoFourTree<MyEntry<Integer, String>> tf3;
  protected MyTwoFourTree<MyEntry<Integer, String>> tf4;
  protected MyTwoFourTree<MyEntry<Integer, String>> tf5;
  protected MyTwoFourTree<MyEntry<Integer, String>> tf6;

  protected MyEntry<Integer, String> makeEntry(Integer i, String s) {
    return new MyEntry<Integer, String>(i, s);
  }

  protected boolean entryCompare(MyEntry<Integer, String> e1, MyEntry<Integer, String> e2){
    if(e1 == null && e2 == null)
      return true;
    return e1.getKey().equals(e2.getKey()) && e1.getValue().equals(e2.getValue());
  }

  protected FourNode<MyEntry<Integer, String>> makeTFNode(MyTwoFourTree<MyEntry<Integer, String>> tf,
                            MyEntry<Integer, String> e, 
                            FourNode<MyEntry<Integer, String>> parent) {

    FourNode<MyEntry<Integer, String>> fN = tf.createNode(e, null, null, null, null, null);
    fN.setParent(parent);
    fN.setLeft(null);
    fN.setLeftMiddle(null);
    fN.setRightMiddle(null);
    fN.setRight(null);
    
    return fN;
  }

  protected FourNode<MyEntry<Integer, String>> makeSmallTFNode(MyTwoFourTree<MyEntry<Integer, String>> tf,
                            MyEntry<Integer, String> e, 
                            FourNode<MyEntry<Integer, String>> parent) {

    FourNode<MyEntry<Integer, String>> fN = makeTFNode(tf, e, parent);
    fN.setSmallItem(e);
    fN.setNumberOfChildren(2);
    
    return fN;
  }

  protected FourNode<MyEntry<Integer, String>> makeMiddleTFNode(MyTwoFourTree<MyEntry<Integer, String>> tf,
                            MyEntry<Integer, String> e1, 
                            MyEntry<Integer, String> e2, 
                            FourNode<MyEntry<Integer, String>> parent) {

    FourNode<MyEntry<Integer, String>> fN = makeTFNode(tf, e1, parent);
    fN.setSmallItem(e1);
    fN.setMiddleItem(e2);
    fN.setNumberOfChildren(3);
    
    return fN;
  }

  protected FourNode<MyEntry<Integer, String>> makeLargeTFNode(MyTwoFourTree<MyEntry<Integer, String>> tf,
                            MyEntry<Integer, String> e1, 
                            MyEntry<Integer, String> e2, 
                            MyEntry<Integer, String> e3, 
                            FourNode<MyEntry<Integer, String>> parent) {

    FourNode<MyEntry<Integer, String>> fN = makeTFNode(tf, e1, parent);
    fN.setSmallItem(e1);
    fN.setMiddleItem(e2);
    fN.setLargeItem(e3);
    fN.setNumberOfChildren(4);
    
    return fN;
  }

  protected boolean checkTF(MyTwoFourTree<MyEntry<Integer, String>> tree1, MyTwoFourTree<MyEntry<Integer, String>> tree2){
    try {
      return checkTFNodes(tree1.root(), tree2.root());
    }
    catch (Exception e) {
      return false;
    }
  }

  protected boolean checkTFNodes(FourNode<MyEntry<Integer, String>> fN1, FourNode<MyEntry<Integer, String>> fN2) {
    try {
      if(fN1 == null && fN2 == null)
        return true;
      if(entryCompare(fN1.getSmallItem(), fN2.getSmallItem()) && 
          entryCompare(fN1.getMiddleItem(), fN2.getMiddleItem()) && 
          entryCompare(fN1.getLargeItem(), fN2.getLargeItem())){
        return (checkTFNodes(fN1.getLeft(), fN2.getLeft()) &&
                checkTFNodes(fN1.getLeftMiddle(), fN2.getLeftMiddle()) &&
                checkTFNodes(fN1.getRightMiddle(), fN2.getRightMiddle()) &&
                checkTFNodes(fN1.getRight(), fN2.getRight()));
      }
      return false;
    }
    catch (Exception e) {
      return false;
    }
  }

  protected void makeRB1() {
    // no element red black tree
    rb1 = new MyRedBlackTree<MyEntry<Integer, String>>();
  }

  protected void makeTF1() {
    // no element 2,4 tree
    tf1 = new MyTwoFourTree<MyEntry<Integer, String>>();
  }

  protected boolean checkTF1(MyTwoFourTree<MyEntry<Integer, String>> tree) {
    try {
      FourNode<MyEntry<Integer, String>> root = tree.root();
      if (root.getSmallItem() == null && root.getMiddleItem() == null &&
          root.getLargeItem() == null && root.getParent() == null &&
          root.getLeft() == null && root.getLeftMiddle() == null &&
          root.getRightMiddle() == null && root.getRight() == null)
        return true;
      return false;
    }
    catch(Exception e) {
      return true;
    }
  }

  protected void makeRB2() {
    // one element red black tree
    rb2 = new MyRedBlackTree<MyEntry<Integer, String>>();
    rb2.addRoot(new MyEntry<Integer, String>(1, "One"));
    rb2.root().makeBlack();
  }

  protected void makeTF2() {
    // one element 2,4 tree
    tf2 = new MyTwoFourTree<MyEntry<Integer, String>>();
    MyEntry<Integer, String> e = new MyEntry<Integer, String>(1, "One");
    tf2.addRoot(e);
    tf2.root().setSmallItem(e);
    tf2.root().setNumberOfChildren(2);
  }

  protected boolean checkTF2(MyTwoFourTree<MyEntry<Integer, String>> tree) {
    try {
      FourNode<MyEntry<Integer, String>> root = tree.root();
      if (entryCompare(root.getSmallItem(),rb2.root().element()) && 
          root.getParent() == null && root.getLeft() == null && 
          root.getLeftMiddle() == null && root.getRightMiddle() == null && 
          root.getRight() == null)
        return true;
      return false;
    }
    catch(Exception e) {
      return false;
    }
  }

  protected void makeRB3() {
    // two element red black tree
    rb3 = new MyRedBlackTree<MyEntry<Integer, String>>();
    rb3.addRoot(new MyEntry<Integer, String>(3, "Three"));
    rb3.root().setLeft(rb3.createNode(makeEntry(1, "One"), rb3.root(), null,null));
    rb3.root().makeBlack();
  }

  protected void makeTF3() {
    // two element 2,4 tree
    tf3 = new MyTwoFourTree<MyEntry<Integer, String>>();
    MyEntry<Integer, String> e1 = new MyEntry<Integer, String>(1, "One");
    MyEntry<Integer, String> e2 = new MyEntry<Integer, String>(3, "Three");
    tf3.addRoot(e1);
    tf3.root().setSmallItem(e1);
    tf3.root().setMiddleItem(e2);
    tf3.root().setNumberOfChildren(3);
  }

  protected void makeRB4() {
    // very simple red-black tree with 3 entries
    rb4 = new MyRedBlackTree<MyEntry<Integer, String>>();
    rb4.addRoot(new MyEntry<Integer, String>(5, "Five"));
    rb4.root().makeBlack();
    rb4.root().setLeft(rb4.createNode(makeEntry(1, "One"), rb4.root(), null,null));
    rb4.root().setRight(rb4.createNode(makeEntry(10, "Ten"), rb4.root(), null,null));
  }

  protected void makeTF4() {
    // very simple 2,4 tree with fournode
    tf4 = new MyTwoFourTree<MyEntry<Integer, String>>();
    MyEntry<Integer, String> small = new MyEntry<Integer, String>(1, "One");
    MyEntry<Integer, String> mid = new MyEntry<Integer, String>(5, "Five");
    MyEntry<Integer, String> large = new MyEntry<Integer, String>(10, "Ten");
    tf4.addRoot(small);
    tf4.root().setSmallItem(small);
    tf4.root().setMiddleItem(mid);
    tf4.root().setLargeItem(large);
    tf4.root().setNumberOfChildren(4);
  }

  protected void makeRB5() {
    // more complex red black tree
    rb5 = new MyRedBlackTree<MyEntry<Integer, String>>();
    rb5.addRoot(new MyEntry<Integer, String>(20, "Twenty"));

    RBNode<MyEntry<Integer, String>> current = rb5.root();
    current.makeBlack();
    current.setLeft(rb5.createNode(makeEntry(15, "Fifteen"), current, null, null));
    current.setRight(rb5.createNode(makeEntry(34, "Thirty Four"), current, null,null));

    current = rb5.root().getLeft();
    current.setLeft(rb5.createNode(makeEntry(3, "Three"), current, null, null));
    current.getLeft().makeBlack();
    current.setRight(rb5.createNode(makeEntry(16, "Sixteen"), current, null, null));
    current.getRight().makeBlack();

    current = rb5.root().getRight();
    current.setLeft(rb5.createNode(makeEntry(25, "Twenty Five"), current, null, null));
    current.getLeft().makeBlack();
    current.setRight(rb5.createNode(makeEntry(50, "Fifty"), current, null, null));
    current.getRight().makeBlack();

    current = rb5.root().getRight().getLeft();
    current.setRight(rb5.createNode(makeEntry(27, "Twenty Seven"), current, null, null));
  }

  protected void makeTF5() {
    tf5 = new MyTwoFourTree<MyEntry<Integer, String>>();
    MyEntry<Integer, String> e = makeEntry(15, "Fifteen");
    tf5.addRoot(e);

    FourNode<MyEntry<Integer, String>> current = tf5.root();
    current.setSmallItem(e);
    current.setMiddleItem(makeEntry(20, "Twenty"));
    current.setLargeItem(makeEntry(34, "Thirty Four"));
    current.setNumberOfChildren(4);

    current.setLeft(makeSmallTFNode(tf5, makeEntry(3, "Three"), current));
    current.setLeftMiddle(makeSmallTFNode(tf5, makeEntry(16, "Sixteen"), current));
    current.setRightMiddle(makeMiddleTFNode(tf5, makeEntry(25, "Twenty Five"), makeEntry(27, "Twenty Seven"), current));
    current.setRight(makeSmallTFNode(tf5, makeEntry(50, "Fifty"), current));
  }

  protected void makeRB6() {
    // more complex red black tree
    rb6 = new MyRedBlackTree<MyEntry<Integer, String>>();
    rb6.addRoot(new MyEntry<Integer, String>(13, "Thirteen"));

    RBNode<MyEntry<Integer, String>> current = rb6.root();
    current.makeBlack();
    current.setLeft(rb6.createNode(makeEntry(8, "Eight"), current, null, null));
    current.setRight(rb6.createNode(makeEntry(17, "Seventeen"), current, null,null));

    current = rb6.root().getLeft();
    current.setLeft(rb6.createNode(makeEntry(1, "One"), current, null, null));
    current.getLeft().makeBlack();
    current.setRight(rb6.createNode(makeEntry(11, "Eleven"), current, null, null));
    current.getRight().makeBlack();

    current = rb6.root().getLeft().getLeft();
    current.setRight(rb6.createNode(makeEntry(6, "Six"), current, null, null));

    current = rb6.root().getRight();
    current.setLeft(rb6.createNode(makeEntry(15, "Fifteen"), current, null, null));
    current.getLeft().makeBlack();
    current.setRight(rb6.createNode(makeEntry(25, "Twenty Five"), current, null, null));
    current.getRight().makeBlack();

    current = rb6.root().getRight().getRight();
    current.setLeft(rb6.createNode(makeEntry(22, "Twenty Two"), current, null, null));
    current.setRight(rb6.createNode(makeEntry(27, "Twenty Seven"), current, null, null));

  }

  protected void makeTF6() {
    tf6 = new MyTwoFourTree<MyEntry<Integer, String>>();
    MyEntry<Integer, String> e = makeEntry(8, "Eight");
    tf6.addRoot(e);

    FourNode<MyEntry<Integer, String>> current = tf6.root();
    current.setSmallItem(e);
    current.setMiddleItem(makeEntry(13, "Thirteen"));
    current.setLargeItem(makeEntry(17, "Seventeen"));
    current.setNumberOfChildren(4);

    current.setLeft(makeMiddleTFNode(tf6, makeEntry(1, "One"), makeEntry(6, "Six"), current));
    current.setLeftMiddle(makeSmallTFNode(tf6, makeEntry(11, "Eleven"), current));
    current.setRightMiddle(makeSmallTFNode(tf6, makeEntry(15, "Fifteen"), current));
    current.setRight(makeLargeTFNode(tf6, makeEntry(22, "Twenty Two"), makeEntry(25, "Twenty Five"), makeEntry(27, "Twenty Seven"), current));
  }

  public void test01() {
    // testing a no-element tree, RB -> 2,4
    makeRB1();
    assertTrue(checkTF1(rb1.convertTo24()));
  }

  public void test02() {
    // testing a no-element tree, 2,4 -> RB -> 2,4
    // red black conversion is tested by converting one way, then back
    // this is because every 3-node doubles the number of possible RB trees
    // it also means that the 2,4->RB->2,4 tests will fail unless BOTH
    // convertToRB and convertTo24 work correctly
    makeRB1();
    makeTF1();
    assertTrue(checkTF1(tf1.convertToRB().convertTo24()));
  }

  public void test03() {
    // testing a one-element tree, RB -> 2,4
    makeRB2();
    assertTrue(checkTF2(rb2.convertTo24()));
  }

  public void test04() {
    // testing a one-element tree, 2,4 -> RB -> 2,4
    makeRB2();
    makeTF2();
    assertTrue(checkTF2(tf2.convertToRB().convertTo24()));
  }

  public void test05() {
    // testing a two element tree, RB -> 2,4
    makeRB3();
    makeTF3();
    assertTrue(checkTF(rb3.convertTo24(), tf3));
  }

  public void test06() {
    // testing a two element tree, 2,4 -> RB -> 2,4
    makeRB3();
    makeTF3();
    assertTrue(checkTF(tf3.convertToRB().convertTo24(), tf3));
  }

  public void test07() {
    // testing a three element tree, RB -> 2,4
    makeRB4();
    makeTF4();
    assertTrue(checkTF(rb4.convertTo24(), tf4));
  }

  public void test08() {
    // testing a three element tree, 2,4 -> RB -> 2,4
    makeRB4();
    makeTF4();
    assertTrue(checkTF(tf4.convertToRB().convertTo24(), tf4));
  }

  public void test09() {
    // testing a larger tree, RB -> 2,4
    makeRB5();
    makeTF5();
    assertTrue(checkTF(rb5.convertTo24(), tf5));
  }

  public void test10() {
    // testing a larger tree, 2,4 -> RB -> 2,4
    makeRB5();
    makeTF5();
    assertTrue(checkTF(tf5.convertToRB().convertTo24(), tf5));
  }

  public void test11() {
    //testing another large tree, RB -> 2,4
    makeRB6();
    makeTF6();
    assertTrue(checkTF(rb6.convertTo24(), tf6));
  }

  public void test12() {
    //testing another large tree, 2,4 -> RB -> 2,4
    makeRB6();
    makeTF6();
    assertTrue(checkTF(tf6.convertToRB().convertTo24(), tf6));
  }


}
