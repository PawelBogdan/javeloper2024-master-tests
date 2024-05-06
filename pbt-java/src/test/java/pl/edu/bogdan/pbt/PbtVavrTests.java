package pl.edu.bogdan.pbt;

import io.vavr.CheckedFunction1;
import io.vavr.Tuple2;
import io.vavr.test.Arbitrary;
import io.vavr.test.Property;
import org.junit.jupiter.api.Test;

public class PbtVavrTests {

    @Test
    void addingShouldBeCommutative() {
        Arbitrary<Tuple2<Integer, Integer>> pairOfIntegersGenerator =
                Arbitrary
                        .list(Arbitrary.integer())
                        .map(l -> new Tuple2<>(l.get(0), l.get(1)));

        CheckedFunction1<Tuple2<Integer, Integer>, Boolean> mustEquals = tuple -> {
            int a = tuple._1;
            int b = tuple._2;
            Calculator left = new Calculator(a).add(b);
            Calculator right = new Calculator(b).add(a);
            System.out.println(a + " " + b);
            return left.getCurrentValue() == right.getCurrentValue();
        };

        Property
                .def("Adding should be always commutative")
                .forAll(pairOfIntegersGenerator)
                .suchThat(mustEquals)
                .check(10_000, 100)
                .assertIsSatisfied();
    }

    @Test
    void dividingByGreaterNumberShouldBe0() {
        Arbitrary<Tuple2<Integer, Integer>> pairOfIntegersGenerator =
                Arbitrary
                        .list(Arbitrary.integer().filter(a -> a > 0))
                        .map(l -> new Tuple2<>(l.get(0), l.get(1)))
                        .filter(t -> t._1 < t._2);

        CheckedFunction1<Tuple2<Integer, Integer>, Boolean> mustEquals = tuple -> {
            int a = tuple._1;
            int b = tuple._2;
            return new Calculator(a).div(b).getCurrentValue() == 0;
        };


        Property
                .def("Integer division smaller number by greater number should give 0")
                .forAll(pairOfIntegersGenerator)
                .suchThat(mustEquals)
                .check(10_000, 100)
                .assertIsSatisfied();
    }

}
