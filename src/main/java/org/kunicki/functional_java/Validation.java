package org.kunicki.functional_java;

import io.vavr.control.Either;

record Person(String name, int age) {
}

interface PersonValidator {

    //region Common validation logic
    default boolean isNameValid(String name) {
        return name.startsWith("M");
    }

    default boolean isAgeValid(int age) {
        return age == 38;
    }
    //endregion
}

class FailingFast implements PersonValidator {

    private Either<String, String> validateName(String name) {
        return isNameValid(name) ? Either.right(name) : Either.left("Invalid name");
    }

    private Either<String, Integer> validateAge(int age) {
        return isAgeValid(age) ? Either.right(age) : Either.left("Invalid age");
    }

    public Either<String, Person> validate(String name, int age) {
        return validateName(name).flatMap(n ->
            validateAge(age).map(a ->
                new Person(n, a)
            )
        );
    }
}

class Accumulating implements PersonValidator {

}
