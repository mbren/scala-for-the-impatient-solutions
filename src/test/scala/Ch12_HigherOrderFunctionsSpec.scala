import Ch12_HigherOrderFunctions._
import org.scalatest.{Matchers, FunSpec}

class Ch12_HigherOrderFunctionsSpec extends FunSpec with Matchers{

  describe("Question 5") {
    it("Find the largest value of a function within a given sequence of inputs") {
      assert(largest(x => 10 * x - x * x, 1 to 10) === 25)
    }
  }

  describe("Question 6") {
    it("Find input that gives the largest value of a function within a given sequence of inputs") {
      assert(largestAt(x => 10 * x - x * x, 1 to 10) === 5)
    }
  }

  describe("Question 7") {
    val pairs = (1 to 10) zip (11 to 20)
    val mytest2 = pairs.map(adjustToPair(_ + _))
    val mytest3 = pairs.map(adjustToPair(_ * _))
    val mytest4 = adjustToPair(_ + _)((6,7))
    it("Pairs: adjustToPair(_ * _)((6,7)) is 42.") {
      assert(adjustToPair(_ * _)((6,7)) === 42)
    }
    it ("adjustToPair(_ + _)((6,7)) is 13") {
      assert(adjustToPair(_ + _)((6,7)) === 13)
    }
    it ("pairs.map(adjustToPair(_ + _)") {
      assert(pairs.map(adjustToPair(_ + _)) === Vector(12, 14, 16, 18, 20, 22, 24, 26, 28, 30))
    }
    it ("pairs.map(adjustToPair(_ * _)") {
      assert(pairs.map(adjustToPair(_ * _)) === Vector(11, 24, 39, 56, 75, 96, 119, 144, 171, 200))
    }
  }

}
