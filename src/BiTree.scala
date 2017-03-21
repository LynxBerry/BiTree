/**
  * Created by stevenshao on 21/03/2017.
  */
abstract class BiTree[+A] { // It is a type.
  def traverseTree(): Unit = BiTree.traverseNode[A](this)


}


object BiTree { //Companion Object
  //def emptyNode[A] = new EmptyBiTree[A]()
  def apply[A](left: BiTree[A], right: BiTree[A], data: A): BiTree[A] = BiTreeNode[A](left, right, data) // generate one node tree

  def traverseNode[A](biTree: BiTree[A]): Unit = sequenceAction[A].foreach(f=>f(biTree)) //type match


  // traverse order
  def action[A](node: BiTree[A]): Unit = node match {
    case EmptyBiTree => print("NIL")
    case n: BiTreeNode[A] => print(n.data)
  }

  def traverseLeft[A](biTree: BiTree[A]): Unit = biTree match {
    case EmptyBiTree => //nothing
    case n: BiTreeNode[A] => traverseNode(n.left)
  }

  def traverseRight[A](biTree: BiTree[A]): Unit = biTree match {
    case EmptyBiTree => //nothing
    case n: BiTreeNode[A] => traverseNode(n.right)
  }
  // define traverse order. Here it's middle order: left->data->right
  def sequenceAction[A]: Array[(BiTree[A]) => Unit] = Array(
    n=>print("("),
    n=>traverseLeft(n),
    n=>action(n),
    n=>traverseRight(n),
    n=>print(")"))
}