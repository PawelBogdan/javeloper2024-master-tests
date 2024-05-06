package pl.edu.bogdan.pbt

import org.junit.runner.RunWith
import org.scalacheck.Gen
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.junit.JUnitRunner
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks

@RunWith(classOf[JUnitRunner])
class PbtExample
    extends AnyWordSpec
    with ScalaCheckDrivenPropertyChecks
    with Matchers {

  "For Calculator" should {
    "adding should be commutative" in {
      forAll { (a: Int, b: Int) =>
        {
          val left = new Calculator(a).add(b).getCurrentValue
          val right = new Calculator(b).add(a).getCurrentValue
          left == right
        }
      }
    }

    val positiveInteger: Gen[Int] = Gen.choose(1, 1000000)
    val pairOfPositiveIntegers: Gen[(Int, Int)] =
      Gen.zip(positiveInteger, positiveInteger)

    "dividing by greater should give 0" in {
      forAll(pairOfPositiveIntegers suchThat (a => a._1 < a._2)) {
        (a: (Int, Int)) =>
          new Calculator(a._1).div(a._2).getCurrentValue == 0
      }
    }
  }
}
