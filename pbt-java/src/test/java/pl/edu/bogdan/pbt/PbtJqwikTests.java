package pl.edu.bogdan.pbt;

import net.jqwik.api.*;

public class PbtJqwikTests {

    @Property
    boolean addingShouldBeCommutative(@ForAll int a, @ForAll int b) {
        Calculator left = new Calculator(a).add(b);
        Calculator right = new Calculator(b).add(a);

        return left.getCurrentValue() == right.getCurrentValue();
    }

    @Property
    boolean dividingByGreaterNumberShouldBe0(@ForAll("pairOfSmallerAndGreaterGenerator") Tuple.Tuple2<Integer, Integer> inputPair) {
        int a = inputPair.get1();
        int b = inputPair.get2();

        return new Calculator(a).div(b).getCurrentValue() == 0;
    }

    Arbitrary<Integer> integersGenerator() {
        return Arbitraries.integers().between(1, 1_000_000);
    }

    @Provide
    Arbitrary<Tuple.Tuple2<Integer, Integer>> pairOfSmallerAndGreaterGenerator() {
        return Combinators.combine(integersGenerator(), integersGenerator()).filter((a,b) -> a < b).as(Tuple::of);
    }
}
