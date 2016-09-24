object Ch14_PatternMatching {

  //Q5
  // One can use lists to model trees that store values only in the leaves. For example, the list <List(List(3, 8) 2 List(5))> describes the tree.
  // However, some of the list elements are numbers and others are lists. In Scala, you cannot have heterogeneous lists, so you have to use a <List[Any]>.
  // Write a <leafSum> function to compute the sum of all elements in the leaves, using pattern matching to differentiate between numbers and lists.
  class Question5 {

    def leafSum(myList: List[Any]): Int = {
      myList.foldLeft(0) {
        case (acc, leaf: Int) => acc + leaf
        case (acc, node: List[Any]) => acc + leafSum(node)
      }
    }
  }

  //Q6
  // A better way of modeling such trees is with case classes. Let's start with binary trees.
  //Write a function to compute the sum of all elements in the leaves.
  class Question6 {

    sealed abstract class BinaryTree

    case class Leaf(value: Int) extends BinaryTree

    case class Node(left: BinaryTree, right: BinaryTree) extends BinaryTree

    object BinaryTree {
      def leafSum(t: BinaryTree): Int = t match {
        case Leaf(num) => num // for a leaf just return the value
        case Node(l, r) => leafSum(l) + leafSum(r)
      }
    }

  }

  //Q7
  // Extend the tree in the preceding exercise so that each node can have an arbitrary number of children, and reimplement the <leafSum> function.
  // The tree in exercise 5 should be expressible as:
  // (Node(Node(Leaf(3), Leaf(8)), Leaf(2), Node(Leaf(5)))
  class Question7 {

    sealed abstract class BinaryTree

    case class Leaf(value: Int) extends BinaryTree

    case class Node(n: BinaryTree*) extends BinaryTree

    //the Node can have a variable number of arguments. Each node can have k child nodes.
    object BinaryTree {
      def leafSum(t: BinaryTree): Int = t match {
        case Leaf(num) => num // for a leaf just return the value
        case Node(children@_*) => children.map(leafSum(_)).sum
      }
    }

  }

  //Q8
  // Extend the tree in the preceding exercise so that each nonleaf node stores an operator in addition to the child nodes.
  // Then write a function <eval> that computes the value. For example, the tree (see image below) have value (3 x 8) + 2 + (-5) = 21.
  class Question8 {

    sealed abstract class BinaryTree

    case class Leaf(value: Int) extends BinaryTree

    case class Node(operator: String, n: BinaryTree*) extends BinaryTree

    object BinaryTree {
      def eval(t: BinaryTree): Int = t match {
        case Leaf(num) => num
        case Node("*", children@_*) => children.foldLeft(1)(_ * eval(_)) //"zero" value for multiplication and division is 1
        case Node("/", children@_*) => children.foldLeft(1)(_ / eval(_))
        case Node("+", children@_*) => children.foldLeft(0)(_ + eval(_)) //"zero" value for addition and subtraction is 0
        case Node("-", children@_*) => children.foldLeft(0)(_ - eval(_))
        case _ => 0 //operator is not defined
      }
    }

  }

  //Q9
  //Write a function that computes the sum of the non-<None> values in a <List[Option[Int]]>. Don't use the <match> statement.
  def computeSum(list: List[Option[Int]]): Int = list.flatten.sum

  //Q10
  //Write a function that composes two functions of type <Double => Option[Double]>, yielding another function of the same type. The composition should yield <None> if either
  // function does. For example,
  //def f(x: Double) = if (x >= 0) Some(sqrt(x)) else None
  //def g(x: Double) = if (x != 1) Some(1 / (x-1)) else None
  //val h = compose(f, g)
  //Then h(2) is Some(1), and h(1) and h(0) are None.
  //NOTE : Recall from math class that function composition is applied right to left, so h(x) = f(g(x)) (i.e. the rightmost function is applied first and the output passed into
  // the method on the left).  For example, h(0) = f(g(0)) = f(-1) = None
  //See Scala API "Option" doc at http://www.scala-lang.org/api/2.11.8/#scala.Option
  //  flatMap[B](f: (A) ⇒ Option[B]): Option[B]
  //  Returns the result of applying f to this scala.Option's value if this scala.Option is nonempty.
  //  Returns None if this scala.Option is empty.
  //  Slightly different from map in that f is expected to return a scala.Option (which could be None).
  def compose(f: Double => Option[Double], g: Double => Option[Double]): Double => Option[Double] = {
    x => g(x).flatMap(f(_))
  }

}
