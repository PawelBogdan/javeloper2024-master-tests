package pl.edu.bogdan.pbt

import org.junit.runner.RunWith
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CalculatorSuite extends AnyWordSpec with Matchers {

  "Calculator" should {
    "add correctly" in {
      val c = new Calculator(0)
      c.add(1).add(2).getCurrentValue shouldBe 3
    }
  }
}
