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