import org.scalatest._

class Ch2_ControlStructuresSpec extends FunSpec with Matchers {
  val controlStruct = new Ch2_ControlStructures

  describe("Question 6 tests") {
    it("Hello returns 9415087488") {
      assert(controlStruct.prodOfCodes("Hello") === 9415087488L)
    }
  }

  describe("Question 7 tests") {
    it("Hello returns 9415087488") {
      assert(controlStruct.prodOfCodes2("Hello") === 9415087488L)
    }
    it("empty string returns 1") {
      assert(controlStruct.prodOfCodes2("") === 1)
    }
    it("ampersand symbol returns 38") {
      assert(controlStruct.prodOfCodes2("&") === 38)
    }
    it("0 returns 48") {
      assert(controlStruct.prodOfCodes2("0") === 48)
    }
    it("é returns 233") {
      assert(controlStruct.prodOfCodes2("é") === 233)
    }
    // http://unicode.org/cgi-bin/GetUnihanData.pl?codepoint=4eba
    it("人 returns 20154") {
      assert(controlStruct.prodOfCodes2("人") === 20154)
    }
    //出口 is 450674350  (出 is 20986  口 is 21475)
    it("出口 returns 450674350") {
      assert(controlStruct.prodOfCodes2("出口") === 450674350)
    }
  }

  describe("*****Question 8 tests") {
    it("Hello returns 9415087488") {
      assert(controlStruct.productOld("Hello") === 9415087488L)
    }
    it("ampersand symbol returns 38") {
      assert(controlStruct.productOld("&") === 38)
    }
    it("0 returns 48") {
      assert(controlStruct.productOld("0") === 48)
    }
    it("é returns 233") {
      assert(controlStruct.productOld("é") === 233)
    }
    // http://unicode.org/cgi-bin/GetUnihanData.pl?codepoint=4eba
    it("人 returns 20154") {
      assert(controlStruct.productOld("人") === 20154)
    }
    //出口 is 450674350  (出 is 20986  口 is 21475)
    it("出口 returns 450674350") {
      assert(controlStruct.productOld("出口") === 450674350)
    }
  }

  describe("*****Question 9 tests") {
    it("Hello returns 9415087488") {
      assert(controlStruct.product("Hello") === 9415087488L)
    }
    it("ampersand symbol returns 38") {
      assert(controlStruct.product("&") === 38)
    }
    it("0 returns 48") {
      assert(controlStruct.product("0") === 48)
    }
    it("é returns 233") {
      assert(controlStruct.product("é") === 233)
    }
    // http://unicode.org/cgi-bin/GetUnihanData.pl?codepoint=4eba
    it("人 returns 20154") {
      assert(controlStruct.product("人") === 20154)
    }
    //出口 is 450674350  (出 is 20986  口 is 21475)
    it("出口 returns 450674350") {
      assert(controlStruct.product("出口") === 450674350)
    }
  }

  describe("*****Question 10 tests") {
    it("computeRec(1, 0) === 1") {
      assert(controlStruct.computeRec(1, 0) === 1)
    }
    it("computeRec(1, 1) === 1") {
      assert(controlStruct.computeRec(1, 1) === 1)
    }
    it("computeRec(1, 2) === 1") {
      assert(controlStruct.computeRec(1, 2) === 1)
    }
    it("computeRec(1, 3) === 1") {
      assert(controlStruct.computeRec(1, 3) === 1)
    }
    it("computeRec(1, -1) === 1") {
      assert(controlStruct.computeRec(1, -1) === 1)
    }
    it("computeRec(1, -2) === 1") {assert(controlStruct.computeRec(1, -2) === 1)}
    it("computeRec(2, 0) === 1") {assert(controlStruct.computeRec(2, 0) === 1)}
    it("computeRec(2, 1) === 2") {assert(controlStruct.computeRec(2, 1) === 2)}
    it("computeRec(2, 2) === 4") {assert(controlStruct.computeRec(2, 2) === 4)}
    it("computeRec(2, 3) === 8") {assert(controlStruct.computeRec(2, 3) === 8)}
    it("computeRec(2, -1) === 0.5") {assert(controlStruct.computeRec(2, -1) === 0.5)}
    it("computeRec(2, -3) === 0.125") {assert(controlStruct.computeRec(2, -3) === 0.125)}
    it("computeRec(3, 1) === 3") {assert(controlStruct.computeRec(3, 1) === 3)}
    it("computeRec(3, 2) === 27") {assert(controlStruct.computeRec(3, 2) === 9)}
  }

}
