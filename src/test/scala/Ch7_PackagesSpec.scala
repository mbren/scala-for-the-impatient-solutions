import org.scalatest.{FunSpec, Matchers}

package mymath {

  class Ch7_PackagesSpec extends FunSpec with Matchers {
    describe("Test the random package") {
      random.setSeed(2)
    }
    it("nextInt()") {
      assert(random.nextInt() !== 0)
    }

    it("nextDouble()") {
      assert(random.nextDouble() !== 0)
    }
  }

}