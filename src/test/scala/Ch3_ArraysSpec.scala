import Ch3_Arrays._
import org.scalatest.{Matchers, FunSpec}

class Ch3_ArraysSpec extends FunSpec with Matchers {
  describe("q 7") {
    it("Find uniques") {
      assert(uniqueVals(Array(1, 2, 3, 1, 3, 5)) === Array(1, 2, 3, 5))
    }
  }
  describe("q 9") {
    it("Find US timezones") {
      assert(
        getAmericanTimeZones() !== ""
      )
    }
  }
}
