
/**
  * Created by stevenshao on 21/03/2017.
  */
object MainApp {
  def main(args: Array[String]): Unit = {
    val myBiTree = BiTree[Int](EmptyBiTree,BiTree(EmptyBiTree,EmptyBiTree,45),75)
    myBiTree.traverseTreeInOrder(x=>print(s"${x} "))
  }

}
