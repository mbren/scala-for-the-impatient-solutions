import org.scalatest.{FunSpec, Matchers}
import Ch14_PatternMatching._

class Ch14_PatternMatchingSpec extends FunSpec with Matchers {

  describe("PatternMatching question 5") {
    it("find sum of tree") {
      val q5 = new Question5
      assert(q5.leafSum(List(List(3, 8), 2, List(5))) === 18)
    }
  }

  describe("PatternMatching question 6") {
    it("Find sum of binary tree") {
      val q6: Question6 = new Question6
      assert(q6.BinaryTree.leafSum(q6.Node(q6.Node(q6.Leaf(3), q6.Leaf(8)), q6.Leaf(2))) === 13)
    }
  }
  describe("PatternMatching question 7") {
    it("Find sum when each node can have an arbitrary number of children") {
      val q7: Question7 = new Question7
      assert(q7.BinaryTree.leafSum(q7.Node(q7.Node(q7.Leaf(3), q7.Leaf(8)), q7.Leaf(2), q7.Node(q7.Leaf(5)))) === 18)
      assert(q7.BinaryTree.leafSum(q7.Leaf(2)) === 2)
      assert(q7.BinaryTree.leafSum(q7.Node(q7.Leaf(3), q7.Leaf(8))) === 11)
    }
  }
  describe("PatternMatching question 8") {
    it("evaluate trees that contain operators") {
      val q8: Question8 = new Question8
      assert(q8.BinaryTree.eval(q8.Leaf(2)) === 2)
      assert(q8.BinaryTree.eval(q8.Node("+", q8.Leaf(3), q8.Leaf(8))) === 11)
      //(3 x 8) + 2 + (-5) = 21
      assert(q8.BinaryTree.eval(q8.Node("+", q8.Node("*", q8.Leaf(3), q8.Leaf(8)), q8.Leaf(2), q8.Node("-", q8.Leaf(5)))) === 21)
    }
  }
  describe("PatternMatching question 9") {
    it("Find sum of option list") {
      //val mylist: List[Option[Int]]= List(Some(1), None, Some(3))
      assert(computeSum(List(Some(1), None, Some(3))) === 4)
    }
  }
  describe("PatternMatching question 10") {
    it("compose two functions") {
      def f(x: Double) = if (x >= 0) Some(scala.math.sqrt(x)) else None
      def g(x: Double) = if (x != 1) Some(1 / (x - 1)) else None
      val h = compose(f, g)
      assert(h(2) === Some(1))
      assert(h(1) === None)
      assert(h(0) === None)
    }
  }

}
