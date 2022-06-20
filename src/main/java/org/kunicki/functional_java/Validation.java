package org.kunicki.functional_java;

import io.vavr.collection.Seq;
import io.vavr.control.Either;
import io.vavr.control.Validation;

import java.util.List;

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

    private Validation<String, String> validateName(String name) {
        return isNameValid(name) ? Validation.valid(name) : Validation.invalid("Invalid name");
    }

    private Validation<String, Integer> validateAge(int age) {
        return isAgeValid(age) ? Validation.valid(age) : Validation.invalid("Invalid age");
    }

    public Either<List<String>, Person> validate(String name, int age) {
        return Validation.combine(validateName(name), validateAge(age))
            .ap(Person::new)
            .mapError(Seq::asJava)
            .toEither();
    }
}
