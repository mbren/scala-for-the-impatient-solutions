import Ch13_Collections._
import org.scalatest.{FunSpec, Matchers}

class Ch13_CollectionsSpec extends FunSpec with Matchers {

    describe("Question 0a") {
      it("Sort a Vector") {
        assert(sortAsc(Vector(3.0, 1.0, 2.2, -3.33)) === Vector(-3.33, 1.0, 2.2, 3.0))
      }
    }
    describe("Question 0b") {
      it("Take first 3 elements from front of list") {
        assert(take3(List(3, 1, 2, -3)) === List(3, 1, 2))
      }
    }
    describe("Question 0c") {
      it("foo is a key in the Map") {
        assert(getValForKey("foo", Map("foo" -> 3, "bar" -> 2, "baz" -> 6)) === 3)
      }
      it("foo is NOT a key in the Map") {
        assert(getValForKey("foo", Map("car" -> 3, "bar" -> 2, "baz" -> 6)) === 0)
      }
    }
    describe("Question 0d") {
      it("Keep only odd ints in the list") {
        assert(oddVals(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)) === List(1, 3, 5, 7, 9))
      }
    }
    describe("Question 0e") {
      it("Combine lists") {
        assert(combineLists(List(1, 2, 3, 4, 5, 6), List(11, 21, 31, 41, 51, 61, 71, 81, 91, 101)) === List(1, 2, 3, 4, 5, 6, 11, 21, 31, 41, 51, 61, 71, 81, 91, 101))
      }
    }
    describe("Question 0f") {
      it("Add element to list") {
        assert(addAtHead(9, List(1, 2, 3)) === List(9, 1, 2, 3))
      }
    }
    describe("Question 4") {
      it("Get vals from Map") {
        assert(getValsFromMap(Array("Tom", "Fred", "Harry"), Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5)) === Array(3, 5))
      }
    }
    describe("Question 5") {
      it("Do mkString from arbitrary collection") {
        assert(mkStringNew(List(2, 3, 4)) === "234")
        assert(mkStringNew(", ", Array(5, 6)) === "5, 6")
        assert(mkStringNew("[[", ", ", "]]", Vector(1, 2)) === "[[1, 2]]")
        assert(mkStringNew(List("i", "am", "here")) === "iamhere")
      }
    }
    describe("Question 10") {
      it("Par Map") {
        val str: String = "scala always"
        assert(getFrequencies(str) === Map('w' -> 1, ' ' -> 1, 's' -> 2, 'y' -> 1, 'a' -> 4, 'c' -> 1, 'l' -> 2))
      }
    }
  }