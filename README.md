# Jak można poprawić testy jednostkowe? (How to master unit tests?)

This is code used to prepare and give presentation in scope of Javeloper 2024 conference [[LINK]](https://javeloper.pl/)

# mutations

This module contains simple `Library` class with two unit tests. One can check that code coverage is 100%. However, not all execution paths are covered by tests.

## JaCoCo

I added JaCoCo plugin - it allows to generate code coverage report. To generate it, run the following command
```shell
$ ./gradlew mutations:clean mutations:test mutations:jacocoTestReport
```

Report is generated in `mutations/build/reports/jacoco/test/html` directory.

## Pitest

I also added Pitest [gradle plugin](https://gradle-pitest-plugin.solidsoft.info/). When one runs the command:
```shell
$ ./gradlew mutations:pitest
```

the mutations are generated and tests are validated on mutations. One can read more about Pitest [here](https://pitest.org/).

# pbt-scala

As property-based-testing paradigm was created for functional languages. I'd like to present this testing approach for simple Scala library. I created pretty simple `Calculator` class with simple unit tests as a starter.

## scalacheck

I added scalacheck library to create two tests using pbt approach. Thanks to `org.scalatestplus:scalacheck-1-18_2.13` all tests (regular unit tests and pbt tests) can be executed at once using the following command:
```shell
$ ./gradlew pbt-scala:clean pbt-scala:test
```

More information can be found [here](https://www.baeldung.com/scala/scalacheck).

# pbt-java

Unfortunately JUnit library doesn't support pbt out of the box. However, there are several libraries which implements this approach. As in `pbt-scala` I created simple `Calculator` class with simple unit test.

## jqwik

I added examples using `jqwik` library. One can read more about that
- [Original user guide](https://jqwik.net/docs/current/user-guide.html)
- [Baeldung](https://www.baeldung.com/java-jqwik-property-based-testing)

Thanks to changes I am introducing to `build.gradle` one can run tests using command:
```shell
$ ./gradlew pbt-java:clean pbt-java:test
```
