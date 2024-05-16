package org.kunicki.functional_java;

import io.vavr.Value;
import io.vavr.collection.List;
import io.vavr.control.Either;
import io.vavr.control.Validation;

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
        // (valid name, valid age) -> Person
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

    private Validation<String, Integer> validateAge(Integer age) {
        return isAgeValid(age) ? Validation.valid(age) : Validation.invalid("Invalid age");
    }

    public Either<List<String>, Person> validate(String name, int age) {
        // (valid name, valid age) -> Person
        final var combined = validateName(name).combine(validateAge(age));
        final var validatedPerson = combined.ap(Person::new);

        // optionally convert errors to java.util.List and Validation to Either
        return validatedPerson.mapError(Value::toList).toEither();
    }
}
