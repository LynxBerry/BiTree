/**
  * Created by stevenshao on 21/03/2017.
  */
abstract class BiTree[+A] { // It is a type.
  def traverseTreeInOrder(action:(A)=>Unit): Unit = {
    def traverse(tree: BiTree[A]):Unit = tree match {
      case EmptyBiTree => //do nothing
      case n: BiTreeNode[A] => {
        traverse(n.left)
        action(n.data)
        traverse(n.right)
      }
    }
    traverse(this)

  }


}


object BiTree { //Companion Object
  //def emptyNode[A] = new EmptyBiTree[A]()
  def apply[A](left: BiTree[A], right: BiTree[A], data: A): BiTree[A] = BiTreeNode[A](left, right, data) // generate one node tree


}